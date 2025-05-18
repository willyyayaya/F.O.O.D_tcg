package com.example.game.helper;

import java.util.ArrayList;
import java.util.List;

import com.example.game.board.BattlefieldZone;
import com.example.game.card.CardEffect;
import com.example.game.card.CardEffectImpl;
import com.example.game.card.CharacterCard;
import com.example.game.player.Player;

/**
 * 目標選擇器 - 協助選擇合法的攻擊目標
 */
public class TargetSelector {
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
} 