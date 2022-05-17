package com.example.lasttest.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShopImg extends BaseTimeEntity{
    private int shopImgId;
    private int shopId;
    private String shopImgUrl;
    private String status;
}
