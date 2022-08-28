package com.offcn.edu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author Vinchen
 * @since 2022-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Course对象", description="课程表")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程编号")
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    @ApiModelProperty(value = "课程名称")
    @TableField("courseName")
    private String courseName;

    @ApiModelProperty(value = "课程简介")
    private String descs;

    @ApiModelProperty(value = "课程类型")
    @TableField("courseType")
    private Integer courseType;

    @ApiModelProperty(value = "课程图片地址")
    @TableField("courseImage")
    private String courseImage;

    @ApiModelProperty(value = "课程视频地址")
    @TableField("courseVideo")
    private String courseVideo;

    @ApiModelProperty(value = "价格")
    @TableField("coursePrice")
    private BigDecimal coursePrice;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "上传时间")
    @TableField("createTime")
    private Date createTime;


}
