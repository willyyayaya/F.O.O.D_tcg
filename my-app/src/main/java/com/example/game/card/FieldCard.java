package com.example.game.card;

import com.example.game.player.Player;

/**
 * 場地卡 - 代表F.O.O.D TCG中的場地效果
 */
public class FieldCard extends Card {
    private int effectValue;             // 效果值
    
    /**
     * 創建環境類場地卡
     */
    public static FieldCard createEnvironmentField(String name, int tokenCost, String description, 
            Rarity rarity, int effectValue) {
        return createEnvironmentField(name, tokenCost, description, rarity, effectValue, Faction.NEUTRAL);
    }

    /**
     * 創建指定陣營的環境類場地卡
     */
    public static FieldCard createEnvironmentField(String name, int tokenCost, String description, 
            Rarity rarity, int effectValue, Faction faction) {
        FieldCard card = new FieldCard(name, tokenCost, description, rarity, faction);
        card.effectValue = effectValue;
        return card;
    }
    
    private FieldCard(String name, int tokenCost, String description, Rarity rarity, Faction faction) {
        super(name, tokenCost, description, rarity, CardType.FIELD, faction);
    }
    
    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " 使用了場地卡: " + name + "! (" + getFaction().getLocalizedName() + ")");
        System.out.println("場地效果：環境 [效果值: " + effectValue + "]");
        System.out.println("該場地改變戰場環境，產生特殊效果: " + description);
    }
    
    /**
     * 獲取效果值
     */
    public int getEffectValue() {
        return effectValue;
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("場地類型: 環境");
        System.out.println("效果值: " + effectValue);
    }
} 