package com.demo.mapper;

import com.demo.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
