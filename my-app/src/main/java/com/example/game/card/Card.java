package com.example.game.card;

import com.example.game.player.Player;

/**
 * 卡牌基類 - 所有F.O.O.D TCG卡牌的父類
 */
public abstract class Card {
    protected String name;
    protected int tokenCost;     // 變更為Token消耗而非魔力消耗
    protected String description;
    protected Rarity rarity;
    protected CardType type;     // 添加卡牌類型
    protected Faction faction;   // 添加陣營屬性
    
    public Card(String name, int tokenCost, String description, Rarity rarity, CardType type) {
        this(name, tokenCost, description, rarity, type, Faction.NEUTRAL); // 預設為中立陣營
    }
    
    public Card(String name, int tokenCost, String description, Rarity rarity, CardType type, Faction faction) {
        this.name = name;
        this.tokenCost = tokenCost;
        this.description = description;
        this.rarity = rarity;
        this.type = type;
        this.faction = faction;
    }
    
    /**
     * 打出卡牌時的效果
     */
    public abstract void play(Player player);
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getTokenCost() {
        return tokenCost;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Rarity getRarity() {
        return rarity;
    }
    
    public CardType getType() {
        return type;
    }
    
    public Faction getFaction() {
        return faction;
    }
    
    /**
     * 顯示卡牌詳細資訊
     */
    public void displayCardDetails() {
        System.out.println("======= 卡牌資訊 =======");
        System.out.println("名稱: " + name);
        System.out.println("類型: " + getCardTypeText(type));
        System.out.println("陣營: " + getFactionText());
        System.out.println("費用: " + tokenCost + " 個Token");
        System.out.println("稀有度: " + getRarityText(rarity));
        System.out.println("描述: " + description);
        displaySpecificDetails();
        System.out.println("========================");
    }
    
    /**
     * 顯示特定類型卡牌的詳細資訊，由子類實現
     */
    protected void displaySpecificDetails() {
        // 基礎實現為空，由子類覆寫
    }
    
    /**
     * 獲取稀有度的中文文本
     */
    private String getRarityText(Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return "普通";
            case RARE:
                return "稀有";
            case EPIC:
                return "史詩";
            case LEGENDARY:
                return "傳說";
            default:
                return "未知";
        }
    }
    
    /**
     * 獲取卡牌類型的中文文本
     */
    private String getCardTypeText(CardType type) {
        switch (type) {
            case CHARACTER:
                return "角色";
            case FIELD:
                return "場地";
            case QUEST:
                return "任務";
            default:
                return "未知";
        }
    }
    
    /**
     * 獲取陣營的文本描述
     */
    private String getFactionText() {
        return faction.getLocalizedName() + " (" + faction.getEnglishName() + ")";
    }
} 