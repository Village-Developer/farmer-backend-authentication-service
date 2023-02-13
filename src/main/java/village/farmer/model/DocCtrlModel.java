package village.farmer.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class DocCtrlModel {

    private String name;
    private String methodType;
    private HashMap<String,String> reqBody;
    private HashMap<String,String> resBody;

}
