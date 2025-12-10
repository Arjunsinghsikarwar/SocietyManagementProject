package SecurityManagementBackend.Backend.Service.FamilyService;

import SecurityManagementBackend.Backend.Exception.FamilyNotFoundException;
import SecurityManagementBackend.Backend.Exception.FlatAlreadyAssignedException;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Repositry.FamilyRepo;
import SecurityManagementBackend.Backend.Repositry.FlatRepo;
import SecurityManagementBackend.Backend.Service.FamilyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceInterfaceImplementation implements FamilyServiceInterface {

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    FlatRepo flatRepo;


    @Override
    public List<Family> getAllFamily() {
        return familyRepo.findAll();
    }

    @Override
    public Family getFamilyById(Long familyId) {
        return familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException(familyId,"This Family Does not Exist"));
    }

    @Override
    public Family updateFamily(Long familyId , Family updateFamilyProfile) {
        Family getFamily = familyRepo.findById(familyId).orElseThrow(() ->  new FamilyNotFoundException(familyId,"This Family Id does'nt Exist"));
        getFamily.setFamilyName(updateFamilyProfile.getFamilyName());
        getFamily.setFlat(updateFamilyProfile.getFlat());
        getFamily.setMemberList(updateFamilyProfile.getMemberList());
        familyRepo.save(getFamily);

        return getFamily;

    }

    @Override
    public void deleteFamilyById(Long familyId) {
      getFamilyById(familyId);
      familyRepo.deleteById(familyId);
    }

    @Override
    public void addFamilyMembers(List<Member> memberList, Long familyId) {
       Family family  = getFamilyById(familyId);
       List<Member> familyMemberList  =  family.getMemberList();
       memberList.forEach(value -> {
           value.setFamily(family);
           familyMemberList.add(value);
       });
       family.setMemberList(familyMemberList);
       familyRepo.save(family);
    }

    @Override
    public List<Member> getAllFamilyMemebers(Long familyId) {
        Family family  = getFamilyById(familyId);
        List<Member> memberList = new ArrayList<>();
        family.getMemberList().forEach(member -> memberList.add(member));
        return memberList;
    }
}
