package com.example.game.board;

import java.util.ArrayList;
import java.util.List;

import com.example.game.card.Card;

/**
 * 資源區 (Resource Zone) - 擺放 Token、法力計數器、棄牌堆、任務牌
 */
public class ResourceZone {
    private int tokenCount;         // Token 計數
    private int manaCounter;        // 法力計數器
    private List<Card> discardPile; // 棄牌堆
    private List<Card> questCards;  // 任務牌
    
    public ResourceZone() {
        this.tokenCount = 3;  // 初始時的Token總數，會根據CastleZone更新
        this.manaCounter = 0;
        this.discardPile = new ArrayList<>();
        this.questCards = new ArrayList<>();
    }
    
    /**
     * 增加Token
     * @param amount 增加的數量
     */
    public void addTokens(int amount) {
        this.tokenCount += amount;
    }
    
    /**
     * 減少Token
     * @param amount 減少的數量
     * @return 實際減少的數量（不能少於0）
     */
    public int removeTokens(int amount) {
        int actualAmount = Math.min(amount, tokenCount);
        tokenCount -= actualAmount;
        return actualAmount;
    }
    
    /**
     * 設置Token總數
     * @param count 新的Token總數
     */
    public void setTokenCount(int count) {
        this.tokenCount = count;
    }
    
    /**
     * 獲取當前Token數量
     */
    public int getTokenCount() {
        return tokenCount;
    }
    
    /**
     * 增加法力
     * @param amount 增加的法力值
     */
    public void addMana(int amount) {
        this.manaCounter += amount;
    }
    
    /**
     * 消耗法力
     * @param amount 消耗的法力值
     * @return 是否成功消耗
     */
    public boolean useMana(int amount) {
        if (manaCounter >= amount) {
            manaCounter -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * 獲取當前法力值
     */
    public int getManaCounter() {
        return manaCounter;
    }
    
    /**
     * 添加卡牌到棄牌堆
     * @param card 要添加的卡牌
     */
    public void addToDiscardPile(Card card) {
        discardPile.add(card);
    }
    
    /**
     * 從棄牌堆移除一張卡牌
     * @param index 要移除的卡牌索引
     * @return 被移除的卡牌，如不存在則返回null
     */
    public Card removeFromDiscardPile(int index) {
        if (index >= 0 && index < discardPile.size()) {
            return discardPile.remove(index);
        }
        return null;
    }
    
    /**
     * 獲取棄牌堆
     */
    public List<Card> getDiscardPile() {
        return discardPile;
    }
    
    /**
     * 添加任務牌
     * @param card 要添加的任務牌
     */
    public void addQuestCard(Card card) {
        questCards.add(card);
    }
    
    /**
     * 完成任務牌
     * @param index 要完成的任務牌索引
     * @return 被完成的任務牌，如不存在則返回null
     */
    public Card completeQuest(int index) {
        if (index >= 0 && index < questCards.size()) {
            return questCards.remove(index);
        }
        return null;
    }
    
    /**
     * 獲取任務牌列表
     */
    public List<Card> getQuestCards() {
        return questCards;
    }
    
    /**
     * 顯示資源區狀態
     */
    public void displayStatus() {
        System.out.println("資源區狀態:");
        System.out.println("- Token總數: " + tokenCount);
        System.out.println("- 法力值: " + manaCounter);
        System.out.println("- 棄牌堆: " + discardPile.size() + " 張卡牌");
        System.out.println("- 任務牌: " + questCards.size() + " 張卡牌");
    }
} 