package com.dy.service;

import com.dy.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄俊
 * @date 2019/10/30 20:21
 * @Disc
 **/
public interface IUserService {

    User getUserByUserName(String userName);

    List<User> findUsersWithLike(User user);

    Set<String> findAllRoleNames();

    int updateUser(User user);

    int delUser(Integer userId);

    int insertUser(User user);

    List<String> findStatus();

    PageInfo<User> selectPage(Integer pageNo, Integer pageSize, Map<String ,Object> map);

    User findUserById(Integer userId);
}
