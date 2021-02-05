package part2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import part2.Model.ProductJpa;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpa, Long> {
    ProductJpa findProductJpaById(Long id);
}
