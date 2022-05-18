package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class Category extends BaseTimeEntity{
    private int categoryId;
    private String category;
    private String categoryEmojiUrl;
    private String status;
}
