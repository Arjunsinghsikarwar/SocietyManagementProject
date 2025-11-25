package SecurityManagementBackend.Backend.Service;

import SecurityManagementBackend.Backend.Model.Complaint;

import java.util.List;

public interface ComplaintServiceInterface {
    public List<Complaint> getAllComplainsForSingleFamily(Long familyId);

    List<Complaint> getComplaintForEachMember(Long memberId);

    void removeAllComplaintForEachMember(Long memberId);
}
