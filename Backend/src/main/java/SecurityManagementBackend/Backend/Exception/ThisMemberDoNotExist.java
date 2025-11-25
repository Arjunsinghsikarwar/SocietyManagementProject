package SecurityManagementBackend.Backend.Exception;

public class ThisMemberDoNotExist extends RuntimeException{

    private Long memberId;

    public ThisMemberDoNotExist(Long memberId , String  message){
        super(message);
        this.memberId = memberId;
    }

    public Long getMemberId(){
       return  this.memberId ;
    }
}
