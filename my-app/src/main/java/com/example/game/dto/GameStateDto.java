package com.example.game.dto;

import java.util.List;

import com.example.game.card.Card;

/**
 * 遊戲狀態數據傳輸對象
 */
public class GameStateDto {
    private String gameId;
    private PlayerDto player1;
    private PlayerDto player2;
    private String currentPlayerName;
    private int turnNumber;
    private boolean gameOver;
    private String winner;
    private String message;
    
    // 建構子
    public GameStateDto() {}
    
    public GameStateDto(String gameId, PlayerDto player1, PlayerDto player2, 
                       String currentPlayerName, int turnNumber, boolean gameOver) {
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayerName = currentPlayerName;
        this.turnNumber = turnNumber;
        this.gameOver = gameOver;
    }
    
    // Getter和Setter方法
    public String getGameId() {
        return gameId;
    }
    
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    
    public PlayerDto getPlayer1() {
        return player1;
    }
    
    public void setPlayer1(PlayerDto player1) {
        this.player1 = player1;
    }
    
    public PlayerDto getPlayer2() {
        return player2;
    }
    
    public void setPlayer2(PlayerDto player2) {
        this.player2 = player2;
    }
    
    public String getCurrentPlayerName() {
        return currentPlayerName;
    }
    
    public void setCurrentPlayerName(String currentPlayerName) {
        this.currentPlayerName = currentPlayerName;
    }
    
    public int getTurnNumber() {
        return turnNumber;
    }
    
    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * 玩家數據傳輸對象
     */
    public static class PlayerDto {
        private String name;
        private int health;
        private int maxHealth;
        private int manaPoints;
        private int maxCardsToPlay;
        private int cardsPlayedThisTurn;
        private List<Card> hand;
        private WallDto drawWall;
        private WallDto manaWall;
        private WallDto playWall;
        
        // 建構子
        public PlayerDto() {}
        
        public PlayerDto(String name, int health, int maxHealth, int manaPoints, 
                        int maxCardsToPlay, int cardsPlayedThisTurn, List<Card> hand) {
            this.name = name;
            this.health = health;
            this.maxHealth = maxHealth;
            this.manaPoints = manaPoints;
            this.maxCardsToPlay = maxCardsToPlay;
            this.cardsPlayedThisTurn = cardsPlayedThisTurn;
            this.hand = hand;
        }
        
        // Getter和Setter方法
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public int getHealth() {
            return health;
        }
        
        public void setHealth(int health) {
            this.health = health;
        }
        
        public int getMaxHealth() {
            return maxHealth;
        }
        
        public void setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
        }
        
        public int getManaPoints() {
            return manaPoints;
        }
        
        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
        
        public int getMaxCardsToPlay() {
            return maxCardsToPlay;
        }
        
        public void setMaxCardsToPlay(int maxCardsToPlay) {
            this.maxCardsToPlay = maxCardsToPlay;
        }
        
        public int getCardsPlayedThisTurn() {
            return cardsPlayedThisTurn;
        }
        
        public void setCardsPlayedThisTurn(int cardsPlayedThisTurn) {
            this.cardsPlayedThisTurn = cardsPlayedThisTurn;
        }
        
        public List<Card> getHand() {
            return hand;
        }
        
        public void setHand(List<Card> hand) {
            this.hand = hand;
        }
        
        public WallDto getDrawWall() {
            return drawWall;
        }
        
        public void setDrawWall(WallDto drawWall) {
            this.drawWall = drawWall;
        }
        
        public WallDto getManaWall() {
            return manaWall;
        }
        
        public void setManaWall(WallDto manaWall) {
            this.manaWall = manaWall;
        }
        
        public WallDto getPlayWall() {
            return playWall;
        }
        
        public void setPlayWall(WallDto playWall) {
            this.playWall = playWall;
        }
    }
    
    /**
     * 城牆數據傳輸對象
     */
    public static class WallDto {
        private int health;
        private int maxHealth;
        private int tokenCount;
        private int maxTokens;
        
        public WallDto() {}
        
        public WallDto(int health, int maxHealth, int tokenCount, int maxTokens) {
            this.health = health;
            this.maxHealth = maxHealth;
            this.tokenCount = tokenCount;
            this.maxTokens = maxTokens;
        }
        
        // Getter和Setter方法
        public int getHealth() {
            return health;
        }
        
        public void setHealth(int health) {
            this.health = health;
        }
        
        public int getMaxHealth() {
            return maxHealth;
        }
        
        public void setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
        }
        
        public int getTokenCount() {
            return tokenCount;
        }
        
        public void setTokenCount(int tokenCount) {
            this.tokenCount = tokenCount;
        }
        
        public int getMaxTokens() {
            return maxTokens;
        }
        
        public void setMaxTokens(int maxTokens) {
            this.maxTokens = maxTokens;
        }
    }
} 