package SpringBootProject.Keka.Repository;

import SpringBootProject.Keka.Utility.HRPortalUtility;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HRRepository extends MongoRepository<HRPortalUtility, String> {
    User findByUsername(String username);
}
