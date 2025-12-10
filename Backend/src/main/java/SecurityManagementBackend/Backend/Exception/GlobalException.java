package SecurityManagementBackend.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(FlatAlreadyAssignedException.class)
    public ResponseEntity<Map<String , Object>> flatAllReadyAssignedException(FlatAlreadyAssignedException f){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("message" , f.getMessage()
                , "flatNumber" , f.getFlatNumber())
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "status", "error",
                        "message", ex.getMessage()
                )
        );
    }



    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<Map<String , Object>> familyNotFoundException(FamilyNotFoundException f){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("message",f.getMessage(),
                        "familyId",f.getFamilyId())
        );
    }

    @ExceptionHandler(ThisMemberDoNotExist.class)
    public ResponseEntity<Map<String , Object>> memberDoNotExist(ThisMemberDoNotExist ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message",ex.getMessage()
        ,"memberId",ex.getMemberId()));
    }

    @ExceptionHandler(LeaderAlreadyExistException.class)
    public ResponseEntity<Map<String,String>> leaderAlreadyExist(LeaderAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "message" , ex.getMessage()
        ));
    }

    @ExceptionHandler(LeaderDoesNotExist.class)
    public ResponseEntity<Map<String , Object>> leaderDoesNotExist(LeaderDoesNotExist ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "message" , "Leader Of This " + ex.getId() + " Does Not exist"
        ));
    }

    @ExceptionHandler(LeaderAlreadyAssignedException.class)
    public ResponseEntity<Map<String , Object>> leaderAlreadyAssignedException(LeaderAlreadyAssignedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "message" , ex.getMessage(),
                "leaderId" , ex.getId()
        ));
    }

    @ExceptionHandler(FamilyAlreadyAssignedException.class)
    public ResponseEntity<Map<String , Object>> familyAlreadyAssignedException(FamilyAlreadyAssignedException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message" , ex.getMessage()));
    }

    @ExceptionHandler(UserDoNotExistException.class)
    public ResponseEntity<Map<String , String>> userDoNotExist(UserDoNotExistException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()
        ,"userName" , ex.getUserName()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Map<String , String>> userAlreadyExistException(UserAlreadyExistException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
                "message" , ex.getMessage()
        ));
    }

}
