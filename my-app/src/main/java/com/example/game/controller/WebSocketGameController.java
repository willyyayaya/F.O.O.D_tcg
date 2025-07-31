package com.example.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.game.dto.GameStateDto;
import com.example.game.dto.PlayCardRequest;
import com.example.game.service.GameService;

/**
 * WebSocket遊戲控制器 - 處理即時遊戲通訊
 */
@Controller
public class WebSocketGameController {
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    
    /**
     * 處理遊戲狀態請求
     */
    @MessageMapping("/game/state")
    @SendTo("/topic/game/state")
    public GameStateDto getGameState() {
        try {
            return gameService.getCurrentGameState();
        } catch (Exception e) {
            // 返回錯誤狀態
            GameStateDto errorState = new GameStateDto();
            errorState.setMessage("獲取遊戲狀態失敗: " + e.getMessage());
            return errorState;
        }
    }
    
    /**
     * 處理出牌請求
     */
    @MessageMapping("/game/play-card")
    @SendTo("/topic/game/update")
    public GameStateDto playCard(PlayCardRequest request) {
        try {
            GameStateDto gameState = gameService.playCard(
                request.getPlayerName(),
                request.getHandIndex(),
                request.getAreaType()
            );
            
            // 發送遊戲更新到所有訂閱者
            broadcastGameUpdate(gameState);
            
            return gameState;
        } catch (Exception e) {
            GameStateDto errorState = new GameStateDto();
            errorState.setMessage("出牌失敗: " + e.getMessage());
            return errorState;
        }
    }
    
    /**
     * 處理結束回合請求
     */
    @MessageMapping("/game/end-turn")
    @SendTo("/topic/game/update")
    public GameStateDto endTurn(String playerName) {
        try {
            GameStateDto gameState = gameService.endTurn(playerName);
            
            // 廣播回合更新
            broadcastGameUpdate(gameState);
            
            return gameState;
        } catch (Exception e) {
            GameStateDto errorState = new GameStateDto();
            errorState.setMessage("結束回合失敗: " + e.getMessage());
            return errorState;
        }
    }
    
    /**
     * 處理放置Token請求
     */
    @MessageMapping("/game/place-token")
    @SendTo("/topic/game/update")
    public GameStateDto placeToken(TokenPlaceRequest request) {
        try {
            GameStateDto gameState = gameService.placeToken(
                request.getPlayerName(),
                request.getWallType()
            );
            
            // 廣播Token放置更新
            broadcastGameUpdate(gameState);
            
            return gameState;
        } catch (Exception e) {
            GameStateDto errorState = new GameStateDto();
            errorState.setMessage("放置Token失敗: " + e.getMessage());
            return errorState;
        }
    }
    
    /**
     * 廣播遊戲更新給所有玩家
     */
    private void broadcastGameUpdate(GameStateDto gameState) {
        messagingTemplate.convertAndSend("/topic/game/update", gameState);
        
        // 發送特定玩家的更新
        if (gameState.getPlayer1() != null) {
            messagingTemplate.convertAndSendToUser(
                gameState.getPlayer1().getName(),
                "/queue/game/personal",
                gameState
            );
        }
        
        if (gameState.getPlayer2() != null) {
            messagingTemplate.convertAndSendToUser(
                gameState.getPlayer2().getName(),
                "/queue/game/personal",
                gameState
            );
        }
    }
    
    /**
     * Token放置請求DTO
     */
    public static class TokenPlaceRequest {
        private String playerName;
        private int wallType;
        
        public TokenPlaceRequest() {}
        
        public String getPlayerName() {
            return playerName;
        }
        
        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }
        
        public int getWallType() {
            return wallType;
        }
        
        public void setWallType(int wallType) {
            this.wallType = wallType;
        }
    }
} 