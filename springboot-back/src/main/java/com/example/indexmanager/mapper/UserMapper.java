package com.example.indexmanager.mapper;

import com.example.indexmanager.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    public User selectByUsername(String username);

    @Select("select COUNT(*) from user where username=#{username}")
    public int checkExist(String username);

    @Select("select id from user where username=#{username}")
    public int getId(String username);

    @Insert("insert into user (username,password,`character`,phone,registertime,lastlogin,question,answer) values(#{username},#{password},#{character},#{phone},#{registertime},#{lastlogin},#{question},#{answer})")
    public int insert(User user);

    @Update("update user set password=#{password},phone=#{phone},mail=#{mail},address=#{address},sex=#{sex},question=#{question},answer=#{answer},picturepath=#{picturepath} where id=#{id}")
    public int update(User user);

    @Update("update user set lastlogin=#{lastlogin} where username=#{username}")
    public int updateLastLogin(String username, Date lastlogin);

    @Select("select question from user where username=#{username}")
    public String getQuestion(String username);

    @Update("update user set password=#{password} where username=#{username} and answer=#{answer}")
    public int updatePassword(User user);

    @Select("select * from user")
    public List<User> getAll();

    @Delete("delete from user where id=#{id}")
    public int delete(int id);
}
