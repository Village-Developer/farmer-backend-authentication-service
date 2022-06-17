package com.village.farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.village.farmer.model.request.UserEditRequest;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.model.response.UserGetResponse;
import com.village.farmer.service.UserManage;

@RestController
@RequestMapping("/manage/user")
public class UserManagement {

    @Autowired UserManage manage;

    @GetMapping("/get/{username}")
    @ResponseBody
    public ResponseEntity<UserGetResponse> get (@PathVariable("username") String username) {
        return manage.getUser(username);
    }

    @PutMapping("/edit/{username}")
    public ResponseEntity<GenericsResponse> name(@PathVariable("username") String username, @RequestBody UserEditRequest request) {
        return manage.editUser(username,request);
    }

}