package com.springboot.springboot2.service;

import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.User;
import org.springframework.dao.DuplicateKeyException;

/**
 * 用户服务接口
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param user 用户实体
     * @return 插入成功的记录数（一般是 1）
     * @throws DuplicateKeyException 唯一索引冲突
     * @throws Exception             其他异常
     */
    int insertUser(User user) throws DuplicateKeyException, Exception;

    /**
     * 分页查询业主信息
     *
     * @param current 当前页码
     * @param size    每页条数
     * @return PageResult<User>
     */
    PageResult<User> pageOfOwner(int current, int size);
}
