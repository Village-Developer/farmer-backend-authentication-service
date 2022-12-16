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

        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", httpStatus.value());
        response.put("message", message);
        response.put("timestamp", currentTime);

        return new ResponseEntity<>(response, httpStatus);
    }

    @Override
    public ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject) {

        Instant nowUtc = Instant.now();
        ZoneId asiaBangkok = ZoneId.of("Asia/Bangkok");
        ZonedDateTime currentTime = ZonedDateTime.ofInstant(nowUtc, asiaBangkok);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", httpStatus.value());
        response.put("message", message);
        response.put("timestamp", currentTime);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);

    }

}
