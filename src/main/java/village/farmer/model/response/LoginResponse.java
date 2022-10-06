package village.farmer.model.response;

import village.farmer.model.GenericsResponse;

import java.util.Date;

public class LoginResponse extends GenericsResponse {
    private String token;
    private String user;
    private Date timeStamp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
