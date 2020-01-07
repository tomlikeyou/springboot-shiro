package com.dy.service.impl;

import com.dy.entity.Dept;
import com.dy.mapper.DeptMapper;
import com.dy.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huang
 * @date 2019/10/31 16:42
 * @Disc
 **/
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public int delDept(Integer deptId) {

        return deptMapper.modifyDept(deptId);
    }

    @Override
    public int addDept(Dept dept) {

        return deptMapper.insertDept(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public List<Dept> findDepts() {
        return deptMapper.findDepts();
    }
}
