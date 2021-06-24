package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
		@TableId
		@ApiModelProperty("用户ID")
private Integer id;
	/**
	 * 部门ID
	 */
		@ApiModelProperty("部门ID")
private Integer deptId;
	/**
	 * 登录账号
	 */
		@ApiModelProperty("登录账号")
private String username;
	/**
	 * 用户昵称
	 */
		@ApiModelProperty("用户昵称")
private String realName;
	/**
	 * 用户类型（00系统用户 01注册用户）
	 */
		@ApiModelProperty("用户类型（00系统用户 01注册用户）")
private String userType;
	/**
	 * 用户邮箱
	 */
		@ApiModelProperty("用户邮箱")
private String email;
	/**
	 * 手机号码
	 */
		@ApiModelProperty("手机号码")
private String phone;
	/**
	 * 用户性别（0男 1女 2未知）
	 */
		@ApiModelProperty("用户性别（0男 1女 2未知）")
private String sex;
	/**
	 * 头像路径
	 */
		@ApiModelProperty("头像路径")
private String avatar;
	/**
	 * 密码
	 */
		@ApiModelProperty("密码")
private String password;
	/**
	 * 帐号状态（0正常 1停用）
	 */
		@ApiModelProperty("帐号状态（0正常 1停用）")
private String status;
	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
		@ApiModelProperty("删除标志（0代表存在 2代表删除）")
private String delFlag;
	/**
	 * 最后登录IP
	 */
		@ApiModelProperty("最后登录IP")
private String loginIp;
	/**
	 * 最后登录时间
	 */
		@ApiModelProperty("最后登录时间")
private Date loginDate;
	/**
	 * 创建者
	 */
		@ApiModelProperty("创建者")
private String createBy;
	/**
	 * 创建时间
	 */
		@ApiModelProperty("创建时间")
private Date createTime;
	/**
	 * 更新者
	 */
		@ApiModelProperty("更新者")
private String updateBy;
	/**
	 * 更新时间
	 */
		@ApiModelProperty("更新时间")
private Date updateTime;
	/**
	 * 备注
	 */
		@ApiModelProperty("备注")
private String remark;

}
