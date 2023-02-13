package village.farmer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericsResponse {
    private int status;
    private String msg;
    private Object data;
}
