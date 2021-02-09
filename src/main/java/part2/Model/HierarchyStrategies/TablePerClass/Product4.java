package part2.Model.HierarchyStrategies.TablePerClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Product4 {

    @Id
    private long productId;

    private String productName;

    private double productPrice;

}
