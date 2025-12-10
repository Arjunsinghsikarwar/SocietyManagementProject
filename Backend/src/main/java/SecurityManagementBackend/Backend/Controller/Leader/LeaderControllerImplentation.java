package SecurityManagementBackend.Backend.Controller.Leader;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Leader;
import SecurityManagementBackend.Backend.Service.LeaderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leader")
public class LeaderControllerImplentation {

    @Autowired // remember this by doing this we are not creating the object of the interface cause it is not allowed to put the annotiation , this means the spring will find the class who implements this interface and that object is going come here .
    private LeaderServiceInterface leaderService;


    @PostMapping("/register")
    public ResponseEntity<Map<String,Object>> registerNewLeader(@RequestBody Leader leader){
     LeaderDto leaderDto1  = leaderService.createNewLeader(leader);

     return ResponseEntity.status(HttpStatus.OK).body(Map.of(
             "message","You Successfully Accessed As Leader",
             "Leader" , leaderDto1
     ));
    }


    @GetMapping("/getProfile/{leaderId}/profile")
    public ResponseEntity<Map<String , Object>> getProfile(@PathVariable Long leaderId){
        LeaderDto leaderDto = leaderService.getFullProfileOfLeader(leaderId);
        return ResponseEntity.ok().body(Map.of(
                "message","Profile Successfully Fetched",
                "Leader Profile" , leaderDto
        ));
    }

    @GetMapping("/getAllFamilies/leader/{leaderId}")
    public ResponseEntity<Map<String , Object>> getAllFamilyOfLeader(@PathVariable Long leaderId)
    {
        List<Family> getAllFamily = leaderService.getLeaderFamily(leaderId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully Fetched",
                "Families", getAllFamily));
    }

    @DeleteMapping("/{leaderId}/deleteMember/{memberId}")
    public ResponseEntity<Map<String , String>> deleteMember(@PathVariable Long leaderId , @PathVariable Long memberId){
        leaderService.removeMemberFromFamily(leaderId,memberId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "message" , "Member deleted Successfully"
        ));
    }

}




