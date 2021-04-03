package com.ray.content_center;

import com.ray.content_center.dao.content.ShareMapper;
import com.ray.content_center.domain.dto.ShareDTO;
import com.ray.content_center.domain.entity.Share;

import com.ray.content_center.service.content.ShareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContentCenterApplicationTests {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private ShareService shareService;

    @Test
    void contextLoads() {
        Share share = shareMapper.selectById(1);
//        ShareDTO byId = shareService.findById(1);

        System.out.println(share);
    }

}
