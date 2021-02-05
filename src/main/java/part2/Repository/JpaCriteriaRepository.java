package part2.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import part2.Model.Bucket;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class JpaCriteriaRepository {

    private final EntityManager entityManager;

    @Autowired
    public JpaCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Bucket> getAllProductFromBucket(String userName){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bucket> criteriaQuery = criteriaBuilder.createQuery(Bucket.class);

        Root<Bucket> bucketRoot = criteriaQuery.from(Bucket.class);
        Predicate predicateUserName = criteriaBuilder.equal(bucketRoot.get("userName"), userName);

        criteriaQuery.where(predicateUserName);
        TypedQuery<Bucket> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
