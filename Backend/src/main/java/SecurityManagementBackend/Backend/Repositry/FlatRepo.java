package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {

    @Query(value = "Select count(*) from flat f where f.flat_number = :flatNumber ",nativeQuery = true)
    int isFlatExist(@Param("flatNumber") String flatNumber);
}
