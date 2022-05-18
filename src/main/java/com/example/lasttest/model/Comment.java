package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class Comment extends BaseTimeEntity{
    private int commentId;
    private int userId;
    private int postId;
    private int parentCommentId;
    private String commentDetail;
    private String status;
    private int commentLike;
}
