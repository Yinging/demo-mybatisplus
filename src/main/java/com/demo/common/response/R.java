package com.demo.common.response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
@Data
@NoArgsConstructor
public class R implements Response {

    private static final long serialVersionUID = 1L;
    //操作是否成功
    boolean success = SUCCESS;

    //操作代码
    int code = SUCCESS_CODE;

    //提示信息
    String msg;

    //返回数据
    Object data;

    public R(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.msg = resultCode.msg();
    }

    public R(ResultCode resultCode, Object data) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.msg = resultCode.msg();
        this.data = data;
    }

    public static R SUCCESS() {
        return new R(CommonCode.SUCCESS);
    }

    public static R SUCCESS(Object data) {
        return new R(CommonCode.SUCCESS, data);
    }

    public static R FAIL() {
        return new R(CommonCode.FAIL);
    }

    public static R FAIL(String message) {
        return new R(false, -1, message);
    }

    public R(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

}
