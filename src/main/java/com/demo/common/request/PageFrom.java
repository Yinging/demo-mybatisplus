package com.demo.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ：msj
 * @date ：Created in 2021/6/24 11:55
 * @description：
 * @modified By：`
 * @version: 1.0
 */

@Data
public class PageFrom {

    @ApiModelProperty(value = "用戶名")
    private String username;

    @ApiModelProperty("密碼")
    private String password;
}
