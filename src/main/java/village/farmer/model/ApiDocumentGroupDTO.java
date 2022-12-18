package village.farmer.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ApiDocumentGroupDTO {

    @NotBlank
    @NotNull
    private String apiGroupName;

    private Boolean isActive = true;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

}
