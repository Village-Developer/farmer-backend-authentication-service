package village.farmer.documents.response.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class RegisterResponse {
    @Schema(example = "true")
    private Boolean success;
    @Schema(example = "Successfully registered")
    private String message;
    private Instant timestamp = Instant.now();
}
