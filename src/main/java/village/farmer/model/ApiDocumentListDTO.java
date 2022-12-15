package village.farmer.model;

import lombok.Data;

import java.util.Date;

@Data
public class ApiDocumentListDTO {

    private Integer apiGroupId;

    private String apiListName;

    private Boolean isActive = true;

    private Date createdAt;

    private Date updatedAt = new Date();

}
