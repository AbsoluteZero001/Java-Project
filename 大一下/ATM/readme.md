# ATM自动存取款系统

一个基于Java Swing开发的ATM模拟系统，具有用户开户、登录、存款、取款等功能。

## 项目简介

本项目是一个模拟ATM机操作的Java桌面应用程序。用户可以通过该系统进行开户、登录、存款、取款等基本银行业务操作。系统采用面向对象的设计思想，使用Swing组件构建图形用户界面，具备良好的用户体验。

## 功能特性

### 主要功能模块：

1. **用户开户**
   - 输入姓名、身份证号码、性别等信息完成开户
   - 自动生成15位银行卡号和默认密码(123456)

2. **用户登录**
   - 使用银行卡号和密码登录系统
   - 输入验证确保数据合法性

3. **主菜单功能**
   - 存取款操作
   - 定存咨询
   - 贷款咨询
   - 未来资产查询
   - 账号管理(待开发)
   - 其他功能(待开发)

4. **存款功能**
   - 支持存款操作
   - 实时更新账户余额

5. **取款功能**
   - 支持取款操作
   - 余额不足提醒

## 技术架构

- **编程语言**: Java
- **GUI框架**: Java Swing
- **设计模式**: 面向对象编程
- **项目结构**:
  ```
  src/
  ├── commons/       # 公共组件样式类
  ├── dao/           # 数据访问层
  ├── entity/        # 实体类
  ├── page/          # 界面页面
  ├── utils/         # 工具类
  └── images/        # 图片资源
  ```

## 类说明

### 实体类
- [Account.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/entity/Account.java): 银行账户实体类，包含卡号、密码、余额等属性
- [User.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/entity/User.java): 用户实体类，包含用户基本信息及账户列表

### 界面类
- [LoginFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/commons/LoginFrame.java): 登录界面
- [RegisterFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/RegisterFrame.java): 开户界面
- [MainFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/MainFrame.java): 主功能界面
- [DepositWithdrawFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/DepositWithdrawFrame.java): 存取款界面
- [FixedDepositFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/FixedDepositFrame.java): 定存咨询界面
- [LoanFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/LoanFrame.java): 贷款咨询界面
- [FutureAssetsFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/page/FutureAssetsFrame.java): 未来资产查询界面

### 工具类
- [ComponentStyle.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/commons/ComponentStyle.java): 组件样式统一设置工具类
- [UserDao.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/dao/UserDao.java): 用户数据访问类
- [AccountDao.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/dao/AccountDao.java): 账户数据访问类
- [UserSaveTool.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/utils/UserSaveTool.java): 用户信息缓存工具类
- [ColorUtils.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/utils/ColorUtils.java): 颜色常量工具类
- [DbUtils.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/utils/DbUtils.java): 数据库连接工具类

## 运行环境

- Java 8 或更高版本
- 支持Swing的Java运行环境

## 如何运行

1. 克隆或下载本项目源代码
2. 使用IntelliJ IDEA或其他Java IDE打开项目
3. 编译并运行[LoginFrame.java](file:///D:/GitHub/HelloWorld/Java-Project/%E5%A4%A7%E4%B8%80%E4%B8%8B/ATM/src/edu/cdivtc/commons/LoginFrame.java)中的main方法启动程序
4. 在登录界面可选择开户或直接登录

## 使用说明

1. **开户流程**：
   - 点击登录界面的"开户"按钮进入开户界面
   - 填写姓名、身份证号码、选择性别
   - 点击"确认"按钮完成开户，系统会自动生成卡号和默认密码

2. **登录流程**：
   - 在登录界面输入15位银行卡号和密码
   - 默认密码为123456，可在开户后修改
   - 登录成功后进入主功能界面

3. **主要操作**：
   - 主界面提供多个功能选项，包括存取款、定存咨询等
   - 点击相应按钮即可进入对应功能界面

## 注意事项

- 本系统为模拟演示系统，不涉及真实银行业务
- 所有数据存储在内存中，程序关闭后数据不会保留
- 卡号必须为15位数字
- 系统部分功能仍在开发中，标记为"暂未开通"

## 项目截图

![登录界面](src/images/login.png)
![主界面](src/images/mainbg.jpg)

## 许可证

本项目仅供学习交流使用。