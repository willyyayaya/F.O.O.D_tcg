#!/bin/bash

# F.O.O.D TCG 部署腳本
set -e

echo "🚀 F.O.O.D TCG 部署腳本"

# 顏色定義
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# 部署環境
ENVIRONMENT=${1:-"development"}
VERSION=${2:-"latest"}

echo -e "${BLUE}🌍 部署環境: ${ENVIRONMENT}${NC}"
echo -e "${BLUE}📦 部署版本: ${VERSION}${NC}"

# 根據環境選擇配置
case $ENVIRONMENT in
    "development")
        COMPOSE_FILE="docker-compose.yml"
        ;;
    "staging")
        COMPOSE_FILE="docker-compose.staging.yml"
        ;;
    "production")
        COMPOSE_FILE="docker-compose.prod.yml"
        ;;
    *)
        echo -e "${RED}❌ 不支援的環境: ${ENVIRONMENT}${NC}"
        echo -e "${YELLOW}支援的環境: development, staging, production${NC}"
        exit 1
        ;;
esac

# 檢查配置文件是否存在
if [ ! -f "$COMPOSE_FILE" ]; then
    echo -e "${RED}❌ 配置文件不存在: ${COMPOSE_FILE}${NC}"
    exit 1
fi

# 停止現有服務
echo -e "${YELLOW}🛑 停止現有服務...${NC}"
docker-compose -f $COMPOSE_FILE down

# 拉取最新映像
echo -e "${YELLOW}📥 拉取最新映像...${NC}"
docker-compose -f $COMPOSE_FILE pull

# 啟動服務
echo -e "${YELLOW}🚀 啟動服務...${NC}"
docker-compose -f $COMPOSE_FILE up -d

# 等待服務啟動
echo -e "${YELLOW}⏳ 等待服務啟動...${NC}"
sleep 30

# 檢查服務狀態
echo -e "${YELLOW}🔍 檢查服務狀態...${NC}"
docker-compose -f $COMPOSE_FILE ps

# 顯示日誌
echo -e "${YELLOW}📋 顯示服務日誌...${NC}"
docker-compose -f $COMPOSE_FILE logs --tail=50 food-tcg-app

echo -e "${GREEN}✅ 部署完成！${NC}"

# 根據環境顯示訪問信息
case $ENVIRONMENT in
    "development")
        echo -e "${GREEN}🌐 開發環境訪問地址: http://localhost:8080${NC}"
        ;;
    "staging")
        echo -e "${GREEN}🌐 測試環境訪問地址: https://staging.foodtcg.com${NC}"
        ;;
    "production")
        echo -e "${GREEN}🌐 生產環境訪問地址: https://foodtcg.com${NC}"
        ;;
esac
