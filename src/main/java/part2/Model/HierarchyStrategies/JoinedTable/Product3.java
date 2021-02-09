package part2.Model.HierarchyStrategies.JoinedTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product3 {

    @Id
    private long productId;

    private String productName;

    private double productPrice;

}
