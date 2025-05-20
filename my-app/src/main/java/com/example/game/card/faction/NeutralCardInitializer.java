package com.example.game.card.faction;

import java.util.List;
import java.util.Map;

import com.example.game.card.Card;
import com.example.game.card.CastleCard;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.FieldCard;
import com.example.game.card.Rarity;
import com.example.game.card.SpellCard;
import com.example.game.card.SpellType;

/**
 * 中立卡牌初始化實現類
 */
public class NeutralCardInitializer implements FactionCardInitializer {
    
    @Override
    public void initializeCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters,
        List<SpellCard> allSpells,
        List<FieldCard> allFieldCards,
        List<CastleCard> allCastles
    ) {
        // 根莖類食材
        CharacterCard cornKnight = new CharacterCard(
            "玉米騎士", 2, "【酥脆(1)】：減免1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(cornKnight.getName(), cornKnight);
        allCharacters.add(cornKnight);

        CharacterCard potatoGuardian = new CharacterCard(
            "馬鈴薯守衛", 3, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時為一個友方角色恢復2點生命值。", 
            Rarity.COMMON, 1, 4, 4, false, Faction.NEUTRAL);
        allCards.put(potatoGuardian.getName(), potatoGuardian);
        allCharacters.add(potatoGuardian);

        CharacterCard sweetPotatoMage = new CharacterCard(
            "地瓜法師", 4, "【開胃】：為一個友方角色恢復2點生命值。【回味】：死亡時抽一張牌。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(sweetPotatoMage.getName(), sweetPotatoMage);
        allCharacters.add(sweetPotatoMage);

        CharacterCard carrotArcher = new CharacterCard(
            "胡蘿蔔射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(carrotArcher.getName(), carrotArcher);
        allCharacters.add(carrotArcher);

        CharacterCard radishScout = new CharacterCard(
            "蘿蔔斥候", 2, "【酥脆(1)】：減免1點傷害。【開胃】：獲得+1攻擊力直到回合結束。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(radishScout.getName(), radishScout);
        allCharacters.add(radishScout);

        CharacterCard taroWarrior = new CharacterCard(
            "芋頭戰士", 4, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時對一個敵方單位造成2點傷害。", 
            Rarity.RARE, 3, 4, 4, false, Faction.NEUTRAL);
        allCards.put(taroWarrior.getName(), taroWarrior);
        allCharacters.add(taroWarrior);

        CharacterCard gingerMage = new CharacterCard(
            "薑法師", 3, "【開胃】：對一個敵方單位造成1點傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(gingerMage.getName(), gingerMage);
        allCharacters.add(gingerMage);

        CharacterCard lotusRootGuard = new CharacterCard(
            "蓮藕守衛", 3, "【酥脆(1)】：減免1點傷害。【回味】：死亡時為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, 1, 5, 3, false, Faction.NEUTRAL);
        allCards.put(lotusRootGuard.getName(), lotusRootGuard);
        allCharacters.add(lotusRootGuard);

        CharacterCard yamPriest = new CharacterCard(
            "山藥祭司", 5, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時抽兩張牌。", 
            Rarity.RARE, 2, 4, 5, false, Faction.NEUTRAL);
        allCards.put(yamPriest.getName(), yamPriest);
        allCharacters.add(yamPriest);

        CharacterCard burdockKnight = new CharacterCard(
            "牛蒡騎士", 4, "【擺盤】：敵人必須優先攻擊這個單位。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(burdockKnight.getName(), burdockKnight);
        allCharacters.add(burdockKnight);

        // 豆類食材
        CharacterCard soyWarrior = new CharacterCard(
            "黃豆戰士", 2, "【彈牙】：每回合可攻擊2次。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 2, 2, 2, true, Faction.NEUTRAL);
        allCards.put(soyWarrior.getName(), soyWarrior);
        allCharacters.add(soyWarrior);

        CharacterCard blackBeanNinja = new CharacterCard(
            "黑豆忍者", 3, "【酥脆(1)】：減免1點傷害。【開胃】：獲得+1/+1直到回合結束。", 
            Rarity.RARE, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(blackBeanNinja.getName(), blackBeanNinja);
        allCharacters.add(blackBeanNinja);

        CharacterCard redBeanMage = new CharacterCard(
            "紅豆法師", 3, "【開胃】：為一個友方角色恢復2點生命值。【回味】：死亡時抽一張牌。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(redBeanMage.getName(), redBeanMage);
        allCharacters.add(redBeanMage);

        CharacterCard mungBeanScout = new CharacterCard(
            "綠豆斥候", 2, "【酥脆(1)】：減免1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(mungBeanScout.getName(), mungBeanScout);
        allCharacters.add(mungBeanScout);

        CharacterCard kidneyBeanGuard = new CharacterCard(
            "腰豆守衛", 3, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 1, 4, 4, false, Faction.NEUTRAL);
        allCards.put(kidneyBeanGuard.getName(), kidneyBeanGuard);
        allCharacters.add(kidneyBeanGuard);

        CharacterCard chickpeaArcher = new CharacterCard(
            "鷹嘴豆射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時對一個敵方單位造成2點傷害。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(chickpeaArcher.getName(), chickpeaArcher);
        allCharacters.add(chickpeaArcher);

        CharacterCard lentilWarrior = new CharacterCard(
            "扁豆戰士", 4, "【開胃】：獲得+2/+2直到回合結束。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(lentilWarrior.getName(), lentilWarrior);
        allCharacters.add(lentilWarrior);

        CharacterCard peaPriest = new CharacterCard(
            "豌豆祭司", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時抽兩張牌。", 
            Rarity.RARE, 2, 3, 4, false, Faction.NEUTRAL);
        allCards.put(peaPriest.getName(), peaPriest);
        allCharacters.add(peaPriest);

        CharacterCard broadBeanKnight = new CharacterCard(
            "蠶豆騎士", 5, "【擺盤】：敵人必須優先攻擊這個單位。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 4, 4, 5, false, Faction.NEUTRAL);
        allCards.put(broadBeanKnight.getName(), broadBeanKnight);
        allCharacters.add(broadBeanKnight);

        CharacterCard adzukiBeanMage = new CharacterCard(
            "紅豆法師", 4, "【開胃】：對所有敵方單位造成1點傷害。【回味】：死亡時使一個友方角色獲得+3/+3。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(adzukiBeanMage.getName(), adzukiBeanMage);
        allCharacters.add(adzukiBeanMage);

        // 葉菜類食材
        CharacterCard spinachPaladin = new CharacterCard(
            "菠菜聖騎士", 4, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.RARE, 2, 5, 4, false, Faction.NEUTRAL);
        allCards.put(spinachPaladin.getName(), spinachPaladin);
        allCharacters.add(spinachPaladin);

        CharacterCard lettuceRogue = new CharacterCard(
            "生菜盜賊", 2, "【酥脆(1)】：減免1點傷害。【開胃】：獲得+1攻擊力直到回合結束。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(lettuceRogue.getName(), lettuceRogue);
        allCharacters.add(lettuceRogue);

        CharacterCard cabbageGuard = new CharacterCard(
            "高麗菜守衛", 3, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, 1, 5, 3, false, Faction.NEUTRAL);
        allCards.put(cabbageGuard.getName(), cabbageGuard);
        allCharacters.add(cabbageGuard);

        CharacterCard celeryArcher = new CharacterCard(
            "芹菜射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(celeryArcher.getName(), celeryArcher);
        allCharacters.add(celeryArcher);

        CharacterCard kaleWarrior = new CharacterCard(
            "羽衣甘藍戰士", 4, "【開胃】：獲得+2/+2直到回合結束。【回味】：死亡時對所有敵方單位造成1點傷害。", 
            Rarity.RARE, 3, 4, 4, false, Faction.NEUTRAL);
        allCards.put(kaleWarrior.getName(), kaleWarrior);
        allCharacters.add(kaleWarrior);

        CharacterCard bokChoyMage = new CharacterCard(
            "青江菜法師", 3, "【開胃】：為一個友方角色恢復2點生命值。【回味】：死亡時抽一張牌。", 
            Rarity.RARE, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(bokChoyMage.getName(), bokChoyMage);
        allCharacters.add(bokChoyMage);

        CharacterCard watercressScout = new CharacterCard(
            "西洋菜斥候", 2, "【酥脆(1)】：減免1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(watercressScout.getName(), watercressScout);
        allCharacters.add(watercressScout);

        CharacterCard arugulaPriest = new CharacterCard(
            "芝麻菜祭司", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 3, 4, false, Faction.NEUTRAL);
        allCards.put(arugulaPriest.getName(), arugulaPriest);
        allCharacters.add(arugulaPriest);

        CharacterCard mustardKnight = new CharacterCard(
            "芥菜騎士", 5, "【擺盤】：敵人必須優先攻擊這個單位。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 4, 4, 5, false, Faction.NEUTRAL);
        allCards.put(mustardKnight.getName(), mustardKnight);
        allCharacters.add(mustardKnight);

        CharacterCard chardMage = new CharacterCard(
            "甜菜法師", 4, "【開胃】：對一個敵方單位造成2點傷害。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(chardMage.getName(), chardMage);
        allCharacters.add(chardMage);

        // 瓜果類食材
        CharacterCard pumpkinGiant = new CharacterCard(
            "南瓜巨人", 5, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時對所有敵方單位造成2點傷害。", 
            Rarity.RARE, 3, 6, 5, false, Faction.NEUTRAL);
        allCards.put(pumpkinGiant.getName(), pumpkinGiant);
        allCharacters.add(pumpkinGiant);

        CharacterCard cucumberArcher = new CharacterCard(
            "黃瓜射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時抽一張牌。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(cucumberArcher.getName(), cucumberArcher);
        allCharacters.add(cucumberArcher);

        CharacterCard watermelonGuard = new CharacterCard(
            "西瓜守衛", 4, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時為所有友方角色恢復2點生命值。", 
            Rarity.RARE, 2, 6, 4, false, Faction.NEUTRAL);
        allCards.put(watermelonGuard.getName(), watermelonGuard);
        allCharacters.add(watermelonGuard);

        CharacterCard cantaloupeWarrior = new CharacterCard(
            "哈密瓜戰士", 4, "【開胃】：獲得+2/+2直到回合結束。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 3, 4, 4, false, Faction.NEUTRAL);
        allCards.put(cantaloupeWarrior.getName(), cantaloupeWarrior);
        allCharacters.add(cantaloupeWarrior);

        CharacterCard honeydewMage = new CharacterCard(
            "蜜瓜法師", 3, "【開胃】：為一個友方角色恢復2點生命值。【回味】：死亡時抽兩張牌。", 
            Rarity.RARE, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(honeydewMage.getName(), honeydewMage);
        allCharacters.add(honeydewMage);

        CharacterCard bitterGourdScout = new CharacterCard(
            "苦瓜斥候", 2, "【酥脆(1)】：減免1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(bitterGourdScout.getName(), bitterGourdScout);
        allCharacters.add(bitterGourdScout);

        CharacterCard winterMelonPriest = new CharacterCard(
            "冬瓜祭司", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+3/+3。", 
            Rarity.RARE, 2, 4, 4, false, Faction.NEUTRAL);
        allCards.put(winterMelonPriest.getName(), winterMelonPriest);
        allCharacters.add(winterMelonPriest);

        CharacterCard luffaKnight = new CharacterCard(
            "絲瓜騎士", 5, "【擺盤】：敵人必須優先攻擊這個單位。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 4, 4, 5, false, Faction.NEUTRAL);
        allCards.put(luffaKnight.getName(), luffaKnight);
        allCharacters.add(luffaKnight);

        CharacterCard bottleGourdMage = new CharacterCard(
            "葫蘆法師", 4, "【開胃】：對一個敵方單位造成2點傷害。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(bottleGourdMage.getName(), bottleGourdMage);
        allCharacters.add(bottleGourdMage);

        CharacterCard snakeGourdArcher = new CharacterCard(
            "蛇瓜射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時對一個敵方單位造成2點傷害。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(snakeGourdArcher.getName(), snakeGourdArcher);
        allCharacters.add(snakeGourdArcher);

        // 菇類食材
        CharacterCard mushroomShaman = new CharacterCard(
            "香菇薩滿", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 3, 4, false, Faction.NEUTRAL);
        allCards.put(mushroomShaman.getName(), mushroomShaman);
        allCharacters.add(mushroomShaman);

        CharacterCard enokiMage = new CharacterCard(
            "金針菇法師", 3, "【酥脆(1)】：減免1點傷害。【開胃】：抽一張牌。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(enokiMage.getName(), enokiMage);
        allCharacters.add(enokiMage);

        CharacterCard shiitakeGuard = new CharacterCard(
            "香菇守衛", 3, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：死亡時為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, 1, 5, 3, false, Faction.NEUTRAL);
        allCards.put(shiitakeGuard.getName(), shiitakeGuard);
        allCharacters.add(shiitakeGuard);

        CharacterCard oysterMushroomArcher = new CharacterCard(
            "蠔菇射手", 3, "【彈牙】：每回合可攻擊2次。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.NEUTRAL);
        allCards.put(oysterMushroomArcher.getName(), oysterMushroomArcher);
        allCharacters.add(oysterMushroomArcher);

        CharacterCard kingOysterWarrior = new CharacterCard(
            "杏鮑菇戰士", 4, "【開胃】：獲得+2/+2直到回合結束。【回味】：死亡時對所有敵方單位造成1點傷害。", 
            Rarity.RARE, 3, 4, 4, false, Faction.NEUTRAL);
        allCards.put(kingOysterWarrior.getName(), kingOysterWarrior);
        allCharacters.add(kingOysterWarrior);

        CharacterCard woodEarMage = new CharacterCard(
            "木耳法師", 3, "【開胃】：為一個友方角色恢復2點生命值。【回味】：死亡時抽一張牌。", 
            Rarity.RARE, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(woodEarMage.getName(), woodEarMage);
        allCharacters.add(woodEarMage);

        CharacterCard cloudEarScout = new CharacterCard(
            "雲耳斥候", 2, "【酥脆(1)】：減免1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.NEUTRAL);
        allCards.put(cloudEarScout.getName(), cloudEarScout);
        allCharacters.add(cloudEarScout);

        CharacterCard reishiPriest = new CharacterCard(
            "靈芝祭司", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 3, 4, false, Faction.NEUTRAL);
        allCards.put(reishiPriest.getName(), reishiPriest);
        allCharacters.add(reishiPriest);

        CharacterCard lionManeKnight = new CharacterCard(
            "猴頭菇騎士", 5, "【擺盤】：敵人必須優先攻擊這個單位。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 4, 4, 5, false, Faction.NEUTRAL);
        allCards.put(lionManeKnight.getName(), lionManeKnight);
        allCharacters.add(lionManeKnight);

        CharacterCard cordycepsMage = new CharacterCard(
            "蟲草法師", 4, "【開胃】：對一個敵方單位造成2點傷害。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 3, 4, false, Faction.NEUTRAL);
        allCards.put(cordycepsMage.getName(), cordycepsMage);
        allCharacters.add(cordycepsMage);

        // 城牆回血法術
        SpellCard wallRepair = new SpellCard(
            "城牆修復", 2, "為一個城牆恢復3點生命值。", 
            Rarity.COMMON, SpellType.HEALING);
        allCards.put(wallRepair.getName(), wallRepair);
        allSpells.add(wallRepair);

        SpellCard emergencyRepair = new SpellCard(
            "緊急修復", 4, "為所有城牆恢復2點生命值。", 
            Rarity.RARE, SpellType.HEALING);
        allCards.put(emergencyRepair.getName(), emergencyRepair);
        allSpells.add(emergencyRepair);

        SpellCard masterRepair = new SpellCard(
            "大師修復", 6, "為一個城牆恢復5點生命值。", 
            Rarity.RARE, SpellType.HEALING);
        allCards.put(masterRepair.getName(), masterRepair);
        allSpells.add(masterRepair);

        SpellCard divineHealing = new SpellCard(
            "神聖治療", 8, "為所有城牆恢復4點生命值。", 
            Rarity.LEGENDARY, SpellType.HEALING);
        allCards.put(divineHealing.getName(), divineHealing);
        allSpells.add(divineHealing);

        // 角色移動法術
        SpellCard quickTransfer = new SpellCard(
            "快速轉移", 2, "將一個友方角色移動到另一個城牆。", 
            Rarity.COMMON, SpellType.SPECIAL);
        allCards.put(quickTransfer.getName(), quickTransfer);
        allSpells.add(quickTransfer);

        SpellCard massTransfer = new SpellCard(
            "群體轉移", 4, "將兩個友方角色移動到另一個城牆。", 
            Rarity.RARE, SpellType.SPECIAL);
        allCards.put(massTransfer.getName(), massTransfer);
        allSpells.add(massTransfer);

        SpellCard emergencyEvacuation = new SpellCard(
            "緊急撤離", 3, "將一個友方角色移動到另一個城牆，並使其獲得+1/+1。", 
            Rarity.RARE, SpellType.SPECIAL);
        allCards.put(emergencyEvacuation.getName(), emergencyEvacuation);
        allSpells.add(emergencyEvacuation);

        SpellCard strategicRetreat = new SpellCard(
            "戰略撤退", 5, "將所有友方角色移動到另一個城牆。", 
            Rarity.LEGENDARY, SpellType.SPECIAL);
        allCards.put(strategicRetreat.getName(), strategicRetreat);
        allSpells.add(strategicRetreat);

        // 其他輔助法術
        SpellCard foodSupply = new SpellCard(
            "食物補給", 2, "抽一張牌。", 
            Rarity.COMMON, SpellType.DRAW);
        allCards.put(foodSupply.getName(), foodSupply);
        allSpells.add(foodSupply);

        SpellCard emergencyRations = new SpellCard(
            "緊急口糧", 3, "抽兩張牌。", 
            Rarity.COMMON, SpellType.DRAW);
        allCards.put(emergencyRations.getName(), emergencyRations);
        allSpells.add(emergencyRations);

        SpellCard foodStorage = new SpellCard(
            "食物儲藏", 4, "抽三張牌。", 
            Rarity.RARE, SpellType.DRAW);
        allCards.put(foodStorage.getName(), foodStorage);
        allSpells.add(foodStorage);

        SpellCard foodPreservation = new SpellCard(
            "食物保存", 2, "使一個友方角色獲得+1/+1直到回合結束。", 
            Rarity.COMMON, SpellType.BUFF);
        allCards.put(foodPreservation.getName(), foodPreservation);
        allSpells.add(foodPreservation);

        SpellCard foodEnhancement = new SpellCard(
            "食物強化", 3, "使一個友方角色獲得+2/+2直到回合結束。", 
            Rarity.RARE, SpellType.BUFF);
        allCards.put(foodEnhancement.getName(), foodEnhancement);
        allSpells.add(foodEnhancement);

        SpellCard foodBlessing = new SpellCard(
            "食物祝福", 4, "使所有友方角色獲得+1/+1直到回合結束。", 
            Rarity.RARE, SpellType.BUFF);
        allCards.put(foodBlessing.getName(), foodBlessing);
        allSpells.add(foodBlessing);

        SpellCard foodCurse = new SpellCard(
            "食物詛咒", 3, "使一個敵方角色獲得-1/-1直到回合結束。", 
            Rarity.COMMON, SpellType.DEBUFF);
        allCards.put(foodCurse.getName(), foodCurse);
        allSpells.add(foodCurse);

        SpellCard foodPoison = new SpellCard(
            "食物中毒", 4, "使一個敵方角色獲得-2/-2直到回合結束。", 
            Rarity.RARE, SpellType.DEBUFF);
        allCards.put(foodPoison.getName(), foodPoison);
        allSpells.add(foodPoison);

        SpellCard foodPlague = new SpellCard(
            "食物瘟疫", 5, "使所有敵方角色獲得-1/-1直到回合結束。", 
            Rarity.RARE, SpellType.DEBUFF);
        allCards.put(foodPlague.getName(), foodPlague);
        allSpells.add(foodPlague);

        SpellCard foodMiracle = new SpellCard(
            "食物奇蹟", 6, "使一個友方角色獲得+3/+3直到回合結束。", 
            Rarity.LEGENDARY, SpellType.BUFF);
        allCards.put(foodMiracle.getName(), foodMiracle);
        allSpells.add(foodMiracle);

        SpellCard foodApocalypse = new SpellCard(
            "食物末日", 7, "使所有敵方角色獲得-2/-2直到回合結束。", 
            Rarity.LEGENDARY, SpellType.DEBUFF);
        allCards.put(foodApocalypse.getName(), foodApocalypse);
        allSpells.add(foodApocalypse);

        // 場地卡
        FieldCard vegetableGarden = FieldCard.createEnvironmentField(
            "蔬菜園", 2, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.COMMON, 1, Faction.NEUTRAL);
        allCards.put(vegetableGarden.getName(), vegetableGarden);
        allFieldCards.add(vegetableGarden);

        FieldCard fruitOrchard = FieldCard.createEnvironmentField(
            "果園", 3, "每當你打出一個角色時，使其獲得+1/+1。", 
            Rarity.RARE, 2, Faction.NEUTRAL);
        allCards.put(fruitOrchard.getName(), fruitOrchard);
        allFieldCards.add(fruitOrchard);

        FieldCard mushroomForest = FieldCard.createEnvironmentField(
            "菇菇森林", 4, "每回合開始時，隨機使一個友方角色獲得【酥脆(1)】效果。", 
            Rarity.RARE, 3, Faction.NEUTRAL);
        allCards.put(mushroomForest.getName(), mushroomForest);
        allFieldCards.add(mushroomForest);

        FieldCard grainField = FieldCard.createEnvironmentField(
            "穀物田", 2, "每當你使用一張法術卡時，抽一張牌。", 
            Rarity.COMMON, 1, Faction.NEUTRAL);
        allCards.put(grainField.getName(), grainField);
        allFieldCards.add(grainField);

        FieldCard herbGarden = FieldCard.createEnvironmentField(
            "香草園", 3, "每當一個友方角色受到傷害時，為其恢復1點生命值。", 
            Rarity.RARE, 2, Faction.NEUTRAL);
        allCards.put(herbGarden.getName(), herbGarden);
        allFieldCards.add(herbGarden);

        FieldCard spiceMarket = FieldCard.createEnvironmentField(
            "香料市集", 4, "每回合開始時，使一個友方角色獲得+2攻擊力直到回合結束。", 
            Rarity.RARE, 3, Faction.NEUTRAL);
        allCards.put(spiceMarket.getName(), spiceMarket);
        allFieldCards.add(spiceMarket);

        FieldCard rootCellar = FieldCard.createEnvironmentField(
            "根莖地窖", 3, "每當一個友方角色死亡時，抽一張牌。", 
            Rarity.COMMON, 2, Faction.NEUTRAL);
        allCards.put(rootCellar.getName(), rootCellar);
        allFieldCards.add(rootCellar);

        FieldCard beanField = FieldCard.createEnvironmentField(
            "豆田", 2, "每當你打出一個角色時，使其獲得【彈牙】效果。", 
            Rarity.RARE, 1, Faction.NEUTRAL);
        allCards.put(beanField.getName(), beanField);
        allFieldCards.add(beanField);

        FieldCard ancientGarden = FieldCard.createEnvironmentField(
            "古老花園", 5, "每回合結束時，使所有友方角色獲得+1/+1。", 
            Rarity.LEGENDARY, 4, Faction.NEUTRAL);
        allCards.put(ancientGarden.getName(), ancientGarden);
        allFieldCards.add(ancientGarden);

        FieldCard sacredGrove = FieldCard.createEnvironmentField(
            "神聖樹林", 4, "每當你使用一張法術卡時，為所有友方角色恢復1點生命值。", 
            Rarity.LEGENDARY, 3, Faction.NEUTRAL);
        allCards.put(sacredGrove.getName(), sacredGrove);
        allFieldCards.add(sacredGrove);
    }
    
    @Override
    public String getFactionName() {
        return "中立";
    }
} 