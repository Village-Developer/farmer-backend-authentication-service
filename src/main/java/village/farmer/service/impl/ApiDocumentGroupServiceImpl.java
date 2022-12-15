package village.farmer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.ApiDocumentGroup;
import village.farmer.repository.ApiDocumentGroupRepository;
import village.farmer.service.ApiDocumentGroupService;

import java.util.*;

@Service
public class ApiDocumentGroupServiceImpl implements ApiDocumentGroupService {

    @Autowired
    private ApiDocumentGroupRepository apiDocumentGroupRepository;

    @Override
    public String addGroupApi(ApiDocumentGroup apiDocumentGroup) {

        apiDocumentGroup.setCreatedAt(new Date());

        apiDocumentGroupRepository.save(apiDocumentGroup);

        return "Successfully created";
    }

    @Override
    public Object getAllApiGroup() {

        List<ApiDocumentGroup> result = apiDocumentGroupRepository.findAll();

        System.out.println(result);
        Map<String, Object> response = new LinkedHashMap<>();

        System.out.println(result.size());
        if(result.size() > 0) {

            response.put("api_group_name", result.get(1).getApiGroupName());

        }

        return response;
    }
}
