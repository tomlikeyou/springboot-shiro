package com.dy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 黄俊
 * @date 2019/11/5 22:11
 * @Disc
 **/
@Data
public class Menu {
    private Integer menuId;
    private String menuName;
    private Integer parentId;
    private String url;
    private Integer orderNum;
    private Integer menuType;
    private String visiable;
    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
    private String remark;
    private String perms;
    private List<Menu> childrenList = new ArrayList<Menu>();
}
