package com.example.game.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.game.board.BattlefieldZone;
import com.example.game.board.CastleZone;
import com.example.game.board.ResourceZone;
import com.example.game.card.Card;
import com.example.game.card.CharacterCard;
import com.example.game.card.CastleCard;
import com.example.game.card.Deck;
import com.example.game.card.FieldCard;
import com.example.game.card.Rarity;
import com.example.game.card.Faction;

/**
 * 玩家類 - 代表F.O.O.D TCG遊戲參與者
 */
public class Player {
    private String name;
    private Deck deck;
    private List<Card> hand;
    private CastleCard castleCard; // 玩家選擇的城堡卡
    private Faction faction; // 玩家選擇的陣營
    
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
        this.hand = new ArrayList<>();
        this.castleCard = null; // 初始化為空
        this.faction = Faction.NEUTRAL; // 預設為中立陣營
        
        // 初始化各區域
        this.castleZone = new CastleZone();
        this.battlefieldZone = new BattlefieldZone();
        this.resourceZone = new ResourceZone();
        
        // 初始化資源
        this.manaPoints = 0;
        this.maxCardsToPlay = 1; // 預設每回合可出1張牌
        this.cardsPlayedThisTurn = 0;
        
        // 同步資源區Token
        updateResourceTokens();
    }
    
    public void initializeDeck() {
        // 初始化牌組，根據玩家選擇的陣營生成對應牌組
        this.deck = new Deck();
        deck.initialize(faction); // 傳入陣營參數
        deck.shuffle();
    }
    
    /**
     * 從牌組中抽一張牌
     * 如果牌組為空，則直接判定玩家失敗
     */
    public void drawCard() {
        if (deck.isEmpty()) {
            // 牌庫耗盡，直接判定為失敗
            System.out.println(name + " 的牌庫已空，無法再抽牌！");
            System.out.println(name + " 因牌庫耗盡而失敗！");
            // 將所有城牆生命值設為0，確保會被判定為失敗
            this.castleZone.getDrawWall().takeDamage(this.castleZone.getDrawWall().getHealth());
            this.castleZone.getManaWall().takeDamage(this.castleZone.getManaWall().getHealth());
            this.castleZone.getPlayWall().takeDamage(this.castleZone.getPlayWall().getHealth());
            return;
        }
        
        Card card = deck.drawCard();
        hand.add(card);
        System.out.println(name + " 抽了一張牌: " + card.getName() + "，牌庫剩餘: " + deck.size() + " 張牌");
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
        
        // 確保資源區Token與城堡區Token同步
        updateResourceTokens();
        
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
     * @param areaType 戰場區域 (1=抽牌區, 2=法力區, 3=出牌區)
     * @return 成功出牌返回true，否則返回false
     */
    public boolean playCard(int handIndex, int areaType) {
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
        
        // 區域名稱
        String areaName;
        switch (areaType) {
            case BattlefieldZone.DRAW_AREA: areaName = "抽牌區"; break;
            case BattlefieldZone.MANA_AREA: areaName = "法力區"; break;
            case BattlefieldZone.PLAY_AREA: areaName = "出牌區"; break;
            default: areaName = "未知區域"; break;
        }
        
        // 根據卡牌類型處理
        switch (card.getType()) {
            case CHARACTER:
                // 角色卡添加到戰場
                CharacterCard characterCard = (CharacterCard) card;
                if (battlefieldZone.addCharacter(characterCard, areaType)) {
                    System.out.println(name + " 派出角色: " + characterCard.getName() + " 到" + areaName);
                    characterCard.play(this);
                } else {
                    System.out.println(areaName + "角色位置已滿!");
                    return false;
                }
                break;
            case FIELD:
                // 場地卡添加到戰場
                FieldCard fieldCard = (FieldCard) card;
                if (battlefieldZone.addFieldCard(fieldCard, areaType)) {
                    System.out.println(name + " 啟用場地: " + fieldCard.getName() + " 到" + areaName);
                    fieldCard.play(this);
            } else {
                    System.out.println(areaName + "場地位置已滿!");
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
    
    // 為了保持向後兼容，提供舊的playCard方法，預設放在出牌區
    public boolean playCard(int handIndex, int wallType, boolean oldVersion) {
        // 注意：wallType 參數已不再使用，僅為保持兼容而保留
        return playCard(handIndex, BattlefieldZone.PLAY_AREA);
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
            
            // 同步資源區Token
            updateResourceTokens();
        } else {
            System.out.println("該城牆Token已達上限!");
        }
        return result;
    }
    
    public void takeDamage(int amount) {
        // 生命值由三個城牆的生命值組成，不再單獨跟蹤玩家生命值
        System.out.println(name + " 受到 " + amount + " 點傷害");
    }
    
    public void heal(int amount) {
        // 治療會均勻分配到三個城牆
        int amountPerWall = amount / 3;
        int remainder = amount % 3;
        
        castleZone.getDrawWall().heal(amountPerWall + (remainder > 0 ? 1 : 0));
        castleZone.getManaWall().heal(amountPerWall + (remainder > 1 ? 1 : 0));
        castleZone.getPlayWall().heal(amountPerWall);
        
        System.out.println(name + " 治療 " + amount + " 點生命值，分配到三個城牆");
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
     * 獲取玩家當前生命值（三個城牆生命值的總和）
     */
    public int getHealth() {
        int drawWallHealth = castleZone.getDrawWall().getHealth();
        int manaWallHealth = castleZone.getManaWall().getHealth();
        int playWallHealth = castleZone.getPlayWall().getHealth();
        
        return drawWallHealth + manaWallHealth + playWallHealth;
    }
    
    /**
     * 獲取玩家最大生命值（三個城牆最大生命值的總和）
     */
    public int getMaxHealth() {
        int maxWallHealth = castleZone.getDrawWall().getMaxHealth();
        return maxWallHealth * 3; // 三個城牆各10點，總共30點
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
                } else if (card instanceof FieldCard) {
                    FieldCard field = (FieldCard) card;
                    cardType = "場地";
                    
                    switch (field.getFieldType()) {
                        case COOKING_TECHNIQUE:
                            extraInfo = "類型:烹飪技術";
                            break;
                        case COOKING_TOOL:
                            extraInfo = "類型:料理工具";
                            break;
                        case ENVIRONMENT:
                            extraInfo = "類型:環境";
                            break;
                    }
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
    
    /**
     * 更新資源區的Token總數（根據城堡區三個區域的token總和）
     */
    public void updateResourceTokens() {
        int totalCastleTokens = castleZone.getTotalTokenCount();
        resourceZone.setTokenCount(totalCastleTokens);
    }
    
    /**
     * 獲取玩家的牌組
     */
    public Deck getDeck() {
        return deck;
    }
    
    /**
     * 獲取玩家的城堡卡
     */
    public CastleCard getCastleCard() {
        return castleCard;
    }
    
    /**
     * 設置玩家的城堡卡
     */
    public void setCastleCard(CastleCard castle) {
        this.castleCard = castle;
        if (castle != null) {
            System.out.println(name + " 選擇了城堡卡: " + castle.getName());
        }
    }
    
    /**
     * 獲取玩家的陣營
     */
    public Faction getFaction() {
        return faction;
    }
    
    /**
     * 設置玩家的陣營
     */
    public void setFaction(Faction faction) {
        this.faction = faction;
        System.out.println(name + " 選擇了陣營: " + faction.getLocalizedName());
    }
} 