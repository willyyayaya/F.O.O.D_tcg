package com.example.game.card;

/**
 * 場地效果類型枚舉 - 定義F.O.O.D TCG中場地卡的效果類型
 * 此枚舉整合了原有的工具類型和技術類型枚舉
 */
public enum FieldEffectType {
    // 原工具類型
    OFFENSIVE,     // 攻擊型，用於造成傷害
    DEFENSIVE,     // 防禦型，用於加強防禦
    UTILITY,       // 效用型，有各種特殊效果
    
    // 原技術類型
    BOOST_ATTACK,  // 提升攻擊力
    BOOST_DEFENSE, // 提升防禦力
    HEAL,          // 治療效果
    DAMAGE,        // 傷害效果
    DRAW,          // 抽牌效果
    SPECIAL,       // 特殊效果
    SUMMON,        // 召喚效果
    
    // 新增的場地效果類型
    SUPPORTIVE,    // 輔助型，增強友方能力
    DISRUPTIVE,    // 干擾型，削弱敵方能力
    ECONOMIC,      // 經濟型，提供資源優勢
    STRATEGIC,     // 戰略型，提供戰略選擇
    ENVIRONMENTAL; // 環境型，改變戰場環境
    
    /**
     * 檢查是否為技術類型效果
     */
    public boolean isTechniqueEffect() {
        return this == BOOST_ATTACK || this == BOOST_DEFENSE || 
               this == HEAL || this == DAMAGE || this == DRAW || this == SPECIAL || this == SUMMON;
    }
    
    /**
     * 獲取效果類型的文字描述
     */
    public String getDescription() {
        switch (this) {
            // 工具類型描述
            case OFFENSIVE: return "攻擊型";
            case DEFENSIVE: return "防禦型";
            case UTILITY: return "效用型";
            
            // 技術類型描述
            case BOOST_ATTACK: return "提升攻擊力";
            case BOOST_DEFENSE: return "提升防禦力";
            case HEAL: return "治療";
            case DAMAGE: return "傷害";
            case DRAW: return "抽牌";
            case SPECIAL: return "特殊";
            case SUMMON: return "召喚";
            
            // 新類型描述
            case SUPPORTIVE: return "輔助型";
            case DISRUPTIVE: return "干擾型";
            case ECONOMIC: return "經濟型";
            case STRATEGIC: return "戰略型";
            case ENVIRONMENTAL: return "環境型";
            default: return "未知類型";
        }
    }
} 