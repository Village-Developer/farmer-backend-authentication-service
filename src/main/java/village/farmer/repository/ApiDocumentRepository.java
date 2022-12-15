package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import village.farmer.entity.ApiDocument;

@Repository
public interface ApiDocumentRepository extends JpaRepository<ApiDocument, Integer>{

}

