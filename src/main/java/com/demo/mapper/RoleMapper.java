package com.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.entity.RoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Value;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色信息表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<RoleEntity> {

    List<RoleEntity> selectList(@Param("ew") QueryWrapper<RoleEntity> qw);
}
