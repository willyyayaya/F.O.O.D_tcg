package com.example.game.card;

import com.example.game.player.Player;

/**
 * 烹飪技術卡 - 代表F.O.O.D TCG中的特殊烹飪技能
 */
public class TechniqueCard extends Card {
    private TechniqueType techniqueType;  // 技術類型
    private int effectValue;              // 效果值
    private int duration;                 // 持續回合數（如果有）
    
    public TechniqueCard(String name, int tokenCost, String description, Rarity rarity,
                      TechniqueType techniqueType, int effectValue, int duration) {
        super(name, tokenCost, description, rarity, CardType.TECHNIQUE);
        this.techniqueType = techniqueType;
        this.effectValue = effectValue;
        this.duration = duration;
    }
    
    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " 使用了烹飪技術: " + name + "!");
        
        // 根據技術類型執行不同效果
        switch (techniqueType) {
            case BOOST_ATTACK:
                System.out.println("該技術可提升角色 " + effectValue + " 點攻擊力，持續 " + duration + " 回合!");
                break;
            case BOOST_DEFENSE:
                System.out.println("該技術可提升角色 " + effectValue + " 點防禦力，持續 " + duration + " 回合!");
                break;
            case HEAL:
                System.out.println("該技術可恢復角色 " + effectValue + " 點生命值!");
                break;
            case DAMAGE:
                System.out.println("該技術可對敵方角色造成 " + effectValue + " 點傷害!");
                break;
            case DRAW:
                System.out.println("該技術可讓你抽取 " + effectValue + " 張卡牌!");
                break;
            case SPECIAL:
                System.out.println("該技術有特殊效果: " + description);
                break;
        }
    }
    
    /**
     * 應用技術效果到目標角色
     * @param target 目標角色
     */
    public void applyEffect(CharacterCard target) {
        switch (techniqueType) {
            case BOOST_ATTACK:
                target.increaseAttack(effectValue);
                break;
            case BOOST_DEFENSE:
                target.increaseDefense(effectValue);
                break;
            case HEAL:
                target.heal(effectValue);
                break;
            case DAMAGE:
                target.takeDamage(effectValue);
                break;
            case SPECIAL:
                // 特殊效果需要單獨實現
                System.out.println("對 " + target.getName() + " 應用特殊效果: " + description);
                break;
            default:
                // DRAW 等不作用於角色的效果不在此處理
                break;
        }
    }
    
    // Getters
    public TechniqueType getTechniqueType() {
        return techniqueType;
    }
    
    public int getEffectValue() {
        return effectValue;
    }
    
    public int getDuration() {
        return duration;
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("技術類型: " + getTechniqueTypeText());
        System.out.println("效果值: " + effectValue);
        if (duration > 0) {
            System.out.println("持續回合: " + duration);
        }
    }
    
    /**
     * 獲取技術類型的文字描述
     */
    private String getTechniqueTypeText() {
        switch (techniqueType) {
            case BOOST_ATTACK:
                return "提升攻擊力";
            case BOOST_DEFENSE:
                return "提升防禦力";
            case HEAL:
                return "治療";
            case DAMAGE:
                return "傷害";
            case DRAW:
                return "抽牌";
            case SPECIAL:
                return "特殊";
            default:
                return "未知";
        }
    }
    
    // 兼容性方法，支援舊系統
    public int getManaCost() {
        return getTokenCost();
    }
}