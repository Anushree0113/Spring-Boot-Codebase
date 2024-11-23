package SpringBootProject.Database.utility;

import SpringBootProject.User.utility.UserUtility;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "organizations-databases")
@Getter
@Setter
public class DatabaseUtility {


    private String id;

    @Id
    private String db_name;

    private String host;
    private String port;
    @Indexed(unique = true)
    private String db_username;

    @Encrypted
    private String db_password;
    @DBRef
    private List<UserUtility> users = new ArrayList<>();
}
