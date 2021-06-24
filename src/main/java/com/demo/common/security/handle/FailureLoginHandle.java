package com.demo.common.security.handle;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：msj
 * @date ：Created in 2021/5/21 10:44
 * @description：
 * @modified By：`
 * @version: 1.0
 */

@Component("failureLoginHandle")
public class FailureLoginHandle extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("登录失败");
        String message="";
        switch (exception.getMessage()) {
            case "UserDetailsService returned null, which is an interface contract violation":
                message="账号不存在";
                break;
            default:
                message=exception.getMessage();
                break;
        }
        request.getSession(true).setAttribute("message", message);
        super.setDefaultFailureUrl("/login");
        super.onAuthenticationFailure(request, response, exception);
    }
}
