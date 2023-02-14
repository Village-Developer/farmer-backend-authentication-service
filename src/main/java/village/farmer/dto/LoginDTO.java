package village.farmer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

    @Schema(example = "John")
    private String username;
    @Schema(example = "123456")
    private String password;

}
