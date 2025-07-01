package com.example.game.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.game.board.BattlefieldZone;
import com.example.game.card.Card;
import com.example.game.card.CardLibrary;
import com.example.game.card.CastleCard;
import com.example.game.card.CastleCardZone;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.TargetSelector;

/**
 * AI玩家類 - 實現AI對手的自動決策行為
 */
public class AIPlayer extends Player {
    private int difficulty; // AI難度: 1=簡單, 2=中等, 3=困難
    private Random random;
    
    public AIPlayer(String name, int difficulty) {
        super(name);
        this.difficulty = difficulty;
        this.random = new Random();
    }
    
    /**
     * AI選擇陣營
     */
    public Faction chooseAIFaction() {
        Faction[] factions = {
            Faction.SPICY_KINGDOM,
            Faction.HEALTHY_OASIS,
            Faction.FAST_FOOD_GUILD,
            Faction.DESSERT_UNION,
            Faction.NEUTRAL
        };
        
        // 簡單模式：完全隨機選擇
        if (difficulty == 1) {
            Faction selectedFaction = factions[random.nextInt(factions.length)];
            setFaction(selectedFaction);
            return selectedFaction;
        }
        
        // 中等模式：偏好實際陣營而非中立陣營
        if (difficulty == 2) {
            Faction selectedFaction;
            if (random.nextDouble() < 0.8) {
                // 80%機率選擇非中立陣營
                selectedFaction = factions[random.nextInt(factions.length - 1)]; // 排除最後一個(中立)
            } else {
                // 20%機率選擇中立陣營
                selectedFaction = Faction.NEUTRAL;
            }
            setFaction(selectedFaction);
            return selectedFaction;
        }
        
        // 困難模式：依據優勢選擇
        // 這裡可以實現更複雜的邏輯，例如根據對手選擇的陣營來選擇有利的陣營
        // 簡化實現：各陣營有不同選擇權重
        double[] weights = {0.3, 0.3, 0.25, 0.1, 0.05}; // 權重分配
        double roll = random.nextDouble();
        double cumulativeWeight = 0.0;
        
        for (int i = 0; i < factions.length; i++) {
            cumulativeWeight += weights[i];
            if (roll < cumulativeWeight) {
                setFaction(factions[i]);
                return factions[i];
            }
        }
        
        // 預設情況
        setFaction(factions[0]);
        return factions[0];
    }
    
    /**
     * AI選擇城堡卡
     */
    public CastleCard chooseAICastle() {
        List<CastleCard> availableCastles = CardLibrary.getCastleCards(getFaction());
        
        if (availableCastles.isEmpty()) {
            return null;
        }
        
        // 簡單模式：完全隨機選擇
        if (difficulty == 1) {
            return availableCastles.get(random.nextInt(availableCastles.size()));
        }
        
        // 中等模式：根據卡牌稀有度加權選擇
        if (difficulty == 2) {
            // 簡單實現：遍歷並選擇稀有度較高的卡牌
            for (CastleCard castle : availableCastles) {
                switch (castle.getRarity()) {
                    case ULTIMATE_TASTE:
                        if (random.nextDouble() < 0.8) return castle;
                        break;
                    case CULINARY_HERITAGE:
                        if (random.nextDouble() < 0.6) return castle;
                        break;
                    case GOURMET_DELIGHT:
                        if (random.nextDouble() < 0.4) return castle;
                        break;
                    case CASUAL_BITES:
                        break;
                    default:
                        break;
                }
            }
            // 如果沒有選到高稀有度卡牌，就隨機選一張
            return availableCastles.get(random.nextInt(availableCastles.size()));
        }
        
        // 困難模式：選擇最適合的城堡卡
        // 簡化實現：根據城堡卡效果選擇
        // 在實際遊戲中可以實現更複雜的評分機制
        CastleCard bestCastle = availableCastles.get(0);
        double bestScore = 0;
        
        for (CastleCard castle : availableCastles) {
            double score = evaluateCastleCard(castle);
            if (score > bestScore) {
                bestScore = score;
                bestCastle = castle;
            }
        }
        
        return bestCastle;
    }
    
    /**
     * 評估城堡卡的價值分數
     */
    private double evaluateCastleCard(CastleCard castle) {
        // 這裡可以實現更複雜的評分標準
        // 簡化實現：基於描述文本評分
        String desc = castle.getDescription().toLowerCase();
        double score = 5.0; // 基礎分數
        
        // 根據卡牌稀有度加分
        switch (castle.getRarity()) {
            case ULTIMATE_TASTE: score += 3.0; break;
            case CULINARY_HERITAGE: score += 2.0; break;
            case GOURMET_DELIGHT: score += 1.0; break;
            case CASUAL_BITES: break;
            default: break;
        }
        
        // 根據效果關鍵字加分
        if (desc.contains("攻擊力")) score += 1.5;
        if (desc.contains("生命值")) score += 1.2;
        if (desc.contains("恢復")) score += 1.0;
        if (desc.contains("抽牌")) score += 2.0;
        
        // 添加一些隨機性，避免每次選擇完全相同
        score += random.nextDouble() * 0.5;
        
        return score;
    }
    
    /**
     * AI選擇城堡卡放置區域
     */
    public CastleCardZone chooseAICastleZone() {
        CastleCardZone[] zones = {
            CastleCardZone.DECK,
            CastleCardZone.MANA,
            CastleCardZone.PLAY
        };
        
        // 簡單模式：完全隨機選擇
        if (difficulty == 1) {
            return zones[random.nextInt(zones.length)];
        }
        
        // 中等模式：按照固定策略選擇
        if (difficulty == 2) {
            // 偏好將城堡卡放在法力區或出牌區
            if (random.nextBoolean()) {
                return CastleCardZone.MANA;
            } else {
                return CastleCardZone.PLAY;
            }
        }
        
        // 困難模式：根據城堡卡效果和陣營特點選擇
        Faction faction = getFaction();
        CastleCard castle = getCastle();
        
        if (castle != null) {
            String desc = castle.getDescription().toLowerCase();
            
            // 根據城堡卡效果選擇最適合的區域
            if (desc.contains("抽牌") || desc.contains("額外抽")) {
                return CastleCardZone.DECK;
            } else if (desc.contains("法力") || desc.contains("費用")) {
                return CastleCardZone.MANA;
            } else if (desc.contains("攻擊") || desc.contains("傷害")) {
                return CastleCardZone.PLAY;
            }
        }
        
        // 根據陣營特點選擇
        switch (faction) {
            case SPICY_KINGDOM: return CastleCardZone.PLAY;  // 火辣王國偏好出牌區
            case HEALTHY_OASIS: return CastleCardZone.DECK;  // 健康綠洲偏好抽牌區
            case FAST_FOOD_GUILD: return CastleCardZone.MANA; // 速食工會偏好法力區
            case DESSERT_UNION: return CastleCardZone.PLAY;  // 甜點聯盟偏好出牌區
            default: return zones[random.nextInt(zones.length)]; // 中立隨機選擇
        }
    }
    
    /**
     * AI選擇要放置Token的城牆
     */
    public int chooseTokenPlacement() {
        // 簡單模式：完全隨機選擇
        if (difficulty == 1) {
            return random.nextInt(3) + 1; // 1-3
        }
        
        // 中等模式：基於當前資源狀態選擇
        if (difficulty == 2) {
            // 檢查當前資源分配
            int drawTokens = getCastleZone().getDrawWall().getTokenCount();
            int manaTokens = getCastleZone().getManaWall().getTokenCount();
            int playTokens = getCastleZone().getPlayWall().getTokenCount();
            
            // 優先選擇Token數量最少的區域
            if (drawTokens <= manaTokens && drawTokens <= playTokens) {
                return 1; // 抽牌區
            } else if (manaTokens <= drawTokens && manaTokens <= playTokens) {
                return 2; // 法力區
            } else {
                return 3; // 出牌區
            }
        }
        
        // 困難模式：根據遊戲階段和策略選擇
        int turnNumber = getTurnNumber(); // 假設可以獲取當前回合數
        
        // 遊戲早期 (回合1-3)
        if (turnNumber <= 3) {
            // 早期優先發展法力和抽牌
            if (random.nextBoolean()) {
                return 2; // 法力區
            } else {
                return 1; // 抽牌區
            }
        }
        
        // 遊戲中期 (回合4-7)
        if (turnNumber <= 7) {
            // 中期平衡發展
            int lowest = findLowestTokenArea();
            if (lowest != -1) {
                return lowest;
            }
            
            // 如果都相等，稍微偏好出牌區
            double roll = random.nextDouble();
            if (roll < 0.4) return 3; // 出牌區
            else if (roll < 0.7) return 2; // 法力區
            else return 1; // 抽牌區
        }
        
        // 遊戲後期 (回合8+)
        // 後期偏好出牌區和法力區
        if (random.nextDouble() < 0.7) {
            // 70%機率選擇出牌區
            return 3;
        } else {
            // 30%機率選擇法力區
            return 2;
        }
    }
    
    /**
     * 找出Token數量最少的區域
     */
    private int findLowestTokenArea() {
        int drawTokens = getCastleZone().getDrawWall().getTokenCount();
        int manaTokens = getCastleZone().getManaWall().getTokenCount();
        int playTokens = getCastleZone().getPlayWall().getTokenCount();
        
        if (drawTokens < manaTokens && drawTokens < playTokens) {
            return 1;
        } else if (manaTokens < drawTokens && manaTokens < playTokens) {
            return 2;
        } else if (playTokens < drawTokens && playTokens < manaTokens) {
            return 3;
        }
        
        return -1; // 表示沒有明顯最低的區域
    }
    
    /**
     * 獲取當前回合數
     */
    private int getTurnNumber() {
        // 這裡應該從遊戲引擎獲取回合數
        // 簡化實現：根據手牌數量和牌庫大小估算
        int handSize = getHand().size();
        int deckSize = getDeck().size();
        int initialDeckSize = 30;
        
        // 粗略估算：假設每回合抽1-2張牌
        int estimatedTurns = (initialDeckSize - deckSize + handSize) / 2;
        return Math.max(1, estimatedTurns);
    }
    
    /**
     * AI選擇要出的卡牌和放置區域
     */
    public int[] chooseCardToPlay() {
        List<Card> hand = getHand();
        if (hand.isEmpty() || getCardsPlayedThisTurn() >= getMaxCardsToPlay()) {
            return null; // 沒有手牌或已達出牌上限
        }
        
        // 獲取可用的法力值
        int availableMana = getManaPoints();
        
        // 過濾出可以支付的卡牌
        List<Card> playableCards = hand.stream()
            .filter(card -> card.getCost() <= availableMana)
            .sorted((c1, c2) -> Integer.compare(c2.getCost(), c1.getCost())) // 優先選擇高費卡牌
            .collect(Collectors.toList());
        
        if (playableCards.isEmpty()) {
            return null; // 沒有可出的牌
        }
        
        // 簡單模式：隨機選擇可出的牌
        if (difficulty == 1) {
            Card selectedCard = playableCards.get(random.nextInt(playableCards.size()));
            int cardIndex = hand.indexOf(selectedCard);
            int areaIndex = random.nextInt(3) + 1;
            return new int[] {cardIndex, areaIndex};
        }
        
        // 中等和困難模式：根據卡牌類型選擇適合的放置區域
        Card bestCard = null;
        int bestArea = 0;
        
        // 困難模式使用更複雜的評分機制
        if (difficulty == 3) {
            double bestScore = -1;
            
            for (Card card : playableCards) {
                for (int area = 1; area <= 3; area++) {
                    double score = evaluateCardPlacement(card, area);
                    if (score > bestScore) {
                        bestScore = score;
                        bestCard = card;
                        bestArea = area;
                    }
                }
            }
        } else {
            // 中等模式：選擇費用最高的牌，並根據卡牌類型選擇區域
            bestCard = playableCards.get(0);
            
            if (bestCard instanceof CharacterCard) {
                CharacterCard character = (CharacterCard) bestCard;
                if (character.getAttack() > (character.getMaxHealth() / 2)) {
                    bestArea = 3; // 進攻型角色放在出牌區
                } else {
                    bestArea = 1; // 防禦型角色放在抽牌區
                }
            } else {
                bestArea = 2; // 非角色卡放在法力區
            }
        }
        
        int cardIndex = hand.indexOf(bestCard);
        return new int[] {cardIndex, bestArea};
    }
    
    /**
     * 評估卡牌放置的價值
     */
    private double evaluateCardPlacement(Card card, int area) {
        double score = card.getCost() * 1.5; // 基礎分數基於費用
        
        // 根據卡牌類型和放置區域調整分數
        if (card instanceof CharacterCard) {
            CharacterCard character = (CharacterCard) card;
            
            if (character.getAttack() > (character.getMaxHealth() / 2)) {
                // 進攻型角色
                if (area == 3) score += 3.0; // 出牌區加分
                else if (area == 2) score += 1.0; // 法力區次之
            } else {
                // 防禦型角色
                if (area == 1) score += 3.0; // 抽牌區加分
                else if (area == 2) score += 1.0; // 法力區次之
            }
            
            // 基於角色屬性加分
            score += character.getAttack() * 0.5;
            score += character.getCurrentHealth() * 0.2;
        } else {
            // 非角色卡（場地卡等）
            if (area == 2) score += 2.0; // 法力區加分
        }
        
        // 添加一些隨機性以避免總是相同選擇
        score += random.nextDouble() * 0.5;
        
        return score;
    }
    
    /**
     * AI選擇攻擊目標
     * @return [attackerIndex, targetType, targetIndex]
     *         attackerIndex: 攻擊者索引
     *         targetType: 目標類型 (1=角色, 2=城牆)
     *         targetIndex: 目標索引 (角色索引或城牆類型)
     */
    public int[] chooseAttackTarget() {
        // 獲取所有區域的角色卡
        List<CharacterCard> characters = new ArrayList<>();
        characters.addAll(getBattlefieldZone().getAreaByType(BattlefieldZone.DRAW_AREA).getCharacters());
        characters.addAll(getBattlefieldZone().getAreaByType(BattlefieldZone.MANA_AREA).getCharacters());
        characters.addAll(getBattlefieldZone().getAreaByType(BattlefieldZone.PLAY_AREA).getCharacters());
        
        List<CharacterCard> canAttack = characters.stream()
            .filter(CharacterCard::canAttack)
            .collect(Collectors.toList());
        
        if (canAttack.isEmpty()) {
            return null; // 沒有可攻擊的角色
        }
        
        // 獲取對手玩家
        Player opponent = getOpponent();
        if (opponent == null) {
            return null; // 未知對手
        }
        
        // 獲取對手角色列表
        List<CharacterCard> opponentCharacters = new ArrayList<>();
        opponentCharacters.addAll(opponent.getBattlefieldZone().getAreaByType(BattlefieldZone.DRAW_AREA).getCharacters());
        opponentCharacters.addAll(opponent.getBattlefieldZone().getAreaByType(BattlefieldZone.MANA_AREA).getCharacters());
        opponentCharacters.addAll(opponent.getBattlefieldZone().getAreaByType(BattlefieldZone.PLAY_AREA).getCharacters());
        
        if (opponentCharacters.isEmpty()) {
            // 攻擊城牆
            CharacterCard attacker = canAttack.get(random.nextInt(canAttack.size()));
            int attackerIndex = characters.indexOf(attacker);
            int targetIndex = random.nextInt(3) + 1; // 隨機選擇城牆（1-3）
            return new int[] {attackerIndex, 2, targetIndex};
        }
        
        // 篩選合法攻擊目標（考慮擺盤效果）
        List<CharacterCard> validTargets = TargetSelector.getValidAttackTargets(opponent, opponentCharacters);
        
        // 簡單模式：隨機選擇攻擊者和目標
        if (difficulty == 1) {
            CharacterCard attacker = canAttack.get(random.nextInt(canAttack.size()));
            int attackerIndex = characters.indexOf(attacker);
            
            // 攻擊角色，必須從有效目標中選擇
            return new int[] {attackerIndex, 1, validTargets.isEmpty() ? 0 : 0}; // 0表示在遊戲引擎中會列出可選目標
        }
        
        // 中等和困難模式：根據策略選擇目標
        
        // 選擇攻擊力最高的角色作為攻擊者
        CharacterCard bestAttacker = canAttack.stream()
            .max((c1, c2) -> Integer.compare(c1.getAttack(), c2.getAttack()))
            .orElse(canAttack.get(0));
        
        int attackerIndex = characters.indexOf(bestAttacker);
        
        // 攻擊角色，從有效目標中選擇
        return new int[] {attackerIndex, 1, validTargets.isEmpty() ? 0 : 0}; // 0表示在遊戲引擎中會列出可選目標
    }
    
    /**
     * 處理AI角色的彈牙效果，決定是否使用第二次攻擊
     * @param attacker 具有彈牙效果的攻擊者
     * @return 是否應該使用彈牙效果
     */
    public boolean shouldUseChewyEffect(CharacterCard attacker) {
        // 檢查是否可以使用彈牙效果
        if (attacker.getDescription().contains("【彈牙】") && attacker.hasAttackedOnce() && !attacker.hasUsedChewyEffect()) {
            // 根據AI難度決定使用機率
            double useChance = 0.8; // 簡單模式下80%機率使用
            
            if (difficulty == 2) {
                useChance = 0.9; // 中等難度下90%機率使用
            } else if (difficulty == 3) {
                useChance = 1.0; // 困難模式下100%使用
            }
            
            return random.nextDouble() < useChance;
        }
        
        return false;
    }
    
    /**
     * 獲取AI難度
     */
    public int getDifficulty() {
        return difficulty;
    }
} 