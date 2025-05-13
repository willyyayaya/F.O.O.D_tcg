package com.example.game.card;

/**
 * 卡牌陣營枚舉 - 定義F.O.O.D TCG中的卡牌陣營
 */
public enum Faction {
    SPICY_KINGDOM,   // 火辣王國
    HEALTHY_OASIS,   // 健康綠洲
    FAST_FOOD_GUILD, // 速食工會
    DESSERT_UNION,   // 甜點聯盟
    NEUTRAL;         // 中立

    /**
     * 獲取陣營的中文名稱
     */
    public String getLocalizedName() {
        switch (this) {
            case SPICY_KINGDOM:
                return "火辣王國";
            case HEALTHY_OASIS:
                return "健康綠洲";
            case FAST_FOOD_GUILD:
                return "速食工會";
            case DESSERT_UNION:
                return "甜點聯盟";
            case NEUTRAL:
                return "中立";
            default:
                return "未知陣營";
        }
    }

    /**
     * 獲取陣營的英文名稱
     */
    public String getEnglishName() {
        switch (this) {
            case SPICY_KINGDOM:
                return "Spicy Kingdom";
            case HEALTHY_OASIS:
                return "Healthy Oasis";
            case FAST_FOOD_GUILD:
                return "Fast Food Guild";
            case DESSERT_UNION:
                return "Dessert Union";
            case NEUTRAL:
                return "Neutral";
            default:
                return "Unknown Faction";
        }
    }

    /**
     * 獲取陣營的描述
     */
    public String getDescription() {
        switch (this) {
            case SPICY_KINGDOM:
                return "以辛辣食物為主題的陣營，擅長攻擊和爆發傷害。";
            case HEALTHY_OASIS:
                return "以健康食物為主題的陣營，擅長恢復和持續效果。";
            case FAST_FOOD_GUILD:
                return "以快餐食物為主題的陣營，擅長快速出牌和連鎖效果。";
            case DESSERT_UNION:
                return "以甜點為主題的陣營，擅長控制和資源生成。";
            case NEUTRAL:
                return "不屬於特定陣營的卡牌，擁有多樣的效果和高適應性。";
            default:
                return "未知陣營。";
        }
    }
} 