package part2.Service;

import part2.product.Product;

import java.util.List;
import java.util.Map;

public class ShopService {

    public void showProductList(Map<Integer, Product> productList){
        System.out.println("Type: \n" +
                "- 'key' of the product to add it in your bucket\n" +
                "- 'finish' to finish adding product process.");
        productList.forEach((K,V) -> System.out.println(K + " " + V.getName() + " "  + V.getPrice() + " BYN "));
    }

    public void showBucket(List<Product> bucket){
        System.out.println("Your bucket:");
        if (bucket.isEmpty()){
            System.out.println("Empty");
        } else
            bucket.forEach((p)-> System.out.println(bucket.indexOf(p) + " " + p.getName() + " " + p.getPrice() + " BYN"));
    }

    public void addProductToBucket(List<Product> bucket, Map<Integer, Product> productList, Integer order){
        bucket.add(productList.get(order));
        System.out.println("Product " + productList.get(order).getName() +
                " " + productList.get(order).getPrice() + " BYN was added.");
    }

    public void removeOneProductFromBucketByKey(List<Product> bucket, int remove) {
            String productName = bucket.get(remove).getName();
            double productPrice = bucket.get(remove).getPrice();
            bucket.remove(remove);
            System.out.println("Product " + productName + " " + productPrice + " BYN was removed.");
    }

    public void removeAllProductFromBucket(List<Product> bucket) {
            bucket.clear();
            System.out.println("All products were removed from the bucket.");
    }

    public void showHome(){
        System.out.println("Describing workflow of the Shop:" +
                "\n - enter 'c' to view the catalogs " +
                "\n - enter 'b' to view your bucket " +
                "\n - type 'exit' to close this app");
    }
}
