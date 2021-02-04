package part2.Product;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Product implements Serializable {
    private static final long serialVersionUID = 6022684364017404279L;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
