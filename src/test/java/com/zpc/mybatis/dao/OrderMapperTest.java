package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.Order;
import com.zpc.mybatis.pojo.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class OrderMapperTest {
    public OrderMapper orderMapper;
    public SqlSession sqlSession;

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

        //1.映射文件的命名空间（namespace）必须是mapper接口的全路径
        //2.映射文件statement的id必须与mapper接口方法名保持一致
        //3.Statement的resultType必须与mapper返回接口方法返回的类型一致
        //4.statement 的parameterType 必须和mapper接口的方法参数一致
        this.orderMapper=sqlSession.getMapper(OrderMapper.class);
    }
    @Test
    public void queryOrderWithUserByOrderNumber() throws Exception
    {
        OrderUser orderUser=orderMapper.queryOrderUserByOrderNumber("201807010001");
        System.out.println(orderUser);
    }
    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() throws  Exception {
        Order order=orderMapper.queryOrderWithUserAndDetailByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailsList());
    }
    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber() throws Exception
    {
        Order order=orderMapper.queryOrderWithUserAndDetailItemByOrderNumber("201807010001");
        System.out.println(order.getUser());
        System.out.println(order.getDetailsList());
    }



}
