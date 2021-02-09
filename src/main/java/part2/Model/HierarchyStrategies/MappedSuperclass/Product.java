package part2.Model.HierarchyStrategies.MappedSuperclass;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Product {

    @Id
    private long productId;

    private String productName;

    private double productPrice;

}
