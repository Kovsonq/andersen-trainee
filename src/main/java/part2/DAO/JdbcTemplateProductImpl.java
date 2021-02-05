package part2.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import part2.Model.Product.Food;
import part2.Model.Product.NoFood;
import part2.Model.Product.Product;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.HashMap;

public class JdbcTemplateProductImpl implements ProductDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public HashMap<Integer, Product> getAllProductFromDB() {
        String sql = "SELECT * FROM product_list ";
        HashMap<Integer, Product> allProducts = jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            HashMap<Integer, Product> results = new HashMap<>();
            while (resultSet.next()) {

                Integer productInUserBucketId = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");

                Product product;
                if (resultSet.getDate("expiredDate") == null) {
                    product = new NoFood(productName, productPrice);
                } else {
                    Date expiredDate = resultSet.getDate("expiredDate");
                    product = new Food(productName, productPrice, expiredDate);
                }

                results.put(productInUserBucketId, product);

            }
            return results;
        });
        return allProducts;
    }

    @Override
    public void addProductToProductList(String productName, double productPrice) {
        String sql = "INSERT INTO product_list (ProductName, ProductPrice) Values (?, ?)";
        jdbcTemplate.update(sql, productName, productPrice);
    }

    @Override
    public void deleteProductFromProductList(int productId) {
        String sql = "DELETE FROM product_list WHERE product_list.id=?";
        jdbcTemplate.update(sql, productId);
    }

    @Override
    public HashMap<Integer, Product> getAllProductFromBucketDB() {
        String sql = "SELECT ub.id, pl.id, pl.ProductName, pl.ProductPrice, pl.expiredDate " +
                "FROM user_bucket ub " +
                "JOIN product_list pl on ub.ProductId=pl.id ";

        HashMap<Integer, Product> bucketProducts = jdbcTemplate.query(sql, (ResultSet resultSet) -> {
            HashMap<Integer, Product> results = new HashMap<>();
            while (resultSet.next()) {

                Integer productInUserBucketId = resultSet.getInt("id");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");

                Product product;
                if (resultSet.getDate("expiredDate") == null) {
                    product = new NoFood(productName, productPrice);
                } else {
                    Date expiredDate = resultSet.getDate("expiredDate");
                    product = new Food(productName, productPrice, expiredDate);
                }

                results.put(productInUserBucketId, product);

            }
            return results;
        });
        return bucketProducts;
    }

    @Override
    public void addProductToBucketList(int productId) {
        String sql = "INSERT INTO user_bucket (productId) Values (?)";
        jdbcTemplate.update(sql, productId);
    }

    @Override
    public void deleteProductFromBucketDbList(int productInBucketId) {
        String sql = "DELETE FROM user_bucket WHERE user_bucket.id=?";
        jdbcTemplate.update(sql, productInBucketId);
    }
}
