package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class PostImg extends BaseTimeEntity{
    private int postImgId;
    private int postId;
    private String postImgUrl;
    private String status;
}
