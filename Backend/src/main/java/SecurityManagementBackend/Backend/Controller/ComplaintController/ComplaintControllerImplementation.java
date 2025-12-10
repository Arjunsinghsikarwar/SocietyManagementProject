package SecurityManagementBackend.Backend.Controller.ComplaintController;


import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Service.ComplaintService.ComplaintServiceInterfaceImplementation;
import SecurityManagementBackend.Backend.Service.ComplaintServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Map;

@RestController
@RequestMapping("/complaint")
public class ComplaintControllerImplementation {

    @Autowired
    private ComplaintServiceInterface complainService ;

    @GetMapping("/family/{familyId}")
    public ResponseEntity<Map<String , Object>>  getAllComplaintForSingleFamily(@PathVariable Long familyId){
        List<Complaint> getAllComplain = complainService.getAllComplainsForSingleFamily(familyId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully fetched All Complain for the Single Family",
                "complainList",getAllComplain));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Map<String , Object>> getComplaintById(@PathVariable Long memberId){
        List<Complaint> complaintList = complainService.getComplaintForEachMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully fetched Complaint for the Single Member","complainList",complaintList));
    }

    @DeleteMapping("/removeComplaint/{memberId}")
        public ResponseEntity<Map<String,Object>> removeAllComplaintForEachMember(@PathVariable Long memberId ){
        complainService.removeAllComplaintForEachMember(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully Removed All Complaint for the This Member"));
        }
}
