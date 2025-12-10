package SecurityManagementBackend.Backend.Controller.Register;

import SecurityManagementBackend.Backend.LoginService.RegisterUserService;
import SecurityManagementBackend.Backend.LoginSetUp.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterControllerImplementation {

    @Autowired
    private RegisterUserService registerUserService;

    @PostMapping("/register")
    public ResponseEntity<Map<String , Object>> registerUser(@RequestBody RegisterUser registerUser){
        registerUserService.exist(registerUser);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully Register"));
    }
}
