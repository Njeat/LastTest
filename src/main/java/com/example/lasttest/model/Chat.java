package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class Chat extends BaseTimeEntity{
    private int chatId;
    private int userId;
    private int roomId;
    private String message;
    private String messageType;
    private String status;
}
