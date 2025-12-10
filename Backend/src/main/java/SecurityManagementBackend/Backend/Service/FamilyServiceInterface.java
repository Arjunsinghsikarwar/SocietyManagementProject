package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FamilyServiceInterface {

      List<Family> getAllFamily();

      Family getFamilyById(Long familyId);

      Family updateFamily(Long familyId , Family updateFamilyProfile);

      void deleteFamilyById(Long familyId);

    void addFamilyMembers(List<Member> memberList, Long familyId);

    List<Member> getAllFamilyMemebers(Long familyId);
}
