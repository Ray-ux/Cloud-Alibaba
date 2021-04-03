package com.ray.user_center.dao.user;


import com.ray.user_center.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {


    User selectById(Integer id);

}
