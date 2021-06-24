package com.demo.mapper;

import com.demo.entity.RoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 角色和菜单关联表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenuEntity> {
	
}
