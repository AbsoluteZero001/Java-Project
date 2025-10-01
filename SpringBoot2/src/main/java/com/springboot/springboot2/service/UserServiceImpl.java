package com.springboot.springboot2.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot2.mapper.UserMapper;
import com.springboot.springboot2.pojo.PageResult;
import com.springboot.springboot2.pojo.User;
import com.springboot.springboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) throws DuplicateKeyException, Exception {
        return userMapper.insertUser(user);
    }

    @Override
    public PageResult<User> pageOfOwner(int current, int size) {
        // 参数校验
        if (current < 1) current = 1;
        if (size < 1) size = 10;

        // 开启分页
        PageHelper.startPage(current, size);

        // 调用 Mapper 查询
        Page<User> page = userMapper.owners();

        // 封装成 PageResult
        return PageResult.restPage(page);
    }
}
