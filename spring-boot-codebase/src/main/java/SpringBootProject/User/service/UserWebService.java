package SpringBootProject.User.service;

import SpringBootProject.Database.repository.DatabaseRepo;
import SpringBootProject.Database.utility.DatabaseUtility;
import SpringBootProject.User.repository.UserRepo;
import SpringBootProject.User.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserWebService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    DatabaseRepo databaseRepo;


    public List<UserUtility> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public ResponseEntity<?> createUser(UserUtility user, String db_name) {
        UserUtility newUser = userRepo.save(user);

        Optional<DatabaseUtility> databaseDoc = databaseRepo.findById(db_name);
        if (databaseDoc.isPresent()) {
            databaseDoc.get().getUsers().add(newUser);
            databaseRepo.save(databaseDoc.get());
            return new ResponseEntity<>("User created and mapped with the particular database", HttpStatus.CREATED);
        }
        return new ResponseEntity("User created but not mapped with database", HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> deleteUser(String user_id) {
        try {
            UserUtility userDoc = userRepo.findById(user_id).orElse(null);
            if (userDoc != null) {
                String db_name = userDoc.getDb_name();
                databaseRepo.findById(db_name).get().getUsers().remove(user_id);
                databaseRepo.save(databaseRepo.findById(db_name).get());
            }
            userRepo.deleteById(user_id);
            return new ResponseEntity<>("User deleted from user collection & database collection", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
