package village.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import village.farmer.entity.ApiDocumentList;

@Repository
public interface ApiDocumentListRepository extends JpaRepository<ApiDocumentList, Integer> {

}
