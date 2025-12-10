package SecurityManagementBackend.Backend.Model;


import jakarta.persistence.*;


@Entity
public class Leader{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String role;


    @OneToOne
    @JoinColumn(name = "family_id")
    Family family;


    public Leader() {
    }

    public Leader(String password, String role, String userName , Family family) {
        this.password = password;
        this.role = role;
        this.userName = userName;
        this.family = family;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
