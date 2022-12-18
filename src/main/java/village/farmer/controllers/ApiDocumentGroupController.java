package village.farmer.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import village.farmer.entity.ApiDocumentGroup;
import village.farmer.model.ApiDocumentGroupDTO;
import village.farmer.response.ResponseHandler;
import village.farmer.service.ApiDocumentGroupService;
import village.farmer.service.AuthorizationService;

import javax.validation.Valid;
import java.util.Objects;

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
    public ResponseEntity<Object> addApiGroup(@RequestHeader("Authorization") String token, @Valid @RequestBody ApiDocumentGroupDTO apiDocumentGroupDTO, Errors errors) throws Exception {

        String authorization = authorizationService.checkToken(token);

        if(errors.hasErrors()) {

            return responseHandler.responseBuilder(errors., HttpStatus.OK);
        }

        else if(!Objects.equals(authorization, "Token is valid")) {

            return responseHandler.responseBuilder(authorization, HttpStatus.UNAUTHORIZED);

        } else {

            ApiDocumentGroup apiDocumentGroup = modelMapper.map(apiDocumentGroupDTO, ApiDocumentGroup.class);

            return responseHandler.responseBuilder("success", HttpStatus.CREATED, apiDocumentGroupService.addGroupApi(apiDocumentGroup));

        }

    }

    @GetMapping("/api_group")
    public ResponseEntity<Object> getAllApiGroup() {

        return responseHandler.responseBuilder("success", HttpStatus.OK, apiDocumentGroupService.getAllApiGroup());

    }
}
