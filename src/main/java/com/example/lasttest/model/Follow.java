package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Follow extends BaseTimeEntity{
    private int followId;
    private int userId;
    private int followUserId;
    private String status;
    private List<Goods> goods;
}
