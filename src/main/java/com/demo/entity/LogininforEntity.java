package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 系统访问记录
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_logininfor")
public class LogininforEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 访问ID
	 */
		@TableId
		@ApiModelProperty("访问ID")
private Integer id;
	/**
	 * 登录账号
	 */
		@ApiModelProperty("登录账号")
private String username;
	/**
	 * 登录IP地址
	 */
		@ApiModelProperty("登录IP地址")
private String ipaddr;
	/**
	 * 登录地点
	 */
		@ApiModelProperty("登录地点")
private String location;
	/**
	 * 浏览器类型
	 */
		@ApiModelProperty("浏览器类型")
private String browser;
	/**
	 * 操作系统
	 */
		@ApiModelProperty("操作系统")
private String os;
	/**
	 * 登录状态（0成功 1失败）
	 */
		@ApiModelProperty("登录状态（0成功 1失败）")
private String status;
	/**
	 * 提示消息
	 */
		@ApiModelProperty("提示消息")
private String msg;
	/**
	 * 访问时间
	 */
		@ApiModelProperty("访问时间")
private Date loginTime;

}
