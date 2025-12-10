package SecurityManagementBackend.Backend.Controller.MemberController;

import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Service.MemberService.MemberServiceInterfaceImplementation;
import SecurityManagementBackend.Backend.Service.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberControllerImplementation {

    @Autowired
    private MemberServiceInterface memberService;


    @GetMapping("/{memberId}")
    public ResponseEntity<Map<String , Object>> getSingleMember(@PathVariable Long memberId){

        Member member = memberService.getSingleMember(memberId);
        return ResponseEntity.ok().body(Map.of("message","Successfully Fetched",
                "member",member));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Map<String, Object>> updateMemberById(@PathVariable Long memberId , @RequestBody Member member){
        memberService.updateSingleMemberById(memberId,member);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Map.of("message","Successfully Updated"));
    }

    @DeleteMapping("/removeMember/{memberId}")
    public ResponseEntity<Map<String , Object>> removeMemberById(@PathVariable Long memberId){
        memberService.removeMeberById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Succesfully memebr got Removed"));
    }

    @GetMapping("/{memberId}/getMemberComplaints")
    public ResponseEntity<Map<String , Object>> getSingleMemberComplaints(@PathVariable Long memberId){
        List<Complaint> getAllComplain = memberService.getAllComplainsForSingleMember(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successsfully get All Complaints",
                "complainList",getAllComplain));
    }
}
