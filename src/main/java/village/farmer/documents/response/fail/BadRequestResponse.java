package village.farmer.documents.response.fail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class BadRequestResponse {
    @Schema(example = "false")
    private Boolean success;
    @Schema(example = "Bad request")
    private String message;
    private Instant timestamp = Instant.now();

}
