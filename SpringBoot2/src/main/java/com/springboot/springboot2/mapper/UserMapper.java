package com.springboot.springboot2.mapper;

import com.github.pagehelper.Page;
import com.springboot.springboot2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增用户
     */
    int insertUser(User user);

    /**
     * 删除用户（根据ID）
     */
    int deleteUserById(@Param("id") Integer id);

    /**
     * 更新用户
     */
    int updateUser(User user);

    /**
     * 查询所有用户
     */
    List<User> selectAllUsers();

    /**
     * 根据账号查询单个用户
     */
    User selectUserByAccount(@Param("account") String account);

    /**
     * 检查账号是否存在（返回数量）
     */
    int countByAccount(@Param("account") String account);

    /**
     * 分页查询业主列表
     * 注意：必须返回 Page<User>
     */
    Page<User> owners();
}
