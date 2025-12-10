package SecurityManagementBackend.Backend.Exception;

public class LeaderAlreadyExistException extends RuntimeException{

    public LeaderAlreadyExistException(String message){
        super(message);
    }
}
