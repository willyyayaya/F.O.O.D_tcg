package com.example.game.board;

import java.util.ArrayList;
import java.util.List;

import com.example.game.card.CharacterCard;
import com.example.game.card.TechniqueCard;
import com.example.game.card.ToolCard;

/**
 * 戰場區 (Battlefield) - 擺放角色卡（進攻與防禦）、料理工具與烹飪技術
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
        private List<ToolCard> cookingTools;     // 料理工具卡
        private List<TechniqueCard> techniques;  // 烹飪技術卡
        
        // 各類卡牌的最大數量限制
        private static final int MAX_CHARACTERS = 2;
        private static final int MAX_TOOLS = 1;
        private static final int MAX_TECHNIQUES = 1;
        
        public BattlefieldArea(String name) {
            this.name = name;
            this.characters = new ArrayList<>();
            this.cookingTools = new ArrayList<>();
            this.techniques = new ArrayList<>();
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
         * 添加料理工具卡到戰場區域
         */
        public boolean addTool(ToolCard card) {
            if (cookingTools.size() < MAX_TOOLS) {
                cookingTools.add(card);
                return true;
            }
            return false; // 料理工具卡已滿
        }
        
        /**
         * 添加烹飪技術卡到戰場區域
         */
        public boolean addTechnique(TechniqueCard card) {
            if (techniques.size() < MAX_TECHNIQUES) {
                techniques.add(card);
                return true;
            }
            return false; // 烹飪技術卡已滿
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
         * 移除料理工具卡
         */
        public ToolCard removeTool(int index) {
            if (index >= 0 && index < cookingTools.size()) {
                return cookingTools.remove(index);
            }
            return null;
        }
        
        /**
         * 移除烹飪技術卡
         */
        public TechniqueCard removeTechnique(int index) {
            if (index >= 0 && index < techniques.size()) {
                return techniques.remove(index);
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
         * 獲取所有料理工具卡
         */
        public List<ToolCard> getTools() {
            return cookingTools;
        }
        
        /**
         * 獲取所有烹飪技術卡
         */
        public List<TechniqueCard> getTechniques() {
            return techniques;
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
            
            // 顯示料理工具卡
            System.out.println("料理工具 (" + cookingTools.size() + "/" + MAX_TOOLS + "):");
            if (cookingTools.isEmpty()) {
                System.out.println("  (無)");
            } else {
                for (int i = 0; i < cookingTools.size(); i++) {
                    ToolCard card = cookingTools.get(i);
                    System.out.println("  " + (i+1) + ". " + card.getName());
                }
            }
            
            // 顯示烹飪技術卡
            System.out.println("烹飪技術 (" + techniques.size() + "/" + MAX_TECHNIQUES + "):");
            if (techniques.isEmpty()) {
                System.out.println("  (無)");
            } else {
                for (int i = 0; i < techniques.size(); i++) {
                    TechniqueCard card = techniques.get(i);
                    System.out.println("  " + (i+1) + ". " + card.getName());
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
     * 添加料理工具卡到指定區域
     */
    public boolean addTool(ToolCard card, int areaType) {
        return getAreaByType(areaType).addTool(card);
    }
    
    /**
     * 添加烹飪技術卡到指定區域
     */
    public boolean addTechnique(TechniqueCard card, int areaType) {
        return getAreaByType(areaType).addTechnique(card);
    }
    
    /**
     * 為了向後兼容，提供不指定區域的方法（預設放在出牌區）
     */
    public boolean addCharacter(CharacterCard card) {
        return addCharacter(card, PLAY_AREA);
    }
    
    public boolean addTool(ToolCard card) {
        return addTool(card, PLAY_AREA);
    }
    
    public boolean addTechnique(TechniqueCard card) {
        return addTechnique(card, PLAY_AREA);
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
     * 獲取所有料理工具卡（所有區域的總和）
     */
    public List<ToolCard> getTools() {
        List<ToolCard> allTools = new ArrayList<>();
        allTools.addAll(drawArea.getTools());
        allTools.addAll(manaArea.getTools());
        allTools.addAll(playArea.getTools());
        return allTools;
    }
    
    /**
     * 獲取所有烹飪技術卡（所有區域的總和）
     */
    public List<TechniqueCard> getTechniques() {
        List<TechniqueCard> allTechniques = new ArrayList<>();
        allTechniques.addAll(drawArea.getTechniques());
        allTechniques.addAll(manaArea.getTechniques());
        allTechniques.addAll(playArea.getTechniques());
        return allTechniques;
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
     * 顯示戰場狀態
     */
    public void displayStatus() {
        System.out.println("戰場區狀態:");
        
        // 顯示抽牌區
        System.out.println("【抽牌區】");
        drawArea.displayStatus();
        
        // 顯示法力區
        System.out.println("\n【法力區】");
        manaArea.displayStatus();
        
        // 顯示出牌區
        System.out.println("\n【出牌區】");
        playArea.displayStatus();
    }
} 