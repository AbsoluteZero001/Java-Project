# 快递打印系统(EPS)

一个基于Java Swing的桌面应用程序，用于管理快递单据和用户信息。

## 项目简介

快递打印系统(EPS - Express Printing System)是一个简单的快递管理系统，提供快递单管理、打印管理和用户管理等功能。该系统采用Java Swing构建图形用户界面，使用MySQL作为数据存储。

## 功能模块

### 1. 用户登录
- 用户名和密码验证
- 登录状态保持

### 2. 快递单管理
- 添加快递单：录入寄件人和收件人的详细信息
- 修改快递单：更新已有快递单的信息

### 3. 打印管理
- 打印快递单：查看和打印快递单信息

### 4. 用户管理
- 添加用户：创建新的系统用户
- 修改个人密码：更改当前用户的登录密码

## 技术架构

### 后端技术
- Java SE
- JDBC连接MySQL数据库
- 面向对象编程(OOP)

### 前端技术
- Java Swing GUI框架
- AWT布局管理

### 数据库设计
系统包含两个主要的数据表：
1. `db_user`：存储用户信息(用户名、密码)
2. `db_express`：存储快递单信息(寄件人和收件人信息)

## 项目结构

```
src/
├── edu.cdivtc.dao/          # 数据访问层
│   ├── ExpressDao.java      # 快递单数据操作
│   └── UserDao.java         # 用户数据操作
├── edu.cdivtc.entity/       # 实体类
│   ├── Express.java         # 快递单实体
│   └── User.java            # 用户实体
├── edu.cdivtc.page/         # 界面层
│   ├── LoginFrame.java              # 登录界面
│   ├── MainFrame.java               # 主界面
│   ├── AddExpressPanel.java         # 添加快递单界面
│   ├── UpdateExpressPanel.java      # 更新快递单界面
│   ├── PrintExpressPanel.java       # 打印快递单界面
│   ├── AddUserPanel.java            # 添加用户界面
│   └── UpdateUserPasswordPanel.java # 修改密码界面
└── edu.cdivtc.utils/        # 工具类
    ├── DbUtils.java         # 数据库连接工具
    └── UserSaveTool.java    # 用户信息保存工具
```

## 运行环境

- Java 8或更高版本
- MySQL数据库
- 支持Swing的操作系统(Windows/Linux/Mac)

## 安装与配置

1. 克隆或下载本项目源代码
2. 在MySQL中创建数据库和表结构
3. 修改[DbUtils.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/EPS/src/edu/cdivtc/utils/DbUtils.java#file-D%3A%5CGitHub%5CHelloWorld%5CJava-Project%5C%E5%A4%A7%E4%B8%80%E4%B8%8B%5CEPS%5Csrc%5Cedu%5Ccdivtc%5Cutils%5CDbUtils.java)中的数据库连接参数
4. 编译并运行[LoginFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/EPS/src/edu/cdivtc/page/LoginFrame.java#file-D%3A%5CGitHub%5CHelloWorld%5CJava-Project%5C%E5%A4%A7%E4%B8%80%E4%B8%8B%5CEPS%5Csrc%5Cedu%5Ccdivtc%5Cpage%5CLoginFrame.java)启动程序

## 使用说明

1. 启动程序后进入登录界面
2. 输入正确的用户名和密码登录系统
3. 登录成功后进入主界面，可通过左侧菜单导航到各个功能模块
4. 可以添加、修改快递单信息，以及进行打印操作
5. 管理员可以添加新用户或修改个人密码

## 界面预览

系统主要界面包括：
- 登录界面
- 主界面(包含功能菜单)
- 快递单添加/修改界面
- 快递单打印界面
- 用户管理界面

## 注意事项

- 系统目前未实现权限控制，所有用户具有相同权限
- 密码以明文形式存储在数据库中，生产环境中应进行加密处理
- 系统缺少完善的异常处理机制，建议在实际部署中加强

## 开发者信息

本项目为学习Java Swing和JDBC开发的示例项目。