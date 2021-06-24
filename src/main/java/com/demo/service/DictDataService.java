package com.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.common.utils.PageUtils;
import com.demo.entity.DictDataEntity;
import com.demo.common.request.PageFrom;

/**
 * 字典数据表
 *
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
public interface DictDataService extends IService<DictDataEntity> {

    PageUtils queryPage(PageFrom params);
}

