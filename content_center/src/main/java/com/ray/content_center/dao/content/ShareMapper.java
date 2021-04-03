package com.ray.content_center.dao.content;

import com.ray.content_center.domain.entity.Share;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 张烈文
 */
@Mapper
@Repository
public interface ShareMapper {


    Share selectById(Integer id);

}
