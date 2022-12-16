package village.farmer.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.entity.ApiDocumentGroup;
import village.farmer.model.ApiDocumentGroupDTO;
import village.farmer.response.ResponseHandler;
import village.farmer.service.ApiDocumentGroupService;
import village.farmer.service.AuthorizationService;

@RestController
@RequestMapping("/api/api_document/")
@CrossOrigin(origins="*")
public class ApiDocumentGroupController {

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ApiDocumentGroupService apiDocumentGroupService;

    @Autowired
    ResponseHandler responseHandler;

    @PostMapping("/api_group")
    public ResponseEntity<Object> addApiGroup(@RequestHeader("Authorization") String token, @RequestBody ApiDocumentGroupDTO apiDocumentGroupDTO) throws Exception {

        String authorization = authorizationService.checkToken(token);

        if(authorization == null) {

            return responseHandler.responseBuilder("Unauthorized", HttpStatus.UNAUTHORIZED);

        } else {

            ApiDocumentGroup apiDocumentGroup = modelMapper.map(apiDocumentGroupDTO, ApiDocumentGroup.class);

            return responseHandler.responseBuilder("success", HttpStatus.OK, apiDocumentGroupService.addGroupApi(apiDocumentGroup));

        }



    }

    @GetMapping("/api_group")
    public ResponseEntity<Object> getAllApiGroup() {

        return responseHandler.responseBuilder("success", HttpStatus.OK, apiDocumentGroupService.getAllApiGroup());

    }
}
