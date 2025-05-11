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
    private static final int MAX_DECK_SIZE = 30;
    
    public Deck() {
        this.cards = new ArrayList<>();
    }
    
    /**
     * 初始化牌組，從卡牌圖鑑中選擇卡牌
     */
    public void initialize() {
        // 從卡牌圖鑑中獲取所有可用卡牌
        List<CharacterCard> allCharacters = CardLibrary.getAllCharacters();
        List<TechniqueCard> allTechniques = CardLibrary.getAllTechniques();
        
        if (allCharacters.isEmpty() && allTechniques.isEmpty()) {
            System.out.println("卡牌圖鑑尚未初始化，使用隨機生成的卡牌");
            initializeRandom();
            return;
        }
        
        // 從卡牌圖鑑中選擇20張角色卡
        int characterCount = Math.min(20, allCharacters.size());
        for (int i = 0; i < characterCount; i++) {
            cards.add(copyCard(allCharacters.get(i % allCharacters.size())));
        }
        
        // 從卡牌圖鑑中選擇10張烹飪技術卡
        int techniqueCount = Math.min(10, allTechniques.size());
        for (int i = 0; i < techniqueCount; i++) {
            cards.add(copyCard(allTechniques.get(i % allTechniques.size())));
        }
        
        System.out.println("牌組初始化完成，共有 " + cards.size() + " 張卡牌");
    }
    
    /**
     * 初始化隨機牌組，用於卡牌圖鑑尚未初始化的情況
     */
    private void initializeRandom() {
        // 在這裡，我們生成一些隨機卡牌
        // 實際遊戲中，牌組應該是預設的或由玩家構建的
        
        Random random = new Random();
        
        // 生成角色卡
        for (int i = 0; i < 20; i++) {
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
            
            CharacterCard character = new CharacterCard(
                    "食物角色 #" + (i+1), 
                    cost, 
                    "一個隨機生成的食物角色", 
                    rarity, 
                    attack, 
                    defense,
                    health,
                    isOffensive);
            
            cards.add(character);
        }
        
        // 生成烹飪技術卡
        for (int i = 0; i < 10; i++) {
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
            
            // 隨機選擇技術類型
            TechniqueType[] types = TechniqueType.values();
            TechniqueType techniqueType = types[random.nextInt(types.length)];
            
            int effectValue = cost + random.nextInt(3); // 效果值基於費用
            int duration = (techniqueType == TechniqueType.BOOST_ATTACK || 
                           techniqueType == TechniqueType.BOOST_DEFENSE) ? 
                           random.nextInt(3) + 1 : 0; // 僅增益效果有持續時間
            
            TechniqueCard technique = new TechniqueCard(
                    "烹飪技術 #" + (i+1), 
                    cost, 
                    "一個隨機生成的烹飪技術", 
                    rarity,
                    techniqueType,
                    effectValue,
                    duration);
            
            cards.add(technique);
        }
        
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
        } else if (original instanceof TechniqueCard) {
            // 支持新的TechniqueCard類型
            TechniqueCard originalTech = (TechniqueCard) original;
            return new TechniqueCard(
                    originalTech.getName(),
                    originalTech.getTokenCost(),
                    originalTech.getDescription(),
                    originalTech.getRarity(),
                    originalTech.getTechniqueType(),
                    originalTech.getEffectValue(),
                    originalTech.getDuration()
            );
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
        if (cards.size() >= MAX_DECK_SIZE) {
            return false;
        }
        
        cards.add(card);
        return true;
    }
} 