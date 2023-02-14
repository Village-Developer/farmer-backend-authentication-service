package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import village.farmer.entity.Credential;
import village.farmer.entity.User;
import village.farmer.model.GenericsResponse;
import village.farmer.dto.LoginDTO;
import village.farmer.model.response.LoginResponse;
import village.farmer.repository.CredentialRepository;
import village.farmer.repository.UserRepository;
import village.farmer.service.etc.Jwt;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Jwt jwt;

    public GenericsResponse login (LoginDTO data){
        /* Create response */
        GenericsResponse response = new GenericsResponse();
        try {
            /* Check username and password */
            Credential credential = credentialRepository.findByUsername(data.getUsername());
            /* Check user exist */
            if (credential == null) {
                response.setStatus(401);
                response.setMsg("User not found");
                throw new Exception("User not found");
            }
            /* Check password */
            else if (!BCrypt.checkpw(data.getPassword(), credential.getPassword())) {
                response.setStatus(401);
                response.setMsg("Invalid password");
                throw new Exception("Invalid password");
            }
            /* Login success */
            response.setStatus(200);
            /* Set message */
            response.setMsg("Login success");
            /* Create token */
            LoginResponse loginResponse = new LoginResponse();
            /* Get user role */
            User user = userRepository.findByCredential(credential);
            /* Check user role */
            if (Objects.equals(user.getRole().getRoleName(), "admin")) {
                loginResponse.setRole("admin");
            } else {
                loginResponse.setRole("user");
            }
            /* Set username */
            loginResponse.setUser(credential.getUsername());
            /* Set token */
            loginResponse.setToken("Bearer " + jwt.jwtCreate(user));
            /* Set response data */
            response.setData(loginResponse);
            /* Return response */
            return response;
        } catch (Exception e) {
            /* Print error */
            e.printStackTrace();
            /* Return response */
            return response;
        }
    }
}
