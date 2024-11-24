package SpringBootProject.Keka.Utility;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "hr-portal")
@Getter
@Setter
public class HRPortalUtility {

    @Id
    private String id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    private String department;
    private int Salary;

    List<String> roles;


}
