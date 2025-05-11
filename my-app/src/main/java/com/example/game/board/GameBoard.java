package com.example.game.board;

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
        
        // 顯示當前玩家的資源區
        System.out.println("\n您的資源區:");
        currentPlayer.getResourceZone().displayStatus();
        
        // 顯示當前玩家信息
        System.out.println("\n您: " + currentPlayer.getName() + " - 生命值: " + currentPlayer.getHealth() + 
                ", 手牌數: " + currentPlayer.getHand().size());
        
        System.out.println("==============================\n");
    }
    
    /**
     * 顯示玩家手牌
     */
    public void displayPlayerHand(Player player) {
        System.out.println("\n------ " + player.getName() + " 的手牌 ------");
        
        if (player.getHand().isEmpty()) {
            System.out.println("  (無)");
        } else {
            for (int i = 0; i < player.getHand().size(); i++) {
                var card = player.getHand().get(i);
                System.out.println((i+1) + ". " + card.getName() + 
                        " [類型:" + card.getType() + ", 費用:" + card.getTokenCost() + "]");
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
} 