package com.demo.common.security.handle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.utils.IpUtil;
import com.demo.entity.UserEntity;
import com.demo.service.LogininforService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author ：msj
 * @date ：Created in 2021/5/21 10:44
 * @description：
 * @modified By：`
 * @version: 1.0
 */

@Component("successLoginHandle")
public class SuccessLoginHandle extends SavedRequestAwareAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Autowired
    private UserService userService;

    @Autowired
    private LogininforService logininforService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        System.out.println("后台登录");
        User principal = (User) authentication.getPrincipal();
        com.demo.entity.UserEntity user = userService.getOne(new QueryWrapper<UserEntity>().eq("username",principal.getUsername()));
        //可以业务逻辑的操作
        //日志

        /*user.setLastIp(IpUtil.getIpAddress(request));
        user.setLastTime(LocalDateTime.now());
        user.setLoginCount(user.getLoginCount() + 1);
        userDao.save(user);*/

        request.getSession().setAttribute("SESSION_USER", user);

        //跳转之前先移除缓存
        requestCache.removeRequest(request,response);
        super.setDefaultTargetUrl("/index");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
