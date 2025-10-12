package com.devteria.identity_service.service;

import com.devteria.identity_service.Exception.AppException;
import com.devteria.identity_service.Exception.ErrorCode;
import com.devteria.identity_service.dto.request.UserUpdateRequest;
import com.devteria.identity_service.dto.request.UsercreationRequest;
import com.devteria.identity_service.entity.User;
import com.devteria.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UsercreationRequest request){
        User user=new User();
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public User UpdateUser(String id, UserUpdateRequest request){
        User user=getUser(id);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUser(String userid){
        return userRepository.findById(userid).orElseThrow(()->new RuntimeException("User not found"));
    }
}
