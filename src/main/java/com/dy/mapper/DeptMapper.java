package com.dy.mapper;

import com.dy.entity.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huang
 * @date 2019/10/31 16:43
 * @Disc
 **/
public interface DeptMapper {
    int modifyDept(Integer deptId);

    int insertDept(Dept dept);

    int updateDept(Dept dept);

    @Select({"select deptId,deptName from sys_dept"})
    List<Dept> findDepts();
}
