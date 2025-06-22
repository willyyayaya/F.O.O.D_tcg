package com.example.game.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 遊戲服務層
 * 處理遊戲的業務邏輯
 */
@Service
public class GameService {
    
    // 使用ConcurrentHashMap存儲多個遊戲實例
    private final Map<String, GameSession> activeSessions = new ConcurrentHashMap<>();
    
    /**
     * 創建新遊戲
     */
    public String createNewGame(String player1Name, String player2Name) {
        String gameId = UUID.randomUUID().toString();
        GameSession session = new GameSession(gameId, player1Name, player2Name);
        activeSessions.put(gameId, session);
        
        System.out.println("新遊戲已創建 ID: " + gameId);
        return gameId;
    }
    
    /**
     * 獲取遊戲詳情
     */
    public Map<String, Object> getGameDetails(String gameId) {
        GameSession session = activeSessions.get(gameId);
        if (session == null) {
            throw new RuntimeException("找不到遊戲 ID: " + gameId);
        }
        
        Map<String, Object> details = new HashMap<>();
        details.put("gameId", session.getGameId());
        details.put("player1", session.getPlayer1Name());
        details.put("player2", session.getPlayer2Name());
        details.put("status", session.getStatus());
        details.put("createdTime", session.getCreatedTime());
        
        return details;
    }
    
    /**
     * 結束遊戲
     */
    public void endGame(String gameId) {
        activeSessions.remove(gameId);
        System.out.println("遊戲已結束 ID: " + gameId);
    }
    
    /**
     * 獲取所有活躍遊戲
     */
    public Map<String, GameSession> getActiveSessions() {
        return new HashMap<>(activeSessions);
    }
    
    /**
     * 遊戲會話內部類
     */
    public static class GameSession {
        private final String gameId;
        private final String player1Name;
        private final String player2Name;
        private final long createdTime;
        private String status;
        
        public GameSession(String gameId, String player1Name, String player2Name) {
            this.gameId = gameId;
            this.player1Name = player1Name;
            this.player2Name = player2Name;
            this.createdTime = System.currentTimeMillis();
            this.status = "CREATED";
        }
        
        // Getters
        public String getGameId() { return gameId; }
        public String getPlayer1Name() { return player1Name; }
        public String getPlayer2Name() { return player2Name; }
        public long getCreatedTime() { return createdTime; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
} 