package SpringBootProject.User.utility;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organizations-users")
@Getter
@Setter
public class UserUtility {

    @Id
    private String id;
    private String username;
    private String password;
    @NonNull
    private String db_name;

}
