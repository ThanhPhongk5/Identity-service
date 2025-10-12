package com.devteria.identity_service.controller;

import com.devteria.identity_service.dto.request.ApiResponse;
import com.devteria.identity_service.dto.request.UserUpdateRequest;
import com.devteria.identity_service.dto.request.UsercreationRequest;
import com.devteria.identity_service.entity.User;
import com.devteria.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identity/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UsercreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(request));
        return response;
    }
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userid}")
    User getUser(@PathVariable("userid") String userid){
        return userService.getUser(userid);
    }
    @PutMapping("/{userid}")
    User updateUser(@PathVariable String userid,@RequestBody UserUpdateRequest request){
        return userService.UpdateUser(userid,request);
    }
    @DeleteMapping("/{userid}")
    String deleteuser(@PathVariable String userid){
        userService.deleteUser(userid);
        return "User đã được xóa";
    }
}
