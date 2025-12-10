package SecurityManagementBackend.Backend.SpringSecuritySetUp.UserDetailsSetUp;


import SecurityManagementBackend.Backend.Exception.UserDoNotExistException;
import SecurityManagementBackend.Backend.Model.UserInfo;
import SecurityManagementBackend.Backend.Repositry.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSetUp implements UserDetailsService {
    @Autowired
    UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepo.findByUserName(username);

        if(userInfo == null){
            throw new UserDoNotExistException(username);
        }

        return new UserDetailImplementation(userInfo);
    }
}
