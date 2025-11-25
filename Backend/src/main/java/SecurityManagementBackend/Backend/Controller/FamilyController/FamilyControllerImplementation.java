package SecurityManagementBackend.Backend.Controller.FamilyController;


import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Service.FamilyService.FamilyServiceInterfaceImplementation;
import org.apache.coyote.Response;
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
    FamilyServiceInterfaceImplementation familyService;


    @PostMapping("/createNewFamily")
    public ResponseEntity<Map<String , String>> createNewFamily(@RequestBody Family family){
            familyService.createNewFamily(family);
            return ResponseEntity.status(200).body(Map.of("message","New Family Got Created Successfully"));
    }


    @GetMapping("/getAllFamilies")
    public ResponseEntity<Map<String , Object>> getAllFamily(){
       List<Family> familyList = familyService.getAllFamily();

       return ResponseEntity.status(200).body(Map.of("message","Successfully Fetched All Users",
               "familyList" , familyList));
    }

    @GetMapping("/{familyId}")
    public ResponseEntity<Map<String , Object>> getFamilyById(@PathVariable Long familyId){

        Optional<Family> getFamily = familyService.getFamilyById(familyId);

        return ResponseEntity.status(HttpStatus.FOUND).body(Map.of("message","successfully Fetched",
                "Family",getFamily));

    }


    @PutMapping("/{familyId}")
    public ResponseEntity<Map<String , Object>> updateFamilyId(@PathVariable Long familyId , @RequestBody Family updateFamilyProfile){

        Family updateFamily = familyService.updateFamily(familyId,updateFamilyProfile);

        return ResponseEntity.status(HttpStatus.FOUND).body(Map.of("message","successfully Fetched",
                "Family",updateFamily));

    }











}


