package SecurityManagementBackend.Backend.Controller.FamilyController;


import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Service.FamilyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/families")
public class FamilyControllerImplementation {

    @Autowired
    FamilyServiceInterface familyService;



    @GetMapping("/getAllFamilies")
    public ResponseEntity<Map<String , Object>> getAllFamily(){
       List<Family> familyList = familyService.getAllFamily();

       return ResponseEntity.status(200).body(Map.of("message","Successfully Fetched All Users",
               "familyList" , familyList));
    }

    @GetMapping("/{familyId}")
    public ResponseEntity<Map<String , Object>> getFamilyById(@PathVariable Long familyId){

       Family getFamily = familyService.getFamilyById(familyId);

        return ResponseEntity.status(200).body(Map.of("message","successfully Fetched",
                "Family",getFamily));
    }

    @PutMapping("/{familyId}")
    public ResponseEntity<Map<String , Object>> updateFamilyId(@PathVariable Long familyId , @RequestBody Family updateFamilyProfile){

        Family updateFamily = familyService.updateFamily(familyId,updateFamilyProfile);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","successfully Fetched",
                "Family",updateFamily));
    }

    @DeleteMapping("/deleteFamily/{familyId}")
    public ResponseEntity<Map<String , Object>> deleteFamilyById(@PathVariable Long familyId){
        familyService.deleteFamilyById(familyId);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Successfully Deleted"));
    }

    @PostMapping("/{familyId}/members")
    public ResponseEntity<Map<String ,  Object>>  addFamilyMembers(@RequestBody List<Member> memberList, @PathVariable Long familyId){

        familyService.addFamilyMembers(memberList,familyId);
        return  ResponseEntity.status(200).body(Map.of("message","All The New Members Added Successfully"));
    }

    @GetMapping("/{familyId}/getAllMembers")
    public ResponseEntity<Map<String , Object>> getAllFamilyMembers(@PathVariable Long familyId){
       List<Member> memberList = familyService.getAllFamilyMemebers(familyId);
       return ResponseEntity.ok().body(Map.of(
               "message" , "Successfully fetched all Members"
               ,"memberList" , memberList
       ));
    }
}


