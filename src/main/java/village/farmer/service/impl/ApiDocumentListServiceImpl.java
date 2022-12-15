package village.farmer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.ApiDocumentList;
import village.farmer.repository.ApiDocumentListRepository;
import village.farmer.service.ApiDocumentListService;

import java.util.Date;

@Service
public class ApiDocumentListServiceImpl implements ApiDocumentListService {

    @Autowired
    ApiDocumentListRepository apiDocumentListRepository;

    @Override
    public String addListApi(ApiDocumentList apiDocumentList) {

        apiDocumentList.setCreatedAt(new Date());

        apiDocumentListRepository.save(apiDocumentList);

        return "Successfully created";

    }
}
