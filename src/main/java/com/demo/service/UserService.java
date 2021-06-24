package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.UserEntity;
import com.demo.common.request.PageFrom;

/**
 * 用户信息表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(PageFrom params);
}

