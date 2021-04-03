package com.ray.user_center.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 张烈文
 */
@Data
public class BonusEventLog {

    private Integer id;
    private Integer userId;
    private Integer value;
    private String event;
    private Date createTime;
    private String description;
}
