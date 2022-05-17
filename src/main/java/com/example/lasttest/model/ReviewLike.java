package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class ReviewLike {
    private int reviewLikeId;
    private int userId;
    private int reviewId;
    private String status;
}
