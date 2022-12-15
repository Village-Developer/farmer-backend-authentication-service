package village.farmer.model;

import lombok.Data;

import java.util.Date;

@Data
public class ApiDocumentGroupDTO {

    private String apiGroupName;

    private Boolean isActive = true;

    private Date createdAt;

    private Date updatedAt = new Date();

}
