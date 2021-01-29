package part2.Service;

import lombok.extern.slf4j.Slf4j;
import part2.Product.Product;
import part2.Product.User;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class ShopConnection {
    private final String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private final String login = "root";
    private final String password = "root";
    private static ShopConnection shopConnection;
    private Connection connection;

    private ShopConnection() {
        try {
            this.connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            log.error("Database Connection Creation Failed : " + ex.getMessage());
        }
    }


    public synchronized static ShopConnection getShopConnection() {
        if (shopConnection == null) {
            shopConnection = new ShopConnection();
        } else {
            try {
                if (shopConnection.getConnection().isClosed()) {
                    shopConnection = new ShopConnection();
                }
            } catch (SQLException exception) {
                log.error("Database Connection Closing Failed : " + exception.getMessage());
            }
        }
        return shopConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void confirmOrder(User user, Integer item, String moneyType, HashMap<User, List<Product>> bucket) {
        String sql = "INSERT INTO OrderConfirmed (UserId, UserName, ProductName, OrderPrice, OrderMoneyType) Values (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getShopConnection().getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUuid().toString());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, bucket.get(user).get(item).getName());
            preparedStatement.setDouble(4, bucket.get(user).get(item).getPrice());
            preparedStatement.setString(5, moneyType);
            preparedStatement.executeUpdate();
            System.out.println("Order confirmed and saved in DB");
        } catch (SQLException e) {
            log.error("Connection to DB failed...");
        }
    }


    public void callUserHistoryProcedure(User user) {
        String sql = "call UserHistory(?)";
        try (CallableStatement callableStatement = getShopConnection().getConnection().prepareCall(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            callableStatement.setString(1, user.getUuid().toString());
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String productName = resultSet.getString("ProductName");
                double orderPrice = resultSet.getDouble("OrderPrice");
                String orderMoneyType = resultSet.getString("OrderMoneyType");
                Date createDate = resultSet.getDate("CreateDate");
                boolean orderProcessed = resultSet.getBoolean("OrderProcessed");

                System.out.println("OrderId: " + id + "; UserName: " + userName +
                        "; ProductName: " + productName + "; OrderPrice: " + orderPrice +
                        "; OrderMoneyType: " + orderMoneyType + "; CreateDate: " + createDate +
                        "; OrderProcessed: " + orderProcessed);
            }

        } catch (SQLException exception) {
            log.error("ResultSet building failed...");
        }
    }

    public void createTriggerForAnalyticsTable() {
        String trigger ="CREATE DEFINER = root@localhost trigger OrderAnalyticsTable " +
                "    after insert " +
                "    on orderconfirmed " +
                "    for each row " +
                "BEGIN " +
                "    INSERT INTO orderconfirmedanalytics " +
                "    SET orderconfirmedanalytics.OrderId = NEW.id, " +
                "        orderconfirmedanalytics.ProductName = NEW.ProductName, " +
                "        orderconfirmedanalytics.UserId = NEW.UserID, " +
                "        orderconfirmedanalytics.OrderProcessed = false; " +
                "END; ";
        try (Statement statement = getShopConnection().getConnection().createStatement()) {
            statement.executeUpdate(trigger);
            log.info("TriggerForAnalyticsTable up");
        } catch (SQLException exception) {
            log.error("Trigger building failed...");
        }
    }

    public void createUserHistoryProcedure() {
        String procedure ="create definer = root@localhost " +
                "procedure UserHistory(IN UserId varchar(255)) comment 'no comments' " +
                "BEGIN " +
                "     select oc.id, oc.UserName, oc.ProductName, oc.OrderPrice, " +
                "oc.OrderMoneyType, oca.CreateDate, oca.OrderProcessed " +
                "    from orderconfirmed oc " +
                "    join orderconfirmedanalytics oca on oc.id = oca.OrderId " +
                "    where oc.UserId=UserId;" +
                "END; ";
        try (Statement statement = getShopConnection().getConnection().createStatement()) {
            statement.executeUpdate(procedure);
            log.info("Procedure up");
        } catch (SQLException exception) {
            log.error("Procedure building failed...");
        }
    }

    public void totalUserSpentMoney(User user) {
        String sum ="SELECT OrderMoneyType, " +
                "       SUM(OrderPrice) AS UserSum " +
                "FROM orderconfirmed oc " +
                "where UserId = (?) " +
                "group by oc.OrderMoneyType";
        try (PreparedStatement preparedStatement = getShopConnection().getConnection().prepareStatement(sum,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            preparedStatement.setString(1, user.getUuid().toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String moneyType = resultSet.getString("OrderMoneyType");
                double userSum = resultSet.getDouble("UserSum");
                System.out.println("OrderMoneyType: " + moneyType + "; UserSum: " + userSum);
            }
        } catch (SQLException exception) {
            log.error("UserSpentMoney query failed...");
        }
    }



}
