package part2.DAO;

import part2.Product.Product;
import part2.Product.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

public interface ProductDao {

    void setDataSource(DataSource dataSource);

    HashMap<Integer, Product> getAllProductFromDB ();

    void addProductToProductList(String productName, double productPrice);


    void deleteProductFromProductList(int productId);

    HashMap<Integer, Product> getAllProductFromBucketDB();

    void addProductToBucketList(int productId);

    void deleteProductFromBucketDbList(int productInBucketId);

}
