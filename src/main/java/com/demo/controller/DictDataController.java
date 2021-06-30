package com.demo.controller;

import java.util.Arrays;


import com.demo.entity.DictDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.request.PageFrom;
import com.demo.service.DictDataService;
import com.demo.common.utils.PageUtils;
import com.demo.common.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 字典数据表
 *
 * @author msj
 * @email ${email}
 * @date 2021-06-24 11:48:20
 */
@RestController
@RequestMapping("/dictdata")
@Api(tags ="字典数据")
public class DictDataController {
    @Autowired
    private DictDataService dictDataService;

    /**
     * 分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public R page(PageFrom params){
        PageUtils page = dictDataService.queryPage(params);

        return R.SUCCESS(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{dictCode}")
    @ApiOperation(value = "信息")
    public R info(@PathVariable("dictCode") Long dictCode){
		DictDataEntity dictData = dictDataService.getById(dictCode);

        return R.SUCCESS(dictData);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public R save(@RequestBody DictDataEntity dictData){
		dictDataService.save(dictData);

        return R.SUCCESS();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody DictDataEntity dictData){
		dictDataService.updateById(dictData);

        return R.SUCCESS();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Long[] dictCodes){
		dictDataService.removeByIds(Arrays.asList(dictCodes));

        return R.SUCCESS();
    }

}
