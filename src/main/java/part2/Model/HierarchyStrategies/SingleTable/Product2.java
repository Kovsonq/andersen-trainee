package part2.Model.HierarchyStrategies.SingleTable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Product2 {

    @Id
    private long productId;

    private String productName;

    private double productPrice;
}
