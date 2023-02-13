package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        GenericsResponse response = new GenericsResponse();
        RegexPattern regex = new RegexPattern();
        try {
            Credential credential = credentialRepository.findByUsername(data.getUsername());
            if (credential != null) {
                response.setStatus(409);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_01);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_01);
            } else if (!regex.passCheck(data.getPassword())) {
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_02);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_02);
            } else if (!regex.mailCheck(data.getEmail())) {
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_04);
                throw new Exception(ErrorResponseReturnHandle.Auth_Register_04);
            }
            credential = new Credential();
            credential.setUsername(data.getUsername());
            credential.setPassword(hash.sha256Hash(data.getPassword()));
            credentialRepository.save(credential);
            Role role = roleRepository.findByRoleName(data.getRole());
            if (role == null) {
                credentialRepository.delete(credential);
                response.setStatus(400);
                response.setMsg(ErrorResponseReturnHandle.Internal_Err_Null_02);
                throw new Exception(ErrorResponseReturnHandle.Internal_Err_Null_02);
            }
            User user = new User();
            user.setEmail(data.getEmail());
            user.setRole(role);
            user.setCredential(credentialRepository.findByUsername(data.getUsername()));
            userRepository.save(user);
            response.setStatus(201);
            response.setMsg(ErrorResponseReturnHandle.Auth_Register_Success);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }
}
