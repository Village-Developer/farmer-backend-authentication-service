package com.village.farmer.model.response;

import com.village.farmer.entity.Users;

public class UserGetResponse extends GenericsResponse {
    
    private Users data;

    public Users getData() {
        return this.data;
    }

    public void setData(Users data) {
        this.data = data;
    }

}
