package com.example.game.card;

import com.example.game.player.Player;

/**
 * 場地卡 - 代表F.O.O.D TCG中的場地效果
 */
public class FieldCard extends Card {
    private int durability;
    private boolean isEnvironment;
    private int effectValue;

    private FieldCard(String name, int cost, String description, Rarity rarity, int durability, Faction faction, boolean isEnvironment) {
        super(name, cost, description, rarity, CardType.FIELD, faction, rarity.getMinPoints());
        this.durability = durability;
        this.isEnvironment = isEnvironment;
        this.effectValue = durability;
    }

    private FieldCard(String name, int cost, String description, Rarity rarity, int durability, Faction faction, boolean isEnvironment, int points) {
        super(name, cost, description, rarity, CardType.FIELD, faction, points);
        this.durability = durability;
        this.isEnvironment = isEnvironment;
        this.effectValue = durability;
    }

    public static FieldCard createEnvironmentField(String name, int cost, String description, Rarity rarity, int durability, Faction faction) {
        return new FieldCard(name, cost, description, rarity, durability, faction, true);
    }

    public static FieldCard createEnvironmentField(String name, int cost, String description, Rarity rarity, int durability, Faction faction, int points) {
        return new FieldCard(name, cost, description, rarity, durability, faction, true, points);
    }

    public int getDurability() {
        return durability;
    }

    public boolean isEnvironment() {
        return isEnvironment;
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
        System.out.println("耐久度: " + durability);
        System.out.println("環境類型: " + (isEnvironment ? "環境" : "非環境"));
        System.out.println("效果值: " + effectValue);
    }

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
        private int durability;
        private boolean isEnvironment = false;
        
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
        
        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }
        
        public Builder isEnvironment(boolean isEnvironment) {
            this.isEnvironment = isEnvironment;
            return this;
        }
        
        public FieldCard build() {
            if (name == null || description == null || rarity == null) {
                throw new IllegalStateException("Required fields are missing");
            }
            
            FieldCard card = new FieldCard(name, cost, description, rarity, durability, faction, isEnvironment);
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