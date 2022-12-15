package village.farmer.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {

        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", httpStatus);
        response.put("message", message);
        response.put("timestamp", currentTime);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);

    }
}
