package village.farmer.documents.response.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class LoginResponse {
    @Schema(example = "true")
    private Boolean success;
    @Schema(example = "Successfully logged in")
    private String message;
    private LoginData data;
    private Instant timestamp = Instant.now();
}
