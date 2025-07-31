package com.example.game.dto;

/**
 * 出牌請求數據傳輸對象
 */
public class PlayCardRequest {
    private String playerName;
    private int handIndex;
    private int areaType;
    
    // 建構子
    public PlayCardRequest() {}
    
    public PlayCardRequest(String playerName, int handIndex, int areaType) {
        this.playerName = playerName;
        this.handIndex = handIndex;
        this.areaType = areaType;
    }
    
    // Getter和Setter方法
    public String getPlayerName() {
        return playerName;
    }
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public int getHandIndex() {
        return handIndex;
    }
    
    public void setHandIndex(int handIndex) {
        this.handIndex = handIndex;
    }
    
    public int getAreaType() {
        return areaType;
    }
    
    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }
} 