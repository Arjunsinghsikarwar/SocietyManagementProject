package SecurityManagementBackend.Backend.Service.AdminService;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Exception.FamilyNotFoundException;
import SecurityManagementBackend.Backend.Exception.LeaderAlreadyAssignedException;
import SecurityManagementBackend.Backend.Exception.LeaderDoesNotExist;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Flat;
import SecurityManagementBackend.Backend.Model.Leader;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Repositry.FamilyRepo;
import SecurityManagementBackend.Backend.Repositry.FlatRepo;
import SecurityManagementBackend.Backend.Repositry.LeaderRepo;
import SecurityManagementBackend.Backend.Repositry.MemberRepo;
import SecurityManagementBackend.Backend.Service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class AdminServiceInterfaceImplementation implements AdminServiceInterface {

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private LeaderRepo leaderRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Family createNewFamily(Family family) {

        if (family.getFamilyName().length() == 0)
            throw new IllegalArgumentException("Family Name Should not empty");

        return familyRepo.save(family);
    }

    public Family assigningAllInfoToFamily(Family family, Long familyId) {

        Family family1 = familyRepo.findById(familyId)
                .orElseThrow(() -> new FamilyNotFoundException(
                        familyId, "This Family Does not Exist"));


        Leader leader = leaderRepo.findById(family.getLeader().getId())
                .orElseThrow(() -> new RuntimeException("Cant Find This Leader"));

        leader.setFamily(family1);
        family1.setLeader(leader);


        Flat flat = flatRepo.findByFlatNumber(family.getFlat().getFlatNumber());
        if (flat == null) {
            throw new RuntimeException("Flat not found");
        }

        flat.setFamily(family1);
        family1.setFlat(flat);


        family1.getMemberList().clear();
        for (Member member : family.getMemberList()) {
            Member existingMember = memberRepo.findById(member.getId())
                    .orElseThrow(() -> new RuntimeException("Member not found"));

            existingMember.setFamily(family1);
            family1.getMemberList().add(existingMember);
        }


        return familyRepo.save(family1);

    }

    @Override
    public Family getFamily(Long familyId) {
        Family family = familyRepo.findById(familyId).orElseThrow(()-> new FamilyNotFoundException(familyId , "This Family I not Exist"));
        return family;
    }
}