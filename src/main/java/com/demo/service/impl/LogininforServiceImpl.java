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
import com.demo.mapper.LogininforMapper;
import com.demo.entity.LogininforEntity;
import com.demo.service.LogininforService;


@Service("logininforService")
public class LogininforServiceImpl extends ServiceImpl<LogininforMapper, LogininforEntity> implements LogininforService {

    @Override
    public PageUtils queryPage(PageFrom params) {
        Map<String, Object> map = BeanUtil.beanToMap(params);
        IPage<LogininforEntity> page = this.page(
                new Query<LogininforEntity>().getPage(map),
                new QueryWrapper<LogininforEntity>()
        );

        return new PageUtils(page);
    }

}