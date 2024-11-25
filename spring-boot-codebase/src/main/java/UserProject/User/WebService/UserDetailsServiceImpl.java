package UserProject.User.WebService;

import UserProject.User.Repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    /**
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepo.findByUsername(username);
        if (existingUser != null) {
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(existingUser.getUsername()).password(existingUser.getPassword()).roles("USER").build();
            return userDetails;
        }
        throw new UsernameNotFoundException(username);

    }
}
