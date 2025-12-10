package SecurityManagementBackend.Backend.Controller.Login;

import SecurityManagementBackend.Backend.LoginService.LoginUserService;
import SecurityManagementBackend.Backend.LoginSetUp.UserLogin;
import SecurityManagementBackend.Backend.SpringSecuritySetUp.JwtService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginControllerImplementation {

    @Autowired
   private LoginUserService loginUserService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<Map<String , Object>> userLogin(@RequestBody UserLogin userLogin){
           loginUserService.isExist(userLogin);

           String token = jwtService.generateToken(userLogin.getUserName());

           return  ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Login Login Successfully",
           "token",token));
    }
}
