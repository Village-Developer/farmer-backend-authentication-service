package village.farmer.service.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.User;
import village.farmer.repository.UserRepository;
import village.farmer.service.etc.RoleReturn;
import village.farmer.statics.StaticsEnum;

@Service
public class Authorization {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleReturn roleReturn;
//    }
    public Boolean roleLevelCheck (String a, String b) {
        User aa = userRepository.findByUsername(a);
        User bb = userRepository.findByUsername(b);
        String roleA = aa.getRole().getRoleName();
        String roleB = bb.getRole().getRoleName();
        if (roleReturn.getRoleName(roleA).equals(roleReturn.getRoleName(roleB))){
            if(roleA.equals(StaticsEnum.Role_Villager.displayName()) && !roleB.equals(StaticsEnum.Role_Villager.displayName())){
                return true;
            } else {
                return false;
            }
        } else {
            Integer sum = roleReturn.getRoleLevel(roleA) - roleReturn.getRoleLevel(roleB);
            return sum >= 0;
        }
    }
}
