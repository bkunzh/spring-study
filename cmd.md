mvn clean package -Dmaven.test.skip=true
java -jar spring-boot/target/spring-boot-0.0.1-SNAPSHOT.jar --server.port=9991
