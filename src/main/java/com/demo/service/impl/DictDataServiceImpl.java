package com.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.demo.common.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.common.utils.PageUtils;
import com.demo.common.request.PageFrom;
import com.demo.mapper.DictDataMapper;
import com.demo.entity.DictDataEntity;
import com.demo.service.DictDataService;


@Service("dictDataService")
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictDataEntity> implements DictDataService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<DictDataEntity> page = this.page(
                new Query<DictDataEntity>().getPage(map),
                new QueryWrapper<DictDataEntity>()
        );

        return new PageUtils(page);
    }

}