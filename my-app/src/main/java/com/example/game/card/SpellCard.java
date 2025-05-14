package com.example.game.card;

import com.example.game.player.Player;

/**
 * 法術卡 - 一次性效果的卡牌
 */
public class SpellCard extends Card {
    private SpellType spellType;
    private int value; // 效果值，如傷害量、治療量等
    private Faction faction; // 添加陣營屬性
    
    public SpellCard(String name, int tokenCost, String description, Rarity rarity, SpellType spellType) {
        super(name, tokenCost, description, rarity, CardType.FIELD);
        this.spellType = spellType;
        this.faction = Faction.NEUTRAL; // 預設為中立陣營
        
        // 根據費用生成效果值，通常費用越高效果越強
        this.value = tokenCost + (int)(Math.random() * 3);
    }
    
    // 添加帶有陣營參數的新構造函數
    public SpellCard(String name, int tokenCost, String description, Rarity rarity, SpellType spellType, Faction faction) {
        super(name, tokenCost, description, rarity, CardType.FIELD);
        this.spellType = spellType;
        this.faction = faction;
        
        // 根據費用生成效果值，通常費用越高效果越強
        this.value = tokenCost + (int)(Math.random() * 3);
    }
    
    @Override
    public void play(Player player) {
        System.out.println("施放法術: " + name);
        
        // 根據法術類型執行不同效果
        switch (spellType) {
            case DAMAGE:
                applyDamage(player);
                break;
            case HEALING:
                applyHealing(player);
                break;
            case DRAW:
                applyDraw(player);
                break;
            case AOE:
                applyAOE(player);
                break;
            case BUFF:
                applyBuff(player);
                break;
            case DEBUFF:
                applyDebuff(player);
                break;
            case TRANSFORM:
                applyTransform(player);
                break;
            case SUMMON:
                applySummon(player);
                break;
            case SPECIAL:
                applySpecial(player);
                break;
        }
    }
    
    // 各種法術效果的實現
    private void applyDamage(Player player) {
        System.out.println("造成 " + value + " 點傷害");
        // 由於FOODGameEngine處理邏輯不同，我們簡化處理
        System.out.println("目標選擇功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applyHealing(Player player) {
        System.out.println("恢復 " + value + " 點生命值");
        // 治療自己
        if (player.getHealth() < 30) {
            player.heal(value);
        }
    }
    
    private void applyDraw(Player player) {
        int drawAmount = Math.min(value, 3); // 最多抽3張
        System.out.println("抽 " + drawAmount + " 張牌");
        for (int i = 0; i < drawAmount; i++) {
            player.drawCard();
        }
    }
    
    private void applyAOE(Player player) {
        System.out.println("對所有敵方角色造成 " + value + " 點傷害");
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applyBuff(Player player) {
        System.out.println("使一個友方角色獲得+" + value + "/+" + value);
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applyDebuff(Player player) {
        System.out.println("使一個敵方角色獲得-" + value + "/-" + value);
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applyTransform(Player player) {
        System.out.println("變形法術效果");
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applySummon(Player player) {
        System.out.println("召喚 " + value + " 個角色");
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    private void applySpecial(Player player) {
        System.out.println("特殊效果法術");
        System.out.println("此功能已由F.O.O.D TCG系統的FieldCard替代");
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("類型: 法術");
        System.out.println("法術類型: " + getSpellTypeText(spellType));
        System.out.println("效果值: " + value);
        System.out.println("陣營: " + faction.getLocalizedName());
    }
    
    /**
     * 獲取法術類型的中文文本描述
     */
    private String getSpellTypeText(SpellType type) {
        switch (type) {
            case DAMAGE:
                return "傷害 (對目標造成" + value + "點傷害)";
            case HEALING:
                return "治療 (回復" + value + "點生命值)";
            case DRAW:
                return "抽牌 (抽" + Math.min(value, 3) + "張牌)";
            case AOE:
                return "範圍傷害 (對所有敵方角色造成" + value + "點傷害)";
            case BUFF:
                return "增益 (使一個友方角色獲得+" + value + "/+" + value + ")";
            case DEBUFF:
                return "減益 (使一個敵方角色獲得-" + value + "/-" + value + ")";
            case TRANSFORM:
                return "變形 (將一個角色變形)";
            case SUMMON:
                return "召喚 (召喚" + value + "個角色)";
            case SPECIAL:
                return "特殊效果 (具有獨特效果的法術)";
            default:
                return "未知";
        }
    }
    
    // Getters
    public SpellType getSpellType() {
        return spellType;
    }
    
    public int getValue() {
        return value;
    }
    
    public Faction getFaction() {
        return faction;
    }
    
    // 兼容性方法，為適應新系統
    public int getTokenCost() {
        return super.getTokenCost();
    }
} 