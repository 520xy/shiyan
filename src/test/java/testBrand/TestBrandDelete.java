package testBrand;

import com.chongligong.mapper.BrandMapper;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestBrandDelete {
    @Test
    public void testDelete()
    {
        SqlSessionFactory sqlSessionFactory = SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(1);
        sqlSession.close();

    }
}
