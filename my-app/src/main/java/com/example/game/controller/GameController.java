package com.example.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.game.FOODGameEngine;
import com.example.game.card.CardLibrary;
import com.example.game.card.Faction;
import com.example.game.service.GameService;

import java.util.HashMap;
import java.util.Map;

/**
 * F.O.O.D TCG 遊戲控制器
 * 提供REST API來操作遊戲
 */
@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*") // 允許跨域請求
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private FOODGameEngine gameEngine;
    
    /**
     * 獲取遊戲狀態
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getGameStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("message", "F.O.O.D TCG Spring Boot API 運行中");
        status.put("version", "1.0.0");
        status.put("totalCards", getTotalCardCount());
        return ResponseEntity.ok(status);
    }
    
    /**
     * 獲取所有可用的陣營
     */
    @GetMapping("/factions")
    public ResponseEntity<Faction[]> getAllFactions() {
        return ResponseEntity.ok(Faction.values());
    }
    
    /**
     * 獲取卡牌庫統計
     */
    @GetMapping("/cards/stats")
    public ResponseEntity<Map<String, Object>> getCardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("characters", CardLibrary.getAllCharacters().size());
        stats.put("spells", CardLibrary.getAllSpells().size());
        stats.put("fields", CardLibrary.getAllFieldCards().size());
        stats.put("castles", CardLibrary.getAllCastles().size());
        stats.put("total", getTotalCardCount());
        return ResponseEntity.ok(stats);
    }
    
    /**
     * 獲取指定陣營的角色卡
     */
    @GetMapping("/cards/characters/{faction}")
    public ResponseEntity<Object> getCharactersByFaction(@PathVariable String faction) {
        try {
            Faction factionEnum = Faction.valueOf(faction.toUpperCase());
            return ResponseEntity.ok(CardLibrary.getCharactersByFaction(factionEnum));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "無效的陣營: " + faction));
        }
    }
    
    /**
     * 開始新遊戲
     */
    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startNewGame(
            @RequestBody Map<String, String> request) {
        
        String player1Name = request.getOrDefault("player1", "玩家1");
        String player2Name = request.getOrDefault("player2", "玩家2");
        
        try {
            String gameId = gameService.createNewGame(player1Name, player2Name);
            Map<String, Object> response = new HashMap<>();
            response.put("gameId", gameId);
            response.put("message", "新遊戲已創建");
            response.put("players", Map.of("player1", player1Name, "player2", player2Name));
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(Map.of("error", "創建遊戲失敗: " + e.getMessage()));
        }
    }
    
    /**
     * 獲取遊戲詳情
     */
    @GetMapping("/{gameId}")
    public ResponseEntity<Object> getGameDetails(@PathVariable String gameId) {
        try {
            Object gameDetails = gameService.getGameDetails(gameId);
            return ResponseEntity.ok(gameDetails);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 測試控制台遊戲啟動
     */
    @PostMapping("/console/start")
    public ResponseEntity<Map<String, String>> startConsoleGame() {
        try {
            // 在新執行緒中啟動控制台遊戲，避免阻塞API
            new Thread(() -> {
                gameEngine.start();
            }).start();
            
            return ResponseEntity.ok(Map.of("message", "控制台遊戲已啟動"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body(Map.of("error", "啟動控制台遊戲失敗: " + e.getMessage()));
        }
    }
    
    private int getTotalCardCount() {
        return CardLibrary.getAllCharacters().size() + 
               CardLibrary.getAllSpells().size() + 
               CardLibrary.getAllFieldCards().size() + 
               CardLibrary.getAllCastles().size();
    }
} 