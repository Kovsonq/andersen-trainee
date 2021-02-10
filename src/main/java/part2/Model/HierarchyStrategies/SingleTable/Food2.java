package part2.Model.HierarchyStrategies.SingleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Food")
public class Food2 extends Product2 {

    private Date expiredDate;
}
