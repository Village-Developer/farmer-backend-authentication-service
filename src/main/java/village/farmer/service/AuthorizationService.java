package village.farmer.service;

import village.farmer.model.GenericsResponse;

public interface AuthorizationService {

    GenericsResponse checkToken(String token) throws Exception;

}
