package com.ray.user_center.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 张烈文
 */
@Data
public class User {

    private Integer id;
    private String wxId;
    private String wxNickname;
    private String roles;
    private String avatarUrl;
    private Date createTime;
    private Date updateTime;
    private Integer bonus;
}
