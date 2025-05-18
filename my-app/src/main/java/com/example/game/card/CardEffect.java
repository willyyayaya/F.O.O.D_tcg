package com.example.game.card;

import com.example.game.player.Player;

/**
 * 卡牌效果接口
 * 定義了卡牌可以具有的各種關鍵字效果
 */
public interface CardEffect {
    
    /**
     * 處理開胃效果（進場時觸發）
     * @param card 卡牌
     * @param player 卡牌擁有者
     * @param target 目標卡牌或玩家（可能為null）
     * @return 效果是否成功處理
     */
    boolean processAppetizerEffect(Card card, Player player, Object target);
    
    /**
     * 處理回味效果（死亡時觸發）
     * @param card 卡牌
     * @param player 卡牌擁有者
     * @return 效果是否成功處理
     */
    boolean processAftertasteEffect(Card card, Player player);
    
    /**
     * 處理拼盤效果（符合條件時可打出融合卡）
     * @param card 卡牌
     * @param player 卡牌擁有者
     * @return 是否滿足拼盤條件
     */
    boolean processPlatterEffect(Card card, Player player);
    
    /**
     * 處理彈牙效果（每回合可攻擊2次）
     * @param card 卡牌
     * @param player 卡牌擁有者
     * @return 是否可以進行第二次攻擊
     */
    boolean processChewBiteEffect(Card card, Player player);
    
    /**
     * 處理酥脆效果（護甲值，減免傷害）
     * @param card 卡牌
     * @param damage 即將受到的傷害
     * @return 實際受到的傷害（減免後）
     */
    int processCrispyEffect(Card card, int damage);
    
    /**
     * 處理擺盤效果（嘲諷）
     * 如果對方戰場上有擺盤效果的角色，則必須優先攻擊該角色
     * @param card 卡牌
     * @return 是否具有嘲諷效果
     */
    boolean processGarnishedEffect(Card card);
    
    /**
     * 處理現炸效果（進場即可攻擊）
     * @param card 卡牌
     * @return 是否可以立即攻擊
     */
    boolean processFreshFriedEffect(Card card);
    
    /**
     * 處理油膩效果（攻擊力逐漸減少）
     * @param card 角色卡
     * @return 減少的攻擊力數值
     */
    int processGlossyEffect(CharacterCard card);
    
    /**
     * 處理糖霜效果（抵擋一次攻擊）
     * @param card 卡牌
     * @param damage 即將受到的傷害
     * @return 實際受到的傷害（如果抵擋則為0）
     */
    int processFrostedEffect(Card card, int damage);
    
    /**
     * 處理糖爆效果（特殊攻擊，下回合無法攻擊）
     * @param card 角色卡
     * @param target 攻擊目標
     * @return 糖爆造成的傷害
     */
    int processSugarCrashEffect(CharacterCard card, CharacterCard target);
    
    /**
     * 處理滋補效果（回合結束時回滿血量）
     * @param card 角色卡
     * @return 恢復的生命值
     */
    int processNourishingEffect(CharacterCard card);
    
    /**
     * 處理清淡效果（滿血時無法攻擊）
     * @param card 角色卡
     * @return 是否可以攻擊
     */
    boolean processBlandEffect(CharacterCard card);
    
    /**
     * 處理爆炒效果（直接消滅單位）
     * @param card 角色卡
     * @param target 目標角色卡
     * @return 是否成功消滅目標
     */
    boolean processOverheatEffect(CharacterCard card, CharacterCard target);
    
    /**
     * 處理嗆辣效果（每回合結束損失一點生命值）
     * @param card 角色卡
     * @return 損失的生命值
     */
    int processSpicyEffect(CharacterCard card);
} 