package com.banksystem.application.dao;

import com.banksystem.application.entity.UserInfo;
import junit.framework.TestCase;

/**
 * 用户信息数据访问测试类
 * 继承自TestCase类，用于测试用户信息相关的数据操作
 */
public class UserInfoDaoTest extends TestCase {
    /**
     * 测试添加用户信息的方法
     * 验证UserInfoDao的addOne方法是否能够正确添加用户信息
     */
    public void testAdduser() {
        // 创建UserInfoDao实例
        UserInfoDao userInfoDao = new UserInfoDao();
        // 创建UserInfo对象并设置用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setCardType("无限黑卡");        // 设置卡类型
        userInfo.setCardNo("202409033627");     // 设置卡号
        userInfo.setPassword("123456");         // 设置密码
        userInfo.setNickname("天地银行卡");       // 设置昵称
        userInfo.setName("Tim");               // 设置姓名
        userInfo.setAddress("杭州");             // 设置地址
        userInfo.setIdNum("330719200009091234"); // 设置身份证号
        userInfo.setMobile("17770177717");       // 设置手机号
        // 调用addOne方法添加用户信息
        userInfoDao.addOne(userInfo);
    }

/**
 * 测试通过手机号获取用户信息的方法
 * 该方法创建UserInfoDao实例，并调用其getUserByMobile方法获取指定手机号的用户信息
 * 最后将获取到的用户信息打印输出
 */
    public void testGetuserByMobile() {
        // 创建UserInfoDao对象，用于数据库操作
        UserInfoDao userInfoDao = new UserInfoDao();
        // 调用getUserByMobile方法，传入手机号"17770177717"获取用户信息
        UserInfo userByMobile = userInfoDao.getUserByMobile("17770177717");
        // 打印输出获取到的用户信息
        System.out.println(userByMobile);
    }
}

