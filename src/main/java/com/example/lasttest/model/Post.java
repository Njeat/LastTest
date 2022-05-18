package com.example.lasttest.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Post extends BaseTimeEntity{
    private int postId;
    private int userId;
    private User user;
    private String postDetail;
    private List<PostImg> postImg;
    private int topicId;
    private Topic topic;
    private String status;
    private int postLike;
    private List<Comment> comment;

}
