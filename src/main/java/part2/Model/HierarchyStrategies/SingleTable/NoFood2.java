package part2.Model.HierarchyStrategies.SingleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NoFood")
public class NoFood2 extends Product2 {

}
