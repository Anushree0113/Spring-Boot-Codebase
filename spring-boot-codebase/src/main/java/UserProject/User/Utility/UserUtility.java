package UserProject.User.Utility;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee-details")
@Getter
@Setter
public class UserUtility {

    private String id;
    private String username;
    private String password;

}
