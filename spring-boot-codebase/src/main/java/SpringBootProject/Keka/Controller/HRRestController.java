package SpringBootProject.Keka.Controller;

import SpringBootProject.Keka.Utility.HRPortalUtility;
import SpringBootProject.Keka.WebService.HRWebService;
import SpringBootProject.Keka.WebService.UserDetailsImpl;
import lombok.Getter;
import lombok.Setter;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("/employee")
public class HRRestController {

    private final Log Klogger = LogFactory.getLog(HRRestController.class);


    @Autowired
    HRWebService hrWebService;
    @Autowired
    private UserDetailsImpl userDetailsImpl;

    @GetMapping
    public List<HRPortalUtility> getEmployees() {
        Klogger.info("Fetching details of all employees ...");
        return hrWebService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody HRPortalUtility employeeDoc) {
        Klogger.info("Adding new Employee ...");
        return hrWebService.insertDocument(employeeDoc);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody HRPortalUtility employeeDoc) {
        Klogger.info("Updating Employee ...");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();
        Klogger.info(username);
        UserDetails userDetails = userDetailsImpl.loadUserByUsername(username);

        return hrWebService.updateDocument(userDetails, employeeDoc);
    }
}
