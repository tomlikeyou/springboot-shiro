package com.dy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄俊
 * @date 2019/10/31 14:57
 * @Disc
 **/
@Data
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String status;
    private String deleteFlag;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private String createBy;
    private String updateBy;
}
