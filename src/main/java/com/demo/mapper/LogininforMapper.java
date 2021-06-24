package com.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.LogininforEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 系统访问记录
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface LogininforMapper extends BaseMapper<LogininforEntity> {
	
}
