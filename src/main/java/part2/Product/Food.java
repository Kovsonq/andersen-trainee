package part2.Product;

import lombok.Data;
import lombok.NoArgsConstructor;
import part2.Warehouse.ExpiredDate;

import java.util.Date;

@Data
@NoArgsConstructor
public class Food extends Product {

    @ExpiredDate
    private Date expiredDate;
    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Food(String name, double price, Date expiredDate) {
        this.name = name;
        this.price = price;
        this.expiredDate = expiredDate;
    }
}
