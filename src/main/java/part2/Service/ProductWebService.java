package part2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import part2.DAO.JdbcTemplateProductImpl;
import part2.Model.Product.Product;

import java.util.HashMap;

@Transactional(rollbackFor = Exception.class)
public class ProductWebService {

    private final JdbcTemplateProductImpl jdbcTemplateProduct;

    @Autowired
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
