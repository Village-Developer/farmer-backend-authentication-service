package village.farmer.service.etc;

import org.springframework.stereotype.Service;
import village.farmer.entity.User;
import village.farmer.statics.StaticsEnum;

@Service
public class RoleReturn {

    public String getRoleName(String role) {
        if (role.equals(StaticsEnum.Role_Villager.displayName())) {
            return StaticsEnum.Role_Villager.displayName();
        } else if (role.equals(StaticsEnum.Role_Admin.displayName())) {
            return StaticsEnum.Role_Admin.displayName();
        } else if (role.equals(StaticsEnum.Role_Other.displayName())) {
            return StaticsEnum.Role_Other.displayName();
        } else if (role.equals(StaticsEnum.Role_User.displayName())) {
            return StaticsEnum.Role_User.displayName();
        } else {
            return role;
        }
    }

    public String getRoleName(User user) {
        String role = user.getRole().getRoleName();
        if (role.equals(StaticsEnum.Role_Villager.displayName())) {
            return StaticsEnum.Role_Villager.displayName();
        } else if (role.equals(StaticsEnum.Role_Admin.displayName())) {
            return StaticsEnum.Role_Admin.displayName();
        } else if (role.equals(StaticsEnum.Role_Other.displayName())) {
            return StaticsEnum.Role_Other.displayName();
        } else if (role.equals(StaticsEnum.Role_User.displayName())) {
            return StaticsEnum.Role_User.displayName();
        } else {
            return role;
        }
    }

    public Integer getRoleLevel(String role) {
        if (role.equals(StaticsEnum.Role_Villager.displayName())) {
            return StaticsEnum.Role_Villager.displayLevel();
        } else if (role.equals(StaticsEnum.Role_Admin.displayName())) {
            return StaticsEnum.Role_Admin.displayLevel();
        } else if (role.equals(StaticsEnum.Role_Other.displayName())) {
            return StaticsEnum.Role_Other.displayLevel();
        } else if (role.equals(StaticsEnum.Role_User.displayName())) {
            return StaticsEnum.Role_User.displayLevel();
        } else {
            return 0;
        }
    }

    public Integer getRoleLevel(User user) {
        String role = user.getRole().getRoleName();
        if (role.equals(StaticsEnum.Role_Villager.displayName())) {
            return StaticsEnum.Role_Villager.displayLevel();
        } else if (role.equals(StaticsEnum.Role_Admin.displayName())) {
            return StaticsEnum.Role_Admin.displayLevel();
        } else if (role.equals(StaticsEnum.Role_Other.displayName())) {
            return StaticsEnum.Role_Other.displayLevel();
        } else if (role.equals(StaticsEnum.Role_User.displayName())) {
            return StaticsEnum.Role_User.displayLevel();
        } else {
            return 0;
        }
    }
}
