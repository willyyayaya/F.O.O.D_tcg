# F.O.O.D TCG - Spring Boot版本

## 🍔 專案簡介

F.O.O.D TCG（食物擬人對戰卡牌遊戲）的Spring Boot重構版本，提供RESTful API和WebSocket支援，支援即時對戰和遊戲狀態持久化。

## 🏗️ 技術架構

### 後端技術棧
- **Spring Boot 2.7.18** - 主框架
- **Spring Data JPA** - 數據持久化
- **Spring WebSocket** - 即時通訊
- **H2 Database** - 開發環境數據庫
- **Maven** - 依賴管理

### 前端
- **HTML5 + CSS3 + JavaScript** - 測試介面
- **WebSocket Client** - 即時遊戲更新

## 🚀 快速開始

### 1. 環境要求
- Java 11 或以上
- Maven 3.6+

### 2. 編譯專案
```bash
mvn clean compile
```

### 3. 運行應用程式
```bash
mvn spring-boot:run
```

### 4. 訪問應用程式
- **Web UI**: http://localhost:8080
- **API文檔**: http://localhost:8080/api
- **H2控制台**: http://localhost:8080/h2-console

## 📡 API端點

### 遊戲管理
- `POST /api/game/initialize` - 初始化卡牌圖鑑
- `POST /api/game/start` - 開始新遊戲
- `GET /api/game/state` - 獲取遊戲狀態
- `POST /api/game/end-turn` - 結束回合

### 遊戲操作
- `POST /api/game/play-card` - 打出手牌
- `POST /api/game/place-token` - 放置Token
- `POST /api/game/attack-wall` - 攻擊城牆

### 卡牌圖鑑
- `GET /api/game/cards` - 獲取所有卡牌
- `GET /api/game/cards/{cardName}` - 獲取特定卡牌
- `GET /api/game/player/{playerName}/hand` - 獲取玩家手牌

## 🔌 WebSocket端點

### 連線端點
- **端點**: `/ws`
- **協議**: SockJS + STOMP

### 訂閱頻道
- `/topic/game/state` - 遊戲狀態更新
- `/topic/game/update` - 遊戲動作廣播
- `/user/queue/game/personal` - 個人遊戲資訊

### 發送目的地
- `/app/game/state` - 請求遊戲狀態
- `/app/game/play-card` - 出牌
- `/app/game/end-turn` - 結束回合
- `/app/game/place-token` - 放置Token

## 🎮 遊戲流程

### 1. 初始化
```javascript
// 初始化卡牌圖鑑
POST /api/game/initialize
```

### 2. 開始遊戲
```javascript
// 創建新遊戲
POST /api/game/start
{
  "player1Name": "玩家1",
  "player2Name": "玩家2"
}
```

### 3. 遊戲操作
```javascript
// 出牌
POST /api/game/play-card
{
  "playerName": "玩家1",
  "handIndex": 0,
  "areaType": 3
}

// 結束回合
POST /api/game/end-turn
{
  "playerName": "玩家1"
}
```

## 🗄️ 數據庫配置

### H2開發環境
```yaml
spring:
  datasource:
    url: jdbc:h2:mem:foodtcg
    username: sa
    password: password
  h2:
    console:
      enabled: true
      path: /h2-console
```

### 遊戲數據表
- `games` - 遊戲記錄
  - `game_id` - 遊戲ID
  - `player1_name`, `player2_name` - 玩家名稱
  - `current_player_name` - 當前玩家
  - `turn_number` - 回合數
  - `game_over` - 遊戲是否結束
  - `winner` - 勝利者
  - `game_state_json` - 完整遊戲狀態（JSON）

## 🔧 配置選項

### application.yml
```yaml
server:
  port: 8080
  servlet:
    context-path: /api

game:
  max-players: 8
  timeout-minutes: 30
  auto-save: true

logging:
  level:
    com.example.game: DEBUG
```

## 🏛️ 專案結構

```
src/main/java/com/example/
├── App.java                     # Spring Boot主程式
├── game/
│   ├── FOODGameEngine.java      # 遊戲引擎服務
│   ├── controller/              # REST和WebSocket控制器
│   │   ├── GameController.java
│   │   └── WebSocketGameController.java
│   ├── service/                 # 業務邏輯服務
│   │   └── GameService.java
│   ├── dto/                     # 數據傳輸對象
│   │   ├── GameStateDto.java
│   │   └── PlayCardRequest.java
│   ├── entity/                  # JPA實體類
│   │   └── GameEntity.java
│   ├── repository/              # 數據訪問層
│   │   └── GameRepository.java
│   ├── config/                  # 配置類
│   │   └── WebSocketConfig.java
│   ├── card/                    # 卡牌系統
│   ├── player/                  # 玩家系統
│   └── board/                   # 遊戲板系統
└── resources/
    ├── application.yml          # 應用配置
    └── static/
        └── index.html          # 測試前端
```

## 🎯 主要功能

### ✅ 已實現
- [x] Spring Boot框架集成
- [x] RESTful API完整實現
- [x] WebSocket即時通訊
- [x] 遊戲狀態管理
- [x] 卡牌圖鑑API
- [x] 玩家操作API
- [x] JPA數據持久化
- [x] H2數據庫支援
- [x] 前端測試介面

### 🔄 進行中
- [ ] 遊戲AI集成
- [ ] 完整的WebSocket客戶端
- [ ] 遊戲錄像回放
- [ ] 統計數據分析

### 📋 待開發
- [ ] 用戶認證系統
- [ ] 排行榜系統
- [ ] 卡包開包系統
- [ ] 多人房間系統
- [ ] 觀戰功能

## 🛠️ 開發建議

### 1. API測試
使用提供的前端測試介面或Postman測試API功能

### 2. WebSocket測試
可以使用瀏覽器開發者工具或專用WebSocket客戶端

### 3. 數據庫查看
訪問H2控制台查看遊戲數據：http://localhost:8080/h2-console

### 4. 日誌調試
查看控制台輸出或調整日誌級別進行調試

## 🤝 貢獻指南

1. Fork專案
2. 創建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 開啟Pull Request

## 📄 授權

此專案採用MIT授權 - 查看 [LICENSE](LICENSE) 文件了解詳情

## 🎉 致謝

感謝所有為F.O.O.D TCG專案做出貢獻的開發者！

---

**享受你的食物卡牌對戰吧！** 🍔⚔️🎮 