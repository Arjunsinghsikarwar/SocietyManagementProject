package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long>
{
    @Query(value = "Select * from user_Info where user_name = :username" , nativeQuery = true)
    UserInfo findByUserName(@Param("username") String username);
}
