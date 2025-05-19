package com.example.game.helper;

import java.util.ArrayList;
import java.util.List;

import com.example.game.board.BattlefieldZone;
import com.example.game.board.CastleZone;
import com.example.game.card.CardEffect;
import com.example.game.card.CardEffectImpl;
import com.example.game.card.CharacterCard;
import com.example.game.player.Player;

/**
 * 目標選擇器 - 協助選擇合法的攻擊目標
 */
public class TargetSelectorHelper {
    private static final CardEffect cardEffect = new CardEffectImpl();
    
    /**
     * 檢查對手戰場上是否有擺盤效果的角色
     * @param opponent 對手玩家
     * @return 找到的擺盤角色列表
     */
    public static List<CharacterCard> findGarnishedTargets(Player opponent) {
        List<CharacterCard> garnishedTargets = new ArrayList<>();
        
        // 檢查所有區域
        for (int areaType : new int[] {
                BattlefieldZone.DRAW_AREA, 
                BattlefieldZone.MANA_AREA, 
                BattlefieldZone.PLAY_AREA}) {
            
            // 獲取該區域的所有角色
            List<CharacterCard> characters = opponent.getBattlefieldZone()
                    .getAreaByType(areaType)
                    .getCharacters();
            
            // 檢查每個角色是否有擺盤效果
            for (CharacterCard character : characters) {
                if (cardEffect.processGarnishedEffect(character)) {
                    garnishedTargets.add(character);
                }
            }
        }
        
        return garnishedTargets;
    }
    
    /**
     * 獲取合法的攻擊目標
     * 如果對手戰場上有擺盤效果的角色，只能攻擊這些角色
     * @param opponent 對手玩家
     * @param allTargets 所有可能的目標
     * @return 可攻擊的目標列表
     */
    public static List<CharacterCard> getValidAttackTargets(Player opponent, List<CharacterCard> allTargets) {
        // 檢查是否有擺盤效果的角色
        List<CharacterCard> garnishedTargets = findGarnishedTargets(opponent);
        
        // 如果有擺盤角色，只能攻擊擺盤角色
        if (!garnishedTargets.isEmpty()) {
            System.out.println("對手有擺盤效果的角色，只能攻擊這些角色！");
            return garnishedTargets;
        }
        
        // 否則所有角色都是合法目標
        return allTargets;
    }
    
    /**
     * 檢查指定角色是否是合法的攻擊目標
     * @param opponent 對手玩家
     * @param target 目標角色
     * @return 是否是合法目標
     */
    public static boolean isValidAttackTarget(Player opponent, CharacterCard target) {
        List<CharacterCard> garnishedTargets = findGarnishedTargets(opponent);
        
        // 如果沒有擺盤角色，任何角色都是合法目標
        if (garnishedTargets.isEmpty()) {
            return true;
        }
        
        // 如果有擺盤角色，目標必須是其中之一
        return garnishedTargets.contains(target);
    }
    
    /**
     * 選擇要進行操作的城牆區域
     * @param player 當前玩家
     * @return 選擇的城牆類型（1=抽牌區，2=法力區，3=出牌區），如果取消則返回0
     */
    public static int selectWallType(Player player) {
        // 選擇生命值最低的城牆進行回復
        if (player != null) {
            CastleZone castleZone = player.getCastleZone();
            
            // 獲取三個城牆的生命值
            int drawWallHealth = castleZone.getDrawWall().getHealth();
            int manaWallHealth = castleZone.getManaWall().getHealth();
            int playWallHealth = castleZone.getPlayWall().getHealth();
            
            // 獲取每個城牆的最大生命值
            int maxWallHealth = castleZone.getDrawWall().getMaxHealth();
            
            // 如果有任何城牆已經滿血，就不考慮它們
            if (drawWallHealth >= maxWallHealth && manaWallHealth >= maxWallHealth && playWallHealth >= maxWallHealth) {
                // 所有城牆都滿血，隨機選一個
                System.out.println("所有城牆都已滿血，隨機選擇一個城牆");
                return new java.util.Random().nextInt(3) + 1;
            }
            
            // 找出生命值最低且未滿血的城牆
            int lowestHealth = Integer.MAX_VALUE;
            int chosenWallType = 0;
            
            if (drawWallHealth < maxWallHealth && drawWallHealth < lowestHealth) {
                lowestHealth = drawWallHealth;
                chosenWallType = 1;
            }
            
            if (manaWallHealth < maxWallHealth && manaWallHealth < lowestHealth) {
                lowestHealth = manaWallHealth;
                chosenWallType = 2;
            }
            
            if (playWallHealth < maxWallHealth && playWallHealth < lowestHealth) {
                chosenWallType = 3;
            }
            
            // 如果沒有選到任何城牆（可能都滿血了），則選擇第一個
            if (chosenWallType == 0) {
                chosenWallType = 1;
            }
            
            System.out.println("選擇生命值最低的城牆（" + getWallName(chosenWallType) + "）進行回復");
            return chosenWallType;
        }
        
        // 如果player為null，則隨機選擇
        return new java.util.Random().nextInt(3) + 1;
    }
    
    /**
     * 獲取城牆名稱
     */
    private static String getWallName(int wallType) {
        switch (wallType) {
            case 1: return "抽牌區";
            case 2: return "法力區";
            case 3: return "出牌區";
            default: return "未知區域";
        }
    }
} 