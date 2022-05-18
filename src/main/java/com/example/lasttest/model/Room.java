package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Room extends BaseTimeEntity{
    private int roomId;
    private int goodsId;
    private Goods goods;
    private int buyerId;
    private User buyer;
    private String status;
    private List<Chat> message;
}
