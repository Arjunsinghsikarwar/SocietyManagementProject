package SecurityManagementBackend.Backend.Exception;


public class FamilyNotFoundException extends RuntimeException{

    private Long familyId;

    public FamilyNotFoundException(Long familyId , String message){
        super(message);
        this.familyId = familyId;
    }


    public Long getFamilyId(){
        return this.familyId;
    }



}
