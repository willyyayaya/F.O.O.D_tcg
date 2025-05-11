package com.example.game.card;

import com.example.game.player.Player;

/**
 * 料理工具卡 - 代表F.O.O.D TCG中的烹飪工具
 */
public class ToolCard extends Card {
    private ToolType toolType;       // 工具類型
    private int durability;          // 耐久度
    private int currentDurability;   // 當前耐久度
    private int effectValue;         // 效果值
    
    public ToolCard(String name, int tokenCost, String description, Rarity rarity,
                 ToolType toolType, int durability, int effectValue) {
        super(name, tokenCost, description, rarity, CardType.TOOL);
        this.toolType = toolType;
        this.durability = durability;
        this.currentDurability = durability;
        this.effectValue = effectValue;
    }
    
    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " 裝備了料理工具: " + name + "!");
    }
    
    /**
     * 使用工具效果
     * @return 是否成功使用（耐久度足夠）
     */
    public boolean use() {
        if (currentDurability > 0) {
            currentDurability--;
            System.out.println("使用 " + name + "，剩餘耐久度: " + currentDurability);
            return true;
        }
        
        System.out.println(name + " 已損壞，無法使用!");
        return false;
    }
    
    /**
     * 對目標角色使用工具
     * @param target 目標角色
     * @return 是否成功使用
     */
    public boolean useOnCharacter(CharacterCard target) {
        if (!use()) {
            return false;
        }
        
        // 根據工具類型應用效果
        switch (toolType) {
            case OFFENSIVE:
                // 攻擊型工具，造成傷害
                System.out.println("對 " + target.getName() + " 造成 " + effectValue + " 點傷害!");
                target.takeDamage(effectValue);
                break;
            case DEFENSIVE:
                // 防禦型工具，提升防禦力
                System.out.println("提升 " + target.getName() + " " + effectValue + " 點防禦力!");
                target.increaseDefense(effectValue);
                break;
            case UTILITY:
                // 效用型工具，通常有特殊效果
                System.out.println("對 " + target.getName() + " 使用效用工具: " + description);
                break;
        }
        
        return true;
    }
    
    /**
     * 修復工具耐久度
     * @param amount 修復量
     */
    public void repair(int amount) {
        currentDurability = Math.min(currentDurability + amount, durability);
        System.out.println(name + " 修復了 " + amount + " 點耐久度，當前耐久: " + currentDurability);
    }
    
    // Getters
    public ToolType getToolType() {
        return toolType;
    }
    
    public int getDurability() {
        return durability;
    }
    
    public int getCurrentDurability() {
        return currentDurability;
    }
    
    public int getEffectValue() {
        return effectValue;
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("工具類型: " + getToolTypeText());
        System.out.println("耐久度: " + currentDurability + "/" + durability);
        System.out.println("效果值: " + effectValue);
    }
    
    /**
     * 獲取工具類型的文字描述
     */
    private String getToolTypeText() {
        switch (toolType) {
            case OFFENSIVE:
                return "攻擊型";
            case DEFENSIVE:
                return "防禦型";
            case UTILITY:
                return "效用型";
            default:
                return "未知";
        }
    }
} 