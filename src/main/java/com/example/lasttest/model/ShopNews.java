package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class ShopNews {
    private int shopNewsId;
    private int shopId;
    private String shopNewsTitle;
    private String shopNewsDetail;
    private int newsView;
    private String status;
    private List<ShopNewsImg> shopNewsImg;
}
