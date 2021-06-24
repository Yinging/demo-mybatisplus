package com.demo.common.exception;

import cn.hutool.core.exceptions.ValidateException;
import com.demo.common.response.CommonCode;
import com.demo.common.response.R;
import com.demo.common.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.ValidationException;

//import org.springframework.security.access.AccessDeniedException;

/**
 * 统一异常捕获类
 *
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:32
 **/
@ControllerAdvice//控制器增强
@Slf4j
public class ExceptionCatch {

    //定义map，配置异常类型所对应的错误代码
    private static   ImmutableMap<Class<? extends Throwable>, ResultCode>         EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public R customException(CustomException customException) {
        customException.printStackTrace();
        //记录日志
        log.error("catch exception:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new R(resultCode);
    }

    //捕获RRException此类异常
    @ExceptionHandler(RRException.class)
    @ResponseBody
    public R handleRRException(RRException rRException) {
        int code = rRException.getCode();
        String msg = rRException.getMsg();
        R r = new R(false, code, msg);
        //记录日志
        log.error("catch exception:{}", rRException.getMessage());

        return r;
    }

    //捕获ValidateException此类异常
    @ExceptionHandler(ValidateException.class)
    @ResponseBody
    public R handleRRException(ValidateException validateException) {
        String msg = validateException.getMessage();
        R r = new R(false, -1, msg);
        //记录日志
        log.error("catch exception:{}", validateException.getMessage());

        return r;
    }

    //ValidationException
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public R handleValidationException(ValidationException v) {
        String msg = v.getMessage();
        R r = new R(false, -1, msg);
        //记录日志
        log.error("catch exception:{}", v.getMessage());

        return r;
    }

    //AccessDeniedException
   /* @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public R handleAccessDeniedException(AccessDeniedException accessDeniedException) {
        String msg = accessDeniedException.getMessage();
        R r = new R(CommonCode.UNAUTHORISE);
        //记录日志
        log.error("catch exception:{}", accessDeniedException.getMessage());

        return r;
    }*/

    //捕获TooManyResultsException此类异常
    @ExceptionHandler(MyBatisSystemException.class)
    @ResponseBody
    public R handleMyBatisSystemException(MyBatisSystemException e) {
        String msg = e.getMessage();
        R r = new R(false, 500, msg);
        //记录日志
        log.error("catch exception:{}", e.getMessage());

        return r;
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public R handlerNoFoundException(Exception e) {
        log.error(e.getMessage(), e);
        R r = new R(false, 404, "路径不存在，请检查路径是否正确");
        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public R handlerDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        R r = new R(false, -1, "提交了重复数据");
        return r;
    }


    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exception(Exception exception) {
        exception.printStackTrace();
        //记录日志
        log.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();//EXCEPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new R(resultCode);
        } else {
            //返回99999异常
            return new R(CommonCode.SERVER_ERROR);
        }


    }

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }
}
