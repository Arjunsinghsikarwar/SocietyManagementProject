package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Leader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderRepo extends JpaRepository<Leader,Long> {
    boolean existsByUserName(String userName);
}
