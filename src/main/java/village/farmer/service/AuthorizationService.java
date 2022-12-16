package village.farmer.service;

public interface AuthorizationService {

    public String checkToken(String token) throws Exception;

}
