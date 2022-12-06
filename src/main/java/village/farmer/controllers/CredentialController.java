package village.farmer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.model.GenericsResponse;
import village.farmer.model.request.LoginRequest;
import village.farmer.model.request.RegisterRequest;
import village.farmer.model.response.LoginResponse;
import village.farmer.service.LoginService;
import village.farmer.service.RegisterService;
import village.farmer.statics.ErrorResponseReturnHandle;

import static javax.print.PrintServiceLookup.registerService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class CredentialController {

    @Autowired
    LoginService loginService;
    @Autowired
    RegisterService registerService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<LoginResponse> Login (@RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse();
        try {
            response = loginService.login(request);
        } catch (Exception e) {
            response.setMsg(e.getMessage());
        }
        HttpStatus httpStatus = ErrorResponseReturnHandle.getStatus(response.getMsg());
        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register (@RequestBody RegisterRequest request) {
        GenericsResponse response = new GenericsResponse();
        try {
            response = registerService.registerUser(request);
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsg("Err: "+e.getMessage());
        }
        HttpStatus httpStatus = ErrorResponseReturnHandle.getStatus(response.getMsg());
        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }
}
