package SecurityManagementBackend.Backend.Model;

import jakarta.persistence.*;


@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Complaint() {
    }

    public Complaint(String description, Long id, Member member) {
        this.description = description;
        this.id = id;
        this.member = member;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", member=" + member +
                '}';
    }
}

//
//orphanRemoval removes children when:
//
//You remove them from a list
//
//Or you set them to null
//
//Or you break the relationship