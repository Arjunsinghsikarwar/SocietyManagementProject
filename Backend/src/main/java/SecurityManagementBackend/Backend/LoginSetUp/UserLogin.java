package SecurityManagementBackend.Backend.LoginSetUp;

import org.springframework.stereotype.Component;

@Component
public class UserLogin {

    private String userName ;
    private String password;

    public UserLogin() {
    }

    public UserLogin(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
