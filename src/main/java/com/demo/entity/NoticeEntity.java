package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 通知公告表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_notice")
public class NoticeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 公告ID
	 */
		@TableId
		@ApiModelProperty("公告ID")
private Integer id;
	/**
	 * 公告标题
	 */
		@ApiModelProperty("公告标题")
private String title;
	/**
	 * 公告类型（1通知 2公告）
	 */
		@ApiModelProperty("公告类型（1通知 2公告）")
private String type;
	/**
	 * 公告内容
	 */
		@ApiModelProperty("公告内容")
private String content;
	/**
	 * 公告状态（0正常 1关闭）
	 */
		@ApiModelProperty("公告状态（0正常 1关闭）")
private String status;
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
