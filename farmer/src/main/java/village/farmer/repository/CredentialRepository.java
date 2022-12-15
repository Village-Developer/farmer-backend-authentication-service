package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import village.farmer.entity.Credential;

public interface CredentialRepository extends JpaRepository<Credential, Integer> {

    Credential findByUsername (String username);
}
