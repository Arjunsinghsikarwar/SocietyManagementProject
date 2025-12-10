package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long>
{
    UserInfo findByUserName(String username);
}
