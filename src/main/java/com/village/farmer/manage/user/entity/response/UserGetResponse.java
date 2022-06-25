package com.village.farmer.manage.user.entity.response;

import com.village.farmer.manage.user.entity.Users;
import com.village.farmer.generics.entity.response.GenericsResponse;

public class UserGetResponse extends GenericsResponse {
    
    private Users data;

    public Users getData() {
        return this.data;
    }

    public void setData(Users data) {
        this.data = data;
    }

}
