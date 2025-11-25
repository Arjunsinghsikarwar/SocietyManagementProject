package SecurityManagementBackend.Backend.Service.MemberService;

import SecurityManagementBackend.Backend.Exception.ThisMemberDoNotExist;
import SecurityManagementBackend.Backend.Model.Complaint;
import SecurityManagementBackend.Backend.Model.Member;
import SecurityManagementBackend.Backend.Repositry.ComplaintRepo;
import SecurityManagementBackend.Backend.Repositry.MemberRepo;
import SecurityManagementBackend.Backend.Service.MemberServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceInterfaceImplementation implements MemberServiceInterface {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private ComplaintRepo complaintRepo;

    @Override
    public Member getSingleMember(Long memberId) {
        return memberRepo.findById(memberId).orElseThrow(() -> new ThisMemberDoNotExist(memberId,"This Member Does not Exist"));
    }

    @Override
    public void updateSingleMemberById(Long memberId , Member member) {
      Member getMember = getSingleMember(memberId);
      getMember.setAge(member.getAge());
      getMember.setFamily(member.getFamily());
      getMember.setName(member.getName());
      getMember.setComplaintList(member.getComplaintList());

      memberRepo.save(getMember);

    }

    @Override
    public void removeMeberById(Long memberId) {
        getSingleMember(memberId);
        memberRepo.deleteById(memberId);
    }

    @Override
    public List<Complaint> getAllComplainsForSingleMember(Long memberId) {
       Member member = getSingleMember(memberId);
       List<Complaint> complaintList = complaintRepo.getAllComplaintforSingleMember(memberId);
       return complaintList;
    }


}
