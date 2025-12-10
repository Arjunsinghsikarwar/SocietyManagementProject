package SecurityManagementBackend.Backend.LoginService;

import SecurityManagementBackend.Backend.Exception.UserDoNotExistException;
import SecurityManagementBackend.Backend.LoginSetUp.UserLogin;
import SecurityManagementBackend.Backend.Model.UserInfo;
import SecurityManagementBackend.Backend.Repositry.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void isExist(UserLogin userLogin) {
       UserInfo userInfo = userInfoRepo.findByUserName(userLogin.getUserName());

       if(userInfo==null)
           throw new UserDoNotExistException(userLogin.getUserName());


       // I have to change this , just learning purpose.
       if(userInfo.getRole().equals("ROLE_ADMIN"))
           return;


      boolean passwordMatches = passwordEncoder.matches(
              userLogin.getPassword(), userInfo.getPassword()
      );

      if(!passwordMatches)
          throw new UserDoNotExistException(userLogin.getUserName());

    }
}
