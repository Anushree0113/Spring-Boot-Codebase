package SpringBootProject.User.controller;

import SpringBootProject.User.service.UserWebService;
import SpringBootProject.User.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserWebService userWebService;

    @GetMapping
    public List<UserUtility> getAllUser() {
        return userWebService.getAllUsers();
    }

    @PostMapping("/create/{db_name}")
    public ResponseEntity<?> createUser(@RequestBody UserUtility user, @PathVariable String db_name) {
        return userWebService.createUser(user, db_name);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        return userWebService.deleteUser(userId);
    }
}
