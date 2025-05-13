package com.example.game.card;

import com.example.game.player.Player;

/**
 * 城堡卡 - 提供持久效果，但隱藏在特定區域，當區域被摧毀時效果消失
 */
public class CastleCard extends Card {
    private CastleCardZone zone;         // 城堡所在區域
    private CastleEffect effect;     // 城堡效果
    private boolean isActive;        // 城堡效果是否啟用
    
    /**
     * 創建城堡卡
     */
    public CastleCard(String name, int tokenCost, String description, Rarity rarity, Faction faction, CastleEffect effect) {
        super(name, tokenCost, description, rarity, CardType.CASTLE, faction);
        this.effect = effect;
        this.isActive = true;
        this.zone = CastleCardZone.NONE; // 初始未分配區域
    }
    
    /**
     * 隱藏城堡卡到指定區域
     */
    public void hideInZone(CastleCardZone zone) {
        this.zone = zone;
        System.out.println(name + " 已隱藏在 " + getZoneText(zone) + " 區域");
    }
    
    /**
     * 啟用城堡效果
     */
    public void activateEffect(Player player) {
        if (isActive) {
            System.out.println("城堡效果啟用: " + description);
            effect.applyEffect(player);
        }
    }
    
    /**
     * 當區域被摧毀時，檢查並處理城堡卡
     */
    public boolean checkZoneDestroyed(CastleCardZone destroyedZone) {
        if (this.zone == destroyedZone) {
            deactivate();
            return true;
        }
        return false;
    }
    
    /**
     * 停用城堡效果
     */
    public void deactivate() {
        isActive = false;
        System.out.println(name + " 的城堡效果已停用！");
    }
    
    @Override
    public void play(Player player) {
        System.out.println("城堡卡不能直接打出，它們在遊戲開始時被選擇並隱藏在特定區域");
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("類型: 城堡卡");
        System.out.println("區域: " + (zone == CastleCardZone.NONE ? "未分配" : getZoneText(zone)));
        System.out.println("狀態: " + (isActive ? "啟用中" : "已停用"));
        System.out.println("效果: " + effect.getEffectDescription());
    }
    
    /**
     * 獲取區域的中文描述
     */
    private String getZoneText(CastleCardZone zone) {
        switch (zone) {
            case PLAY:
                return "出牌區";
            case MANA:
                return "法力區";
            case DECK:
                return "抽牌區";
            case NONE:
            default:
                return "未分配";
        }
    }
    
    // Getters and Setters
    public CastleCardZone getZone() {
        return zone;
    }
    
    public CastleEffect getEffect() {
        return effect;
    }
    
    public boolean isActive() {
        return isActive;
    }
} 