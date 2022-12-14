package village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.Role;
import village.farmer.model.GenericsResponseModel;
import village.farmer.model.request.DeleteRoleRequest;
import village.farmer.model.request.EditRoleRequest;
import village.farmer.repository.RoleRepository;
import village.farmer.service.etc.Authorization;
import village.farmer.service.etc.Jwt;
import village.farmer.statics.ErrorResponseReturnHandle;

@Service
public class RoleManagementService {

    @Autowired
    Jwt jwt;

    @Autowired
    Authorization authorization;

    @Autowired
    RoleRepository roleRepository;

    public GenericsResponseModel edit (String token, EditRoleRequest request) {
        GenericsResponseModel response = new GenericsResponseModel();
        try {
            token = token.replace("Bearer ","");
            if(!jwt.RoleVillageAuthorized(token)|| !jwt.RoleAdminAuthorized(token)){
                throw new Exception(ErrorResponseReturnHandle.Role_Edit_02);
            }
            Role role = roleRepository.findByRoleName(request.getRole());
            role.setRoleName(request.getChangeTo());
            roleRepository.save(role);
            response.setMsg(ErrorResponseReturnHandle.Role_Edit_Success);
        } catch (Exception e){
            e.printStackTrace();
            response.setMsg(ErrorResponseReturnHandle.Role_Edit_01);
        }
        return response;
    }

    public GenericsResponseModel delete (String token, DeleteRoleRequest request) {
        GenericsResponseModel response = new GenericsResponseModel();
        try {
            token = token.replace("Bearer ","");
            if(!jwt.RoleVillageAuthorized(token)|| !jwt.RoleAdminAuthorized(token)){
                throw new Exception();
            }
            String user = jwt.getUserFromToken(token);
            if (authorization.roleLevelCheck(user,request.getRole())) {
                Role role = roleRepository.findByRoleName(request.getRole());
                roleRepository.delete(role);
                response.setMsg("");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setMsg(e.getMessage());
        }
        return response;
    }
}
