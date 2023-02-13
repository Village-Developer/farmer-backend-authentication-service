package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import village.farmer.entity.Credential;
import village.farmer.entity.Role;
import village.farmer.entity.User;
import village.farmer.model.GenericsResponse;
import village.farmer.model.request.RegisterRequest;
import village.farmer.repository.CredentialRepository;
import village.farmer.repository.RoleRepository;
import village.farmer.repository.UserRepository;
import village.farmer.service.etc.Hash;
import village.farmer.service.etc.RegexPattern;
import village.farmer.statics.ErrorResponseReturnHandle;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    Hash hash;

    @Transactional
    public GenericsResponse registerUser (RegisterRequest data) {
        /* Create response */
        GenericsResponse response = new GenericsResponse();
        /* Create regex pattern */
        RegexPattern regex = new RegexPattern();
        try {
            /* Check username exist */
            Credential credential = credentialRepository.findByUsername(data.getUsername());
            if (credential != null) {
                response.setStatus(409);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_01);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_01);
            }
            /* Check password */
            else if (!regex.passCheck(data.getPassword())) {
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_02);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_02);
            }
            /* Check email */
            else if (!regex.mailCheck(data.getEmail())) {
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_04);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_04);
            }
            /* Check role */
            else if (!regex.roleCheck(data.getRole())) {
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Internal_Err_Null_02);
                throw new Exception(ErrorResponseReturnHandle.Internal_Err_Null_02);
            }
            /* Create new user */
            credential = new Credential();
            /* Set username */
            credential.setUsername(data.getUsername());
            /* Set password */
            String hashPass = BCrypt.hashpw(data.getPassword(), BCrypt.gensalt());
            credential.setPassword(hashPass);
            /* Save credential */
            credentialRepository.save(credential);
            /* Set role */
            Role role = roleRepository.findByRoleName(data.getRole());
            /* Check role */
            if (role == null) {
                /* Delete credential */
                credentialRepository.delete(credential);
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Internal_Err_Null_02);
                throw new Exception(ErrorResponseReturnHandle.Internal_Err_Null_02);
            }
            /* Create user */
            User user = new User();
            /* Set email */
            user.setEmail(data.getEmail());
            /* Set role */
            user.setRole(role);
            /* Set credential */
            user.setCredential(credentialRepository.findByUsername(data.getUsername()));
            /* Save user */
            userRepository.save(user);
            /* Set response */
            response.setStatus(201);
            /* Set message */
            response.setMsg(ErrorResponseReturnHandle.Auth_Register_Success);
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
