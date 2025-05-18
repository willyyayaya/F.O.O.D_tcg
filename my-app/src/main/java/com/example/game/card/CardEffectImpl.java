package com.example.game.card;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.game.board.BattlefieldZone;
import com.example.game.player.Player;

/**
 * 卡牌效果實現類
 * 實現了CardEffect接口中定義的各種卡牌效果
 */
public class CardEffectImpl implements CardEffect {
    
    private static final Random random = new Random();
    
    // 酥脆效果的護甲值提取模式
    private static final Pattern CRISPY_PATTERN = Pattern.compile("【酥脆\\(([0-9]+)\\)】");
    
    // 糖爆效果的傷害值提取模式
    private static final Pattern SUGAR_CRASH_PATTERN = Pattern.compile("【糖爆\\(([0-9]+)\\)】");
    
    @Override
    public boolean processAppetizerEffect(Card card, Player player, Object target) {
        // 根據卡牌類型和描述執行開胃效果
        String description = card.getDescription();
        String cardName = card.getName();
        System.out.println("處理【開胃】效果: " + cardName);
        
        if (!description.contains("【開胃】")) {
            return false; // 卡牌沒有開胃效果
        }
        
        // 使用正則表達式提取開胃效果描述
        Pattern pattern = Pattern.compile("【開胃】：([^。]+)[。]?");
        Matcher matcher = pattern.matcher(description);
        
        if (matcher.find()) {
            String effectDescription = matcher.group(1);
            System.out.println("  開胃效果描述: " + effectDescription);
            
            // 根據效果描述執行相應操作
            if (card instanceof CharacterCard) {
                CharacterCard character = (CharacterCard) card;
                
                // 處理獲得屬性加成的效果
                if (effectDescription.contains("獲得+")) {
                    processStatBoost(character, effectDescription);
                }
                
                // 處理抽牌效果
                if (effectDescription.contains("抽一張牌") || effectDescription.contains("抽牌")) {
                    System.out.println("  觸發抽牌效果");
                    player.drawCard();
                } else if (effectDescription.matches(".*抽([0-9]+)張牌.*")) {
                    Pattern drawPattern = Pattern.compile("抽([0-9]+)張牌");
                    Matcher drawMatcher = drawPattern.matcher(effectDescription);
                    if (drawMatcher.find()) {
                        int cardsToDraw = Integer.parseInt(drawMatcher.group(1));
                        System.out.println("  觸發抽" + cardsToDraw + "張牌效果");
                        for (int i = 0; i < cardsToDraw; i++) {
                            player.drawCard();
                        }
                    }
                }
                
                // 處理生命值恢復效果
                if (effectDescription.contains("恢復") && effectDescription.contains("生命值")) {
                    processHealingEffect(character, player, effectDescription);
                }
                
                // 處理對敵方角色造成傷害的效果
                if (effectDescription.contains("造成") && effectDescription.contains("點傷害")) {
                    // 需要敵方玩家信息，此處暫時無法處理
                    // 在實際遊戲中，需要從上下文中獲取敵方玩家
                    Player opponent = null;
                    if (target instanceof Player) {
                        opponent = (Player) target;
                    } else {
                        System.out.println("  無法確定敵方玩家，無法處理傷害效果");
                        return true;
                    }
                    processDamageEffect(character, player, opponent, effectDescription);
                }
                
                // 處理獲得特殊關鍵字效果
                if (effectDescription.contains("獲得【")) {
                    processKeywordGainEffect(character, effectDescription);
                }
                
                // 處理搜索牌庫的效果
                if (effectDescription.contains("從牌庫")) {
                    processSearchDeckEffect(player, effectDescription);
                }
            }
            
            return true;
        }
        
        // 無法解析具體效果，但仍然返回成功
        System.out.println("  無法解析具體開胃效果，請查看卡牌描述");
        return true;
    }
    
    /**
     * 處理獲得屬性加成的效果
     */
    private void processStatBoost(CharacterCard character, String effectDescription) {
        Pattern statPattern = Pattern.compile("獲得\\+(\\d+)/(\\d+)");
        Matcher statMatcher = statPattern.matcher(effectDescription);
        
        if (statMatcher.find()) {
            int attackBoost = Integer.parseInt(statMatcher.group(1));
            int healthBoost = Integer.parseInt(statMatcher.group(2));
            
            System.out.println("  觸發屬性加成效果: +" + attackBoost + "/+" + healthBoost);
            character.increaseAttack(attackBoost);
            character.increaseDefense(healthBoost);
            
            return;
        }
        
        // 檢查單獨的攻擊力加成
        Pattern attackPattern = Pattern.compile("獲得\\+(\\d+)攻擊力");
        Matcher attackMatcher = attackPattern.matcher(effectDescription);
        if (attackMatcher.find()) {
            int attackBoost = Integer.parseInt(attackMatcher.group(1));
            System.out.println("  觸發攻擊力加成效果: +" + attackBoost);
            character.increaseAttack(attackBoost);
            return;
        }
        
        // 檢查單獨的生命值/防禦力加成
        Pattern healthPattern = Pattern.compile("獲得\\+(\\d+)/\\+(\\d+)");
        Matcher healthMatcher = healthPattern.matcher(effectDescription);
        if (healthMatcher.find()) {
            int attackBoost = Integer.parseInt(healthMatcher.group(1));
            int healthBoost = Integer.parseInt(healthMatcher.group(2));
            System.out.println("  觸發屬性加成效果: +" + attackBoost + "/+" + healthBoost);
            character.increaseAttack(attackBoost);
            character.increaseDefense(healthBoost);
        }
    }
    
    /**
     * 處理生命值恢復效果
     */
    private void processHealingEffect(CharacterCard sourceCard, Player player, String effectDescription) {
        // 為自身恢復生命值
        if (effectDescription.contains("恢復") && !effectDescription.contains("為") && !effectDescription.contains("所有")) {
            Pattern healPattern = Pattern.compile("恢復(\\d+)點生命值");
            Matcher healMatcher = healPattern.matcher(effectDescription);
            if (healMatcher.find()) {
                int healAmount = Integer.parseInt(healMatcher.group(1));
                System.out.println("  觸發恢復生命值效果: +" + healAmount);
                sourceCard.heal(healAmount);
            }
            return;
        }
        
        // 為一個友方角色恢復生命值
        if (effectDescription.contains("為一個友方角色恢復")) {
            Pattern healPattern = Pattern.compile("為一個友方角色恢復(\\d+)點生命值");
            Matcher healMatcher = healPattern.matcher(effectDescription);
            if (healMatcher.find()) {
                int healAmount = Integer.parseInt(healMatcher.group(1));
                System.out.println("  觸發為友方角色恢復生命值效果: +" + healAmount);
                
                // 使用TargetSelector選擇目標
                CharacterCard target = TargetSelector.selectFriendlyCharacter(
                        player, 
                        sourceCard, 
                        "選擇一個友方角色恢復" + healAmount + "點生命值"
                );
                
                // 應用恢復效果
                if (target != null) {
                    target.heal(healAmount);
                    System.out.println("  " + target.getName() + " 恢復了 " + healAmount + " 點生命值");
                } else {
                    System.out.println("  取消了治療效果");
                }
            }
        }
        
        // 為所有友方角色恢復生命值
        if (effectDescription.contains("為所有友方角色恢復")) {
            Pattern healPattern = Pattern.compile("為所有友方角色恢復(\\d+)點生命值");
            Matcher healMatcher = healPattern.matcher(effectDescription);
            if (healMatcher.find()) {
                int healAmount = Integer.parseInt(healMatcher.group(1));
                System.out.println("  觸發為所有友方角色恢復生命值效果: +" + healAmount);
                
                // 選擇所有友方角色
                List<CharacterCard> targets = TargetSelector.selectAllFriendlyCharacters(player);
                
                // 應用恢復效果
                for (CharacterCard target : targets) {
                    target.heal(healAmount);
                    System.out.println("  " + target.getName() + " 恢復了 " + healAmount + " 點生命值");
                }
            }
        }
    }
    
    /**
     * 處理對敵方角色造成傷害的效果
     */
    private void processDamageEffect(CharacterCard sourceCard, Player player, Player opponent, String effectDescription) {
        // 對一個敵方角色造成傷害
        if (effectDescription.contains("對一個敵方角色造成")) {
            Pattern damagePattern = Pattern.compile("對一個敵方角色造成(\\d+)點傷害");
            Matcher damageMatcher = damagePattern.matcher(effectDescription);
            if (damageMatcher.find()) {
                int damageAmount = Integer.parseInt(damageMatcher.group(1));
                System.out.println("  觸發對敵方角色造成傷害效果: " + damageAmount + "點");
                
                // 使用TargetSelector選擇目標
                CharacterCard target = TargetSelector.selectEnemyCharacter(
                        player, 
                        opponent, 
                        "選擇一個敵方角色造成" + damageAmount + "點傷害"
                );
                
                // 應用傷害效果
                if (target != null) {
                    boolean survived = target.takeDamage(damageAmount);
                    System.out.println("  " + target.getName() + " 受到了 " + damageAmount + 
                            " 點傷害" + (survived ? "" : "，已被摧毀！"));
                } else {
                    System.out.println("  取消了傷害效果");
                }
            }
        }
        
        // 對所有敵方角色造成傷害
        if (effectDescription.contains("對所有敵方角色造成")) {
            Pattern damagePattern = Pattern.compile("對所有敵方角色造成(\\d+)點傷害");
            Matcher damageMatcher = damagePattern.matcher(effectDescription);
            if (damageMatcher.find()) {
                int damageAmount = Integer.parseInt(damageMatcher.group(1));
                System.out.println("  觸發對所有敵方角色造成傷害效果: " + damageAmount + "點");
                
                // 選擇所有敵方角色
                List<CharacterCard> targets = TargetSelector.selectAllEnemyCharacters(opponent);
                
                // 應用傷害效果
                for (CharacterCard target : targets) {
                    boolean survived = target.takeDamage(damageAmount);
                    System.out.println("  " + target.getName() + " 受到了 " + damageAmount + 
                            " 點傷害" + (survived ? "" : "，已被摧毀！"));
                }
            }
        }
    }
    
    /**
     * 處理獲得特殊關鍵字效果
     */
    private void processKeywordGainEffect(CharacterCard character, String effectDescription) {
        // 獲得糖霜效果
        if (effectDescription.contains("獲得【糖霜】")) {
            System.out.println("  觸發獲得【糖霜】效果");
            character.addFrostedEffect();
        }
        
        // 獲得其他關鍵字效果
        Pattern keywordPattern = Pattern.compile("獲得【([^】]+)】");
        Matcher keywordMatcher = keywordPattern.matcher(effectDescription);
        while (keywordMatcher.find()) {
            String keyword = keywordMatcher.group(1);
            if (!keyword.equals("糖霜")) { // 已經處理過糖霜效果
                System.out.println("  觸發獲得【" + keyword + "】效果");
                // 根據不同關鍵字執行相應操作
                // 這裡需要實現其他關鍵字的處理邏輯
            }
        }
    }
    
    /**
     * 處理搜索牌庫的效果
     */
    private void processSearchDeckEffect(Player player, String effectDescription) {
        if (effectDescription.contains("從牌庫中抽取")) {
            System.out.println("  觸發從牌庫搜索效果");
            System.out.println("  (需要實現具體的牌庫搜索邏輯)");
        }
    }
    
    @Override
    public boolean processAftertasteEffect(Card card, Player player) {
        // 處理回味效果（死亡後觸發）
        String description = card.getDescription();
        String cardName = card.getName();
        System.out.println("處理【回味】效果: " + cardName);
        
        if (!description.contains("【回味】")) {
            return false; // 卡牌沒有回味效果
        }
        
        // 使用正則表達式提取回味效果描述
        Pattern pattern = Pattern.compile("【回味】：([^。]+)[。]?");
        Matcher matcher = pattern.matcher(description);
        
        if (matcher.find()) {
            String effectDescription = matcher.group(1);
            System.out.println("  回味效果描述: " + effectDescription);
            
            // 根據效果描述執行相應操作
            
            // 處理抽牌效果
            if (effectDescription.contains("抽一張牌") || effectDescription.contains("抽牌")) {
                System.out.println("  觸發抽牌效果");
                player.drawCard();
            } else if (effectDescription.matches(".*抽([0-9]+)張牌.*")) {
                Pattern drawPattern = Pattern.compile("抽([0-9]+)張牌");
                Matcher drawMatcher = drawPattern.matcher(effectDescription);
                if (drawMatcher.find()) {
                    int cardsToDraw = Integer.parseInt(drawMatcher.group(1));
                    System.out.println("  觸發抽" + cardsToDraw + "張牌效果");
                    for (int i = 0; i < cardsToDraw; i++) {
                        player.drawCard();
                    }
                }
            }
            
            // 處理召喚效果
            if (effectDescription.contains("召喚") && effectDescription.contains("副本")) {
                System.out.println("  觸發召喚副本效果");
                if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    // 創建相同屬性但初始血量的副本
                    CharacterCard copy = new CharacterCard(
                        character.getName() + " 的副本", 
                        0, // 無費用
                        character.getDescription(), 
                        character.getRarity(),
                        character.getAttack(),
                        character.getDefense(),
                        character.getMaxHealth(),
                        character.isOffensive(),
                        character.getFaction()
                    );
                    
                    // 添加到戰場
                    player.getBattlefieldZone().addCharacter(copy, BattlefieldZone.PLAY_AREA);
                    System.out.println("  召喚了 " + copy.getName() + " 到戰場");
                }
            }
            
            // 處理對敵方角色造成傷害的效果
            if (effectDescription.contains("造成") && effectDescription.contains("點傷害")) {
                Player opponent = player.getOpponent();
                if (opponent != null) {
                    // 對單一敵方角色造成傷害 (需要選擇目標)
                    if (effectDescription.contains("對一個敵方角色造成")) {
                        Pattern damagePattern = Pattern.compile("對一個敵方角色造成(\\d+)點傷害");
                        Matcher damageMatcher = damagePattern.matcher(effectDescription);
                        if (damageMatcher.find()) {
                            int damageAmount = Integer.parseInt(damageMatcher.group(1));
                            System.out.println("  觸發對敵方角色造成傷害效果: " + damageAmount + "點");
                            
                            // 使用TargetSelector選擇敵方目標
                            CharacterCard target = TargetSelector.selectEnemyCharacter(
                                player,
                                opponent,
                                "【回味】效果 - 選擇一個敵方角色造成" + damageAmount + "點傷害"
                            );
                            
                            // 應用傷害效果
                            if (target != null) {
                                boolean survived = target.takeDamage(damageAmount);
                                System.out.println("  " + target.getName() + " 受到了 " + damageAmount + 
                                        " 點傷害" + (survived ? "" : "，已被摧毀！"));
                            } else {
                                System.out.println("  取消了傷害效果");
                            }
                        }
                    }
                    // 對所有敵方角色造成傷害 (直接整合 processDeathDamageEffect 方法的功能)
                    else if (effectDescription.contains("對所有敵方角色造成")) {
                        Pattern damagePattern = Pattern.compile("對所有敵方角色造成(\\d+)點傷害");
                        Matcher damageMatcher = damagePattern.matcher(effectDescription);
                        if (damageMatcher.find()) {
                            int damageAmount = Integer.parseInt(damageMatcher.group(1));
                            System.out.println("  觸發對所有敵方角色造成傷害效果: " + damageAmount + "點");
                            
                            List<CharacterCard> targets = TargetSelector.selectAllEnemyCharacters(opponent);
                            for (CharacterCard target : targets) {
                                boolean survived = target.takeDamage(damageAmount);
                                System.out.println("  " + target.getName() + " 受到了 " + damageAmount + 
                                        " 點傷害" + (survived ? "" : "，已被摧毀！"));
                            }
                        }
                    } else {
                        System.out.println("  無法確定傷害目標，無法處理傷害效果");
                    }
                } else {
                    System.out.println("  無法確定敵方玩家，無法處理傷害效果");
                }
            }
            
            // 處理回復生命值效果
            if (effectDescription.contains("恢復") && effectDescription.contains("生命值")) {
                // 為單一友方角色恢復生命值 (需要選擇目標)
                if (effectDescription.contains("為一個友方角色恢復")) {
                    Pattern healPattern = Pattern.compile("為一個友方角色恢復(\\d+)點生命值");
                    Matcher healMatcher = healPattern.matcher(effectDescription);
                    if (healMatcher.find()) {
                        int healAmount = Integer.parseInt(healMatcher.group(1));
                        System.out.println("  觸發為友方角色恢復生命值效果: +" + healAmount);
                        
                        // 使用TargetSelector選擇友方目標
                        CharacterCard target = TargetSelector.selectFriendlyCharacter(
                            player,
                            card,
                            "【回味】效果 - 選擇一個友方角色恢復" + healAmount + "點生命值"
                        );
                        
                        // 應用恢復效果
                        if (target != null) {
                            target.heal(healAmount);
                            System.out.println("  " + target.getName() + " 恢復了 " + healAmount + " 點生命值");
                        } else {
                            System.out.println("  取消了治療效果");
                        }
                    }
                }
                // 為所有友方角色恢復生命值
                else if (effectDescription.contains("為所有友方角色恢復")) {
                    Pattern healPattern = Pattern.compile("為所有友方角色恢復(\\d+)點生命值");
                    Matcher healMatcher = healPattern.matcher(effectDescription);
                    if (healMatcher.find()) {
                        int healAmount = Integer.parseInt(healMatcher.group(1));
                        System.out.println("  觸發為所有友方角色恢復生命值效果: +" + healAmount);
                        
                        List<CharacterCard> targets = TargetSelector.selectAllFriendlyCharacters(player);
                        for (CharacterCard target : targets) {
                            target.heal(healAmount);
                            System.out.println("  " + target.getName() + " 恢復了 " + healAmount + " 點生命值");
                        }
                    }
                } else if (effectDescription.contains("恢復") && effectDescription.contains("法力值")) {
                    Pattern manaPattern = Pattern.compile("恢復(\\d+)點法力值");
                    Matcher manaMatcher = manaPattern.matcher(effectDescription);
                    if (manaMatcher.find()) {
                        int manaAmount = Integer.parseInt(manaMatcher.group(1));
                        System.out.println("  觸發恢復法力值效果: +" + manaAmount);
                        player.updateManaPoints(manaAmount);
                    }
                }
            }
            
            return true;
        }
        
        // 無法解析具體效果，但仍然返回成功
        System.out.println("  無法解析具體回味效果，請查看卡牌描述");
        return true;
    }
    
    @Override
    public boolean processPlatterEffect(Card card, Player player) {
        // 檢查是否滿足拼盤條件
        System.out.println("檢查【拼盤】條件: " + card.getName());
        // 在實際遊戲邏輯中實現條件檢查
        return false;
    }
    
    @Override
    public boolean processChewBiteEffect(Card card, Player player) {
        // 處理彈牙效果（每回合可攻擊2次）
        System.out.println("處理【彈牙】效果: " + card.getName());
        return card.getDescription().contains("【彈牙】");
    }
    
    @Override
    public int processCrispyEffect(Card card, int damage) {
        // 這個方法現在用於計算卡牌的酥脆值，不直接處理傷害減免
        // 實際的傷害減免由CharacterCard.takeDamage直接處理
        
        String description = card.getDescription();
        if (description.contains("【酥脆】")) {
            Matcher matcher = CRISPY_PATTERN.matcher(description);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            } else {
                return 1; // 默認酥脆值
            }
        }
        return 0; // 沒有酥脆效果
    }
    
    @Override
    public boolean processGarnishedEffect(Card card) {
        // 處理擺盤效果（嘲諷）
        return card.getDescription().contains("【擺盤】");
    }
    
    @Override
    public boolean processFreshFriedEffect(Card card) {
        // 處理現炸效果（進場即可攻擊）
        return card.getDescription().contains("【現炸】");
    }
    
    @Override
    public int processGlossyEffect(CharacterCard card) {
        // 處理油膩效果（攻擊力逐漸減少）
        if (card.getDescription().contains("【油膩】")) {
            System.out.println("【油膩】效果使攻擊力-1");
            return 1; // 減少1點攻擊力
        }
        return 0;
    }
    
    @Override
    public int processFrostedEffect(Card card, int damage) {
        // 處理糖霜效果（抵擋一次攻擊）
        if (card.getDescription().contains("【糖霜】")) {
            System.out.println("【糖霜】效果抵擋一次攻擊");
            // 需要在遊戲中記錄已使用過糖霜效果的狀態
            return 0;
        }
        return damage;
    }
    
    @Override
    public int processSugarCrashEffect(CharacterCard card, CharacterCard target) {
        // 處理糖爆效果（特殊攻擊，下回合無法攻擊）
        String description = card.getDescription();
        if (description.contains("【糖爆】")) {
            Matcher matcher = SUGAR_CRASH_PATTERN.matcher(description);
            if (matcher.find()) {
                int damage = Integer.parseInt(matcher.group(1));
                System.out.println("觸發【糖爆(" + damage + ")】效果，造成" + damage + "點傷害，下回合無法攻擊");
                // 在遊戲邏輯中設置該卡牌下回合無法攻擊的標記
                return damage;
            } else {
                System.out.println("觸發【糖爆】效果，造成1點傷害，下回合無法攻擊");
                return 1; // 默認造成1點傷害
            }
        }
        return 0;
    }
    
    @Override
    public int processNourishingEffect(CharacterCard card) {
        // 處理滋補效果（回合結束時回滿血量）
        if (card.getDescription().contains("【滋補】")) {
            int healAmount = card.getMaxHealth() - card.getCurrentHealth();
            System.out.println("【滋補】效果恢復生命值: " + healAmount);
            return healAmount;
        }
        return 0;
    }
    
    @Override
    public boolean processBlandEffect(CharacterCard card) {
        // 處理清淡效果（滿血時無法攻擊）
        if (card.getDescription().contains("【清淡】")) {
            boolean isFullHealth = card.getCurrentHealth() >= card.getMaxHealth();
            System.out.println("【清淡】效果檢查: " + (isFullHealth ? "滿血，無法攻擊" : "可以攻擊"));
            return !isFullHealth; // 滿血時返回false，表示不能攻擊
        }
        return true; // 沒有清淡效果，可以攻擊
    }
    
    @Override
    public boolean processOverheatEffect(CharacterCard card, CharacterCard target) {
        // 處理爆炒效果（直接消滅單位）
        if (card.getDescription().contains("【爆炒】")) {
            // 在實際遊戲中，可能需要基於概率來決定是否觸發
            boolean triggered = random.nextDouble() <= 0.25; // 假設25%的觸發率
            System.out.println("【爆炒】效果檢查: " + (triggered ? "觸發成功，摧毀目標" : "未觸發"));
            return triggered;
        }
        return false;
    }
    
    @Override
    public int processSpicyEffect(CharacterCard card) {
        // 處理嗆辣效果（每回合結束損失一點生命值）
        if (card.getDescription().contains("【嗆辣】")) {
            System.out.println("【嗆辣】效果生效，損失1點生命值");
            return 1;
        }
        return 0;
    }
} 