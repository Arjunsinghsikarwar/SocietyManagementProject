package SecurityManagementBackend.Backend.Exception;

public class FamilyAlreadyAssignedException extends RuntimeException{

    public FamilyAlreadyAssignedException(String message){
        super(message);
    }
}
