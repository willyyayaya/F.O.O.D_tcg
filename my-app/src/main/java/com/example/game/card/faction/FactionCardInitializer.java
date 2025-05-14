package com.example.game.card.faction;

import java.util.Map;
import java.util.List;
import com.example.game.card.Card;
import com.example.game.card.SpellCard;
import com.example.game.card.CharacterCard;
import com.example.game.card.FieldCard;
import com.example.game.card.CastleCard;

/**
 * 陣營卡牌初始化介面 - 每個陣營的卡牌初始化實現類都需實現此介面
 */
public interface FactionCardInitializer {
    
    /**
     * 初始化該陣營的所有卡牌
     * 
     * @param allCards 全局卡牌集合
     * @param allCharacters 角色卡集合
     * @param allSpells 法術卡集合
     * @param allFieldCards 場地卡集合
     * @param allCastles 城堡卡集合
     */
    void initializeCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters,
        List<SpellCard> allSpells,
        List<FieldCard> allFieldCards,
        List<CastleCard> allCastles
    );
    
    /**
     * 獲取陣營名稱
     * 
     * @return 陣營的本地化名稱
     */
    String getFactionName();
} 