package SecurityManagementBackend.Backend.Service;


import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Model.Member;

import java.util.List;

public interface MemberServiceInterface {

    Member getSingleMember(Long memberId);

    void updateSingleMemberById(Long memberId,Member member);

    void removeMeberById(Long memberId);

    List<Complaint> getAllComplainsForSingleMember(Long memberId);
}