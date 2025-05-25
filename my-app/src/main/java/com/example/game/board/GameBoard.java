package com.example.game.board;

import java.util.List;
import java.util.Scanner;

import com.example.game.card.CharacterCard;
import com.example.game.player.Player;

/**
 * 遊戲板類 - 負責顯示F.O.O.D TCG遊戲狀態
 */
public class GameBoard {
    
    public GameBoard() {
        // 初始化遊戲板
    }
    
    /**
     * 顯示當前遊戲狀態
     */
    public void displayBoard(Player player1, Player player2, Player currentPlayer) {
        System.out.println("\n======= F.O.O.D TCG 遊戲狀態 =======");
        
        // 顯示對手信息
        Player opponent = (currentPlayer == player1) ? player2 : player1;
        System.out.println("對手: " + opponent.getName() + " - 生命值: " + opponent.getHealth());
        
        // 顯示對手的城堡區
        System.out.println("對手的城堡區:");
        opponent.getCastleZone().displayStatus();
        
        // 顯示對手的戰場區
        System.out.println("\n對手的戰場區:");
        opponent.getBattlefieldZone().displayStatus();
        
        System.out.println("\n----- 場地分隔線 -----\n");
        
        // 顯示當前玩家的戰場區
        System.out.println("您的戰場區:");
        currentPlayer.getBattlefieldZone().displayStatus();
        
        // 顯示當前玩家的城堡區
        System.out.println("\n您的城堡區:");
        currentPlayer.getCastleZone().displayStatus();
        
        // 更新資源區Token總數
        currentPlayer.updateResourceTokens();
        
        // 顯示當前玩家的資源區
        System.out.println("\n您的資源區:");
        currentPlayer.getResourceZone().displayStatus();
        
        // 顯示當前玩家信息和資源
        System.out.println("\n您: " + currentPlayer.getName() + 
                " - 生命值: " + currentPlayer.getHealth() + 
                ", 手牌數: " + currentPlayer.getHand().size() +
                ", 法力值: " + currentPlayer.getManaPoints() +
                ", 出牌次數: " + currentPlayer.getCardsPlayedThisTurn() + "/" + currentPlayer.getMaxCardsToPlay());
        
        System.out.println("==============================\n");
    }
    
    /**
     * 顯示玩家手牌
     */
    public void displayPlayerHand(Player player) {
        System.out.println("\n------ " + player.getName() + " 的手牌 ------");
        System.out.println("法力值: " + player.getManaPoints() + ", 出牌次數: " + player.getCardsPlayedThisTurn() + "/" + player.getMaxCardsToPlay());
        
        if (player.getHand().isEmpty()) {
            System.out.println("  (無)");
        } else {
            for (int i = 0; i < player.getHand().size(); i++) {
                var card = player.getHand().get(i);
                System.out.println((i+1) + ". " + card.getName() + 
                        " [類型:" + card.getType() + ", 費用:" + card.getCost() + "]");
            }
        }
        
        System.out.println("------------------------\n");
    }
    
    /**
     * 顯示戰鬥動畫（文字形式）
     */
    public void displayBattleAnimation(String attacker, String defender, int damage) {
        System.out.println("\n*** 戰鬥動畫 ***");
        System.out.println("  " + attacker + " ------> " + defender);
        System.out.println("  造成 " + damage + " 點傷害!");
        System.out.println("***************\n");
    }
    
    /**
     * 顯示戰場上的角色詳情
     */
    public void displayBattlefieldDetails(Player player1, Player player2, Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                System.out.println("\n======= 戰場角色詳情 =======");
                Player opponent = (currentPlayer == player1) ? player2 : player1;
                
                System.out.println("1. 查看您的角色");
                System.out.println("2. 查看對手的角色");
                System.out.println("0. 返回");
                System.out.print("請選擇: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // 清除輸入緩衝
                
                if (choice == 0) {
                    return;
                } else if (choice == 1) {
                    displayPlayerCharacters(currentPlayer);
                } else if (choice == 2) {
                    displayPlayerCharacters(opponent);
                } else {
                    System.out.println("無效的選擇!");
                }
            }
        } catch (Exception e) {
            System.out.println("發生錯誤: " + e.getMessage());
        }
    }
    
    /**
     * 顯示玩家場上的角色詳情
     */
    private void displayPlayerCharacters(Player player) {
        Scanner scanner = new Scanner(System.in);
        List<CharacterCard> characters = player.getBattlefieldZone().getCharacters();
        
        if (characters.isEmpty()) {
            System.out.println(player.getName() + " 的場上沒有角色");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n" + player.getName() + " 的場上角色:");
            for (int i = 0; i < characters.size(); i++) {
                CharacterCard character = characters.get(i);
                System.out.printf("%2d. %-15s [攻擊:%d, 生命:%d/%d] %s\n", 
                        i+1, character.getName(), character.getAttack(), 
                        character.getCurrentHealth(), character.getMaxHealth(), 
                        character.canAttack() ? "可攻擊" : "已消耗");
            }
            
            System.out.println("\n輸入角色編號查看詳情，或輸入0返回: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // 清除輸入緩衝
                
                if (choice == 0) {
                    return;
                } else if (choice > 0 && choice <= characters.size()) {
                    characters.get(choice-1).displayCardDetails();
                    
                    // 查看完後暫停一下
                    System.out.println("按Enter繼續...");
                    scanner.nextLine();
                } else {
                    System.out.println("無效的選擇!");
            }
            } catch (Exception e) {
                System.out.println("請輸入有效的數字!");
                scanner.nextLine(); // 清除輸入緩衝
            }
        }
    }
} 