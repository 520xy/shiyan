package com.chongligong.service;

import com.chongligong.mapper.BrandMapper;
import com.chongligong.pojo.Brand;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
      private   SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> selectAll()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }
    public void add(Brand brand)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.close();
    }

    public void updata(Brand brand)
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        if(brand!=null)mapper.update(brand);
        sqlSession.close();
    }

    public Brand select(Integer id)
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void deleteById(Integer id)
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
         mapper.deleteById(id);
        sqlSession.close();
    }
}
