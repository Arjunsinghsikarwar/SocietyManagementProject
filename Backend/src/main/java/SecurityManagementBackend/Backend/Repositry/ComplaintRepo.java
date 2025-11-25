package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint,Long> {
}
