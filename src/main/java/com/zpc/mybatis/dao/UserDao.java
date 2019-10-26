package com.zpc.mybatis.dao;
import com.zpc.mybatis.pojo.User;
import java.util.List;


public interface UserDao {

    /**
     * 根据id 查询用户信息
     * @param id
     * @return
     */
    public User queryUserById(int id);

    /**
     * 查询用户信息
     * @return
     */
    public List<User> queryUserAll();
    /**
     * 更新用户信息
     *
     * @param user
     */
    /**
     * 新增用户
     * @param user
     */
    public void insertUser(User user);
    public void updateUser(User user);
    /**
     * 根据id删除信息
     * @param id
     */
    public void deleteUser(String id);

}
