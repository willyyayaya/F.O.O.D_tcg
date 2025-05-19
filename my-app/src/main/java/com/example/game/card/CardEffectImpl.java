package com.example.game.card;

import java.util.ArrayList;
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
    
    // 糖爆效果的文字提取模式
    private static final Pattern SUGAR_CRASH_PATTERN = Pattern.compile("【糖爆】：([^。]+)[。]?");
    
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
        System.out.println("  觸發從牌庫搜索效果");
        
        // 解析效果描述，尋找要搜索的卡牌類型或名稱
        String searchTarget = null;
        int cardCount = 1; // 預設抽取一張卡牌
        
        // 搜索單一卡牌類型（例如：從牌庫中抽取一張角色卡）
        if (effectDescription.contains("從牌庫中抽取") || effectDescription.contains("從牌庫中搜索")) {
            Pattern cardTypePattern = Pattern.compile("從牌庫中(?:抽取|搜索)(?:一張|([0-9]+)張)?(?:的)?([^，。]+)(?:卡)?");
            Matcher cardTypeMatcher = cardTypePattern.matcher(effectDescription);
            
            if (cardTypeMatcher.find()) {
                String countStr = cardTypeMatcher.group(1);
                if (countStr != null && !countStr.isEmpty()) {
                    cardCount = Integer.parseInt(countStr);
                }
                
                searchTarget = cardTypeMatcher.group(2).trim();
                System.out.println("  將從牌庫中尋找 " + cardCount + " 張" + searchTarget);
                
                // 從牌庫中搜索指定類型的卡牌
                List<Card> foundCards = searchCardsFromDeck(player, searchTarget, cardCount);
                
                if (!foundCards.isEmpty()) {
                    System.out.println("  找到了 " + foundCards.size() + " 張符合條件的卡牌");
                    
                    // 將找到的卡牌加入手牌
                    for (Card card : foundCards) {
                        player.addCardToHand(card);
                        System.out.println("  將 " + card.getName() + " 加入手牌");
                    }
                } else {
                    System.out.println("  在牌庫中未找到任何符合 '" + searchTarget + "' 的卡牌");
                }
            }
        }
        
        // 如果沒有找到任何匹配條件，則直接抽一張牌
        if (searchTarget == null) {
            System.out.println("  無法解析具體搜索條件，直接抽一張牌");
            player.drawCard();
        }
    }
    
    /**
     * 從牌庫中搜索指定類型的卡牌
     * @param player 玩家
     * @param searchTarget 搜索目標（類型或名稱）
     * @param count 需要搜索的數量
     * @return 找到的卡牌列表
     */
    private List<Card> searchCardsFromDeck(Player player, String searchTarget, int count) {
        List<Card> result = new ArrayList<>();
        List<Card> deck = player.getDeck().getCards();
        
        if (deck.isEmpty()) {
            return result; // 牌庫為空
        }
        
        // 搜索邏輯
        // 1. 先根據卡牌類型過濾（角色卡、法術卡、場地卡等）
        // 2. 如果是根據名稱搜索，則直接匹配名稱
        // 3. 如果是根據特定效果搜索，則檢查卡牌描述
        
        for (Card card : deck) {
            boolean matches = false;
            
            // 根據類型匹配
            if (searchTarget.contains("角色") && card instanceof CharacterCard) {
                matches = true;
            } else if (searchTarget.contains("法術") && card.getType() == CardType.FIELD) {
                matches = true;
            } else if (searchTarget.contains("場地") && card instanceof FieldCard) {
                matches = true;
            } else if (searchTarget.contains("任務") && card.getType() == CardType.QUEST) {
                matches = true;
            } else if (searchTarget.contains("城堡") && card instanceof CastleCard) {
                matches = true;
            }
            // 根據陣營匹配
            else if (searchTarget.contains("火辣王國") && card.getFaction() == Faction.SPICY_KINGDOM) {
                matches = true;
            } else if (searchTarget.contains("健康綠洲") && card.getFaction() == Faction.HEALTHY_OASIS) {
                matches = true;
            } else if (searchTarget.contains("速食工會") && card.getFaction() == Faction.FAST_FOOD_GUILD) {
                matches = true;
            } else if (searchTarget.contains("甜點聯盟") && card.getFaction() == Faction.DESSERT_UNION) {
                matches = true;
            } else if (searchTarget.contains("中立") && card.getFaction() == Faction.NEUTRAL) {
                matches = true;
            }
            // 根據稀有度匹配
            else if (searchTarget.contains("傳說") && card.getRarity() == Rarity.LEGENDARY) {
                matches = true;
            } else if (searchTarget.contains("史詩") && card.getRarity() == Rarity.EPIC) {
                matches = true;
            } else if (searchTarget.contains("稀有") && card.getRarity() == Rarity.RARE) {
                matches = true;
            } else if (searchTarget.contains("普通") && card.getRarity() == Rarity.COMMON) {
                matches = true;
            }
            // 根據名稱或描述匹配
            else if (card.getName().contains(searchTarget) || 
                     card.getDescription().contains(searchTarget)) {
                matches = true;
            }
            // 根據費用匹配
            else if (searchTarget.contains("費用") || searchTarget.contains("Token")) {
                Pattern costPattern = Pattern.compile("(\\d+)(?:費用|Token)");
                Matcher costMatcher = costPattern.matcher(searchTarget);
                if (costMatcher.find()) {
                    int cost = Integer.parseInt(costMatcher.group(1));
                    if (card.getTokenCost() == cost) {
                        matches = true;
                    }
                }
            }
            
            if (matches) {
                result.add(card);
                // 從牌庫中移除找到的卡牌
                player.getDeck().removeCard(card);
                
                // 如果已找到足夠數量的卡牌，則停止搜索
                if (result.size() >= count) {
                    break;
                }
            }
        }
        
        return result;
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
                if (opponent != null && card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    processDamageEffect(character, player, opponent, effectDescription);
                } else {
                    System.out.println("  無法確定敵方玩家或不是角色卡，無法處理傷害效果");
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
        String description = card.getDescription();
        String cardName = card.getName();
        System.out.println("檢查【拼盤】條件: " + cardName);
        
        if (!description.contains("【拼盤】")) {
            return false; // 卡牌沒有拼盤效果
        }
        
        // 使用正則表達式提取拼盤效果描述
        Pattern pattern = Pattern.compile("【拼盤】：([^。]+)[。]?");
        Matcher matcher = pattern.matcher(description);
        
        if (matcher.find()) {
            String effectDescription = matcher.group(1);
            System.out.println("  拼盤效果描述: " + effectDescription);
            
            // 提取需要的卡片名稱
            List<String> requiredCards = new ArrayList<>();
            
            // 分割描述，處理不同格式的拼盤需求
            // 例如「需要A、B和C」或「A+B+C」或「A、B、C」等格式
            String[] parts;
            if (effectDescription.contains("、")) {
                parts = effectDescription.replaceAll("需要|和", "").split("、");
            } else if (effectDescription.contains("+")) {
                parts = effectDescription.split("\\+");
            } else if (effectDescription.contains("，")) {
                parts = effectDescription.replaceAll("需要|和", "").split("，");
            } else {
                parts = new String[]{effectDescription}; // 假設只需要一張卡
            }
            
            for (String part : parts) {
                String cardRequirement = part.trim();
                if (!cardRequirement.isEmpty()) {
                    requiredCards.add(cardRequirement);
                }
            }
            
            System.out.println("  需要的卡片: " + String.join(", ", requiredCards));
            
            // 檢查戰場上是否有所需的卡片
            BattlefieldZone battlefield = player.getBattlefieldZone();
            boolean allRequirementsMet = true;
            
            for (String requiredCard : requiredCards) {
                boolean found = false;
                
                // 在所有區域中檢查角色卡
                // 抽牌區
                for (CharacterCard character : battlefield.getAreaByType(BattlefieldZone.DRAW_AREA).getCharacters()) {
                    if (character.getName().equals(requiredCard)) {
                        found = true;
                        System.out.println("  在抽牌區找到需要的卡片: " + requiredCard);
                        break;
                    }
                }
                
                // 如果在抽牌區沒找到，繼續檢查法力區
                if (!found) {
                    for (CharacterCard character : battlefield.getAreaByType(BattlefieldZone.MANA_AREA).getCharacters()) {
                        if (character.getName().equals(requiredCard)) {
                            found = true;
                            System.out.println("  在法力區找到需要的卡片: " + requiredCard);
                            break;
                        }
                    }
                }
                
                // 如果在法力區沒找到，最後檢查出牌區
                if (!found) {
                    for (CharacterCard character : battlefield.getAreaByType(BattlefieldZone.PLAY_AREA).getCharacters()) {
                        if (character.getName().equals(requiredCard)) {
                            found = true;
                            System.out.println("  在出牌區找到需要的卡片: " + requiredCard);
                            break;
                        }
                    }
                }
                
                // 如果還是沒找到，檢查場地卡
                if (!found) {
                    // 檢查抽牌區場地卡
                    for (FieldCard field : battlefield.getAreaByType(BattlefieldZone.DRAW_AREA).getFieldCards()) {
                        if (field.getName().equals(requiredCard)) {
                            found = true;
                            System.out.println("  在抽牌區找到需要的場地卡: " + requiredCard);
                            break;
                        }
                    }
                }
                
                // 檢查法力區場地卡
                if (!found) {
                    for (FieldCard field : battlefield.getAreaByType(BattlefieldZone.MANA_AREA).getFieldCards()) {
                        if (field.getName().equals(requiredCard)) {
                            found = true;
                            System.out.println("  在法力區找到需要的場地卡: " + requiredCard);
                            break;
                        }
                    }
                }
                
                // 檢查出牌區場地卡
                if (!found) {
                    for (FieldCard field : battlefield.getAreaByType(BattlefieldZone.PLAY_AREA).getFieldCards()) {
                        if (field.getName().equals(requiredCard)) {
                            found = true;
                            System.out.println("  在出牌區找到需要的場地卡: " + requiredCard);
                            break;
                        }
                    }
                }
                
                // 如果沒找到任何一張所需的卡片，拼盤條件不滿足
                if (!found) {
                    allRequirementsMet = false;
                    System.out.println("  未找到需要的卡片: " + requiredCard + "，拼盤條件不滿足");
                    break;
                }
            }
            
            if (allRequirementsMet) {
                System.out.println("  滿足所有拼盤條件，可以無需法力消耗打出");
                return true;
            }
        }
        
        System.out.println("  不滿足拼盤條件，需要正常消耗法力打出");
        return false;
    }
    
    @Override
    public boolean processChewBiteEffect(Card card, Player player) {
        // 處理彈牙效果（每回合可攻擊2次）
        String description = card.getDescription();
        
        if (!description.contains("【彈牙】")) {
            return false; // 卡牌沒有彈牙效果
        }
        
        if (card instanceof CharacterCard) {
            CharacterCard character = (CharacterCard) card;
            
            if (!character.hasAttackedOnce()) {
                // 第一次攻擊，不需要特殊處理
                return false;
            } else if (!character.hasUsedChewBiteEffect()) {
                // 已經攻擊過一次，但還沒使用彈牙效果
                System.out.println(character.getName() + " 的【彈牙】效果觸發，可以再次攻擊！");
                character.setUsedChewBiteEffect(true);
                character.setCanAttack(true); // 重新設為可攻擊
                return true;
            } else {
                // 已經使用過彈牙效果
                System.out.println(character.getName() + " 已經用過【彈牙】效果，本回合不能再攻擊了");
                return false;
            }
        }
        
        return false;
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
        // 處理油膩效果（每回合攻擊力固定減少1點）
        if (card.getDescription().contains("【油膩】")) {
            System.out.println("【油膩】效果使攻擊力-1");
            return 1; // 固定減少1點攻擊力
        }
        return 0;
    }
    
    @Override
    public int processFrostedEffect(Card card, int damage) {
        // 處理糖霜效果（抵擋一次攻擊）
        if (card.getDescription().contains("【糖霜】")) {
            System.out.println("【糖霜】效果觸發，完全抵擋這次攻擊的" + damage + "點傷害");
            // CharacterCard.takeDamage方法中已經處理了hasFrostedEffect = false的邏輯
            return 0; // 返回0表示完全抵擋傷害
        }
        return damage; // 如果沒有糖霜效果，返回原始傷害值
    }
    
    @Override
    public int processSugarCrashEffect(CharacterCard card, CharacterCard target) {
        // 處理糖爆效果（執行文字效果，下回合無法攻擊與無法使用糖爆）
        String description = card.getDescription();
        
        if (!description.contains("【糖爆】")) {
            return 0; // 卡牌沒有糖爆效果
        }
        
        // 使用正則表達式提取糖爆效果描述
        Matcher matcher = SUGAR_CRASH_PATTERN.matcher(description);
        
        if (matcher.find()) {
            String effectDescription = matcher.group(1);
            System.out.println("  糖爆效果描述: " + effectDescription);
            
            // 設置下回合無法攻擊的標記（在CharacterCard.useSugarCrash中處理）
            System.out.println(card.getName() + " 的【糖爆】效果觸發，下回合無法攻擊");
            
            Player player = card.getOwner();
            if (player == null) {
                System.out.println("  無法確定卡牌擁有者，無法處理糖爆效果");
                return 0;
            }
            
            // 處理不同的糖爆效果
            // 1. 抽牌效果
            if (effectDescription.contains("抽一張牌") || effectDescription.contains("抽牌")) {
                System.out.println("  【糖爆】觸發抽牌效果");
                player.drawCard();
                return 1; // 返回值表示效果強度，用於後續處理
            }
            
            // 2. 造成傷害效果
            if (effectDescription.contains("造成") && effectDescription.contains("點傷害")) {
                Pattern damagePattern = Pattern.compile("造成(\\d+)點傷害");
                Matcher damageMatcher = damagePattern.matcher(effectDescription);
                
                if (damageMatcher.find()) {
                    int damage = Integer.parseInt(damageMatcher.group(1));
                    System.out.println("  【糖爆】觸發造成傷害效果: " + damage + "點");
                    
                    if (target != null) {
                        return damage; // 返回傷害值，實際傷害在CharacterCard.useSugarCrash中處理
                    } else {
                        System.out.println("  沒有指定目標，無法處理傷害效果");
                        return 1;
                    }
                } else {
                    // 默認造成1點傷害
                    System.out.println("  【糖爆】觸發造成默認1點傷害");
                    return 1;
                }
            }
            
            // 3. 獲得酥脆效果
            if (effectDescription.contains("獲得") && effectDescription.contains("酥脆")) {
                System.out.println("  【糖爆】觸發獲得酥脆效果");
                
                // 如果有目標指定，則為目標添加酥脆效果
                if (target != null && target instanceof CharacterCard) {
                    // 提取酥脆值
                    Pattern crispyPattern = Pattern.compile("獲得(\\d+)點酥脆");
                    Matcher crispyMatcher = crispyPattern.matcher(effectDescription);
                    
                    int crispyValue = 1; // 默認酥脆值
                    if (crispyMatcher.find()) {
                        crispyValue = Integer.parseInt(crispyMatcher.group(1));
                    }
                    
                    target.increaseCrispyValue(crispyValue);
                    System.out.println("  為 " + target.getName() + " 添加了 " + crispyValue + " 點酥脆值");
                    return crispyValue;
                } else {
                    System.out.println("  沒有指定目標，無法添加酥脆效果");
                    return 1;
                }
            }
            
            // 4. 回復城堡生命值
            if (effectDescription.contains("回復") && effectDescription.contains("城堡")) {
                System.out.println("  【糖爆】觸發回復城堡生命值效果");
                
                // 提取回復值
                Pattern healPattern = Pattern.compile("回復(\\d+)點");
                Matcher healMatcher = healPattern.matcher(effectDescription);
                
                int healAmount = 1; // 默認回復1點
                if (healMatcher.find()) {
                    healAmount = Integer.parseInt(healMatcher.group(1));
                }
                
                // 回復玩家城堡生命值的邏輯需要在調用處實現
                System.out.println("  回復城堡 " + healAmount + " 點生命值");
                return healAmount;
            }
            
            // 5. 回復角色生命值
            if (effectDescription.contains("回復") && effectDescription.contains("生命值") && !effectDescription.contains("城堡")) {
                System.out.println("  【糖爆】觸發回復角色生命值效果");
                
                // 提取回復值
                Pattern healPattern = Pattern.compile("回復(\\d+)點");
                Matcher healMatcher = healPattern.matcher(effectDescription);
                
                int healAmount = 1; // 默認回復1點
                if (healMatcher.find()) {
                    healAmount = Integer.parseInt(healMatcher.group(1));
                }
                
                // 如果有目標，為目標回復生命值
                if (target != null) {
                    target.heal(healAmount);
                    System.out.println("  為 " + target.getName() + " 回復了 " + healAmount + " 點生命值");
                    return healAmount;
                } else if (card instanceof CharacterCard) {
                    // 沒有目標時，為自己回復生命值
                    CharacterCard self = (CharacterCard) card;
                    self.heal(healAmount);
                    System.out.println("  為自己回復了 " + healAmount + " 點生命值");
                    return healAmount;
                } else {
                    System.out.println("  沒有有效目標，無法回復生命值");
                    return 1;
                }
            }
            
            // 默認返回1，表示效果已觸發但沒有匹配到具體邏輯
            return 1;
        }
        
        // 沒有找到具體的糖爆效果描述，返回默認值
        System.out.println(card.getName() + " 的【糖爆】效果格式不正確");
        return 1;
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