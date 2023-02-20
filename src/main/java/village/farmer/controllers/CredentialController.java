package village.farmer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import village.farmer.documents.response.fail.BadRequestResponse;
import village.farmer.documents.response.success.LoginResponse;
import village.farmer.documents.response.success.RegisterResponse;
import village.farmer.documents.response.success.VerifyResponse;
import village.farmer.dto.VerifyDTO;
import village.farmer.model.GenericsResponse;
import village.farmer.dto.LoginDTO;
import village.farmer.dto.RegisterDTO;
import village.farmer.response.ResponseHandler;
import village.farmer.service.LoginService;
import village.farmer.service.RegisterService;
import village.farmer.service.etc.Jwt;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
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

    @Operation(summary = "Login", description = "Login to get access token", tags = {"Authentication"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "login success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponse.class))}),
    })
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> Login (@RequestBody LoginDTO body) {
        GenericsResponse response = loginService.login(body);
        return response.getStatus() == 200
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()), response.getData())
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Register", description = "Register user", tags = {"Registration"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Register Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = RegisterResponse.class))}),
    })
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register (@RequestBody RegisterDTO body) {
        GenericsResponse response = registerService.registerUser(body);
        return response.getStatus() == 201
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()))
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }

    @Operation(summary = "Verify access token", description = "Verify access token from login", tags = {"Authentication"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "verify success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = VerifyResponse.class))}),
    })
    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<?> verify (@RequestBody VerifyDTO body) throws Exception {
        GenericsResponse response = jwt.jwtVerify(body.getToken());
        ArrayList<String> r = new ArrayList<>();
        return response.getStatus() == 200
                ? responseHandler.responseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()))
                : responseHandler.errorResponseBuilder(response.getMsg(), HttpStatus.valueOf(response.getStatus()));
    }
}
