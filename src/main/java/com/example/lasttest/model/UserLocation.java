package com.example.lasttest.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserLocation extends BaseTimeEntity{
    private int userId;
    private int locationId;
    private Location location;
    private String status;
    private int userLocationId;
}
