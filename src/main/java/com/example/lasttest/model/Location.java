package com.example.lasttest.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
public class Location extends BaseTimeEntity{
    private int locationId;
    private String location;
    private String status;
}
