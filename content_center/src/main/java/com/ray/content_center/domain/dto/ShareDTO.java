package com.ray.content_center.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ShareDTO {

    private Integer id;
    private Integer userId;
    private String title;
    private Date createTime;
    private Date updateTime;
    private Integer isOriginal;
    private String author;
    private String cover;
    private String summary;
    private Integer price;
    private String downloadUrl;
    private Integer buyCount;
    private Integer showFlag;
    private String auditStatus;
    private String reason;

    private String wxNickname;


}
