package SecurityManagementBackend.Backend.SpringSecuritySetUp.UserDetailsSetUp;

import SecurityManagementBackend.Backend.Model.UserInfo;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailImplementation implements UserDetails {

    private UserInfo userInfo;

    public UserDetailImplementation(UserInfo userInfo){
        this.userInfo = userInfo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> userInfo.getRole());
    }

    @Override
    public @Nullable String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
