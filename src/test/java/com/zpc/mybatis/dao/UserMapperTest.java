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

public class UserMapperTest {

    public UserMapper userMapper;
    public UserMapper userMapper1;
    public SqlSession sqlSession;
    public SqlSession sqlSession1;
    @Before
    public void setUp() throws Exception{
        //指定配置文件
        String resource="mybatis-config.xml";
        //读取配置文件
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        sqlSession=sqlSessionFactory.openSession(true);
        sqlSession1=sqlSessionFactory.openSession(true);

        //1.映射文件的命名空间（namespace）必须是mapper接口的全路径
        //2.映射文件statement的id必须与mapper接口方法名保持一致
        //3.Statement的resultType必须与mapper返回接口方法返回的类型一致
        //4.statement 的parameterType 必须和mapper接口的方法参数一致
        this.userMapper=sqlSession.getMapper(UserMapper.class);
        this.userMapper1=sqlSession1.getMapper(UserMapper.class);
    }

    @Test
    public void testQueryUserByTableName()
    {
        List<User> userList=this.userMapper.queryUserByTableName("tb_user");
        for(User user:userList)
        {
            System.out.println(user);
        }
    }

    @Test
    public void testLogin()
    {
        System.out.println(this.userMapper.login("hj","123456"));
    }

    @Test
    public void testQueryUserById()
    {
        System.out.println(this.userMapper.queryUserById(1));
    }

    @Test
    public void testQueryUserAll()
    {
        List<User> userList=this.userMapper.queryUserAll();
        for(User user:userList)
        {
            System.out.println(user);
        }
    }

    @Test
    public void testInsertUser()
    {
        User user=new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("贵");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("BIGLAO");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser()
    {
        User user=new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("兴");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("BIGLAO");
        user.setId(1);
        this.userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById()
    {
        this.userMapper.deleteUserById(6);
    }

    @Test
    public void testQueryUserList()
    {
        List<User> users=this.userMapper.queryUserList("大鹏");
        for(User user: users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListByNameAndAge() throws Exception{
        List<User> users=this.userMapper.queryUserListByNameAndAge("大鹏",16);
        for(User user: users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void test1UpdateUser(){
        User user=new User();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId(1);
        user.setAge(20);
        this.userMapper.updateUserIn(user);
    }

    @Test
    public void queryUserListByIds() throws  Exception{
        List<User> users=this.userMapper.queryUserListByIds(new Integer[]{2,3,4});
        for(User user:users)
        {
            System.out.println(user);
        }
    }

    /**
     * 一级缓存 默认开启 SqlSession 的缓存  而由于是SqlSession 层面的缓存 因此没必要序列化
     * 对于不同的SqlSession 不能共享相同的缓存 因此开启二级缓存
     */
    @Test
    public void testQueryUserById1()
    {
        System.out.println(this.userMapper.queryUserById(1));
        //sqlSession.clearCache() 可以强制清除缓存
        sqlSession.clearCache();
        System.out.println(this.userMapper.queryUserById(1));
    }

    /**
     * 执行update、insert、detele的时候 会清空缓存
     */
    @Test
    public void testQueryUser()
    {
        System.out.println(this.userMapper.queryUserById(1));
        sqlSession.close();
        System.out.println(this.userMapper1.queryUserById(1));
    }


}
