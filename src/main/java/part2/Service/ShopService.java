package part2.Service;

import lombok.extern.slf4j.Slf4j;
import part2.Product.Product;
import part2.Product.User;
import part2.Service.Concurrency.Concurrency;
import part2.Service.Concurrency.RURConcurrency;
import part2.Service.Concurrency.UAHConcurrency;
import part2.Service.Concurrency.USDConcurrency;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
public class ShopService {
    private static Concurrency concurrency;

    public void saveCustomerBucket(HashMap<User, List<Product>> bucket){
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
    public List<Product> downloadCustomerBucket(User user){
        List<Product> userBucket = new LinkedList<>();
        try {
            FileInputStream fis = new FileInputStream("customerBucket.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<User, List<Product>> bucket = (HashMap<User, List<Product>>) ois.readObject();
            userBucket = bucket.get(user);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            log.error("IOException during serialization." + e.getMessage());
        }
        System.out.println("Your bucket downloaded");
        return userBucket;
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

    public void showBucket(User user, HashMap<User, List<Product>> bucket) {
        List<Product> userBucket = bucket.get(user);
        System.out.println("Your bucket:");
        if (userBucket.isEmpty()) {
            System.out.println("Empty");
        } else
            for (int i = 0; i < userBucket.size(); i++) {
                System.out.println(i + " " + userBucket.get(i).getName() + " " + userBucket.get(i).getPrice() + " BYN");
            }
    }

    public void addProductToBucket(User user, HashMap<User, List<Product>> bucket, Map<Integer, Product> productList, Integer order) {
        List<Product> userBucket = bucket.get(user);
        userBucket.add(productList.get(order));
        System.out.println("Product " + productList.get(order).getName() +
                " " + productList.get(order).getPrice() + " BYN was added.");
    }

    public void removeOneProductFromBucketByKey(User user, HashMap<User, List<Product>> bucket, int remove) {
        List<Product> userBucket = bucket.get(user);
        String productName = userBucket.get(remove).getName();
        double productPrice = userBucket.get(remove).getPrice();
        userBucket.remove(remove);
        System.out.println("Product " + productName + " " + productPrice + " BYN was removed.");
    }

    public void removeAllProductFromBucket(User user, HashMap<User, List<Product>> bucket) {
        List<Product> userBucket = bucket.get(user);
        userBucket.clear();
        System.out.println("All products were removed from the bucket.");
    }

    public void showHome() {
        System.out.println("Describing workflow of the Shop:" +
                "\n - enter 'c' to view the catalogs " +
                "\n - enter 'b' to view your bucket " +
                "\n - enter 'history' to view your shop history " +
                "\n - type 'exit' to close this app");
    }

    @SuppressWarnings("unchecked")
    public User badAuthorization(String name){
        User user = new User(name);
        try {
            FileInputStream fis = new FileInputStream("customerBucket.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap<User, List<Product>> bucket = (HashMap<User, List<Product>>) ois.readObject();
            for (HashMap.Entry<User, List<Product>> entry : bucket.entrySet()){
                if (entry.getKey().getName().equals(name)){
                    user = entry.getKey();
                    System.out.println(name + ", hello again");
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            log.error("That's first start of the app, hello customer!");
        }
        return user;
    }



}
