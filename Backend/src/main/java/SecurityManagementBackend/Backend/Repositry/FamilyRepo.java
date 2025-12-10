package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyRepo extends JpaRepository<Family,Long> {
    @Query("SELECT f FROM Family f WHERE f.leader.id = :leaderId")
    List<Family> getSameFamilyLeader(@Param("leaderId") Long leaderId);

}
