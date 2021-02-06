package part2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import part2.Model.Bucket;
import part2.Model.ProductJpa;

@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long> {

}
