package SpringBootProject.Database.service;

import SpringBootProject.Database.repository.DatabaseRepo;
import SpringBootProject.Database.utility.DatabaseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DatabaseWebService {
    @Autowired
    DatabaseRepo databaseRepo;

    public List<DatabaseUtility> getAllDatabases() {
        return databaseRepo.findAll();
    }

    public ResponseEntity<?> createDatabase(DatabaseUtility databaseUtility) {
        DatabaseUtility isDatabaseCreated = databaseRepo.save(databaseUtility);
        if (isDatabaseCreated == null) {
            return new ResponseEntity<>("Database was not created", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Database was created", HttpStatus.CREATED);
    }

    public Optional<DatabaseUtility> getDatabase(String databaseName) {
        return databaseRepo.findById(databaseName);
    }

}
