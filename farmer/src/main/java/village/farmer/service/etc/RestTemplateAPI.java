package village.farmer.service.etc;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateAPI {

    public RestTemplate go () {
        return new RestTemplate();
    }

    public HttpHeaders headers() {
        return new HttpHeaders();
    }

    public HttpEntity<?> request (Object obj, HttpHeaders headers) {
        return new HttpEntity<>(obj,headers);
    }
}
