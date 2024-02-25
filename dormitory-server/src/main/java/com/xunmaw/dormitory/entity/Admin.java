package com.xunmaw.dormitory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * 
 * @since 2023-01-14 20:02:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private static final long serialVersionUID = -60977259118231423L;
    /**
     * 管理员主键自增
     */
    private Integer id;
    /**
     * 管理员账户名
     */
    private String account;
    /**
     * 管理员密码
     */
    private String password;
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
     * 状态码是否已经删除
     */
    private Boolean status;

}

