package SpringBootProject.Student.repository;

import SpringBootProject.Student.StudentPOJO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentEntryRepo extends MongoRepository<StudentPOJO, Integer> {

}
