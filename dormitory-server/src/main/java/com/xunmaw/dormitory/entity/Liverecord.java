package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Liverecord)实体类
 *
 * 
 * @since 2023-01-14 15:07:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liverecord implements Serializable {
    private static final long serialVersionUID = -54571904354148940L;
    
    private Integer lId;
    /**
     * 入住日期
     */
    private Date liveDate;
    /**
     * 对应宿舍
     */
    private Integer dId;
    /**
     * 对应学生
     */
    private Integer sId;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    /**
     * 修改次数
     */
    private Integer version;
    /**
     * 状态码
     */
    private Boolean status;

}

