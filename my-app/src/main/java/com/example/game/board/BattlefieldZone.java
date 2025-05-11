package com.example.game.board;

import java.util.ArrayList;
import java.util.List;

import com.example.game.card.CharacterCard;
import com.example.game.card.TechniqueCard;
import com.example.game.card.ToolCard;

/**
 * 戰場區 (Battlefield) - 擺放角色卡（進攻與防禦）、料理工具與烹飪技術
 */
public class BattlefieldZone {
    private List<CharacterCard> characters;  // 角色卡
    private List<ToolCard> cookingTools;     // 料理工具卡
    private List<TechniqueCard> techniques;  // 烹飪技術卡
    
    // 各類卡牌的最大數量限制
    private static final int MAX_CHARACTERS = 5;
    private static final int MAX_TOOLS = 3;
    private static final int MAX_TECHNIQUES = 3;
    
    public BattlefieldZone() {
        this.characters = new ArrayList<>();
        this.cookingTools = new ArrayList<>();
        this.techniques = new ArrayList<>();
    }
    
    /**
     * 添加角色卡到戰場
     * @param card 角色卡
     * @return 是否成功添加
     */
    public boolean addCharacter(CharacterCard card) {
        if (characters.size() < MAX_CHARACTERS) {
            characters.add(card);
            return true;
        }
        return false; // 角色卡已滿
    }
    
    /**
     * 添加料理工具卡到戰場
     * @param card 料理工具卡
     * @return 是否成功添加
     */
    public boolean addTool(ToolCard card) {
        if (cookingTools.size() < MAX_TOOLS) {
            cookingTools.add(card);
            return true;
        }
        return false; // 料理工具卡已滿
    }
    
    /**
     * 添加烹飪技術卡到戰場
     * @param card 烹飪技術卡
     * @return 是否成功添加
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
     * @param index 要移除的角色卡索引
     * @return 被移除的角色卡，如不存在則返回null
     */
    public CharacterCard removeCharacter(int index) {
        if (index >= 0 && index < characters.size()) {
            return characters.remove(index);
        }
        return null;
    }
    
    /**
     * 移除料理工具卡
     * @param index 要移除的料理工具卡索引
     * @return 被移除的料理工具卡，如不存在則返回null
     */
    public ToolCard removeTool(int index) {
        if (index >= 0 && index < cookingTools.size()) {
            return cookingTools.remove(index);
        }
        return null;
    }
    
    /**
     * 移除烹飪技術卡
     * @param index 要移除的烹飪技術卡索引
     * @return 被移除的烹飪技術卡，如不存在則返回null
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
     * 顯示戰場狀態
     */
    public void displayStatus() {
        System.out.println("戰場區狀態:");
        
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