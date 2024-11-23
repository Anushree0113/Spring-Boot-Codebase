package SpringBootProject.Database.repository;

import SpringBootProject.Database.utility.DatabaseUtility;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatabaseRepo extends MongoRepository<DatabaseUtility, String> {

}
