package com.demo.common.security.validate;

import org.springframework.security.core.AuthenticationException;

/**
 * @author ：msj
 * @date ：Created in 2021/6/8 15:57
 * @description：
 * @modified By：`
 * @version: 1.0
 */

public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
