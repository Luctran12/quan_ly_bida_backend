FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Sao chép các file Maven Wrapper
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Cấp quyền thực thi cho mvnw
RUN chmod +x mvnw

# Tải trước các dependency
RUN ./mvnw dependency:go-offline

# Sao chép mã nguồn ứng dụng
COPY src ./src

# Build ứng dụng và bỏ qua test
RUN ./mvnw package -DskipTests

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app/target/quan_ly_bida_backend-0.0.1-SNAPSHOT.jar"]

# Expose cổng 8081
EXPOSE 8081
