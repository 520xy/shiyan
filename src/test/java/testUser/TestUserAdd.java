package testUser;

import com.chongligong.mapper.UserMapper;
import com.chongligong.pojo.User;
import com.chongligong.util.SlqSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestUserAdd {
    @Test
    public void testAdd()
    {
        SqlSessionFactory sqlSessionFactory = SlqSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.add("xxx","32");
    }
}
