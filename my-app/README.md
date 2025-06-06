# F.O.O.D TCG - 食物擬人對戰卡牌遊戲

這是一個基於Java的食物擬人主題集換式卡牌遊戲(TCG)，玩家之間通過食物角色卡、場地卡和法術卡進行戰略對抗。

## 遊戲概念

F.O.O.D TCG是一款雙方對戰的桌遊，每位玩家都有自己的城堡和戰場。遊戲的目標是降低對手的生命值至零或摧毀對手的城堡。

## 遊戲核心元素

### 遊戲版面

每位玩家的遊戲版面分為三大區域：

1. **城堡區（Castle Zone）** 
   - 代表玩家的防禦核心，包括三面城牆
     - 抽牌區 (Draw Wall)
     - 法力區 (Mana Wall)
     - 出牌區 (Play Wall)
   - 每面城牆上都可以放置Token，上限為10個
   - 一開始每面城牆各有1個Token

2. **戰場區（Battlefield）**
   - 擺放角色卡（進攻與防禦）
   - 擺放場地卡
   - 使用法術卡

3. **資源區（Resource Zone）**
   - 擺放Token計數器
   - 法力計數器
   - 棄牌堆
   - 任務牌

### Token機制

- 每回合開始，玩家獲得1個Token，可立即放置於三面城牆之一
- Token用於支付卡牌費用
- 不同城牆的Token可能會影響不同類型卡牌的效果

### 卡牌類型

1. **角色卡 (Character)**
   - 代表食物擬人化的角色
   - 具有攻擊力、防禦力和生命值
   - 分為進攻型和防禦型
   - 能在戰場區進行戰鬥

2. **場地卡 (Field)**
   - 整合了料理工具和烹飪技術的功能
   - 分為三種類型：
     - 烹飪技術類場地：提供各種增益效果，有持續回合數
     - 料理工具類場地：提供各種效果，有耐久度
     - 環境類場地：改變戰場環境，提供獨特效果

3. **法術卡 (Spell)**
   - 提供一次性的效果
   - 分為傷害、治療、抽牌等多種類型
   - 注：此卡牌類型在系統中被場地卡替代，但保留兼容性

4. **任務卡 (Quest)**
   - 提供特殊目標和獎勵
   - 完成特定條件後可以獲得額外效果

5. **城堡卡 (Castle)**
   - 提供特殊的陣營相關效果
   - 可以放置在三個戰場區域中的一個
   - 與玩家選擇的陣營相關聯

### 卡牌陣營

F.O.O.D TCG中的卡牌分為五個陣營，每個陣營有自己的特色和風格：

1. **火辣王國 (Spicy Kingdom)**
   - 以辛辣食物為主題的陣營
   - 擅長攻擊和爆發傷害
   - 核心關鍵字：【爆炒】和【嗆辣】
   - 代表角色：辣雞將軍、辣椒騎士等

2. **健康綠洲 (Healthy Oasis)**
   - 以健康食物為主題的陣營
   - 擅長恢復和持續效果
   - 核心關鍵字：【滋補】和【清淡】
   - 代表角色：酪梨守衛、花椰菜法師等

3. **速食工會 (Fast Food Guild)**
   - 以快餐食物為主題的陣營
   - 擅長快速出牌和連鎖效果
   - 核心關鍵字：【現炸】和【油膩】
   - 代表角色：漢堡老闆、薯條戰士等

4. **甜點聯盟 (Dessert Union)**
   - 以甜點為主題的陣營
   - 擅長控制和資源生成
   - 核心關鍵字：【糖霜】和【糖爆】
   - 代表角色：蛋糕大師、糖果粉碎者等

5. **中立 (Neutral)**
   - 不屬於特定陣營的卡牌
   - 擁有多樣的效果和高適應性
   - 可以配合任何陣營使用

### 卡牌關鍵字

F.O.O.D TCG中的卡牌具有各種關鍵字效果：

#### 通用關鍵字

1. **【開胃】(Appetizer)**
   - 進場時發動效果
   - 類似於其他卡牌遊戲中的"戰吼"

2. **【回味】(Aftertaste)**
   - 死亡後觸發效果
   - 可能包括抽牌、造成傷害、恢復生命值等

3. **【拼盤】(Platter)**
   - 符合條件的卡片都在場時，可免費打出融合卡
   - 但仍然計算為出一張牌

4. **【彈牙】(Chewy Bite)**
   - 每回合可攻擊2次
   - 第一次攻擊後能夠再次攻擊

5. **【酥脆】(Crispy)**
   - 提供護甲值，減免相應點數的傷害
   - 格式為【酥脆(N)】，表示N點護甲值
   - 每回合自動恢復1點護甲值

6. **【擺盤】(Garnished)**
   - 敵人必須優先攻擊此單位
   - 類似於其他卡牌遊戲中的"嘲諷"

#### 陣營專屬關鍵字

1. **火辣王國**
   - **【爆炒】(Overheat)**
     - 格式為【爆炒(N)】，能夠消滅攻擊力小於或等於N的單位
     - 例如：【爆炒(3)】能夠消滅攻擊力為3或以下的角色

   - **【嗆辣】(Spicy)**
     - 每回合結束時損失1點生命值
     - 通常搭配較高的初始數值或強力效果

2. **健康綠洲**
   - **【滋補】(Nourishing)**
     - 回合結束時恢復生命值至滿血
     - 提供持續的生命值恢復

   - **【清淡】(Bland)**
     - 滿血時無法攻擊
     - 只有當生命值低於最大值時才能攻擊

3. **速食工會**
   - **【現炸】(Fresh-Fried)**
     - 進場當回合即可攻擊
     - 不需要等待一回合的準備

   - **【油膩】(Glossy)**
     - 每回合開始時攻擊力減少1（最低降至1）
     - 代表隨時間逐漸削弱的效果

4. **甜點聯盟**
   - **【糖霜】(Frosted)**
     - 抵擋一次攻擊（完全免疫傷害）
     - 使用後效果消失

   - **【糖爆】(Sugar Crash)**
     - 執行文字效果，但下回合無法攻擊與無法使用糖爆
     - 效果可能包括抽牌、造成傷害、獲得酥脆、回復生命值等

## 遊戲流程

1. **初始化**
   - 每位玩家抽取初始手牌（3張）
   - 每面城牆各放置1個Token

2. **回合流程**
   - 回合開始階段：
     - 抽一張牌
     - 獲得1個Token並放置
     - 刷新角色攻擊狀態
   - 主要階段：
     - 打出手牌（支付Token費用）
     - 進行戰鬥
     - 使用場地卡和法術卡
   - 回合結束階段

3. **勝利條件**
   - 降低對手生命值至0
   - 摧毀對手的所有城牆
   - 完成特定任務

## 專案結構

```
my-app/
├── src/main/java/com/example/
│   ├── App.java                           # 主程式入口
│   ├── game/                              # 遊戲核心
│   │   ├── FOODGameEngine.java            # F.O.O.D TCG遊戲引擎
│   │   ├── board/                         # 遊戲版面
│   │   │   ├── GameBoard.java             # 遊戲板總體實現
│   │   │   ├── CastleZone.java            # 城堡區實現
│   │   │   ├── BattlefieldZone.java       # 戰場區實現
│   │   │   └── ResourceZone.java          # 資源區實現
│   │   ├── card/                          # 卡牌系統
│   │   │   ├── Card.java                  # 卡牌基類
│   │   │   ├── CardType.java              # 卡牌類型枚舉
│   │   │   ├── Faction.java               # 卡牌陣營枚舉
│   │   │   ├── CharacterCard.java         # 角色卡實現
│   │   │   ├── CastleCard.java            # 城堡卡實現
│   │   │   ├── CastleCardZone.java        # 城堡卡放置區域枚舉
│   │   │   ├── CastleEffect.java          # 城堡效果接口
│   │   │   ├── CastleEffectImpl.java      # 城堡效果實現
│   │   │   ├── FieldCard.java             # 場地卡實現
│   │   │   ├── FieldEffectType.java       # 場地效果類型枚舉
│   │   │   ├── SpellCard.java             # 法術卡實現（兼容層）
│   │   │   ├── SpellType.java             # 法術類型枚舉
│   │   │   ├── CardEffect.java            # 卡牌效果接口
│   │   │   ├── CardEffectImpl.java        # 卡牌效果實現
│   │   │   ├── TargetSelector.java        # 目標選擇器
│   │   │   ├── Deck.java                  # 牌組管理
│   │   │   ├── CardLibrary.java           # 卡牌圖鑑
│   │   │   ├── Rarity.java                # 稀有度枚舉
│   │   │   └── faction/                   # 陣營卡牌初始化
│   │   │       ├── FactionCardInitializer.java         # 陣營卡片初始化接口
│   │   │       ├── SpicyKingdomInitializer.java        # 火辣王國卡片初始化
│   │   │       ├── HealthyOasisInitializer.java        # 健康綠洲卡片初始化
│   │   │       ├── FastFoodGuildInitializer.java       # 速食工會卡片初始化
│   │   │       ├── DessertUnionInitializer.java        # 甜點聯盟卡片初始化
│   │   │       └── NeutralCardInitializer.java         # 中立卡片初始化
│   │   └── player/                        # 玩家相關
│   │       ├── Player.java                # 玩家類實現
│   │       └── AIPlayer.java              # AI玩家實現
└── pom.xml                                # Maven 配置文件
```

## 如何運行

### 前置需求
- Java 21 或更高版本
- Maven 3.6 或更高版本

### 編譯與運行
1. 編譯專案
   ```
   mvn compile
   ```

2. 運行遊戲
   ```
   mvn exec:java -Dexec.mainClass="com.example.App"
   ```

### 遊戲操作指南
- **1.放置新Token**：選擇一面城牆放置每回合獲得的Token
- **2.出牌**：從手牌中選擇卡牌打出，並選擇支付Token的城牆
- **3.戰鬥**：指揮角色攻擊敵方角色
- **4.查看手牌**：查看當前手中的卡牌
- **5.結束回合**：結束當前回合

## 未來擴展

1. **更多食物主題角色**
   - 不同食物類別：肉類、蔬菜、水果、甜點、飲料等
   - 不同文化的料理角色

2. **連鎖效果系統**
   - 特定食物組合可觸發特殊效果
   - 料理完成條件和獎勵

3. **食物季節系統**
   - 季節變化影響特定食物角色的能力
   - 限定季節活動和卡牌

4. **競技場模式**
   - 多人對戰
   - 排名系統

## 授權
本專案採用 MIT 授權條款 

## AI對手功能介紹

F.O.O.D TCG現在支援與AI對手進行對戰。AI對手擁有不同的難度級別，並且會根據難度自動做出決策。

### AI難度等級

AI對手有三個難度等級：

1. **簡單** - 隨機決策模式
   - 隨機選擇陣營、城堡卡和放置區域
   - 隨機放置Token
   - 隨機選擇卡牌和出牌區域
   - 隨機選擇攻擊目標

2. **中等** - 基本策略模式
   - 偏好選擇實際陣營而非中立陣營
   - 傾向選擇稀有度較高的城堡卡
   - 根據當前資源狀況放置Token
   - 優先使用高費卡牌，並根據卡牌類型選擇適合的區域
   - 選擇攻擊力最高的角色進行攻擊

3. **困難** - 複雜策略模式
   - 根據權重策略選擇最佳陣營
   - 評估城堡卡的效果和價值
   - 根據遊戲階段和策略選擇放置Token
   - 使用複雜評分機制選擇最佳卡牌和放置區域
   - 優先攻擊對手較弱的城牆

### AI決策規則

#### 陣營選擇

- **簡單**：完全隨機選擇陣營
- **中等**：80%機率選擇非中立陣營，20%機率選擇中立陣營
- **困難**：根據陣營權重選擇，偏好火辣王國和健康綠洲

#### 城堡卡選擇

- **簡單**：隨機選擇可用城堡卡
- **中等**：稀有度越高的卡牌，被選中機率越大
- **困難**：評估每張城堡卡的效果，選擇最優城堡卡

#### 城堡卡放置區域

- **簡單**：隨機選擇放置區域
- **中等**：偏好將城堡卡放在法力區或出牌區
- **困難**：根據城堡卡效果和陣營特點選擇最適合的區域
  - 火辣王國偏好出牌區
  - 健康綠洲偏好抽牌區
  - 速食工會偏好法力區
  - 甜點聯盟偏好出牌區

#### Token放置

- **簡單**：隨機選擇城牆放置Token
- **中等**：優先選擇Token數量最少的區域
- **困難**：根據遊戲階段調整策略
  - 早期(回合1-3)：優先發展法力和抽牌
  - 中期(回合4-7)：平衡發展
  - 後期(回合8+)：偏好出牌區和法力區

#### 出牌決策

- **簡單**：隨機選擇可出的牌
- **中等**：優先選擇高費卡牌
  - 進攻型角色放在出牌區
  - 防禦型角色放在抽牌區
  - 非角色卡放在法力區
- **困難**：使用評分機制評估每張牌在每個區域的價值，選擇最優解

#### 戰鬥決策

- **簡單**：隨機選擇攻擊者和目標
- **中等**：選擇攻擊力最高的角色作為攻擊者，優先攻擊出牌區
- **困難**：選擇攻擊力最高的角色作為攻擊者，優先攻擊較弱的城牆

## 使用方法

在遊戲開始時，玩家可以選擇：
1. 玩家對戰玩家
2. 玩家對戰AI

選擇與AI對戰後，玩家可以選擇AI難度級別。遊戲進行中，當輪到AI玩家回合時，AI會自動執行其決策。 