package part2.Model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryName;

    @ManyToMany
    @JoinTable(
            name = "product_country",
            joinColumns = @JoinColumn(name = "countryId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<ProductJpa> productJpaList = new LinkedList<>();

}
