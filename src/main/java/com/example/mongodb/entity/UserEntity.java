package com.example.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class UserEntity {
    @Id
    private String user_id;

    private String user_name;

    private String user_pwd;

    private Date createTime;

    private Date updateTime;

}
