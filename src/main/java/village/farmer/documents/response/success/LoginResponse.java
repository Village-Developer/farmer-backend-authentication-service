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

@Getter
@Setter
class LoginData {
    @Schema(example = "John")
    private String username;
    @Schema(example = "admin")
    private String role;
    @Schema(example = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IlJTQSJ9.eyJhdWQiOiJhZG1pbiIsInVzZXJuYW1lIjoiSm9obiIsImV4cCI6MTY3NjQ0OTY5NCwianRpIjoiamxydzM3SXV3U1BCdkJpbTRGeWI2QSIsImlzcyI6IlZpbGxhZ2UgT2ZmaWNlciIsInN1YiI6IjI3OWZhYmZhZDQ5MTQxZTY0NzJmYzYzZmEwNmY0NDYyNjIyOGI4NGZjOWE5NjUyM2VmOWU2OTUxODhjMjg5YzIifQ.oUTLHx-hM7kS18HoYzP8ClWWTMK4fpFvyBxq-AV4tGOC0Aku2wwZ_eRKVvMSf9ndYE4YLpf3EpkjpA-dSIAeftPfsi33bnR7T_jVux4ZeSKVTMqfuhP_aHapTvwY-AdQrfmzN8qjYMs11uGqEPivMu7GO_YHbjswus2g17jQ92enHKWpisDsQvJJ1LWme-YzEJD0PVMI9Hp79sGRFBc6eZYDTKd8DloCCUH0PF2aagHohj3-AOJFJSjDyPQ5qM5da1bNkpCgENPCSoJ81U-4vUh7mGF-tYjyl90ZbzAq44ZBhql_vu1i7VWcLsTHTHabzuWJ9ryQ2iYUJ6SkCuMWNg")
    private String token;



}
