package com.example.game.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.game.board.BattlefieldZone;
import com.example.game.board.CastleZone;
import com.example.game.board.ResourceZone;
import com.example.game.card.Card;
import com.example.game.card.CharacterCard;
import com.example.game.card.Deck;
import com.example.game.card.Rarity;
import com.example.game.card.TechniqueCard;
import com.example.game.card.ToolCard;

/**
 * 玩家類 - 代表F.O.O.D TCG遊戲參與者
 */
public class Player {
    private String name;
    private int health;
    private Deck deck;
    private List<Card> hand;
    
    // 新增資源相關屬性
    private int manaPoints;        // 當前法力值
    private int maxCardsToPlay;    // 本回合可出牌數量限制
    private int cardsPlayedThisTurn; // 本回合已出牌數量
    
    // F.O.O.D TCG專用區域
    private CastleZone castleZone;
    private BattlefieldZone battlefieldZone;
    private ResourceZone resourceZone;
    
    public Player(String name) {
        this.name = name;
        this.health = 30; // 預設生命值
        this.hand = new ArrayList<>();
        
        // 初始化各區域
        this.castleZone = new CastleZone();
        this.battlefieldZone = new BattlefieldZone();
        this.resourceZone = new ResourceZone();
        
        // 初始化資源
        this.manaPoints = 0;
        this.maxCardsToPlay = 1; // 預設每回合可出1張牌
        this.cardsPlayedThisTurn = 0;
    }
    
    public void initializeDeck() {
        // 初始化牌組，這裡簡單模擬
        this.deck = new Deck();
        deck.initialize();
        deck.shuffle();
    }
    
    public void drawCard() {
        if (deck.isEmpty()) {
            // 牌庫耗盡，受到疲勞傷害
            takeFatigueDamage();
            return;
        }
        
        Card card = deck.drawCard();
        hand.add(card);
        System.out.println(name + " 抽了一張牌: " + card.getName());
    }
    
    public void drawInitialHand() {
        // 初始手牌，通常是3-4張
        for (int i = 0; i < 3; i++) {
            drawCard();
        }
    }
    
    /**
     * 開始新回合
     */
    public void startNewTurn() {
        // 回合開始時獲得1個Token，並選擇放置在某一城牆
        System.out.println(name + " 獲得了1個新Token");
        
        // 重置資源計數
        this.manaPoints = 0;
        this.maxCardsToPlay = 0; // 出牌數量將由出牌區 Token 直接決定
        this.cardsPlayedThisTurn = 0;
        
        // 刷新所有角色的攻擊狀態
        for (CharacterCard character : battlefieldZone.getCharacters()) {
            character.refreshForNewTurn();
        }
    }
    
    /**
     * 更新法力值（根據法力區Token數量）
     * @param manaTokens 法力區Token數量
     */
    public void updateManaPoints(int manaTokens) {
        this.manaPoints += manaTokens;
        System.out.println(name + " 目前擁有 " + manaPoints + " 點法力值");
    }
    
    /**
     * 更新出牌數量限制（根據出牌區Token數量）
     * @param playTokens 出牌區Token數量
     */
    public void updateMaxCardsToPlay(int playTokens) {
        this.maxCardsToPlay = playTokens; // 出牌數量直接等於出牌區Token數量
        System.out.println(name + " 本回合可出 " + maxCardsToPlay + " 張牌");
    }
    
    /**
     * 打出手牌
     * @param handIndex 手牌索引
     * @param wallType 不再使用，保留參數以維持兼容性
     * @return 成功出牌返回true，否則返回false
     */
    public boolean playCard(int handIndex, int wallType) {
        if (handIndex < 0 || handIndex >= hand.size()) {
            System.out.println("無效的手牌索引!");
            return false;
        }
        
        // 檢查出牌次數限制
        if (cardsPlayedThisTurn >= maxCardsToPlay) {
            System.out.println("本回合出牌次數已達上限! (" + cardsPlayedThisTurn + "/" + maxCardsToPlay + ")");
            return false;
        }
        
        Card card = hand.get(handIndex);
        
        // 檢查法力是否足夠
        if (card.getTokenCost() > manaPoints) {
            System.out.println("法力值不足! 需要: " + card.getTokenCost() + ", 實際有: " + manaPoints);
            return false;
        }
        
        // 消耗法力值
        manaPoints -= card.getTokenCost();
        
        // 增加出牌計數
        cardsPlayedThisTurn++;
        
        // 從手牌中移除
        hand.remove(handIndex);
        
        // 根據卡牌類型處理
        switch (card.getType()) {
            case CHARACTER:
                // 角色卡添加到戰場
                CharacterCard characterCard = (CharacterCard) card;
                if (battlefieldZone.addCharacter(characterCard)) {
                    System.out.println(name + " 派出角色: " + characterCard.getName());
                    characterCard.play(this);
                } else {
                    System.out.println("戰場角色位置已滿!");
                    return false;
                }
                break;
            case TECHNIQUE:
                // 烹飪技術卡添加到戰場
                TechniqueCard techniqueCard = (TechniqueCard) card;
                if (battlefieldZone.addTechnique(techniqueCard)) {
                    System.out.println(name + " 使用烹飪技術: " + techniqueCard.getName());
                    techniqueCard.play(this);
            } else {
                    System.out.println("戰場烹飪技術位置已滿!");
                    return false;
                }
                break;
            case TOOL:
                // 料理工具卡添加到戰場
                ToolCard toolCard = (ToolCard) card;
                if (battlefieldZone.addTool(toolCard)) {
                    System.out.println(name + " 裝備料理工具: " + toolCard.getName());
                    toolCard.play(this);
        } else {
                    System.out.println("戰場料理工具位置已滿!");
                    return false;
                }
                break;
            case QUEST:
                // 任務卡添加到資源區
                System.out.println(name + " 接受任務: " + card.getName());
                resourceZone.addQuestCard(card);
            card.play(this);
                break;
        }
        
        // 顯示剩餘資源
        System.out.println(name + " 剩餘法力值: " + manaPoints + ", 出牌次數: " + cardsPlayedThisTurn + "/" + maxCardsToPlay);
        
        return true;
    }
    
    /**
     * 放置新獲得的Token
     * @param wallType 城牆類型 (1=抽牌區, 2=法力區, 3=出牌區)
     * @return 是否成功放置
     */
    public boolean placeNewToken(int wallType) {
        boolean result = castleZone.addTokenToWall(wallType);
        if (result) {
            String wallName = "";
            switch (wallType) {
                case 1: wallName = "抽牌區"; break;
                case 2: wallName = "法力區"; break;
                case 3: wallName = "出牌區"; break;
            }
            System.out.println(name + " 將新Token放置在 " + wallName);
        } else {
            System.out.println("該城牆Token已達上限!");
        }
        return result;
    }
    
    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(name + " 受到 " + amount + " 點傷害，剩餘生命值: " + health);
    }
    
    private void takeFatigueDamage() {
        // 牌庫耗盡時受到的疲勞傷害，每次+1
        int fatigueDamage = battlefieldZone.getCharacters().size() + 1; // 簡單計算疲勞傷害
        takeDamage(fatigueDamage);
    }
    
    public void heal(int amount) {
        health = Math.min(health + amount, 30); // 最大生命值為30
        System.out.println(name + " 恢復 " + amount + " 點生命值，目前生命值: " + health);
    }
    
    public void displayHand() {
        System.out.println(name + " 的手牌:");
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            System.out.println((i+1) + ". " + card.getName() + " [費用:" + card.getTokenCost() + "]");
        }
    }
    
    /**
     * 顯示指定手牌的詳細資訊
     */
    public void displayCardDetails(int handIndex) {
        if (handIndex < 0 || handIndex >= hand.size()) {
            System.out.println("無效的手牌索引!");
            return;
        }
        
        Card card = hand.get(handIndex);
        card.displayCardDetails();
    }
    
    /**
     * 城牆受到攻擊
     * @param wallType 城牆類型 (1=抽牌區, 2=法力區, 3=出牌區)
     * @param damage 傷害量
     * @return 該城牆是否被摧毀
     */
    public boolean attackWall(int wallType, int damage) {
        boolean wallDestroyed = castleZone.damageWall(wallType, damage);
        
        if (wallDestroyed) {
            String wallName = "";
            switch (wallType) {
                case 1: wallName = "抽牌區"; break;
                case 2: wallName = "法力區"; break;
                case 3: wallName = "出牌區"; break;
            }
            System.out.println(name + " 的 " + wallName + " 城牆被摧毀!");
        }
        
        return wallDestroyed;
    }
    
    /**
     * 治療城牆
     * @param wallType 城牆類型 (1=抽牌區, 2=法力區, 3=出牌區)
     * @param amount 恢復量
     */
    public void healWall(int wallType, int amount) {
        CastleZone.Wall wall;
        switch (wallType) {
            case 1: wall = castleZone.getDrawWall(); break;
            case 2: wall = castleZone.getManaWall(); break;
            case 3: wall = castleZone.getPlayWall(); break;
            default: return; // 無效的牆類型
        }
        
        wall.heal(amount);
    }
    
    /**
     * 檢查該玩家是否失敗(所有城牆被摧毀)
     * @return 如果所有城牆都被摧毀，返回true
     */
    public boolean isDefeated() {
        return castleZone.areAllWallsDestroyed();
    }
    
    /**
     * 顯示玩家手牌詳情
     */
    public void displayHandDetailed() {
        System.out.println("\n======= " + name + " 的手牌詳情 =======");
        System.out.println("當前法力值: " + getManaPoints() + ", 出牌次數: " + getCardsPlayedThisTurn() + "/" + getMaxCardsToPlay());
        
        if (hand.isEmpty()) {
            System.out.println("  (沒有手牌)");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n手牌列表:");
            for (int i = 0; i < hand.size(); i++) {
                Card card = hand.get(i);
                String cardType = "";
                String extraInfo = "";
                
                if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    cardType = "角色";
                    extraInfo = String.format("攻擊:%d 防禦:%d 生命:%d", 
                                             character.getAttack(), 
                                             character.getDefense(), 
                                             character.getCurrentHealth());
                } else if (card instanceof TechniqueCard) {
                    cardType = "技術";
                    TechniqueCard technique = (TechniqueCard) card;
                    extraInfo = String.format("類型:%s 效果值:%d", 
                                            technique.getTechniqueType(), 
                                            technique.getEffectValue());
                } else if (card instanceof ToolCard) {
                    cardType = "工具";
                }
                
                System.out.printf("%2d. %-15s [費用:%d] [%s] %s %s\n", 
                        i+1, card.getName(), card.getTokenCost(), 
                        cardType, extraInfo, 
                        getRaritySymbol(card.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice;
            try {
                choice = scanner.nextInt();
                
                if (choice == 0) {
                    return;
                } else if (choice > 0 && choice <= hand.size()) {
                    hand.get(choice-1).displayCardDetails();
                    
                    // 查看完後暫停一下
                    System.out.println("\n按Enter繼續...");
                    scanner.nextLine(); // 消耗前面的數字
                    scanner.nextLine(); // 等待Enter
                } else {
                    System.out.println("無效的選擇!");
                }
            } catch (Exception e) {
                System.out.println("請輸入有效的數字!");
                scanner.nextLine(); // 清除輸入緩衝
            }
        }
    }
    
    // 一個簡單的工具方法，用於顯示稀有度符號
    private String getRaritySymbol(Rarity rarity) {
        switch (rarity) {
            case COMMON: return "★";
            case RARE: return "★★";
            case EPIC: return "★★★";
            case LEGENDARY: return "★★★★";
            default: return "";
        }
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public List<Card> getHand() {
        return hand;
    }
    
    public CastleZone getCastleZone() {
        return castleZone;
    }
    
    public BattlefieldZone getBattlefieldZone() {
        return battlefieldZone;
    }
    
    public ResourceZone getResourceZone() {
        return resourceZone;
    }
    
    public int getManaPoints() {
        return manaPoints;
    }
    
    public int getMaxCardsToPlay() {
        return maxCardsToPlay;
    }
    
    public int getCardsPlayedThisTurn() {
        return cardsPlayedThisTurn;
    }
} 