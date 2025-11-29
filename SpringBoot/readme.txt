大二一学期，企业级项目开发，项目一小区物业管理系统-管理员端。 基本功能已完成


# 小区物业管理系统 - 管理员端


## 项目简介

这是一个基于Spring Boot开发的小区物业管理系统，专为管理员设计。该系统提供了对小区建筑、楼层和房间的管理功能，以及用户管理系统。

## 功能特性

- 建筑管理：添加、删除、查询小区内的建筑物
- 楼层管理：管理建筑物内各楼层信息
- 房间管理：管理楼层内的房间信息
- 用户管理：管理系统用户及权限
- RESTful API接口设计
- 数据持久化存储

## 技术栈

- 后端框架：Spring Boot
- 数据库：MyBatis
- 依赖管理：Maven
- API文档：Swagger
- 拦截器：自定义登录拦截器
- 测试框架：JUnit

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
- UserController: 处理用户相关HTTP请求
- UserService: 提供用户业务逻辑
- UserMapper: 数据库访问接口

## 配置说明

系统使用YAML格式的配置文件：
- application.yml: 主配置文件
- application.private.yml: 私有配置文件(未包含在版本控制中)

## API文档

集成了Swagger UI，可以通过以下路径访问API文档：
```
http://localhost:8080/swagger-ui.html
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

## 部署运行

1. 确保已安装Java 8+和Maven
2. 配置数据库连接
3. 运行以下命令启动项目：
```bash
mvn spring-boot:run
```

或者打包运行：
```bash
mvn clean package
java -jar target/*.jar
```

## 开发工具

- IDE: IntelliJ IDEA
- 构建工具: Maven
- 版本控制: Git

## 注意事项

- 此为管理员端系统
- 所有接口均遵循RESTful设计规范
- 使用拦截器进行权限验证