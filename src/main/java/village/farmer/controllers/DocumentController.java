package village.farmer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.model.response.DocCtrlResponse;
import village.farmer.statics.ErrorResponseReturnHandle;

@RestController
@RequestMapping("/doc")
@CrossOrigin(origins = "*")
public class DocumentController {

    @GetMapping("/list/ctrl")
    @ResponseBody
    public ResponseEntity<?> listController () {
        DocCtrlResponse response = new DocCtrlResponse();
        try {

        } catch (Exception e) {

        }
        HttpStatus httpStatus = ErrorResponseReturnHandle.getStatus(response.getMsg());
        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }
}
