package com.example.game.card;

/**
 * 卡牌稀有度枚舉
 */
public enum Rarity {
    CASUAL_BITES("輕鬆小食", 0.5, "#C0C0C0", 1, 2, 4),    // 輕鬆小食 - 50% 機率
    GOURMET_DELIGHT("風味饗宴", 0.3, "#0070DD", 2, 3, 3),  // 風味饗宴 - 30% 機率
    CULINARY_HERITAGE("美食傳承", 0.15, "#A335EE", 3, 4, 2), // 美食傳承 - 15% 機率
    ULTIMATE_TASTE("極致美味", 0.05, "#FF8000", 4, 5, 1);   // 極致美味 - 5% 機率

    private final String chineseName;    // 中文名稱
    private final double probability;    // 出現機率
    private final String color;          // 稀有度顏色
    private final int minPoints;         // 最小點數
    private final int maxPoints;         // 最大點數
    private final int maxCopies;         // 每副牌組最大同名卡數量

    Rarity(String chineseName, double probability, String color, int minPoints, int maxPoints, int maxCopies) {
        this.chineseName = chineseName;
        this.probability = probability;
        this.color = color;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
        this.maxCopies = maxCopies;
    }

    public String getChineseName() {
        return chineseName;
    }

    public double getProbability() {
        return probability;
    }

    public String getColor() {
        return color;
    }

    public int getMinPoints() {
        return minPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public int getMaxCopies() {
        return maxCopies;
    }

    @Override
    public String toString() {
        return chineseName;
    }
} 