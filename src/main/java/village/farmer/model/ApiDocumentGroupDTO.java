package village.farmer.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ApiDocumentGroupDTO {

    @NotNull
    private String apiGroupName;

    private Boolean isActive = true;

    private Date createdAt;

    private Date updatedAt = new Date();

}
