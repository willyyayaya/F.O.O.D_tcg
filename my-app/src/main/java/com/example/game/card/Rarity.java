package com.example.game.card;

/**
 * 卡牌稀有度枚舉
 */
public enum Rarity {
    COMMON(0.5, "#C0C0C0", 1),    // 普通 - 50% 機率
    RARE(0.3, "#0070DD", 2),      // 稀有 - 30% 機率
    EPIC(0.15, "#A335EE", 3),     // 史詩 - 15% 機率
    LEGENDARY(0.05, "#FF8000", 4); // 傳說 - 5% 機率

    private final double probability; // 出現機率
    private final String color;      // 稀有度顏色
    private final int points;        // 稀有度點數

    Rarity(double probability, String color, int points) {
        this.probability = probability;
        this.color = color;
        this.points = points;
    }

    public double getProbability() {
        return probability;
    }

    public String getColor() {
        return color;
    }

    public int getPoints() {
        return points;
    }
} 