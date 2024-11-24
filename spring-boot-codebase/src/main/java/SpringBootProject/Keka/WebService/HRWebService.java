package SpringBootProject.Keka.WebService;


import SpringBootProject.Keka.Repository.HRRepository;
import SpringBootProject.Keka.Utility.HRPortalUtility;
import lombok.Getter;
import lombok.Setter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class HRWebService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Log Klogger = LogFactory.getLog(HRWebService.class);

    @Autowired
    HRRepository HRRepository;

    public List<HRPortalUtility> findAll() {
        return HRRepository.findAll();
    }

    public ResponseEntity<?> insertDocument(HRPortalUtility newEmployeeDoc) {
        newEmployeeDoc.setPassword(passwordEncoder.encode(newEmployeeDoc.getPassword()));
        HRPortalUtility newDoc = HRRepository.save(newEmployeeDoc);
        if (newDoc != null) {
            return new ResponseEntity<>("Successfully added in the MongoDB !", HttpStatus.CREATED);
        } else if (newDoc == null) {
            return new ResponseEntity<>("Empty JSON body received ...", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>("Something went wrong !", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<?> updateDocument(UserDetails existingDoc, HRPortalUtility updateDoc) {
        Klogger.info("Updating user : " + existingDoc.getUsername());
        if (existingDoc != null) {

            String oldPassword = existingDoc.getPassword();
            Klogger.info("Old password : " + oldPassword);

            updateDoc.setPassword(passwordEncoder.encode(updateDoc.getPassword()));
            HRRepository.save(updateDoc);
        }
        return new ResponseEntity<>("Successfully updated in the MongoDB !", HttpStatus.OK);
    }
}
