package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import village.farmer.entity.Role;

public interface RoleRepository extends JpaRepository <Role,Integer> {
    Role findByRoleName(String name);
}
