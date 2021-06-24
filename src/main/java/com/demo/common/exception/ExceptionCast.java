package com.demo.common.exception;


import com.demo.common.response.ResultCode;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:31
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }

    public static void cast(int code, String msg) {

        throw new RRException(msg, code);
    }

}
