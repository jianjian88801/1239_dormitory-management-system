package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (DormitoryManager)实体类
 *
 * 
 * @since 2023-01-14 15:07:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DormitoryManager implements Serializable {
    private static final long serialVersionUID = 291795314949608769L;
    /**
     * 宿管id
     */
    private Integer id;
    /**
     * 宿管真实姓名
     */
    private String name;
    /**
     * 登录账号
     */
    private String account;
    /**
     * 宿管登录密码
     */
    private String password;
    /**
     * 1男 2女
     */
    private Integer sex;
    /**
     * 宿管评分，按照每一个学生打分去除最高最低取平均分，最高十分，初始为0
     */
    private Integer score;
    /**
     * 宿管编号
     */
    private String dManagerNum;
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
     * 更新次数
     */
    private Integer version;
    /**
     * 状态码
     */
    private Boolean status;

}

