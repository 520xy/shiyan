package testBrand;

import com.chongligong.mapper.BrandMapper;
import com.chongligong.pojo.Brand;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestBrandAdd {
    @Test
    public void TestAdd()
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand("米奇妙妙屋", "迪士尼", 1, "xxx", 0);
        mapper.add(brand);
        sqlSession.close();
    }
}
