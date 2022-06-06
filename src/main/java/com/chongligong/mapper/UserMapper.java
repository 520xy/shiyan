package com.chongligong.mapper;

import com.chongligong.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @ResultMap("userResultMap")
    @Select("select * from tb_user where user_name=#{userName} and password=#{password}")
    User select(@Param("userName") String userName,@Param("password") String password);

    @ResultMap("userResultMap")
    @Insert("insert into tb_user(user_name, password) VALUES(#{userName},#{password})")
    void add(@Param("userName") String userName,@Param("password") String password);
    @ResultMap("userResultMap")
    @Select("select * from tb_user where user_name=#{userName}")
    User selectByName(String userName);


}
