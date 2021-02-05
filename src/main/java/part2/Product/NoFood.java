package part2.Product;

import lombok.Data;
import part2.Warehouse.ExpiredDate;


@Data
public class NoFood extends Product {

    private String name;
    private double price;

    public NoFood() {
    }

    public NoFood(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
