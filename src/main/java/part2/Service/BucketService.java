package part2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import part2.Model.Bucket;
import part2.Repository.BucketRepository;
import part2.Repository.JpaCriteriaRepository;

import java.util.List;

@Service
@Transactional
public class BucketService {
    private final BucketRepository bucketRepository;
    private final JpaCriteriaRepository jpaCriteriaRepository;

    @Autowired
    public BucketService(BucketRepository bucketRepository, JpaCriteriaRepository jpaCriteriaRepository) {
        this.bucketRepository = bucketRepository;
        this.jpaCriteriaRepository = jpaCriteriaRepository;
    }

    public Bucket saveProductJpaToBucket(Bucket bucket){
        return bucketRepository.save(bucket);
    }

    public void deleteProductJpa(Long id){
        bucketRepository.deleteById(id);
    }

    public List<Bucket> findAllProductInBucket(String userName){
        return jpaCriteriaRepository.getAllProductFromBucket(userName);
    }
}
