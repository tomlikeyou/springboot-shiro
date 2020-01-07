package com.dy.service.impl;

import com.dy.entity.User;
import com.dy.mapper.UserMapper;
import com.dy.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄俊
 * @date 2019/10/30 20:21
 * @Disc
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public List<User> findUsersWithLike(User user) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("userName",user.getUserName());
        paramMap.put("deptId",user.getDeptId());
        paramMap.put("status",user.getStatus());
        List<User> users = userMapper.findUsersWithLike(paramMap);
        return users;
    }


    @Override
    public Set<String> findAllRoleNames() {
        return userMapper.findAllRoleNames();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int delUser(Integer userId) {
        return userMapper.modifyUser(userId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<String> findStatus() {
        return userMapper.findStatus();
    }

    @Override
    public PageInfo<User> selectPage(Integer pageNo, Integer pageSize,Map<String ,Object> map) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> users = userMapper.findUsers(map);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    public static void main(String[] args) {
        int b[] = {23, 55, 3, 90, 88};
        quickSort(b, 0, b.length - 1);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    /*
    quick sort
     */
    static void quickSort(int a[], int low, int high) {
        int i = low, j = high;
        if (low > high) {
            return;
        }
        int temp = a[i];
        while (i < j) {
            while (i < j && temp <= a[j])
                j--;
            if (i < j)
                //找到右边第一个比temp小的值,交换
                a[i++] = a[j];
            while (i < j && a[i] < temp)
                i++;
            if (i < j)
                //找到左边第一个比temp大的值，交换
                a[j--] = a[i];
        }
        a[i] = temp;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);
    }
}
