package com.example.lasttest.controller;

import com.example.lasttest.model.User;
import com.example.lasttest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 생성
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        userService.createUser(user);
        return user;
    }

    // 전체 유저 조회
    @GetMapping("/user")
    public List<User> allUser(){
        return userService.allUser();
    }

    // 특정 유저 조회
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserById(userId);
    }

    @PatchMapping("/user/{userId}")
    public int updateUser(@PathVariable("userId") int userId,
                           @RequestParam(value = "manner",required = false) int manner){
        userService.updateUser(userId, manner);
        return manner;
    }

    @DeleteMapping("/user/{userId}")
    public int deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return userId;
    }

//    @GetMapping("/user/location/{userId}")
//    public List<User> getUserByIdLocation(@PathVariable("userId") int userId){
//        return userService.getUserByIdLocation(userId);
//    }
}
