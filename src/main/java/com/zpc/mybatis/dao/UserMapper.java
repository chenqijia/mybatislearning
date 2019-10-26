package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 登录（直接通过使用注解制定传入参数的名称）
     * @param userName
     * @param password
     * @return
     */
    public User login(@Param("userName") String userName,@Param("password") String password);

    /**
     * 根据表名查询用户的信息
     * @param tableName
     * @return
     */
    public List<User> queryUserByTableName(@Param("tableName")String tableName);

    /**
     * 查询全部用户信息
     * @return
     */
    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(int id);



    public List<User> queryUserAll();

    /**
     * 新增用户的信息
     * @param  user
     */
    public void insertUser(User user);

    /**
     * 根据id 新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id 删除用户信息
     * @param id
     */

    public void deleteUserById(int id);

    /**
     * 查询男性用户  输入姓名 按照姓名查询
     * @param name
     * @return
     */
    public List<User> queryUserList(@Param("name") String name);

    /**
     * 如果输入名字 则按照名字查询 如果输入年龄 就按照年龄查询 如果两个都输入了 就都按来查询
     * @param name
     * @param age
     * @return
     */
    List<User> queryUserListByNameAndAge(@Param("name")String name,@Param("age")Integer age );

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUserIn(User user);

    /**
     * 按多个Id查询
     * @param ids
     * @return
     */

    List<User> queryUserListByIds(@Param("ids") Integer[] ids);
}
