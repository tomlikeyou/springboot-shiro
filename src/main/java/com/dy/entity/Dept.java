package com.dy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huang
 * @date 2019/10/31 15:54
 * @Disc
 **/
@Data
public class Dept implements Serializable {
    private Integer deptId;
    private String deptName;
    private Integer parentId;
    private String leader;
    private String email;
    private String status;
    private String delFlag;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;

}
