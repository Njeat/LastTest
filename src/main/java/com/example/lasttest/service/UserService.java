package com.example.lasttest.service;

import com.example.lasttest.model.User;
import com.example.lasttest.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Slf4j
public class UserService {
    private final UserMapper userMapper;

    public void createUser(User user){
        userMapper.createUser(user);
    }

    public List<User> allUser(){
        return userMapper.allUser();
    }

    public User getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

    public void updateUser(int userId, int manner){
        userMapper.updateUser(userId, manner);
    }

    public void deleteUser(int userId){
        userMapper.deleteUser(userId);
    }

//    public List<User> getUserByIdLocation(int userId){
//        return userMapper.getUserByIdLocation(userId);

//    }
}
