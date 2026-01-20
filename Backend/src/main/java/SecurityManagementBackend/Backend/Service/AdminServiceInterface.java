package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Dtos.LeaderDto;
import SecurityManagementBackend.Backend.Model.Family;
import org.jspecify.annotations.Nullable;

public interface AdminServiceInterface {

    public Family createNewFamily(Family family);

   public Family assigningAllInfoToFamily(Family family,Long familyId);

    public Family getFamily(Long familyId);
}
