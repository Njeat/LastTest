package com.example.lasttest.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Shop extends BaseTimeEntity{
    private int shopId;
    private int locationId;
    private int userId;
    private User user;
    private String shopProfileImgUrl;
    private String shopName;
    private String shopDetail;
    private String status;
    private Location location;
    private List<ShopImg> shopImg;
    private int custom;
}
