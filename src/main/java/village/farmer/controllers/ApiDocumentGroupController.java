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

@RestController
@RequestMapping("/api/api_document/")
@CrossOrigin(origins="*")
public class ApiDocumentGroupController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ApiDocumentGroupService apiDocumentGroupService;

    @PostMapping("/api_group")
    public ResponseEntity<Object> addApiGroup(@RequestBody ApiDocumentGroupDTO apiDocumentGroupDTO) {

        ApiDocumentGroup apiDocumentGroup = modelMapper.map(apiDocumentGroupDTO, ApiDocumentGroup.class);

        return ResponseHandler.responseBuilder("success", HttpStatus.CREATED, apiDocumentGroupService.addGroupApi(apiDocumentGroup));

    }

    @GetMapping("/api_group")
    public ResponseEntity<Object> getAllApiGroup() {

        return ResponseHandler.responseBuilder("success", HttpStatus.OK, apiDocumentGroupService.getAllApiGroup());

    }
}
