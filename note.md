
## 1. spring boot注解
- SpringBootApplication
- EnableConfigurationProperties
- Value
- ConfigurationProperties
- PropertySource
- Configuration
---
- SpringBootTest
- RunWith
---

## 2. spring boot学习知识点
1. Hello World
2. 基础配置
- 全局配置`application.properties`
- 自定义属性值
    - 每个属性单独设置值 @Value
    - 一次性配置多个属性 @ConfigurationProperties(prefix="xx.xx")
    - 属性间引用 `mrbird.blog.wholeTitle=${mrbird.blog.name}--${mrbird.blog.title}`
    - 自定义一个配置文件 @PropertySource("classpath:test.properties")
- 通过命令行设置属性值 `java -jar xxx.jar --server.port=8081`
- Profile配置
    > 多环境配置文件必须以application-{profile}.properties的格式命名，其中{profile}为环境标识，比如application-dev.properties、application-prod.properties
    - 在application.properties文件中通过spring.profiles.active属性来设置，其值对应{profile}值，如：spring.profiles.active=dev就会加载application-dev.properties配置文件内容
    - 可以在运行jar文件的时候使用命令`java -jar xxx.jar --spring.profiles.active={profile}`切换不同的环境配置
## 3. spring boot生成可执行jar
在pom.xml中加入
```
    <!-- 生成spring-boot可执行jar包 -->
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
```
再执行mvn package即可

## 99. 参考资料
> <https://github.com/bkunzhang/springall-study-test>(fork from <https://github.com/wuyouzhuguli/SpringAll>)




