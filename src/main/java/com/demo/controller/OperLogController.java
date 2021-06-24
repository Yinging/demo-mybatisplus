package com.demo.controller;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.request.PageFrom;
import com.demo.entity.OperLogEntity;
import com.demo.service.OperLogService;
import com.demo.common.utils.PageUtils;
import com.demo.common.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 操作日志记录
 *
 * @author msj
 * @email ${email}
 * @date 2021-06-24 11:48:20
 */
@RestController
@RequestMapping("/operlog")
@Api(tags ="操作日志记录")
public class OperLogController {
    @Autowired
    private OperLogService operLogService;

    /**
     * 分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public R page(PageFrom params){
        PageUtils page = operLogService.queryPage(params);

        return R.SUCCESS(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public R info(@PathVariable("id") Integer id){
		OperLogEntity operLog = operLogService.getById(id);

        return R.SUCCESS(operLog);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public R save(@RequestBody OperLogEntity operLog){
		operLogService.save(operLog);

        return R.SUCCESS();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody OperLogEntity operLog){
		operLogService.updateById(operLog);

        return R.SUCCESS();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Integer[] ids){
		operLogService.removeByIds(Arrays.asList(ids));

        return R.SUCCESS();
    }

}
