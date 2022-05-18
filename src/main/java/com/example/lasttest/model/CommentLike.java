package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class CommentLike extends BaseTimeEntity{
    private int commentLikeId;
    private int commentId;
    private int userId;
    private String status;
}
