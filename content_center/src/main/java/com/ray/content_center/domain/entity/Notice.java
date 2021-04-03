package com.ray.content_center.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer id;
    private String content;
    private Integer showFlag;
    private Date createTime;
}
