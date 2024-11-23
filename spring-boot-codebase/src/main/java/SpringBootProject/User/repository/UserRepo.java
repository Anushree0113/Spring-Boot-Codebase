package SpringBootProject.User.repository;

import SpringBootProject.User.utility.UserUtility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserUtility, String> {
}
