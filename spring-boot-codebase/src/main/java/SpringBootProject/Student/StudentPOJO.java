package SpringBootProject.Student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student-entries")
@Getter
@Setter
public class StudentPOJO {

    @Id
    private int id;
    private String name;
    private String address;
    private String email;

}
