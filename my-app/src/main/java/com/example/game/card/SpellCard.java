package com.example.game.card;

import java.util.List;

import com.example.game.player.Player;

/**
 * 法術卡 - 一次性效果的卡牌
 */
public class SpellCard extends Card {
    private SpellType spellType;
    private int value; // 效果值，如傷害量、治療量等
    private int effectDuration; // 效果持續回合數
    private boolean hasDelayedEffect; // 是否有延遲效果
    private TargetType targetType; // 目標類型
    
    /**
     * 法術目標類型枚舉
     */
    public enum TargetType {
        SELF("自己"),
        FRIENDLY_CHARACTER("友方角色"),
        ENEMY_CHARACTER("敵方角色"),
        ANY_CHARACTER("任意角色"),
        ALL_FRIENDLY_CHARACTERS("所有友方角色"),
        ALL_ENEMY_CHARACTERS("所有敵方角色"),
        ALL_CHARACTERS("所有角色"),
        NONE("無目標");
        
        private String localizedName;
        
        TargetType(String localizedName) {
            this.localizedName = localizedName;
        }
        
        public String getLocalizedName() {
            return localizedName;
        }
    }
    
    public SpellCard(String name, int cost, String description, Rarity rarity, SpellType spellType) {
        super(name, cost, description, rarity, CardType.SPELL, Faction.NEUTRAL);
        this.spellType = spellType;
        initializeSpellProperties();
    }
    
    public SpellCard(String name, int cost, String description, Rarity rarity, SpellType spellType, int points) {
        super(name, cost, description, rarity, CardType.SPELL, Faction.NEUTRAL, points);
        this.spellType = spellType;
        initializeSpellProperties();
    }
    
    public SpellCard(String name, int tokenCost, String description, Rarity rarity, SpellType spellType, Faction faction) {
        super(name, tokenCost, description, rarity, CardType.FIELD, faction);
        this.spellType = spellType;
        initializeSpellProperties();
    }
    
    /**
     * 初始化法術屬性
     */
    private void initializeSpellProperties() {
        // 根據法術類型和費用計算效果值和設置目標類型
        switch (spellType) {
            case DAMAGE:
                this.value = calculateEffectValue(1.2); // 傷害法術標準效果值稍高
                this.targetType = TargetType.ENEMY_CHARACTER;
                this.effectDuration = 1; // 立即效果
                this.hasDelayedEffect = false;
                break;
            case HEALING:
                this.value = calculateEffectValue(1.3); // 治療法術效果值更高
                this.targetType = TargetType.FRIENDLY_CHARACTER;
                this.effectDuration = 1;
                this.hasDelayedEffect = false;
                break;
            case DRAW:
                this.value = Math.max(1, getCost() / 2); // 抽牌數量適中
                this.targetType = TargetType.SELF;
                this.effectDuration = 1;
                this.hasDelayedEffect = false;
                break;
            case AOE:
                this.value = calculateEffectValue(0.8); // AOE傷害值略低
                this.targetType = TargetType.ALL_ENEMY_CHARACTERS;
                this.effectDuration = 1;
                this.hasDelayedEffect = false;
                break;
            case BUFF:
                this.value = calculateEffectValue(1.0);
                this.targetType = TargetType.FRIENDLY_CHARACTER;
                this.effectDuration = getCost() > 3 ? 2 : 1; // 高費buff可能持續多回合
                this.hasDelayedEffect = this.effectDuration > 1;
                break;
            case DEBUFF:
                this.value = calculateEffectValue(0.9);
                this.targetType = TargetType.ENEMY_CHARACTER;
                this.effectDuration = getCost() > 3 ? 2 : 1; // 高費debuff可能持續多回合
                this.hasDelayedEffect = this.effectDuration > 1;
                break;
            case TRANSFORM:
                this.value = calculateEffectValue(1.5); // 變形效果強度高
                this.targetType = TargetType.ANY_CHARACTER;
                this.effectDuration = 0; // 永久效果
                this.hasDelayedEffect = false;
                break;
            case SUMMON:
                this.value = Math.max(1, getCost() / 2); // 召喚數量
                this.targetType = TargetType.NONE;
                this.effectDuration = 0; // 永久效果
                this.hasDelayedEffect = false;
                break;
            case SPECIAL:
                this.value = calculateEffectValue(1.2);
                this.targetType = TargetType.NONE; // 特殊效果目標類型需自定義
                this.effectDuration = 0;
                this.hasDelayedEffect = false;
                break;
            default:
                this.value = getCost();
                this.targetType = TargetType.NONE;
                this.effectDuration = 1;
                this.hasDelayedEffect = false;
        }
        
        // 根據稀有度調整效果值
        adjustValueByRarity();
    }
    
    /**
     * 計算基本效果值
     * @param multiplier 效果係數
     * @return 計算後的效果值
     */
    private int calculateEffectValue(double multiplier) {
        return (int)Math.ceil(getCost() * multiplier);
    }
    
    /**
     * 根據稀有度調整效果值
     */
    private void adjustValueByRarity() {
        switch (getRarity()) {
            case CASUAL_BITES:
                // 不調整
                break;
            case GOURMET_DELIGHT:
                this.value += 1;
                break;
            case CULINARY_HERITAGE:
                this.value += 2;
                break;
            case ULTIMATE_TASTE:
                this.value += 3;
                if (this.effectDuration > 1) {
                    this.effectDuration += 1; // 傳說卡持續效果增強
                }
                break;
        }
    }
    
    @Override
    public void play(Player player) {
        System.out.println(player.getName() + " 施放法術: " + name + " (" + getFaction().getLocalizedName() + ")");
        
        // 根據法術類型執行不同效果
        switch (spellType) {
            case DAMAGE:
                applyDamage(player, null);
                break;
            case HEALING:
                applyHealing(player, null);
                break;
            case DRAW:
                applyDraw(player);
                break;
            case AOE:
                applyAOE(player, null);
                break;
            case BUFF:
                applyBuff(player, null);
                break;
            case DEBUFF:
                applyDebuff(player, null);
                break;
            case TRANSFORM:
                applyTransform(player, null);
                break;
            case SUMMON:
                applySummon(player);
                break;
            case SPECIAL:
                applySpecial(player, null);
                break;
        }
    }
    
    /**
     * 帶目標參數的施放法術方法
     * @param player 施放法術的玩家
     * @param target 目標角色卡 (可為null)
     * @param targets 多個目標 (可為null)
     */
    public void play(Player player, CharacterCard target, List<CharacterCard> targets) {
        System.out.println(player.getName() + " 施放法術: " + name + " (" + getFaction().getLocalizedName() + ")");
        
        // 根據法術類型執行不同效果
        switch (spellType) {
            case DAMAGE:
                applyDamage(player, target);
                break;
            case HEALING:
                applyHealing(player, target);
                break;
            case DRAW:
                applyDraw(player);
                break;
            case AOE:
                applyAOE(player, targets);
                break;
            case BUFF:
                applyBuff(player, target);
                break;
            case DEBUFF:
                applyDebuff(player, target);
                break;
            case TRANSFORM:
                applyTransform(player, target);
                break;
            case SUMMON:
                applySummon(player);
                break;
            case SPECIAL:
                applySpecial(player, target);
                break;
        }
    }
    
    // 各種法術效果的實現
    private void applyDamage(Player player, CharacterCard target) {
        if (target == null) {
            System.out.println("錯誤：傷害法術需要指定目標角色");
            return;
        }
        
        // 檢查是否有與陣營相關的特殊效果
        int actualDamage = value;
        if (getFaction() == target.getFaction()) {
            // 同陣營傷害減少
            actualDamage = Math.max(1, (int)(actualDamage * 0.8));
            System.out.println("同陣營效果：傷害降低至 " + actualDamage);
        } else if (isFactionCounterTo(getFaction(), target.getFaction())) {
            // 克制陣營傷害提高
            actualDamage = (int)(actualDamage * 1.5);
            System.out.println("陣營克制效果：傷害提高至 " + actualDamage);
        }
        
        System.out.println("對 " + target.getName() + " 造成 " + actualDamage + " 點傷害");
        target.takeDamage(actualDamage);
    }
    
    private void applyHealing(Player player, CharacterCard target) {
        if (target == null) {
        // 治療自己
            if (player.getHealth() < player.getMaxHealth()) {
                int healAmount = value;
                player.heal(healAmount);
                System.out.println("恢復 " + healAmount + " 點生命值");
            } else {
                System.out.println(player.getName() + " 已滿血，無需治療");
            }
        } else {
            // 治療指定角色
            int healAmount = value;
            
            // 檢查是否有與陣營相關的特殊效果
            if (getFaction() == target.getFaction()) {
                // 同陣營治療提高
                healAmount = (int)(healAmount * 1.3);
                System.out.println("同陣營效果：治療提高至 " + healAmount);
            }
            
            target.heal(healAmount);
            System.out.println("為 " + target.getName() + " 恢復 " + healAmount + " 點生命值");
        }
    }
    
    private void applyDraw(Player player) {
        int drawAmount = Math.min(value, 3); // 最多抽3張
        System.out.println("抽 " + drawAmount + " 張牌");
        for (int i = 0; i < drawAmount; i++) {
            player.drawCard();
        }
    }
    
    private void applyAOE(Player player, List<CharacterCard> targets) {
        if (targets == null || targets.isEmpty()) {
            System.out.println("錯誤：範圍傷害法術需要指定目標角色列表");
            return;
        }
        
        System.out.println("對所有目標造成 " + value + " 點傷害");
        for (CharacterCard target : targets) {
            // 對每個目標造成傷害
            int actualDamage = value;
            
            // 陣營相關效果
            if (getFaction() == target.getFaction()) {
                actualDamage = Math.max(1, (int)(actualDamage * 0.8));
            } else if (isFactionCounterTo(getFaction(), target.getFaction())) {
                actualDamage = (int)(actualDamage * 1.2); // AOE克制效果較小
            }
            
            System.out.println("  - 對 " + target.getName() + " 造成 " + actualDamage + " 點傷害");
            target.takeDamage(actualDamage);
        }
    }
    
    private void applyBuff(Player player, CharacterCard target) {
        if (target == null) {
            System.out.println("錯誤：增益法術需要指定目標角色");
            return;
        }
        
        int buffValue = value;
        
        // 陣營相關效果
        if (getFaction() == target.getFaction()) {
            buffValue = (int)(buffValue * 1.2);
            System.out.println("同陣營效果：增益效果提高至 " + buffValue);
        }
        
        // 增加攻擊力和防禦力
        target.increaseAttack(buffValue);
        target.increaseCrispyValue(buffValue);
        
        // 如果有酥脆效果，也增加酥脆值
        if (target.getCrispyValue() > 0) {
            target.increaseCrispyValue(buffValue / 2);
        }
        
        System.out.println(target.getName() + " 獲得了 +" + buffValue + "/+" + buffValue + " 的增益效果");
        
        // 持續效果處理
        if (effectDuration > 1) {
            System.out.println("此增益效果將持續 " + effectDuration + " 回合");
            // 這裡需要實現持續效果的存儲和管理
            // TODO: 需要在角色卡中添加持續效果的管理機制
        }
    }
    
    private void applyDebuff(Player player, CharacterCard target) {
        if (target == null) {
            System.out.println("錯誤：減益法術需要指定目標角色");
            return;
        }
        
        int debuffValue = value;
        
        // 陣營相關效果
        if (isFactionCounterTo(getFaction(), target.getFaction())) {
            debuffValue = (int)(debuffValue * 1.5);
            System.out.println("陣營克制效果：減益效果提高至 " + debuffValue);
        }
        
        // 減少目標的攻擊力
        int newAttack = Math.max(1, target.getAttack() - debuffValue);
        int attackReduction = target.getAttack() - newAttack;
        
        // 設置新的數值
        target.increaseAttack(-attackReduction);
        
        System.out.println(target.getName() + " 受到了 -" + attackReduction + " 攻擊力的減益效果");
        
        // 持續效果處理
        if (effectDuration > 1) {
            System.out.println("此減益效果將持續 " + effectDuration + " 回合");
            // 這裡需要實現持續效果的存儲和管理
            // TODO: 需要在角色卡中添加持續效果的管理機制
        }
    }
    
    private void applyTransform(Player player, CharacterCard target) {
        if (target == null) {
            System.out.println("錯誤：變形法術需要指定目標角色");
            return;
        }
        
        System.out.println("變形法術效果：將 " + target.getName() + " 變形");
        
        // 實現變形效果需要額外的機制
        // 這裡示範一個簡單的實現：重置目標角色的屬性
        int newAttack = value;
        int newDefense = value;
        int newHealth = value;
        
        // 更新目標屬性
        target.increaseAttack(-target.getAttack() + newAttack); // 將攻擊力設為value
        target.increaseCrispyValue(-target.getCrispyValue() + newDefense); // 將酥脆值設為value
        
        // 生命值需要特殊處理，應避免超過最大值
        // 這裡假設有一個setCurrentHealth方法
        // TODO: 需要在CharacterCard中實現更多控制生命值的方法
        
        System.out.println(target.getName() + " 已被變形為 " + newAttack + "/" + newDefense + "/" + newHealth + " 的角色");
    }
    
    private void applySummon(Player player) {
        int summonCount = value;
        System.out.println("召喚 " + summonCount + " 個食物角色");
        
        // 實現召喚效果需要額外的機制
        // 這裡需要創建新的角色卡並添加到玩家場上
        // TODO: 需要實現角色卡的創建和場上管理機制
        
        System.out.println("召喚效果已處理，請在UI中查看結果");
    }
    
    private void applySpecial(Player player, CharacterCard target) {
        System.out.println("特殊效果法術：" + getDescription());
        
        // 特殊效果需要根據具體卡牌單獨實現
        // 這裡可以根據卡牌名稱或描述來決定實現什麼效果
        
        // 示例：特殊效果 - 如果卡牌描述包含【美食陣營】關鍵字，則增強特定陣營的角色
        if (getDescription().contains("【美食陣營】")) {
            System.out.println("提升所有美食陣營角色的能力");
            // TODO: 實現美食陣營增強效果
        }
        
        // 示例：特殊效果 - 如果卡牌描述包含【料理絕技】關鍵字，則增加特定效果
        if (getDescription().contains("【料理絕技】")) {
            System.out.println("施放料理絕技特殊效果");
            // TODO: 實現料理絕技效果
        }
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("類型: 法術");
        System.out.println("法術類型: " + getSpellTypeText());
        System.out.println("效果值: " + value);
        System.out.println("目標類型: " + targetType.getLocalizedName());
        System.out.println("陣營: " + getFaction().getLocalizedName());
        
        if (effectDuration > 1) {
            System.out.println("效果持續: " + effectDuration + " 回合");
        }
        
        if (hasDelayedEffect) {
            System.out.println("特性: 具有延遲效果");
        }
    }
    
    /**
     * 獲取法術類型的中文文本描述
     */
    private String getSpellTypeText() {
        switch (spellType) {
            case DAMAGE:
                return "傷害 (對目標造成" + value + "點傷害)";
            case HEALING:
                return "治療 (回復" + value + "點生命值)";
            case DRAW:
                return "抽牌 (抽" + Math.min(value, 3) + "張牌)";
            case AOE:
                return "範圍傷害 (對所有敵方角色造成" + value + "點傷害)";
            case BUFF:
                String buffText = "增益 (使一個友方角色獲得+" + value + "/+" + value + ")";
                if (effectDuration > 1) {
                    buffText += "，持續" + effectDuration + "回合";
                }
                return buffText;
            case DEBUFF:
                String debuffText = "減益 (使一個敵方角色獲得-" + value + "/-" + value + ")";
                if (effectDuration > 1) {
                    debuffText += "，持續" + effectDuration + "回合";
                }
                return debuffText;
            case TRANSFORM:
                return "變形 (將一個角色變形為" + value + "/" + value + "/" + value + ")";
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
    
    public int getEffectDuration() {
        return effectDuration;
    }
    
    public boolean hasDelayedEffect() {
        return hasDelayedEffect;
    }
    
    public TargetType getTargetType() {
        return targetType;
    }
    
    /**
     * 判斷陣營克制關係
     * @param attackerFaction 攻擊方陣營
     * @param defenderFaction 防守方陣營
     * @return 是否克制
     */
    private boolean isFactionCounterTo(Faction attackerFaction, Faction defenderFaction) {
        // 實現陣營克制關係判斷
        // 這裡是個簡單實現，實際系統中需根據遊戲設定調整
        // 例如：甜點聯盟克制火辣王國，健康綠洲克制甜點聯盟，速食工會克制健康綠洲，火辣王國克制速食工會
        if (attackerFaction == Faction.DESSERT_UNION && defenderFaction == Faction.SPICY_KINGDOM) {
            return true;
        } else if (attackerFaction == Faction.HEALTHY_OASIS && defenderFaction == Faction.DESSERT_UNION) {
            return true;
        } else if (attackerFaction == Faction.FAST_FOOD_GUILD && defenderFaction == Faction.HEALTHY_OASIS) {
            return true;
        } else if (attackerFaction == Faction.SPICY_KINGDOM && defenderFaction == Faction.FAST_FOOD_GUILD) {
            return true;
        }
        return false;
    }
} 