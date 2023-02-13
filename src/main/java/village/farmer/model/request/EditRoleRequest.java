package village.farmer.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRoleRequest {
    private String role;
    private String changeTo;

}
