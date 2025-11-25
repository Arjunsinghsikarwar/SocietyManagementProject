package SecurityManagementBackend.Backend.Exception;

public class FlatAlreadyAssignedException extends RuntimeException{

    private String flatNumber ;

    public FlatAlreadyAssignedException(String flatNumber , String message) {
        super(message);
        this.flatNumber = flatNumber;
    }

    public String getFlatNumber(){
        return this.flatNumber;
    }
}
