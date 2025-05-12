package com.example.game;

import java.util.Scanner;

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
        // 簡單模擬，實際上會讀取玩家數據或讓玩家選擇牌組
        player1 = new Player("玩家1");
        player2 = new Player("玩家2");
        
        player1.initializeDeck();
        player2.initializeDeck();
        
        player1.drawInitialHand();
        player2.drawInitialHand();
       
        // 隨機決定先手
        currentPlayer = Math.random() > 0.5 ? player1 : player2;
        System.out.println(currentPlayer.getName() + " 將先手進行遊戲");
    }
    
    private void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        
        while (!gameOver) {
            startTurn();
            
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
                    System.out.println("法力區: " + currentPlayer.getCastleZone().getManaWall().getTokenCount() + " 個Token");
                    System.out.println("出牌區: " + currentPlayer.getCastleZone().getPlayWall().getTokenCount() + " 個Token");
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
        
        // 檢查是否有角色可以攻擊
        var characters = currentPlayer.getBattlefieldZone().getCharacters();
        if (characters.isEmpty()) {
            System.out.println("您沒有角色可以進行戰鬥!");
            return;
        }
        
        // 檢查對手是否有角色可以攻擊
        Player opponent = (currentPlayer == player1) ? player2 : player1;
        var enemyCharacters = opponent.getBattlefieldZone().getCharacters();
        if (enemyCharacters.isEmpty()) {
            System.out.println("對手沒有角色可以攻擊!");
            return;
        }
        
        // 顯示可攻擊的角色
        System.out.println("選擇進行攻擊的角色:");
        for (int i = 0; i < characters.size(); i++) {
            CharacterCard character = characters.get(i);
            System.out.println((i+1) + ". " + character.getName() + 
                   " [攻擊:" + character.getAttack() + ", 生命:" + character.getCurrentHealth() + 
                   (character.canAttack() ? ", 可攻擊" : ", 不可攻擊") + "]");
        }
        System.out.println("0. 取消");
        
        try {
            int attackerIndex = scanner.nextInt() - 1; // 轉為0-索引
            
            if (attackerIndex == -1) {
                System.out.println("取消攻擊");
                return;
            }
            
            if (attackerIndex < 0 || attackerIndex >= characters.size()) {
                System.out.println("無效的角色選擇!");
                return;
            }
            
            CharacterCard attacker = characters.get(attackerIndex);
            
            if (!attacker.canAttack()) {
                System.out.println("該角色本回合不能攻擊!");
                return;
            }
            
            // 顯示可攻擊的敵方角色
            System.out.println("選擇攻擊目標:");
            for (int i = 0; i < enemyCharacters.size(); i++) {
                CharacterCard enemy = enemyCharacters.get(i);
                System.out.println((i+1) + ". " + enemy.getName() + 
                       " [防禦:" + enemy.getDefense() + ", 生命:" + enemy.getCurrentHealth() + "]");
            }
            System.out.println("0. 取消");
            
            int targetIndex = scanner.nextInt() - 1; // 轉為0-索引
            
            if (targetIndex == -1) {
                System.out.println("取消攻擊");
                return;
            }
            
            if (targetIndex < 0 || targetIndex >= enemyCharacters.size()) {
                System.out.println("無效的目標選擇!");
                return;
            }
            
            CharacterCard target = enemyCharacters.get(targetIndex);
            
            // 執行攻擊
            int damage = attacker.attack(target);
            gameBoard.displayBattleAnimation(attacker.getName(), target.getName(), damage);
            
            // 檢查目標是否死亡
            if (target.getCurrentHealth() <= 0) {
                System.out.println(target.getName() + " 被擊敗了!");
                enemyCharacters.remove(targetIndex);
            }
            
        } catch (Exception e) {
            System.out.println("輸入錯誤! 請輸入有效的數字選項");
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
} 