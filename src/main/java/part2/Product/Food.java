package part2.Product;

import java.util.Date;

public class Food extends Product {
    Date expiredDate;

    public Food(String name, double price) {
        super(name, price);
    }
}
