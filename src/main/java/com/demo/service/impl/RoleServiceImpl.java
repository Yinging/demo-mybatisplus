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
import com.demo.mapper.RoleMapper;
import com.demo.entity.RoleEntity;
import com.demo.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<RoleEntity> page = this.page(
                new Query<RoleEntity>().getPage(map),
                new QueryWrapper<RoleEntity>()
        );

        return new PageUtils(page);
    }

}