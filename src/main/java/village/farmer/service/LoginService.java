package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.Credential;
import village.farmer.entity.User;
import village.farmer.model.GenericsResponse;
import village.farmer.model.request.LoginRequest;
import village.farmer.model.response.LoginResponse;
import village.farmer.repository.CredentialRepository;
import village.farmer.repository.UserRepository;
import village.farmer.service.etc.Hash;
import village.farmer.service.etc.Jwt;
import village.farmer.statics.ErrorResponseReturnHandle;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Jwt jwt;
    @Autowired
    Hash hash;
    public GenericsResponse login (LoginRequest data){
        GenericsResponse response = new GenericsResponse();
        try {
            Credential credential = credentialRepository.findByUsername(data.getUsername());
            if (credential == null) {
                response.setStatus(401);
                response.setMsg("User not found");
                throw new Exception("User not found");
            }
            else if (!hash.sha256Hash(data.getPassword()).equals(credential.getPassword())) {
                response.setStatus(401);
                response.setMsg("Invalid password");
                throw new Exception("Invalid password");
            }
            response.setStatus(200);
            response.setMsg("Login success");
            LoginResponse loginResponse = new LoginResponse();
            User user = userRepository.findByCredential(credential);
            if (Objects.equals(user.getRole().getRoleName(), "admin")) {
                loginResponse.setRole("admin");
            } else {
                loginResponse.setRole("user");
            }
            loginResponse.setUser(credential.getUsername());
            loginResponse.setToken("Bearer " + jwt.jwtCreate(user));
            response.setData(loginResponse);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }
}
