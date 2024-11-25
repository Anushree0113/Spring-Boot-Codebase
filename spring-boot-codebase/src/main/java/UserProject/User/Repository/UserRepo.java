package UserProject.User.Repository;

import UserProject.User.Utility.UserUtility;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserUtility, String> {
    User findByUsername(String username);
}
