package com.demo.controller;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.common.request.PageFrom;
import com.demo.entity.UserEntity;
import com.demo.service.UserService;
import com.demo.common.utils.PageUtils;
import com.demo.common.response.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息表
 *
 * @author msj
 * @email ${email}
 * @date 2021-06-24 11:48:20
 */
@RestController
@RequestMapping("/user")
@Api(tags ="用户信息")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页")
    public R page(PageFrom params){
        PageUtils page = userService.queryPage(params);

        return R.SUCCESS(page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "信息")
    public R info(@PathVariable("id") Integer id){
		UserEntity user = userService.getById(id);

        return R.SUCCESS(user);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存")
    public R save(@RequestBody UserEntity user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userService.save(user);

        return R.SUCCESS();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.SUCCESS();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除")
    public R delete(@RequestBody Integer[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.SUCCESS();
    }

}
