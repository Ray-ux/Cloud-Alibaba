package com.ray.content_center.controller.content;

import com.ray.content_center.domain.dto.ShareDTO;

import com.ray.content_center.service.content.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张烈文
 */
@RestController
@RequestMapping("/share")
public class ShareController {


    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {

        ShareDTO shareDTO = shareService.findByShareId(id);
        return shareDTO.toString();

    }




}
