package part2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import part2.Model.ProductJpa;
import part2.Repository.ProductJpaRepository;

import java.util.Optional;

@Service
@Transactional
public class ProductJpaService {

    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductJpaService(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public ProductJpa findProductJpaById(Long id){
        return productJpaRepository.findProductJpaById(id);
    }

    public ProductJpa getOneProductJpa (Long id) {
        return productJpaRepository.getOne(id);
    }

    public ProductJpa saveProductJpa(ProductJpa productJpa){
        return productJpaRepository.save(productJpa);
    }

    public void deleteProductJpa(Long id){
        productJpaRepository.deleteById(id);
    }

}
