package com.dy.service;

import com.dy.entity.Dept;

import java.util.List;

/**
 * @author huang
 * @date 2019/10/31 16:42
 * @Disc
 **/
public interface IDeptService {
    int delDept(Integer deptId);

    int addDept(Dept dept);

    int updateDept(Dept dept);

    List<Dept> findDepts();

}
