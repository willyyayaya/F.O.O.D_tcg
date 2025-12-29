#!/bin/bash

# F.O.O.D TCG Docker 構建腳本
set -e

echo "🍔 F.O.O.D TCG Docker 構建開始..."

# 顏色定義
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# 檢查 Docker 是否安裝
if ! command -v docker &> /dev/null; then
    echo -e "${RED}❌ Docker 未安裝，請先安裝 Docker${NC}"
    exit 1
fi

# 檢查 Docker Compose 是否安裝
if ! command -v docker-compose &> /dev/null; then
    echo -e "${RED}❌ Docker Compose 未安裝，請先安裝 Docker Compose${NC}"
    exit 1
fi

# 設置變數
PROJECT_NAME="food-tcg"
VERSION=${1:-"latest"}
BUILD_DATE=$(date -u +'%Y-%m-%dT%H:%M:%SZ')

echo -e "${YELLOW}📦 構建版本: ${VERSION}${NC}"
echo -e "${YELLOW}📅 構建時間: ${BUILD_DATE}${NC}"

# 清理舊的構建
echo -e "${YELLOW}🧹 清理舊的構建...${NC}"
docker-compose down --remove-orphans
docker system prune -f

# 構建應用程式
echo -e "${YELLOW}🔨 構建 F.O.O.D TCG 應用程式...${NC}"
cd ../my-app
docker build \
    --build-arg BUILD_DATE="${BUILD_DATE}" \
    --build-arg VERSION="${VERSION}" \
    -t "${PROJECT_NAME}:${VERSION}" \
    -t "${PROJECT_NAME}:latest" \
    .

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✅ 應用程式構建成功${NC}"
else
    echo -e "${RED}❌ 應用程式構建失敗${NC}"
    exit 1
fi

# 回到根目錄
cd ..

# 啟動服務
echo -e "${YELLOW}🚀 啟動服務...${NC}"
docker-compose up -d

# 等待服務啟動
echo -e "${YELLOW}⏳ 等待服務啟動...${NC}"
sleep 30

# 檢查服務狀態
echo -e "${YELLOW}🔍 檢查服務狀態...${NC}"
docker-compose ps

# 健康檢查
echo -e "${YELLOW}🏥 執行健康檢查...${NC}"
for i in {1..10}; do
    if curl -f http://localhost:8080/actuator/health > /dev/null 2>&1; then
        echo -e "${GREEN}✅ 服務健康檢查通過${NC}"
        break
    else
        echo -e "${YELLOW}⏳ 等待服務啟動... (${i}/10)${NC}"
        sleep 10
    fi
    
    if [ $i -eq 10 ]; then
        echo -e "${RED}❌ 服務健康檢查失敗${NC}"
        docker-compose logs food-tcg-app
        exit 1
    fi
done

echo -e "${GREEN}🎉 F.O.O.D TCG Docker 構建和部署完成！${NC}"
echo -e "${GREEN}🌐 應用程式訪問地址: http://localhost:8080${NC}"
echo -e "${GREEN}📊 監控面板: http://localhost:3000 (如果啟用監控)${NC}"
echo -e "${GREEN}🗄️  數據庫管理: http://localhost:8080/h2-console${NC}"
