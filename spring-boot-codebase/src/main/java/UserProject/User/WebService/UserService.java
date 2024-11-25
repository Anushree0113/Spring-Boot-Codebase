package UserProject.User.WebService;

import UserProject.User.Repository.UserRepo;
import UserProject.User.Utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    public List<UserUtility> getUsers() {
        return userRepo.findAll();
    }

    public Optional<UserUtility> getUser(String id) {
        return userRepo.findById(id);
    }

    public ResponseEntity<?> addUser(UserUtility user) {
        //adding password encryption
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserUtility newUserDoc = userRepo.save(user);
        if (newUserDoc == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newUserDoc, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getUserByName(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
