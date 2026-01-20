package SecurityManagementBackend.Backend.Controller.AdminController;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminControllerImplementation {

    @Autowired
    private AdminServiceInterface adminService;

    @PostMapping("/createNewFamily")
    public ResponseEntity<Map<String,Object>> createNewFamily(@RequestBody Family family){
     Family family1  = adminService.createNewFamily(family);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "message" , "Family Create Successfully",
                 "family" , family1
        ));
    }


    @PostMapping("/assigningAllInfoToFamily/family/familyId/{familyId}")
    public ResponseEntity<Map<String, Object>> assignLeader(@RequestBody Family family, @PathVariable Long familyId) {
      Family family1  = adminService.assigningAllInfoToFamily(family, familyId);
      return ResponseEntity.status(HttpStatus.OK).body(Map.of(
              "message" , "Successfully Assigned",
              "family" , family1
      ));
    }

    @GetMapping("/getFamily/{familyId}")
    public ResponseEntity<Family> getFamily(@PathVariable Long familyId){
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getFamily(familyId));
    }
}

