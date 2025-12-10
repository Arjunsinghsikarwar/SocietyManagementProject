package SecurityManagementBackend.Backend.Exception;

public class LeaderAlreadyAssignedException extends RuntimeException {

    private Long id;

    public LeaderAlreadyAssignedException(Long id , String message){
        super(message);
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }
}
