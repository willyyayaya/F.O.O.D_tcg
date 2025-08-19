package com.example.game;

import java.util.Scanner;

import com.example.game.card.CardLibrary;
import com.example.game.player.Player;

/**
 * 獨立的控制台遊戲執行器 - 不依賴Spring Boot
 */
public class ConsoleGameRunner {
    
    private static Scanner scanner;
    private static Player player1;
    private static Player player2;
    private static Player currentPlayer;
    private static int turnNumber = 1;
    private static boolean gameOver = false;
    
    public static void main(String[] args) {
        try (Scanner scannerResource = new Scanner(System.in)) {
            scanner = scannerResource;
            
            System.out.println("🍔 歡迎來到 F.O.O.D TCG 食物擬人對戰卡牌遊戲 - 控制台版本! 🎮");
            System.out.println("========================================================");
            
            // 初始化卡牌圖鑑
            initializeCardLibrary();
            
            // 初始化玩家
            initializePlayers();
            
            if (player1 != null && player2 != null) {
                // 開始遊戲循環
                gameLoop();
            }
            
            System.out.println("\n👋 感謝遊玩 F.O.O.D TCG！");
        }
    }
    
    private static void initializeCardLibrary() {
        System.out.println("\n🔧 正在初始化卡牌圖鑑...");
        CardLibrary.initialize();
        
        int totalCards = CardLibrary.getAllCharacters().size() + 
                         CardLibrary.getAllFieldCards().size() + 
                         CardLibrary.getAllSpells().size() +
                         CardLibrary.getAllCastles().size();
        
        System.out.println("✅ 卡牌圖鑑初始化完成，共 " + totalCards + " 張卡牌");
        System.out.println("- 角色卡: " + CardLibrary.getAllCharacters().size() + " 張");
        System.out.println("- 場地卡: " + CardLibrary.getAllFieldCards().size() + " 張");
        System.out.println("- 法術卡: " + CardLibrary.getAllSpells().size() + " 張");
        System.out.println("- 城堡卡: " + CardLibrary.getAllCastles().size() + " 張");
    }
    
    private static void initializePlayers() {
        System.out.println("\n👥 設置玩家");
        
        System.out.print("請輸入玩家1名稱 (或按Enter使用預設): ");
        String name1 = scanner.nextLine().trim();
        if (name1.isEmpty()) name1 = "玩家1";
        
        System.out.print("請輸入玩家2名稱 (或按Enter使用預設): ");
        String name2 = scanner.nextLine().trim();
        if (name2.isEmpty()) name2 = "玩家2";
        
        // 創建玩家
        player1 = new Player(name1);
        player2 = new Player(name2);
        
        // 設置對手關係
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        
        // 初始化牌組
        player1.initializeDeck();
        player2.initializeDeck();
        
        // 抽初始手牌
        player1.drawInitialHand();
        player2.drawInitialHand();
        
        // 隨機決定先手
        currentPlayer = Math.random() > 0.5 ? player1 : player2;
        
        System.out.println("\n✅ 玩家設置完成");
        System.out.println("🎯 " + currentPlayer.getName() + " 先手進行遊戲");
    }
    
    private static void gameLoop() {
        System.out.println("\n🎮 遊戲開始！");
        
        while (!gameOver) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("🔄 第 " + turnNumber + " 回合 - " + currentPlayer.getName() + " 的回合");
            System.out.println("=".repeat(50));
            
            // 顯示當前玩家狀態
            displayPlayerStatus(currentPlayer);
            
            // 玩家回合
            playerTurn(currentPlayer);
            
            // 檢查遊戲是否結束
            checkGameOver();
            
            if (!gameOver) {
                // 切換玩家
                switchPlayer();
            }
        }
        
        // 顯示遊戲結果
        showGameResult();
    }
    
    private static void displayPlayerStatus(Player player) {
        System.out.println("\n📊 " + player.getName() + " 的狀態:");
        System.out.println("❤️  生命值: " + player.getHealth() + "/" + player.getMaxHealth());
        System.out.println("🔮 法力值: " + player.getManaPoints());
        System.out.println("🃏 手牌數: " + player.getHand().size());
        System.out.println("🎯 本回合已出牌: " + player.getCardsPlayedThisTurn() + "/" + player.getMaxCardsToPlay());
        
        // 顯示城堡狀態
        System.out.println("\n🏰 城堡狀態:");
        player.getCastleZone().displayStatus();
    }
    
    private static void playerTurn(Player player) {
        // 開始新回合
        player.startNewTurn();
        
        while (true) {
            System.out.println("\n請選擇操作:");
            System.out.println("1. 🃏 查看手牌");
            System.out.println("2. 🎯 出牌");
            System.out.println("3. 🏗️  放置Token");
            System.out.println("4. 📊 查看遊戲狀態");
            System.out.println("5. 📚 瀏覽卡牌圖鑑");
            System.out.println("6. ⏭️  結束回合");
            System.out.println("0. 🚪 退出遊戲");
            
            System.out.print("請輸入選項 (0-6): ");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    showPlayerHand(player);
                    break;
                case "2":
                    playCard(player);
                    break;
                case "3":
                    placeToken(player);
                    break;
                case "4":
                    showGameStatus();
                    break;
                case "5":
                    browseCardLibrary();
                    break;
                case "6":
                    System.out.println("⏭️ " + player.getName() + " 結束回合");
                    return;
                case "0":
                    gameOver = true;
                    return;
                default:
                    System.out.println("❌ 無效選項，請重新選擇");
            }
            
            // 檢查是否可以繼續操作
            if (player.getCardsPlayedThisTurn() >= player.getMaxCardsToPlay()) {
                System.out.println("📝 本回合出牌次數已達上限，自動結束回合");
                return;
            }
        }
    }
    
    private static void showPlayerHand(Player player) {
        System.out.println("\n🃏 " + player.getName() + " 的手牌:");
        if (player.getHand().isEmpty()) {
            System.out.println("   手牌為空");
        } else {
            for (int i = 0; i < player.getHand().size(); i++) {
                var card = player.getHand().get(i);
                String cardInfo = "   [" + i + "] " + card.getName() + " (費用:" + card.getCost();
                
                // 只有角色卡有攻擊力和生命值
                if (card instanceof com.example.game.card.CharacterCard) {
                    var charCard = (com.example.game.card.CharacterCard) card;
                    cardInfo += ", 攻擊:" + charCard.getAttack() + ", 生命:" + charCard.getCurrentHealth();
                }
                cardInfo += ")";
                
                System.out.println(cardInfo);
            }
        }
    }
    
    private static void playCard(Player player) {
        showPlayerHand(player);
        
        if (player.getHand().isEmpty()) {
            System.out.println("❌ 手牌為空，無法出牌");
            return;
        }
        
        System.out.print("請選擇要出的牌 (編號): ");
        try {
            int handIndex = Integer.parseInt(scanner.nextLine().trim());
            
            System.out.println("請選擇放置區域:");
            System.out.println("1. 戰場");
            System.out.println("2. 資源區");
            System.out.println("3. 出牌區");
            System.out.print("請輸入選項 (1-3): ");
            
            int areaType = Integer.parseInt(scanner.nextLine().trim());
            
            boolean success = player.playCard(handIndex, areaType, player.getOpponent());
            
            if (success) {
                System.out.println("✅ 出牌成功！");
            } else {
                System.out.println("❌ 出牌失敗");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 請輸入有效的數字");
        }
    }
    
    private static void placeToken(Player player) {
        System.out.println("\n🏗️ 放置Token");
        System.out.println("請選擇要放置Token的城牆:");
        System.out.println("1. 抽牌區");
        System.out.println("2. 法力區");
        System.out.println("3. 出牌區");
        System.out.print("請輸入選項 (1-3): ");
        
        try {
            int wallType = Integer.parseInt(scanner.nextLine().trim());
            boolean success = player.placeNewToken(wallType);
            
            if (success) {
                System.out.println("✅ Token放置成功！");
            } else {
                System.out.println("❌ Token放置失敗");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ 請輸入有效的數字");
        }
    }
    
    private static void showGameStatus() {
        System.out.println("\n📊 遊戲狀態:");
        System.out.println("🔄 回合數: " + turnNumber);
        System.out.println("👤 當前玩家: " + currentPlayer.getName());
        
        System.out.println("\n👤 " + player1.getName() + ":");
        System.out.println("   ❤️  生命值: " + player1.getHealth() + "/" + player1.getMaxHealth());
        System.out.println("   🔮 法力值: " + player1.getManaPoints());
        System.out.println("   🃏 手牌數: " + player1.getHand().size());
        
        System.out.println("\n👤 " + player2.getName() + ":");
        System.out.println("   ❤️  生命值: " + player2.getHealth() + "/" + player2.getMaxHealth());
        System.out.println("   🔮 法力值: " + player2.getManaPoints());
        System.out.println("   🃏 手牌數: " + player2.getHand().size());
    }
    
    private static void browseCardLibrary() {
        System.out.println("\n📚 卡牌圖鑑瀏覽");
        System.out.println("1. 角色卡");
        System.out.println("2. 法術卡");
        System.out.println("3. 場地卡");
        System.out.println("4. 城堡卡");
        System.out.print("請選擇類別 (1-4): ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                showCardList("角色卡", CardLibrary.getAllCharacters());
                break;
            case "2":
                showCardList("法術卡", CardLibrary.getAllSpells());
                break;
            case "3":
                showCardList("場地卡", CardLibrary.getAllFieldCards());
                break;
            case "4":
                showCardList("城堡卡", CardLibrary.getAllCastles());
                break;
            default:
                System.out.println("❌ 無效選項");
        }
    }
    
    private static void showCardList(String cardType, java.util.List<? extends com.example.game.card.Card> cards) {
        System.out.println("\n📄 " + cardType + " 總數: " + cards.size());
        
        if (cards.isEmpty()) {
            System.out.println("❌ 沒有找到任何卡牌");
            return;
        }
        
        final int CARDS_PER_PAGE = 10;
        int totalPages = (cards.size() + CARDS_PER_PAGE - 1) / CARDS_PER_PAGE;
        int currentPage = 1;
        
        while (true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("📖 " + cardType + " - 第 " + currentPage + "/" + totalPages + " 頁");
            System.out.println("=".repeat(60));
            
            // 顯示當前頁的卡牌
            int startIndex = (currentPage - 1) * CARDS_PER_PAGE;
            int endIndex = Math.min(startIndex + CARDS_PER_PAGE, cards.size());
            
            for (int i = startIndex; i < endIndex; i++) {
                var card = cards.get(i);
                displayCardInfo(i + 1, card);
            }
            
            // 顯示操作選項
            System.out.println("\n操作選項:");
            if (currentPage > 1) System.out.println("p - 上一頁");
            if (currentPage < totalPages) System.out.println("n - 下一頁");
            System.out.println("d [編號] - 查看詳細資訊 (例: d 5)");
            System.out.println("q - 返回上級選單");
            System.out.print("請輸入選項: ");
            
            String input = scanner.nextLine().trim().toLowerCase();
            
            if (input.equals("q")) {
                break;
            } else if (input.equals("p") && currentPage > 1) {
                currentPage--;
            } else if (input.equals("n") && currentPage < totalPages) {
                currentPage++;
            } else if (input.startsWith("d ")) {
                try {
                    int cardNum = Integer.parseInt(input.substring(2).trim());
                    if (cardNum >= 1 && cardNum <= cards.size()) {
                        showDetailedCardInfo(cards.get(cardNum - 1));
                    } else {
                        System.out.println("❌ 無效的卡牌編號");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ 請輸入有效的數字");
                }
            } else {
                System.out.println("❌ 無效選項");
            }
        }
    }
    
    private static void displayCardInfo(int number, com.example.game.card.Card card) {
        String info = String.format("[%3d] %-25s", number, card.getName());
        info += " (費用:" + card.getCost() + ")";
        
        // 根據卡牌類型顯示不同資訊
        if (card instanceof com.example.game.card.CharacterCard) {
            var charCard = (com.example.game.card.CharacterCard) card;
            info += " [攻:" + charCard.getAttack() + "/血:" + charCard.getCurrentHealth() + "]";
        } else if (card instanceof com.example.game.card.SpellCard) {
            info += " [法術]";
        } else if (card instanceof com.example.game.card.FieldCard) {
            info += " [場地]";
        } else if (card instanceof com.example.game.card.CastleCard) {
            info += " [城堡]";
        }
        
        // 顯示稀有度
        info += " (" + card.getRarity().getChineseName() + ")";
        
        System.out.println(info);
    }
    
    private static void showDetailedCardInfo(com.example.game.card.Card card) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🔍 卡牌詳細資訊");
        System.out.println("=".repeat(50));
        
        System.out.println("📛 名稱: " + card.getName());
        System.out.println("💰 費用: " + card.getCost());
        System.out.println("⭐ 稀有度: " + card.getRarity().getChineseName());
        System.out.println("🏷️  陣營: " + card.getFaction().getLocalizedName());
        
        if (card instanceof com.example.game.card.CharacterCard) {
            var charCard = (com.example.game.card.CharacterCard) card;
            System.out.println("⚔️  攻擊力: " + charCard.getAttack());
            System.out.println("❤️  生命值: " + charCard.getCurrentHealth() + "/" + charCard.getMaxHealth());
            
            // 關鍵字功能暫未實現
        }
        
        System.out.println("📝 描述: " + card.getDescription());
        
        System.out.print("\n按Enter鍵返回...");
        scanner.nextLine();
    }
    
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        if (currentPlayer == player1) {
            turnNumber++;
        }
    }
    
    private static void checkGameOver() {
        if (player1.isDefeated() || player2.isDefeated()) {
            gameOver = true;
        }
    }
    
    private static void showGameResult() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏆 遊戲結束！");
        System.out.println("=".repeat(50));
        
        if (player1.isDefeated()) {
            System.out.println("🎉 " + player2.getName() + " 獲勝！");
        } else if (player2.isDefeated()) {
            System.out.println("🎉 " + player1.getName() + " 獲勝！");
        } else {
            System.out.println("🤝 遊戲平局！");
        }
        
        System.out.println("📊 遊戲統計:");
        System.out.println("- 總回合數: " + turnNumber);
        System.out.println("- " + player1.getName() + " 最終生命值: " + player1.getHealth());
        System.out.println("- " + player2.getName() + " 最終生命值: " + player2.getHealth());
    }
} 