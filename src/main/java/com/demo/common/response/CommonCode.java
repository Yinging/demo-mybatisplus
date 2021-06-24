package com.demo.common.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode {
    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, -1, "操作失败！"),
    INVALID_PARAM(false, -1, "非法参数！"),
    INVALID_CHAR(false, -1, "非法字符！"),
    UNAUTHENTICATED(false, 401, "此操作需要登陆系统！"),
    UNAUTHORISE(false, 403, "权限不足，无权操作！"),
    USER_IS_NOT_ENABLE(false, -1, "用户已被禁用！"),

    FILE_UPLOAD_FAILE(false, -1, "上传失败！"),
    FILE_CANT_NULL(false, -1, "请选择文件！"),
    FILE_INVALID(false, -1, "文件名称非法，不允许下载"),

    IDCARD_ERROR(false, -1, "身份证格式错误！"),
    EMAIL_ERROR(false, -1, "邮箱格式错误！"),
    MOBILE_ERROR(false, -1, "手机格式错误！"),

    TOKEN_CANT_NULL(false, 401, "token can't null or empty string"),
    TOKEN_VERIFY_ERROR(false, 401, "登录失效，请重新登录！"),
    SOCKET_ERROR(false, -1, "连接已断开，请刷新页面！"),
    SOCKET_SUCCESS(true, 0, "上传成功"),

    SERVER_ERROR(false, 99999, "服务器出错，联系管理员！");

    //操作是否成功
    boolean success;
    //操作代码
    int     code;
    //提示信息
    String  msg;

    private CommonCode(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }


    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }


}
