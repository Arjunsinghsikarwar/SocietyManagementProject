package SecurityManagementBackend.Backend.Service.ComplaintService;

import SecurityManagementBackend.Backend.Exception.FamilyNotFoundException;
import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Repositry.ComplaintRepo;
import SecurityManagementBackend.Backend.Repositry.MemberRepo;
import SecurityManagementBackend.Backend.Service.ComplaintServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceInterfaceImplementation implements ComplaintServiceInterface {

    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public List<Complaint> getAllComplainsForSingleFamily(Long familyId) {
        return  complaintRepo.getAllComplaintBySingleFamily(familyId);
    }

    @Override
    public List<Complaint> getComplaintForEachMember(Long memberId){
       Member member  = memberRepo.findById(memberId).orElseThrow(()-> new FamilyNotFoundException(memberId,"This Memeber Does not exist"));
        return complaintRepo.getComplaintForEachMember(memberId);
    }

    @Override
    public void removeAllComplaintForEachMember(Long memberId) {
        complaintRepo.removeAllComplainForMember(memberId);
    }

    @Override
    public Complaint addNewComplaint(Complaint complaint, Long memberId) {
        Member member = memberRepo.findById(memberId).orElseThrow(()-> new FamilyNotFoundException(memberId,"This Member Does Not Exist"));
        Complaint complaint1 = new Complaint();
        complaint1.setDescription(complaint.getDescription());
        complaint1.setMember(complaint.getMember());

       return complaintRepo.save(complaint1);
    }


}
