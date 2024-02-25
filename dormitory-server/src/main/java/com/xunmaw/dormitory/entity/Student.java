package com.xunmaw.dormitory.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * 
 * @since 2023-01-15 18:36:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 245299377366907940L;
    /**
     * 学生id
     */

    @JSONField(name = "id")
    @SerializedName("id")
    private Integer sId;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 账户名
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 学号
     */
    private String sNumber;
    /**
     * 1表示男，2表示女
     */
    private Integer sex;
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

