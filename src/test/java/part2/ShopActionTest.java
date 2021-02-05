package part2;


import org.junit.Before;
import org.junit.Test;
import part2.Model.Product.User;
import part2.Service.ShopService;

import part2.Model.Product.Food;
import part2.Model.Product.NoFood;
import part2.Model.Product.Product;
import part2.Warehouse.Warehouse;

import java.util.*;


import static org.junit.Assert.*;

public class ShopActionTest {
    ShopService shopService = new ShopService();
    Map<Integer, Product> productList = new HashMap<>();
    HashMap<User, List<Product>> bucket  = new HashMap<>();
    List<Product> userBucket = new LinkedList<>();
    User user = new User("Alex");


    @Test
    public void addProductToTheWarehouseTest(){
        Warehouse warehouse = new Warehouse();

        warehouse.addProductToWarehouse(new Food("Milk",2),1);
        HashMap<Product,Integer> testWarehouse = warehouse.getWarehouseMap();
        Food food = new Food();
        for (Map.Entry<Product,Integer> entry : testWarehouse.entrySet()){
            food = (Food) entry.getKey();
        }
        assertNotNull(food.getExpiredDate());
    }



    @Before
    public void init(){
        bucket.put(user, userBucket);
        productList.put(1, new Food("Bread", 4));
        productList.put(2, new Food("Tomato", 5));
        productList.put(3, new Food("Potato", 2));
        productList.put(4, new NoFood("Pencil", 5));
        productList.put(5, new NoFood("Knife", 12));
        productList.put(6, new NoFood("Cup", 8));
    }

    @Test
    public void saveProductFromBucketToTheDBAndTakeFromTest(){
//        shopConnection.createTriggerForAnalyticsTable();
//        shopConnection.createUserHistoryProcedure();
        user = shopService.badAuthorization(user.getName());
        bucket.put(user, shopService.downloadCustomerBucket(user));
//        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket, productList,1);
        shopService.addProductToBucket(user, bucket, productList,4);
        shopService.confirmOrder(user,1,"RUR",bucket);
        shopService.callUserHistoryProcedure(user);
        shopService.totalUserSpentMoney(user);
    }

    @Test
    public void getAllProductFromDB(){
        System.out.println(shopService.getAllProductFromDB().entrySet());
    }

    @Test
    public void addProductToTheDB(){
        shopService.addProductToProductList("Malina",12.22);
    }

    @Test
    public void addProductToTheBucketTest(){
        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket, productList,1);
        shopService.addProductToBucket(user, bucket, productList,4);
        assertEquals(productList.get(4) ,bucket.get(user).get(1));
    }

    @Test
    public void removeOneProductFromBucketTest(){
        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket,productList,1);
        shopService.addProductToBucket(user, bucket,productList,4);
        assertEquals(2, bucket.get(user).size());

        shopService.removeOneProductFromBucketByKey(user, bucket,0);
        assertEquals(1, bucket.get(user).size());

        shopService.removeOneProductFromBucketByKey(user, bucket,0);
        assertTrue(bucket.get(user).isEmpty());
    }

    @Test
    public void removeAllProductFromBucketTest() {
        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket, productList, 1);
        shopService.addProductToBucket(user, bucket, productList, 4);
        assertFalse(bucket.get(user).isEmpty());
        shopService.removeAllProductFromBucket(user, bucket);
        assertTrue(bucket.get(user).isEmpty());
    }

    @Test
    public void removeAndThenAddProductInBucketTest() {
        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket, productList, 1);
        shopService.addProductToBucket(user, bucket, productList, 4);
        assertFalse(bucket.get(user).isEmpty());

        shopService.removeOneProductFromBucketByKey(user, bucket,0);
        shopService.addProductToBucket(user, bucket, productList, 2);
        assertEquals(2, bucket.get(user).size());

        shopService.removeOneProductFromBucketByKey(user, bucket,1);
        shopService.addProductToBucket(user, bucket, productList, 1);
        assertEquals(2, bucket.get(user).size());
    }

    @Test
    public void serializationAndDeserialization() {
        assertTrue(bucket.get(user).isEmpty());
        shopService.addProductToBucket(user, bucket,productList,1);
        shopService.addProductToBucket(user, bucket,productList,4);
        assertFalse(bucket.get(user).isEmpty());

        shopService.saveCustomerBucket(bucket);
        List<Product> bucketAfterSerializationDeserialization =

                shopService.downloadCustomerBucket(user);
        assertEquals(bucketAfterSerializationDeserialization, bucket.get(user));

    }

}
