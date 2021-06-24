package com.demo.common.security;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.entity.RoleEntity;
import com.demo.entity.UserEntity;
import com.demo.mapper.RoleMapper;
import com.demo.service.RoleService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ：msj
 * @date ：Created in 2021/5/21 9:56
 * @description：spring security
 * @modified By：`
 * @version: 1.0
 */

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().eq("username",s));
        List<RoleEntity> roles = roleMapper.selectList(new QueryWrapper<RoleEntity>().eq("ur.user_id",user.getId()));
        if (user == null) {
            System.out.println("用户不存在！");
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(s,user.getPassword(),authorities);
    }
}
