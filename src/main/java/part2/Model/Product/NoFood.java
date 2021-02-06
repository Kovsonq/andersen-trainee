package part2.Model.Product;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NoFood extends Product {

    private String name;
    private double price;

    public NoFood(String name, double price) {
        this.name = name;
        this.price = price;
    }
}