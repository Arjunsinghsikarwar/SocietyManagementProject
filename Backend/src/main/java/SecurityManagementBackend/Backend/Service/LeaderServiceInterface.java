package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;

import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Leader;

import java.util.List;


public interface LeaderServiceInterface {
    LeaderDto createNewLeader(Leader leader);

    LeaderDto getFullProfileOfLeader(Long leaderId);

    List<Family> getLeaderFamily(Long leaderId);

    void removeMemberFromFamily(Long leaderId, Long memberId);
}
