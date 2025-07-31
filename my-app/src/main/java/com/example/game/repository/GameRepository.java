package com.example.game.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.game.entity.GameEntity;

/**
 * 遊戲數據訪問Repository
 */
@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
    
    /**
     * 根據遊戲ID查找遊戲
     */
    Optional<GameEntity> findByGameId(String gameId);
    
    /**
     * 查找進行中的遊戲
     */
    List<GameEntity> findByGameOverFalse();
    
    /**
     * 查找已結束的遊戲
     */
    List<GameEntity> findByGameOverTrue();
    
    /**
     * 根據玩家名稱查找遊戲
     */
    @Query("SELECT g FROM GameEntity g WHERE g.player1Name = :playerName OR g.player2Name = :playerName")
    List<GameEntity> findGamesByPlayerName(@Param("playerName") String playerName);
    
    /**
     * 查找玩家的進行中遊戲
     */
    @Query("SELECT g FROM GameEntity g WHERE (g.player1Name = :playerName OR g.player2Name = :playerName) AND g.gameOver = false")
    List<GameEntity> findActiveGamesByPlayerName(@Param("playerName") String playerName);
    
    /**
     * 查找最近的遊戲
     */
    @Query("SELECT g FROM GameEntity g ORDER BY g.createdAt DESC")
    List<GameEntity> findRecentGames();
    
    /**
     * 刪除舊的已結束遊戲
     */
    @Query("DELETE FROM GameEntity g WHERE g.gameOver = true AND g.updatedAt < :cutoffDate")
    void deleteOldFinishedGames(@Param("cutoffDate") java.time.LocalDateTime cutoffDate);
} 