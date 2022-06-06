package testBrand;

import com.chongligong.mapper.BrandMapper;
import com.chongligong.pojo.Brand;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestBrandUpdata {
    @Test
    public void testUpdata()
    {
        SqlSessionFactory sqlSessionFactory= SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand= mapper.selectById(100);
        if(brand!=null){brand.setBrandName("良品铺子");brand.setCompanyName("良品铺子有限公司");}
        else System.out.println("该品牌不存在");
    }
}
