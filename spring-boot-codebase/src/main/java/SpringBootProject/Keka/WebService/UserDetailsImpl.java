package SpringBootProject.Keka.WebService;

import SpringBootProject.Keka.Repository.HRRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    HRRepository employee;

    @Autowired
    HRWebService webService;

    @Autowired
    private static  final Log Klogger  = LogFactory.getLog(UserDetailsImpl.class);

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Klogger.info("Load user by name...");
        org.apache.catalina.User userDoc = employee.findByUsername(username);

        if (userDoc != null) {
            Klogger.info("Doc is not null...");
            UserDetails userDetails = User.builder().username(username).password(userDoc.getPassword()).roles("USER").build();
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
