package part2.Service;

import lombok.extern.slf4j.Slf4j;
import part2.Product.Product;
import part2.Service.Concurrency.Concurrency;
import part2.Service.Concurrency.RURConcurrency;
import part2.Service.Concurrency.UAHConcurrency;
import part2.Service.Concurrency.USDConcurrency;

import java.io.*;
import java.util.List;
import java.util.Map;

@Slf4j
public class ShopService {
    private static Concurrency concurrency;

    public void saveCustomerBucket(List<Product> bucket){
        try {
            FileOutputStream fos = new FileOutputStream("customerBucket.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bucket);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            log.error("IOException during serialization.");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> downloadCustomerBucket(){
        List<Product> bucket = null;
        try {
            FileInputStream fis = new FileInputStream("customerBucket.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            bucket = (List<Product>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Your bucket downloaded");
        return bucket;
    }

    public double countBoughtPrice(double price, String paymentMethod) throws IllegalArgumentException {
        if (paymentMethod.equalsIgnoreCase("0")) {
            return price * 1.2;
        } else if (paymentMethod.matches("[1-3]")){
            switch (paymentMethod) {
                case "1":
                    concurrency = new RURConcurrency();
                    break;
                case "2":
                    concurrency = new UAHConcurrency();
                    break;
                case "3":
                    concurrency = new USDConcurrency();
                default:
            }
            return concurrency.countPrice(price);
        } else throw new IllegalArgumentException();
    }

    public void showProductList(Map<Integer, Product> productList) {
        System.out.println("Type: \n" +
                "- 'key' of the Product to add it in your bucket\n" +
                "- 'finish' to finish adding Product process.");
        productList.forEach((K, V) -> System.out.println(K + " " + V.getName() + " " + V.getPrice() + " BYN "));
    }

    public void showBucket(List<Product> bucket) {
        System.out.println("Your bucket:");
        if (bucket.isEmpty()) {
            System.out.println("Empty");
        } else
            for (int i = 0; i < bucket.size(); i++) {
                System.out.println(i + " " + bucket.get(i).getName() + " " + bucket.get(i).getPrice() + " BYN");
            }
    }

    public void addProductToBucket(List<Product> bucket, Map<Integer, Product> productList, Integer order) {
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

    public void showHome() {
        System.out.println("Describing workflow of the Shop:" +
                "\n - enter 'c' to view the catalogs " +
                "\n - enter 'b' to view your bucket " +
                "\n - type 'exit' to close this app" +
                "\n - type 'download' to download your last bucket");
    }


}
