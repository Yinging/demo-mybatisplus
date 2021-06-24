package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.LogininforEntity;
import com.demo.common.request.PageFrom;

/**
 * 系统访问记录
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface LogininforService extends IService<LogininforEntity> {

    PageUtils queryPage(PageFrom params);
}

