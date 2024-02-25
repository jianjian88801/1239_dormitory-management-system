package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Building)实体类
 *
 * 
 * @since 2023-01-14 15:07:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Building implements Serializable {
    private static final long serialVersionUID = 123740690875111447L;
    /**
     * 楼宇id
     */
    private Integer buId;
    /**
     * 楼宇名称
     */
    private String name;
    /**
     * 楼宇位置
     */
    private String location;
    /**
     * 宿管id
     */
    private Integer dMId;
    /**
     * 生成时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    /**
     * 更新次数
     */
    private Integer version;
    /**
     * 状态码是否删除
     */
    private Boolean status;

}

