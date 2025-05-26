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
            "玉米大地守衛 (Corn Earth Guardian)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.NEUTRAL, 1);
        allCards.put(cornKnight.getName(), cornKnight);
        allCharacters.add(cornKnight);

        CharacterCard potatoGuardian = new CharacterCard(
            "馬鈴薯土脈戰士 (Potato Soil Vein Warrior)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(potatoGuardian.getName(), potatoGuardian);
        allCharacters.add(potatoGuardian);

        CharacterCard carrotArcher = new CharacterCard(
            "胡蘿蔔地核祭司 (Carrot Earth Core Priest)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.NEUTRAL, 1);
        allCards.put(carrotArcher.getName(), carrotArcher);
        allCharacters.add(carrotArcher);

        CharacterCard radishScout = new CharacterCard(
            "蘿蔔大地衛士 (Radish Earth Sentinel)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.NEUTRAL, 1);
        allCards.put(radishScout.getName(), radishScout);
        allCharacters.add(radishScout);

        CharacterCard sweetPotatoMage = new CharacterCard(
            "地瓜根系掘者 (Sweet Potato Root Digger)", 4, "【開胃】：使一個友方角色獲得+0/+3。【根系】：每當有友方角色受到傷害時，為其恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(sweetPotatoMage.getName(), sweetPotatoMage);
        allCharacters.add(sweetPotatoMage);

        CharacterCard taroWarrior = new CharacterCard(
            "芋頭土元素統御者 (Taro Earth Elemental Commander)", 4, "【擺盤】：敵人必須優先攻擊這個單位。【土元素】：場上每有一個根莖類角色，就獲得+0/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(taroWarrior.getName(), taroWarrior);
        allCharacters.add(taroWarrior);

        CharacterCard gingerMage = new CharacterCard(
            "薑根大地魔導師 (Ginger Earth Archmage)", 3, "【開胃】：為一個友方角色恢復2點生命值。【薑根強化】：每當你恢復生命值時，獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(gingerMage.getName(), gingerMage);
        allCharacters.add(gingerMage);

        CharacterCard yamPriest = new CharacterCard(
            "山藥大地祭司 (Yam Earth Priest)", 5, "【開胃】：為所有友方角色恢復1點生命值。【酥脆(1)】：減免1點傷害。【回味】：死亡時使所有友方角色獲得+0/+2。", 
            Rarity.ULTIMATE_TASTE, 3, 5, false, Faction.NEUTRAL, 5);
        allCards.put(yamPriest.getName(), yamPriest);
        allCharacters.add(yamPriest);

        CharacterCard burdockKnight = new CharacterCard(
            "牛蒡大地騎士 (Burdock Earth Knight)", 4, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(burdockKnight.getName(), burdockKnight);
        allCharacters.add(burdockKnight);

        // 豆類食材
        CharacterCard soyWarrior = new CharacterCard(
            "黃豆風行使者 (Soybean Wind Messenger)", 2, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(soyWarrior.getName(), soyWarrior);
        allCharacters.add(soyWarrior);

        CharacterCard redBeanMage = new CharacterCard(
            "紅豆翱翔斥候 (Red Bean Soaring Scout)", 3, "【開胃】：抽一張牌。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(redBeanMage.getName(), redBeanMage);
        allCharacters.add(redBeanMage);

        CharacterCard mungBeanScout = new CharacterCard(
            "綠豆彈射師 (Mung Bean Projectile Master)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(mungBeanScout.getName(), mungBeanScout);
        allCharacters.add(mungBeanScout);

        CharacterCard chickpeaArcher = new CharacterCard(
            "鷹嘴豆氣旋射手 (Chickpea Air Vortex Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(chickpeaArcher.getName(), chickpeaArcher);
        allCharacters.add(chickpeaArcher);

        CharacterCard blackBeanNinja = new CharacterCard(
            "黑豆氣流騎士 (Black Bean Air Current Knight)", 3, "【酥脆(1)】：減免1點傷害。【風馳電掣】：攻擊時，敵方角色無法反擊。", 
            Rarity.GOURMET_DELIGHT, 3, 2, true, Faction.NEUTRAL, 3);
        allCards.put(blackBeanNinja.getName(), blackBeanNinja);
        allCharacters.add(blackBeanNinja);

        CharacterCard kidneyBeanGuard = new CharacterCard(
            "腰豆風翼守衛 (Kidney Bean Wind Wing Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。【風翼】：每當敵方角色攻擊時，有30%機率使其攻擊力-1。", 
            Rarity.GOURMET_DELIGHT, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(kidneyBeanGuard.getName(), kidneyBeanGuard);
        allCharacters.add(kidneyBeanGuard);

        CharacterCard lentilWarrior = new CharacterCard(
            "扁豆疾風劍士 (Lentil Swift Wind Swordsman)", 4, "【現炸】：可以在出場的回合立即攻擊。【疾風】：每回合第一次攻擊後，獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(lentilWarrior.getName(), lentilWarrior);
        allCharacters.add(lentilWarrior);

        CharacterCard peaPriest = new CharacterCard(
            "豌豆風潮祭司 (Pea Wind Tide Priest)", 4, "【開胃】：使所有友方角色獲得【彈牙】效果直到回合結束。【風潮】：每回合結束時，使所有友方豆類角色獲得+1/+0。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(peaPriest.getName(), peaPriest);
        allCharacters.add(peaPriest);

        CharacterCard broadBeanKnight = new CharacterCard(
            "蠶豆風暴騎士 (Broad Bean Storm Knight)", 5, "【開胃】：對所有敵方角色造成1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CULINARY_HERITAGE, 4, 4, false, Faction.NEUTRAL, 4);
        allCards.put(broadBeanKnight.getName(), broadBeanKnight);
        allCharacters.add(broadBeanKnight);

        CharacterCard adzukiBeanMage = new CharacterCard(
            "紅豆颶風魔導師 (Adzuki Bean Hurricane Archmage)", 4, "【開胃】：對所有敵方單位造成1點傷害。【彈牙】：每回合可攻擊2次。【回味】：死亡時抽兩張牌。", 
            Rarity.ULTIMATE_TASTE, 4, 4, false, Faction.NEUTRAL, 5);
        allCards.put(adzukiBeanMage.getName(), adzukiBeanMage);
        allCharacters.add(adzukiBeanMage);

        // 葉菜類食材
        CharacterCard spinachPaladin = new CharacterCard(
            "菠菜生機祭司 (Spinach Vitality Priest)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：為所有友方角色恢復2點生命值。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.ULTIMATE_TASTE, 3, 6, false, Faction.NEUTRAL, 5);
        allCards.put(spinachPaladin.getName(), spinachPaladin);
        allCharacters.add(spinachPaladin);

        CharacterCard lettuceRogue = new CharacterCard(
            "生菜綠葉賢者 (Lettuce Green Leaf Sage)", 2, "【開胃】：為一個友方角色恢復1點生命值。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(lettuceRogue.getName(), lettuceRogue);
        allCharacters.add(lettuceRogue);

        CharacterCard cabbageGuard = new CharacterCard(
            "高麗菜光合巫師 (Cabbage Photosynthesis Wizard)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.NEUTRAL, 2);
        allCards.put(cabbageGuard.getName(), cabbageGuard);
        allCharacters.add(cabbageGuard);

        CharacterCard celeryArcher = new CharacterCard(
            "芹菜自然德魯伊 (Celery Natural Druid)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(celeryArcher.getName(), celeryArcher);
        allCharacters.add(celeryArcher);

        CharacterCard kaleWarrior = new CharacterCard(
            "羽衣甘藍生機導師 (Kale Vitality Mentor)", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使所有友方角色獲得+0/+2。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(kaleWarrior.getName(), kaleWarrior);
        allCharacters.add(kaleWarrior);

        CharacterCard bokChoyMage = new CharacterCard(
            "青江菜綠意治療師 (Bok Choy Green Essence Healer)", 3, "【開胃】：為一個友方角色恢復2點生命值。【滋養】：每回合結束時，為生命值最低的友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(bokChoyMage.getName(), bokChoyMage);
        allCharacters.add(bokChoyMage);

        CharacterCard watercressScout = new CharacterCard(
            "西洋菜復甦使者 (Watercress Revival Envoy)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(watercressScout.getName(), watercressScout);
        allCharacters.add(watercressScout);

        CharacterCard arugulaPriest = new CharacterCard(
            "芝麻菜生機祝福者 (Arugula Vitality Blesser)", 4, "【開胃】：為所有友方角色恢復1點生命值。【生機共鳴】：每當你恢復生命值時，抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(arugulaPriest.getName(), arugulaPriest);
        allCharacters.add(arugulaPriest);

        CharacterCard mustardKnight = new CharacterCard(
            "芥菜生命守護騎士 (Mustard Life Protection Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 5, false, Faction.NEUTRAL, 4);
        allCards.put(mustardKnight.getName(), mustardKnight);
        allCharacters.add(mustardKnight);

        CharacterCard chardMage = new CharacterCard(
            "甜菜自然魔導師 (Swiss Chard Nature Archmage)", 4, "【開胃】：為所有友方角色恢復1點生命值。【自然共生】：每當一個友方角色恢復生命值時，使其獲得+1/+1直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(chardMage.getName(), chardMage);
        allCharacters.add(chardMage);

        // 瓜果類食材
        CharacterCard pumpkinGiant = new CharacterCard(
            "南瓜水潮法師 (Pumpkin Water Tide Mage)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 6, false, Faction.NEUTRAL, 4);
        allCards.put(pumpkinGiant.getName(), pumpkinGiant);
        allCharacters.add(pumpkinGiant);

        CharacterCard cucumberArcher = new CharacterCard(
            "黃瓜汁液射手 (Cucumber Juice Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(cucumberArcher.getName(), cucumberArcher);
        allCharacters.add(cucumberArcher);

        CharacterCard watermelonGuard = new CharacterCard(
            "西瓜潮汐操控師 (Watermelon Tide Controller)", 6, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：使所有敵方角色費用+1直到回合結束。【酥脆(1)】：減免1點傷害。", 
            Rarity.ULTIMATE_TASTE, 3, 7, false, Faction.NEUTRAL, 5);
        allCards.put(watermelonGuard.getName(), watermelonGuard);
        allCharacters.add(watermelonGuard);

        CharacterCard cantaloupeWarrior = new CharacterCard(
            "哈密瓜漿流術士 (Cantaloupe Fluid Sorcerer)", 4, "【開胃】：使一個敵方角色無法攻擊直到回合結束。【漿流】：敵方角色費用+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(cantaloupeWarrior.getName(), cantaloupeWarrior);
        allCharacters.add(cantaloupeWarrior);

        CharacterCard honeydewMage = new CharacterCard(
            "蜜瓜水靈法師 (Honeydew Water Spirit Mage)", 3, "【開胃】：為一個友方角色恢復2點生命值。【水靈】：敵方法術費用+1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(honeydewMage.getName(), honeydewMage);
        allCharacters.add(honeydewMage);

        CharacterCard bitterGourdScout = new CharacterCard(
            "苦瓜水脈斥候 (Bitter Gourd Water Vein Scout)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(bitterGourdScout.getName(), bitterGourdScout);
        allCharacters.add(bitterGourdScout);

        CharacterCard winterMelonPriest = new CharacterCard(
            "冬瓜潮汐祭司 (Winter Melon Tide Priest)", 4, "【開胃】：對所有敵方角色造成1點傷害。【霜凍】：每回合結束時，隨機凍結一個敵方角色直到對手的下個回合結束。", 
            Rarity.GOURMET_DELIGHT, 2, 4, false, Faction.NEUTRAL, 3);
        allCards.put(winterMelonPriest.getName(), winterMelonPriest);
        allCharacters.add(winterMelonPriest);

        CharacterCard luffaKnight = new CharacterCard(
            "絲瓜水旋騎士 (Luffa Water Vortex Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【水旋】：敵方角色進場時，使其費用+1直到對手回合結束。", 
            Rarity.GOURMET_DELIGHT, 4, 4, false, Faction.NEUTRAL, 3);
        allCards.put(luffaKnight.getName(), luffaKnight);
        allCharacters.add(luffaKnight);

        CharacterCard bottleGourdMage = new CharacterCard(
            "葫蘆水源魔導師 (Bottle Gourd Water Source Archmage)", 4, "【開胃】：召喚一個水幕，使所有友方角色獲得【酥脆(1)】效果1回合。【水源】：每回合結束時，隨機使一個敵方角色攻擊力歸零直到對手回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(bottleGourdMage.getName(), bottleGourdMage);
        allCharacters.add(bottleGourdMage);

        CharacterCard snakeGourdArcher = new CharacterCard(
            "蛇瓜水箭射手 (Snake Gourd Water Arrow Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 1);
        allCards.put(snakeGourdArcher.getName(), snakeGourdArcher);
        allCharacters.add(snakeGourdArcher);

        // 菇類食材
        CharacterCard enokiMage = new CharacterCard(
            "金針菇幻象賢者 (Enoki Illusion Sage)", 3, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(enokiMage.getName(), enokiMage);
        allCharacters.add(enokiMage);

        CharacterCard shiitakeGuard = new CharacterCard(
            "香菇孢子守護者 (Shiitake Spore Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.NEUTRAL, 2);
        allCards.put(shiitakeGuard.getName(), shiitakeGuard);
        allCharacters.add(shiitakeGuard);

        CharacterCard oysterMushroomArcher = new CharacterCard(
            "蠔菇暗殺射手 (Oyster Mushroom Assassination Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(oysterMushroomArcher.getName(), oysterMushroomArcher);
        allCharacters.add(oysterMushroomArcher);

        CharacterCard mushroomShaman = new CharacterCard(
            "香菇暗影術士 (Shiitake Shadow Arcanist)", 4, "【開胃】：使一個敵方角色-2/-0直到回合結束。【暗影掌控】：每回合開始時，隨機使一個敵方角色無法攻擊1回合。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(mushroomShaman.getName(), mushroomShaman);
        allCharacters.add(mushroomShaman);

        CharacterCard kingOysterWarrior = new CharacterCard(
            "杏鮑菇菌絲劍士 (King Oyster Mycelium Swordsman)", 4, "【開胃】：獲得+2/+2直到回合結束。【菌絲網絡】：每當敵方角色進場時，使其-1/-1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(kingOysterWarrior.getName(), kingOysterWarrior);
        allCharacters.add(kingOysterWarrior);

        CharacterCard woodEarMage = new CharacterCard(
            "木耳暗夜法師 (Wood Ear Dark Night Mage)", 3, "【開胃】：使一個敵方角色無法攻擊直到回合結束。【暗夜】：夜晚時，所有菇類角色+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(woodEarMage.getName(), woodEarMage);
        allCharacters.add(woodEarMage);

        CharacterCard cloudEarScout = new CharacterCard(
            "雲耳陰影斥候 (Cloud Ear Shadow Scout)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(cloudEarScout.getName(), cloudEarScout);
        allCharacters.add(cloudEarScout);

        CharacterCard reishiPriest = new CharacterCard(
            "靈芝暗幕祭司 (Reishi Dark Veil Priest)", 4, "【開胃】：對所有敵方角色造成1點傷害。【暗幕】：敵方法術費用+1。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(reishiPriest.getName(), reishiPriest);
        allCharacters.add(reishiPriest);

        CharacterCard lionManeKnight = new CharacterCard(
            "猴頭菇幻影騎士 (Lion's Mane Phantom Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：召喚一個2/2的幻影複製。", 
            Rarity.CULINARY_HERITAGE, 4, 4, false, Faction.NEUTRAL, 4);
        allCards.put(lionManeKnight.getName(), lionManeKnight);
        allCharacters.add(lionManeKnight);

        CharacterCard cordycepsMage = new CharacterCard(
            "蟲草暗黑魔導師 (Cordyceps Dark Archmage)", 6, "【開胃】：使一個敵方角色-2/-2直到回合結束。【彈牙】：每回合可攻擊2次。【回味】：死亡時隨機使一個敵方角色無法攻擊1回合。", 
            Rarity.ULTIMATE_TASTE, 4, 4, false, Faction.NEUTRAL, 5);
        allCards.put(cordycepsMage.getName(), cordycepsMage);
        allCharacters.add(cordycepsMage);

        // 香料類食材
        CharacterCard blackPepperWarrior = new CharacterCard(
            "黑胡椒烈焰狂戰 (Black Pepper Flame Berserker)", 2, "【烈焰】：每回合攻擊時，攻擊力+1。", 
            Rarity.CASUAL_BITES, 3, 1, true, Faction.NEUTRAL, 1);
        allCards.put(blackPepperWarrior.getName(), blackPepperWarrior);
        allCharacters.add(blackPepperWarrior);

        CharacterCard whitePepperArcher = new CharacterCard(
            "白胡椒辛香刺客 (White Pepper Spicy Assassin)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(whitePepperArcher.getName(), whitePepperArcher);
        allCharacters.add(whitePepperArcher);

        CharacterCard cinnamonGuard = new CharacterCard(
            "肉桂燃燒守衛 (Cinnamon Burning Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.NEUTRAL, 2);
        allCards.put(cinnamonGuard.getName(), cinnamonGuard);
        allCharacters.add(cinnamonGuard);

        CharacterCard cuminMage = new CharacterCard(
            "孜然味覺操控師 (Cumin Taste Controller)", 3, "【開胃】：使所有友方角色獲得+1/+0直到回合結束。【味覺操控】：敵方角色攻擊力-1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(cuminMage.getName(), cuminMage);
        allCharacters.add(cuminMage);

        CharacterCard starAniseKnight = new CharacterCard(
            "八角烈火騎士 (Star Anise Raging Fire Knight)", 4, "【酥脆(2)】：減免2點傷害。【開胃】：對目標和相鄰單位造成1點傷害。", 
            Rarity.CULINARY_HERITAGE, 4, 3, false, Faction.NEUTRAL, 4);
        allCards.put(starAniseKnight.getName(), starAniseKnight);
        allCharacters.add(starAniseKnight);

        CharacterCard mustardAssassin = new CharacterCard(
            "芥末燃燒領主 (Mustard Burning Lord)", 3, "【突刺】：每回合第一次攻擊時，攻擊力+2。【燃燒領域】：每回合開始時，對所有敵方角色造成1點傷害。", 
            Rarity.GOURMET_DELIGHT, 4, 1, true, Faction.NEUTRAL, 3);
        allCards.put(mustardAssassin.getName(), mustardAssassin);
        allCharacters.add(mustardAssassin);

        CharacterCard turmericPriest = new CharacterCard(
            "薑黃炙熱祭司 (Turmeric Scorching Priest)", 4, "【滋補】：回合結束時恢復2點生命值。【炙熱】：每回合結束時，使所有友方角色獲得+1/+0直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(turmericPriest.getName(), turmericPriest);
        allCharacters.add(turmericPriest);

        CharacterCard basilMonk = new CharacterCard(
            "羅勒火舌修行者 (Basil Fire Tongue Monk)", 3, "【現炸】：可以在出場的回合立即攻擊。【火舌】：攻擊後，目標下回合攻擊力-1。", 
            Rarity.GOURMET_DELIGHT, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(basilMonk.getName(), basilMonk);
        allCharacters.add(basilMonk);

        CharacterCard herbMaster = new CharacterCard(
            "香草灼燒大師 (Herb Searing Master)", 6, "【開胃】：對所有敵方角色造成2點傷害。【彈牙】：每回合可攻擊2次。【回味】：死亡時對所有敵方角色造成1點傷害。", 
            Rarity.ULTIMATE_TASTE, 5, 4, false, Faction.NEUTRAL, 5);
        allCards.put(herbMaster.getName(), herbMaster);
        allCharacters.add(herbMaster);

        // 為各類食材添加無特性角色

        // 根莖類無特性角色
        CharacterCard plainRootVegetable = new CharacterCard(
            "紅蘿蔔大地見習生 (Carrot Earth Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(plainRootVegetable.getName(), plainRootVegetable);
        allCharacters.add(plainRootVegetable);
        
        CharacterCard plainPotato = new CharacterCard(
            "小馬鈴薯土脈學徒 (Small Potato Soil Vein Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(plainPotato.getName(), plainPotato);
        allCharacters.add(plainPotato);
        
        CharacterCard plainYam = new CharacterCard(
            "山藥根系戰士 (Yam Root System Warrior)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 3, false, Faction.NEUTRAL, 2);
        allCards.put(plainYam.getName(), plainYam);
        allCharacters.add(plainYam);
        
        CharacterCard plainTaro = new CharacterCard(
            "芋頭大地衛兵 (Taro Earth Guard)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, false, Faction.NEUTRAL, 2);
        allCards.put(plainTaro.getName(), plainTaro);
        allCharacters.add(plainTaro);
        
        CharacterCard plainBurdock = new CharacterCard(
            "牛蒡大地將軍 (Burdock Earth General)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 5, 5, false, Faction.NEUTRAL, 4);
        allCards.put(plainBurdock.getName(), plainBurdock);
        allCharacters.add(plainBurdock);

        // 豆類無特性角色
        CharacterCard plainBean = new CharacterCard(
            "豆芽風行學徒 (Bean Sprout Wind Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, true, Faction.NEUTRAL, 1);
        allCards.put(plainBean.getName(), plainBean);
        allCharacters.add(plainBean);
        
        CharacterCard plainPea = new CharacterCard(
            "豌豆氣流砲兵 (Green Pea Air Current Cannoneer)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 0, true, Faction.NEUTRAL, 1);
        allCards.put(plainPea.getName(), plainPea);
        allCharacters.add(plainPea);
        
        CharacterCard plainSoybean = new CharacterCard(
            "黃豆風盾守衛 (Soybean Wind Shield Guardian)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 3, false, Faction.NEUTRAL, 1);
        allCards.put(plainSoybean.getName(), plainSoybean);
        allCharacters.add(plainSoybean);
        
        CharacterCard plainLentil = new CharacterCard(
            "扁豆疾風勇士 (Lentil Swift Wind Fighter)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.NEUTRAL, 2);
        allCards.put(plainLentil.getName(), plainLentil);
        allCharacters.add(plainLentil);
        
        CharacterCard plainBroadBean = new CharacterCard(
            "蠶豆風暴將軍 (Broad Bean Storm General)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 4, 6, false, Faction.NEUTRAL, 3);
        allCards.put(plainBroadBean.getName(), plainBroadBean);
        allCharacters.add(plainBroadBean);

        // 香料類無特性角色
        CharacterCard plainVanilla = new CharacterCard(
            "香草烈焰學徒 (Vanilla Flame Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(plainVanilla.getName(), plainVanilla);
        allCharacters.add(plainVanilla);
        
        CharacterCard plainGarlic = new CharacterCard(
            "大蒜灼熱哨兵 (Garlic Scorching Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(plainGarlic.getName(), plainGarlic);
        allCharacters.add(plainGarlic);
        
        CharacterCard plainGinger = new CharacterCard(
            "老薑火焰長者 (Ginger Flame Elder)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(plainGinger.getName(), plainGinger);
        allCharacters.add(plainGinger);
        
        CharacterCard plainCinnamon = new CharacterCard(
            "肉桂燃燒戰士 (Cinnamon Burning Warrior)", 3, "無特性", 
            Rarity.CASUAL_BITES, 4, 2, true, Faction.NEUTRAL, 2);
        allCards.put(plainCinnamon.getName(), plainCinnamon);
        allCharacters.add(plainCinnamon);
        
        CharacterCard plainStarAnise = new CharacterCard(
            "八角烈火大使 (Star Anise Fierce Fire Ambassador)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 5, 5, true, Faction.NEUTRAL, 3);
        allCards.put(plainStarAnise.getName(), plainStarAnise);
        allCharacters.add(plainStarAnise);

        // 葉菜類無特性角色
        CharacterCard plainLettuce = new CharacterCard(
            "小生菜綠葉見習生 (Small Lettuce Green Leaf Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, true, Faction.NEUTRAL, 1);
        allCards.put(plainLettuce.getName(), plainLettuce);
        allCharacters.add(plainLettuce);
        
        CharacterCard plainSpinach = new CharacterCard(
            "嫩菠菜生機學徒 (Tender Spinach Vitality Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(plainSpinach.getName(), plainSpinach);
        allCharacters.add(plainSpinach);
        
        CharacterCard plainCabbage = new CharacterCard(
            "高麗菜光合戰士 (Cabbage Photosynthesis Warrior)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(plainCabbage.getName(), plainCabbage);
        allCharacters.add(plainCabbage);
        
        CharacterCard plainKale = new CharacterCard(
            "羽衣甘藍生命衛士 (Kale Life Sentinel)", 3, "無特性", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.NEUTRAL, 2);
        allCards.put(plainKale.getName(), plainKale);
        allCharacters.add(plainKale);
        
        CharacterCard plainChard = new CharacterCard(
            "瑞士甜菜自然將軍 (Swiss Chard Nature General)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 3, 6, false, Faction.NEUTRAL, 3);
        allCards.put(plainChard.getName(), plainChard);
        allCharacters.add(plainChard);

        // 瓜果類無特性角色
        CharacterCard plainCucumber = new CharacterCard(
            "小黃瓜汁液學徒 (Small Cucumber Juice Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(plainCucumber.getName(), plainCucumber);
        allCharacters.add(plainCucumber);
        
        CharacterCard plainBitterGourd = new CharacterCard(
            "苦瓜水脈哨兵 (Bitter Gourd Water Vein Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, false, Faction.NEUTRAL, 1);
        allCards.put(plainBitterGourd.getName(), plainBitterGourd);
        allCharacters.add(plainBitterGourd);
        
        CharacterCard plainPumpkin = new CharacterCard(
            "南瓜水潮守衛 (Pumpkin Water Tide Guard)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(plainPumpkin.getName(), plainPumpkin);
        allCharacters.add(plainPumpkin);
        
        CharacterCard plainWatermelon = new CharacterCard(
            "西瓜潮汐戰士 (Watermelon Tide Warrior)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, false, Faction.NEUTRAL, 2);
        allCards.put(plainWatermelon.getName(), plainWatermelon);
        allCharacters.add(plainWatermelon);
        
        CharacterCard plainMelon = new CharacterCard(
            "哈密瓜水源將軍 (Cantaloupe Water Source General)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 4, 5, false, Faction.NEUTRAL, 3);
        allCards.put(plainMelon.getName(), plainMelon);
        allCharacters.add(plainMelon);

        // 菇類無特性角色
        CharacterCard plainEnoki = new CharacterCard(
            "金針菇幻影見習生 (Enoki Phantom Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, true, Faction.NEUTRAL, 1);
        allCards.put(plainEnoki.getName(), plainEnoki);
        allCharacters.add(plainEnoki);
        
        CharacterCard plainShiitake = new CharacterCard(
            "香菇暗影哨兵 (Shiitake Shadow Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, false, Faction.NEUTRAL, 1);
        allCards.put(plainShiitake.getName(), plainShiitake);
        allCharacters.add(plainShiitake);
        
        CharacterCard plainOyster = new CharacterCard(
            "蠔菇菌絲戰士 (Oyster Mushroom Mycelium Warrior)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(plainOyster.getName(), plainOyster);
        allCharacters.add(plainOyster);
        
        CharacterCard plainWoodEar = new CharacterCard(
            "木耳暗夜哨衛 (Wood Ear Dark Night Guard)", 3, "無特性", 
            Rarity.CASUAL_BITES, 2, 3, false, Faction.NEUTRAL, 2);
        allCards.put(plainWoodEar.getName(), plainWoodEar);
        allCharacters.add(plainWoodEar);
        
        CharacterCard plainReishi = new CharacterCard(
            "靈芝暗幕將軍 (Reishi Dark Veil General)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 3, 6, false, Faction.NEUTRAL, 3);
        allCards.put(plainReishi.getName(), plainReishi);
        allCharacters.add(plainReishi);

        // 城牆回血法術
        SpellCard wallRepair = new SpellCard(
            "城牆磚縫修復術 (Wall Crevice Restoration)", 2, "為一個城牆恢復3點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, 1);
        allCards.put(wallRepair.getName(), wallRepair);
        allSpells.add(wallRepair);

        SpellCard emergencyRepair = new SpellCard(
            "緊急防禦重建 (Emergency Defense Reconstruction)", 4, "為所有城牆恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, 3);
        allCards.put(emergencyRepair.getName(), emergencyRepair);
        allSpells.add(emergencyRepair);

        SpellCard masterRepair = new SpellCard(
            "大師級結構重鑄 (Master Structural Reforging)", 6, "為一個城牆恢復5點生命值。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, 4);
        allCards.put(masterRepair.getName(), masterRepair);
        allSpells.add(masterRepair);

        SpellCard divineHealing = new SpellCard(
            "神聖防線祝福 (Divine Frontline Blessing)", 8, "為所有城牆恢復4點生命值。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, 5);
        allCards.put(divineHealing.getName(), divineHealing);
        allSpells.add(divineHealing);
        
        // 角色移動法術
        SpellCard quickTransfer = new SpellCard(
            "快速戰術調動 (Rapid Tactical Redeployment)", 2, "將一個友方角色移動到另一個城牆。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, 1);
        allCards.put(quickTransfer.getName(), quickTransfer);
        allSpells.add(quickTransfer);

        SpellCard massTransfer = new SpellCard(
            "群體兵力轉移 (Mass Force Relocation)", 4, "將兩個友方角色移動到另一個城牆。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 3);
        allCards.put(massTransfer.getName(), massTransfer);
        allSpells.add(massTransfer);

        SpellCard emergencyEvacuation = new SpellCard(
            "緊急撤退強化 (Emergency Retreat Enhancement)", 3, "將一個友方角色移動到另一個城牆，並使其獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 2);
        allCards.put(emergencyEvacuation.getName(), emergencyEvacuation);
        allSpells.add(emergencyEvacuation);

        SpellCard strategicRetreat = new SpellCard(
            "戰略全面撤退 (Strategic Complete Withdrawal)", 5, "將所有友方角色移動到另一個城牆。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 4);
        allCards.put(strategicRetreat.getName(), strategicRetreat);
        allSpells.add(strategicRetreat);

        // 其他輔助法術
        SpellCard foodSupply = new SpellCard(
            "根莖能量補給 (Root Vegetable Energy Supply)", 2, "抽一張牌。根莖類連動：如果你控制至少一個根莖類角色，則再抽一張牌。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, 1);
        allCards.put(foodSupply.getName(), foodSupply);
        allSpells.add(foodSupply);

        SpellCard foodStorage = new SpellCard(
            "菇類養分儲藏 (Mushroom Nutrient Storage)", 4, "抽三張牌。菇類連動：如果你控制至少一個菇類角色，則使其獲得+0/+2。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, 3);
        allCards.put(foodStorage.getName(), foodStorage);
        allSpells.add(foodStorage);

        SpellCard foodPreservation = new SpellCard(
            "葉菜鮮度保存 (Leafy Vegetable Freshness Preservation)", 2, "使一個友方角色獲得+1/+1直到回合結束。葉菜類連動：如果目標是葉菜類角色，則效果變為+2/+2。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(foodPreservation.getName(), foodPreservation);
        allSpells.add(foodPreservation);

        SpellCard foodEnhancement = new SpellCard(
            "香料風味強化 (Spice Flavor Enhancement)", 3, "使一個友方角色獲得+2/+2直到回合結束。香料類連動：如果你控制至少一個香料類角色，則使所有友方角色獲得+1/+0。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 2);
        allCards.put(foodEnhancement.getName(), foodEnhancement);
        allSpells.add(foodEnhancement);

        SpellCard foodBlessing = new SpellCard(
            "瓜果甜蜜祝福 (Gourd Sweet Blessing)", 4, "使所有友方角色獲得+1/+1直到回合結束。瓜果類連動：如果你控制至少一個瓜果類角色，則額外獲得【彈牙】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 3);
        allCards.put(foodBlessing.getName(), foodBlessing);
        allSpells.add(foodBlessing);

        SpellCard foodCurse = new SpellCard(
            "根莖纏繞詛咒 (Root Entanglement Curse)", 3, "使一個敵方角色獲得-1/-1直到回合結束。根莖類連動：如果你控制至少一個根莖類角色，則目標角色無法攻擊下回合。", 
            Rarity.CASUAL_BITES, SpellType.DEBUFF, 1);
        allCards.put(foodCurse.getName(), foodCurse);
        allSpells.add(foodCurse);

        SpellCard foodPoison = new SpellCard(
            "菇類孢子中毒 (Mushroom Spore Poisoning)", 4, "使一個敵方角色獲得-2/-2直到回合結束。菇類連動：如果你控制至少一個菇類角色，則目標角色每回合開始時受到1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, 2);
        allCards.put(foodPoison.getName(), foodPoison);
        allSpells.add(foodPoison);

        SpellCard foodPlague = new SpellCard(
            "豆類寄生瘟疫 (Bean Parasitic Plague)", 5, "使所有敵方角色獲得-1/-1直到回合結束。豆類連動：如果你控制至少一個豆類角色，則敵方角色費用+1回合。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, 3);
        allCards.put(foodPlague.getName(), foodPlague);
        allSpells.add(foodPlague);

        SpellCard foodMiracle = new SpellCard(
            "葉菜再生奇蹟 (Leafy Vegetable Regeneration Miracle)", 6, "使一個友方角色獲得+3/+3直到回合結束。葉菜類連動：如果你控制至少一個葉菜類角色，則目標角色獲得【酥脆(2)】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 4);
        allCards.put(foodMiracle.getName(), foodMiracle);
        allSpells.add(foodMiracle);

        SpellCard foodApocalypse = new SpellCard(
            "香料灼燒末日 (Spice Scorching Apocalypse)", 7, "使所有敵方角色獲得-2/-2直到回合結束。香料類連動：如果你控制至少一個香料類角色，則所有敵方角色失去其特殊能力。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, 5);
        allCards.put(foodApocalypse.getName(), foodApocalypse);
        allSpells.add(foodApocalypse);

        // 特殊法術卡
        SpellCard chefBlessing = new SpellCard(
            "廚神全能祝福 (Chef's Omnipotent Blessing)", 5, "計算場上你控制的不同食材類別數量。效果隨數量增強：1類-抽1張牌；2類-為所有友方角色恢復2點生命值；3類-所有友方角色獲得+1/+1；4類-對所有敵方角色造成2點傷害；5類-隨機召喚一個費用為3的角色；6類-你獲得一個額外的回合。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 4);
        allCards.put(chefBlessing.getName(), chefBlessing);
        allSpells.add(chefBlessing);

        // 添加新的連動法術
        SpellCard beanProtection = new SpellCard(
            "豆類蛋白護盾 (Bean Protein Shield)", 2, "使一個友方角色獲得【酥脆(1)】效果。豆類連動：如果目標是豆類角色，則改為獲得【酥脆(2)】效果並抽一張牌。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(beanProtection.getName(), beanProtection);
        allSpells.add(beanProtection);
        
        SpellCard rootVegetableGrowth = new SpellCard(
            "根莖快速生長 (Root Vegetable Rapid Growth)", 3, "召喚一個1/2的根莖類食材代幣。根莖類連動：如果你控制至少兩個根莖類角色，則改為召喚一個2/3的代幣。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, 2);
        allCards.put(rootVegetableGrowth.getName(), rootVegetableGrowth);
        allSpells.add(rootVegetableGrowth);
        
        SpellCard leafyRegeneration = new SpellCard(
            "葉菜光合修復 (Leafy Vegetable Photosynthesis Repair)", 3, "為所有友方角色恢復1點生命值。葉菜類連動：如果你控制至少一個葉菜類角色，則改為恢復2點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, 2);
        allCards.put(leafyRegeneration.getName(), leafyRegeneration);
        allSpells.add(leafyRegeneration);
        
        SpellCard fruitEnergy = new SpellCard(
            "瓜果糖分爆發 (Gourd Sugar Burst)", 3, "使一個友方角色獲得+2攻擊力並可以額外攻擊一次。瓜果類連動：如果目標是瓜果類角色，則效果持續到下回合。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 2);
        allCards.put(fruitEnergy.getName(), fruitEnergy);
        allSpells.add(fruitEnergy);
        
        SpellCard mushroomSpores = new SpellCard(
            "菇類孢子繁殖 (Mushroom Spore Propagation)", 4, "召喚兩個1/1菇類食材代幣。菇類連動：如果你控制至少一個菇類角色，則使這些代幣獲得【回味】：死亡時抽一張牌。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 3);
        allCards.put(mushroomSpores.getName(), mushroomSpores);
        allSpells.add(mushroomSpores);
        
        SpellCard spicyFlavor = new SpellCard(
            "香料火辣風味 (Spicy Hot Flavor)", 2, "使一個友方角色獲得【現炸】效果。香料類連動：如果你控制至少一個香料類角色，則使目標角色獲得+2/+0。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(spicyFlavor.getName(), spicyFlavor);
        allSpells.add(spicyFlavor);

        // 場地卡
        FieldCard vegetableGarden = FieldCard.createEnvironmentField(
            "生命蔬菜綠園 (Vital Vegetable Green Garden)", 2, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.CASUAL_BITES, 1, Faction.NEUTRAL, 2);
        allCards.put(vegetableGarden.getName(), vegetableGarden);
        allFieldCards.add(vegetableGarden);

        FieldCard fruitOrchard = FieldCard.createEnvironmentField(
            "多汁水果果園 (Juicy Fruit Orchard)", 3, "每當你打出一個角色時，使其獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.NEUTRAL, 3);
        allCards.put(fruitOrchard.getName(), fruitOrchard);
        allFieldCards.add(fruitOrchard);

        FieldCard mushroomForest = FieldCard.createEnvironmentField(
            "神祕菇菇幻森 (Mystic Mushroom Fantasy Forest)", 4, "每回合開始時，隨機使一個友方角色獲得【酥脆(1)】效果。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(mushroomForest.getName(), mushroomForest);
        allFieldCards.add(mushroomForest);

        FieldCard grainField = FieldCard.createEnvironmentField(
            "金黃麥穗豐田 (Golden Wheat Abundant Field)", 2, "每當你使用一張法術卡時，抽一張牌。", 
            Rarity.CASUAL_BITES, 1, Faction.NEUTRAL, 1);
        allCards.put(grainField.getName(), grainField);
        allFieldCards.add(grainField);

        FieldCard herbGarden = FieldCard.createEnvironmentField(
            "芳香香草療園 (Aromatic Herb Healing Garden)", 3, "每當一個友方角色受到傷害時，為其恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.NEUTRAL, 2);
        allCards.put(herbGarden.getName(), herbGarden);
        allFieldCards.add(herbGarden);

        FieldCard spiceMarket = FieldCard.createEnvironmentField(
            "異國香料集市 (Exotic Spice Marketplace)", 4, "每回合開始時，使一個友方角色獲得+2攻擊力直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(spiceMarket.getName(), spiceMarket);
        allFieldCards.add(spiceMarket);

        FieldCard rootCellar = FieldCard.createEnvironmentField(
            "古老根莖窖藏 (Ancient Root Vegetable Cellar)", 3, "每當一個友方角色死亡時，抽一張牌。", 
            Rarity.CASUAL_BITES, 2, Faction.NEUTRAL, 2);
        allCards.put(rootCellar.getName(), rootCellar);
        allFieldCards.add(rootCellar);

        FieldCard beanField = FieldCard.createEnvironmentField(
            "活力豆類田野 (Vitality Bean Field)", 2, "每當你打出一個角色時，使其獲得【彈牙】效果。", 
            Rarity.GOURMET_DELIGHT, 1, Faction.NEUTRAL, 1);
        allCards.put(beanField.getName(), beanField);
        allFieldCards.add(beanField);

        FieldCard ancientGarden = FieldCard.createEnvironmentField(
            "遠古農耕聖地 (Ancient Farming Sanctuary)", 5, "每回合結束時，使所有友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 4, Faction.NEUTRAL, 5);
        allCards.put(ancientGarden.getName(), ancientGarden);
        allFieldCards.add(ancientGarden);

        FieldCard sacredGrove = FieldCard.createEnvironmentField(
            "神聖食物樹林 (Sacred Food Grove)", 4, "每當你使用一張法術卡時，為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(sacredGrove.getName(), sacredGrove);
        allFieldCards.add(sacredGrove);

        // 添加遺漏的卡牌
        CharacterCard rosemaryGuardian = new CharacterCard(
            "迷迭香熾焰刺客 (Rosemary Blazing Assassin)", 2, "【熾焰】：攻擊敵方角色時，有50%機率造成1點額外傷害。", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(rosemaryGuardian.getName(), rosemaryGuardian);
        allCharacters.add(rosemaryGuardian);
        
        CharacterCard lotusRootGuard = new CharacterCard(
            "蓮藕根脈守護者 (Lotus Root Vein Protector)", 3, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.NEUTRAL, 1);
        allCards.put(lotusRootGuard.getName(), lotusRootGuard);
        allCharacters.add(lotusRootGuard);

        // 設計拼盤卡片
        CharacterCard masterChef = new CharacterCard(
            "六大食材料理大師 (Six Ingredients Master Chef)", 8, "【拼盤】：當你控制根莖類、豆類、葉菜類、瓜果類、菇類和香料類各一個角色時，可免費打出此卡。【開胃】：使所有友方角色獲得+2/+2。【酥脆(2)】：減免2點傷害。", 
            Rarity.ULTIMATE_TASTE, 6, 6, false, Faction.NEUTRAL, 6);
        allCards.put(masterChef.getName(), masterChef);
        allCharacters.add(masterChef);
    }
    
    @Override
    public String getFactionName() {
        return "中立";
    }
} 