package com.demo.common.security.validate;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：msj
 * @date ：Created in 2021/6/8 15:51
 * @description：  验证码验证
 * @modified By：`
 * @version: 1.0
 */

@Component
public class ValidateCodeFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationFailureHandler ryAdminAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //post请求
        if (StringUtils.equalsIgnoreCase(request.getMethod(),"post")
            && StringUtils.equals("/user/login", request.getRequestURI())) {
            logger.info("图片验证码校验的URL：" + request.getRequestURI());
            try {
                this.validate(request);
            } catch (ValidateCodeException e) {
                logger.info("图片验证码失败：" + e.getMessage());
                ryAdminAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        chain.doFilter(request,response);
    }

    /**
     * 验证图片验证码
     * @param request
     */
    private void validate(HttpServletRequest request) {
        String codeInRequest = null;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request, "imageCode");
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }

        if(StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        ImageCode codeInSession = (ImageCode)request.getSession(true).getAttribute("IMAGE_CODE_SESSION");

        if(codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if(codeInSession.isExpried()) {
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equalsIgnoreCase(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }

        //验证结束后，移除session
        request.getSession(true).removeAttribute("IMAGE_CODE_SESSION");
    }
}
