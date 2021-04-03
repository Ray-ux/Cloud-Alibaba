package com.ray.content_center.service.content.impl;

import com.ray.content_center.dao.content.ShareMapper;
import com.ray.content_center.domain.dto.ShareDTO;
import com.ray.content_center.domain.dto.UserDTO;
import com.ray.content_center.domain.entity.Share;
import com.ray.content_center.service.content.ShareService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ShareDTO findByShareId(Integer id) {

        Share share = shareMapper.selectById(id);
        Integer userId = share.getUserId();
        UserDTO userDTO = restTemplate.getForObject("http://user-center/users/{userId}", UserDTO.class, userId);
//        String str = restTemplate.getForObject("http://test-center/test", String.class);
//        log.info("test-center={}", str);
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share, shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;

    }
}
