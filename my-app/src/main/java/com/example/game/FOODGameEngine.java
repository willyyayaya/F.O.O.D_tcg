package com.example.game;

import java.util.Scanner;

import com.example.game.board.GameBoard;
import com.example.game.card.Card;
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
    
    public FOODGameEngine() {
        this.gameBoard = new GameBoard();
        this.gameOver = false;
        this.turnNumber = 1;
        // 設置當前遊戲實例
        currentGameInstance = this;
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
        
        // 初始化卡牌圖鑑
        initializeCardLibrary();
        System.out.println("卡牌圖鑑已初始化，開始遊戲...");
        
        initializePlayers();
        gameLoop();
    }
    
    private void initializeCardLibrary() {
        // 如果已有卡牌圖鑑類，則調用其初始化方法
        // 暫時簡單處理
        System.out.println("初始化F.O.O.D TCG卡牌圖鑑...");
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
                System.out.println("1.放置新Token 2.出牌 3.戰鬥 4.查看手牌 5.結束回合");
                
                try {
                    int choice = scanner.nextInt();
                    
                    switch (choice) {
                        case 1:
                            placeNewToken();
                            break;
                        case 2:
                            playCard();
                            break;
                        case 3:
                            battle();
                            break;
                        case 4:
                            gameBoard.displayPlayerHand(currentPlayer);
                            break;
                        case 5:
                            // 結束回合
                            break;
                        default:
                            System.out.println("無效的選擇，請重新輸入!");
                            continue;
                    }
                    
                    if (choice == 5) {
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
        
        // 回合開始時抽一張牌
        currentPlayer.drawCard();
        
        // 回合開始時的處理
        currentPlayer.startNewTurn();
    }
    
    private void placeNewToken() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("選擇要放置新Token的城牆:");
        System.out.println("1.抽牌區 2.法力區 3.出牌區");
        
        try {
            int wallType = scanner.nextInt();
            if (wallType >= 1 && wallType <= 3) {
                if (currentPlayer.placeNewToken(wallType)) {
                    System.out.println("Token放置成功!");
                } else {
                    System.out.println("該城牆Token已達上限，請選擇其他城牆!");
                }
            } else {
                System.out.println("選擇無效，請輸入1-3的數字!");
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤! 請輸入有效的數字選項");
        }
    }
    
    private void playCard() {
        Scanner scanner = new Scanner(System.in);
        
        // 顯示玩家手牌
        gameBoard.displayPlayerHand(currentPlayer);
        
        if (currentPlayer.getHand().isEmpty()) {
            System.out.println("您沒有手牌可以打出!");
            return;
        }
        
        try {
            System.out.println("選擇要打出的手牌 (1-" + currentPlayer.getHand().size() + "):");
            int cardIndex = scanner.nextInt() - 1; // 轉為0-索引
            
            if (cardIndex < 0 || cardIndex >= currentPlayer.getHand().size()) {
                System.out.println("無效的卡牌選擇!");
                return;
            }
            
            // 顯示所選卡牌詳情
            Card selectedCard = currentPlayer.getHand().get(cardIndex);
            selectedCard.displayCardDetails();
            
            System.out.println("選擇要消耗Token的城牆:");
            System.out.println("1.抽牌區 (當前Token: " + currentPlayer.getCastleZone().getDrawWall().getTokenCount() + ")");
            System.out.println("2.法力區 (當前Token: " + currentPlayer.getCastleZone().getManaWall().getTokenCount() + ")");
            System.out.println("3.出牌區 (當前Token: " + currentPlayer.getCastleZone().getPlayWall().getTokenCount() + ")");
            System.out.println("0.取消");
            
            int wallChoice = scanner.nextInt();
            
            if (wallChoice >= 1 && wallChoice <= 3) {
                if (currentPlayer.playCard(cardIndex, wallChoice)) {
                    System.out.println("成功打出卡牌!");
                }
            } else if (wallChoice == 0) {
                System.out.println("取消出牌");
            } else {
                System.out.println("無效的城牆選擇!");
            }
        } catch (Exception e) {
            System.out.println("輸入錯誤! " + e.getMessage());
            scanner.nextLine(); // 清除輸入緩衝
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
    
    private void checkGameOver() {
        // 檢查玩家生命值
        if (player1.getHealth() <= 0) {
            gameOver = true;
        } else if (player2.getHealth() <= 0) {
            gameOver = true;
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