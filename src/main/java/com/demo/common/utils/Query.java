package com.demo.common.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.common.constant.Constant;
import com.demo.common.xssFliter.SQLFilter;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Query<T> {

    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, List<String> defaultOrderFields, boolean isAsc) {
        //分页参数
        Integer pageNum = 0;
        Integer pageSize = 10;
        Integer pageNum1 = (Integer) params.get("pageNum");
        Integer pageSize1 = (Integer) params.get("pageSize");

        if (pageNum1 != null && pageNum1 >= 0) {
            pageNum = pageNum1;
        }
        if (pageSize1 != null && pageSize1 > 0) {
            pageSize = pageSize1;
        }


        //分页对象
        Page<T> page = new Page<>(pageNum, pageSize);

        //分页参数
        params.put(Constant.PAGE, page);


        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject((String) params.get(Constant.ORDER_FIELD));
        String order = (String) params.get(Constant.ORDER);

        //前端字段排序
        if (StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)) {
            if (Constant.ASC.equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            } else {
                return page.setDesc(orderField);
            }
        }

        //没有排序字段，则不排序
        if (CollUtil.isEmpty(defaultOrderFields)) {
            return page;
        }
        //驼峰转下划线
        List<String> list = com.demo.common.utils.StringUtils.camelCaseToConvert(defaultOrderFields);
        //默认排序
        if (isAsc) {
            page.setAsc(ArrayUtil.toArray(list, String.class));
        } else {
            page.setDesc(ArrayUtil.toArray(list, String.class));
        }

        return page;
    }
}