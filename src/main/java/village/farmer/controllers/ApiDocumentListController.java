package village.farmer.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.entity.ApiDocumentList;
import village.farmer.model.ApiDocumentListDTO;
import village.farmer.response.ResponseHandler;
import village.farmer.service.ApiDocumentListService;

@RestController
@RequestMapping("/api/api_document")
@CrossOrigin(origins = "*")
public class ApiDocumentListController {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ApiDocumentListService apiDocumentListService;

    @PostMapping("/api_group/{api_group_id}")
    public ResponseEntity<Object> addApiList(@PathVariable("api_group_id") Integer apiGroupId, @RequestBody ApiDocumentListDTO apiDocumentListDTO) {

        apiDocumentListDTO.setApiGroupId(apiGroupId);

        ApiDocumentList apiDocumentList = modelMapper.map(apiDocumentListDTO, ApiDocumentList.class);

        return ResponseHandler.responseBuilder("success", HttpStatus.CREATED, apiDocumentListService.addListApi(apiDocumentList));
    }

}
