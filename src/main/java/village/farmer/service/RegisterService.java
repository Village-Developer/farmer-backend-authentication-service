package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.Credential;
import village.farmer.entity.Role;
import village.farmer.entity.User;
import village.farmer.model.GenericsResponse;
import village.farmer.model.request.RegisterRequest;
import village.farmer.repository.CredentialRepository;
import village.farmer.repository.RoleRepository;
import village.farmer.repository.UserRepository;
import village.farmer.service.etc.RegexPattern;
import village.farmer.statics.ErrorResponseReturnHandle;
import village.farmer.statics.StaticsEnum;
import village.farmer.statics.StaticsParameter;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    RoleRepository roleRepository;

    public GenericsResponse registerUser (RegisterRequest data) {
        GenericsResponse response = new GenericsResponse();
        RegexPattern regex = new RegexPattern();
        try {
            Credential credential = credentialRepository.findByUsername(data.getUsername());
            if (credential!=null) {
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_01);
                return  response;
            } else if (!data.getPassword().equals(data.getRePassword())) {
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_03);
                return  response;
            } else if (!regex.passCheck(data.getPassword())) {
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_02);
                return  response;
            } else if (!regex.mailCheck(data.getEmail())) {
                response.setMsg(ErrorResponseReturnHandle.Auth_Register_04);
                return  response;
            }
            User user = new User();
            credential = new Credential();
            try {
                user.setEmail(data.getEmail());
                user.setName(data.getName());
                user.setTitle(data.getTitle());
            } catch (Exception e) {
                e.printStackTrace();
                response.setMsg("Err: "+e.getMessage());
            }
            try {
                credential.setUsername(data.getUsername());
                credential.setPassword(data.getPassword());
                credentialRepository.save(credential);

                credential = credentialRepository.findByUsername(data.getUsername());
                if (credential != null) {
                    user.setCredential(credential);
                } else {
                    response.setMsg(ErrorResponseReturnHandle.Internal_Err_Null_01);
                    return  response;
                }

                System.out.println(StaticsEnum.Role_User.displayName());
                Role role = roleRepository.findByRoleName(StaticsEnum.Role_User.displayName());
                if (role!=null) {
                    user.setRole(role);
                    userRepository.save(user);
                } else {
                    response.setMsg(ErrorResponseReturnHandle.Internal_Err_Null_02);
                    return  response;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.setMsg("Err: "+e.getMessage());
            }
            response.setMsg(ErrorResponseReturnHandle.Auth_Register_Success);
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsg("Err: "+e.getMessage());
        }
        return response;
    }
}
