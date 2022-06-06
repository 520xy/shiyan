package testBrand;

import com.chongligong.mapper.BrandMapper;
import com.chongligong.pojo.Brand;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class TestBrandMapper {
    @Test
    public void testSelectAll()
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        sqlSession.close();
        brands.forEach(System.out::println);
    }
}
