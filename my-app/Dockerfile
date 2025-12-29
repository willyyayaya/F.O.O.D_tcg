# F.O.O.D TCG Docker 多階段構建
# Stage 1: 構建階段
FROM maven:3.8.6-openjdk-11-slim AS builder

# 設置工作目錄
WORKDIR /app

# 複製 Maven 配置文件
COPY pom.xml .

# 下載依賴（利用 Docker 層緩存）
RUN mvn dependency:go-offline -B

# 複製源代碼
COPY src ./src

# 構建應用程式
RUN mvn clean package -DskipTests

# Stage 2: 運行階段
FROM openjdk:11-jre-slim

# 安裝必要工具
RUN apt-get update && apt-get install -y \
    curl \
    && rm -rf /var/lib/apt/lists/*

# 創建應用用戶（安全性）
RUN groupadd -r foodtcg && useradd -r -g foodtcg foodtcg

# 設置工作目錄
WORKDIR /app

# 從構建階段複製 JAR 文件
COPY --from=builder /app/target/*.jar app.jar

# 創建數據目錄
RUN mkdir -p /app/data && chown -R foodtcg:foodtcg /app

# 切換到應用用戶
USER foodtcg

# 暴露端口
EXPOSE 8080

# 健康檢查
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# 啟動應用程式
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# 可選的 JVM 參數
CMD ["--spring.profiles.active=docker"]
