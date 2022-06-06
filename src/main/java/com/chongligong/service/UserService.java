package com.chongligong.service;

import com.chongligong.mapper.UserMapper;
import com.chongligong.pojo.User;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
     public User select(String userName, String password)
     {
         SqlSession sqlSession = sqlSessionFactory.openSession();
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         User select = mapper.select(userName, password);
         sqlSession.close();
         return select;
     }
     public void addUser(String userName,String password)
     {
         SqlSession sqlSession = sqlSessionFactory.openSession(true);
         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
         mapper.add(userName,password);
         sqlSession.close();
     }
    public User selectByName(String userName)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByName(userName);
        sqlSession.close();
        return user;

    }
}
