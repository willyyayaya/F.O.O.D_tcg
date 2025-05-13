package com.example.game.card;

import com.example.game.player.Player;

/**
 * 城堡效果實現類 - 為各陣營提供不同的城堡效果
 */
public class CastleEffectImpl {
    
    /**
     * 火辣王國城堡效果 - 增加攻擊力和傷害
     */
    public static class SpicyKingdomEffect implements CastleEffect {
        private final int attackBonus;
        
        public SpicyKingdomEffect(int attackBonus) {
            this.attackBonus = attackBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("火辣王國城堡效果: 所有友方角色攻擊力+" + attackBonus + "，對敵方角色造成的傷害+1");
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色攻擊力+" + attackBonus + "，對敵方角色造成的傷害+1";
        }
    }
    
    /**
     * 健康綠洲城堡效果 - 增加生命值和治療效果
     */
    public static class HealthyOasisEffect implements CastleEffect {
        private final int healthBonus;
        
        public HealthyOasisEffect(int healthBonus) {
            this.healthBonus = healthBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("健康綠洲城堡效果: 所有友方角色生命值+" + healthBonus + "，每回合結束時恢復1點生命值");
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色生命值+" + healthBonus + "，每回合結束時恢復1點生命值";
        }
    }
    
    /**
     * 速食工會城堡效果 - 減少費用和加速
     */
    public static class FastFoodGuildEffect implements CastleEffect {
        private final int costReduction;
        
        public FastFoodGuildEffect(int costReduction) {
            this.costReduction = costReduction;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("速食工會城堡效果: 所有友方角色費用-" + costReduction + "，30%機率獲得【現炸】效果");
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色費用-" + costReduction + "，30%機率獲得【現炸】效果";
        }
    }
    
    /**
     * 甜點聯盟城堡效果 - 提供防禦和特殊能力
     */
    public static class DessertUnionEffect implements CastleEffect {
        private final int defenseBonus;
        
        public DessertUnionEffect(int defenseBonus) {
            this.defenseBonus = defenseBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("甜點聯盟城堡效果: 所有友方角色獲得+" + defenseBonus + "防禦，25%機率獲得【糖霜】效果");
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色獲得+" + defenseBonus + "防禦，25%機率獲得【糖霜】效果";
        }
    }
    
    /**
     * 中立城堡效果 - 多功能輔助效果
     */
    public static class NeutralEffect implements CastleEffect {
        private final int drawBonus;
        
        public NeutralEffect(int drawBonus) {
            this.drawBonus = drawBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("中立城堡效果: 每回合開始時有" + (drawBonus * 10) + "%機率額外抽一張牌，所有友方角色獲得+1/+1");
        }
        
        @Override
        public String getEffectDescription() {
            return "每回合開始時有" + (drawBonus * 10) + "%機率額外抽一張牌，所有友方角色獲得+1/+1";
        }
    }
} 