package SecurityManagementBackend.Backend.Service.AdminService;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Exception.FamilyNotFoundException;
import SecurityManagementBackend.Backend.Exception.LeaderAlreadyAssignedException;
import SecurityManagementBackend.Backend.Exception.LeaderDoesNotExist;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Flat;
import SecurityManagementBackend.Backend.Model.Leader;
import SecurityManagementBackend.Backend.Repositry.FamilyRepo;
import SecurityManagementBackend.Backend.Repositry.FlatRepo;
import SecurityManagementBackend.Backend.Repositry.LeaderRepo;
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

    @Override
    public Family createNewFamily(Family family) {

        String flatNumber = family.getFlat().getFlatNumber();
        Flat flat = flatRepo.findByFlatNumber(flatNumber);

        if (flat != null && flat.getFamily() != null) {
            throw new RuntimeException(
                    "This flat " + flatNumber + " already belongs to Family: "
                            + flat.getFamily().getFamilyName()
            );
        }

        return familyRepo.save(family);
    }

    @Override
    public LeaderDto assigningLeaderToFamily(Long leaderId, Long familyId) {
       Family family = familyRepo.findById(familyId).orElseThrow(() -> new FamilyNotFoundException(familyId,"This Family Is Not Exist"));

       if(family.getLeader()!=null)
           throw new LeaderAlreadyAssignedException(family.getLeader().getId(),"This Leader Is Already Been Assigned For This Family");

        Leader leader = leaderRepo.findById(leaderId).orElseThrow(() -> new LeaderDoesNotExist(leaderId));

        family.setLeader(leader);
        leader.setFamily(family);

        familyRepo.save(family);
        leaderRepo.save(leader);

        LeaderDto leaderDto = new LeaderDto(leader);

        return leaderDto;



    }
}
