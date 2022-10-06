package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.Credential;
import village.farmer.model.request.LoginRequest;
import village.farmer.model.response.LoginResponse;
import village.farmer.repository.CredentialRepository;
import village.farmer.service.etc.Hash;
import village.farmer.service.etc.Jwt;
import village.farmer.statics.ErrorResponseReturnHandle;

import java.util.Date;

@Service
public class LoginService {

    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    Jwt jwt;
    public LoginResponse login (LoginRequest data){
        LoginResponse response = new LoginResponse();
        Hash hash = new Hash();
        try {
            String msg = "";
            Credential user = credentialRepository.findByUsername(data.getUsername());
            if (user == null) {
                msg =  ErrorResponseReturnHandle.Auth_Verify_01;
            }
            else if (!hash.sha256Hash(data.getPassword()).equals(user.getPassword())) {
                msg = ErrorResponseReturnHandle.Auth_Verify_02;
            }
            if (msg.equals("")) {
                msg = ErrorResponseReturnHandle.Auth_Verify_Success;
                response.setMsg(msg);
                response.setUser(data.getUsername());
                response.setToken(jwt.jwtcreate());
                response.setTimeStamp(new Date());
            } else {
                response.setMsg(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsg("Err: "+e.getMessage());
        }
        return response;
    }
}
