package SecurityManagementBackend.Backend.Model;

import jakarta.persistence.*;

@Entity
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String flatNumber;


    @OneToOne
    @JoinColumn(name = "family_id")
    private Family family;

    public Flat() {
    }

    public Flat(Family family, String flatNumber) {
        this.family = family;
        this.flatNumber = flatNumber;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "family=" + family +
                ", id=" + id +
                ", flatNumber='" + flatNumber + '\'' +
                '}';
    }
}
