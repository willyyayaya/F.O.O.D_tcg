package com.example.game.card;

import com.example.game.player.Player;

/**
 * 城堡卡效果介面 - 定義城堡卡的效果行為
 */
public interface CastleEffect {
    /**
     * 應用城堡效果到玩家
     */
    void applyEffect(Player player);
    
    /**
     * 獲取效果描述
     */
    String getEffectDescription();
} 