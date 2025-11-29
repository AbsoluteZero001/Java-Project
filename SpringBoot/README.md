# 小区物业管理系统 - 管理员端

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-green)
![MyBatis](https://img.shields.io/badge/MyBatis-3.0.3-blue)
![License](https://img.shields.io/badge/license-MIT-blue)

这是一个基于Spring Boot开发的小区物业管理系统，专为管理员设计。该系统提供了对小区建筑、楼层和房间的管理功能，以及用户管理系统。

## 功能特性

- 🏢 建筑管理：添加、删除、查询小区内的建筑物
- 📚 楼层管理：管理建筑物内各楼层信息
- 🚪 房间管理：管理楼层内的房间信息
- 👥 用户管理：管理系统用户及权限
- 🔐 登录认证与权限拦截
- 📱 RESTful API接口设计
- 📄 数据持久化存储
- 🖼️ 用户头像上传功能
- 📘 完整的API文档

## 技术栈

### 后端技术

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.2.4 | 核心框架 |
| MyBatis | 3.0.3 | ORM框架 |
| MySQL | 8.0.30 | 数据库 |
| Maven | - | 项目构建管理 |
| Swagger/OpenAPI | 2.6.0 | API文档生成 |
| Knife4j | 4.4.0 | 增强API文档UI |
| Log4j | 1.2.17 | 日志框架 |
| PageHelper | 1.4.4 | 分页插件 |

### 开发环境

- JDK 17
- MySQL 8.0+
- IntelliJ IDEA

## 项目结构

```
src/
├── main/
│   ├── java/com/springboot/springboot/
│   │   ├── config/          # 配置文件（Swagger配置、Web配置）
│   │   ├── controller/      # 控制层（建筑、楼层、房间、用户控制器）
│   │   ├── interceptor/     # 拦截器（登录拦截器）
│   │   ├── mapper/          # 数据访问层接口
│   │   ├── pojo/            # 实体类
│   │   ├── service/         # 业务逻辑层接口及实现
│   │   └── Application.java # Spring Boot启动类
│   └── resources/
│       ├── mapper/          # MyBatis映射文件
│       └── application.yml  # 配置文件
└── test/                    # 单元测试
```

## 核心模块

### 1. 建筑管理模块
- BuildingController: 处理建筑相关HTTP请求
- BuildingService: 提供建筑业务逻辑
- BuildingMapper: 数据库访问接口

### 2. 楼层管理模块
- FloorController: 处理楼层相关HTTP请求
- FloorService: 提供楼层业务逻辑
- FloorMapper: 数据库访问接口

### 3. 房间管理模块
- RoomController: 处理房间相关HTTP请求
- RoomService: 提供房间业务逻辑
- RoomMapper: 数据库访问接口

### 4. 用户管理模块
- UserController: 处理用户相关HTTP请求（登录、分页查询、头像上传等）
- UserService: 提供用户业务逻辑
- UserMapper: 数据库访问接口

## API文档

集成了Swagger UI和Knife4j增强文档，可以通过以下路径访问API文档：

```
http://localhost:8080/swagger-ui.html
http://localhost:8080/doc.html
```

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 部署步骤

1. 克隆项目到本地：
```bash
git clone <项目地址>
```

2. 创建数据库并导入初始数据（如有）

3. 修改配置文件中的数据库连接信息：
```yaml
# application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: your_username
    password: your_password
```

4. 编译并运行项目：
```bash
mvn clean package
java -jar target/SpringBoot-0.0.1-SNAPSHOT.jar
```

或者直接运行：
```bash
mvn spring-boot:run
```

## 测试

项目包含全面的单元测试，涵盖：
- Mapper层测试
- POJO实体类测试
- Service层测试

运行测试命令：
```bash
mvn test
```

## 配置说明

系统使用YAML格式的配置文件：
- application.yml: 主配置文件
- application-private.yml: 私有配置文件(未包含在版本控制中)

关键配置项：
```yaml
# 数据库配置
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/rpsm
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}

# 头像上传路径配置
avatar:
  upload-path: D:/springboot_upload/img/

# MyBatis配置
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.springboot.springboot.pojo
```

## 注意事项

- 此为管理员端系统
- 所有接口均遵循RESTful设计规范
- 使用拦截器进行权限验证
- 用户密码在当前版本中为明文存储，请在生产环境中加强安全性
- 当前使用的Log4j版本存在安全风险，建议升级至Log4j2

## 许可证

MIT License

## 开发团队

大二一学期企业级项目开发课程项目