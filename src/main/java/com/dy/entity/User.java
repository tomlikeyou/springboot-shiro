package com.dy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huang
 * @date 2019/10/30 20:22
 * @Disc
 **/
@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String password;
    private String status;
    private String email;
    private String sex;
    private String phone;
    private Integer deptId;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;
    private Integer deleteFlag;
    private Dept dept;
}
