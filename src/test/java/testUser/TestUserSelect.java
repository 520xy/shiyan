package testUser;

import com.chongligong.mapper.UserMapper;
import com.chongligong.pojo.User;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestUserSelect {
    @Test
    public void testSelect()
    {
        SqlSessionFactory sqlSessionFactory = SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User zhangsan = mapper.select("zhangsan", "123");
        sqlSession.close();
    }


}
