package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Model.Family;

public interface AdminServiceInterface {

    public Family createNewFamily(Family family);

    LeaderDto assigningLeaderToFamily(Long leaderId, Long familyId);
}
