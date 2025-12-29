# 🐳 F.O.O.D TCG Docker 部署指南

## 📋 目錄
- [快速開始](#快速開始)
- [環境要求](#環境要求)
- [構建和部署](#構建和部署)
- [服務管理](#服務管理)
- [監控和日誌](#監控和日誌)
- [故障排除](#故障排除)

## 🚀 快速開始

### 1. 克隆專案
```bash
git clone <repository-url>
cd F.O.O.D_tcg
```

### 2. 一鍵部署
```bash
chmod +x scripts/build.sh
./scripts/build.sh
```

### 3. 訪問應用程式
- **主應用**: http://localhost:8080
- **數據庫管理**: http://localhost:8080/h2-console
- **監控面板**: http://localhost:3000 (需啟用監控)

## 📦 環境要求

### 最低要求
- Docker 20.10+
- Docker Compose 2.0+
- 4GB RAM
- 10GB 磁盤空間

### 推薦配置
- Docker 24.0+
- Docker Compose 2.20+
- 8GB RAM
- 50GB 磁盤空間

## 🔨 構建和部署

### 開發環境
```bash
# 基本部署
docker-compose up -d

# 重新構建並部署
docker-compose up -d --build

# 查看日誌
docker-compose logs -f food-tcg-app
```

### 生產環境
```bash
# 使用部署腳本
chmod +x scripts/deploy.sh
./scripts/deploy.sh production latest

# 手動部署
docker-compose -f docker-compose.prod.yml up -d
```

### 啟用監控
```bash
# 啟動包含監控的完整堆棧
docker-compose --profile monitoring up -d
```

## 🛠️ 服務管理

### 查看服務狀態
```bash
docker-compose ps
```

### 重啟特定服務
```bash
docker-compose restart food-tcg-app
```

### 擴展服務
```bash
docker-compose up -d --scale food-tcg-app=3
```

### 更新服務
```bash
# 拉取最新映像
docker-compose pull

# 重新部署
docker-compose up -d
```

## 📊 監控和日誌

### 查看應用程式日誌
```bash
# 實時日誌
docker-compose logs -f food-tcg-app

# 最近100行日誌
docker-compose logs --tail=100 food-tcg-app
```

### 健康檢查
```bash
# 檢查應用程式健康狀態
curl http://localhost:8080/actuator/health

# 檢查所有服務
docker-compose ps
```

### 監控端點
- **應用程式指標**: http://localhost:8080/actuator/metrics
- **Prometheus 指標**: http://localhost:8080/actuator/prometheus
- **Prometheus UI**: http://localhost:9090
- **Grafana 儀表板**: http://localhost:3000

## 🔧 配置選項

### 環境變數
```bash
# 數據庫配置
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/foodtcg
SPRING_DATASOURCE_USERNAME=foodtcg
SPRING_DATASOURCE_PASSWORD=foodtcg123

# JVM 配置
JAVA_OPTS=-Xmx2g -Xms1g

# 應用程式配置
SPRING_PROFILES_ACTIVE=docker
```

### 數據持久化
```bash
# 備份數據
docker-compose exec postgres pg_dump -U foodtcg foodtcg > backup.sql

# 恢復數據
docker-compose exec -T postgres psql -U foodtcg foodtcg < backup.sql
```

## 🚨 故障排除

### 常見問題

#### 1. 端口衝突
```bash
# 檢查端口使用情況
netstat -tulpn | grep :8080

# 修改端口映射
# 在 docker-compose.yml 中修改 ports: "8081:8080"
```

#### 2. 內存不足
```bash
# 檢查容器資源使用
docker stats

# 增加 JVM 堆內存限制
JAVA_OPTS=-Xmx4g -Xms2g
```

#### 3. 數據庫連接失敗
```bash
# 檢查數據庫狀態
docker-compose logs postgres

# 重啟數據庫
docker-compose restart postgres
```

#### 4. 應用程式啟動失敗
```bash
# 查看詳細日誌
docker-compose logs food-tcg-app

# 檢查配置文件
docker-compose exec food-tcg-app cat /app/application-docker.yml
```

### 清理和重置
```bash
# 停止所有服務
docker-compose down

# 清理所有數據（警告：會刪除所有數據）
docker-compose down -v

# 清理未使用的映像
docker system prune -a
```

## 🔐 安全建議

### 生產環境安全
1. **更改默認密碼**
   ```bash
   # 修改數據庫密碼
   POSTGRES_PASSWORD=your-secure-password
   
   # 修改 Grafana 管理員密碼
   GF_SECURITY_ADMIN_PASSWORD=your-secure-password
   ```

2. **使用 HTTPS**
   - 配置 SSL 證書
   - 啟用 HTTPS 重定向

3. **網絡隔離**
   - 使用自定義網絡
   - 限制容器間通信

4. **資源限制**
   ```yaml
   deploy:
     resources:
       limits:
         cpus: '2'
         memory: 4G
       reservations:
         cpus: '1'
         memory: 2G
   ```

## 📈 性能優化

### JVM 調優
```bash
# 生產環境 JVM 參數
JAVA_OPTS=-Xmx4g -Xms2g -XX:+UseG1GC -XX:MaxGCPauseMillis=200
```

### 數據庫優化
```sql
-- PostgreSQL 性能調優
ALTER SYSTEM SET shared_buffers = '256MB';
ALTER SYSTEM SET effective_cache_size = '1GB';
ALTER SYSTEM SET maintenance_work_mem = '64MB';
```

### Nginx 優化
```nginx
# 啟用 HTTP/2
listen 443 ssl http2;

# 啟用快取
proxy_cache_path /var/cache/nginx levels=1:2 keys_zone=app_cache:10m;
```

## 📞 支援

如果遇到問題，請：
1. 查看日誌文件
2. 檢查 GitHub Issues
3. 聯繫開發團隊

---

**祝你使用愉快！** 🍔⚔️🎮
