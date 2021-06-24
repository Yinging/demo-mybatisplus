package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.OperLogEntity;
import com.demo.common.request.PageFrom;

/**
 * 操作日志记录
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface OperLogService extends IService<OperLogEntity> {

    PageUtils queryPage(PageFrom params);
}

