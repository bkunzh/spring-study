### 打包，跳过测试
mvn clean package -Dmaven.test.skip=true
### java -jar 指定端口启动
java -jar spring-boot/target/spring-boot-0.0.1-SNAPSHOT.jar --server.port=9991
### maven指定端口启动
mvn spring-boot:run -Dserver.port=9912