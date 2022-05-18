package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Goods extends BaseTimeEntity{
    private int goodsId;
    private int userId;
    private User user;
    private String goodsTitle;
    private int categoryId;
    private Category category;
    private String goodsDetail;
    private int goodsView;
    private int goodsPrice;
    private String status;
    private List<GoodsImg> goodsImg;
}
