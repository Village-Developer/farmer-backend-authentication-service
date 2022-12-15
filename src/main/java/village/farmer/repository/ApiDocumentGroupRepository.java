package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import village.farmer.entity.ApiDocumentGroup;

@Repository
public interface ApiDocumentGroupRepository extends JpaRepository<ApiDocumentGroup, Integer> {

}

