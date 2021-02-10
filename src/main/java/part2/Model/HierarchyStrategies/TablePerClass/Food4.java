package part2.Model.HierarchyStrategies.TablePerClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Food4 extends Product4 {

    private Date expiredDate;

}
