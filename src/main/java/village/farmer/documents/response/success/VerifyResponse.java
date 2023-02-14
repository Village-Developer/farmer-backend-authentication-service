package village.farmer.documents.response.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class VerifyResponse {
    @Schema(example = "true")
    private Boolean success;
    @Schema(example = "Authorization")
    private String message;
    private final Instant timestamp = Instant.now();
}
