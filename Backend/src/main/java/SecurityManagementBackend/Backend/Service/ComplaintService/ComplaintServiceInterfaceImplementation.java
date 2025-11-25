package SecurityManagementBackend.Backend.Service.ComplaintService;

import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Repositry.ComplaintRepo;
import SecurityManagementBackend.Backend.Service.ComplaintServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceInterfaceImplementation implements ComplaintServiceInterface {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Override
    public List<Complaint> getAllComplainsForSingleFamily(Long familyId) {
        return  complaintRepo.getAllComplaintBySingleFamily(familyId);
    }

    @Override
    public List<Complaint> getComplaintForEachMember(Long memberId){
        return complaintRepo.getComplaintForEachMember(memberId);
    }

    @Override
    public void removeAllComplaintForEachMember(Long memberId) {
        complaintRepo.removeAllComplainForMember(memberId);
    }


}
