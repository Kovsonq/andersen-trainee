package part2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import part2.DAO.JdbcTemplateProductImpl;
import part2.Product.Product;

import java.util.HashMap;

public class ProductWebService {

    @Autowired
    private final JdbcTemplateProductImpl jdbcTemplateProduct;

    public ProductWebService(JdbcTemplateProductImpl jdbcTemplateProduct) {
        this.jdbcTemplateProduct = jdbcTemplateProduct;
    }

    public HashMap<Integer, Product> getAllProductFromDB (){
        return jdbcTemplateProduct.getAllProductFromDB();
    };

    public void addProductToProductList(String productName, double productPrice){
        jdbcTemplateProduct.addProductToProductList(productName, productPrice);
    };

    public void deleteProductFromProductList(int productId){
        jdbcTemplateProduct.deleteProductFromProductList(productId);
    };

    public HashMap<Integer, Product> getAllProductFromBucketDB(){
        return jdbcTemplateProduct.getAllProductFromBucketDB();
    };

    public void addProductToBucketList(int productId){
        jdbcTemplateProduct.addProductToBucketList(productId);
    };

    public void deleteProductFromBucketDbList(int productInBucketId){
        jdbcTemplateProduct.deleteProductFromBucketDbList(productInBucketId);
    };

}
