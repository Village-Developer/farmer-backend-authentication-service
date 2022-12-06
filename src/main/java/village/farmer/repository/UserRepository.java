package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import village.farmer.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

}
