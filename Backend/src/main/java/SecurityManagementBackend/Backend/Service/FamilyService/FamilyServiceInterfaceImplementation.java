package SecurityManagementBackend.Backend.Service.FamilyService;

import SecurityManagementBackend.Backend.Exception.FamilyNotFoundException;
import SecurityManagementBackend.Backend.Exception.FlatAlreadyAssignedException;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Repositry.FamilyRepo;
import SecurityManagementBackend.Backend.Repositry.FlatRepo;
import SecurityManagementBackend.Backend.Service.FamilyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceInterfaceImplementation implements FamilyServiceInterface {

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    FlatRepo flatRepo;

    @Override
    public void createNewFamily(Family family) {

        String flatNumber = family.getFlat().getFlatNumber();
        int value = flatRepo.isFlatExist(flatNumber);

        if(value > 0){
            throw new FlatAlreadyAssignedException(flatNumber , "This Flat is already occupied by some other family");
        }
        familyRepo.save(family);
    }

    @Override
    public List<Family> getAllFamily() {
        return familyRepo.findAll();
    }

    @Override
    public Optional<Family> getFamilyById(Long familyId) {
         Optional<Family> getFamily = familyRepo.findById(familyId);
        if(getFamily.isEmpty()) throw new FamilyNotFoundException(familyId , "The Family Of This Id didnt't Exist");
        return getFamily;
    }

    @Override
    public Family updateFamily(Long familyId , Family updateFamilyProfile) {
        Family getFamily = familyRepo.findById(familyId).orElseThrow(() ->  new FamilyNotFoundException(familyId,"This Family Id does'nt Exist"));
        getFamily.setFamilyName(updateFamilyProfile.getFamilyName());
        getFamily.setFlat(updateFamilyProfile.getFlat());
        getFamily.setFamilyName(updateFamilyProfile.getFamilyName());

        return getFamily;

    }
}
