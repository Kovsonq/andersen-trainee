package part2.Model.HierarchyStrategies.JoinedTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@DiscriminatorValue("Food")
@PrimaryKeyJoinColumn(name = "foodId")
public class Food3 extends Product3 {

    private Date expiredDate;
}
