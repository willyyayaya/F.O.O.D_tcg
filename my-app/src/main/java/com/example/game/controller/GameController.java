package com.example.game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.game.FOODGameEngine;
import com.example.game.card.Card;
import com.example.game.card.CardLibrary;
import com.example.game.dto.GameStateDto;
import com.example.game.dto.PlayCardRequest;
import com.example.game.player.Player;
import com.example.game.service.GameService;

/**
 * 遊戲API控制器 - 提供RESTful API接口
 */
@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private FOODGameEngine gameEngine;
    
    /**
     * 初始化卡牌圖鑑
     */
    @PostMapping("/initialize")
    public ResponseEntity<Map<String, String>> initializeGame() {
        try {
            CardLibrary.initialize();
            Map<String, String> response = new HashMap<>();
            response.put("message", "遊戲初始化成功");
            response.put("status", "success");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "遊戲初始化失敗: " + e.getMessage());
            response.put("status", "error");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    /**
     * 開始新遊戲
     */
    @PostMapping("/start")
    public ResponseEntity<GameStateDto> startNewGame(@RequestBody Map<String, String> request) {
        try {
            String player1Name = request.get("player1Name");
            String player2Name = request.get("player2Name");
            
            GameStateDto gameState = gameService.startNewGame(player1Name, player2Name);
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 獲取當前遊戲狀態
     */
    @GetMapping("/state")
    public ResponseEntity<GameStateDto> getGameState() {
        try {
            GameStateDto gameState = gameService.getCurrentGameState();
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 打出手牌
     */
    @PostMapping("/play-card")
    public ResponseEntity<GameStateDto> playCard(@RequestBody PlayCardRequest request) {
        try {
            GameStateDto gameState = gameService.playCard(
                request.getPlayerName(),
                request.getHandIndex(),
                request.getAreaType()
            );
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 結束回合
     */
    @PostMapping("/end-turn")
    public ResponseEntity<GameStateDto> endTurn(@RequestBody Map<String, String> request) {
        try {
            String playerName = request.get("playerName");
            GameStateDto gameState = gameService.endTurn(playerName);
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 放置Token
     */
    @PostMapping("/place-token")
    public ResponseEntity<GameStateDto> placeToken(@RequestBody Map<String, Object> request) {
        try {
            String playerName = (String) request.get("playerName");
            Integer wallType = (Integer) request.get("wallType");
            
            GameStateDto gameState = gameService.placeToken(playerName, wallType);
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 獲取卡牌圖鑑
     */
    @GetMapping("/cards")
    public ResponseEntity<Map<String, Object>> getCardLibrary() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("characters", CardLibrary.getAllCharacters());
            response.put("spells", CardLibrary.getAllSpells());
            response.put("fields", CardLibrary.getAllFieldCards());
            response.put("castles", CardLibrary.getAllCastles());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 根據名稱獲取特定卡牌
     */
    @GetMapping("/cards/{cardName}")
    public ResponseEntity<Card> getCard(@PathVariable String cardName) {
        try {
            Card card = CardLibrary.getCardByName(cardName);
            if (card != null) {
                return ResponseEntity.ok(card);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 獲取玩家手牌
     */
    @GetMapping("/player/{playerName}/hand")
    public ResponseEntity<List<Card>> getPlayerHand(@PathVariable String playerName) {
        try {
            List<Card> hand = gameService.getPlayerHand(playerName);
            return ResponseEntity.ok(hand);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 攻擊城牆
     */
    @PostMapping("/attack-wall")
    public ResponseEntity<GameStateDto> attackWall(@RequestBody Map<String, Object> request) {
        try {
            String attackerName = (String) request.get("attackerName");
            String targetPlayerName = (String) request.get("targetPlayerName");
            Integer wallType = (Integer) request.get("wallType");
            Integer damage = (Integer) request.get("damage");
            
            GameStateDto gameState = gameService.attackWall(attackerName, targetPlayerName, wallType, damage);
            return ResponseEntity.ok(gameState);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 