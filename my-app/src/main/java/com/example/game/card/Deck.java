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
    private static final int MAX_DECK_POINTS = 50; // 最大牌組點數
    
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
            System.out.println("卡牌圖鑑尚未初始化，無法創建牌組");
            return;
        }
        
        // 按照7:3的比例分配角色卡和場地卡
        int totalPoints = 0;
        Random random = new Random();
        
        // 從卡牌圖鑑中選擇角色卡
        while (totalPoints < MAX_DECK_POINTS) {
            if (!allCharacters.isEmpty()) {
                Card card = allCharacters.get(random.nextInt(allCharacters.size()));
                int cardPoints = card.getPoints();
                
                if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                    cards.add(copyCard(card));
                    totalPoints += cardPoints;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        // 從卡牌圖鑑中選擇場地卡
        while (totalPoints < MAX_DECK_POINTS) {
            if (!allFields.isEmpty()) {
                Card card = allFields.get(random.nextInt(allFields.size()));
                int cardPoints = card.getPoints();
                
                if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                    cards.add(copyCard(card));
                    totalPoints += cardPoints;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        System.out.println("牌組初始化完成，共有 " + cards.size() + " 張卡牌，總點數: " + totalPoints);
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
            System.out.println("卡牌圖鑑尚未初始化，無法創建牌組");
            return;
        }
        
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
        
        // 選擇卡牌，直到總點數達到50
        int totalPoints = 0;
        Random random = new Random();
        
        // 優先選擇陣營卡牌，然後是中立卡牌
        while (totalPoints < MAX_DECK_POINTS) {
            Card card = null;
            int cardPoints = 0;
            
            // 優先選擇陣營角色卡
            if (!factionCharacters.isEmpty()) {
                card = factionCharacters.get(random.nextInt(factionCharacters.size()));
            } else if (!neutralCharacters.isEmpty()) {
                card = neutralCharacters.get(random.nextInt(neutralCharacters.size()));
            }
            
            if (card != null) {
                cardPoints = card.getPoints();
                if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                    cards.add(copyCard(card));
                    totalPoints += cardPoints;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        // 選擇場地卡
        while (totalPoints < MAX_DECK_POINTS) {
            Card card = null;
            int cardPoints = 0;
            
            // 優先選擇陣營場地卡
            if (!factionFields.isEmpty()) {
                card = factionFields.get(random.nextInt(factionFields.size()));
            } else if (!neutralFields.isEmpty()) {
                card = neutralFields.get(random.nextInt(neutralFields.size()));
            }
            
            if (card != null) {
                cardPoints = card.getPoints();
                if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                    cards.add(copyCard(card));
                    totalPoints += cardPoints;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        System.out.println(faction.getLocalizedName() + " 牌組初始化完成，共有 " + cards.size() + " 張卡牌，總點數: " + totalPoints);
    }
    
    /**
     * 創建一個隨機套牌，總點數為50
     * @return 創建好的牌組
     */
    public static Deck createRandomDeck() {
        Deck deck = new Deck();
        List<Card> allCards = new ArrayList<>();
        
        // 從卡牌圖鑑中獲取所有可用卡牌
        allCards.addAll(CardLibrary.getAllCharacters());
        allCards.addAll(CardLibrary.getAllFieldCards());
        
        if (allCards.isEmpty()) {
            System.out.println("卡牌圖鑑尚未初始化，無法創建隨機套牌");
            return deck;
        }
        
        // 隨機選擇卡牌，直到總點數達到50
        Random random = new Random();
        int totalPoints = 0;
        
        while (totalPoints < MAX_DECK_POINTS) {
            Card card = allCards.get(random.nextInt(allCards.size()));
            int cardPoints = card.getPoints();
            
            // 如果加入這張卡牌不會超過50點，則加入
            if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                deck.cards.add(copyCard(card));
                totalPoints += cardPoints;
            } else {
                break;
            }
        }
        
        System.out.println("隨機套牌創建完成，共有 " + deck.cards.size() + " 張卡牌，總點數: " + totalPoints);
        return deck;
    }
    
    /**
     * 創建一個主題套牌，總點數為50
     * @param faction 陣營
     * @param theme 主題（例如：攻擊型、防禦型、控制型等）
     * @return 創建好的牌組
     */
    public static Deck createThemedDeck(Faction faction, String theme) {
        Deck deck = new Deck();
        List<Card> factionCards = new ArrayList<>();
        
        // 從卡牌圖鑑中獲取指定陣營的卡牌
        factionCards.addAll(CardLibrary.getAllCharacters().stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList()));
        factionCards.addAll(CardLibrary.getAllFieldCards().stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList()));
        
        // 如果陣營卡牌不足，加入一些中立卡牌
        if (factionCards.isEmpty()) {
            List<Card> neutralCards = new ArrayList<>();
            neutralCards.addAll(CardLibrary.getAllCharacters().stream()
                    .filter(card -> card.getFaction() == Faction.NEUTRAL)
                    .collect(Collectors.toList()));
            neutralCards.addAll(CardLibrary.getAllFieldCards().stream()
                    .filter(card -> card.getFaction() == Faction.NEUTRAL)
                    .collect(Collectors.toList()));
            factionCards.addAll(neutralCards);
        }
        
        if (factionCards.isEmpty()) {
            System.out.println("卡牌圖鑑尚未初始化，無法創建主題套牌");
            return deck;
        }
        
        // 根據主題篩選卡牌
        List<Card> themedCards = filterCardsByTheme(factionCards, theme);
        
        // 選擇卡牌，直到總點數達到50
        int totalPoints = 0;
        Random random = new Random();
        
        while (totalPoints < MAX_DECK_POINTS) {
            Card card = null;
            int cardPoints = 0;
            
            if (!themedCards.isEmpty()) {
                // 優先選擇主題卡牌
                card = themedCards.get(random.nextInt(themedCards.size()));
                themedCards.remove(card);
            } else if (!factionCards.isEmpty()) {
                // 如果主題卡牌用完，從所有卡牌中選擇
                card = factionCards.get(random.nextInt(factionCards.size()));
            }
            
            if (card != null) {
                cardPoints = card.getPoints();
                if (totalPoints + cardPoints <= MAX_DECK_POINTS) {
                    deck.cards.add(copyCard(card));
                    totalPoints += cardPoints;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        System.out.println(faction.getLocalizedName() + " 主題套牌創建完成，共有 " + deck.cards.size() + " 張卡牌，總點數: " + totalPoints);
        return deck;
    }
    
    /**
     * 根據主題篩選卡牌
     * @param cards 卡牌列表
     * @param theme 主題
     * @return 符合主題的卡牌列表
     */
    private static List<Card> filterCardsByTheme(List<Card> cards, String theme) {
        List<Card> themedCards = new ArrayList<>();
        
        for (Card card : cards) {
            if (card instanceof CharacterCard) {
                CharacterCard characterCard = (CharacterCard) card;
                switch (theme.toLowerCase()) {
                    case "攻擊型":
                        if (characterCard.isOffensive() && characterCard.getAttack() > characterCard.getMaxHealth()) {
                            themedCards.add(card);
                        }
                        break;
                    case "防禦型":
                        if (!characterCard.isOffensive() && characterCard.getMaxHealth() > characterCard.getAttack()) {
                            themedCards.add(card);
                        }
                        break;
                    case "控制型":
                        if (characterCard.getDescription().contains("無法") || 
                            characterCard.getDescription().contains("凍結") ||
                            characterCard.getDescription().contains("暈眩")) {
                            themedCards.add(card);
                        }
                        break;
                    case "治療型":
                        if (characterCard.getDescription().contains("恢復") || 
                            characterCard.getDescription().contains("治療")) {
                            themedCards.add(card);
                        }
                        break;
                    default:
                        themedCards.add(card);
                        break;
                }
            } else if (card instanceof FieldCard) {
                FieldCard fieldCard = (FieldCard) card;
                switch (theme.toLowerCase()) {
                    case "攻擊型":
                        if (fieldCard.getDescription().contains("攻擊") || 
                            fieldCard.getDescription().contains("傷害")) {
                            themedCards.add(card);
                        }
                        break;
                    case "防禦型":
                        if (fieldCard.getDescription().contains("防禦") || 
                            fieldCard.getDescription().contains("護甲")) {
                            themedCards.add(card);
                        }
                        break;
                    case "控制型":
                        if (fieldCard.getDescription().contains("無法") || 
                            fieldCard.getDescription().contains("凍結") ||
                            fieldCard.getDescription().contains("暈眩")) {
                            themedCards.add(card);
                        }
                        break;
                    case "治療型":
                        if (fieldCard.getDescription().contains("恢復") || 
                            fieldCard.getDescription().contains("治療")) {
                            themedCards.add(card);
                        }
                        break;
                    default:
                        themedCards.add(card);
                        break;
                }
            }
        }
        
        return themedCards;
    }
    
    /**
     * 複製一張卡牌
     */
    private static Card copyCard(Card original) {
        if (original instanceof CharacterCard) {
            CharacterCard originalChar = (CharacterCard) original;
            return new CharacterCard(
                originalChar.getName(),
                originalChar.getCost(),
                originalChar.getDescription(),
                originalChar.getRarity(),
                originalChar.getAttack(),
                originalChar.getMaxHealth(),
                originalChar.isOffensive(),
                originalChar.getFaction(),
                originalChar.getPoints()
            );
        } else if (original instanceof FieldCard) {
            FieldCard originalField = (FieldCard) original;
            return FieldCard.createEnvironmentField(
                originalField.getName(),
                originalField.getCost(),
                originalField.getDescription(),
                originalField.getRarity(),
                originalField.getDurability(),
                originalField.getFaction(),
                originalField.getPoints()
            );
        }
        return null;
    }
    
    /**
     * 洗牌
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    /**
     * 抽一張牌
     * @return 抽到的卡牌，如果牌組為空則返回null
     */
    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
    
    /**
     * 檢查牌組是否為空
     * @return 如果牌組為空返回true，否則返回false
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    /**
     * 獲取牌組大小
     * @return 牌組中的卡牌數量
     */
    public int size() {
        return cards.size();
    }
    
    /**
     * 添加一張卡牌到牌組
     * @param card 要添加的卡牌
     * @return 如果添加成功返回true，否則返回false
     */
    public boolean addCard(Card card) {
        int totalPoints = cards.stream().mapToInt(Card::getPoints).sum();
        if (totalPoints + card.getPoints() > MAX_DECK_POINTS) {
            return false;
        }
        return cards.add(card);
    }
    
    /**
     * 獲取牌組中的所有卡牌
     * @return 卡牌列表
     */
    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
    
    /**
     * 從牌組中移除一張卡牌
     * @param card 要移除的卡牌
     * @return 如果移除成功返回true，否則返回false
     */
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }
} 