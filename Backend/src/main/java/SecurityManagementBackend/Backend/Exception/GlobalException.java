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

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of("message" , f.getMessage()
                , "flatNumber" , f.getFlatNumber())
        );
    }


    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<Map<String , Object>> familyNotFoundException(FamilyNotFoundException f){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("message",f.getMessage(),
                        "familyId",f.getFamilyId())
        );
    }


}
