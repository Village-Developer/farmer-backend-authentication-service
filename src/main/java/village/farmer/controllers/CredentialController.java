package village.farmer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.model.GenericsResponse;
import village.farmer.model.GenericsResponseModel;
import village.farmer.model.request.LoginRequest;
import village.farmer.model.request.RegisterRequest;
import village.farmer.model.response.LoginResponse;
import village.farmer.response.ResponseHandler;
import village.farmer.service.LoginService;
import village.farmer.service.RegisterService;
import village.farmer.service.etc.Jwt;
import village.farmer.statics.ErrorResponseReturnHandle;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class CredentialController {

    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @Autowired
    Jwt jwt;

    @Autowired
    ResponseHandler responseHandler;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> Login (@RequestBody LoginRequest request) {
        GenericsResponse response = loginService.login(request);
        return response.getStatus() == 200
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()), response.getData())
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register (@RequestBody RegisterRequest request) {
        GenericsResponse response = registerService.registerUser(request);
        return response.getStatus() == 201
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()))
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }

    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify (@RequestHeader String Authorization) throws Exception {
        GenericsResponse response = jwt.jwtVerify(Authorization);
        return response.getStatus() == 200
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()))
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }
}
