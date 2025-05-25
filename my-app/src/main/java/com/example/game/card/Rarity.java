package com.example.game.card;

/**
 * 卡牌稀有度枚舉 - 反映美味世界中不同層級的美食文化
 */
public enum Rarity {
    CASUAL_BITES("輕鬆小食", 0.5, "#C0C0C0", 1, 2, 4, 
        "日常可見的基礎食材，是美味世界中最常見的存在。這些食材雖然普通，但卻是構成美食的基石。",
        "基礎食材、家常料理、街邊小吃"),    // 輕鬆小食 - 50% 機率

    GOURMET_DELIGHT("風味饗宴", 0.3, "#0070DD", 2, 3, 3,
        "經過精心烹調的特色料理，展現出廚師們的獨特創意。這些美食往往能帶來意想不到的驚喜。",
        "特色料理、創意美食、地方特產"),  // 風味饗宴 - 30% 機率

    CULINARY_HERITAGE("美食傳承", 0.15, "#A335EE", 3, 4, 2,
        "代代相傳的珍貴食譜，蘊含著深厚的文化底蘊。這些美食往往與某個勢力的歷史緊密相連。",
        "傳統美食、家族秘方、文化瑰寶"), // 美食傳承 - 15% 機率

    ULTIMATE_TASTE("極致美味", 0.05, "#FF8000", 4, 5, 1,
        "傳說中的究極料理，據說蘊含著改變世界的力量。這些美食往往與究極佐料有著神秘的聯繫。",
        "傳說料理、究極美食、世界奇蹟");   // 極致美味 - 5% 機率

    private final String chineseName;    // 中文名稱
    private final double probability;    // 出現機率
    private final String color;          // 稀有度顏色
    private final int minPoints;         // 最小點數
    private final int maxPoints;         // 最大點數
    private final int maxCopies;         // 每副牌組最大同名卡數量
    private final String description;    // 稀有度描述
    private final String keywords;       // 關鍵詞

    Rarity(String chineseName, double probability, String color, int minPoints, int maxPoints, int maxCopies,
           String description, String keywords) {
        this.chineseName = chineseName;
        this.probability = probability;
        this.color = color;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
        this.maxCopies = maxCopies;
        this.description = description;
        this.keywords = keywords;
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

    public String getDescription() {
        return description;
    }

    public String getKeywords() {
        return keywords;
    }

    @Override
    public String toString() {
        return chineseName;
    }

    /**
     * 獲取稀有度的完整描述
     * @return 包含名稱、描述和關鍵詞的完整描述
     */
    public String getFullDescription() {
        return String.format("%s\n%s\n關鍵詞：%s", chineseName, description, keywords);
    }
} 