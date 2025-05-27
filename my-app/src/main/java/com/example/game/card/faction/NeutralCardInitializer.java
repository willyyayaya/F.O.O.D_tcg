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
        CharacterCard cornEarthGuardian = new CharacterCard(
            "玉米大地守衛 (Corn Earth Guardian)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.NEUTRAL, 1);
        allCards.put(cornEarthGuardian.getName(), cornEarthGuardian);
        allCharacters.add(cornEarthGuardian);

        CharacterCard potatoSoilVeinWarrior = new CharacterCard(
            "馬鈴薯土脈戰士 (Potato Soil Vein Warrior)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(potatoSoilVeinWarrior.getName(), potatoSoilVeinWarrior);
        allCharacters.add(potatoSoilVeinWarrior);

        CharacterCard turnipEarthCorePriest = new CharacterCard(
            "蕪菁地核祭司 (Turnip Earth Core Priest)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.NEUTRAL, 1);
        allCards.put(turnipEarthCorePriest.getName(), turnipEarthCorePriest);
        allCharacters.add(turnipEarthCorePriest);

        CharacterCard radishEarthSentinel = new CharacterCard(
            "白蘿蔔大地衛士 (Radish Earth Sentinel)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.NEUTRAL, 1);
        allCards.put(radishEarthSentinel.getName(), radishEarthSentinel);
        allCharacters.add(radishEarthSentinel);

        CharacterCard sweetPotatoRootDigger = new CharacterCard(
            "地瓜根系掘者 (Sweet Potato Root Digger)", 4, "【開胃】：使一個友方角色獲得+0/+3。【酥脆(1)】：減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(sweetPotatoRootDigger.getName(), sweetPotatoRootDigger);
        allCharacters.add(sweetPotatoRootDigger);

        CharacterCard taroEarthElementalCommander = new CharacterCard(
            "芋頭土元素統御者 (Taro Earth Elemental Commander)", 4, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(1)】：減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(taroEarthElementalCommander.getName(), taroEarthElementalCommander);
        allCharacters.add(taroEarthElementalCommander);

        CharacterCard gingerEarthArchmage = new CharacterCard(
            "薑根大地魔導師 (Ginger Earth Archmage)", 3, "【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(gingerEarthArchmage.getName(), gingerEarthArchmage);
        allCharacters.add(gingerEarthArchmage);

        CharacterCard yamEarthPriest = new CharacterCard(
            "山藥大地祭司 (Yam Earth Priest)", 5, "【開胃】：為所有友方角色恢復1點生命值。【酥脆(1)】：減免1點傷害。【回味】：死亡時使所有友方角色獲得+0/+2。", 
            Rarity.ULTIMATE_TASTE, 3, 5, false, Faction.NEUTRAL, 5);
        allCards.put(yamEarthPriest.getName(), yamEarthPriest);
        allCharacters.add(yamEarthPriest);

        CharacterCard burdockEarthKnight = new CharacterCard(
            "牛蒡大地騎士 (Burdock Earth Knight)", 4, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(burdockEarthKnight.getName(), burdockEarthKnight);
        allCharacters.add(burdockEarthKnight);

        // 豆類食材
        CharacterCard soybeanWindMessenger = new CharacterCard(
            "黃豆風行使者 (Soybean Wind Messenger)", 2, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(soybeanWindMessenger.getName(), soybeanWindMessenger);
        allCharacters.add(soybeanWindMessenger);

        CharacterCard limaBeanSoaringScout = new CharacterCard(
            "皇帝豆翱翔斥候 (Lima Bean Soaring Scout)", 3, "【開胃】：抽一張牌。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(limaBeanSoaringScout.getName(), limaBeanSoaringScout);
        allCharacters.add(limaBeanSoaringScout);

        CharacterCard mungBeanProjectileMaster = new CharacterCard(
            "綠豆彈射師 (Mung Bean Projectile Master)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(mungBeanProjectileMaster.getName(), mungBeanProjectileMaster);
        allCharacters.add(mungBeanProjectileMaster);

        CharacterCard chickpeaAirVortexArcher = new CharacterCard(
            "鷹嘴豆氣旋射手 (Chickpea Air Vortex Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(chickpeaAirVortexArcher.getName(), chickpeaAirVortexArcher);
        allCharacters.add(chickpeaAirVortexArcher);

        CharacterCard blackBeanAirCurrentKnight = new CharacterCard(
            "黑豆氣流騎士 (Black Bean Air Current Knight)", 3, "【酥脆(1)】：減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 2, true, Faction.NEUTRAL, 3);
        allCards.put(blackBeanAirCurrentKnight.getName(), blackBeanAirCurrentKnight);
        allCharacters.add(blackBeanAirCurrentKnight);

        CharacterCard kidneyBeanWindWingGuardian = new CharacterCard(
            "腰豆風翼守衛 (Kidney Bean Wind Wing Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(kidneyBeanWindWingGuardian.getName(), kidneyBeanWindWingGuardian);
        allCharacters.add(kidneyBeanWindWingGuardian);

        CharacterCard lentilSwiftWindSwordsman = new CharacterCard(
            "扁豆疾風劍士 (Lentil Swift Wind Swordsman)", 4, "【彈牙】：每回合可攻擊2次。【開胃】：獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(lentilSwiftWindSwordsman.getName(), lentilSwiftWindSwordsman);
        allCharacters.add(lentilSwiftWindSwordsman);

        CharacterCard peaWindTidePriest = new CharacterCard(
            "豌豆風潮祭司 (Pea Wind Tide Priest)", 4, "【開胃】：使所有友方角色獲得【彈牙】效果直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(peaWindTidePriest.getName(), peaWindTidePriest);
        allCharacters.add(peaWindTidePriest);

        CharacterCard broadBeanStormKnight = new CharacterCard(
            "蠶豆風暴騎士 (Broad Bean Storm Knight)", 5, "【開胃】：對所有敵方角色造成1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CULINARY_HERITAGE, 4, 4, false, Faction.NEUTRAL, 4);
        allCards.put(broadBeanStormKnight.getName(), broadBeanStormKnight);
        allCharacters.add(broadBeanStormKnight);

        CharacterCard adzukiBeanHurricaneArchmage = new CharacterCard(
            "紅豆颶風魔導師 (Adzuki Bean Hurricane Archmage)", 4, "【開胃】：對所有敵方單位造成1點傷害。【彈牙】：每回合可攻擊2次。【回味】：死亡時抽兩張牌。", 
            Rarity.ULTIMATE_TASTE, 4, 4, false, Faction.NEUTRAL, 5);
        allCards.put(adzukiBeanHurricaneArchmage.getName(), adzukiBeanHurricaneArchmage);
        allCharacters.add(adzukiBeanHurricaneArchmage);

        // 葉菜類食材
        CharacterCard spinachVitalityPriest = new CharacterCard(
            "菠菜生機祭司 (Spinach Vitality Priest)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：為所有友方角色恢復2點生命值。【回味】：死亡時使所有友方角色獲得+1/+1。", 
            Rarity.ULTIMATE_TASTE, 3, 6, false, Faction.NEUTRAL, 5);
        allCards.put(spinachVitalityPriest.getName(), spinachVitalityPriest);
        allCharacters.add(spinachVitalityPriest);

        CharacterCard lettuceGreenLeafSage = new CharacterCard(
            "生菜綠葉賢者 (Lettuce Green Leaf Sage)", 2, "【開胃】：為一個友方角色恢復1點生命值。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(lettuceGreenLeafSage.getName(), lettuceGreenLeafSage);
        allCharacters.add(lettuceGreenLeafSage);

        CharacterCard cabbagePhotosynthesisWizard = new CharacterCard(
            "高麗菜光合巫師 (Cabbage Photosynthesis Wizard)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.NEUTRAL, 2);
        allCards.put(cabbagePhotosynthesisWizard.getName(), cabbagePhotosynthesisWizard);
        allCharacters.add(cabbagePhotosynthesisWizard);

        CharacterCard celeryNaturalDruid = new CharacterCard(
            "芹菜自然德魯伊 (Celery Natural Druid)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(celeryNaturalDruid.getName(), celeryNaturalDruid);
        allCharacters.add(celeryNaturalDruid);

        CharacterCard kaleVitalityMentor = new CharacterCard(
            "羽衣甘藍生機導師 (Kale Vitality Mentor)", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時使所有友方角色獲得+0/+2。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(kaleVitalityMentor.getName(), kaleVitalityMentor);
        allCharacters.add(kaleVitalityMentor);

        CharacterCard bokChoyGreenEssenceHealer = new CharacterCard(
            "青江菜綠意治療師 (Bok Choy Green Essence Healer)", 3, "【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(bokChoyGreenEssenceHealer.getName(), bokChoyGreenEssenceHealer);
        allCharacters.add(bokChoyGreenEssenceHealer);

        CharacterCard watercressRevivalEnvoy = new CharacterCard(
            "西洋菜復甦使者 (Watercress Revival Envoy)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(watercressRevivalEnvoy.getName(), watercressRevivalEnvoy);
        allCharacters.add(watercressRevivalEnvoy);

        CharacterCard arugulaVitalityBlesser = new CharacterCard(
            "芝麻菜生機祝福者 (Arugula Vitality Blesser)", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(arugulaVitalityBlesser.getName(), arugulaVitalityBlesser);
        allCharacters.add(arugulaVitalityBlesser);

        CharacterCard mustardLifeProtectionKnight = new CharacterCard(
            "芥菜生命守護騎士 (Mustard Life Protection Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 5, false, Faction.NEUTRAL, 4);
        allCards.put(mustardLifeProtectionKnight.getName(), mustardLifeProtectionKnight);
        allCharacters.add(mustardLifeProtectionKnight);

        CharacterCard swissChardNatureArchmage = new CharacterCard(
            "甜菜自然魔導師 (Swiss Chard Nature Archmage)", 4, "【開胃】：為所有友方角色恢復1點生命值。【酥脆(1)】：減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(swissChardNatureArchmage.getName(), swissChardNatureArchmage);
        allCharacters.add(swissChardNatureArchmage);

        // 瓜果類食材
        CharacterCard pumpkinWaterTideMage = new CharacterCard(
            "南瓜水潮法師 (Pumpkin Water Tide Mage)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(2)】：減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 3, 6, false, Faction.NEUTRAL, 4);
        allCards.put(pumpkinWaterTideMage.getName(), pumpkinWaterTideMage);
        allCharacters.add(pumpkinWaterTideMage);

        CharacterCard cucumberJuiceArcher = new CharacterCard(
            "黃瓜汁液射手 (Cucumber Juice Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(cucumberJuiceArcher.getName(), cucumberJuiceArcher);
        allCharacters.add(cucumberJuiceArcher);

        CharacterCard watermelonTideController = new CharacterCard(
            "西瓜潮汐操控師 (Watermelon Tide Controller)", 6, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：使所有敵方角色費用+1直到回合結束。【酥脆(1)】：減免1點傷害。", 
            Rarity.ULTIMATE_TASTE, 3, 7, false, Faction.NEUTRAL, 5);
        allCards.put(watermelonTideController.getName(), watermelonTideController);
        allCharacters.add(watermelonTideController);

        CharacterCard cantaloupeFluidSorcerer = new CharacterCard(
            "哈密瓜漿流術士 (Cantaloupe Fluid Sorcerer)", 4, "【開胃】：使一個敵方角色無法攻擊直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(cantaloupeFluidSorcerer.getName(), cantaloupeFluidSorcerer);
        allCharacters.add(cantaloupeFluidSorcerer);

        CharacterCard honeydewWaterSpiritMage = new CharacterCard(
            "蜜瓜水靈法師 (Honeydew Water Spirit Mage)", 3, "【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(honeydewWaterSpiritMage.getName(), honeydewWaterSpiritMage);
        allCharacters.add(honeydewWaterSpiritMage);

        CharacterCard bitterGourdWaterVeinScout = new CharacterCard(
            "苦瓜水脈斥候 (Bitter Gourd Water Vein Scout)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(bitterGourdWaterVeinScout.getName(), bitterGourdWaterVeinScout);
        allCharacters.add(bitterGourdWaterVeinScout);

        CharacterCard winterMelonTidePriest = new CharacterCard(
            "冬瓜潮汐祭司 (Winter Melon Tide Priest)", 4, "【開胃】：對所有敵方角色造成1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.GOURMET_DELIGHT, 2, 4, false, Faction.NEUTRAL, 3);
        allCards.put(winterMelonTidePriest.getName(), winterMelonTidePriest);
        allCharacters.add(winterMelonTidePriest);

        CharacterCard luffaWaterVortexKnight = new CharacterCard(
            "絲瓜水旋騎士 (Luffa Water Vortex Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：使敵方角色費用+1直到對手回合結束。", 
            Rarity.GOURMET_DELIGHT, 4, 4, false, Faction.NEUTRAL, 3);
        allCards.put(luffaWaterVortexKnight.getName(), luffaWaterVortexKnight);
        allCharacters.add(luffaWaterVortexKnight);

        CharacterCard bottleGourdWaterSourceArchmage = new CharacterCard(
            "葫蘆水源魔導師 (Bottle Gourd Water Source Archmage)", 4, "【開胃】：使所有友方角色獲得【酥脆(1)】效果1回合。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.NEUTRAL, 3);
        allCards.put(bottleGourdWaterSourceArchmage.getName(), bottleGourdWaterSourceArchmage);
        allCharacters.add(bottleGourdWaterSourceArchmage);

        CharacterCard snakeGourdWaterArrowArcher = new CharacterCard(
            "蛇瓜水箭射手 (Snake Gourd Water Arrow Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 1);
        allCards.put(snakeGourdWaterArrowArcher.getName(), snakeGourdWaterArrowArcher);
        allCharacters.add(snakeGourdWaterArrowArcher);

        // 菇類食材
        CharacterCard enokiIllusionSage = new CharacterCard(
            "金針菇幻象賢者 (Enoki Illusion Sage)", 3, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.NEUTRAL, 1);
        allCards.put(enokiIllusionSage.getName(), enokiIllusionSage);
        allCharacters.add(enokiIllusionSage);

        CharacterCard shiitakeSporeGuardian = new CharacterCard(
            "香菇孢子守護者 (Shiitake Spore Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.NEUTRAL, 2);
        allCards.put(shiitakeSporeGuardian.getName(), shiitakeSporeGuardian);
        allCharacters.add(shiitakeSporeGuardian);

        CharacterCard oysterMushroomAssassinationArcher = new CharacterCard(
            "蠔菇暗殺射手 (Oyster Mushroom Assassination Archer)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(oysterMushroomAssassinationArcher.getName(), oysterMushroomAssassinationArcher);
        allCharacters.add(oysterMushroomAssassinationArcher);

        CharacterCard matsutakeShadowArcanist = new CharacterCard(
            "姬松茸暗影術士 (Matsutake Shadow Arcanist)", 4, "【開胃】：使一個敵方角色-2/-0直到回合結束。【酥脆(1)】：減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(matsutakeShadowArcanist.getName(), matsutakeShadowArcanist);
        allCharacters.add(matsutakeShadowArcanist);

        CharacterCard kingOysterMyceliumSwordsman = new CharacterCard(
            "杏鮑菇菌絲劍士 (King Oyster Mycelium Swordsman)", 4, "【開胃】：獲得+2/+2直到回合結束。【彈牙】：每回合可攻擊2次。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.NEUTRAL, 3);
        allCards.put(kingOysterMyceliumSwordsman.getName(), kingOysterMyceliumSwordsman);
        allCharacters.add(kingOysterMyceliumSwordsman);

        CharacterCard woodEarDarkNightMage = new CharacterCard(
            "木耳暗夜法師 (Wood Ear Dark Night Mage)", 3, "【開胃】：使一個敵方角色無法攻擊直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(woodEarDarkNightMage.getName(), woodEarDarkNightMage);
        allCharacters.add(woodEarDarkNightMage);

        CharacterCard cloudEarShadowScout = new CharacterCard(
            "雲耳陰影斥候 (Cloud Ear Shadow Scout)", 2, "【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(cloudEarShadowScout.getName(), cloudEarShadowScout);
        allCharacters.add(cloudEarShadowScout);

        CharacterCard reishiDarkVeilPriest = new CharacterCard(
            "靈芝暗幕祭司 (Reishi Dark Veil Priest)", 4, "【開胃】：對所有敵方角色造成1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(reishiDarkVeilPriest.getName(), reishiDarkVeilPriest);
        allCharacters.add(reishiDarkVeilPriest);

        CharacterCard lionsManePhantomKnight = new CharacterCard(
            "猴頭菇幻影騎士 (Lion's Mane Phantom Knight)", 5, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：召喚一個2/2的幻影複製。", 
            Rarity.CULINARY_HERITAGE, 4, 4, false, Faction.NEUTRAL, 4);
        allCards.put(lionsManePhantomKnight.getName(), lionsManePhantomKnight);
        allCharacters.add(lionsManePhantomKnight);

        CharacterCard cordycepsDarkArchmage = new CharacterCard(
            "蟲草暗黑魔導師 (Cordyceps Dark Archmage)", 6, "【開胃】：使一個敵方角色-2/-2直到回合結束。【彈牙】：每回合可攻擊2次。【回味】：死亡時隨機使一個敵方角色無法攻擊1回合。", 
            Rarity.ULTIMATE_TASTE, 4, 4, false, Faction.NEUTRAL, 5);
        allCards.put(cordycepsDarkArchmage.getName(), cordycepsDarkArchmage);
        allCharacters.add(cordycepsDarkArchmage);

        // 香料類食材
        CharacterCard blackPepperFlameBerserker = new CharacterCard(
            "黑胡椒烈焰狂戰 (Black Pepper Flame Berserker)", 2, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 1, true, Faction.NEUTRAL, 1);
        allCards.put(blackPepperFlameBerserker.getName(), blackPepperFlameBerserker);
        allCharacters.add(blackPepperFlameBerserker);

        CharacterCard whitePepperSpicyAssassin = new CharacterCard(
            "白胡椒辛香刺客 (White Pepper Spicy Assassin)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(whitePepperSpicyAssassin.getName(), whitePepperSpicyAssassin);
        allCharacters.add(whitePepperSpicyAssassin);

        CharacterCard cinnamonBurningGuardian = new CharacterCard(
            "肉桂燃燒守衛 (Cinnamon Burning Guardian)", 3, "【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.NEUTRAL, 2);
        allCards.put(cinnamonBurningGuardian.getName(), cinnamonBurningGuardian);
        allCharacters.add(cinnamonBurningGuardian);

        CharacterCard cuminTasteController = new CharacterCard(
            "孜然味覺操控師 (Cumin Taste Controller)", 3, "【開胃】：使所有友方角色獲得+1/+0直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 2, 2, true, Faction.NEUTRAL, 2);
        allCards.put(cuminTasteController.getName(), cuminTasteController);
        allCharacters.add(cuminTasteController);

        CharacterCard starAniseRagingFireKnight = new CharacterCard(
            "八角烈火騎士 (Star Anise Raging Fire Knight)", 4, "【酥脆(2)】：減免2點傷害。【開胃】：對目標和相鄰單位造成1點傷害。", 
            Rarity.CULINARY_HERITAGE, 4, 3, false, Faction.NEUTRAL, 4);
        allCards.put(starAniseRagingFireKnight.getName(), starAniseRagingFireKnight);
        allCharacters.add(starAniseRagingFireKnight);

        CharacterCard mustardBurningLord = new CharacterCard(
            "芥末燃燒領主 (Mustard Burning Lord)", 3, "【開胃】：對所有敵方角色造成1點傷害。", 
            Rarity.GOURMET_DELIGHT, 4, 1, true, Faction.NEUTRAL, 3);
        allCards.put(mustardBurningLord.getName(), mustardBurningLord);
        allCharacters.add(mustardBurningLord);

        CharacterCard turmericScorchingPriest = new CharacterCard(
            "薑黃炙熱祭司 (Turmeric Scorching Priest)", 4, "【開胃】：使所有友方角色獲得+1/+0直到回合結束。【回味】：死亡時恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 3, false, Faction.NEUTRAL, 3);
        allCards.put(turmericScorchingPriest.getName(), turmericScorchingPriest);
        allCharacters.add(turmericScorchingPriest);

        CharacterCard basilFireTongueMonk = new CharacterCard(
            "羅勒火舌修行者 (Basil Fire Tongue Monk)", 3, "【彈牙】：每回合可攻擊2次。", 
            Rarity.GOURMET_DELIGHT, 3, 2, true, Faction.NEUTRAL, 2);
        allCards.put(basilFireTongueMonk.getName(), basilFireTongueMonk);
        allCharacters.add(basilFireTongueMonk);

        CharacterCard herbSearingMaster = new CharacterCard(
            "香草灼燒大師 (Herb Searing Master)", 6, "【開胃】：對所有敵方角色造成2點傷害。【彈牙】：每回合可攻擊2次。【回味】：死亡時對所有敵方角色造成1點傷害。", 
            Rarity.ULTIMATE_TASTE, 5, 4, false, Faction.NEUTRAL, 5);
        allCards.put(herbSearingMaster.getName(), herbSearingMaster);
        allCharacters.add(herbSearingMaster);

        CharacterCard rosemaryBlazingAssassin = new CharacterCard(
            "迷迭香熾焰刺客 (Rosemary Blazing Assassin)", 2, "【熾焰】：攻擊敵方角色時，有50%機率造成1點額外傷害。", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(rosemaryBlazingAssassin.getName(), rosemaryBlazingAssassin);
        allCharacters.add(rosemaryBlazingAssassin);

        // 為各類食材添加無特性角色

        // 根莖類無特性角色
        CharacterCard carrotEarthApprentice = new CharacterCard(
            "紅蘿蔔大地見習生 (Carrot Earth Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(carrotEarthApprentice.getName(), carrotEarthApprentice);
        allCharacters.add(carrotEarthApprentice);
        
        CharacterCard arrowrootSoilVeinApprentice = new CharacterCard(
            "芋艿土脈學徒 (Arrowroot Soil Vein Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(arrowrootSoilVeinApprentice.getName(), arrowrootSoilVeinApprentice);
        allCharacters.add(arrowrootSoilVeinApprentice);
        
        CharacterCard waterCaltropRootSystemApprentice = new CharacterCard(
            "菱角根系學徒 (Water Caltrop Root System Apprentice)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 3, false, Faction.NEUTRAL, 2);
        allCards.put(waterCaltropRootSystemApprentice.getName(), waterCaltropRootSystemApprentice);
        allCharacters.add(waterCaltropRootSystemApprentice);
        
        CharacterCard waterBambooEarthSentinel = new CharacterCard(
            "茭白筍大地哨兵 (Water Bamboo Earth Sentinel)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, false, Faction.NEUTRAL, 2);
        allCards.put(waterBambooEarthSentinel.getName(), waterBambooEarthSentinel);
        allCharacters.add(waterBambooEarthSentinel);
        
        CharacterCard jerusalemArtichokeEarthSeniorApprentice = new CharacterCard(
            "菊芋大地資深學徒 (Jerusalem Artichoke Earth Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 5, 5, false, Faction.NEUTRAL, 4);
        allCards.put(jerusalemArtichokeEarthSeniorApprentice.getName(), jerusalemArtichokeEarthSeniorApprentice);
        allCharacters.add(jerusalemArtichokeEarthSeniorApprentice);

        // 豆類無特性角色
        CharacterCard beanSproutWindApprentice = new CharacterCard(
            "豆芽風行學徒 (Bean Sprout Wind Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, true, Faction.NEUTRAL, 1);
        allCards.put(beanSproutWindApprentice.getName(), beanSproutWindApprentice);
        allCharacters.add(beanSproutWindApprentice);
        
        CharacterCard hyacinthBeanAirCurrentNoviceCannoneer = new CharacterCard(
            "刀豆氣流見習砲手 (Hyacinth Bean Air Current Novice Cannoneer)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 0, true, Faction.NEUTRAL, 1);
        allCards.put(hyacinthBeanAirCurrentNoviceCannoneer.getName(), hyacinthBeanAirCurrentNoviceCannoneer);
        allCharacters.add(hyacinthBeanAirCurrentNoviceCannoneer);
        
        CharacterCard chickpeaWindShieldSentinel = new CharacterCard(
            "鵪鶉豆風盾哨兵 (Chickpea Wind Shield Sentinel)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 3, false, Faction.NEUTRAL, 1);
        allCards.put(chickpeaWindShieldSentinel.getName(), chickpeaWindShieldSentinel);
        allCharacters.add(chickpeaWindShieldSentinel);
        
        CharacterCard blackEyedPeaSwiftWindApprentice = new CharacterCard(
            "黑眼豆疾風見習生 (Black-eyed Pea Swift Wind Apprentice)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.NEUTRAL, 2);
        allCards.put(blackEyedPeaSwiftWindApprentice.getName(), blackEyedPeaSwiftWindApprentice);
        allCharacters.add(blackEyedPeaSwiftWindApprentice);
        
        CharacterCard limaBeanStormSeniorApprentice = new CharacterCard(
            "利馬豆風暴資深學徒 (Lima Bean Storm Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 4, 6, false, Faction.NEUTRAL, 3);
        allCards.put(limaBeanStormSeniorApprentice.getName(), limaBeanStormSeniorApprentice);
        allCharacters.add(limaBeanStormSeniorApprentice);

        // 香料類無特性角色
        CharacterCard vanillaFlameApprentice = new CharacterCard(
            "香草烈焰學徒 (Vanilla Flame Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(vanillaFlameApprentice.getName(), vanillaFlameApprentice);
        allCharacters.add(vanillaFlameApprentice);
        
        CharacterCard garlicScorchingSentinel = new CharacterCard(
            "大蒜灼熱哨兵 (Garlic Scorching Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(garlicScorchingSentinel.getName(), garlicScorchingSentinel);
        allCharacters.add(garlicScorchingSentinel);
        
        CharacterCard fennelFlameApprentice = new CharacterCard(
            "小茴香火焰見習者 (Fennel Flame Apprentice)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(fennelFlameApprentice.getName(), fennelFlameApprentice);
        allCharacters.add(fennelFlameApprentice);
        
        CharacterCard driedTangerinePeelBurningApprentice = new CharacterCard(
            "陳皮燃燒學徒 (Dried Tangerine Peel Burning Apprentice)", 3, "無特性", 
            Rarity.CASUAL_BITES, 4, 2, true, Faction.NEUTRAL, 2);
        allCards.put(driedTangerinePeelBurningApprentice.getName(), driedTangerinePeelBurningApprentice);
        allCharacters.add(driedTangerinePeelBurningApprentice);
        
        CharacterCard cloveFierceFireSeniorApprentice = new CharacterCard(
            "丁香烈火資深見習生 (Clove Fierce Fire Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 5, 5, true, Faction.NEUTRAL, 3);
        allCards.put(cloveFierceFireSeniorApprentice.getName(), cloveFierceFireSeniorApprentice);
        allCharacters.add(cloveFierceFireSeniorApprentice);

        // 葉菜類無特性角色
        CharacterCard rapeGreenLeafApprentice = new CharacterCard(
            "油菜綠葉見習生 (Rape Green Leaf Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, true, Faction.NEUTRAL, 1);
        allCards.put(rapeGreenLeafApprentice.getName(), rapeGreenLeafApprentice);
        allCharacters.add(rapeGreenLeafApprentice);
        
        CharacterCard crownDaisyVitalityApprentice = new CharacterCard(
            "茼蒿生機學徒 (Crown Daisy Vitality Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, false, Faction.NEUTRAL, 1);
        allCards.put(crownDaisyVitalityApprentice.getName(), crownDaisyVitalityApprentice);
        allCharacters.add(crownDaisyVitalityApprentice);
        
        CharacterCard chineseBroccoliPhotosynthesisApprentice = new CharacterCard(
            "芥藍光合學徒 (Chinese Broccoli Photosynthesis Apprentice)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(chineseBroccoliPhotosynthesisApprentice.getName(), chineseBroccoliPhotosynthesisApprentice);
        allCharacters.add(chineseBroccoliPhotosynthesisApprentice);
        
        CharacterCard amaranthLifeSentinel = new CharacterCard(
            "莧菜生命哨兵 (Amaranth Life Sentinel)", 3, "無特性", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.NEUTRAL, 2);
        allCards.put(amaranthLifeSentinel.getName(), amaranthLifeSentinel);
        allCharacters.add(amaranthLifeSentinel);
        
        CharacterCard perillaNatureSeniorApprentice = new CharacterCard(
            "紫蘇自然資深學徒 (Perilla Nature Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 3, 6, false, Faction.NEUTRAL, 3);
        allCards.put(perillaNatureSeniorApprentice.getName(), perillaNatureSeniorApprentice);
        allCharacters.add(perillaNatureSeniorApprentice);

        // 瓜果類無特性角色
        CharacterCard chayoteJuiceApprentice = new CharacterCard(
            "節瓜汁液學徒 (Chayote Juice Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.NEUTRAL, 1);
        allCards.put(chayoteJuiceApprentice.getName(), chayoteJuiceApprentice);
        allCharacters.add(chayoteJuiceApprentice);
        
        CharacterCard buddhasHandWaterVeinSentinel = new CharacterCard(
            "佛手瓜水脈哨兵 (Buddha's Hand Water Vein Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, false, Faction.NEUTRAL, 1);
        allCards.put(buddhasHandWaterVeinSentinel.getName(), buddhasHandWaterVeinSentinel);
        allCharacters.add(buddhasHandWaterVeinSentinel);
        
        CharacterCard kabochaWaterTideApprentice = new CharacterCard(
            "栗子南瓜水潮見習守衛 (Kabocha Water Tide Apprentice Guard)", 2, "無特性", 
            Rarity.CASUAL_BITES, 1, 4, false, Faction.NEUTRAL, 2);
        allCards.put(kabochaWaterTideApprentice.getName(), kabochaWaterTideApprentice);
        allCharacters.add(kabochaWaterTideApprentice);
        
        CharacterCard persianMelonTideApprentice = new CharacterCard(
            "大荔瓜潮汐學徒 (Persian Melon Tide Apprentice)", 3, "無特性", 
            Rarity.CASUAL_BITES, 3, 3, false, Faction.NEUTRAL, 2);
        allCards.put(persianMelonTideApprentice.getName(), persianMelonTideApprentice);
        allCharacters.add(persianMelonTideApprentice);
        
        CharacterCard waxGourdWaterSourceSeniorApprentice = new CharacterCard(
            "扁蒲水源資深學徒 (Wax Gourd Water Source Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 4, 5, false, Faction.NEUTRAL, 3);
        allCards.put(waxGourdWaterSourceSeniorApprentice.getName(), waxGourdWaterSourceSeniorApprentice);
        allCharacters.add(waxGourdWaterSourceSeniorApprentice);

        // 菇類無特性角色
        CharacterCard flamulinaPhantomApprentice = new CharacterCard(
            "鴻喜菇幻影見習生 (Flamulina Phantom Apprentice)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 1, true, Faction.NEUTRAL, 1);
        allCards.put(flamulinaPhantomApprentice.getName(), flamulinaPhantomApprentice);
        allCharacters.add(flamulinaPhantomApprentice);
        
        CharacterCard whiteBeechMushroomShadowSentinel = new CharacterCard(
            "白玉菇暗影哨兵 (White Beech Mushroom Shadow Sentinel)", 1, "無特性", 
            Rarity.CASUAL_BITES, 1, 2, false, Faction.NEUTRAL, 1);
        allCards.put(whiteBeechMushroomShadowSentinel.getName(), whiteBeechMushroomShadowSentinel);
        allCharacters.add(whiteBeechMushroomShadowSentinel);
        
        CharacterCard teaTreeMushroomMyceliumApprentice = new CharacterCard(
            "茶樹菇菌絲學徒 (Tea Tree Mushroom Mycelium Apprentice)", 2, "無特性", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.NEUTRAL, 1);
        allCards.put(teaTreeMushroomMyceliumApprentice.getName(), teaTreeMushroomMyceliumApprentice);
        allCharacters.add(teaTreeMushroomMyceliumApprentice);
        
        CharacterCard velvetDarkNightSentinel = new CharacterCard(
            "毛木耳暗夜哨衛 (Velvet Dark Night Sentinel)", 3, "無特性", 
            Rarity.CASUAL_BITES, 2, 3, false, Faction.NEUTRAL, 2);
        allCards.put(velvetDarkNightSentinel.getName(), velvetDarkNightSentinel);
        allCharacters.add(velvetDarkNightSentinel);
        
        CharacterCard shimejiDarkVeilSeniorApprentice = new CharacterCard(
            "秀珍菇暗幕資深學徒 (Shimeji Dark Veil Senior Apprentice)", 5, "無特性", 
            Rarity.GOURMET_DELIGHT, 3, 6, false, Faction.NEUTRAL, 3);
        allCards.put(shimejiDarkVeilSeniorApprentice.getName(), shimejiDarkVeilSeniorApprentice);
        allCharacters.add(shimejiDarkVeilSeniorApprentice);

        // 城牆回血法術
        SpellCard wallCreviceRestoration = new SpellCard(
            "城牆磚縫修復術 (Wall Crevice Restoration)", 1, "為一個城牆恢復2點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, 1);
        allCards.put(wallCreviceRestoration.getName(), wallCreviceRestoration);
        allSpells.add(wallCreviceRestoration);

        SpellCard emergencyDefenseReconstruction = new SpellCard(
            "緊急防禦重建 (Emergency Defense Reconstruction)", 3, "為所有城牆恢復2點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, 2);
        allCards.put(emergencyDefenseReconstruction.getName(), emergencyDefenseReconstruction);
        allSpells.add(emergencyDefenseReconstruction);

        SpellCard masterStructuralReforging = new SpellCard(
            "大師級結構重鑄 (Master Structural Reforging)", 5, "為一個城牆恢復4點生命值，並使其獲得【酥脆(1)】效果直到回合結束。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, 3);
        allCards.put(masterStructuralReforging.getName(), masterStructuralReforging);
        allSpells.add(masterStructuralReforging);

        SpellCard divineFrontlineBlessing = new SpellCard(
            "神聖防線祝福 (Divine Frontline Blessing)", 7, "為所有城牆恢復3點生命值，並使其獲得【酥脆(1)】效果直到回合結束。", 
            Rarity.CULINARY_HERITAGE, SpellType.HEALING, 4);
        allCards.put(divineFrontlineBlessing.getName(), divineFrontlineBlessing);
        allSpells.add(divineFrontlineBlessing);
        
        // 角色移動法術
        SpellCard rapidTacticalRedeployment = new SpellCard(
            "快速戰術調動 (Rapid Tactical Redeployment)", 1, "將一個友方角色移動到另一個城牆，並使其獲得+1/+0直到回合結束。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, 1);
        allCards.put(rapidTacticalRedeployment.getName(), rapidTacticalRedeployment);
        allSpells.add(rapidTacticalRedeployment);

        SpellCard massForceRelocation = new SpellCard(
            "群體兵力轉移 (Mass Force Relocation)", 3, "將兩個友方角色移動到另一個城牆。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, 2);
        allCards.put(massForceRelocation.getName(), massForceRelocation);
        allSpells.add(massForceRelocation);

        SpellCard emergencyRetreatEnhancement = new SpellCard(
            "緊急撤退強化 (Emergency Retreat Enhancement)", 2, "將一個友方角色移動到另一個城牆，並使其獲得【酥脆(1)】效果直到回合結束。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 2);
        allCards.put(emergencyRetreatEnhancement.getName(), emergencyRetreatEnhancement);
        allSpells.add(emergencyRetreatEnhancement);

        SpellCard strategicCompleteWithdrawal = new SpellCard(
            "戰略全面撤退 (Strategic Complete Withdrawal)", 4, "將所有友方角色移動到另一個城牆，並使其獲得+1/+1直到回合結束。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 3);
        allCards.put(strategicCompleteWithdrawal.getName(), strategicCompleteWithdrawal);
        allSpells.add(strategicCompleteWithdrawal);

        // 其他輔助法術
        SpellCard rootVegetableEnergySupply = new SpellCard(
            "根莖能量補給 (Root Vegetable Energy Supply)", 2, "抽一張牌。根莖類連動：如果你控制至少一個根莖類角色，則再抽一張牌並獲得1點生命值。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, 1);
        allCards.put(rootVegetableEnergySupply.getName(), rootVegetableEnergySupply);
        allSpells.add(rootVegetableEnergySupply);

        SpellCard mushroomNutrientStorage = new SpellCard(
            "菇類養分儲藏 (Mushroom Nutrient Storage)", 3, "抽兩張牌。菇類連動：如果你控制至少一個菇類角色，則使一個友方角色獲得+1/+2。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, 2);
        allCards.put(mushroomNutrientStorage.getName(), mushroomNutrientStorage);
        allSpells.add(mushroomNutrientStorage);

        SpellCard leafyVegetableFreshnessPreservation = new SpellCard(
            "葉菜鮮度保存 (Leafy Vegetable Freshness Preservation)", 2, "使一個友方角色獲得+1/+1直到回合結束。葉菜類連動：如果目標是葉菜類角色，則效果變為+2/+2並獲得【酥脆(1)】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(leafyVegetableFreshnessPreservation.getName(), leafyVegetableFreshnessPreservation);
        allSpells.add(leafyVegetableFreshnessPreservation);

        SpellCard spiceFlavorEnhancement = new SpellCard(
            "香料風味強化 (Spice Flavor Enhancement)", 3, "使一個友方角色獲得+2/+1直到回合結束。香料類連動：如果你控制至少一個香料類角色，則使所有友方角色獲得+1/+0並獲得【彈牙】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 2);
        allCards.put(spiceFlavorEnhancement.getName(), spiceFlavorEnhancement);
        allSpells.add(spiceFlavorEnhancement);

        SpellCard gourdSweetBlessing = new SpellCard(
            "瓜果甜蜜祝福 (Gourd Sweet Blessing)", 4, "使所有友方角色獲得+1/+1直到回合結束。瓜果類連動：如果你控制至少一個瓜果類角色，則使所有友方角色獲得【彈牙】效果並抽一張牌。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 3);
        allCards.put(gourdSweetBlessing.getName(), gourdSweetBlessing);
        allSpells.add(gourdSweetBlessing);

        SpellCard rootEntanglementCurse = new SpellCard(
            "根莖纏繞詛咒 (Root Entanglement Curse)", 2, "使一個敵方角色獲得-1/-1直到回合結束。根莖類連動：如果你控制至少一個根莖類角色，則目標角色無法攻擊下回合並失去其特殊能力。", 
            Rarity.CASUAL_BITES, SpellType.DEBUFF, 1);
        allCards.put(rootEntanglementCurse.getName(), rootEntanglementCurse);
        allSpells.add(rootEntanglementCurse);

        SpellCard mushroomSporePoisoning = new SpellCard(
            "菇類孢子中毒 (Mushroom Spore Poisoning)", 3, "使一個敵方角色獲得-2/-1直到回合結束。菇類連動：如果你控制至少一個菇類角色，則目標角色每回合開始時受到1點傷害並失去其特殊能力。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, 2);
        allCards.put(mushroomSporePoisoning.getName(), mushroomSporePoisoning);
        allSpells.add(mushroomSporePoisoning);

        SpellCard beanParasiticPlague = new SpellCard(
            "豆類寄生瘟疫 (Bean Parasitic Plague)", 4, "使所有敵方角色獲得-1/-1直到回合結束。豆類連動：如果你控制至少一個豆類角色，則敵方角色費用+1並失去其特殊能力直到回合結束。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, 3);
        allCards.put(beanParasiticPlague.getName(), beanParasiticPlague);
        allSpells.add(beanParasiticPlague);

        SpellCard leafyVegetableRegenerationMiracle = new SpellCard(
            "葉菜再生奇蹟 (Leafy Vegetable Regeneration Miracle)", 5, "使一個友方角色獲得+3/+2直到回合結束。葉菜類連動：如果你控制至少一個葉菜類角色，則目標角色獲得【酥脆(2)】效果並可以額外攻擊一次。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 4);
        allCards.put(leafyVegetableRegenerationMiracle.getName(), leafyVegetableRegenerationMiracle);
        allSpells.add(leafyVegetableRegenerationMiracle);

        SpellCard spiceScorchingApocalypse = new SpellCard(
            "香料灼燒末日 (Spice Scorching Apocalypse)", 6, "使所有敵方角色獲得-2/-2直到回合結束。香料類連動：如果你控制至少一個香料類角色，則所有敵方角色失去其特殊能力並每回合開始時受到1點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.DEBUFF, 5);
        allCards.put(spiceScorchingApocalypse.getName(), spiceScorchingApocalypse);
        allSpells.add(spiceScorchingApocalypse);

        // 特殊法術卡
        SpellCard chefOmnipotentBlessing = new SpellCard(
            "廚神全能祝福 (Chef's Omnipotent Blessing)", 6, "計算場上你控制的不同食材類別數量。效果隨數量增強：1類-抽2張牌；2類-為所有友方角色恢復2點生命值；3類-所有友方角色獲得+1/+1；4類-對所有敵方角色造成2點傷害；5類-隨機召喚一個費用為3的角色；6類-你獲得一個額外的回合。", 
            Rarity.CULINARY_HERITAGE, SpellType.SPECIAL, 5);
        allCards.put(chefOmnipotentBlessing.getName(), chefOmnipotentBlessing);
        allSpells.add(chefOmnipotentBlessing);

        // 添加新的連動法術
        SpellCard beanProteinShield = new SpellCard(
            "豆類蛋白護盾 (Bean Protein Shield)", 1, "使一個友方角色獲得【酥脆(1)】效果。豆類連動：如果目標是豆類角色，則改為獲得【酥脆(2)】效果並抽一張牌。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(beanProteinShield.getName(), beanProteinShield);
        allSpells.add(beanProteinShield);
        
        SpellCard rootVegetableRapidGrowth = new SpellCard(
            "根莖快速生長 (Root Vegetable Rapid Growth)", 2, "召喚一個1/2的根莖類食材代幣。根莖類連動：如果你控制至少兩個根莖類角色，則改為召喚一個2/3的代幣並使其獲得【酥脆(1)】效果。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, 1);
        allCards.put(rootVegetableRapidGrowth.getName(), rootVegetableRapidGrowth);
        allSpells.add(rootVegetableRapidGrowth);
        
        SpellCard leafyVegetablePhotosynthesisRepair = new SpellCard(
            "葉菜光合修復 (Leafy Vegetable Photosynthesis Repair)", 2, "為所有友方角色恢復1點生命值。葉菜類連動：如果你控制至少一個葉菜類角色，則改為恢復2點生命值並使所有友方角色獲得+1/+0。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, 1);
        allCards.put(leafyVegetablePhotosynthesisRepair.getName(), leafyVegetablePhotosynthesisRepair);
        allSpells.add(leafyVegetablePhotosynthesisRepair);
        
        SpellCard fruitSugarBurst = new SpellCard(
            "瓜果糖分爆發 (Gourd Sugar Burst)", 3, "使一個友方角色獲得+2攻擊力並可以額外攻擊一次。瓜果類連動：如果目標是瓜果類角色，則效果持續到下回合並使其獲得【酥脆(1)】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, 2);
        allCards.put(fruitSugarBurst.getName(), fruitSugarBurst);
        allSpells.add(fruitSugarBurst);
        
        SpellCard mushroomSporePropagation = new SpellCard(
            "菇類孢子繁殖 (Mushroom Spore Propagation)", 3, "召喚兩個1/1菇類食材代幣。菇類連動：如果你控制至少一個菇類角色，則使這些代幣獲得【回味】：死亡時抽一張牌並使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, 2);
        allCards.put(mushroomSporePropagation.getName(), mushroomSporePropagation);
        allSpells.add(mushroomSporePropagation);
        
        SpellCard spicyHotFlavor = new SpellCard(
            "香料火辣風味 (Spicy Hot Flavor)", 2, "使一個友方角色獲得【現炸】效果。香料類連動：如果你控制至少一個香料類角色，則使目標角色獲得+2/+0並可以額外攻擊一次。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, 1);
        allCards.put(spicyHotFlavor.getName(), spicyHotFlavor);
        allSpells.add(spicyHotFlavor);

        // 場地卡
        FieldCard vitalVegetableGreenGarden = FieldCard.createEnvironmentField(
            "生命蔬菜綠園 (Vital Vegetable Green Garden)", 2, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.CASUAL_BITES, 1, Faction.NEUTRAL, 2);
        allCards.put(vitalVegetableGreenGarden.getName(), vitalVegetableGreenGarden);
        allFieldCards.add(vitalVegetableGreenGarden);

        FieldCard juicyFruitOrchard = FieldCard.createEnvironmentField(
            "多汁水果果園 (Juicy Fruit Orchard)", 3, "每當你打出一個角色時，使其獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.NEUTRAL, 3);
        allCards.put(juicyFruitOrchard.getName(), juicyFruitOrchard);
        allFieldCards.add(juicyFruitOrchard);

        FieldCard mysticMushroomFantasyForest = FieldCard.createEnvironmentField(
            "神祕菇菇幻森 (Mystic Mushroom Fantasy Forest)", 4, "每回合開始時，隨機使一個友方角色獲得【酥脆(1)】效果。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(mysticMushroomFantasyForest.getName(), mysticMushroomFantasyForest);
        allFieldCards.add(mysticMushroomFantasyForest);

        FieldCard goldenWheatAbundantField = FieldCard.createEnvironmentField(
            "金黃麥穗豐田 (Golden Wheat Abundant Field)", 2, "每當你使用一張法術卡時，抽一張牌。", 
            Rarity.CASUAL_BITES, 1, Faction.NEUTRAL, 1);
        allCards.put(goldenWheatAbundantField.getName(), goldenWheatAbundantField);
        allFieldCards.add(goldenWheatAbundantField);

        FieldCard aromaticHerbHealingGarden = FieldCard.createEnvironmentField(
            "芳香香草療園 (Aromatic Herb Healing Garden)", 3, "每當一個友方角色受到傷害時，為其恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.NEUTRAL, 2);
        allCards.put(aromaticHerbHealingGarden.getName(), aromaticHerbHealingGarden);
        allFieldCards.add(aromaticHerbHealingGarden);

        FieldCard exoticSpiceMarketplace = FieldCard.createEnvironmentField(
            "異國香料集市 (Exotic Spice Marketplace)", 4, "每回合開始時，使一個友方角色獲得+2攻擊力直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(exoticSpiceMarketplace.getName(), exoticSpiceMarketplace);
        allFieldCards.add(exoticSpiceMarketplace);

        FieldCard ancientRootVegetableCellar = FieldCard.createEnvironmentField(
            "古老根莖窖藏 (Ancient Root Vegetable Cellar)", 3, "每當一個友方角色死亡時，抽一張牌。", 
            Rarity.CASUAL_BITES, 2, Faction.NEUTRAL, 2);
        allCards.put(ancientRootVegetableCellar.getName(), ancientRootVegetableCellar);
        allFieldCards.add(ancientRootVegetableCellar);

        FieldCard vitalityBeanField = FieldCard.createEnvironmentField(
            "活力豆類田野 (Vitality Bean Field)", 2, "每當你打出一個角色時，使其獲得【彈牙】效果。", 
            Rarity.GOURMET_DELIGHT, 1, Faction.NEUTRAL, 1);
        allCards.put(vitalityBeanField.getName(), vitalityBeanField);
        allFieldCards.add(vitalityBeanField);

        FieldCard ancientFarmingSanctuary = FieldCard.createEnvironmentField(
            "遠古農耕聖地 (Ancient Farming Sanctuary)", 5, "每回合結束時，使所有友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 4, Faction.NEUTRAL, 5);
        allCards.put(ancientFarmingSanctuary.getName(), ancientFarmingSanctuary);
        allFieldCards.add(ancientFarmingSanctuary);

        FieldCard sacredFoodGrove = FieldCard.createEnvironmentField(
            "神聖食物樹林 (Sacred Food Grove)", 4, "每當你使用一張法術卡時，為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.NEUTRAL, 3);
        allCards.put(sacredFoodGrove.getName(), sacredFoodGrove);
        allFieldCards.add(sacredFoodGrove);
    }
    
    @Override
    public String getFactionName() {
        return "中立";
    }
} 