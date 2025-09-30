package com.springboot.springboot2.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot2.mapper.UserMapper;
import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    // 构造函数注入 Mapper（推荐方式）
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insertUser(User user) throws Exception {
        // 默认密码
        user.setPassword("123456");

        // 设置用户类型和状态
        user.setUserType((short) 3);   // 业主类型
        user.setUserStatus((short) 3); // 未激活状态

        // 生成唯一账号
        String account = generateUniqueAccount(user.getUsername());
        user.setAccount(account);

        // 插入数据库，并捕获唯一索引异常
        try {
            return insertUserWithExceptionHandling(user);
        } catch (DuplicateKeyException e) {
            System.out.println("账号已存在，可能触发唯一索引: " + user.getAccount());
            throw e; // 上层可根据需要处理
        }
    }

    private int insertUserWithExceptionHandling(User user) throws DuplicateKeyException {
        return userMapper.insertUser(user);
    }

    private String generateUniqueAccount(String username) throws Exception {
        String account;
        int maxRetry = 5; // 最多尝试 5 次
        int attempt = 0;

        do {
            String base = DigestUtils.md5DigestAsHex(username.getBytes(StandardCharsets.UTF_8))
                    .substring(13, 20);
            account = base + (System.currentTimeMillis() % 10000);

            try {
                // 检查账号是否已存在
                if (userMapper.countByAccount(account) == 0) {
                    return account; // 唯一，返回
                }
            } catch (Exception e) {
                throw new Exception("检查账号唯一性失败", e);
            }

            attempt++;
        } while (attempt < maxRetry);

        throw new Exception("生成唯一账号失败，请稍后重试");
    }

    /**
     * 分页查询业主信息
     */
    @Override
    public PageResult<User> pageOfOwner(int current, int size) {
        if (current < 1) current = 1;
        if (size < 1) size = 10;

        PageHelper.startPage(current, size);
        Page<User> page = userMapper.owners(); // 调用 Mapper 方法，保证 userMapper 已注入
        return PageResult.restPage(page);
    }

    // ❌ 删除原来在类末尾直接调用 Mapper 的字段
    // Page<User> page = userMapper.owners(); // 不要在类中直接调用 Mapper
}
