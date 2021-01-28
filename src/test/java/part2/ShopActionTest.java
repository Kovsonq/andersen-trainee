package part2;


import org.junit.Before;
import org.junit.Test;
import part2.Service.ShopService;
import part2.Product.Food;
import part2.Product.NoFood;
import part2.Product.Product;

import java.util.*;

import static org.junit.Assert.*;

public class ShopActionTest {
    ShopService shopService = new ShopService();
    Map<Integer, Product> productList = new HashMap<>();
    List<Product> bucket = new LinkedList<>();


    @Before
    public void init(){
        productList.put(1, new Food("Bread", 4));
        productList.put(2, new Food("Tomato", 5));
        productList.put(3, new Food("Potato", 2));
        productList.put(4, new NoFood("Pencil", 5));
        productList.put(5, new NoFood("Knife", 12));
        productList.put(6, new NoFood("Cup", 8));
    }

    @Test
    public void addProductToTheBucketTest(){
        assertTrue(bucket.isEmpty());
        shopService.addProductToBucket(bucket,productList,1);
        shopService.addProductToBucket(bucket,productList,4);
        assertEquals(productList.get(4) ,bucket.get(1));
    }

    @Test
    public void removeOneProductFromBucketTest(){
        assertTrue(bucket.isEmpty());
        shopService.addProductToBucket(bucket,productList,1);
        shopService.addProductToBucket(bucket,productList,4);
        assertEquals(2, bucket.size());

        shopService.removeOneProductFromBucketByKey(bucket,0);
        assertEquals(1, bucket.size());

        shopService.removeOneProductFromBucketByKey(bucket,0);
        assertTrue(bucket.isEmpty());
    }

    @Test
    public void removeAllProductFromBucketTest() {
        assertTrue(bucket.isEmpty());
        shopService.addProductToBucket(bucket, productList, 1);
        shopService.addProductToBucket(bucket, productList, 4);
        assertFalse(bucket.isEmpty());
        shopService.removeAllProductFromBucket(bucket);
        assertTrue(bucket.isEmpty());
    }

    @Test
    public void removeAndThenAddProductInBucketTest() {
        assertTrue(bucket.isEmpty());
        shopService.addProductToBucket(bucket, productList, 1);
        shopService.addProductToBucket(bucket, productList, 4);
        assertFalse(bucket.isEmpty());

        shopService.removeOneProductFromBucketByKey(bucket,0);
        shopService.addProductToBucket(bucket, productList, 2);
        assertEquals(2, bucket.size());

        shopService.removeOneProductFromBucketByKey(bucket,1);
        shopService.addProductToBucket(bucket, productList, 1);
        assertEquals(2, bucket.size());
    }

    @Test
    public void serializationAndDeserialization() {
        assertTrue(bucket.isEmpty());
        shopService.addProductToBucket(bucket,productList,1);
        shopService.addProductToBucket(bucket,productList,4);
        assertFalse(bucket.isEmpty());

        shopService.saveCustomerBucket(bucket);
        List<Product> bucketAfterSerializationDeserialization =
                shopService.downloadCustomerBucket();
        assertEquals(bucketAfterSerializationDeserialization, bucket);
    }

}
