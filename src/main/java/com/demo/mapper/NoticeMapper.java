package com.demo.mapper;

import com.demo.entity.NoticeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 通知公告表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Mapper
@Repository
public interface NoticeMapper extends BaseMapper<NoticeEntity> {
	
}
