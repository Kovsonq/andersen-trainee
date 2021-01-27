package part2;

import part2.product.Food;
import part2.product.NoFood;
import part2.product.Product;
import part2.Service.ShopService;

import java.util.*;

public class ShopRunner {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();

        Map<Integer, Product> productList = new HashMap<>();
        List<Product> bucket = new LinkedList<>();

        productList.put(1, new Food("Bread", 4));
        productList.put(2, new Food("Tomato", 5));
        productList.put(3, new Food("Potato", 2));
        productList.put(4, new NoFood("Pencil", 5));
        productList.put(5, new NoFood("Knife", 12));
        productList.put(6, new NoFood("Cup", 8));

        shopService.showHome();

        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String action = input.nextLine();

            switch (action) {
                //exit case
                case "exit":
                    System.exit(0);

                    //show productList
                case "c": {
                    shopService.showProductList(productList);

                    //add product in the bucket
                    String order;
                    while (true){
                        order = input.nextLine();
                        if (order.equalsIgnoreCase("finish")) break;
                        if (order.matches("[0-9]*") && productList.containsKey(Integer.parseInt(order))) {
                            shopService.addProductToBucket(bucket, productList, Integer.parseInt(order));
                        } else System.out.println("Can't find any product by this key");
                    }
                    shopService.showHome();
                    break;
                }

                // show product in your bucket
                case "b": {
                    System.out.println("Type: \n" +
                            "- 'index' if you want to remove a product from the bucket \n" +
                            "- 'all' to clear your bucket\n" +
                            "- 'finish' to go home");
                    shopService.showBucket(bucket);

                    //delete product from bucket
                    String remove;
                    while (true) {
                        if (bucket.isEmpty()) break;

                        remove = input.nextLine();

                        if (remove.equalsIgnoreCase("finish")) break;

                        else if (remove.equalsIgnoreCase("all")) {
                                shopService.removeAllProductFromBucket(bucket);
                                shopService.showBucket(bucket);
                            } else if (remove.matches("[0-9]*")) {
                                shopService.removeOneProductFromBucketByKey(bucket, Integer.parseInt(remove));
                                shopService.showBucket(bucket);
                            } else System.out.println("Can't find any product by this key");
                        }
                    shopService.showHome();
                        break;

                }

                // error input
                default:
                    System.out.println("You typed wrong symbol, try again");
                    shopService.showHome();
                    break;
            }

        }
    }
}
