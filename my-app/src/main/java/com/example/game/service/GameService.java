package com.example.game.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.game.FOODGameEngine;
import com.example.game.card.Card;
import com.example.game.card.CardLibrary;
import com.example.game.dto.GameStateDto;
import com.example.game.dto.GameStateDto.PlayerDto;
import com.example.game.dto.GameStateDto.WallDto;
import com.example.game.player.Player;

/**
 * 遊戲服務層 - 處理遊戲業務邏輯
 */
@Service
public class GameService {
    
    @Autowired
    private FOODGameEngine gameEngine;
    
    private String currentGameId;
    
    /**
     * 開始新遊戲
     */
    public GameStateDto startNewGame(String player1Name, String player2Name) {
        // 初始化卡牌圖鑑
        CardLibrary.initialize();
        
        // 生成遊戲ID
        currentGameId = UUID.randomUUID().toString();
        
        // 設置玩家並啟動遊戲引擎
        gameEngine.setupPlayers(player1Name, player2Name);
        
        return getCurrentGameState();
    }
    
    /**
     * 獲取當前遊戲狀態
     */
    public GameStateDto getCurrentGameState() {
        if (FOODGameEngine.getPlayer1() == null || FOODGameEngine.getPlayer2() == null) {
            throw new RuntimeException("遊戲未開始");
        }
        
        Player player1 = FOODGameEngine.getPlayer1();
        Player player2 = FOODGameEngine.getPlayer2();
        Player currentPlayer = FOODGameEngine.getCurrentPlayer();
        
        // 轉換玩家數據
        PlayerDto player1Dto = convertToPlayerDto(player1);
        PlayerDto player2Dto = convertToPlayerDto(player2);
        
        GameStateDto gameState = new GameStateDto(
            currentGameId,
            player1Dto,
            player2Dto,
            currentPlayer != null ? currentPlayer.getName() : "",
            gameEngine.getTurnNumber(),
            gameEngine.isGameOver()
        );
        
        if (gameEngine.isGameOver()) {
            // 判定勝利者
            if (!player1.isDefeated()) {
                gameState.setWinner(player1.getName());
            } else if (!player2.isDefeated()) {
                gameState.setWinner(player2.getName());
            }
        }
        
        return gameState;
    }
    
    /**
     * 打出手牌
     */
    public GameStateDto playCard(String playerName, int handIndex, int areaType) {
        Player player = getPlayerByName(playerName);
        Player opponent = getOpponent(player);
        
        boolean success = player.playCard(handIndex, areaType, opponent);
        
        GameStateDto gameState = getCurrentGameState();
        if (success) {
            gameState.setMessage(playerName + " 成功打出了卡牌");
        } else {
            gameState.setMessage("打出卡牌失敗");
        }
        
        return gameState;
    }
    
    /**
     * 結束回合
     */
    public GameStateDto endTurn(String playerName) {
        Player currentPlayer = gameEngine.getCurrentPlayer();
        
        if (currentPlayer == null || !currentPlayer.getName().equals(playerName)) {
            throw new RuntimeException("不是該玩家的回合");
        }
        
        gameEngine.endTurn();
        
        GameStateDto gameState = getCurrentGameState();
        gameState.setMessage(playerName + " 結束了回合");
        
        return gameState;
    }
    
    /**
     * 放置Token
     */
    public GameStateDto placeToken(String playerName, int wallType) {
        Player player = getPlayerByName(playerName);
        
        boolean success = player.placeNewToken(wallType);
        
        GameStateDto gameState = getCurrentGameState();
        if (success) {
            gameState.setMessage(playerName + " 成功放置了Token");
        } else {
            gameState.setMessage("放置Token失敗");
        }
        
        return gameState;
    }
    
    /**
     * 獲取玩家手牌
     */
    public List<Card> getPlayerHand(String playerName) {
        Player player = getPlayerByName(playerName);
        return player.getHand();
    }
    
    /**
     * 攻擊城牆
     */
    public GameStateDto attackWall(String attackerName, String targetPlayerName, int wallType, int damage) {
        Player targetPlayer = getPlayerByName(targetPlayerName);
        
        boolean wallDestroyed = targetPlayer.attackWall(wallType, damage);
        
        GameStateDto gameState = getCurrentGameState();
        
        String wallName = getWallName(wallType);
        if (wallDestroyed) {
            gameState.setMessage(targetPlayerName + " 的 " + wallName + " 被摧毀了！");
        } else {
            gameState.setMessage(targetPlayerName + " 的 " + wallName + " 受到了 " + damage + " 點傷害");
        }
        
        return gameState;
    }
    
    // 輔助方法
    
    /**
     * 根據名稱獲取玩家
     */
    private Player getPlayerByName(String playerName) {
        Player player1 = gameEngine.getPlayer1();
        Player player2 = gameEngine.getPlayer2();
        
        if (player1 != null && player1.getName().equals(playerName)) {
            return player1;
        } else if (player2 != null && player2.getName().equals(playerName)) {
            return player2;
        } else {
            throw new RuntimeException("找不到玩家: " + playerName);
        }
    }
    
    /**
     * 獲取對手
     */
    private Player getOpponent(Player player) {
        Player player1 = gameEngine.getPlayer1();
        Player player2 = gameEngine.getPlayer2();
        
        if (player == player1) {
            return player2;
        } else if (player == player2) {
            return player1;
        } else {
            throw new RuntimeException("無效的玩家");
        }
    }
    
    /**
     * 轉換玩家為DTO
     */
    private PlayerDto convertToPlayerDto(Player player) {
        PlayerDto dto = new PlayerDto(
            player.getName(),
            player.getHealth(),
            player.getMaxHealth(),
            player.getManaPoints(),
            player.getMaxCardsToPlay(),
            player.getCardsPlayedThisTurn(),
            player.getHand()
        );
        
        // 轉換城牆信息 - 使用固定的最大Token數量
        dto.setDrawWall(new WallDto(
            player.getCastleZone().getDrawWall().getHealth(),
            player.getCastleZone().getDrawWall().getMaxHealth(),
            player.getCastleZone().getDrawWall().getTokenCount(),
            10 // 最大Token數量（從CastleZone.MAX_TOTAL_TOKENS推斷）
        ));
        
        dto.setManaWall(new WallDto(
            player.getCastleZone().getManaWall().getHealth(),
            player.getCastleZone().getManaWall().getMaxHealth(),
            player.getCastleZone().getManaWall().getTokenCount(),
            10
        ));
        
        dto.setPlayWall(new WallDto(
            player.getCastleZone().getPlayWall().getHealth(),
            player.getCastleZone().getPlayWall().getMaxHealth(),
            player.getCastleZone().getPlayWall().getTokenCount(),
            10
        ));
        
        return dto;
    }
    
    /**
     * 獲取城牆名稱
     */
    private String getWallName(int wallType) {
        switch (wallType) {
            case 1: return "抽牌區城牆";
            case 2: return "法力區城牆";
            case 3: return "出牌區城牆";
            default: return "未知城牆";
        }
    }
} 