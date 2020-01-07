package com.dy.mapper;

import com.dy.entity.Role;
import com.dy.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄俊
 * @date 2019/10/30 20:25
 * @Disc
 **/
public interface UserMapper {

    User findUserByUserName(String userName);

    List<User> findUsersWithLike(Map<String, Object> paramMap);

    Set<String> findRoleNameByUserName(String userName);

    Set<String> findAllRoleNames();

    int updateUser(User user);

    int modifyUser(Integer userId);

    int insertUser(User user);

    List<Role> getRolesByUserName(String userName);

    List<String> findStatus();

    List<User> findUsers(Map<String ,Object> map);

    @Select("select * from sys_user where userId=#{userId}")
    User findUserById(Integer userId);
}
