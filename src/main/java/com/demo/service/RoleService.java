package com.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.RoleEntity;
import com.demo.common.request.PageFrom;

import java.util.List;

/**
 * 角色信息表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface RoleService extends IService<RoleEntity> {

    PageUtils queryPage(PageFrom params);

}

