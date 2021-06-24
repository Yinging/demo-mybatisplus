package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色和菜单关联表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_role_menu")
public class RoleMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID
	 */
		@TableId
		@ApiModelProperty("角色ID")
private Integer roleId;
	/**
	 * 菜单ID
	 */
		@ApiModelProperty("菜单ID")
private Integer menuId;

}
