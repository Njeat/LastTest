package com.example.lasttest.model;

import lombok.Getter;

@Getter
public class Topic extends BaseTimeEntity{
    private int topicId;
    private String topic;
    private String status;
}
