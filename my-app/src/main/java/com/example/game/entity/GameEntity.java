package com.example.game.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * 遊戲實體類 - 用於持久化遊戲狀態
 */
@Entity
@Table(name = "games")
public class GameEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "game_id", unique = true, nullable = false)
    private String gameId;
    
    @Column(name = "player1_name", nullable = false)
    private String player1Name;
    
    @Column(name = "player2_name", nullable = false)
    private String player2Name;
    
    @Column(name = "current_player_name")
    private String currentPlayerName;
    
    @Column(name = "turn_number")
    private Integer turnNumber;
    
    @Column(name = "game_over")
    private Boolean gameOver;
    
    @Column(name = "winner")
    private String winner;
    
    @Column(name = "game_state", columnDefinition = "TEXT")
    private String gameStateJson; // JSON格式存儲完整遊戲狀態
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // 建構子
    public GameEntity() {}
    
    public GameEntity(String gameId, String player1Name, String player2Name) {
        this.gameId = gameId;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.turnNumber = 1;
        this.gameOver = false;
    }
    
    // JPA回調方法
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    // Getter和Setter方法
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getGameId() {
        return gameId;
    }
    
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    
    public String getPlayer1Name() {
        return player1Name;
    }
    
    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }
    
    public String getPlayer2Name() {
        return player2Name;
    }
    
    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }
    
    public String getCurrentPlayerName() {
        return currentPlayerName;
    }
    
    public void setCurrentPlayerName(String currentPlayerName) {
        this.currentPlayerName = currentPlayerName;
    }
    
    public Integer getTurnNumber() {
        return turnNumber;
    }
    
    public void setTurnNumber(Integer turnNumber) {
        this.turnNumber = turnNumber;
    }
    
    public Boolean getGameOver() {
        return gameOver;
    }
    
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getGameStateJson() {
        return gameStateJson;
    }
    
    public void setGameStateJson(String gameStateJson) {
        this.gameStateJson = gameStateJson;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
} 