package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepo extends JpaRepository<Family,Long> {
}
