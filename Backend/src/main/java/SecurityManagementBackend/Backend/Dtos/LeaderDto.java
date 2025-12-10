package SecurityManagementBackend.Backend.Dtos;

import SecurityManagementBackend.Backend.Model.Family;
import SecurityManagementBackend.Backend.Model.Leader;

public class LeaderDto {

    private Long id;
    private String userName;
    private String role;
    private Long familyId;


    public LeaderDto() {
    }

    public LeaderDto(Long id, String userName, String role, Long familyId) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.familyId = familyId;
    }

    public LeaderDto(Leader leader){
        this.id = leader.getId();
        this.userName = leader.getUserName();
        this.role = leader.getRole();
        if( leader.getFamily()!=null && leader.getFamily().getFamilyId()!=null)
            this.familyId = leader.getFamily().getFamilyId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }
}
