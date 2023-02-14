package village.farmer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @Schema(example = "John")
    private String username;
    @Schema(example = "123456")
    private String password;
    @Schema(example = "John@mail.com")
    private String email;
    @Schema(example = "admin")
    private String role;

}
