package part2.Model.HierarchyStrategies.MappedSuperclass;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Food extends Product {

    private Date expiredDate;
}
