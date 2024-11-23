package SpringBootProject.Database.controller;

import SpringBootProject.Database.service.DatabaseWebService;
import SpringBootProject.Database.utility.DatabaseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/databases")
public class DatabaseController {
    @Autowired
    DatabaseWebService databaseWebService;

    @GetMapping
    public List<DatabaseUtility> getAllDatabases() {
        return databaseWebService.getAllDatabases();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDatabase(@RequestBody DatabaseUtility database) {
        return databaseWebService.createDatabase(database);
    }
}
