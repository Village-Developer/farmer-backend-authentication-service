package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import village.farmer.entity.Credential;
import village.farmer.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByCredential(Credential user);
    @Query("select u from User u, Credential c where c.username = :user and u.credential.id = c.id")
    User findByUsername(@Param("user") String username);
}
