# 小区物业管理系统 - 客户端

基于 Spring Boot 3.2.4 + MyBatis 3.0.3 + Java 17 的小区物业管理系统客户端模块，
由成都工业职业技术学院开发，用于实现业主、楼栋、用户管理等功能。

## 项目结构

```
src/
├── main/
│   ├── java/
│   └── resources/
│       ├── application.yml          # 主配置文件（占位符形式）
│       ├── application-private.yml  # 私有配置文件（示例，不应提交）
│       └── mapper/                  # MyBatis映射文件
└── test/
```

## 数据库配置

为了防止敏感信息泄露，本项目使用占位符方式配置数据库连接信息，
真实的数据库凭证应该通过以下方式之一提供：

### 方式一：使用环境变量（推荐）

在运行应用前设置环境变量：

```bash
export DB_USERNAME=your_database_username
export DB_PASSWORD=your_database_password
```

Windows CMD:

```cmd
set DB_USERNAME=your_database_username
set DB_PASSWORD=your_database_password
```

Windows PowerShell:

```powershell
$env=DB_USERNAME="your_database_username"
$env=DB_PASSWORD="your_database_password"
```

### 方式二：使用私有配置文件

1. 编辑 `application-private.yml` 文件，填写正确的数据库用户名和密码
2. 在启动应用时指定使用的配置文件：
   ```bash
   java -jar your-application.jar --spring.config.location=classpath:/application.yml,classpath:/application-private.yml
   ```

### 方式三：命令行参数

在启动应用时通过命令行参数传递：

```bash
java -jar your-application.jar --DB_USERNAME=your_username --DB_PASSWORD=your_password
```

## 注意事项

- `application-private.yml` 已添加到 `.gitignore`，不会被提交到版本库
- 生产环境中应使用环境变量或外部配置服务来管理敏感信息
- 不要将真实的用户名和密码提交到代码仓库中

## 启动项目

```bash
mvn spring-boot:run
```

或者打包后运行：

```bash
mvn clean package
java -jar target/小区物业管理系统-物业端.jar
```