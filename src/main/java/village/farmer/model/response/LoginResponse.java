package village.farmer.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String user;
    private String role;
    private String token;
}
