package SecurityManagementBackend.Backend.Exception;

public class LeaderDoesNotExist extends RuntimeException{
    Long id;
    public LeaderDoesNotExist(Long id){
        super("This Leader Does Not Exist");
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }
}
