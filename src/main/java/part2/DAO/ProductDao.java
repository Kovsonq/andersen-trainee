package part2.DAO;

import part2.Model.Product.Product;

import javax.sql.DataSource;
import java.util.HashMap;

public interface ProductDao {

    void setDataSource(DataSource dataSource);

    HashMap<Integer, Product> getAllProductFromDB ();

    void addProductToProductList(String productName, double productPrice);


    void deleteProductFromProductList(int productId);

    HashMap<Integer, Product> getAllProductFromBucketDB();

    void addProductToBucketList(int productId);

    void deleteProductFromBucketDbList(int productInBucketId);

}
