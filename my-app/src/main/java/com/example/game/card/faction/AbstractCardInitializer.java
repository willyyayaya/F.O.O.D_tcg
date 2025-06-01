package com.example.game.card.faction;

import java.util.List;
import java.util.Map;

import com.example.game.card.Card;
import com.example.game.card.CastleCard;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.FieldCard;
import com.example.game.card.Rarity;
import com.example.game.card.SpellCard;
import com.example.game.card.SpellType;

/**
 * 卡牌初始化器的抽象基類
 * 提供通用的卡牌創建和初始化邏輯
 */
public abstract class AbstractCardInitializer implements FactionCardInitializer {
    
    /**
     * 創建角色卡的通用方法
     * 使用 Builder 模式創建角色卡
     * 
     * @param name 卡牌名稱
     * @param cost 費用
     * @param description 描述
     * @param rarity 稀有度
     * @param attack 攻擊力
     * @param health 生命值
     * @param faction 陣營
     * @param points 點數
     * @return 創建的角色卡
     */
    protected CharacterCard createCharacterCard(
        String name, int cost, String description, Rarity rarity,
        int attack, int health, Faction faction, int points
    ) {
        return CharacterCard.builder()
            .name(name)
            .cost(cost)
            .description(description)
            .rarity(rarity)
            .attack(attack)
            .health(health)
            .faction(faction)
            .points(points)
            .build();
    }

    /**
     * 創建法術卡的通用方法
     * 
     * @param name 卡牌名稱
     * @param cost 費用
     * @param description 描述
     * @param rarity 稀有度
     * @param spellType 法術類型
     * @param faction 陣營
     * @return 創建的法術卡
     */
    protected SpellCard createSpellCard(
        String name, int cost, String description, Rarity rarity,
        SpellType spellType, Faction faction
    ) {
        return SpellCard.builder()
            .name(name)
            .cost(cost)
            .description(description)
            .rarity(rarity)
            .spellType(spellType)
            .faction(faction)
            .build();
    }

    /**
     * 創建場地卡的通用方法
     * 
     * @param name 卡牌名稱
     * @param cost 費用
     * @param description 描述
     * @param rarity 稀有度
     * @param faction 陣營
     * @return 創建的場地卡
     */
    protected FieldCard createFieldCard(
        String name, int cost, String description, Rarity rarity,
        Faction faction
    ) {
        return FieldCard.builder()
            .name(name)
            .cost(cost)
            .description(description)
            .rarity(rarity)
            .faction(faction)
            .build();
    }

    /**
     * 創建城堡卡的通用方法
     * 
     * @param name 卡牌名稱
     * @param cost 費用
     * @param description 描述
     * @param rarity 稀有度
     * @param faction 陣營
     * @param health 生命值
     * @return 創建的城堡卡
     */
    protected CastleCard createCastleCard(
        String name, int cost, String description, Rarity rarity,
        Faction faction, int health
    ) {
        return CastleCard.builder()
            .name(name)
            .cost(cost)
            .description(description)
            .rarity(rarity)
            .faction(faction)
            .health(health)
            .build();
    }

    /**
     * 將卡牌添加到集合中的通用方法
     * 
     * @param card 要添加的卡牌
     * @param allCards 所有卡牌的映射
     * @param specificList 特定類型卡牌的列表
     */
    protected <T extends Card> void addToCollection(
        T card, Map<String, Card> allCards, List<T> specificList
    ) {
        allCards.put(card.getName(), card);
        specificList.add(card);
    }

    @Override
    public void initializeCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters,
        List<SpellCard> allSpells,
        List<FieldCard> allFieldCards,
        List<CastleCard> allCastles
    ) {
        initializeCharacterCards(allCards, allCharacters);
        initializeSpellCards(allCards, allSpells);
        initializeFieldCards(allCards, allFieldCards);
        initializeCastleCards(allCards, allCastles);
    }

    /**
     * 初始化角色卡
     * 子類必須實現此方法
     */
    protected abstract void initializeCharacterCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters
    );

    /**
     * 初始化法術卡
     * 子類必須實現此方法
     */
    protected abstract void initializeSpellCards(
        Map<String, Card> allCards,
        List<SpellCard> allSpells
    );

    /**
     * 初始化場地卡
     * 子類必須實現此方法
     */
    protected abstract void initializeFieldCards(
        Map<String, Card> allCards,
        List<FieldCard> allFieldCards
    );

    /**
     * 初始化城堡卡
     * 子類必須實現此方法
     */
    protected abstract void initializeCastleCards(
        Map<String, Card> allCards,
        List<CastleCard> allCastles
    );

    /**
     * 獲取陣營名稱
     * 子類必須實現此方法
     */
    @Override
    public abstract String getFactionName();
} 