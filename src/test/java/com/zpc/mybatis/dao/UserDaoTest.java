package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;
    public UserMapper userMapper;

    public void setUp() throws Exception{
        //mybatis-config.xml
        String resource="mybatis-config.xml";
        //读取配置文件
        InputStream is= Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //sqlSession获取
        sqlSession=sqlSessionFactory.openSession();
    }
    @Test
    public void queryUserById()  throws  Exception{
            System.out.println(userDao.queryUserById(1));
    }

    @Test
    public void queryUserAll() {
        List<User> userList=this.userDao.queryUserAll();
        for(User user: userList)
        {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        User user=new User();
        user.setAge(17);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("hj");
        this.userDao.insertUser(user);
        this.sqlSession.commit();

    }

    @Test
    public void updateUser() {
        User user=new User();
        user.setBirthday(new Date());
        user.setName("静止");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evan");
        user.setId(4);
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
    }
}