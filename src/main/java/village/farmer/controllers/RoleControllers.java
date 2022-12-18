package village.farmer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.model.GenericsResponseModel;
import village.farmer.model.request.DeleteRoleRequest;
import village.farmer.model.request.EditRoleRequest;
import village.farmer.service.RoleManagementService;
import village.farmer.statics.ErrorResponseReturnHandle;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleControllers {

    @Autowired
    RoleManagementService roleManagementService;

//    @PostMapping("/edit")
//    @ResponseBody
//    public ResponseEntity<GenericsResponseModel> edit (@RequestHeader("Authorization") String token, @RequestBody EditRoleRequest request) {
//        GenericsResponseModel response = new GenericsResponseModel();
//        try {
//            response = roleManagementService.edit(token, request);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setMsg(e.getMessage());
//        }
//        HttpStatus httpStatus = ErrorResponseReturnHandle.getStatus(response.getMsg());
//        return ResponseEntity
//                .status(httpStatus)
//                .body(response);
//    }
//
//    @DeleteMapping("/delete")
//    @ResponseBody
//    public ResponseEntity<GenericsResponseModel> delete (@RequestHeader("Authorization") String token, @RequestBody DeleteRoleRequest request) {
//        GenericsResponseModel response = new GenericsResponseModel();
//        try {
//            response = roleManagementService.delete(token,request);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setMsg(e.getMessage());
//        }
//        HttpStatus httpStatus = ErrorResponseReturnHandle.getStatus(response.getMsg());
//        return ResponseEntity
//                .status(httpStatus)
//                .body(response);
//    }
}
