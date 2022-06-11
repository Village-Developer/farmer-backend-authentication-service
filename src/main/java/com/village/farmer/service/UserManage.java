package com.village.farmer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Users;
import com.village.farmer.model.request.UserEditRequest;
import com.village.farmer.model.response.GenericsResponse;
import com.village.farmer.model.response.UserGetResponse;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;

@Service
public class UserManage {

    @Autowired UserRepository userRepo;
    @Autowired CredentialRepository credRepo;
    
    public ResponseEntity<UserGetResponse> getUser(String username) {
        UserGetResponse res = new UserGetResponse();
        try {
            Credentials data = credRepo.findByUser(username);
            Users user = userRepo.findByCredential(data);
            res.setData(user);
            res.setMsg("Success");
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.setMsg("Fail: "+e.getMessage());
            return ResponseEntity.ok().body(res);
        }
    }

    public ResponseEntity<GenericsResponse> editUser(String username, UserEditRequest request) {
        GenericsResponse res = new GenericsResponse();
        try {
            Credentials data = credRepo.findByUser(username);
            Users user = userRepo.findByCredential(data);
            user.setAddr(request.getAddr());
            user.setFname(request.getFname());
            user.setLname(request.getLname());
            user.setMail(request.getEmail());
            user.setTel(request.getTel());
            userRepo.save(user);
            res.setMsg("Success");
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            res.setMsg("Fail: "+e.getMessage());
            return ResponseEntity.ok().body(res);
        }
    }
}
