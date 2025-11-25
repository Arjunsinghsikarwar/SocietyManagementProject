package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Model.Family;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FamilyServiceInterface {
     void createNewFamily(Family family);

      List<Family> getAllFamily();

      Optional<Family> getFamilyById(Long familyId);

      Family updateFamily(Long familyId , Family updateFamilyProfile);
}
