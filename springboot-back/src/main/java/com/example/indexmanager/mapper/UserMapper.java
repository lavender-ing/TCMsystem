package com.example.indexmanager.mapper;

import com.example.indexmanager.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    public User selectByUsername(String username);

    @Select("select COUNT(*) from user where username=#{username}")
    public int checkExist(String username);

    @Select("select id from user where username=#{username}")
    public int getId(String username);

    @Insert("insert into user (username,password,`character`,phone,registertime,picturepath,lastlogin,question,answer) values(#{username},#{password},#{character},#{phone},#{registertime},#{picturepath},#{lastlogin},#{question},#{answer})")
    public int insert(User user);

    @Update("update user set password=#{password},`character`=#{character},phone=#{phone},mail=#{mail},address=#{address},sex=#{sex},picturepath=#{picturepath},question=#{question},answer=#{answer} where id=#{id}")
    public int update(User user);

    @Update("update user set lastlogin=#{lastlogin} where username=#{username}")
    public int updateLastLogin(String username, Date lastlogin);

    @Select("select question from user where username=#{username}")
    public String getQuestion(String username);

    @Update("update user set password=#{password} where username=#{username} and answer=#{answer}")
    public int updatePassword(User user);
}
