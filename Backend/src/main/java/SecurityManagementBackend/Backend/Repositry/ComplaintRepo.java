package SecurityManagementBackend.Backend.Repositry;

import SecurityManagementBackend.Backend.Model.Complaint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint,Long> {
    @Query(value = "SELECT * from complaint c where c.member_id = :memberId ",nativeQuery = true)
    List<Complaint> getAllComplaintforSingleMember(@Param("memberId") Long memberId);

    @Query(value = "Select c.* from complaint c inner join member m on c.member_id = m.id where m.family_id = :familyId ",nativeQuery = true)
    List<Complaint> getAllComplaintBySingleFamily(@Param("familyId") Long familyId);

    @Query(value = "SELECT c.* from complaint c where c.member_id  = :memberId" ,nativeQuery = true)
    List<Complaint> getComplaintForEachMember(@Param("memberId") Long memberId);

    @Modifying
    @Transactional
    @Query(value = "Delete from complaint c  where c.member_id = :memberId " ,nativeQuery = true)
    void removeAllComplainForMember(@Param(("memberId")) Long memberId);
}
