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
import com.demo.mapper.OperLogMapper;
import com.demo.entity.OperLogEntity;
import com.demo.service.OperLogService;


@Service("operLogService")
public class OperLogServiceImpl extends ServiceImpl<OperLogMapper, OperLogEntity> implements OperLogService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<OperLogEntity> page = this.page(
                new Query<OperLogEntity>().getPage(map),
                new QueryWrapper<OperLogEntity>()
        );

        return new PageUtils(page);
    }

}