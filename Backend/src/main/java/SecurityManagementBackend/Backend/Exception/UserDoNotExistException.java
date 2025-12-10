package SecurityManagementBackend.Backend.Exception;


public class UserDoNotExistException extends RuntimeException{

    private String userName;

    public UserDoNotExistException(String userName){
        super("This User Do not Exist");
        this.userName = userName;
    }

     public String getUserName()
    {
        return userName;
    }

}
