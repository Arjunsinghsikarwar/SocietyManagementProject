package SecurityManagementBackend.Backend.LoginSetUp;

import org.springframework.stereotype.Component;

@Component
public class RegisterUser {

    private String userName;
    private String password;
    private String role;

    public RegisterUser() {
    }

    public RegisterUser(String password, String role, String userName) {
        this.password = password;
        this.role = role;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
