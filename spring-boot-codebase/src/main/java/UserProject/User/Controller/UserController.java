package UserProject.User.Controller;

import UserProject.User.Utility.UserUtility;
import UserProject.User.WebService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

/*  @GetMapping
    public List<UserUtility> getAllUser() {
        return userService.getUsers();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        Optional<UserUtility> userDoc = userService.getUser(id);
        if (userDoc.isPresent()) {
            return new ResponseEntity<>(userDoc.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserUtility user) {
        return userService.addUser(user);
    }

    @GetMapping
    public ResponseEntity<?> getUserByName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.getUserByName(username);
    }
}
