package com.example.lasttest.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class User extends BaseTimeEntity{

    private int userId;
    private String userName;
    private String profileImgUrl;
    private String phoneNum;
    private int manner;
    private String status;
    private UserLocation userLocation;

}
