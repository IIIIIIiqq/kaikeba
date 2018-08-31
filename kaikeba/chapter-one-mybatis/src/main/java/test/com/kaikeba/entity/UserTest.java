package test.com.kaikeba.entity; 

import com.kaikeba.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.InputStream;
import java.util.Date;

/** 
* User Tester. 
* 
* @author <Authors name> 
* @since <pre>2018年8月31日</pre>
* @version 1.0 
*/ 
public class UserTest {
    SqlSessionFactory sqlSessionFactory;
@Before
public void before() throws Exception {
    String resource = "mybatisConfig.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
} 

@After
public void after() throws Exception { 
} 

@Test
public void testSelect() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        User user = sqlSession.selectOne("test.getById", 1);
        System.out.println(user);
    } catch (Exception e) {
    } finally {
        sqlSession.close();
    }
}
@Test
public void testUpdate() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        User u = new User();
        u.setAddress("qf");
        u.setSex('1');
        u.setUsername("aaa");
        u.setId(110110);
        int rowNum= sqlSession.update("test.updateById", u);
        System.out.println(rowNum);
        if (1 == rowNum)
            sqlSession.commit();
    } catch (Exception e) {
    } finally {
        sqlSession.close();
    }
}
@Test
public void testDelete() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        int rowNum = sqlSession.delete("test.deleteById", 110110);
        System.out.println(rowNum);
        if (1 == rowNum)
            sqlSession.commit();
    } catch (Exception e) {
    } finally {
        sqlSession.close();
    }
}
@Test
public void testInsert() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
        User u = new User();
        u.setAddress("qf111");
        u.setSex('2');
        u.setUsername("aaa1111");
        u.setId(110110);
        u.setBirthday(new Date());
        int rowNum = sqlSession.insert("test.addUser", u);
        System.out.println(rowNum);
        if (1 == rowNum)
            sqlSession.commit();
    } catch (Exception e) {
    } finally {
        sqlSession.close();
    }
}


} 
