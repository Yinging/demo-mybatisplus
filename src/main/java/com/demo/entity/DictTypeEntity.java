package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典类型表
 * 
 * @author msj
 * @email
 * @date 2021-06-24 11:48:20
 */
@Data
@TableName("sys_dict_type")
public class DictTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 字典主键
	 */
		@TableId
		@ApiModelProperty("字典主键")
private Integer id;
	/**
	 * 字典名称
	 */
		@ApiModelProperty("字典名称")
private String dictName;
	/**
	 * 字典类型
	 */
		@ApiModelProperty("字典类型")
private String type;
	/**
	 * 状态（0正常 1停用）
	 */
		@ApiModelProperty("状态（0正常 1停用）")
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
