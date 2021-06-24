package com.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.Query;
import com.demo.common.request.PageFrom;
import com.demo.mapper.UserMapper;
import com.demo.entity.UserEntity;
import com.demo.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(map),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

}