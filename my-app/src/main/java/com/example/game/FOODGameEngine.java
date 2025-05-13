package com.example.game;

import java.util.Scanner;
import java.util.List;

import com.example.game.board.GameBoard;
import com.example.game.card.Card;
import com.example.game.card.CardLibrary;
import com.example.game.card.CardType;
import com.example.game.card.CharacterCard;
import com.example.game.player.Player;

/**
 * F.O.O.D TCG遊戲引擎 - 控制食物擬人卡牌遊戲的流程和規則
 */
public class FOODGameEngine {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int turnNumber;
    private boolean gameOver;
    
    // 靜態引用，方便其他類（如卡牌圖鑑）訪問當前遊戲實例
    private static FOODGameEngine currentGameInstance;
    
    // 新增變數追蹤玩家是否已放置Token
    private boolean hasPlacedTokenThisTurn;
    
    public FOODGameEngine() {
        this.gameBoard = new GameBoard();
        this.gameOver = false;
        this.turnNumber = 1;
        // 設置當前遊戲實例
        currentGameInstance = this;
        
        // 初始化卡牌圖鑑
        initializeCardLibrary();
    }
    
    // 靜態方法獲取當前玩家1
    public static Player getPlayer1() {
        if (currentGameInstance == null) return null;
        return currentGameInstance.player1;
    }
    
    // 靜態方法獲取當前玩家2
    public static Player getPlayer2() {
        if (currentGameInstance == null) return null;
        return currentGameInstance.player2;
    }
    
    // 靜態方法獲取當前回合玩家
    public static Player getCurrentPlayer() {
        if (currentGameInstance == null) return null;
        return currentGameInstance.currentPlayer;
    }
    
    public void start() {
        System.out.println("歡迎來到 F.O.O.D TCG - 食物擬人對戰卡牌遊戲!");
        
        initializePlayers();
        gameLoop();
    }
    
    private void initializeCardLibrary() {
        System.out.println("正在初始化 F.O.O.D TCG 卡牌圖鑑...");
        // 調用卡牌圖鑑的初始化方法
        CardLibrary.initialize();
        
        // 驗證初始化結果
        int totalCards = CardLibrary.getAllCharacters().size() + 
                         CardLibrary.getAllFieldCards().size() + 
                         CardLibrary.getAllMinions().size() + 
                         CardLibrary.getAllSpells().size();
        
        System.out.println("F.O.O.D TCG卡牌圖鑑初始化完成，共有 " + totalCards + " 張卡牌");
        System.out.println("- 角色卡: " + CardLibrary.getAllCharacters().size() + " 張");
        System.out.println("- 場地卡: " + CardLibrary.getAllFieldCards().size() + " 張");
        System.out.println("- 隨從卡: " + CardLibrary.getAllMinions().size() + " 張");
        System.out.println("- 法術卡: " + CardLibrary.getAllSpells().size() + " 張");
    }
    
    private void initializePlayers() {
        Scanner scanner = new Scanner(System.in);
        
        // 選擇遊戲模式
        System.out.println("\n===== 選擇遊戲模式 =====");
        System.out.println("1. 玩家對戰玩家");
        System.out.println("2. 玩家對戰AI");
        
        int gameMode = 1; // 預設為玩家對戰玩家
        boolean vsAI = false;
        
        try {
            System.out.print("請選擇遊戲模式: ");
            gameMode = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (gameMode == 2) {
                vsAI = true;
                System.out.println("您選擇了玩家對戰AI模式!");
            } else {
                System.out.println("您選擇了玩家對戰玩家模式!");
            }
        } catch (Exception e) {
            System.out.println("輸入無效，預設使用玩家對戰玩家模式!");
            scanner.nextLine(); // 清除輸入緩衝
        }
        
        // 創建玩家1
        player1 = new Player("玩家1");
        
        // 創建玩家2 或 AI對手
        if (vsAI) {
            // 選擇AI難度
            System.out.println("\n===== 選擇AI難度 =====");
            System.out.println("1. 簡單 - AI會做出隨機決策");
            System.out.println("2. 中等 - AI會有基本策略");
            System.out.println("3. 困難 - AI會有複雜策略");
            
            int difficulty = 1; // 預設為簡單難度
            
            try {
                System.out.print("請選擇AI難度: ");
                difficulty = scanner.nextInt();
                scanner.nextLine(); // 清除輸入緩衝
                
                if (difficulty < 1 || difficulty > 3) {
                    difficulty = 1;
                    System.out.println("輸入無效，預設使用簡單難度!");
                }
            } catch (Exception e) {
                System.out.println("輸入無效，預設使用簡單難度!");
                scanner.nextLine(); // 清除輸入緩衝
            }
            
            // 創建AI對手
            player2 = new com.example.game.player.AIPlayer("AI對手", difficulty);
            System.out.println("AI對手已準備就緒，難度為: " + getAIDifficultyName(difficulty));
        } else {
            // 創建人類玩家2
            player2 = new Player("玩家2");
        }
        
        // 玩家選擇陣營
        System.out.println("\n" + player1.getName() + " 請選擇你的陣營:");
        com.example.game.card.Faction faction1 = chooseFaction(scanner);
        player1.setFaction(faction1);
        
        // 如果是AI對手，自動選擇陣營
        if (vsAI) {
            System.out.println("\n" + player2.getName() + " 正在選擇陣營...");
            com.example.game.card.Faction aiFaction = ((com.example.game.player.AIPlayer)player2).chooseAIFaction();
            System.out.println(player2.getName() + " 選擇了 " + aiFaction.getLocalizedName() + " 陣營!");
        } else {
            System.out.println("\n" + player2.getName() + " 請選擇你的陣營:");
            com.example.game.card.Faction faction2 = chooseFaction(scanner);
            player2.setFaction(faction2);
        }
        
        // 玩家選擇城堡卡並決定放置區域
        setupPlayerCastle(player1);
        
        // 如果是AI對手，自動選擇城堡卡
        if (vsAI) {
            setupAICastle((com.example.game.player.AIPlayer)player2);
        } else {
            setupPlayerCastle(player2);
        }
        
        // 初始化牌組 - 現在會根據玩家選擇的陣營
        player1.initializeDeck();
        player2.initializeDeck();
        
        player1.drawInitialHand();
        player2.drawInitialHand();
       
        // 隨機決定先手
        currentPlayer = Math.random() > 0.5 ? player1 : player2;
        System.out.println(currentPlayer.getName() + " 將先手進行遊戲");
    }
    
    /**
     * 設置AI的城堡卡
     */
    private void setupAICastle(com.example.game.player.AIPlayer aiPlayer) {
        System.out.println("\n" + aiPlayer.getName() + " 正在選擇城堡卡和區域...");
        
        // 讓AI選擇城堡卡
        com.example.game.card.CastleCard castle = aiPlayer.chooseAICastle();
        if (castle != null) {
            aiPlayer.setCastleCard(castle);
            
            // 讓AI選擇放置區域
            com.example.game.card.CastleCardZone zone = aiPlayer.chooseAICastleZone();
            castle.hideInZone(zone);
            
            // 啟用城堡效果
            castle.activateEffect(aiPlayer);
            
            System.out.println(aiPlayer.getName() + " 的城堡卡設置完成!");
        } else {
            System.out.println("警告: AI無法選擇城堡卡!");
        }
    }
    
    /**
     * 獲取AI難度的名稱
     */
    private String getAIDifficultyName(int difficulty) {
        switch (difficulty) {
            case 1: return "簡單";
            case 2: return "中等";
            case 3: return "困難";
            default: return "未知";
        }
    }
    
    /**
     * 讓玩家選擇陣營
     */
    private com.example.game.card.Faction chooseFaction(Scanner scanner) {
        System.out.println("請選擇你的陣營:");
        System.out.println("1. 火辣王國 - 辛辣料理, 擅長爆發和控場");
        System.out.println("2. 健康綠洲 - 有機食材, 擅長防禦和回復");
        System.out.println("3. 速食工會 - 快速料理, 擅長快速節奏和低費卡牌");
        System.out.println("4. 甜點聯盟 - 甜點烘焙, 擅長增益和特殊效果");
        System.out.println("5. 中立陣營 - 多樣食材, 擁有多樣的效果和高適應性");
        
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // 清除輸入緩衝
                
                switch (choice) {
                    case 1: 
                        System.out.println("你選擇了火辣王國陣營!");
                        return com.example.game.card.Faction.SPICY_KINGDOM;
                    case 2: 
                        System.out.println("你選擇了健康綠洲陣營!");
                        return com.example.game.card.Faction.HEALTHY_OASIS;
                    case 3: 
                        System.out.println("你選擇了速食工會陣營!");
                        return com.example.game.card.Faction.FAST_FOOD_GUILD;
                    case 4: 
                        System.out.println("你選擇了甜點聯盟陣營!");
                        return com.example.game.card.Faction.DESSERT_UNION;
                    case 5: 
                        System.out.println("你選擇了中立陣營!");
                        return com.example.game.card.Faction.NEUTRAL;
                    default:
                        System.out.println("無效選擇，請輸入1-5!");
                }
            } catch (Exception e) {
                System.out.println("輸入錯誤，請輸入數字!");
                scanner.nextLine(); // 清除輸入緩衝
            }
        }
    }
    
    /**
     * 為玩家設置城堡卡
     */
    private void setupPlayerCastle(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + player.getName() + " 請選擇你的城堡卡:");
        
        // 使用玩家選擇的陣營
        com.example.game.card.Faction playerFaction = player.getFaction();
        
        // 選擇城堡卡
        com.example.game.card.CastleCard castle = CardLibrary.chooseCastleCard(scanner, playerFaction);
        if (castle != null) {
            player.setCastleCard(castle);
            
            // 選擇放置區域
            com.example.game.card.CastleCardZone zone = CardLibrary.chooseCastleZone(scanner, castle);
            castle.hideInZone(zone);
            
            // 啟用城堡效果
            castle.activateEffect(player);
            
            System.out.println(player.getName() + " 的城堡卡設置完成!");
        } else {
            System.out.println("警告: 無法選擇城堡卡!");
        }
    }
    
    private void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        
        while (!gameOver) {
            startTurn();
            
            // 檢查當前玩家是否為AI
            boolean isAITurn = currentPlayer instanceof com.example.game.player.AIPlayer;
            
            if (isAITurn) {
                // 如果是AI玩家，自動執行回合
                executeAITurn();
            } else {
                // 如果是人類玩家，正常執行回合
                executePlayerTurn(scanner);
            }
            
            endTurn();
            checkGameOver();
        }
        
        scanner.close();
        announceWinner();
    }
    
    private void startTurn() {
        System.out.println("======= 回合 " + turnNumber + " =======");
        System.out.println(currentPlayer.getName() + " 的回合開始");
        
        // 回合開始時的處理
        currentPlayer.startNewTurn();
        
        // 重置Token放置狀態
        hasPlacedTokenThisTurn = false;
        
        // 不再自動獲得資源，需要先放置Token
        System.out.println(currentPlayer.getName() + " 需要先放置新Token才能獲得資源");
    }
    
    private void placeNewToken() {
        Scanner scanner = new Scanner(System.in);
        
        // 檢查是否已經放置過Token
        if (hasPlacedTokenThisTurn) {
            System.out.println("您本回合已經放置過Token了，每回合只能放置一次!");
            return;
        }
        
        // 先獲取當前 Token 總數
        int totalTokens = currentPlayer.getCastleZone().getTotalTokenCount();
        int maxTokens = 10; // 最大 Token 總數
        
        // 檢查是否已達到總數上限
        boolean isMaxTokensReached = (totalTokens >= maxTokens);
        
        if (isMaxTokensReached) {
            System.out.println("警告: Token總數已達上限(" + maxTokens + "個)，無法再放置新Token!");
            System.out.println("請選擇操作: 1.查看當前資源分配 2.繼續遊戲");
            
            try {
                int choice = scanner.nextInt();
                
                if (choice == 1) {
                    // 顯示當前Token分配
                    System.out.println("\n當前Token分配情況:");
                    System.out.println("抽牌區: " + currentPlayer.getCastleZone().getDrawWall().getTokenCount() + " 個Token");
                    System.out.println("法力區: " + currentPlayer.getCastleZone().getManaWall().getTokenCount() + " 個 Token");
                    System.out.println("出牌區: " + currentPlayer.getCastleZone().getPlayWall().getTokenCount() + " 個 Token");
                    System.out.println("總數: " + totalTokens + "/" + maxTokens);
                }
                
                // 無論選擇什麼，都設定為已放置Token狀態（跳過放置階段）
                hasPlacedTokenThisTurn = true;
                
                // 使用現有的Token分配來設置資源
                // 根據抽牌區的 Token 數量抽牌
                int drawAmount = currentPlayer.getCastleZone().getDrawWall().getTokenCount();
                System.out.println(currentPlayer.getName() + " 根據抽牌區的 " + drawAmount + " 個 Token 抽 " + drawAmount + " 張牌");
                for (int i = 0; i < drawAmount; i++) {
                    currentPlayer.drawCard();
                }
                
                // 根據法力區 Token 更新法力值
                int manaTokens = currentPlayer.getCastleZone().getManaWall().getTokenCount();
                currentPlayer.updateManaPoints(manaTokens);
                
                // 根據出牌區 Token 更新最大出牌數
                int playTokens = currentPlayer.getCastleZone().getPlayWall().getTokenCount();
                currentPlayer.updateMaxCardsToPlay(playTokens);
                
                // 顯示當前資源分配效果
                System.out.println("本回合使用現有Token: 抽了 " + drawAmount + " 張牌，獲得 " + manaTokens + " 點法力值，可出 " + playTokens + " 張牌");
                
                return;
            } catch (Exception e) {
                System.out.println("輸入錯誤，將繼續遊戲");
                scanner.nextLine(); // 清除輸入緩衝
                hasPlacedTokenThisTurn = true; // 設為已放置，以繼續遊戲
                return;
            }
        }
        
        System.out.println("選擇要放置新Token的城牆 (當前總數: " + totalTokens + "/" + maxTokens + "):");
        System.out.println("1.抽牌區 (當前: " + currentPlayer.getCastleZone().getDrawWall().getTokenCount() + " 個 Token，影響每回合抽牌數)");
        System.out.println("2.法力區 (當前: " + currentPlayer.getCastleZone().getManaWall().getTokenCount() + " 個 Token，影響每回合法力值)");
        System.out.println("3.出牌區 (當前: " + currentPlayer.getCastleZone().getPlayWall().getTokenCount() + " 個 Token，影響每回合出牌數)");
        
        try {
            int wallType = scanner.nextInt();
            if (wallType >= 1 && wallType <= 3) {
                if (currentPlayer.placeNewToken(wallType)) {
                    System.out.println("Token放置成功!");
                    
                    // 設定已放置Token狀態
                    hasPlacedTokenThisTurn = true;
                    
                    // 確保城堡區和資源區的Token總數同步
                    currentPlayer.updateResourceTokens();
                    
                    // 根據抽牌區的 Token 數量抽牌
                    int drawAmount = currentPlayer.getCastleZone().getDrawWall().getTokenCount();
                    System.out.println(currentPlayer.getName() + " 根據抽牌區的 " + drawAmount + " 個 Token 抽 " + drawAmount + " 張牌");
                    for (int i = 0; i < drawAmount; i++) {
                        currentPlayer.drawCard();
                    }
                    
                    // 根據法力區 Token 更新法力值
                    int manaTokens = currentPlayer.getCastleZone().getManaWall().getTokenCount();
                    currentPlayer.updateManaPoints(manaTokens);
                    
                    // 根據出牌區 Token 更新最大出牌數
                    int playTokens = currentPlayer.getCastleZone().getPlayWall().getTokenCount();
                    currentPlayer.updateMaxCardsToPlay(playTokens);
                    
                    // 顯示放置後的效果說明
                    String effectDescription = "";
                    switch (wallType) {
                        case 1: 
                            effectDescription = "本回合抽了 " + drawAmount + " 張牌";
                            break;
                        case 2: 
                            effectDescription = "本回合獲得了 " + manaTokens + " 點法力值";
                            break;
                        case 3: 
                            effectDescription = "本回合可出 " + playTokens + " 張牌";
                            break;
                    }
                    System.out.println(effectDescription);
                } else {
                    System.out.println("Token放置失敗，可能已達到總數上限(10個)，或選擇的城牆已滿");
                    
                    // 給玩家選擇是否繼續嘗試放置或跳過
                    System.out.println("請選擇: 1.嘗試放置到其他城牆 2.跳過放置階段");
                    int choice = scanner.nextInt();
                    
                    if (choice == 2) {
                        // 玩家選擇跳過放置階段
                        System.out.println("跳過放置階段，使用現有資源繼續遊戲");
                        hasPlacedTokenThisTurn = true;
                        
                        // 使用現有的Token分配來設置資源
                        int drawAmount = currentPlayer.getCastleZone().getDrawWall().getTokenCount();
                        for (int i = 0; i < drawAmount; i++) {
                            currentPlayer.drawCard();
                        }
                        
                        currentPlayer.updateManaPoints(currentPlayer.getCastleZone().getManaWall().getTokenCount());
                        currentPlayer.updateMaxCardsToPlay(currentPlayer.getCastleZone().getPlayWall().getTokenCount());
                    } else {
                        // 玩家選擇嘗試放置到其他城牆，遞迴調用
                        placeNewToken();
                        return;
                    }
                }
            } else {
                System.out.println("選擇無效，請輸入1-3的數字!");
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤! 請輸入有效的數字選項");
        }
    }
    
    private void playCardsPhase(Player player, Scanner scanner) {
        Player opponent = (player == player1) ? player2 : player1;
        
        while (true) {
            gameBoard.displayBoard(player1, player2, player);
            gameBoard.displayPlayerHand(player);
            
            System.out.println("\n===== 出牌階段 =====");
            System.out.println("1. 出牌");
            System.out.println("2. 查看場上詳情");
            System.out.println("3. 查看手牌詳情");
            System.out.println("0. 結束出牌階段");
            System.out.print("請選擇操作: ");
            
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // 清除輸入緩衝
                
                switch (choice) {
                    case 0:
                        return;
                    case 1:
                        // 出牌
                        if (player.getHand().isEmpty()) {
                            System.out.println("你沒有手牌可出!");
                            continue;
                        }
                        
                        if (player.getCardsPlayedThisTurn() >= player.getMaxCardsToPlay()) {
                            System.out.println("本回合出牌次數已用完! (" + player.getCardsPlayedThisTurn() + "/" + player.getMaxCardsToPlay() + ")");
                            continue;
                        }
                        
                        System.out.print("選擇要出的牌 (1-" + player.getHand().size() + "): ");
                        int cardIndex = scanner.nextInt();
                        scanner.nextLine(); // 清除輸入緩衝
                        
                        if (cardIndex < 1 || cardIndex > player.getHand().size()) {
                            System.out.println("無效的選擇!");
                            continue;
                        }
                        
                        Card selectedCard = player.getHand().get(cardIndex - 1);
                        
                        // 檢查是否為任務卡，任務卡直接放置到資源區
                        if (selectedCard.getType() == CardType.QUEST) {
                            player.playCard(cardIndex - 1, 0); // 任務卡不需要選擇區域
                            continue;
                        }
                        
                        // 讓玩家選擇將卡牌放在哪個區域
                        System.out.println("\n選擇要放置的區域:");
                        System.out.println("1. 抽牌區");
                        System.out.println("2. 法力區");
                        System.out.println("3. 出牌區");
                        System.out.print("請選擇: ");
                        
                        int areaChoice = scanner.nextInt();
                        scanner.nextLine(); // 清除輸入緩衝
                        
                        if (areaChoice < 1 || areaChoice > 3) {
                            System.out.println("無效的區域選擇!");
                            continue;
                        }
                        
                        // 出牌
                        player.playCard(cardIndex - 1, areaChoice);
                        break;
                    
                    case 2:
                        // 查看場上詳情
                        gameBoard.displayBattlefieldDetails(player1, player2, player);
                        break;
                    
                    case 3:
                        // 查看手牌詳情
                        player.displayHandDetailed();
                        break;
                    
                    default:
                        System.out.println("無效的選擇!");
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("輸入錯誤: " + e.getMessage());
                scanner.nextLine(); // 清除輸入緩衝
            }
        }
    }
    
    private void battle() {
        Scanner scanner = new Scanner(System.in);
        Player opponent = (currentPlayer == player1) ? player2 : player1;
        
        System.out.println("\n======= 戰鬥階段 =======");
        System.out.println("選擇進行戰鬥的角色:");
        
        // 獲取當前玩家的戰場
        com.example.game.board.BattlefieldZone battlefield = currentPlayer.getBattlefieldZone();
        List<CharacterCard> characters = battlefield.getCharacters();
        
        if (characters.isEmpty()) {
            System.out.println("你沒有角色可以進行戰鬥!");
            return;
        }
        
        // 顯示可進行戰鬥的角色
        for (int i = 0; i < characters.size(); i++) {
            CharacterCard character = characters.get(i);
            String status = character.canAttack() ? "[可攻擊]" : "[已消耗]";
            System.out.printf("%d. %s [ATK:%d] %s\n", i + 1, character.getName(), 
                            character.getAttack(), status);
        }
        
        System.out.println("0. 返回");
        
        try {
            int choice = scanner.nextInt();
            if (choice == 0) return;
            
            if (choice < 1 || choice > characters.size()) {
                System.out.println("無效的選擇!");
                return;
            }
            
            CharacterCard attacker = characters.get(choice - 1);
            
            if (!attacker.canAttack()) {
                System.out.println("這個角色已經攻擊過或不能攻擊!");
                return;
            }
            
            System.out.println("選擇攻擊目標:");
            System.out.println("1. 攻擊對手角色");
            System.out.println("2. 攻擊對手城牆");
            System.out.println("0. 返回");
            
            int targetType = scanner.nextInt();
            
            if (targetType == 0) return;
            
            if (targetType == 1) {
                // 選擇對手角色進行攻擊
                // ...此部分代碼保持不變...
            } else if (targetType == 2) {
                // 選擇對手城牆進行攻擊
                System.out.println("選擇要攻擊的城牆:");
                System.out.println("1. 抽牌區");
                System.out.println("2. 法力區");
                System.out.println("3. 出牌區");
                
                int wallChoice = scanner.nextInt();
                if (wallChoice < 1 || wallChoice > 3) {
                    System.out.println("無效的選擇!");
                    return;
                }
                
                // 使用修改後的攻擊方法，會檢查城堡卡
                attackWall(opponent, wallChoice, attacker.getAttack());
                
                // 設置為已攻擊狀態
                attacker.refreshForNewTurn(); // 先刷新以確保可攻擊
                attacker.attack(attacker); // 利用現有方法將 canAttack 設為 false
                System.out.println(attacker.getName() + " 攻擊了 " + opponent.getName() + " 的城牆!");
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤!");
            scanner.nextLine(); // 清除輸入緩衝
        }
    }
    
    private void displayGameState() {
        gameBoard.displayBoard(player1, player2, currentPlayer);
        
        // 顯示當前玩家的資源資訊
        System.out.println("\n" + currentPlayer.getName() + " 的資源:");
        
        if (hasPlacedTokenThisTurn) {
            System.out.println("- 法力值: " + currentPlayer.getManaPoints());
            System.out.println("- 出牌次數: " + currentPlayer.getCardsPlayedThisTurn() + "/" + currentPlayer.getMaxCardsToPlay());
        } else {
            System.out.println("- 尚未放置Token，請先放置Token以獲得本回合資源");
        }
        
        // 顯示城堡區狀態
        System.out.println("\n" + currentPlayer.getName() + " 的城堡區:");
        System.out.println("- 抽牌區: " + currentPlayer.getCastleZone().getDrawWall().getTokenCount() + " 個 Token (影響額外抽牌數)");
        System.out.println("- 法力區: " + currentPlayer.getCastleZone().getManaWall().getTokenCount() + " 個 Token (影響額外法力值)"); 
        System.out.println("- 出牌區: " + currentPlayer.getCastleZone().getPlayWall().getTokenCount() + " 個 Token (影響出牌上限)");
    }
    
    private void endTurn() {
        System.out.println(currentPlayer.getName() + " 結束回合");
        
        // 切換玩家
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        
        if (currentPlayer == player1) {
            // 一輪結束，回合數+1
            turnNumber++;
        }
    }
    
    /**
     * 檢查遊戲是否結束
     */
    private void checkGameOver() {
        // 檢查玩家生命值
        if (player1.getHealth() <= 0) {
            gameOver = true;
            System.out.println(player1.getName() + " 生命值歸零，遊戲結束！");
        } else if (player2.getHealth() <= 0) {
            gameOver = true;
            System.out.println(player2.getName() + " 生命值歸零，遊戲結束！");
        }
        
        // 檢查玩家是否因牌庫耗盡而失敗
        if (player1.getDeck().isEmpty()) {
            gameOver = true;
            System.out.println(player1.getName() + " 牌庫耗盡，遊戲結束！");
        } else if (player2.getDeck().isEmpty()) {
            gameOver = true;
            System.out.println(player2.getName() + " 牌庫耗盡，遊戲結束！");
        }
        
        // 可以加入其他勝利條件，如三個城牆全部被摧毀等
    }
    
    private void announceWinner() {
        Player winner = (player1.getHealth() <= 0) ? player2 : player1;
        System.out.println("\n======= 遊戲結束 =======");
        System.out.println(winner.getName() + " 獲勝!");
        System.out.println("========================\n");
    }

    /**
     * 攻擊指定玩家的指定城牆
     * @param target 目標玩家
     * @param wallType 城牆類型 (1=抽牌區, 2=法力區, 3=出牌區)
     * @param damage 傷害量
     * @return 該城牆是否被摧毀
     */
    public boolean attackWall(Player target, int wallType, int damage) {
        boolean wallDestroyed = target.attackWall(wallType, damage);
        
        // 檢查城牆被摧毀時，是否有城堡卡在此區域
        if (wallDestroyed) {
            com.example.game.card.CastleCardZone zone;
            switch (wallType) {
                case 1: zone = com.example.game.card.CastleCardZone.DECK; break;
                case 2: zone = com.example.game.card.CastleCardZone.MANA; break;
                case 3: zone = com.example.game.card.CastleCardZone.PLAY; break;
                default: return wallDestroyed;
            }
            
            // 檢查並處理城堡卡
            CardLibrary.checkZoneDestroyed(target, zone);
        }
        
        return wallDestroyed;
    }

    /**
     * 人類玩家回合執行
     */
    private void executePlayerTurn(Scanner scanner) {
        while (true) {
            displayGameState();
            System.out.println(currentPlayer.getName() + " 的回合。請選擇操作:");
            
            // 根據是否已放置Token調整選單選項
            if (!hasPlacedTokenThisTurn) {
                System.out.println("1.放置新Token 7.結束回合");
            } else {
                System.out.println("1.(已放置Token) 2.出牌 3.戰鬥 4.查看手牌 5.查看卡牌圖鑑 6.查看場上角色 7.結束回合");
            }
            
            try {
                int choice = scanner.nextInt();
                
                if (!hasPlacedTokenThisTurn && (choice > 1 && choice < 7)) {
                    System.out.println("您必須先放置新Token才能進行其他操作!");
                    continue;
                }
                
                switch (choice) {
                    case 1:
                        placeNewToken();
                        break;
                    case 2:
                        playCardsPhase(currentPlayer, scanner);
                        break;
                    case 3:
                        battle();
                        break;
                    case 4:
                        currentPlayer.displayHandDetailed();
                        break;
                    case 5:
                        CardLibrary.showLibrary();
                        break;
                    case 6:
                        gameBoard.displayBattlefieldDetails(player1, player2, currentPlayer);
                        break;
                    case 7:
                        // 結束回合
                        break;
                    default:
                        System.out.println("無效的選擇，請重新輸入!");
                        continue;
                }
                
                if (choice == 7) {
                    break; // 結束當前回合
                }
            } catch (Exception e) {
                System.out.println("輸入錯誤! 請輸入有效的數字選項");
                scanner.nextLine(); // 清除輸入緩衝
            }
        }
    }
    
    /**
     * AI玩家回合執行
     */
    private void executeAITurn() {
        com.example.game.player.AIPlayer aiPlayer = (com.example.game.player.AIPlayer) currentPlayer;
        displayGameState();
        System.out.println(aiPlayer.getName() + " 正在思考...");
        
        // 模擬AI思考時間
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // 1. 放置新Token
        if (!hasPlacedTokenThisTurn) {
            int wallType = aiPlayer.chooseTokenPlacement();
            System.out.println(aiPlayer.getName() + " 選擇放置Token到 " + getWallName(wallType));
            
            // 放置Token並更新資源
            boolean placed = aiPlayer.placeNewToken(wallType);
            if (placed) {
                hasPlacedTokenThisTurn = true;
                
                // 根據抽牌區的Token數量抽牌
                int drawAmount = aiPlayer.getCastleZone().getDrawWall().getTokenCount();
                System.out.println(aiPlayer.getName() + " 根據抽牌區的 " + drawAmount + " 個Token抽 " + drawAmount + " 張牌");
                for (int i = 0; i < drawAmount; i++) {
                    aiPlayer.drawCard();
                }
                
                // 根據法力區Token更新法力值
                int manaTokens = aiPlayer.getCastleZone().getManaWall().getTokenCount();
                aiPlayer.updateManaPoints(manaTokens);
                
                // 根據出牌區Token更新最大出牌數
                int playTokens = aiPlayer.getCastleZone().getPlayWall().getTokenCount();
                aiPlayer.updateMaxCardsToPlay(playTokens);
            } else {
                System.out.println(aiPlayer.getName() + " 不能放置更多Token了!");
            }
        }
        
        // 模擬AI思考時間
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // 2. 出牌階段
        while (true) {
            // 檢查是否還能出牌
            if (aiPlayer.getCardsPlayedThisTurn() >= aiPlayer.getMaxCardsToPlay()) {
                System.out.println(aiPlayer.getName() + " 已達本回合出牌上限。");
                break;
            }
            
            // 讓AI選擇卡牌
            int[] cardChoice = aiPlayer.chooseCardToPlay();
            if (cardChoice == null) {
                System.out.println(aiPlayer.getName() + " 沒有可出的卡牌了。");
                break;
            }
            
            int cardIndex = cardChoice[0];
            int areaIndex = cardChoice[1];
            
            // 如果手牌索引有效
            if (cardIndex >= 0 && cardIndex < aiPlayer.getHand().size()) {
                Card selectedCard = aiPlayer.getHand().get(cardIndex);
                String areaName = getAreaName(areaIndex);
                
                System.out.println(aiPlayer.getName() + " 選擇出牌: " + selectedCard.getName() + " 到 " + areaName);
                
                // 出牌
                boolean played = aiPlayer.playCard(cardIndex, areaIndex);
                if (!played) {
                    System.out.println(aiPlayer.getName() + " 出牌失敗!");
                    break;
                }
                
                // 模擬AI思考時間
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(aiPlayer.getName() + " 選擇了無效的卡牌!");
                break;
            }
        }
        
        // 模擬AI思考時間
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // 3. 戰鬥階段
        System.out.println(aiPlayer.getName() + " 進入戰鬥階段...");
        
        while (true) {
            int[] attackChoice = aiPlayer.chooseAttackTarget();
            if (attackChoice == null) {
                System.out.println(aiPlayer.getName() + " 沒有可攻擊的角色了。");
                break;
            }
            
            int attackerIndex = attackChoice[0];
            int targetType = attackChoice[1];
            int targetIndex = attackChoice[2];
            
            List<CharacterCard> aiCharacters = aiPlayer.getBattlefieldZone().getCharacters();
            if (attackerIndex >= 0 && attackerIndex < aiCharacters.size()) {
                CharacterCard attacker = aiCharacters.get(attackerIndex);
                
                if (targetType == 1) {
                    // 攻擊對手角色 (目前未實現)
                    System.out.println(aiPlayer.getName() + " 選擇使用 " + attacker.getName() + " 攻擊對手角色！");
                } else {
                    // 攻擊對手城牆
                    Player opponent = (aiPlayer == player1) ? player2 : player1;
                    String wallName = getWallName(targetIndex);
                    
                    System.out.println(aiPlayer.getName() + " 選擇使用 " + attacker.getName() + 
                                     " (攻擊力:" + attacker.getAttack() + ") 攻擊 " + 
                                     opponent.getName() + " 的 " + wallName);
                    
                    // 執行攻擊
                    boolean wallDestroyed = attackWall(opponent, targetIndex, attacker.getAttack());
                    
                    // 設置為已攻擊狀態
                    attacker.refreshForNewTurn(); // 先刷新以確保可攻擊
                    attacker.attack(attacker); // 利用現有方法將 canAttack 設為 false
                    
                    if (wallDestroyed) {
                        System.out.println(opponent.getName() + " 的 " + wallName + " 被摧毀了!");
                    }
                }
                
                // 模擬AI思考時間
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(aiPlayer.getName() + " 選擇了無效的攻擊者!");
                break;
            }
        }
        
        System.out.println(aiPlayer.getName() + " 的回合結束。");
    }
    
    /**
     * 獲取區域名稱
     */
    private String getAreaName(int areaIndex) {
        switch (areaIndex) {
            case 1: return "抽牌區";
            case 2: return "法力區";
            case 3: return "出牌區";
            default: return "未知區域";
        }
    }
    
    /**
     * 獲取城牆名稱
     */
    private String getWallName(int wallType) {
        switch (wallType) {
            case 1: return "抽牌區";
            case 2: return "法力區";
            case 3: return "出牌區";
            default: return "未知區域";
        }
    }
} 