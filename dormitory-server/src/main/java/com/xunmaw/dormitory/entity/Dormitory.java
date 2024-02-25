package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Dormitory)实体类
 *
 * 
 * @since 2023-01-14 15:07:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dormitory implements Serializable {
    private static final long serialVersionUID = -31902986619805670L;
    /**
     * 宿舍id
     */
    private Integer dId;
    /**
     * 楼宇id
     */
    private Integer buId;
    /**
     * 宿舍编号或者名称
     */
    private String name;
    /**
     * 所在楼层
     */
    private Integer floor;
    /**
     * 入住人数
     */
    private Integer livedNumber;
    /**
     * 最大人数
     */
    private Integer maxNumber;
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
     * 状态码控制删除
     */
    private Boolean status;

}

