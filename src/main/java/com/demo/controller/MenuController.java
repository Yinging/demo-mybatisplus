package com.demo.controller;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.request.PageFrom;
import com.demo.entity.MenuEntity;
import com.demo.service.MenuService;
import com.demo.common.utils.PageUtils;
import com.demo.common.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单权限表
 *
 * @author msj
 * @email ${email}
 * @date 2021-06-24 11:48:20
 */
@RestController
@RequestMapping("/menu")
@Api(tags ="菜单权限")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public R page(PageFrom params){
        PageUtils page = menuService.queryPage(params);

        return R.SUCCESS(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public R info(@PathVariable("id") Integer id){
		MenuEntity menu = menuService.getById(id);

        return R.SUCCESS(menu);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public R save(@RequestBody MenuEntity menu){
		menuService.save(menu);

        return R.SUCCESS();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody MenuEntity menu){
		menuService.updateById(menu);

        return R.SUCCESS();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Integer[] ids){
		menuService.removeByIds(Arrays.asList(ids));

        return R.SUCCESS();
    }

}
