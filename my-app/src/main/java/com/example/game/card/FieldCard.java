package com.example.game.card;

import com.example.game.player.Player;

/**
 * 場地卡 - 代表F.O.O.D TCG中的場地效果
 */
public class FieldCard extends Card {
    public enum FieldType {
        COOKING_TECHNIQUE,  // 烹飪技術類場地
        COOKING_TOOL,       // 料理工具類場地
        ENVIRONMENT         // 環境類場地
    }
    
    private FieldType fieldType;         // 場地類型
    private FieldEffectType effectType;  // 場地效果類型（整合了原技術和工具類型）
    private int effectValue;             // 效果值
    private int duration;                // 持續回合數（對技術類場地有效）
    private int durability;              // 耐久度（對工具類場地有效）
    private int currentDurability;       // 當前耐久度
    
    /**
     * 創建烹飪技術類場地卡
     */
    public static FieldCard createTechniqueField(String name, int tokenCost, String description, 
            Rarity rarity, FieldEffectType effectType, int effectValue, int duration) {
        return createTechniqueField(name, tokenCost, description, rarity, effectType, effectValue, duration, Faction.NEUTRAL);
    }

    /**
     * 創建指定陣營的烹飪技術類場地卡
     */
    public static FieldCard createTechniqueField(String name, int tokenCost, String description, 
            Rarity rarity, FieldEffectType effectType, int effectValue, int duration, Faction faction) {
        
        if (!effectType.isTechniqueEffect()) {
            throw new IllegalArgumentException("必須使用技術類型的效果");
        }
        
        FieldCard card = new FieldCard(name, tokenCost, description, rarity, FieldType.COOKING_TECHNIQUE, faction);
        card.effectType = effectType;
        card.effectValue = effectValue;
        card.duration = duration;
        return card;
    }
    
    /**
     * 創建料理工具類場地卡
     */
    public static FieldCard createToolField(String name, int tokenCost, String description, 
            Rarity rarity, FieldEffectType effectType, int durability, int effectValue) {
        return createToolField(name, tokenCost, description, rarity, effectType, durability, effectValue, Faction.NEUTRAL);
    }

    /**
     * 創建指定陣營的料理工具類場地卡
     */
    public static FieldCard createToolField(String name, int tokenCost, String description, 
            Rarity rarity, FieldEffectType effectType, int durability, int effectValue, Faction faction) {
        
        FieldCard card = new FieldCard(name, tokenCost, description, rarity, FieldType.COOKING_TOOL, faction);
        card.effectType = effectType;
        card.durability = durability;
        card.currentDurability = durability;
        card.effectValue = effectValue;
        return card;
    }
    
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
        
        FieldCard card = new FieldCard(name, tokenCost, description, rarity, FieldType.ENVIRONMENT, faction);
        card.effectType = FieldEffectType.ENVIRONMENTAL; // 使用環境類型
        card.effectValue = effectValue;
        return card;
    }
    
    private FieldCard(String name, int tokenCost, String description, Rarity rarity, FieldType fieldType) {
        this(name, tokenCost, description, rarity, fieldType, Faction.NEUTRAL);
    }

    private FieldCard(String name, int tokenCost, String description, Rarity rarity, FieldType fieldType, Faction faction) {
        super(name, tokenCost, description, rarity, CardType.FIELD, faction);
        this.fieldType = fieldType;
    }
    
    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " 使用了場地卡: " + name + "! (" + getFaction().getLocalizedName() + ")");
        
        // 根據場地類型執行不同效果
        switch (fieldType) {
            case COOKING_TECHNIQUE:
                applyTechniqueEffect(player);
                break;
            case COOKING_TOOL:
                applyToolEffect(player);
                break;
            case ENVIRONMENT:
                applyEnvironmentEffect(player);
                break;
        }
    }
    
    /**
     * 應用烹飪技術效果
     */
    private void applyTechniqueEffect(Player player) {
        if (effectType == null || !effectType.isTechniqueEffect()) return;
        
        System.out.println("場地效果：" + effectType.getDescription() + " [效果值: " + effectValue + 
                (duration > 0 ? ", 持續 " + duration + " 回合]" : "]"));
        
        // 各種技術效果的實現
        switch (effectType) {
            case BOOST_ATTACK:
                System.out.println("該場地可提升角色 " + effectValue + " 點攻擊力，持續 " + duration + " 回合!");
                break;
            case BOOST_DEFENSE:
                System.out.println("該場地可提升角色 " + effectValue + " 點防禦力，持續 " + duration + " 回合!");
                break;
            case HEAL:
                System.out.println("該場地可恢復角色 " + effectValue + " 點生命值!");
                break;
            case DAMAGE:
                System.out.println("該場地可對敵方角色造成 " + effectValue + " 點傷害!");
                break;
            case DRAW:
                System.out.println("該場地可讓你抽取 " + effectValue + " 張卡牌!");
                break;
            case SPECIAL:
                System.out.println("該場地有特殊效果: " + description);
                break;
            default:
                System.out.println("未知的技術效果類型!");
                break;
        }
    }
    
    /**
     * 應用料理工具效果
     */
    private void applyToolEffect(Player player) {
        // 獲取效果類型
        if (effectType == null) return;
        
        System.out.println("場地效果：" + effectType.getDescription() + " [效果值: " + effectValue + 
                ", 耐久度: " + currentDurability + "/" + durability + "]");
        
        // 根據效果類型應用效果
        switch (effectType) {
            case OFFENSIVE:
                System.out.println("該場地提供攻擊性效果，可對敵方造成傷害!");
                break;
            case DEFENSIVE:
                System.out.println("該場地提供防禦性效果，可增強我方防禦!");
                break;
            case UTILITY:
                System.out.println("該場地提供各種實用效果!");
                break;
            case SUPPORTIVE:
                System.out.println("該場地提供輔助效果，增強友方能力!");
                break;
            case DISRUPTIVE:
                System.out.println("該場地提供干擾效果，削弱敵方能力!");
                break;
            case ECONOMIC:
                System.out.println("該場地提供經濟效果，給予資源優勢!");
                break;
            case STRATEGIC:
                System.out.println("該場地提供戰略選擇，擴展可用策略!");
                break;
            case ENVIRONMENTAL:
                System.out.println("該場地改變戰場環境，提供獨特效果!");
                break;
            default:
                System.out.println("未知的工具效果類型!");
                break;
        }
    }
    
    /**
     * 應用環境效果
     */
    private void applyEnvironmentEffect(Player player) {
        System.out.println("場地效果：環境 [效果值: " + effectValue + "]");
        System.out.println("該場地改變戰場環境，產生特殊效果: " + description);
    }
    
    /**
     * 使用場地效果（針對工具類場地，使用會消耗耐久度）
     */
    public boolean use() {
        if (fieldType != FieldType.COOKING_TOOL) return true; // 非工具類場地不消耗耐久度
        
        if (currentDurability > 0) {
            currentDurability--;
            System.out.println("使用 " + name + "，剩餘耐久度: " + currentDurability);
            return true;
        }
        
        System.out.println(name + " 已損壞，無法使用!");
        return false;
    }
    
    /**
     * 獲取場地類型
     */
    public FieldType getFieldType() {
        return fieldType;
    }
    
    /**
     * 獲取效果類型
     */
    public FieldEffectType getEffectType() {
        return effectType;
    }
    
    /**
     * 獲取效果值
     */
    public int getEffectValue() {
        return effectValue;
    }
    
    /**
     * 獲取持續回合數（技術類場地）
     */
    public int getDuration() {
        return duration;
    }
    
    /**
     * 獲取耐久度（工具類場地）
     */
    public int getDurability() {
        return durability;
    }
    
    /**
     * 獲取當前耐久度（工具類場地）
     */
    public int getCurrentDurability() {
        return currentDurability;
    }
    
    @Override
    protected void displaySpecificDetails() {
        switch (fieldType) {
            case COOKING_TECHNIQUE:
                System.out.println("場地類型: 烹飪技術");
                if (effectType != null && effectType.isTechniqueEffect()) {
                    System.out.println("效果類型: " + effectType.getDescription());
                }
                System.out.println("效果值: " + effectValue);
                if (duration > 0) {
                    System.out.println("持續回合: " + duration);
                }
                break;
            case COOKING_TOOL:
                System.out.println("場地類型: 料理工具");
                System.out.println("效果類型: " + (effectType != null ? effectType.getDescription() : "無"));
                System.out.println("效果值: " + effectValue);
                System.out.println("耐久度: " + currentDurability + "/" + durability);
                break;
            case ENVIRONMENT:
                System.out.println("場地類型: 環境");
                System.out.println("效果值: " + effectValue);
                break;
        }
    }
} 