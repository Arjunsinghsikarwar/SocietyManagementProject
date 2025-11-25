package SecurityManagementBackend.Backend.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;

    private String familyName;

    @OneToOne(mappedBy = "family",cascade = CascadeType.ALL,orphanRemoval = true)
    private Flat flat;

    @OneToMany(mappedBy = "family",cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Member> memberList = new ArrayList<>();

    public Family() {
    }

    public Family(Long familyId, String familyName, Flat flat, List<Member> memberList) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.flat = flat;
        this.memberList = memberList;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
}
