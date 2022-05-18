package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class GoodsLike extends BaseTimeEntity{
    private int goodsLikeId;
    private int userId;
    private int goodsId;
    private String status;
}
