package com.example.lasttest.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Custom extends BaseTimeEntity{
    private int customId;
    private int userId;
    private int shopId;
    private String status;
}
