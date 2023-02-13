package village.farmer.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseHandler {

    ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus);

    ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject);

    ResponseEntity<Object> errorResponseBuilder(String message, HttpStatus httpStatus);

}
