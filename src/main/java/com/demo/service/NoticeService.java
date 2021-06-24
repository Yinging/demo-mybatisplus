package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.NoticeEntity;
import com.demo.common.request.PageFrom;

/**
 * 通知公告表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface NoticeService extends IService<NoticeEntity> {

    PageUtils queryPage(PageFrom params);
}

