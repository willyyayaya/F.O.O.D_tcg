package com.example.game.card;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.game.player.Player;

/**
 * 角色卡 - 代表F.O.O.D TCG中的食物擬人角色
 * 命名規則：
 * 1. 基本格式：[食材名] + [元素/魔法屬性] + [職業]
 * 2. 職業系統：保持奇幻風格（守衛者、戰士、騎士等）
 * 3. 元素系統：融入烹飪魔法（大地之力、風之力等）
 */
public class CharacterCard extends Card {
    private int attack;         // 攻擊力
    private int maxHealth;      // 最大生命值
    private int currentHealth;  // 當前生命值
    private boolean canAttack;   // 是否可以攻擊（本回合）
    
    // 效果處理器
    private static final CardEffect effectProcessor = new CardEffectImpl();
    
    // 卡牌擁有者
    private Player owner;
    
    // 酥脆效果相關
    private int crispyValue;    // 當前酥脆值（護甲值）
    private int maxCrispyValue; // 最大酥脆值
    private static final Pattern CRISPY_PATTERN = Pattern.compile("【酥脆\\(([0-9]+)\\)】");
    
    // 效果狀態
    private boolean hasFrostedEffect = false;   // 是否有糖霜效果
    private boolean sugarRushUsed = false;     // 是否使用過糖爆
    private boolean cannotAttackNextTurn = false; // 下回合無法攻擊的標記（糖爆效果）
    
    // 彈牙效果相關
    private boolean attackedOnce = false;       // 是否已經攻擊過一次
    private boolean usedChewyEffect = false; // 是否已使用彈牙效果
    
    /**
     * 角色卡建造者
     */
    public static class Builder {
        private String name;
        private int tokenCost;
        private String description;
        private Rarity rarity;
        private int attack;
        private int maxHealth;
        private Faction faction = Faction.NEUTRAL;
        private int points;

        public Builder(String name, int tokenCost, String description, Rarity rarity, int points) {
            this.name = name;
            this.tokenCost = tokenCost;
            this.description = description;
            this.rarity = rarity;
            this.points = points;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cost(int tokenCost) {
            this.tokenCost = tokenCost;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public Builder health(int maxHealth) {
            this.maxHealth = maxHealth;
            return this;
        }

        public Builder faction(Faction faction) {
            this.faction = faction;
            return this;
        }

        public Builder points(int points) {
            this.points = points;
            return this;
        }

        public CharacterCard build() {
            return new CharacterCard(this);
        }
    }

    /**
     * 單一構造函數
     */
    private CharacterCard(Builder builder) {
        super(builder.name, builder.tokenCost, builder.description, builder.rarity, 
              CardType.CHARACTER, builder.faction, builder.points);
        this.attack = builder.attack;
        this.maxHealth = builder.maxHealth;
        this.currentHealth = builder.maxHealth;
        this.canAttack = false;  // 剛出場的角色通常不能立即攻擊
        
        // 初始化酥脆值
        initCrispyValue();
        
        // 現炸效果檢查
        if (effectProcessor.processSizzleEffect(this)) {
            this.canAttack = true;
            System.out.println(name + " 具有【現炸】效果，可以立即攻擊！");
        }
    }
    
    /**
     * 初始化酥脆值
     */
    private void initCrispyValue() {
        String description = getDescription();
        if (description.contains("【酥脆】")) {
            Matcher matcher = CRISPY_PATTERN.matcher(description);
            if (matcher.find()) {
                maxCrispyValue = Integer.parseInt(matcher.group(1));
                crispyValue = maxCrispyValue;
                System.out.println(name + " 初始化酥脆值: " + crispyValue);
            } else {
                // 默認酥脆值為1
                maxCrispyValue = 1;
                crispyValue = 1;
                System.out.println(name + " 初始化默認酥脆值: 1");
            }
        } else {
            maxCrispyValue = 0;
            crispyValue = 0;
        }
    }
    
    /**
     * 重置酥脆值（恢復到最大值）
     */
    public void resetCrispyValue() {
        if (maxCrispyValue > 0) {
            crispyValue = maxCrispyValue;
            System.out.println(name + " 重置酥脆值為: " + crispyValue);
        }
    }
    
    /**
     * 消耗酥脆值
     * @param amount 消耗量
     * @return 實際消耗量
     */
    public int consumeCrispyValue(int amount) {
        int consumed = Math.min(crispyValue, amount);
        crispyValue -= consumed;
        System.out.println(name + " 消耗酥脆值: " + consumed + "，剩餘: " + crispyValue);
        return consumed;
    }
    
    /**
     * 獲取當前酥脆值
     * @return 當前酥脆值
     */
    public int getCrispyValue() {
        return crispyValue;
    }
    
    /**
     * 設置酥脆值
     * @param value 新的酥脆值
     */
    public void setCrispyValue(int value) {
        this.crispyValue = Math.max(0, Math.min(value, maxCrispyValue));
        System.out.println(name + " 設置酥脆值為: " + crispyValue);
    }
    
    /**
     * 增加酥脆值
     * @param amount 增加量
     */
    public void increaseCrispyValue(int amount) {
        setCrispyValue(crispyValue + amount);
        System.out.println(name + " 增加酥脆值: " + amount + "，現在為: " + crispyValue);
    }
    
    /**
     * 當卡牌被打出時執行
     * @param player 打出此卡牌的玩家
     */
    @Override
    public void play(Player player) {
        // 出牌時的效果，可能包括戰吼效果等
        System.out.println(player.getName() + " 派出了 " + name + " 角色! (" + getFaction().getLocalizedName() + ")");
        
        // 設置卡牌擁有者
        this.owner = player;
        
        // 處理開胃效果（類似戰吼）
        if (getDescription().contains("【開胃】")) {
            effectProcessor.processAppetizerEffect(this, player, null);
        }
    }
    
    /**
     * 當卡牌被打出時執行（帶對手參數，用於處理需要敵方目標的效果）
     * @param player 打出此卡牌的玩家
     * @param opponent 對手玩家
     */
    public void play(Player player, Player opponent) {
        // 出牌時的效果，可能包括戰吼效果等
        System.out.println(player.getName() + " 派出了 " + name + " 角色! (" + getFaction().getLocalizedName() + ")");
        
        // 設置卡牌擁有者
        this.owner = player;
        
        // 處理開胃效果（類似戰吼）
        if (getDescription().contains("【開胃】")) {
            effectProcessor.processAppetizerEffect(this, player, opponent);
        }
    }
    
    /**
     * 角色攻擊目標
     * @param target 攻擊目標
     * @return 實際造成的傷害
     */
    public int attack(CharacterCard target) {
        // 檢查是否可以攻擊
        if (!canAttack) {
            System.out.println(name + " 本回合不能攻擊!");
            return 0;
        }
        
        // 清淡效果檢查
        if (!effectProcessor.processBlandEffect(this)) {
            System.out.println(name + " 由於【清淡】效果不能攻擊!");
            return 0;
        }
        
        // 計算實際傷害
        int damage = this.attack;
        
        // 處理攻擊
        boolean targetKilled = !target.takeDamage(damage);
        
        // 設置為已攻擊狀態
        this.canAttack = false;
        
        // 標記已經攻擊過一次（用於彈牙效果）
        this.attackedOnce = true;
        
        System.out.println(name + " 攻擊了 " + target.getName() + "，造成 " + damage + " 點傷害!");
        
        // 檢查爆炒效果（有機率直接消滅目標）
        if (!targetKilled && effectProcessor.processSearEffect(this, target)) {
            target.takeDamage(target.getCurrentHealth()); // 直接消滅目標
            System.out.println(name + " 的【爆炒】效果觸發，直接消滅了 " + target.getName() + "！");
        }
        
        return damage;
    }
    
    /**
     * 使用糖爆效果
     * @param target 可選的目標角色
     * @return 執行效果的強度
     */
    public int useSugarRush(CharacterCard target) {
        if (!canAttack) {
            System.out.println(name + " 本回合不能使用【糖爆】效果!");
            return 0;
        }
        
        // 檢查是否有糖爆效果
        int effectStrength = effectProcessor.processSugarRushEffect(this, target);
        if (effectStrength > 0) {
            // 設置狀態標記
            this.canAttack = false; // 本回合不能再攻擊
            this.sugarRushUsed = true; // 已使用糖爆
            this.cannotAttackNextTurn = true; // 下回合不能攻擊
            
            System.out.println(name + " 使用了【糖爆】效果，下回合將無法攻擊");
            return effectStrength;
        } else {
            System.out.println(name + " 沒有【糖爆】效果或效果無法執行!");
            return 0;
        }
    }
    
    /**
     * 角色受到傷害
     * @param amount 傷害量
     * @return 是否存活
     */
    public boolean takeDamage(int amount) {
        // 處理護甲/減傷效果
        int actualDamage = amount;
        
        // 檢查糖霜效果
        if (hasFrostedEffect) {
            actualDamage = effectProcessor.processFrostedEffect(this, actualDamage);
            hasFrostedEffect = false; // 使用後糖霜效果消失
            System.out.println(name + " 的【糖霜】效果抵擋了攻擊！");
        } else if (crispyValue > 0) {
            // 檢查酥脆效果（護甲），每次受到傷害減少相應數量的酥脆值
            int absorbed = consumeCrispyValue(actualDamage);
            actualDamage = Math.max(0, actualDamage - absorbed);
            System.out.println(name + " 的【酥脆】效果抵擋了 " + absorbed + " 點傷害，剩餘酥脆值: " + crispyValue);
        }
        
        this.currentHealth -= actualDamage;
        System.out.println(name + " 受到 " + actualDamage + " 點傷害，剩餘生命值: " + currentHealth);
        
        // 如果角色死亡，處理回味效果
        if (currentHealth <= 0 && getDescription().contains("【回味】")) {
            System.out.println(name + " 的【回味】效果觸發！");
            if (owner != null) {
                effectProcessor.processAftertasteEffect(this, owner, null);
            } else {
                System.out.println("  無法確定卡牌擁有者，無法處理回味效果");
            }
        }
        
        return currentHealth > 0;
    }
    
    /**
     * 恢復生命值
     * @param amount 恢復量
     */
    public void heal(int amount) {
        healWithoutMessage(amount);
        System.out.println(name + " 恢復 " + amount + " 點生命值，當前生命值: " + currentHealth);
    }
    
    /**
     * 恢復生命值但不輸出訊息
     * @param amount 恢復量
     */
    public void healWithoutMessage(int amount) {
        this.currentHealth = Math.min(currentHealth + amount, maxHealth);
    }
    
    /**
     * 刷新角色狀態（新回合開始時）
     */
    public void refreshForNewTurn() {
        // 檢查下回合是否可以攻擊（糖爆效果後遺症）
        if (cannotAttackNextTurn) {
            System.out.println(name + " 由於【糖爆】效果影響，本回合無法攻擊");
            cannotAttackNextTurn = false; // 清除標記
            this.canAttack = false;
        } else {
            // 新回合開始時，可以再次攻擊
            this.canAttack = true;
        }
        
        // 重置彈牙效果狀態
        this.attackedOnce = false;
        this.usedChewyEffect = false;
        
        // 處理油膩效果（每回合攻擊力減少）
        int attackReduction = effectProcessor.processGreasyEffect(this);
        if (attackReduction > 0) {
            this.attack = Math.max(1, this.attack - attackReduction); // 最低降至1
        }
        
        // 處理滋補效果（回合結束時恢復生命值）
        int healAmount = effectProcessor.processHeartyEffect(this);
        if (healAmount > 0) {
            heal(healAmount);
        }
        
        // 處理嗆辣效果（回合結束損失生命值）
        int damageAmount = effectProcessor.processFieryEffect(this);
        if (damageAmount > 0) {
            takeDamage(damageAmount);
        }
        
        // 每回合恢復部分酥脆值（如果該卡具有酥脆特性）
        // 注意：這是獨立於滋補效果的機制
        if (maxCrispyValue > 0 && crispyValue < maxCrispyValue) {
            // 恢復1點酥脆值
            increaseCrispyValue(1);
            System.out.println(name + " 每回合自動恢復1點酥脆值");
        }
    }
    
    /**
     * 增加攻擊力
     * @param amount 增加量
     */
    public void increaseAttack(int amount) {
        this.attack += amount;
        System.out.println(name + " 的攻擊力提升了 " + amount + "，現在為: " + attack);
    }
    
    /**
     * 添加糖霜效果
     */
    public void addFrostedEffect() {
        this.hasFrostedEffect = true;
        System.out.println(name + " 獲得了【糖霜】效果！");
    }
    
    // Getters
    public int getAttack() {
        return attack;
    }
    
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public boolean canAttack() {
        return canAttack;
    }
    
    public boolean hasFrostedEffect() {
        return hasFrostedEffect;
    }
    
    public boolean hasSugarRushUsed() {
        return sugarRushUsed;
    }
    
    /**
     * 判斷角色類型
     * @return 角色類型描述
     */
    private String getCharacterType() {
        if (attack > maxHealth) {
            return "進攻型";
        } else if (attack < maxHealth) {
            return "防禦型";
        } else {
            return "平衡型";
        }
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("攻擊力: " + attack);
        System.out.println("生命值: " + currentHealth + "/" + maxHealth);
        System.out.println("類別: " + getCharacterType());
        
        // 顯示特殊效果狀態
        if (hasFrostedEffect) {
            System.out.println("效果: 擁有【糖霜】效果");
        }
        if (cannotAttackNextTurn) {
            System.out.println("效果: 下回合無法攻擊");
        }
        if (maxCrispyValue > 0) {
            System.out.println("效果: 擁有【酥脆】效果，當前護甲值: " + crispyValue + "/" + maxCrispyValue);
        }
    }
    
    /**
     * 設置卡牌擁有者
     * @param owner 玩家
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    
    /**
     * 獲取卡牌擁有者
     * @return 玩家
     */
    public Player getOwner() {
        return owner;
    }
    
    /**
     * 檢查是否具有彈牙效果，並在攻擊後處理
     */
    public boolean checkChewyEffect() {
        if (getDescription().contains("【彈牙】") && attackedOnce && !usedChewyEffect) {
            return effectProcessor.processChewyEffect(this, owner);
        }
        return false;
    }
    
    // 彈牙效果相關的getter和setter
    public boolean hasAttackedOnce() {
        return attackedOnce;
    }
    
    public boolean hasUsedChewyEffect() {
        return usedChewyEffect;
    }
    
    public void setUsedChewyEffect(boolean usedChewyEffect) {
        this.usedChewyEffect = usedChewyEffect;
    }
    
    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    /**
     * 創建角色卡的輔助方法
     * 使用範例：
     * CharacterCard card = CharacterCard.create()
     *     .name("玉米大地守衛者")
     *     .cost(3)
     *     .description("【酥脆(2)】")
     *     .rarity(Rarity.CASUAL_BITES)
     *     .attack(2)
     *     .health(4)
     *     .faction(Faction.EARTH)
     *     .build();
     */
    public static Builder builder() {
        return new Builder(null, 0, null, null, 0);
    }
}