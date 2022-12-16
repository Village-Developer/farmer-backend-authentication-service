package village.farmer.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseHandler {

    public ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus);

    public ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject);

}
