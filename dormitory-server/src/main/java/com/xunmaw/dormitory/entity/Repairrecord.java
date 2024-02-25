package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Repairrecord)实体类
 *
 * 
 * @since 2023-01-14 15:07:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repairrecord implements Serializable {
    private static final long serialVersionUID = 937176730379212952L;
    /**
     * 报修id
     */
    private Integer rId;
    /**
     * 谁报修的根据学生id去查学生所在宿舍
     */
    private Integer sId;
    /**
     * 报修日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date date;
    /**
     * 报修内容
     */
    private String title;
    /**
     * 处理人
     */
    private Integer dMId;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    /**
     * 修改次数
     */
    private Integer version;
    /**
     * 状态码是否删除
     */
    private Boolean status;
    /**
     * 处理时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date handleTime;

}

