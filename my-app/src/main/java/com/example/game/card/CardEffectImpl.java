package com.example.game.card;

import com.example.game.player.Player;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("處理【開胃】效果: " + card.getName());
        // 在實際遊戲邏輯中實現具體效果
        return true;
    }
    
    @Override
    public boolean processAftertasteEffect(Card card, Player player) {
        // 處理回味效果（死亡後觸發）
        System.out.println("處理【回味】效果: " + card.getName());
        // 在實際遊戲邏輯中實現具體效果
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