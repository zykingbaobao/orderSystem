package com.ffcs.order.mapper;

import com.ffcs.order.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user(userId,userName,password) values (#{userId},#{userName},#{password})")
    int addUser(User user);

    @Delete("delete from t_user where userId=#{userId}")
    int deleteUser(String id);

    @Update("update t_user set userName=#{userName},address=#{address},password=#{password},updateTime=#{updateTime}")
    int updateUser(User user);

    @Select("select * from t_user where userId=#{userId} and userName like CONCAT('%',#{userName},'%')")
    List<User> getUserByNameAndId(User user);

    @Select("select * from t_user where userId=#{userId}")
    List<User> getUserById(User user);

    @Select("select * from t_user where userName like CONCAT('%',#{userName},'%')")
    List<User> getUserByName(User user);

    @Select("select * from t_user u where u.userId=#{userId} and u.password=#{password}")
    User isLogin(User user);
}  