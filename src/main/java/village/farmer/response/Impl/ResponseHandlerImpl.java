package village.farmer.response.Impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import village.farmer.response.ResponseHandler;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ResponseHandlerImpl implements ResponseHandler {

    @Override
    public ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus) {
        /*
        {
            "success": true,
            "message": "Successfully created user",
            "timestamp": "2020-12-01T10:10:10.000+07:00[Asia/Bangkok]"
        }
         */
        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", message);
        response.put("timestamp", currentTime);

        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {
        /*
        {
            "success": true,
            "message": "Successfully created user",
            "timestamp": "2020-12-01T10:10:10.000+07:00[Asia/Bangkok]",
            "data": {
                "id": 1,
                "username": "user",
                "email": "user@mail.com"
            }
         }
         */
        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", message);
        response.put("timestamp", currentTime);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);

    }

    @Override
    public ResponseEntity<Object> errorResponseBuilder(String message, HttpStatus httpStatus) {
        /*
        {
            "success": false,
            "message": "Username is already taken!",
            "timestamp": "2020-12-01T10:10:10.000+07:00[Asia/Bangkok]"
        }
         */
        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", false);
        response.put("message", message);
        response.put("timestamp", currentTime);

        return new ResponseEntity<>(response, httpStatus);
    }

}
