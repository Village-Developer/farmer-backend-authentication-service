package village.farmer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.response.ResponseHandler;
import village.farmer.service.ApiDocumentService;

@RestController
@RequestMapping("/api/api_document/")
@CrossOrigin(origins="*")
public class ApiDocumentController {

    @Autowired
    ResponseHandler responseHandler;

    @Autowired
    ApiDocumentService apiDocumentService;

    @GetMapping("/api_group/api_list/{api_list_id}")
    public ResponseEntity<Object> getByApiList(@PathVariable("api_list_id") Integer api_list_id) {

        return responseHandler.responseBuilder("success", HttpStatus.OK, apiDocumentService.getByApiId(api_list_id));
    }

}
