package part2;


import part2.Product.Food;
import part2.Product.NoFood;
import part2.Product.Product;

import part2.Product.User;
import part2.DAO.ShopConnection;

import part2.Service.ShopService;

import java.util.*;

public class ShopRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShopService shopService = new ShopService();

        Map<Integer, Product> productList = new HashMap<>();
        HashMap<User, List<Product>> bucket = new HashMap<>();

        productList.put(1, new Food("Bread", 4));
        productList.put(2, new Food("Tomato", 5));
        productList.put(3, new Food("Potato", 2));
        productList.put(4, new NoFood("Pencil", 5));
        productList.put(5, new NoFood("Knife", 12));
        productList.put(6, new NoFood("Cup", 8));


        System.out.print("Type your name:");
        String userName = input.nextLine();
        User user = shopService.badAuthorization(userName);
        bucket.put(user, shopService.downloadCustomerBucket(user));

        shopService.showHome();

        while (input.hasNext()) {
            String action = input.nextLine();

            switch (action) {
                //exit case
                case "exit":

                    shopService.saveCustomerBucket(bucket);
                    System.exit(0);

                //show history
                case "history":
                    shopService.callUserHistoryProcedure(user);
                    shopService.totalUserSpentMoney(user);
                    break;

                //show productList
                case "c": {
                    shopService.showProductList(productList);

                    //add Product in the bucket
                    String order;
                    while (true) {

                        order = input.nextLine();
                        if (order.equalsIgnoreCase("finish")) break;
                        if (order.matches("[0-9]*") && productList.containsKey(Integer.parseInt(order))) {

                            shopService.addProductToBucket(user, bucket, productList, Integer.parseInt(order));

                        } else System.out.println("Can't find any Product by this key");

                    }
                    shopService.showHome();
                    break;
                }


                // show Product in your bucket
                case "b": {
                    System.out.println("Type: \n" +
                            "- 'buy' if you want to buy smth from bucket\n" +
                            "- 'index of the product' if you want to remove the Product from the bucket \n" +
                            "- 'all' to clear your bucket\n" +
                            "- 'finish' to go home");
                    shopService.showBucket(user, bucket);


                    //Workflow in the bucket
                    while (true) {
                        if (bucket.isEmpty()) break;

                        String remove = input.nextLine();

                        if (remove.equalsIgnoreCase("finish")) break;

                        else if (remove.equalsIgnoreCase("buy")) {
                            System.out.println("Please, select 'index' of item you want to buy");
                            String item = input.nextLine();

                            System.out.println("Please, select concurrency for payment\n" +
                                    "'0' BYN\n" +
                                    "'1' RUR\n" +
                                    "'2' UAH\n" +
                                    "'3' USD");
                            String concurrency = input.nextLine();

                            String moneyType = "BYN";
                            switch (concurrency) {
                                case "1":
                                    moneyType = "RUR";
                                    break;
                                case "2":
                                    moneyType = "UAH";
                                    break;
                                case "3":
                                    moneyType = "USD";
                                    break;
                            }
                            try {
                                double price = shopService.countBoughtPrice(bucket.get(user).get(Integer.parseInt(item)).getPrice(), concurrency);
                                System.out.println("Your price for " +
                                        bucket.get(user).get(Integer.parseInt(item)).getName() + " is: " + price + " " + moneyType);

                                System.out.println("Do you confirm the order for this Product?\n" +
                                        "'y' - to approve\n" +
                                        "'n' - to cancel");
                                String confirm = input.nextLine();
                                while (true) {
                                    if (confirm.equalsIgnoreCase("n")){
                                        break;
                                    } else if (confirm.equalsIgnoreCase("y")){

                                        shopService.confirmOrder(user, Integer.parseInt(item), moneyType, bucket);

                                    } else System.out.println("Incorrect symbol: " + "'" + confirm + "'" + " try again.");
                                }
                                break;
                            } catch (IllegalArgumentException exception) {
                                System.out.println("Illegal index of concurrency");
                            }
                        } else if (remove.equalsIgnoreCase("all")) {
                            shopService.removeAllProductFromBucket(user, bucket);
                            shopService.showBucket(user, bucket);
                        } else if (remove.matches("[0-9]*")) {
                            shopService.removeOneProductFromBucketByKey(user, bucket, Integer.parseInt(remove));
                            shopService.showBucket(user, bucket);
                        } else System.out.println("Can't find any Product by this key");
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

