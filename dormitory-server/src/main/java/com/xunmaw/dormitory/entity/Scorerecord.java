package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Scorerecord)实体类
 *
 * 
 * @since 2023-01-16 04:09:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scorerecord implements Serializable {
    private static final long serialVersionUID = 618625245174323699L;
    /**
     * 主键
     */
    private Integer scoreId;
    /**
     * 谁打的分
     */
    private Integer sId;
    /**
     * 给谁打的分
     */
    private Integer dMId;
    /**
     * 打分时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createtime;
    /**
     * 打了多少分
     */
    private Integer number;
}

