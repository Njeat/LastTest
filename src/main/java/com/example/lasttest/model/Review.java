package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Review extends BaseTimeEntity{
    private int reviewId;
    private int shopId;
    private int userId;
    private User user;
    private String reviewDetail;
    private String status;
    private int reviewLike;
    private List<ReviewImg> reviewImg;
}
