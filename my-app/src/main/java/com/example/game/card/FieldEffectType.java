package com.example.game.card;

/**
 * 場地效果類型枚舉 - 定義F.O.O.D TCG中場地卡的效果類型
 */
public enum FieldEffectType {
    // 場地效果類型
    SUPPORTIVE,    // 輔助型，增強友方能力
    DISRUPTIVE,    // 干擾型，削弱敵方能力
    ECONOMIC,      // 經濟型，提供資源優勢
    STRATEGIC,     // 戰略型，提供戰略選擇
    ENVIRONMENTAL; // 環境型，改變戰場環境
    
    /**
     * 獲取效果類型的文字描述
     */
    public String getDescription() {
        switch (this) {
            case SUPPORTIVE: return "輔助型";
            case DISRUPTIVE: return "干擾型";
            case ECONOMIC: return "經濟型";
            case STRATEGIC: return "戰略型";
            case ENVIRONMENTAL: return "環境型";
            default: return "未知類型";
        }
    }
} 