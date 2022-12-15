package village.farmer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.ApiDocument;
import village.farmer.entity.ApiDocumentGroup;
import village.farmer.repository.ApiDocumentGroupRepository;
import village.farmer.repository.ApiDocumentRepository;
import village.farmer.service.ApiDocumentService;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ApiDocumentServiceImpl implements ApiDocumentService {

    @Autowired
    ApiDocumentRepository apiDocumentRepository;

    @Override
    public Map<String, Object> getByApiId(Integer id) {

        Optional<ApiDocument> result = apiDocumentRepository.findById(id);

        Map<String, Object> response = new LinkedHashMap<>();

        if(result.isPresent()) {

            response.put("api_method", result.get().getApiMethod());
            response.put("api_path", result.get().getApiPath());

        }

        return response;

    }

}
