package com.example.game.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
     * 初始化特定陣營的牌組
     * @param faction 卡牌陣營
     */
    public void initialize(Faction faction) {
        System.out.println("初始化 " + faction.getLocalizedName() + " 陣營牌組...");
        
        // 從卡牌圖鑑中獲取所有可用卡牌
        List<CharacterCard> allCharacters = CardLibrary.getAllCharacters();
        List<FieldCard> allFields = CardLibrary.getAllFieldCards();
        
        if (allCharacters.isEmpty() && allFields.isEmpty()) {
            System.out.println("卡牌圖鑑尚未初始化，使用隨機生成的陣營卡牌");
            initializeRandomWithFaction(faction);
            return;
        }
        
        // 按照7:3的比例分配角色卡和場地卡
        int characterCount = (int)(DECK_SIZE * 0.7); // 70%為角色卡
        int fieldCount = DECK_SIZE - characterCount; // 30%為場地卡
        
        // 從卡牌圖鑑中選擇指定陣營的角色卡
        List<CharacterCard> factionCharacters = allCharacters.stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList());
        
        // 如果該陣營的角色卡不足，加入一些中立陣營的卡牌
        List<CharacterCard> neutralCharacters = allCharacters.stream()
                .filter(card -> card.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
        
        // 從卡牌圖鑑中選擇指定陣營的場地卡
        List<FieldCard> factionFields = allFields.stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList());
        
        // 如果該陣營的場地卡不足，加入一些中立陣營的卡牌
        List<FieldCard> neutralFields = allFields.stream()
                .filter(card -> card.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
                
        // 優先選擇陣營卡牌，然後是中立卡牌
        for (int i = 0; i < characterCount; i++) {
            if (!factionCharacters.isEmpty()) {
                cards.add(copyCard(factionCharacters.get(i % factionCharacters.size())));
            } else if (!neutralCharacters.isEmpty()) {
                cards.add(copyCard(neutralCharacters.get(i % neutralCharacters.size())));
            } else {
                cards.add(createRandomCharacterCard(i, faction));
            }
        }
        
        for (int i = 0; i < fieldCount; i++) {
            if (!factionFields.isEmpty()) {
                cards.add(copyCard(factionFields.get(i % factionFields.size())));
            } else if (!neutralFields.isEmpty()) {
                cards.add(copyCard(neutralFields.get(i % neutralFields.size())));
            } else {
                cards.add(createRandomFieldCard(i, faction));
            }
        }
        
        // 確保牌組大小為30張
        if (cards.size() > DECK_SIZE) {
            cards = cards.subList(0, DECK_SIZE);
        } else if (cards.size() < DECK_SIZE) {
            // 不足30張時補充隨機卡牌
            while (cards.size() < DECK_SIZE) {
                if (Math.random() < 0.7) {
                    cards.add(createRandomCharacterCard(cards.size(), faction));
                } else {
                    cards.add(createRandomFieldCard(cards.size(), faction));
                }
            }
        }
        
        System.out.println(faction.getLocalizedName() + " 牌組初始化完成，共有 " + cards.size() + " 張卡牌");
    }
    
    /**
     * 創建一個隨機角色卡
     */
    private CharacterCard createRandomCharacterCard(int index) {
        return createRandomCharacterCard(index, Faction.NEUTRAL);
    }
    
    /**
     * 創建一個特定陣營的隨機角色卡
     */
    private CharacterCard createRandomCharacterCard(int index, Faction faction) {
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
            
        // 根據陣營生成名稱
        String namePrefix = "";
        switch (faction) {
            case SPICY_KINGDOM:
                namePrefix = "辣味";
                break;
            case HEALTHY_OASIS:
                namePrefix = "健康";
                break;
            case FAST_FOOD_GUILD:
                namePrefix = "速食";
                break;
            case DESSERT_UNION:
                namePrefix = "甜點";
                break;
            default:
                namePrefix = "中立";
                break;
        }
        
        return new CharacterCard(
                namePrefix + "食物角色 #" + (index+1), 
                cost, 
                "一個隨機生成的" + faction.getLocalizedName() + "陣營食物角色", 
                rarity, 
                attack, 
                defense,
                health,
                isOffensive,
                faction);
    }
    
    /**
     * 創建一個隨機場地卡
     */
    private FieldCard createRandomFieldCard(int index) {
        return createRandomFieldCard(index, Faction.NEUTRAL);
    }
    
    /**
     * 創建一個特定陣營的隨機場地卡
     */
    private FieldCard createRandomFieldCard(int index, Faction faction) {
        Random random = new Random();
        int cost = random.nextInt(7) + 1; // 1-7費
            
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
            
        // 根據陣營生成名稱
        String namePrefix = "";
        switch (faction) {
            case SPICY_KINGDOM:
                namePrefix = "辣味";
                break;
            case HEALTHY_OASIS:
                namePrefix = "健康";
                break;
            case FAST_FOOD_GUILD:
                namePrefix = "速食";
                break;
            case DESSERT_UNION:
                namePrefix = "甜點";
                break;
            default:
                namePrefix = "中立";
                break;
        }
        
        // 創建環境類場地卡
        int envEffectValue = cost + random.nextInt(3); // 效果值基於費用
        
        return FieldCard.createEnvironmentField(
                namePrefix + "料理環境 #" + (index+1), 
                cost, 
                "一個隨機生成的" + faction.getLocalizedName() + "陣營料理環境場地", 
                rarity,
                envEffectValue,
                faction);
    }
    
    /**
     * 初始化隨機牌組，用於卡牌圖鑑尚未初始化的情況
     */
    private void initializeRandom() {
        initializeRandomWithFaction(Faction.NEUTRAL);
    }
    
    /**
     * 初始化特定陣營的隨機牌組
     */
    private void initializeRandomWithFaction(Faction faction) {
        // 生成隨機牌組，確保正好有30張卡牌
        Random random = new Random();
        
        // 按照7:3的比例分配角色卡和場地卡
        int characterCount = (int)(DECK_SIZE * 0.7); // 70%為角色卡
        int fieldCount = DECK_SIZE - characterCount; // 30%為場地卡
        
        // 生成指定陣營的角色卡
        for (int i = 0; i < characterCount; i++) {
            cards.add(createRandomCharacterCard(i, faction));
        }
        
        // 生成指定陣營的場地卡
        for (int i = 0; i < fieldCount; i++) {
            cards.add(createRandomFieldCard(i, faction));
        }
        
        System.out.println(faction.getLocalizedName() + " 陣營牌組隨機初始化完成，共有 " + cards.size() + " 張卡牌");
    }
    
    /**
     * 複製卡牌，確保每張卡牌是獨立的實例
     */
    private Card copyCard(Card original) {
        if (original instanceof SpellCard) {
            SpellCard originalSpell = (SpellCard) original;
            return new SpellCard(
                    originalSpell.getName(),
                    originalSpell.getTokenCost(),
                    originalSpell.getDescription(),
                    originalSpell.getRarity(),
                    originalSpell.getSpellType()
            );
        } else if (original instanceof CharacterCard) {
            CharacterCard originalChar = (CharacterCard) original;
            return new CharacterCard(
                    originalChar.getName(),
                    originalChar.getTokenCost(),
                    originalChar.getDescription(),
                    originalChar.getRarity(),
                    originalChar.getAttack(),
                    originalChar.getDefense(),
                    originalChar.getMaxHealth(),
                    originalChar.isOffensive(),
                    originalChar.getFaction()
            );
        } else if (original instanceof FieldCard) {
            FieldCard originalField = (FieldCard) original;
            return FieldCard.createEnvironmentField(
                    originalField.getName(),
                    originalField.getTokenCost(),
                    originalField.getDescription(),
                    originalField.getRarity(),
                    originalField.getEffectValue(),
                    originalField.getFaction()
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
        if (cards.size() >= DECK_SIZE) {
            return false;
        }
        
        cards.add(card);
        return true;
    }
    
    /**
     * 獲取牌組中的所有卡牌
     * @return 牌組中的卡牌列表
     */
    public List<Card> getCards() {
        return cards;
    }
    
    /**
     * 從牌組中移除指定卡牌
     * @param card 要移除的卡牌
     * @return 移除是否成功
     */
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }
} 