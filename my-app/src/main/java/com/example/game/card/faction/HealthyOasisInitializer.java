package com.example.game.card.faction;

import java.util.Map;
import java.util.List;
import com.example.game.card.Card;
import com.example.game.card.SpellCard;
import com.example.game.card.CharacterCard;
import com.example.game.card.FieldCard;
import com.example.game.card.CastleCard;
import com.example.game.card.Faction;
import com.example.game.card.Rarity;
import com.example.game.card.SpellType;
import com.example.game.card.FieldEffectType;
import com.example.game.card.CastleEffectImpl;

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
        // 基礎角色卡
        CharacterCard avocadoGuardian = new CharacterCard(
            "酪梨守衛", 4, "【滋補】：回合結束時恢復全滿血量。【酥脆】：減免2點傷害。", 
            Rarity.RARE, 3, 5, 6, false, Faction.HEALTHY_OASIS);
        allCards.put(avocadoGuardian.getName(), avocadoGuardian);
        allCharacters.add(avocadoGuardian);

        CharacterCard broccoliMage = new CharacterCard(
            "花椰菜法師", 2, "【開胃】：為一個友方角色恢復3點生命值。【清淡】：滿血時無法攻擊。", 
            Rarity.COMMON, 2, 2, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(broccoliMage.getName(), broccoliMage);
        allCharacters.add(broccoliMage);
        
        CharacterCard quinoaKnight = new CharacterCard(
            "藜麥騎士", 3, "【開胃】：獲得+0/+3。【清淡】：滿血時無法攻擊，但獲得額外2點防禦力。", 
            Rarity.COMMON, 2, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(quinoaKnight.getName(), quinoaKnight);
        allCharacters.add(quinoaKnight);
        
        CharacterCard saladMaster = new CharacterCard(
            "沙拉大師", 5, "【拼盤】：當你控制3個或更多健康綠洲角色時，可免費打出「田園沙拉拼盤」卡。", 
            Rarity.EPIC, 3, 3, 7, false, Faction.HEALTHY_OASIS);
        allCards.put(saladMaster.getName(), saladMaster);
        allCharacters.add(saladMaster);
        
        CharacterCard kaleDefender = new CharacterCard(
            "羽衣甘藍防衛者", 3, "【酥脆】：減免3點傷害。【清淡】：滿血時無法攻擊，但為相鄰友方角色提供【酥脆】效果。", 
            Rarity.RARE, 1, 6, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(kaleDefender.getName(), kaleDefender);
        allCharacters.add(kaleDefender);

        CharacterCard fruitHarvester = new CharacterCard(
            "果實採集者", 4, "【開胃】：從牌庫抽一張卡牌。【回味】：為所有友方角色恢復2點生命值。", 
            Rarity.COMMON, 3, 3, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(fruitHarvester.getName(), fruitHarvester);
        allCharacters.add(fruitHarvester);
        
        // 傳說角色卡
        CharacterCard holisticHealer = new CharacterCard(
            "全息療愈師", 8, "【開胃】：為所有友方角色恢復全部生命值。【滋補】：每回合結束時，所有友方角色恢復2點生命值。【酥脆】：減免所有傷害的50%。", 
            Rarity.LEGENDARY, 4, 6, 8, false, Faction.HEALTHY_OASIS);
        allCards.put(holisticHealer.getName(), holisticHealer);
        allCharacters.add(holisticHealer);
        
        // 補充更多角色卡以達到20張
        CharacterCard spinachProtector = new CharacterCard(
            "菠菜衛士", 3, "【開胃】：獲得+0/+2。【滋補】：每回合結束時，恢復1點生命值。", 
            Rarity.COMMON, 2, 4, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(spinachProtector.getName(), spinachProtector);
        allCharacters.add(spinachProtector);
        
        CharacterCard eggplantSage = new CharacterCard(
            "茄子賢者", 5, "【開胃】：使一個友方角色獲得【滋補】效果。【清淡】：滿血時，法術消耗-1。", 
            Rarity.RARE, 3, 3, 6, false, Faction.HEALTHY_OASIS);
        allCards.put(eggplantSage.getName(), eggplantSage);
        allCharacters.add(eggplantSage);
        
        CharacterCard carrotArcher = new CharacterCard(
            "胡蘿蔔射手", 2, "【遠程】：無視對方防禦進行攻擊。【滋補】：每次攻擊後，恢復1點生命值。", 
            Rarity.COMMON, 3, 1, 3, true, Faction.HEALTHY_OASIS);
        allCards.put(carrotArcher.getName(), carrotArcher);
        allCharacters.add(carrotArcher);
        
        CharacterCard appleTreeProtector = new CharacterCard(
            "蘋果樹守護者", 6, "【擺盤】：敵人必須優先攻擊這個單位。【回味】：為相鄰友方角色恢復2點生命值。", 
            Rarity.RARE, 3, 5, 7, false, Faction.HEALTHY_OASIS);
        allCards.put(appleTreeProtector.getName(), appleTreeProtector);
        allCharacters.add(appleTreeProtector);
        
        CharacterCard tofuMaster = new CharacterCard(
            "豆腐師傅", 3, "【滋補】：當友方角色恢復生命值時，使其獲得+0/+1。", 
            Rarity.RARE, 2, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(tofuMaster.getName(), tofuMaster);
        allCharacters.add(tofuMaster);
        
        CharacterCard nutHealers = new CharacterCard(
            "堅果治癒師", 2, "【開胃】：為一個友方角色恢復2點生命值。【酥脆】：減免1點傷害。", 
            Rarity.COMMON, 1, 2, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(nutHealers.getName(), nutHealers);
        allCharacters.add(nutHealers);
        
        CharacterCard beanSproutScout = new CharacterCard(
            "豆芽斥候", 1, "【開胃】：從牌庫抽一張卡牌。【滋補】：抽到健康綠洲卡牌時，獲得+1/+1。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.HEALTHY_OASIS);
        allCards.put(beanSproutScout.getName(), beanSproutScout);
        allCharacters.add(beanSproutScout);
        
        CharacterCard organicFarmer = new CharacterCard(
            "有機農夫", 3, "【開胃】：從牌庫底抽一張健康綠洲卡牌。【回味】：使一個友方角色獲得+0/+2。", 
            Rarity.COMMON, 2, 3, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(organicFarmer.getName(), organicFarmer);
        allCharacters.add(organicFarmer);
        
        CharacterCard vegetableDruid = new CharacterCard(
            "蔬菜德魯伊", 4, "【開胃】：使一個友方角色獲得【滋補】效果。【清淡】：滿血時，使友方城牆恢復1點耐久度。", 
            Rarity.RARE, 2, 4, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(vegetableDruid.getName(), vegetableDruid);
        allCharacters.add(vegetableDruid);
        
        CharacterCard coconutGuard = new CharacterCard(
            "椰子衛兵", 4, "【擺盤】：敵人必須優先攻擊這個單位。【酥脆】：減免3點傷害。",
            Rarity.COMMON, 2, 5, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(coconutGuard.getName(), coconutGuard);
        allCharacters.add(coconutGuard);
        
        CharacterCard pearMedic = new CharacterCard(
            "梨子醫師", 3, "【開胃】：為兩個友方角色恢復2點生命值。【滋補】：治癒友方角色時，自身獲得+0/+1。", 
            Rarity.RARE, 2, 2, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(pearMedic.getName(), pearMedic);
        allCharacters.add(pearMedic);
        
        CharacterCard organicShaman = new CharacterCard(
            "有機薩滿", 5, "【開胃】：召喚一個2/2的植物精靈。【滋補】：每回合結束時，所有友方角色恢復1點生命值。", 
            Rarity.EPIC, 3, 3, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(organicShaman.getName(), organicShaman);
        allCharacters.add(organicShaman);
        
        CharacterCard wholegrainGuardian = new CharacterCard(
            "全穀守護者", 6, "【酥脆】：減免2點傷害。【清淡】：滿血時，友方城牆耐久度+2。", 
            Rarity.EPIC, 4, 4, 7, false, Faction.HEALTHY_OASIS);
        allCards.put(wholegrainGuardian.getName(), wholegrainGuardian);
        allCharacters.add(wholegrainGuardian);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard organicHealing = new SpellCard(
            "有機療癒", 2, "為一個友方角色恢復全部生命值並給予【滋補】效果。", 
            Rarity.COMMON, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(organicHealing.getName(), organicHealing);
        allSpells.add(organicHealing);

        SpellCard naturalBarrier = new SpellCard(
            "自然屏障", 4, "使所有友方角色獲得【酥脆】效果，減免2點傷害，持續2回合。", 
            Rarity.RARE, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(naturalBarrier.getName(), naturalBarrier);
        allSpells.add(naturalBarrier);
        
        // 補充更多法術卡以達到20張
        SpellCard greenSmoothie = new SpellCard(
            "綠色能量昔", 3, "為所有友方角色恢復2點生命值並獲得+0/+1。", 
            Rarity.COMMON, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(greenSmoothie.getName(), greenSmoothie);
        allSpells.add(greenSmoothie);
        
        SpellCard fruitBasket = new SpellCard(
            "果籃禮盒", 5, "為所有友方角色恢復3點生命值並抽2張牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(fruitBasket.getName(), fruitBasket);
        allSpells.add(fruitBasket);
        
        SpellCard seedOfLife = new SpellCard(
            "生命種子", 2, "使一個友方角色獲得【滋補】效果：每回合結束時恢復2點生命值。", 
            Rarity.COMMON, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(seedOfLife.getName(), seedOfLife);
        allSpells.add(seedOfLife);
        
        SpellCard natureFury = new SpellCard(
            "自然之怒", 4, "對一個敵方角色造成等同於你已恢復生命值總量的傷害(最多8點)。", 
            Rarity.EPIC, SpellType.DAMAGE, Faction.HEALTHY_OASIS);
        allCards.put(natureFury.getName(), natureFury);
        allSpells.add(natureFury);
        
        SpellCard organicFertilizer = new SpellCard(
            "有機肥料", 3, "使所有友方角色獲得+1/+2。如果目標滿血，則改為獲得+2/+3。", 
            Rarity.RARE, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(organicFertilizer.getName(), organicFertilizer);
        allSpells.add(organicFertilizer);
        
        SpellCard revitalizingDew = new SpellCard(
            "復甦露水", 1, "為一個友方角色恢復3點生命值。如果該角色滿血，則抽一張牌。", 
            Rarity.COMMON, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(revitalizingDew.getName(), revitalizingDew);
        allSpells.add(revitalizingDew);
        
        SpellCard vegetablePlate = new SpellCard(
            "蔬菜拼盤", 4, "使所有友方角色獲得+0/+2和【酥脆】效果，減免1點傷害。", 
            Rarity.COMMON, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(vegetablePlate.getName(), vegetablePlate);
        allSpells.add(vegetablePlate);
        
        SpellCard naturalDefense = new SpellCard(
            "自然防禦", 2, "使一個友方角色獲得【酥脆】效果，減免所有傷害的50%，持續一回合。", 
            Rarity.RARE, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(naturalDefense.getName(), naturalDefense);
        allSpells.add(naturalDefense);
        
        SpellCard massRegeneration = new SpellCard(
            "群體再生", 6, "為所有友方角色恢復全部生命值，並使其獲得+0/+2。", 
            Rarity.EPIC, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(massRegeneration.getName(), massRegeneration);
        allSpells.add(massRegeneration);
        
        SpellCard lifeDrain = new SpellCard(
            "生命汲取", 3, "對一個敵方角色造成3點傷害，並為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.HEALTHY_OASIS);
        allCards.put(lifeDrain.getName(), lifeDrain);
        allSpells.add(lifeDrain);
        
        SpellCard plantGrowth = new SpellCard(
            "植物生長", 5, "使所有友方角色獲得+2/+2並獲得【滋補】效果。", 
            Rarity.RARE, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(plantGrowth.getName(), plantGrowth);
        allSpells.add(plantGrowth);
        
        SpellCard recycleNutrients = new SpellCard(
            "養分循環", 2, "從你的棄牌堆中選擇一張健康綠洲卡牌加入手牌。", 
            Rarity.COMMON, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(recycleNutrients.getName(), recycleNutrients);
        allSpells.add(recycleNutrients);
        
        SpellCard naturalSelection = new SpellCard(
            "自然選擇", 3, "檢視牌庫頂部5張牌，選擇其中一張健康綠洲卡牌加入手牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(naturalSelection.getName(), naturalSelection);
        allSpells.add(naturalSelection);
        
        SpellCard photosynthesis = new SpellCard(
            "光合作用", 2, "每有一個友方角色獲得【滋補】效果，抽一張牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(photosynthesis.getName(), photosynthesis);
        allSpells.add(photosynthesis);
        
        SpellCard farmAbundance = new SpellCard(
            "農場豐收", 4, "召喚兩個2/2的有機蔬果，它們具有【滋補】效果。", 
            Rarity.RARE, SpellType.SUMMON, Faction.HEALTHY_OASIS);
        allCards.put(farmAbundance.getName(), farmAbundance);
        allSpells.add(farmAbundance);
        
        SpellCard naturalShield = new SpellCard(
            "自然護盾", 3, "使一個友方角色獲得等同於其最大生命值30%的護盾值(無法超過滿血)。", 
            Rarity.COMMON, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(naturalShield.getName(), naturalShield);
        allSpells.add(naturalShield);
        
        SpellCard renewalCycle = new SpellCard(
            "更新循環", 5, "消滅一個友方角色，然後召喚一個生命值和攻擊力各+2的同名角色。", 
            Rarity.EPIC, SpellType.TRANSFORM, Faction.HEALTHY_OASIS);
        allCards.put(renewalCycle.getName(), renewalCycle);
        allSpells.add(renewalCycle);
        
        SpellCard vitalityInfusion = new SpellCard(
            "活力灌注", 4, "使一個友方角色獲得【滋補】和【酥脆】效果，並抽一張牌。", 
            Rarity.EPIC, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(vitalityInfusion.getName(), vitalityInfusion);
        allSpells.add(vitalityInfusion);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard organicGarden = FieldCard.createEnvironmentField(
            "有機農場", 4, "每回合開始時，為所有友方角色恢復1點生命值，並給予一個隨機友方角色【滋補】效果。", 
            Rarity.RARE, 4, Faction.HEALTHY_OASIS);
        allCards.put(organicGarden.getName(), organicGarden);
        allFieldCards.add(organicGarden);
        
        // 補充更多場地卡以達到10張
        FieldCard greenSmoothieMaker = FieldCard.createToolField(
            "綠拿鐵機", 3, "每回合可以為一個友方角色恢復2點生命值並給予【滋補】效果。", 
            Rarity.COMMON, FieldEffectType.HEAL, 3, 2, Faction.HEALTHY_OASIS);
        allCards.put(greenSmoothieMaker.getName(), greenSmoothieMaker);
        allFieldCards.add(greenSmoothieMaker);
        
        FieldCard vegetableGarden = FieldCard.createEnvironmentField(
            "蔬菜花園", 3, "友方健康綠洲角色生命值+1。當你打出一張健康綠洲卡牌時，有25%機率抽一張牌。", 
            Rarity.RARE, 3, Faction.HEALTHY_OASIS);
        allCards.put(vegetableGarden.getName(), vegetableGarden);
        allFieldCards.add(vegetableGarden);
        
        FieldCard naturalPresservation = FieldCard.createTechniqueField(
            "自然保存", 2, "使一個友方角色獲得【酥脆】效果：受到傷害時，第一次傷害減半(向下取整)。", 
            Rarity.COMMON, FieldEffectType.SPECIAL, 2, 3, Faction.HEALTHY_OASIS);
        allCards.put(naturalPresservation.getName(), naturalPresservation);
        allFieldCards.add(naturalPresservation);
        
        FieldCard fruitOrchard = FieldCard.createEnvironmentField(
            "果園", 5, "每回合結束時，為所有友方角色恢復2點生命值。當一個友方角色被治癒至滿血時，抽一張牌。", 
            Rarity.EPIC, 4, Faction.HEALTHY_OASIS);
        allCards.put(fruitOrchard.getName(), fruitOrchard);
        allFieldCards.add(fruitOrchard);
        
        FieldCard wheatField = FieldCard.createEnvironmentField(
            "麥田", 3, "友方健康綠洲角色獲得+0/+2。每當一個友方角色觸發【滋補】效果時，有30%機率使其獲得+0/+1。", 
            Rarity.COMMON, 3, Faction.HEALTHY_OASIS);
        allCards.put(wheatField.getName(), wheatField);
        allFieldCards.add(wheatField);
        
        FieldCard healingInfusion = FieldCard.createTechniqueField(
            "療癒注入", 3, "使一個友方角色獲得效果：每當受到傷害時，觸發一次【滋補】效果，持續2回合。", 
            Rarity.RARE, FieldEffectType.HEAL, 2, 3, Faction.HEALTHY_OASIS);
        allCards.put(healingInfusion.getName(), healingInfusion);
        allFieldCards.add(healingInfusion);
        
        FieldCard acupunctureKit = FieldCard.createToolField(
            "針灸套件", 2, "每回合可以為一個友方角色恢復3點生命值，但該角色無法攻擊，持續一回合。", 
            Rarity.RARE, FieldEffectType.HEAL, 3, 3, Faction.HEALTHY_OASIS);
        allCards.put(acupunctureKit.getName(), acupunctureKit);
        allFieldCards.add(acupunctureKit);
        
        FieldCard nutritionLab = FieldCard.createEnvironmentField(
            "營養實驗室", 4, "每回合開始時，有30%機率發現一張健康綠洲法術卡。當你施放治療法術時，治療效果+1。", 
            Rarity.RARE, 3, Faction.HEALTHY_OASIS);
        allCards.put(nutritionLab.getName(), nutritionLab);
        allFieldCards.add(nutritionLab);
        
        FieldCard organicHotpot = FieldCard.createToolField(
            "有機養生鍋", 3, "每回合可以為所有友方角色恢復1點生命值，或為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, FieldEffectType.HEAL, 2, 3, Faction.HEALTHY_OASIS);
        allCards.put(organicHotpot.getName(), organicHotpot);
        allFieldCards.add(organicHotpot);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard healthyCastle = new CastleCard(
            "果蔬城堡", 0, "【城堡效果】：所有友方角色生命值+3，每回合結束時恢復1點生命值。", 
            Rarity.EPIC, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(3));
        addToCollection(healthyCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard gardenCastle = new CastleCard(
            "花園堡壘", 0, "【城堡效果】：所有友方角色每回合恢復2點生命值，滿血時獲得+0/+2。", 
            Rarity.LEGENDARY, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(4));
        addToCollection(gardenCastle, allCards, allCastles);
        
        CastleCard vegetableTower = new CastleCard(
            "蔬菜高塔", 0, "【城堡效果】：友方【滋補】效果額外恢復1點生命值，友方角色獲得+0/+3。", 
            Rarity.RARE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(2));
        addToCollection(vegetableTower, allCards, allCastles);
        
        CastleCard fruitCastle = new CastleCard(
            "水果堡壘", 0, "【城堡效果】：每當你恢復生命值時，有30%機率抽一張牌。", 
            Rarity.RARE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(1));
        addToCollection(fruitCastle, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 