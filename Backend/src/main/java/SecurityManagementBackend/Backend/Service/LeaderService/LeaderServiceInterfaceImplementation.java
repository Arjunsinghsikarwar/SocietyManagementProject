package SecurityManagementBackend.Backend.Service.LeaderService;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Exception.*;
import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Leader;
import SecurityManagementBackend.Backend.Repositry.FamilyRepo;
import SecurityManagementBackend.Backend.Repositry.LeaderRepo;
import SecurityManagementBackend.Backend.Repositry.MemberRepo;
import SecurityManagementBackend.Backend.Service.LeaderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderServiceInterfaceImplementation implements LeaderServiceInterface {
    @Autowired
    LeaderRepo leaderRepo;

    @Autowired
    FamilyRepo familyRepo;

    @Autowired
    MemberRepo memberRepo;



    @Override
    public LeaderDto createNewLeader(Leader leader){
        boolean isExist = leaderRepo.existsByUserName(leader.getUserName());

        if(isExist)
           throw new LeaderAlreadyExistException("This Leader Is Already Assigned to Another Family");

        Leader savedLeader  = leaderRepo.save(leader);
        LeaderDto leaderDto = new LeaderDto();
        leaderDto.setFamilyId(savedLeader.getFamily() != null ? savedLeader.getFamily().getFamilyId() : null );
        leaderDto.setUserName(savedLeader.getUserName());
        leaderDto.setId(savedLeader.getId());
        leaderDto.setRole(savedLeader.getRole());
        return leaderDto;
    }

    @Override
    public LeaderDto getFullProfileOfLeader(Long leaderId) {
        Leader leader = leaderRepo.findById(leaderId).orElseThrow(() -> new LeaderDoesNotExist(leaderId));
        LeaderDto leaderDto = new LeaderDto(leader);
        return leaderDto;
    }

    @Override
    public List<Family> getLeaderFamily(Long leaderId) {
        Leader leader = leaderRepo.findById(leaderId).orElseThrow(() -> new LeaderDoesNotExist(leaderId));
        List<Family> getAllFamily = familyRepo.getSameFamilyLeader(leaderId);
        return getAllFamily;
    }

    @Override
    public void removeMemberFromFamily(Long leaderId, Long memberId) {
        getFullProfileOfLeader(leaderId); // just to make sure does this id leader even exist
        memberRepo.deleteById(memberId);
    }




}
