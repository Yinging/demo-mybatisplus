package com.demo.mapper;

import com.demo.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 菜单权限表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface MenuMapper extends BaseMapper<MenuEntity> {
	
}
