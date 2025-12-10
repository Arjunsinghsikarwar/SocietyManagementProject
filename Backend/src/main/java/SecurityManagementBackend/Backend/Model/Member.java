package SecurityManagementBackend.Backend.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    private String password;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true)
   private List<Complaint> complaintList = new ArrayList<>();

    public Member() {
    }



    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member(List<Complaint> complaintList, Family family , String name, String role , String password) {

        this.complaintList = complaintList;
        this.family = family;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", family=" + family +
                ", complaintList=" + complaintList +
                '}';
    }
}
