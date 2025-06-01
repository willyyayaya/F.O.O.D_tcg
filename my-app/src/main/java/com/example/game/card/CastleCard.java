package com.example.game.card;

import com.example.game.player.Player;

/**
 * 城堡卡 - 提供持久效果，但隱藏在特定區域，當區域被摧毀時效果消失
 */
public class CastleCard extends Card {
    private CastleCardZone zone;         // 城堡所在區域
    private CastleEffect effect;     // 城堡效果
    private boolean isActive;        // 城堡效果是否啟用
    private boolean isInitialized;   // 是否已初始化
    private int currentHealth;       // 當前生命值
    private int maxHealth;           // 最大生命值
    
    /**
     * Builder 類別
     */
    public static class Builder {
        private String name;
        private int cost;
        private String description;
        private Rarity rarity;
        private Faction faction = Faction.NEUTRAL;
        private int points;
        private int health;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder cost(int cost) {
            this.cost = cost;
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
        
        public Builder faction(Faction faction) {
            this.faction = faction;
            return this;
        }
        
        public Builder points(int points) {
            this.points = points;
            return this;
        }
        
        public Builder health(int health) {
            this.health = health;
            return this;
        }
        
        public CastleCard build() {
            if (name == null || description == null || rarity == null) {
                throw new IllegalStateException("Required fields are missing");
            }
            
            CastleCard card = new CastleCard(name, cost, description, rarity, faction);
            card.currentHealth = health;
            card.maxHealth = health;
            if (points > 0) {
                card.setPoints(points);
            }
            return card;
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * 創建城堡卡
     */
    public CastleCard(String name, int cost, String description, Rarity rarity, Faction faction) {
        super(name, cost, description, rarity, CardType.CASTLE, faction, rarity.getMinPoints());
        this.effect = null;
        this.isActive = false;           // 初始未啟用
        this.isInitialized = false;      // 初始未初始化
        this.zone = CastleCardZone.NONE; // 初始未分配區域
        this.currentHealth = 30; // 預設生命值
        this.maxHealth = 30;
    }
    
    /**
     * 遊戲開始時初始化城堡卡
     */
    public void initialize() {
        if (!isInitialized) {
            isActive = true;
            isInitialized = true;
            System.out.println(name + " 已初始化，效果已啟用");
        }
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
        if (isActive && isInitialized) {
            System.out.println("城堡效果啟用: " + description);
            if (effect != null) {
                effect.applyEffect(player);
            }
        }
    }
    
    /**
     * 當區域被摧毀時，檢查並處理城堡卡
     */
    public boolean checkZoneDestroyed(CastleCardZone destroyedZone) {
        if (this.zone == destroyedZone && isActive) {
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
        System.out.println("初始化: " + (isInitialized ? "是" : "否"));
        System.out.println("效果: " + (effect != null ? effect.getEffectDescription() : "無效果"));
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
    
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * 回復城牆生命值
     * @param healAmount 回復量
     * @return 實際回復的生命值
     */
    public int heal(int healAmount) {
        if (healAmount <= 0) {
            return 0;
        }

        int currentHealth = getCurrentHealth();
        int maxHealth = getMaxHealth();
        
        // 如果已經滿血，則不回復
        if (currentHealth >= maxHealth) {
            System.out.println(name + " 已經滿血，無法回復！");
            return 0;
        }

        // 計算實際回復量（不超過最大生命值）
        int actualHeal = Math.min(healAmount, maxHealth - currentHealth);
        setCurrentHealth(currentHealth + actualHeal);
        
        System.out.println(name + " 回復了 " + actualHeal + " 點生命值！");
        System.out.println("當前生命值: " + getCurrentHealth() + "/" + maxHealth);
        
        return actualHeal;
    }

    /**
     * 獲取當前生命值
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     * 獲取最大生命值
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * 設置當前生命值
     */
    public void setCurrentHealth(int health) {
        this.currentHealth = Math.max(0, Math.min(health, maxHealth));
    }

    /**
     * 設置最大生命值
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = Math.max(1, maxHealth);
        // 確保當前生命值不超過新的最大生命值
        this.currentHealth = Math.min(this.currentHealth, this.maxHealth);
    }

    /**
     * 設置卡牌點數
     */
    public void setPoints(int points) {
        if (points < getRarity().getMinPoints() || points > getRarity().getMaxPoints()) {
            throw new IllegalArgumentException(
                String.format("Points must be between %d and %d for %s rarity",
                    getRarity().getMinPoints(),
                    getRarity().getMaxPoints(),
                    getRarity().name())
            );
        }
        this.points = points;
    }
} 