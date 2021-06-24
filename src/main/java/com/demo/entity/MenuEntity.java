package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 菜单权限表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_menu")
public class MenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID
	 */
		@TableId
		@ApiModelProperty("菜单ID")
private Integer id;
	/**
	 * 菜单名称
	 */
		@ApiModelProperty("菜单名称")
private String menuName;
	/**
	 * 父菜单ID
	 */
		@ApiModelProperty("父菜单ID")
private Integer parentId;
	/**
	 * 显示顺序
	 */
		@ApiModelProperty("显示顺序")
private Integer sort;
	/**
	 * 请求地址
	 */
		@ApiModelProperty("请求地址")
private String url;
	/**
	 * 菜单类型（M目录 C菜单 F按钮）
	 */
		@ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
private String menuType;
	/**
	 * 菜单状态（0显示 1隐藏）
	 */
		@ApiModelProperty("菜单状态（0显示 1隐藏）")
private String visible;
	/**
	 * 是否刷新（0刷新 1不刷新）
	 */
		@ApiModelProperty("是否刷新（0刷新 1不刷新）")
private String isRefresh;
	/**
	 * 权限标识
	 */
		@ApiModelProperty("权限标识")
private String perms;
	/**
	 * 菜单图标
	 */
		@ApiModelProperty("菜单图标")
private String icon;
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
