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
        // 中立卡牌
        CharacterCard waterServant = new CharacterCard(
            "水之侍者", 2, "【開胃】：若你的牌組中有至少兩個不同陣營的卡牌，獲得+1/+1。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(waterServant.getName(), waterServant);
        allCharacters.add(waterServant);

        CharacterCard saltSage = new CharacterCard(
            "鹽之賢者", 4, "【開胃】：在打出時，你可以選擇一個陣營，視為該陣營的角色。【回味】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, 4, false, Faction.NEUTRAL);
        allCards.put(saltSage.getName(), saltSage);
        allCharacters.add(saltSage);

        FieldCard marketPlace = FieldCard.createEnvironmentField(
            "美食市集", 5, "【拼盤】：每回合可以將一張手牌與牌庫頂的一張牌交換，如果抽到的是'拼盤'卡牌，則費用-2。", 
            Rarity.EPIC, 5, Faction.NEUTRAL);
        allCards.put(marketPlace.getName(), marketPlace);
        allFieldCards.add(marketPlace);
        
        // 添加更多中立卡牌
        CharacterCard foodCritic = new CharacterCard(
            "美食評論家", 3, "【開胃】：查看你牌庫頂的三張牌，選擇一張加入手牌。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 3, 3, false, Faction.NEUTRAL);
        allCards.put(foodCritic.getName(), foodCritic);
        allCharacters.add(foodCritic);
        
        CharacterCard chefApprentice = new CharacterCard(
            "廚師學徒", 1, "【彈牙】：每回合可攻擊 2 次。【開胃】：隨機生成一張費用為1的卡牌。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.NEUTRAL);
        allCards.put(chefApprentice.getName(), chefApprentice);
        allCharacters.add(chefApprentice);
        
        FieldCard diningTable = FieldCard.createEnvironmentField(
            "用餐餐桌", 2, "【拼盤】：當符合打出條件時，有機會生成特殊融合料理卡；當你的角色受到致命傷害時，有30%機率存活並保留1點生命值。", 
            Rarity.COMMON, 2, Faction.NEUTRAL);
        allCards.put(diningTable.getName(), diningTable);
        allFieldCards.add(diningTable);
        
        // 新增中立卡牌
        CharacterCard masterChef = new CharacterCard(
            "名廚大師", 5, "【開胃】：為所有友方角色恢復1點生命值。【拼盤】：當你控制3個不同陣營的卡牌時，可免費打出「豪華拼盤」卡。", 
            Rarity.EPIC, 4, 3, 5, false, Faction.NEUTRAL);
        allCards.put(masterChef.getName(), masterChef);
        allCharacters.add(masterChef);

        CharacterCard umamiFlavor = new CharacterCard(
            "鮮味精華", 3, "【開胃】：使一個友方角色獲得+1/+1。【回味】：從牌庫中抽取一張你選擇陣營的卡牌。", 
            Rarity.RARE, 2, 3, 3, true, Faction.NEUTRAL);
        allCards.put(umamiFlavor.getName(), umamiFlavor);
        allCharacters.add(umamiFlavor);

        // 新增中立法術卡
        SpellCard perfectionPlate = new SpellCard(
            "完美料理", 4, "使一個友方角色獲得+2/+2和一個你選擇的關鍵字效果。", 
            Rarity.RARE, SpellType.BUFF, Faction.NEUTRAL);
        allCards.put(perfectionPlate.getName(), perfectionPlate);
        allSpells.add(perfectionPlate);

        SpellCard culinaryInspiration = new SpellCard(
            "料理靈感", 2, "抽兩張牌，如果這些牌屬於不同陣營，則費用-1。", 
            Rarity.COMMON, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(culinaryInspiration.getName(), culinaryInspiration);
        allSpells.add(culinaryInspiration);
        
        // 新增特殊中立場地卡
        FieldCard internationalFoodFest = FieldCard.createEnvironmentField(
            "國際美食節", 6, "【拼盤】：每回合結束時，從場上收集一種關鍵字效果。當收集到5種不同效果時，生成「美食終極盛宴」卡牌。", 
            Rarity.LEGENDARY, 5, Faction.NEUTRAL);
        allCards.put(internationalFoodFest.getName(), internationalFoodFest);
        allFieldCards.add(internationalFoodFest);

        // 中立傳說卡牌
        CharacterCard gastronomyLegend = new CharacterCard(
            "美食傳奇", 9, "【開胃】：從牌庫中抽取每個陣營的一張卡牌。【拼盤】：當控制4個不同陣營的卡牌時，使所有友方角色獲得+2/+2和其所屬陣營的一個特殊效果。", 
            Rarity.LEGENDARY, 6, 6, 9, false, Faction.NEUTRAL);
        allCards.put(gastronomyLegend.getName(), gastronomyLegend);
        allCharacters.add(gastronomyLegend);
        
        // 傳說法術卡
        SpellCard culinaryMasterpiece = new SpellCard(
            "料理傑作", 10, "使所有友方角色獲得+3/+3，並賦予其所有通用關鍵字效果。從牌庫或手牌中選擇一張費用不大於5的卡牌，免費打出它。", 
            Rarity.LEGENDARY, SpellType.SPECIAL, Faction.NEUTRAL);
        allCards.put(culinaryMasterpiece.getName(), culinaryMasterpiece);
        allSpells.add(culinaryMasterpiece);

        // 添加更多中立卡牌
        CharacterCard gourmetJudge = new CharacterCard(
            "美食評審", 5, "【開胃】：查看牌庫頂的3張牌，選擇1張加入手牌。【拼盤】：當控制3種不同陣營的卡牌時，抽一張牌。", 
            Rarity.EPIC, 3, 4, 5, false, Faction.NEUTRAL);
        allCards.put(gourmetJudge.getName(), gourmetJudge);
        allCharacters.add(gourmetJudge);
        
        CharacterCard universalIngredient = new CharacterCard(
            "萬能食材", 2, "【開胃】：獲取一個你選擇的陣營標籤。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 2, 2, 3, true, Faction.NEUTRAL);
        allCards.put(universalIngredient.getName(), universalIngredient);
        allCharacters.add(universalIngredient);
        
        CharacterCard cuisineWanderer = new CharacterCard(
            "料理流浪者", 3, "【開胃】：選擇一個陣營，獲得該陣營的一個隨機關鍵字效果。【酥脆(1)】：減免1點傷害。", 
            Rarity.RARE, 3, 3, 3, true, Faction.NEUTRAL);
        allCards.put(cuisineWanderer.getName(), cuisineWanderer);
        allCharacters.add(cuisineWanderer);
        
        CharacterCard dishDefender = new CharacterCard(
            "菜品守衛", 4, "【擺盤】：敵人必須優先攻擊這個單位。【開胃】：根據你的陣營獲得對應關鍵字效果。", 
            Rarity.COMMON, 2, 6, 5, false, Faction.NEUTRAL);
        allCards.put(dishDefender.getName(), dishDefender);
        allCharacters.add(dishDefender);
        
        CharacterCard flavorBlender = new CharacterCard(
            "風味調和師", 3, "【拼盤】：場上每有一種不同陣營的卡牌，獲得+1/+1。【回味】：抽一張牌。", 
            Rarity.RARE, 2, 2, 3, false, Faction.NEUTRAL);
        allCards.put(flavorBlender.getName(), flavorBlender);
        allCharacters.add(flavorBlender);
        
        SpellCard tasteTest = new SpellCard(
            "味道測試", 1, "查看牌庫頂的3張牌，選擇1張加入手牌，其餘放回牌庫頂。", 
            Rarity.COMMON, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(tasteTest.getName(), tasteTest);
        allSpells.add(tasteTest);
        
        SpellCard recipeResearch = new SpellCard(
            "食譜研究", 3, "從卡牌庫中發現3張不同陣營的卡牌，選擇1張加入手牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(recipeResearch.getName(), recipeResearch);
        allSpells.add(recipeResearch);
        
        SpellCard fusionCuisine = new SpellCard(
            "融合料理", 4, "選擇兩個友方角色，將其攻擊力和生命值加總，創造一個新的融合角色。", 
            Rarity.EPIC, SpellType.TRANSFORM, Faction.NEUTRAL);
        allCards.put(fusionCuisine.getName(), fusionCuisine);
        allSpells.add(fusionCuisine);
        
        FieldCard culinaryClass = FieldCard.createEnvironmentField(
            "料理課堂", 3, "每當打出一張卡牌時，有20%機率使其獲得一個隨機關鍵字效果。", 
            Rarity.RARE, 3, Faction.NEUTRAL);
        allCards.put(culinaryClass.getName(), culinaryClass);
        allFieldCards.add(culinaryClass);
        
        FieldCard travelingFoodTruck = FieldCard.createEnvironmentField(
            "流動餐車", 2, "每回合結束時，有25%機率從牌庫中抽取一張隨機陣營的卡牌。", 
            Rarity.COMMON, 3, Faction.NEUTRAL);
        allCards.put(travelingFoodTruck.getName(), travelingFoodTruck);
        allFieldCards.add(travelingFoodTruck);

        // 添加更多傳說卡牌
        CharacterCard grandBanquetMaster = new CharacterCard(
            "大宴會主廚", 7, "【開胃】：從牌庫中抽取每個陣營的一張卡牌。【拼盤】：當控制所有陣營的卡牌時，對所有敵方單位造成3點傷害。", 
            Rarity.LEGENDARY, 5, 5, 7, true, Faction.NEUTRAL);
        allCards.put(grandBanquetMaster.getName(), grandBanquetMaster);
        allCharacters.add(grandBanquetMaster);
        
        CharacterCard universalTaste = new CharacterCard(
            "環球味覺", 8, "【開胃】：獲得所有陣營關鍵字效果中的一個。【拼盤】：場上每有一種不同陣營的卡牌，獲得+1/+1。", 
            Rarity.LEGENDARY, 4, 6, 6, false, Faction.NEUTRAL);
        allCards.put(universalTaste.getName(), universalTaste);
        allCharacters.add(universalTaste);
        
        // 添加更多中立場地卡
        FieldCard worldCuisineAcademy = FieldCard.createEnvironmentField(
            "世界料理學院", 4, "場上每有一種不同陣營的卡牌，所有友方角色獲得+1/+1。每當打出一張與場上角色不同陣營的卡牌，抽一張牌。", 
            Rarity.EPIC, 3, Faction.NEUTRAL);
        allCards.put(worldCuisineAcademy.getName(), worldCuisineAcademy);
        allFieldCards.add(worldCuisineAcademy);
        
        FieldCard universalCookbook = FieldCard.createToolField(
            "萬用食譜", 2, "每回合可查看牌庫頂的三張牌，選擇一張加入手牌。", 
            Rarity.COMMON, FieldEffectType.DRAW, 3, 2, Faction.NEUTRAL);
        allCards.put(universalCookbook.getName(), universalCookbook);
        allFieldCards.add(universalCookbook);
        
        FieldCard fusionKitchen = FieldCard.createEnvironmentField(
            "融合廚房", 3, "每當打出一張卡牌，有20%機率使其獲得一個隨機陣營的關鍵字效果。", 
            Rarity.RARE, 3, Faction.NEUTRAL);
        allCards.put(fusionKitchen.getName(), fusionKitchen);
        allFieldCards.add(fusionKitchen);
        
        FieldCard gastronomicLaboratory = FieldCard.createTechniqueField(
            "美食實驗室", 3, "使所有友方角色在打出時，有30%機率獲得一個隨機關鍵字效果。", 
            Rarity.RARE, FieldEffectType.SPECIAL, 2, 3, Faction.NEUTRAL);
        allCards.put(gastronomicLaboratory.getName(), gastronomicLaboratory);
        allFieldCards.add(gastronomicLaboratory);
        
        FieldCard culinaryConclave = FieldCard.createToolField(
            "料理議會", 4, "每回合可從牌庫中發現三張不同陣營的卡牌，選擇一張加入手牌。", 
            Rarity.EPIC, FieldEffectType.DRAW, 2, 3, Faction.NEUTRAL);
        allCards.put(culinaryConclave.getName(), culinaryConclave);
        allFieldCards.add(culinaryConclave);
        
        FieldCard globalKitchen = FieldCard.createEnvironmentField(
            "環球廚房", 5, "場上所有角色獲得所屬陣營的一個關鍵字效果。每回合結束時，有30%機率從牌庫中抽取一張隨機陣營的卡牌。", 
            Rarity.EPIC, 3, Faction.NEUTRAL);
        allCards.put(globalKitchen.getName(), globalKitchen);
        allFieldCards.add(globalKitchen);
    }
    
    @Override
    public String getFactionName() {
        return "中立";
    }
} 