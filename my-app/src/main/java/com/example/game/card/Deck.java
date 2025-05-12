package com.example.game.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 牌組類 - 管理玩家的卡牌集合
 */
public class Deck {
    private List<Card> cards;
    private static final int DECK_SIZE = 30; // 固定牌組大小為30張
    
    public Deck() {
        this.cards = new ArrayList<>();
    }
    
    /**
     * 初始化牌組，從卡牌圖鑑中選擇卡牌
     */
    public void initialize() {
        // 從卡牌圖鑑中獲取所有可用卡牌
        List<CharacterCard> allCharacters = CardLibrary.getAllCharacters();
        List<FieldCard> allFields = CardLibrary.getAllFieldCards();
        
        if (allCharacters.isEmpty() && allFields.isEmpty()) {
            System.out.println("卡牌圖鑑尚未初始化，使用隨機生成的卡牌");
            initializeRandom();
            return;
        }
        
        // 按照7:3的比例分配角色卡和場地卡
        int characterCount = (int)(DECK_SIZE * 0.7); // 70%為角色卡
        int fieldCount = DECK_SIZE - characterCount; // 30%為場地卡
        
        // 從卡牌圖鑑中選擇角色卡
        for (int i = 0; i < characterCount; i++) {
            if (!allCharacters.isEmpty()) {
                cards.add(copyCard(allCharacters.get(i % allCharacters.size())));
            } else {
                // 如果沒有足夠的角色卡，則生成隨機角色卡
                cards.add(createRandomCharacterCard(i));
            }
        }
        
        // 從卡牌圖鑑中選擇場地卡
        for (int i = 0; i < fieldCount; i++) {
            if (!allFields.isEmpty()) {
                cards.add(copyCard(allFields.get(i % allFields.size())));
            } else {
                // 如果沒有足夠的場地卡，則生成隨機場地卡
                cards.add(createRandomFieldCard(i));
            }
        }
        
        // 確保牌組大小為30張
        if (cards.size() > DECK_SIZE) {
            cards = cards.subList(0, DECK_SIZE);
        } else if (cards.size() < DECK_SIZE) {
            // 不足30張時補充隨機卡牌
            while (cards.size() < DECK_SIZE) {
                if (Math.random() < 0.7) {
                    cards.add(createRandomCharacterCard(cards.size()));
                } else {
                    cards.add(createRandomFieldCard(cards.size()));
                }
            }
        }
        
        System.out.println("牌組初始化完成，共有 " + cards.size() + " 張卡牌");
    }
    
    /**
     * 創建一個隨機角色卡
     */
    private CharacterCard createRandomCharacterCard(int index) {
        Random random = new Random();
        int cost = random.nextInt(10) + 1; // 1-10費
        int attack = cost + random.nextInt(3) - 1; // 費用±1的攻擊力
        int defense = random.nextInt(3); // 0-2的防禦力
        int health = cost + random.nextInt(3); // 費用+0到2的生命值
        boolean isOffensive = random.nextBoolean(); // 隨機決定是否為進攻型
        
        Rarity rarity;
        double rarityRoll = random.nextDouble();
        if (rarityRoll < 0.6) {
            rarity = Rarity.COMMON;
        } else if (rarityRoll < 0.85) {
            rarity = Rarity.RARE;
        } else if (rarityRoll < 0.97) {
            rarity = Rarity.EPIC;
        } else {
            rarity = Rarity.LEGENDARY;
        }
        
        return new CharacterCard(
                "食物角色 #" + (index+1), 
                cost, 
                "一個隨機生成的食物角色", 
                rarity, 
                attack, 
                defense,
                health,
                isOffensive);
    }
    
    /**
     * 創建一個隨機場地卡
     */
    private FieldCard createRandomFieldCard(int index) {
        Random random = new Random();
        int cost = random.nextInt(8) + 1; // 1-8費
        
        Rarity rarity;
        double rarityRoll = random.nextDouble();
        if (rarityRoll < 0.6) {
            rarity = Rarity.COMMON;
        } else if (rarityRoll < 0.85) {
            rarity = Rarity.RARE;
        } else {
            rarity = Rarity.EPIC;
        }
        
        // 隨機決定場地卡類型
        FieldCard.FieldType[] fieldTypes = FieldCard.FieldType.values();
        FieldCard.FieldType fieldType = fieldTypes[random.nextInt(fieldTypes.length)];
        
        // 根據場地卡類型創建不同的場地卡
        switch (fieldType) {
            case COOKING_TECHNIQUE:
                // 創建烹飪技術類場地卡
                FieldEffectType[] techniqueEffects = {
                    FieldEffectType.BOOST_ATTACK,
                    FieldEffectType.BOOST_DEFENSE,
                    FieldEffectType.HEAL,
                    FieldEffectType.DAMAGE,
                    FieldEffectType.DRAW,
                    FieldEffectType.SPECIAL
                };
                FieldEffectType techniqueEffect = techniqueEffects[random.nextInt(techniqueEffects.length)];
                
                int effectValue = cost + random.nextInt(3); // 效果值基於費用
                int duration = (techniqueEffect == FieldEffectType.BOOST_ATTACK || 
                               techniqueEffect == FieldEffectType.BOOST_DEFENSE) ? 
                               random.nextInt(3) + 1 : 0; // 僅增益效果有持續時間
                
                return FieldCard.createTechniqueField(
                        "烹飪技術 #" + (index+1), 
                        cost, 
                        "一個隨機生成的烹飪技術場地", 
                        rarity,
                        techniqueEffect,
                        effectValue,
                        duration);
                
            case COOKING_TOOL:
                // 創建料理工具類場地卡
                FieldEffectType toolEffect;
                // 70%概率使用基本工具效果，30%概率使用擴展效果
                if (random.nextDouble() < 0.7) {
                    FieldEffectType[] basicToolEffects = {
                        FieldEffectType.OFFENSIVE,
                        FieldEffectType.DEFENSIVE,
                        FieldEffectType.UTILITY
                    };
                    toolEffect = basicToolEffects[random.nextInt(basicToolEffects.length)];
                } else {
                    // 使用擴展效果類型
                    FieldEffectType[] extendedEffects = {
                        FieldEffectType.SUPPORTIVE,
                        FieldEffectType.DISRUPTIVE,
                        FieldEffectType.ECONOMIC,
                        FieldEffectType.STRATEGIC,
                        FieldEffectType.ENVIRONMENTAL
                    };
                    toolEffect = extendedEffects[random.nextInt(extendedEffects.length)];
                }
                
                int durability = cost + random.nextInt(2); // 耐久度基於費用
                int toolEffectValue = cost + random.nextInt(2); // 效果值基於費用
                
                return FieldCard.createToolField(
                        "料理工具 #" + (index+1), 
                        cost, 
                        "一個隨機生成的料理工具場地", 
                        rarity,
                        toolEffect,
                        durability,
                        toolEffectValue);
                
            case ENVIRONMENT:
            default:
                // 創建環境類場地卡
                int envEffectValue = cost + random.nextInt(3); // 效果值基於費用
                
                return FieldCard.createEnvironmentField(
                        "料理環境 #" + (index+1), 
                        cost, 
                        "一個隨機生成的料理環境場地", 
                        rarity,
                        envEffectValue);
        }
    }
    
    /**
     * 初始化隨機牌組，用於卡牌圖鑑尚未初始化的情況
     */
    private void initializeRandom() {
        // 生成隨機牌組，確保正好有30張卡牌
        Random random = new Random();
        
        // 按照7:2:1的比例分配角色卡、場地卡和任務卡
        int characterCount = (int)(DECK_SIZE * 0.7); // 70%為角色卡
        int fieldCount = (int)(DECK_SIZE * 0.2);     // 20%為場地卡
        int questCount = DECK_SIZE - characterCount - fieldCount; // 10%為任務卡
        
        // 生成角色卡
        for (int i = 0; i < characterCount; i++) {
            cards.add(createRandomCharacterCard(i));
        }
        
        // 生成場地卡
        for (int i = 0; i < fieldCount; i++) {
            cards.add(createRandomFieldCard(i));
        }
        
        // 生成任務卡 (未實現，可以在將來添加)
        
        System.out.println("牌組隨機初始化完成，共有 " + cards.size() + " 張卡牌");
    }
    
    /**
     * 複製卡牌，確保每張卡牌是獨立的實例
     */
    private Card copyCard(Card original) {
        if (original instanceof Minion) {
            Minion originalMinion = (Minion) original;
            Minion copy = new Minion(
                    originalMinion.getName(),
                    originalMinion.getTokenCost(),
                    originalMinion.getDescription(),
                    originalMinion.getRarity(),
                    originalMinion.getAttack(),
                    originalMinion.getHealth()
            );
            
            copy.setTaunt(originalMinion.hasTaunt());
            copy.setDivineShield(originalMinion.hasDivineShield());
            copy.setCharge(originalMinion.hasCharge());
            
            return copy;
        } else if (original instanceof SpellCard) {
            SpellCard originalSpell = (SpellCard) original;
            return new SpellCard(
                    originalSpell.getName(),
                    originalSpell.getTokenCost(),
                    originalSpell.getDescription(),
                    originalSpell.getRarity(),
                    originalSpell.getSpellType()
            );
        } else if (original instanceof CharacterCard) {
            // 支持新的CharacterCard類型
            CharacterCard originalChar = (CharacterCard) original;
            return new CharacterCard(
                    originalChar.getName(),
                    originalChar.getTokenCost(),
                    originalChar.getDescription(),
                    originalChar.getRarity(),
                    originalChar.getAttack(),
                    originalChar.getDefense(),
                    originalChar.getMaxHealth(),
                    originalChar.isOffensive()
            );
        } else if (original instanceof FieldCard) {
            // 支持新的FieldCard類型
            FieldCard originalField = (FieldCard) original;
            FieldCard copy;
            
            switch (originalField.getFieldType()) {
                case COOKING_TECHNIQUE:
                    copy = FieldCard.createTechniqueField(
                            originalField.getName(),
                            originalField.getTokenCost(),
                            originalField.getDescription(),
                            originalField.getRarity(),
                            originalField.getEffectType(),
                            originalField.getEffectValue(),
                            originalField.getDuration()
                    );
                    break;
                case COOKING_TOOL:
                    copy = FieldCard.createToolField(
                            originalField.getName(),
                            originalField.getTokenCost(),
                            originalField.getDescription(),
                            originalField.getRarity(),
                            originalField.getEffectType(),
                            originalField.getDurability(),
                            originalField.getEffectValue()
                    );
                    break;
                case ENVIRONMENT:
                default:
                    copy = FieldCard.createEnvironmentField(
                            originalField.getName(),
                            originalField.getTokenCost(),
                            originalField.getDescription(),
                            originalField.getRarity(),
                            originalField.getEffectValue()
                    );
                    break;
            }
            
            return copy;
        }
        
        return null;
    }
    
    /**
     * 洗牌
     */
    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("牌組已洗牌");
    }
    
    /**
     * 從牌組頂部抽一張牌
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        
        return cards.remove(0);
    }
    
    /**
     * 檢查牌組是否為空
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    /**
     * 獲取牌組大小
     */
    public int size() {
        return cards.size();
    }
    
    /**
     * 添加卡牌到牌組
     */
    public boolean addCard(Card card) {
        if (cards.size() >= DECK_SIZE) {
            return false;
        }
        
        cards.add(card);
        return true;
    }
} 