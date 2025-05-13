package com.example.game.board;

import java.util.ArrayList;
import java.util.List;

import com.example.game.card.Card;
import com.example.game.card.CharacterCard;
import com.example.game.card.FieldCard;

/**
 * 戰場區 (Battlefield) - 擺放角色卡（進攻與防禦）和場地卡
 * 分為三個子區域：抽牌區、法力區、出牌區
 */
public class BattlefieldZone {
    // 新的區域結構
    private BattlefieldArea drawArea;    // 抽牌區
    private BattlefieldArea manaArea;    // 法力區
    private BattlefieldArea playArea;    // 出牌區
    
    // 區域類型常量
    public static final int DRAW_AREA = 1;
    public static final int MANA_AREA = 2;
    public static final int PLAY_AREA = 3;
    
    /**
     * 戰場子區域類，代表三個不同區域中的一個
     */
    public static class BattlefieldArea {
        private String name;
        private List<CharacterCard> characters;  // 角色卡
        private List<FieldCard> fieldCards;      // 場地卡
        
        // 各類卡牌的最大數量限制
        private static final int MAX_CHARACTERS = 2;
        private static final int MAX_FIELD_CARDS = 2;  // 每個區域最多2張場地卡
        
        public BattlefieldArea(String name) {
            this.name = name;
            this.characters = new ArrayList<>();
            this.fieldCards = new ArrayList<>();
        }
        
        public String getName() {
            return name;
        }
        
        /**
         * 添加角色卡到戰場區域
         */
        public boolean addCharacter(CharacterCard card) {
            if (characters.size() < MAX_CHARACTERS) {
                characters.add(card);
                return true;
            }
            return false; // 角色卡已滿
        }
        
        /**
         * 添加場地卡到戰場區域
         */
        public boolean addFieldCard(FieldCard card) {
            if (fieldCards.size() < MAX_FIELD_CARDS) {
                fieldCards.add(card);
                return true;
            }
            return false; // 場地卡已滿
        }
        
        /**
         * 移除角色卡
         */
        public CharacterCard removeCharacter(int index) {
            if (index >= 0 && index < characters.size()) {
                return characters.remove(index);
            }
            return null;
        }
        
        /**
         * 移除場地卡
         */
        public FieldCard removeFieldCard(int index) {
            if (index >= 0 && index < fieldCards.size()) {
                return fieldCards.remove(index);
            }
            return null;
        }
        
        /**
         * 獲取所有角色卡
         */
        public List<CharacterCard> getCharacters() {
            return characters;
        }
        
        /**
         * 獲取所有場地卡
         */
        public List<FieldCard> getFieldCards() {
            return fieldCards;
        }
        
        /**
         * 顯示區域狀態
         */
        public void displayStatus() {
            // 顯示角色卡
            System.out.println("角色卡 (" + characters.size() + "/" + MAX_CHARACTERS + "):");
            if (characters.isEmpty()) {
                System.out.println("  (無)");
            } else {
                for (int i = 0; i < characters.size(); i++) {
                    CharacterCard card = characters.get(i);
                    System.out.println("  " + (i+1) + ". " + card.getName() + 
                            " [攻擊:" + card.getAttack() + ", 防禦:" + card.getDefense() + "]");
                }
            }
            
            // 顯示場地卡
            System.out.println("場地卡 (" + fieldCards.size() + "/" + MAX_FIELD_CARDS + "):");
            if (fieldCards.isEmpty()) {
                System.out.println("  (無)");
            } else {
                for (int i = 0; i < fieldCards.size(); i++) {
                    FieldCard card = fieldCards.get(i);
                    
                    String fieldTypeInfo = "";
                    switch (card.getFieldType()) {
                        case COOKING_TECHNIQUE:
                            fieldTypeInfo = "[烹飪技術]";
                            break;
                        case COOKING_TOOL:
                            fieldTypeInfo = "[料理工具]";
                            break;
                        case ENVIRONMENT:
                            fieldTypeInfo = "[環境]";
                            break;
                    }
                    
                    System.out.println("  " + (i+1) + ". " + card.getName() + " " + fieldTypeInfo);
                }
            }
        }
    }
    
    public BattlefieldZone() {
        // 初始化三個區域
        this.drawArea = new BattlefieldArea("抽牌區");
        this.manaArea = new BattlefieldArea("法力區");
        this.playArea = new BattlefieldArea("出牌區");
    }
    
    /**
     * 根據區域類型獲取對應的區域
     */
    public BattlefieldArea getAreaByType(int areaType) {
        switch (areaType) {
            case DRAW_AREA: return drawArea;
            case MANA_AREA: return manaArea;
            case PLAY_AREA: return playArea;
            default: throw new IllegalArgumentException("無效的區域類型: " + areaType);
        }
    }
    
    /**
     * 添加角色卡到指定區域
     */
    public boolean addCharacter(CharacterCard card, int areaType) {
        return getAreaByType(areaType).addCharacter(card);
    }
    
    /**
     * 添加場地卡到指定區域
     */
    public boolean addFieldCard(FieldCard card, int areaType) {
        return getAreaByType(areaType).addFieldCard(card);
    }
    
    /**
     * 為了向後兼容，提供不指定區域的方法（預設放在出牌區）
     */
    public boolean addCharacter(CharacterCard card) {
        return addCharacter(card, PLAY_AREA);
    }
    
    public boolean addFieldCard(FieldCard card) {
        return addFieldCard(card, PLAY_AREA);
    }
    
    /**
     * 獲取所有角色卡（所有區域的總和）
     */
    public List<CharacterCard> getCharacters() {
        List<CharacterCard> allCharacters = new ArrayList<>();
        allCharacters.addAll(drawArea.getCharacters());
        allCharacters.addAll(manaArea.getCharacters());
        allCharacters.addAll(playArea.getCharacters());
        return allCharacters;
    }
    
    /**
     * 獲取所有場地卡（所有區域的總和）
     */
    public List<FieldCard> getFieldCards() {
        List<FieldCard> allFieldCards = new ArrayList<>();
        allFieldCards.addAll(drawArea.getFieldCards());
        allFieldCards.addAll(manaArea.getFieldCards());
        allFieldCards.addAll(playArea.getFieldCards());
        return allFieldCards;
    }
    
    /**
     * 獲取抽牌區
     */
    public BattlefieldArea getDrawArea() {
        return drawArea;
    }
    
    /**
     * 獲取法力區
     */
    public BattlefieldArea getManaArea() {
        return manaArea;
    }
    
    /**
     * 獲取出牌區
     */
    public BattlefieldArea getPlayArea() {
        return playArea;
    }
    
    /**
     * 移除指定角色卡
     */
    public boolean removeCharacter(CharacterCard card) {
        // 嘗試從所有區域尋找並移除卡牌
        for (BattlefieldArea area : new BattlefieldArea[]{drawArea, manaArea, playArea}) {
            List<CharacterCard> characters = area.getCharacters();
            int index = characters.indexOf(card);
            if (index != -1) {
                area.removeCharacter(index);
                return true;
            }
        }
        return false; // 未找到指定卡牌
    }
    
    /**
     * 顯示整個戰場狀態
     */
    public void displayStatus() {
        System.out.println("\n======= 戰場狀態 =======");
        
        System.out.println("\n【抽牌區】");
        drawArea.displayStatus();
        
        System.out.println("\n【法力區】");
        manaArea.displayStatus();
        
        System.out.println("\n【出牌區】");
        playArea.displayStatus();
        
        System.out.println("\n=========================");
    }
    
    /**
     * @deprecated 使用 addFieldCard 替代
     */
    @Deprecated
    public boolean addTechnique(Card card, int areaType) {
        System.out.println("警告：使用了已棄用的方法addTechnique，請改用addFieldCard");
        // 實際上就會返回false，因為我們期望開發者使用新的API
        return false;
    }
    
    /**
     * @deprecated 使用 addFieldCard 替代
     */
    @Deprecated
    public boolean addTool(Card card, int areaType) {
        System.out.println("警告：使用了已棄用的方法addTool，請改用addFieldCard");
        // 實際上就會返回false，因為我們期望開發者使用新的API
        return false;
    }
    
    /**
     * @deprecated 使用 getFieldCards 替代
     */
    @Deprecated
    public List<Card> getTechniques() {
        System.out.println("警告：使用了已棄用的方法getTechniques，請改用getFieldCards");
        return new ArrayList<>(); // 返回空列表
    }
    
    /**
     * @deprecated 使用 getFieldCards 替代
     */
    @Deprecated
    public List<Card> getTools() {
        System.out.println("警告：使用了已棄用的方法getTools，請改用getFieldCards");
        return new ArrayList<>(); // 返回空列表
    }
} 