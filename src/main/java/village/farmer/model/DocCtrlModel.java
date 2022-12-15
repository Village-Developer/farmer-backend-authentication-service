package village.farmer.model;

import java.util.HashMap;

public class DocCtrlModel {

    private String name;
    private String methodType;
    private HashMap<String,String> reqBody;
    private HashMap<String,String> resBody;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public HashMap<String, String> getResBody() {
        return resBody;
    }

    public void setResBody(HashMap<String, String> resBody) {
        this.resBody = resBody;
    }

    public HashMap<String, String> getReqBody() {
        return reqBody;
    }

    public void setReqBody(HashMap<String, String> reqBody) {
        this.reqBody = reqBody;
    }
}
