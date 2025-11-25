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
    private int age;
    private String role;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL , orphanRemoval = true)
   private List<Complaint> complaintList = new ArrayList<>();

    public Member() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setId(Long id) {
        this.id = id;
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

    public Member(int age, List<Complaint> complaintList, Family family, Long id, String name, String role) {
        this.age = age;
        this.complaintList = complaintList;
        this.family = family;
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", family=" + family +
                ", complaintList=" + complaintList +
                '}';
    }
}
