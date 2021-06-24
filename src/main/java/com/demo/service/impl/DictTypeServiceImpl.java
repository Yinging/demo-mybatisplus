package com.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.demo.mapper.DictTypeMapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.utils.Query;
import com.demo.common.request.PageFrom;
import com.demo.entity.DictTypeEntity;
import com.demo.service.DictTypeService;


@Service("dictTypeService")
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictTypeEntity> implements DictTypeService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<DictTypeEntity> page = this.page(
                new Query<DictTypeEntity>().getPage(map),
                new QueryWrapper<DictTypeEntity>()
        );

        return new PageUtils(page);
    }

}