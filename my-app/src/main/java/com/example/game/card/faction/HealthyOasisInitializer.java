package com.example.game.card.faction;

import java.util.List;
import java.util.Map;

import com.example.game.card.Card;
import com.example.game.card.CastleCard;
import com.example.game.card.CastleEffectImpl;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.FieldCard;
import com.example.game.card.FieldEffectType;
import com.example.game.card.Rarity;
import com.example.game.card.SpellCard;
import com.example.game.card.SpellType;

/**
 * 健康綠洲陣營卡牌初始化實現類
 */
public class HealthyOasisInitializer implements FactionCardInitializer {
    
    @Override
    public void initializeCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters,
        List<SpellCard> allSpells,
        List<FieldCard> allFieldCards,
        List<CastleCard> allCastles
    ) {
        initializeCharacterCards(allCards, allCharacters);
        initializeSpellCards(allCards, allSpells);
        initializeFieldCards(allCards, allFieldCards);
        initializeCastleCards(allCards, allCastles);
    }
    
    @Override
    public String getFactionName() {
        return "健康綠洲";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 沙拉類角色
        CharacterCard caesarSaladGuardian = new CharacterCard(
            "凱撒沙拉守衛 (Caesar Salad Guardian)", 4, "【滋補】：回合結束時恢復全滿血量。【酥脆(2)】：減免2點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(caesarSaladGuardian.getName(), caesarSaladGuardian);
        allCharacters.add(caesarSaladGuardian);

        CharacterCard greekSaladMage = new CharacterCard(
            "希臘沙拉法師 (Greek Salad Mage)", 2, "【開胃】：為一個友方角色恢復3點生命值。【清淡】：滿血時無法攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(greekSaladMage.getName(), greekSaladMage);
        allCharacters.add(greekSaladMage);
        
        CharacterCard fruitSaladProtector = new CharacterCard(
            "水果沙拉守護者 (Fruit Salad Protector)", 3, "【開胃】：從牌庫抽一張卡牌。【回味】：為所有友方角色恢復2點生命值。", 
            Rarity.CASUAL_BITES, 3, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(fruitSaladProtector.getName(), fruitSaladProtector);
        allCharacters.add(fruitSaladProtector);
        
        CharacterCard seasonalSaladSwordsman = new CharacterCard(
            "時蔬沙拉劍士 (Seasonal Salad Swordsman)", 2, "【開胃】：為一個友方角色恢復1點生命值。【連擊】：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.HEALTHY_OASIS);
        allCards.put(seasonalSaladSwordsman.getName(), seasonalSaladSwordsman);
        allCharacters.add(seasonalSaladSwordsman);
        
        // 穀物類角色
        CharacterCard oatmealDefender = new CharacterCard(
            "燕麥粥防衛者 (Oatmeal Defender)", 3, "【酥脆(3)】：減免3點傷害。【清淡】：滿血時無法攻擊，但為相鄰友方角色提供【酥脆(1)】效果。", 
            Rarity.GOURMET_DELIGHT, 1, 6, false, Faction.HEALTHY_OASIS);
        allCards.put(oatmealDefender.getName(), oatmealDefender);
        allCharacters.add(oatmealDefender);

        CharacterCard quinoaRiceKnight = new CharacterCard(
            "藜麥飯騎士 (Quinoa Rice Knight)", 3, "【開胃】：獲得+0/+3。【清淡】：滿血時無法攻擊，但獲得額外2點防禦力。", 
            Rarity.CASUAL_BITES, 2, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(quinoaRiceKnight.getName(), quinoaRiceKnight);
        allCharacters.add(quinoaRiceKnight);
        
        CharacterCard wholeWheatBreadWarrior = new CharacterCard(
            "全麥麵包戰士 (Whole Wheat Bread Warrior)", 3, "【開胃】：獲得+0/+2。【滋補】：每回合結束時，恢復1點生命值。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(wholeWheatBreadWarrior.getName(), wholeWheatBreadWarrior);
        allCharacters.add(wholeWheatBreadWarrior);
        
        CharacterCard brownRicePorridgeArchmage = new CharacterCard(
            "糙米粥魔導師 (Brown Rice Porridge Archmage)", 6, "【酥脆(2)】：減免2點傷害。【清淡】：滿血時，友方城牆耐久度+2。", 
            Rarity.CULINARY_HERITAGE, 4, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(brownRicePorridgeArchmage.getName(), brownRicePorridgeArchmage);
        allCharacters.add(brownRicePorridgeArchmage);
        
        // 蛋白質類角色
        CharacterCard boiledChickenBreastGuard = new CharacterCard(
            "水煮雞胸衛兵 (Boiled Chicken Breast Guard)", 4, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆(3)】：減免3點傷害。",
            Rarity.CASUAL_BITES, 2, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(boiledChickenBreastGuard.getName(), boiledChickenBreastGuard);
        allCharacters.add(boiledChickenBreastGuard);
        
        CharacterCard nonfatYogurtPriest = new CharacterCard(
            "無脂優格祭司 (Non-fat Yogurt Priest)", 3, "【開胃】：為兩個友方角色恢復2點生命值。【滋補】：治癒友方角色時，自身獲得+0/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(nonfatYogurtPriest.getName(), nonfatYogurtPriest);
        allCharacters.add(nonfatYogurtPriest);
        
        CharacterCard tofuMaster = new CharacterCard(
            "豆腐師傅 (Tofu Master)", 3, "【滋補】：當友方角色恢復生命值時，使其獲得+0/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(tofuMaster.getName(), tofuMaster);
        allCharacters.add(tofuMaster);
        
        CharacterCard steamedEggArcher = new CharacterCard(
            "蒸蛋神射手 (Steamed Egg Archer)", 2, "【遠程】：無視對方防禦進行攻擊。【滋補】：每次攻擊後，恢復1點生命值。", 
            Rarity.CASUAL_BITES, 3, 1, true, Faction.HEALTHY_OASIS);
        allCards.put(steamedEggArcher.getName(), steamedEggArcher);
        allCharacters.add(steamedEggArcher);
        
        // 飲品類角色
        CharacterCard greenLatteMage = new CharacterCard(
            "綠拿鐵法師 (Green Latte Mage)", 3, "【開胃】：使一個友方角色獲得+1/+1。【連擊】：攻擊後，有40%機率再次攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 2, true, Faction.HEALTHY_OASIS);
        allCards.put(greenLatteMage.getName(), greenLatteMage);
        allCharacters.add(greenLatteMage);
        
        CharacterCard vegetableJuiceScout = new CharacterCard(
            "蔬果汁斥候 (Vegetable Juice Scout)", 1, "【開胃】：從牌庫抽一張卡牌。【滋補】：抽到健康綠洲卡牌時，獲得+1/+1。", 
            Rarity.CASUAL_BITES, 1, 1, true, Faction.HEALTHY_OASIS);
        allCards.put(vegetableJuiceScout.getName(), vegetableJuiceScout);
        allCharacters.add(vegetableJuiceScout);
        
        CharacterCard nutMilkArcher = new CharacterCard(
            "堅果奶射手 (Nut Milk Archer)", 2, "【開胃】：為一個友方角色恢復2點生命值。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(nutMilkArcher.getName(), nutMilkArcher);
        allCharacters.add(nutMilkArcher);
        
        CharacterCard orangeJuiceHealer = new CharacterCard(
            "柳橙汁治療師 (Orange Juice Healer)", 3, "【開胃】：使一個友方角色獲得【滋補】效果。【清淡】：滿血時，法術消耗-1。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(orangeJuiceHealer.getName(), orangeJuiceHealer);
        allCharacters.add(orangeJuiceHealer);
        
        // 堅果類角色
        CharacterCard mixedNutsGuardian = new CharacterCard(
            "堅果混合守衛 (Mixed Nuts Guardian)", 6, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：為相鄰友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(mixedNutsGuardian.getName(), mixedNutsGuardian);
        allCharacters.add(mixedNutsGuardian);
        
        CharacterCard almondButterAssassin = new CharacterCard(
            "杏仁醬刺客 (Almond Butter Assassin)", 4, "【開胃】：召喚一個2/2的植物精靈。【滋補】：每回合結束時，所有友方角色恢復1點生命值。", 
            Rarity.CULINARY_HERITAGE, 3, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(almondButterAssassin.getName(), almondButterAssassin);
        allCharacters.add(almondButterAssassin);
        
        // 湯品類角色
        CharacterCard vegetableSoupWizard = new CharacterCard(
            "蔬菜湯巫師 (Vegetable Soup Wizard)", 4, "【開胃】：使一個友方角色獲得【滋補】效果。【清淡】：滿血時，使友方城牆恢復1點耐久度。", 
            Rarity.GOURMET_DELIGHT, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(vegetableSoupWizard.getName(), vegetableSoupWizard);
        allCharacters.add(vegetableSoupWizard);
        
        CharacterCard chickenBrothKnight = new CharacterCard(
            "雞肉清湯騎士 (Chicken Broth Knight)", 3, "【開胃】：從牌庫底抽一張健康綠洲卡牌。【回味】：使一個友方角色獲得+0/+2。", 
            Rarity.CASUAL_BITES, 2, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(chickenBrothKnight.getName(), chickenBrothKnight);
        allCharacters.add(chickenBrothKnight);
        
        // 烤製類角色
        CharacterCard grilledSalmonWarrior = new CharacterCard(
            "烤鮭魚戰士 (Grilled Salmon Warrior)", 5, "【開胃】：使一個友方角色獲得【滋補】效果。【連擊】：攻擊後，有40%機率再次攻擊。", 
            Rarity.GOURMET_DELIGHT, 4, 3, true, Faction.HEALTHY_OASIS);
        allCards.put(grilledSalmonWarrior.getName(), grilledSalmonWarrior);
        allCharacters.add(grilledSalmonWarrior);
        
        CharacterCard roastedVegetablesProtector = new CharacterCard(
            "烤蔬菜守護者 (Roasted Vegetables Protector)", 4, "【開胃】：為所有友方角色恢復1點生命值。【酥脆(2)】：減免2點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(roastedVegetablesProtector.getName(), roastedVegetablesProtector);
        allCharacters.add(roastedVegetablesProtector);
        
        // 輕食類角色
        CharacterCard sandwichScout = new CharacterCard(
            "三明治斥候 (Sandwich Scout)", 2, "【開胃】：從牌庫抽一張卡牌。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 1, true, Faction.HEALTHY_OASIS);
        allCards.put(sandwichScout.getName(), sandwichScout);
        allCharacters.add(sandwichScout);
        
        CharacterCard vegetableWrapSwordsman = new CharacterCard(
            "蔬菜包捲劍士 (Vegetable Wrap Swordsman)", 3, "【開胃】：獲得+1/+1。【連擊】：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 3, 2, true, Faction.HEALTHY_OASIS);
        allCards.put(vegetableWrapSwordsman.getName(), vegetableWrapSwordsman);
        allCharacters.add(vegetableWrapSwordsman);
        
        // 傳說角色卡 - 各類別整合
        CharacterCard holisticNutritionMaster = new CharacterCard(
            "整合營養大師 (Holistic Nutrition Master)", 8, "【開胃】：為所有友方角色恢復全部生命值。【滋補】：每回合結束時，所有友方角色恢復2點生命值。【酥脆(3)】：減免所有傷害的50%。", 
            Rarity.ULTIMATE_TASTE, 4, 6, false, Faction.HEALTHY_OASIS);
        allCards.put(holisticNutritionMaster.getName(), holisticNutritionMaster);
        allCharacters.add(holisticNutritionMaster);
        
        CharacterCard balancedMealMaster = new CharacterCard(
            "均衡餐點大師 (Balanced Meal Master)", 6, "【開胃】：為所有友方角色恢復2點生命值。【連擊】：攻擊後，有50%機率再次攻擊。", 
            Rarity.ULTIMATE_TASTE, 4, 4, true, Faction.HEALTHY_OASIS);
        allCards.put(balancedMealMaster.getName(), balancedMealMaster);
        allCharacters.add(balancedMealMaster);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard nutrientInfusion = new SpellCard(
            "營養注入 (Nutrient Infusion)", 2, "為一個友方角色恢復全部生命值並給予【滋補】效果。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(nutrientInfusion.getName(), nutrientInfusion);
        allSpells.add(nutrientInfusion);

        SpellCard immuneSystemBooster = new SpellCard(
            "免疫系統增強劑 (Immune System Booster)", 4, "使所有友方角色獲得【酥脆(2)】效果，持續2回合。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(immuneSystemBooster.getName(), immuneSystemBooster);
        allSpells.add(immuneSystemBooster);
        
        // 其他法術卡
        SpellCard greenSmoothieBlend = new SpellCard(
            "綠色能量昔 (Green Smoothie Blend)", 3, "為所有友方角色恢復2點生命值並獲得+0/+1。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(greenSmoothieBlend.getName(), greenSmoothieBlend);
        allSpells.add(greenSmoothieBlend);
        
        SpellCard seasonalFruitPlatter = new SpellCard(
            "季節水果拼盤 (Seasonal Fruit Platter)", 2, "【開胃】：從牌庫抽一張卡牌。【滋補】：抽到健康綠洲卡牌時，獲得+1/+1。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(seasonalFruitPlatter.getName(), seasonalFruitPlatter);
        allSpells.add(seasonalFruitPlatter);
        
        SpellCard probioticBoost = new SpellCard(
            "益生菌增強 (Probiotic Boost)", 2, "使一個友方角色獲得【滋補】效果：每回合結束時恢復2點生命值。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(probioticBoost.getName(), probioticBoost);
        allSpells.add(probioticBoost);
        
        SpellCard antioxidantBurst = new SpellCard(
            "抗氧化爆發 (Antioxidant Burst)", 4, "對一個敵方角色造成等同於你已恢復生命值總量的傷害(最多8點)。", 
            Rarity.CULINARY_HERITAGE, SpellType.DAMAGE, Faction.HEALTHY_OASIS);
        allCards.put(antioxidantBurst.getName(), antioxidantBurst);
        allSpells.add(antioxidantBurst);
        
        SpellCard superfoodMix = new SpellCard(
            "超級食物混合 (Superfood Mix)", 3, "使所有友方角色獲得+1/+2。如果目標滿血，則改為獲得+2/+3。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(superfoodMix.getName(), superfoodMix);
        allSpells.add(superfoodMix);
        
        SpellCard morningDetoxJuice = new SpellCard(
            "早晨排毒果汁 (Morning Detox Juice)", 1, "為一個友方角色恢復3點生命值。如果該角色滿血，則抽一張牌。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(morningDetoxJuice.getName(), morningDetoxJuice);
        allSpells.add(morningDetoxJuice);
        
        SpellCard balancedMealPlan = new SpellCard(
            "均衡餐點計劃 (Balanced Meal Plan)", 4, "使所有友方角色獲得+0/+2和【酥脆(1)】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(balancedMealPlan.getName(), balancedMealPlan);
        allSpells.add(balancedMealPlan);
        
        SpellCard essentialOilProtection = new SpellCard(
            "精油保護 (Essential Oil Protection)", 2, "使一個友方角色獲得【酥脆(2)】效果，持續一回合。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(essentialOilProtection.getName(), essentialOilProtection);
        allSpells.add(essentialOilProtection);
        
        SpellCard holisticHealing = new SpellCard(
            "全方位療愈 (Holistic Healing)", 6, "為所有友方角色恢復全部生命值，並使其獲得+0/+2。", 
            Rarity.CULINARY_HERITAGE, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(holisticHealing.getName(), holisticHealing);
        allSpells.add(holisticHealing);
        
        SpellCard energyTransfer = new SpellCard(
            "能量轉移 (Energy Transfer)", 3, "對一個敵方角色造成3點傷害，並為一個友方角色恢復3點生命值。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.HEALTHY_OASIS);
        allCards.put(energyTransfer.getName(), energyTransfer);
        allSpells.add(energyTransfer);
        
        SpellCard healthyDietBoost = new SpellCard(
            "健康飲食加強 (Healthy Diet Boost)", 5, "使所有友方角色獲得+2/+2並獲得【滋補】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(healthyDietBoost.getName(), healthyDietBoost);
        allSpells.add(healthyDietBoost);
        
        SpellCard recycledIngredients = new SpellCard(
            "回收食材 (Recycled Ingredients)", 2, "從你的棄牌堆中選擇一張健康綠洲卡牌加入手牌。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(recycledIngredients.getName(), recycledIngredients);
        allSpells.add(recycledIngredients);
        
        SpellCard mindfulFoodChoice = new SpellCard(
            "正念食物選擇 (Mindful Food Choice)", 3, "檢視牌庫頂部5張牌，選擇其中一張健康綠洲卡牌加入手牌。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(mindfulFoodChoice.getName(), mindfulFoodChoice);
        allSpells.add(mindfulFoodChoice);
        
        SpellCard nutrientAbsorption = new SpellCard(
            "營養吸收 (Nutrient Absorption)", 2, "每有一個友方角色獲得【滋補】效果，抽一張牌。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(nutrientAbsorption.getName(), nutrientAbsorption);
        allSpells.add(nutrientAbsorption);
        
        SpellCard organicMealPrep = new SpellCard(
            "有機餐點準備 (Organic Meal Prep)", 4, "召喚兩個2/2的健康餐盒，它們具有【滋補】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.SUMMON, Faction.HEALTHY_OASIS);
        allCards.put(organicMealPrep.getName(), organicMealPrep);
        allSpells.add(organicMealPrep);
        
        SpellCard collagenSupplement = new SpellCard(
            "膠原蛋白補充 (Collagen Supplement)", 3, "使一個友方角色獲得等同於其最大生命值30%的護盾值(無法超過滿血)。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(collagenSupplement.getName(), collagenSupplement);
        allSpells.add(collagenSupplement);
        
        SpellCard dietaryOverhaul = new SpellCard(
            "飲食徹底改革 (Dietary Overhaul)", 5, "消滅一個友方角色，然後召喚一個生命值和攻擊力各+2的同名角色。", 
            Rarity.CULINARY_HERITAGE, SpellType.TRANSFORM, Faction.HEALTHY_OASIS);
        allCards.put(dietaryOverhaul.getName(), dietaryOverhaul);
        allSpells.add(dietaryOverhaul);
        
        SpellCard immuneSystemBoost = new SpellCard(
            "免疫系統提升 (Immune System Boost)", 4, "使一個友方角色獲得【滋補】和【酥脆(2)】效果，並抽一張牌。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(immuneSystemBoost.getName(), immuneSystemBoost);
        allSpells.add(immuneSystemBoost);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard healthyMealPrepStation = FieldCard.createEnvironmentField(
            "健康餐點準備站 (Healthy Meal Prep Station)", 4, "每回合開始時，為所有友方角色恢復1點生命值，並給予一個隨機友方角色【滋補】效果。", 
            Rarity.GOURMET_DELIGHT, 4, Faction.HEALTHY_OASIS);
        allCards.put(healthyMealPrepStation.getName(), healthyMealPrepStation);
        allFieldCards.add(healthyMealPrepStation);
        
        // 補充更多場地卡
        FieldCard juicingCounter = FieldCard.createEnvironmentField(
            "鮮榨果汁吧台 (Juicing Counter)", 3, "每回合可以為一個友方角色恢復2點生命值並給予【滋補】效果。", 
            Rarity.CASUAL_BITES, 3, Faction.HEALTHY_OASIS);
        allCards.put(juicingCounter.getName(), juicingCounter);
        allFieldCards.add(juicingCounter);
        
        FieldCard saladBuffet = FieldCard.createEnvironmentField(
            "沙拉自助餐檯 (Salad Buffet)", 3, "【開胃】：從牌庫底抽一張健康綠洲卡牌。【回味】：使一個友方角色獲得+0/+2。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.HEALTHY_OASIS);
        allCards.put(saladBuffet.getName(), saladBuffet);
        allFieldCards.add(saladBuffet);
        
        FieldCard naturalSupplementStore = FieldCard.createEnvironmentField(
            "天然保健品商店 (Natural Supplement Store)", 2, "使一個友方角色獲得【酥脆(1)】效果：受到傷害時，第一次傷害減半(向下取整)。", 
            Rarity.CASUAL_BITES, 3, Faction.HEALTHY_OASIS);
        allCards.put(naturalSupplementStore.getName(), naturalSupplementStore);
        allFieldCards.add(naturalSupplementStore);
        
        FieldCard smoothieBowlBar = FieldCard.createEnvironmentField(
            "果昔碗專賣店 (Smoothie Bowl Bar)", 5, "每回合結束時，為所有友方角色恢復2點生命值。當一個友方角色被治癒至滿血時，抽一張牌。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.HEALTHY_OASIS);
        allCards.put(smoothieBowlBar.getName(), smoothieBowlBar);
        allFieldCards.add(smoothieBowlBar);
        
        FieldCard wholeGrainBakery = FieldCard.createEnvironmentField(
            "全穀麵包坊 (Whole Grain Bakery)", 3, "友方健康綠洲角色獲得+0/+2。每當一個友方角色觸發【滋補】效果時，有30%機率使其獲得+0/+1。", 
            Rarity.CASUAL_BITES, 3, Faction.HEALTHY_OASIS);
        allCards.put(wholeGrainBakery.getName(), wholeGrainBakery);
        allFieldCards.add(wholeGrainBakery);
        
        FieldCard detoxSpa = FieldCard.createEnvironmentField(
            "排毒水療中心 (Detox Spa)", 3, "使一個友方角色獲得效果：每當受到傷害時，觸發一次【滋補】效果，持續2回合。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.HEALTHY_OASIS);
        allCards.put(detoxSpa.getName(), detoxSpa);
        allFieldCards.add(detoxSpa);
        
        FieldCard nutritionConsultingRoom = FieldCard.createEnvironmentField(
            "營養諮詢室 (Nutrition Consulting Room)", 4, "每回合開始時，有30%機率發現一張健康綠洲法術卡。當你施放治療法術時，治療效果+1。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.HEALTHY_OASIS);
        allCards.put(nutritionConsultingRoom.getName(), nutritionConsultingRoom);
        allFieldCards.add(nutritionConsultingRoom);
        
        FieldCard healthyHotpotRestaurant = FieldCard.createEnvironmentField(
            "健康火鍋餐廳 (Healthy Hotpot Restaurant)", 3, "每回合可以為所有友方角色恢復1點生命值，或為一個友方角色恢復3點生命值。", 
            Rarity.CASUAL_BITES, 3, Faction.HEALTHY_OASIS);
        allCards.put(healthyHotpotRestaurant.getName(), healthyHotpotRestaurant);
        allFieldCards.add(healthyHotpotRestaurant);

        FieldCard proteinShakeGym = FieldCard.createEnvironmentField(
            "蛋白質奶昔健身房 (Protein Shake Gym)", 2, "使一個友方角色獲得【連擊】效果：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, Faction.HEALTHY_OASIS);
        allCards.put(proteinShakeGym.getName(), proteinShakeGym);
        allFieldCards.add(proteinShakeGym);
        
        FieldCard meditationCenter = FieldCard.createEnvironmentField(
            "冥想養生中心 (Meditation Wellness Center)", 4, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.HEALTHY_OASIS);
        allCards.put(meditationCenter.getName(), meditationCenter);
        allFieldCards.add(meditationCenter);
        
        FieldCard veggieMealPrepKitchen = FieldCard.createEnvironmentField(
            "蔬食備餐廚房 (Veggie Meal Prep Kitchen)", 5, "友方角色獲得+1/+1，且每回合開始時恢復1點生命值。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.HEALTHY_OASIS);
        allCards.put(veggieMealPrepKitchen.getName(), veggieMealPrepKitchen);
        allFieldCards.add(veggieMealPrepKitchen);
        
        FieldCard holisticNutritionCenter = FieldCard.createEnvironmentField(
            "全方位營養中心 (Holistic Nutrition Center)", 6, "所有友方角色獲得【連擊】效果，且每回合開始時恢復2點生命值。", 
            Rarity.ULTIMATE_TASTE, 5, Faction.HEALTHY_OASIS);
        allCards.put(holisticNutritionCenter.getName(), holisticNutritionCenter);
        allFieldCards.add(holisticNutritionCenter);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard balancedNutritionCastle = new CastleCard(
            "均衡營養堡壘 (Balanced Nutrition Fortress)", 0, "【城堡效果】：所有友方角色生命值+3，每回合結束時恢復1點生命值。", 
            Rarity.CULINARY_HERITAGE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(3));
        addToCollection(balancedNutritionCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard wellnessSanctuary = new CastleCard(
            "健康養生聖殿 (Wellness Sanctuary)", 0, "【城堡效果】：所有友方角色每回合恢復2點生命值，滿血時獲得+0/+2。", 
            Rarity.ULTIMATE_TASTE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(4));
        addToCollection(wellnessSanctuary, allCards, allCastles);
        
        CastleCard plantBasedTower = new CastleCard(
            "植物能量高塔 (Plant-Based Tower)", 0, "【城堡效果】：友方【滋補】效果額外恢復1點生命值，友方角色獲得+0/+3。", 
            Rarity.GOURMET_DELIGHT, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(2));
        addToCollection(plantBasedTower, allCards, allCastles);
        
        CastleCard nutritionPlazaCastle = new CastleCard(
            "營養廣場城堡 (Nutrition Plaza Castle)", 0, "【城堡效果】：每當你恢復生命值時，有30%機率抽一張牌。", 
            Rarity.GOURMET_DELIGHT, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(1));
        addToCollection(nutritionPlazaCastle, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 