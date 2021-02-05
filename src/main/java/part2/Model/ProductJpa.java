package part2.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_jpa")
public class ProductJpa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String productName;

    private double productPrice;


    @ManyToMany(mappedBy = "productJpaList")
    private List<Country> countryList;

    @ManyToMany(mappedBy = "bucketProduct")
    private List<Bucket> buckets;

}
