package SecurityManagementBackend.Backend.LoginService;
import SecurityManagementBackend.Backend.Exception.LeaderAlreadyAssignedException;
import SecurityManagementBackend.Backend.Exception.UserAlreadyExistException;
import SecurityManagementBackend.Backend.LoginSetUp.RegisterUser;
import SecurityManagementBackend.Backend.Model.Leader;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Model.UserInfo;
import SecurityManagementBackend.Backend.Repositry.LeaderRepo;
import SecurityManagementBackend.Backend.Repositry.MemberRepo;
import SecurityManagementBackend.Backend.Repositry.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegisterUserService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    LeaderRepo leaderRepo;

    @Autowired
    MemberRepo memberRepo;


    public void exist(RegisterUser registerUser) {
        UserInfo userInfo = userInfoRepo.findByUserName(registerUser.getUserName());

        if(userInfo != null) {

            if(userInfo.getRole().equals("LEADER"))
            throw new LeaderAlreadyAssignedException(userInfo.getUserId(), "This UserName Leader Already Exists");
            else if (userInfo.getRole().equals("MEMBER"))
                throw new UserAlreadyExistException("This UserName Member Already Exist");
            else
                throw new UserAlreadyExistException("This UserName Admin Already Exist");
        }
        registerNewUser(registerUser);
    }



    public void registerNewUser(RegisterUser registerUser) {

        String finalRole = "ROLE_" + registerUser.getRole();

        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName(registerUser.getUserName());
        userInfo1.setPassword(passwordEncoder.encode(registerUser.getPassword()));
        userInfo1.setRole(finalRole);

        userInfoRepo.save(userInfo1);

        if(finalRole.equals("ROLE_LEADER"))
            leaderRegister(userInfo1);
        else
            memberRegister(userInfo1);

    }


    public void leaderRegister(UserInfo userInfo){
        Leader leader = new Leader();
        leader.setRole(userInfo.getRole());
        leader.setUserName(userInfo.getUserName());
        leader.setPassword(userInfo.getPassword());
        leaderRepo.save(leader);
    }


    public void memberRegister(UserInfo userInfo){
        Member member = new Member();
        member.setName(userInfo.getUserName());
        member.setRole(userInfo.getRole());
        member.setPassword(userInfo.getPassword());
        memberRepo.save(member);
    }


}
