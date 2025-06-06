package com.example.game.card.faction;

import java.util.List;
import java.util.Map;

import com.example.game.card.Card;
import com.example.game.card.CastleCard;
import com.example.game.card.CastleEffectImpl;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.FieldCard;
import com.example.game.card.Rarity;
import com.example.game.card.SpellCard;
import com.example.game.card.SpellType;

/**
 * 火辣王國陣營卡牌初始化實現類
 */
public class SpicyKingdomInitializer implements FactionCardInitializer {
    
    private CharacterCard createCharacterCard(
        String name, int cost, String description, Rarity rarity,
        int attack, int health, Faction faction, int points
    ) {
        return CharacterCard.builder()
            .name(name)
            .cost(cost)
            .description(description)
            .rarity(rarity)
            .attack(attack)
            .health(health)
            .faction(faction)
            .points(points)
            .build();
    }
    
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
        return "火辣王國";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 辣醬類角色
        CharacterCard oilChiliSoldier = createCharacterCard(
            "油潑辣子斥候 (Chili Oil Scout)", 3, "【開胃】：獲得+1攻擊力。【回味】：使一個友方角色獲得+1攻擊力。", 
            Rarity.CASUAL_BITES, 3, 2, Faction.SPICY_KINGDOM, 2);
        allCards.put(oilChiliSoldier.getName(), oilChiliSoldier);
        allCharacters.add(oilChiliSoldier);
        
        CharacterCard srirachaBerserker = createCharacterCard(
            "是拉差狂戰士 (Sriracha Berserker)", 5, "【開胃】：自身攻擊力+2。【嗆辣】：每次攻擊後，自身生命值-1，攻擊力+1。", 
            Rarity.CASUAL_BITES, 3, 5, Faction.SPICY_KINGDOM, 3);
        allCards.put(srirachaBerserker.getName(), srirachaBerserker);
        allCharacters.add(srirachaBerserker);
        
        CharacterCard doubanjiangMage = createCharacterCard(
            "豆瓣醬法師 (Doubanjiang Mage)", 3, "【開胃】：使一個敵方角色獲得-1/-1。【連擊】：攻擊後，有40%機率再次攻擊。", 
            Rarity.GOURMET_DELIGHT, 2, 4, Faction.SPICY_KINGDOM, 2);
        allCards.put(doubanjiangMage.getName(), doubanjiangMage);
        allCharacters.add(doubanjiangMage);
        
        CharacterCard sambalGuardian = createCharacterCard(
            "參巴醬守衛 (Sambal Guardian)", 4, "【嗆辣】：每回合結束時，對對手造成1點傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, Faction.SPICY_KINGDOM, 2);
        allCards.put(sambalGuardian.getName(), sambalGuardian);
        allCharacters.add(sambalGuardian);
        
        // 麻辣火鍋類角色
        CharacterCard hotPotEmperor = createCharacterCard(
            "麻辣火鍋帝王 (Hot Pot Emperor)", 8, "【開胃】：對所有敵方角色造成3點傷害並施加【嗆辣】效果。【爆炒】：攻擊時有50%機率摧毀目標，每回合只能發動一次。【回味】：對敵方英雄造成5點傷害。", 
            Rarity.ULTIMATE_TASTE, 5, 8, Faction.SPICY_KINGDOM, 5);
        allCards.put(hotPotEmperor.getName(), hotPotEmperor);
        allCharacters.add(hotPotEmperor);
        
        CharacterCard sichuanHotPotGuard = createCharacterCard(
            "四川火鍋守護者 (Sichuan Hot Pot Guardian)", 6, "【擺盤】：敵人必須優先攻擊這個單位。【嗆辣】：每回合結束時，對兩個隨機敵方角色造成1點傷害。", 
            Rarity.CASUAL_BITES, 5, 6, Faction.SPICY_KINGDOM, 3);
        allCards.put(sichuanHotPotGuard.getName(), sichuanHotPotGuard);
        allCharacters.add(sichuanHotPotGuard);
        
        CharacterCard spicySoupTureen = createCharacterCard(
            "麻辣湯盅法師 (Spicy Soup Tureen Mage)", 6, "【開胃】：對所有敵方角色造成1點傷害。【爆炒】：攻擊時有30%機率造成雙倍傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 6, Faction.SPICY_KINGDOM, 3);
        allCards.put(spicySoupTureen.getName(), spicySoupTureen);
        allCharacters.add(spicySoupTureen);
        
        CharacterCard boiledFishMaster = createCharacterCard(
            "水煮魚大師 (Boiled Fish Master)", 4, "【開胃】：對一個敵方角色造成3點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 3, 5, Faction.SPICY_KINGDOM, 2);
        allCards.put(boiledFishMaster.getName(), boiledFishMaster);
        allCharacters.add(boiledFishMaster);
        
        // 辣麵類角色
        CharacterCard dandanNoodleAdept = createCharacterCard(
            "擔擔麵達人 (Dandan Noodle Adept)", 3, "【連擊】：攻擊後，有50%機率可再次攻擊。【嗆辣】：受到傷害時，攻擊力+1。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(dandanNoodleAdept.getName(), dandanNoodleAdept);
        allCharacters.add(dandanNoodleAdept);
        
        CharacterCard spicyRamenWarrior = createCharacterCard(
            "麻辣拉麵武士 (Spicy Ramen Warrior)", 3, "【彈牙】：每回合可攻擊 2 次。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(spicyRamenWarrior.getName(), spicyRamenWarrior);
        allCharacters.add(spicyRamenWarrior);
        
        CharacterCard malatangSorcerer = createCharacterCard(
            "麻辣燙法師 (Malatang Sorcerer)", 4, "【開胃】：使一個敵方角色獲得【嗆辣】效果。【爆炒】：當攻擊時，有25%機率直接消滅目標。", 
            Rarity.GOURMET_DELIGHT, 5, 4, Faction.SPICY_KINGDOM, 3);
        allCards.put(malatangSorcerer.getName(), malatangSorcerer);
        allCharacters.add(malatangSorcerer);
        
        CharacterCard redOilNoodleSniper = createCharacterCard(
            "紅油麵狙擊手 (Red Oil Noodle Sniper)", 4, "【遠程】：無視防禦進行攻擊。【潛行】：進場時不會觸發敵方的陷阱效果。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(redOilNoodleSniper.getName(), redOilNoodleSniper);
        allCharacters.add(redOilNoodleSniper);
        
        // 辣餃類角色
        CharacterCard redOilDumplingArcher = createCharacterCard(
            "紅油餃子射手 (Red Oil Dumpling Archer)", 2, "【彈牙】：每回合可攻擊 2 次。【嗆辣】：對被攻擊目標施加【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 1);
        allCards.put(redOilDumplingArcher.getName(), redOilDumplingArcher);
        allCharacters.add(redOilDumplingArcher);
        
        CharacterCard spicyWontonNinja = createCharacterCard(
            "紅油抄手忍者 (Spicy Wonton Ninja)", 3, "【潛行】：進場時不會觸發敵方的陷阱效果。【嗆辣】：對被攻擊目標施加【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(spicyWontonNinja.getName(), spicyWontonNinja);
        allCharacters.add(spicyWontonNinja);
        
        CharacterCard chiliOilGyozaTosser = createCharacterCard(
            "辣油煎餃投擲者 (Chili Oil Gyoza Tosser)", 2, "【開胃】：對一個敵方角色造成1點傷害。【連擊】：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.SPICY_KINGDOM, 1);
        allCards.put(chiliOilGyozaTosser.getName(), chiliOilGyozaTosser);
        allCharacters.add(chiliOilGyozaTosser);
        
        CharacterCard spicyDumplingMerchant = createCharacterCard(
            "麻辣水餃商人 (Spicy Dumpling Merchant)", 2, "【開胃】：抽一張牌。【爆炒】：如果抽到的是火辣王國卡牌，獲得+1/+1。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 1);
        allCards.put(spicyDumplingMerchant.getName(), spicyDumplingMerchant);
        allCharacters.add(spicyDumplingMerchant);
        
        // 辣燒烤類角色
        CharacterCard spicyGrilledFishKnight = createCharacterCard(
            "麻辣烤魚騎士 (Spicy Grilled Fish Knight)", 5, "【開胃】：對所有敵方角色造成1點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 3, 5, Faction.SPICY_KINGDOM, 3);
        allCards.put(spicyGrilledFishKnight.getName(), spicyGrilledFishKnight);
        allCharacters.add(spicyGrilledFishKnight);
        
        CharacterCard hotWingsBreather = createCharacterCard(
            "辣味雞翅吐火者 (Hot Wings Fire Breather)", 5, "【開胃】：對所有敵方角色造成1點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 3, 5, Faction.SPICY_KINGDOM, 3);
        allCards.put(hotWingsBreather.getName(), hotWingsBreather);
        allCharacters.add(hotWingsBreather);
        
        CharacterCard spicySkewersWarrior = createCharacterCard(
            "麻辣串串戰士 (Spicy Skewers Warrior)", 2, "【開胃】：獲得+1攻擊力。【連擊】：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.SPICY_KINGDOM, 1);
        allCards.put(spicySkewersWarrior.getName(), spicySkewersWarrior);
        allCharacters.add(spicySkewersWarrior);
        
        CharacterCard saucyRibsGuardian = createCharacterCard(
            "醬香排骨守衛 (Saucy Ribs Guardian)", 3, "【嗆辣】：每回合結束時對敵方英雄造成1點傷害。【回味】：回復1點生命值。", 
            Rarity.CASUAL_BITES, 3, 4, Faction.SPICY_KINGDOM, 2);
        allCards.put(saucyRibsGuardian.getName(), saucyRibsGuardian);
        allCharacters.add(saucyRibsGuardian);
        
        // 辣炒菜類角色
        CharacterCard mapoTofuMaster = createCharacterCard(
            "麻婆豆腐大師 (Mapo Tofu Master)", 6, "【開胃】：對所有敵方角色造成2點傷害。【連擊】：攻擊後，有50%機率再次攻擊。", 
            Rarity.ULTIMATE_TASTE, 4, 6, Faction.SPICY_KINGDOM, 4);
        allCards.put(mapoTofuMaster.getName(), mapoTofuMaster);
        allCharacters.add(mapoTofuMaster);
        
        CharacterCard kungpaoPaladin = createCharacterCard(
            "宮保聖騎士 (Kung Pao Paladin)", 7, "【開胃】：使所有友方角色獲得+1/+1。【爆炒】：攻擊時有30%機率使目標失去所有效果。", 
            Rarity.GOURMET_DELIGHT, 3, 7, Faction.SPICY_KINGDOM, 4);
        allCards.put(kungpaoPaladin.getName(), kungpaoPaladin);
        allCharacters.add(kungpaoPaladin);
        
        CharacterCard spicyEggplantPriest = createCharacterCard(
            "魚香茄子祭司 (Yu-Shiang Eggplant Priest)", 3, "【開胃】：使一個友方角色獲得【爆炒】效果。【彈牙】：每回合可攻擊 2 次。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(spicyEggplantPriest.getName(), spicyEggplantPriest);
        allCharacters.add(spicyEggplantPriest);
        
        CharacterCard chilliChickenTactician = createCharacterCard(
            "辣子雞戰術家 (Chilli Chicken Tactician)", 4, "【開胃】：對一個敵方角色造成2點傷害。【嗆辣】：每次攻擊時，有50%機率使目標無法使用特殊效果一回合。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.SPICY_KINGDOM, 3);
        allCards.put(chilliChickenTactician.getName(), chilliChickenTactician);
        allCharacters.add(chilliChickenTactician);
        
        // 辣小吃類角色
        CharacterCard spicyBeefJerkyRogue = createCharacterCard(
            "麻辣牛肉幹盜賊 (Spicy Beef Jerky Rogue)", 3, "【開胃】：抽一張牌。【連擊】：攻擊後，有35%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.SPICY_KINGDOM, 2);
        allCards.put(spicyBeefJerkyRogue.getName(), spicyBeefJerkyRogue);
        allCharacters.add(spicyBeefJerkyRogue);
        
        CharacterCard spicyTofu = createCharacterCard(
            "麻辣豆干行者 (Spicy Tofu Wanderer)", 2, "【開胃】：抽一張牌。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.SPICY_KINGDOM, 1);
        allCards.put(spicyTofu.getName(), spicyTofu);
        allCharacters.add(spicyTofu);
        
        CharacterCard spicyDuckNeckGeneral = createCharacterCard(
            "香辣鴨脖將軍 (Spicy Duck Neck General)", 4, "【開胃】：對一個敵方角色造成2點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.SPICY_KINGDOM, 3);
        allCards.put(spicyDuckNeckGeneral.getName(), spicyDuckNeckGeneral);
        allCharacters.add(spicyDuckNeckGeneral);
        
        CharacterCard hotpotFlavoredChips = createCharacterCard(
            "火鍋味薯片戰士 (Hotpot Flavored Chips Warrior)", 3, "【開胃】：獲得+1攻擊力。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(hotpotFlavoredChips.getName(), hotpotFlavoredChips);
        allCharacters.add(hotpotFlavoredChips);
        
        // 辣香料類角色
        CharacterCard sichuanPepperDuelist = createCharacterCard(
            "花椒決鬥者 (Sichuan Pepper Duelist)", 4, "【開胃】：使一個敵方角色獲得【嗆辣】效果。【連擊】：攻擊後，有40%機率再次攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.SPICY_KINGDOM, 3);
        allCards.put(sichuanPepperDuelist.getName(), sichuanPepperDuelist);
        allCharacters.add(sichuanPepperDuelist);
        
        CharacterCard fiveSpiceSage = createCharacterCard(
            "五香賢者 (Five Spice Sage)", 5, "【開胃】：使所有友方角色獲得+1/+1。【回味】：死亡時抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 3, 5, Faction.SPICY_KINGDOM, 3);
        allCards.put(fiveSpiceSage.getName(), fiveSpiceSage);
        allCharacters.add(fiveSpiceSage);
        
        CharacterCard chilliPowderElementalist = createCharacterCard(
            "辣椒粉元素使 (Chilli Powder Elementalist)", 3, "【開胃】：對所有敵方角色造成1點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.SPICY_KINGDOM, 2);
        allCards.put(chilliPowderElementalist.getName(), chilliPowderElementalist);
        allCharacters.add(chilliPowderElementalist);
        
        CharacterCard hotCurryMonarch = createCharacterCard(
            "咖哩君王 (Hot Curry Monarch)", 6, "【開胃】：對所有敵方角色造成2點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。【回味】：死亡時對敵方英雄造成3點傷害。", 
            Rarity.ULTIMATE_TASTE, 4, 6, Faction.SPICY_KINGDOM, 4);
        allCards.put(hotCurryMonarch.getName(), hotCurryMonarch);
        allCharacters.add(hotCurryMonarch);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard spicyExplosion = new SpellCard(
            "辣味爆炸術 (Spicy Explosion Technique)", 3, "對所有敵方角色造成2點傷害，並使其獲得【灼燒】效果：每回合受到1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(spicyExplosion.getName(), spicyExplosion);
        allSpells.add(spicyExplosion);
        
        SpellCard hotPotFeast = new SpellCard(
            "火鍋盛宴 (Hot Pot Feast)", 5, "使所有友方角色獲得+1/+1和【爆炒】效果。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotPotFeast.getName(), hotPotFeast);
        allSpells.add(hotPotFeast);
        
        SpellCard spicyRain = new SpellCard(
            "辣油轟炸 (Chili Oil Bombing)", 4, "對所有敵方角色造成2點傷害，並有50%機率使其獲得【嗆辣】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(spicyRain.getName(), spicyRain);
        allSpells.add(spicyRain);
        
        SpellCard volcanicEruption = new SpellCard(
            "麻辣火山爆發 (Mala Volcanic Eruption)", 6, "對所有敵方角色造成3點傷害，並摧毀敵方一面城牆。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(volcanicEruption.getName(), volcanicEruption);
        allSpells.add(volcanicEruption);
        
        SpellCard spicyBoost = new SpellCard(
            "辣度增強劑 (Spiciness Enhancer)", 2, "使一個友方角色獲得+2攻擊力和【爆炒】效果，持續2回合。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyBoost.getName(), spicyBoost);
        allSpells.add(spicyBoost);
        
        // 更多法術卡以達到20張
        SpellCard redPepperRush = new SpellCard(
            "紅油辣椒衝擊 (Red Oil Pepper Rush)", 2, "使一個友方角色獲得+2攻擊力和【嗆辣】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(redPepperRush.getName(), redPepperRush);
        allSpells.add(redPepperRush);
        
        SpellCard spicyTransformation = new SpellCard(
            "辣味變身料理 (Spicy Transformation Cuisine)", 5, "使一個友方角色獲得+2/+2和【爆炒】效果，攻擊時有25%機率造成雙倍傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.TRANSFORM, Faction.SPICY_KINGDOM);
        allCards.put(spicyTransformation.getName(), spicyTransformation);
        allSpells.add(spicyTransformation);
        
        SpellCard chilliStorm = new SpellCard(
            "辣椒油風暴 (Chili Oil Storm)", 3, "對所有敵方角色造成1點傷害，並使其本回合內無法使用特殊效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, Faction.SPICY_KINGDOM);
        allCards.put(chilliStorm.getName(), chilliStorm);
        allSpells.add(chilliStorm);
        
        SpellCard hotSauceSplash = new SpellCard(
            "辣醬濺射攻擊 (Hot Sauce Splash Attack)", 2, "對一個敵方角色造成3點傷害，並對其相鄰單位造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(hotSauceSplash.getName(), hotSauceSplash);
        allSpells.add(hotSauceSplash);
        
        SpellCard spicyArmor = new SpellCard(
            "辣味防護醬料 (Spicy Armor Sauce)", 3, "使一個友方角色獲得+0/+3和【嗆辣】反擊效果：當被攻擊時，對攻擊者造成2點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyArmor.getName(), spicyArmor);
        allSpells.add(spicyArmor);
        
        SpellCard flamingWeapon = new SpellCard(
            "燒烤辣椒武器 (Grilled Pepper Weapon)", 4, "使一個友方角色攻擊力+3，並獲得【爆炒】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(flamingWeapon.getName(), flamingWeapon);
        allSpells.add(flamingWeapon);
        
        SpellCard spicyRecall = new SpellCard(
            "辣味食譜回顧 (Spicy Recipe Recall)", 1, "將一個友方【嗆辣】效果的角色返回手牌，並使其費用-2。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicyRecall.getName(), spicyRecall);
        allSpells.add(spicyRecall);
        
        SpellCard hotPotion = new SpellCard(
            "辣椒精華萃取 (Hot Pepper Extract)", 2, "使一個友方角色獲得【爆炒】效果和【嗆辣】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotPotion.getName(), hotPotion);
        allSpells.add(hotPotion);
        
        SpellCard blazingAssault = new SpellCard(
            "麻辣烹飪突襲 (Mala Cooking Assault)", 5, "對所有敵方角色造成2點傷害，己方所有【嗆辣】效果角色攻擊力+2。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(blazingAssault.getName(), blazingAssault);
        allSpells.add(blazingAssault);
        
        SpellCard chilliBarrage = new SpellCard(
            "泡椒彈幕攻勢 (Pickled Pepper Barrage)", 3, "隨機對敵方角色造成共5點傷害，分配到1-5個目標。", 
            Rarity.GOURMET_DELIGHT, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(chilliBarrage.getName(), chilliBarrage);
        allSpells.add(chilliBarrage);
        
        SpellCard spicyTrap = new SpellCard(
            "麻辣火鍋陷阱 (Mala Hot Pot Trap)", 2, "秘密：當敵方出牌時，使其獲得【嗆辣】效果並受到2點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicyTrap.getName(), spicyTrap);
        allSpells.add(spicyTrap);
        
        SpellCard hotFlame = new SpellCard(
            "宮保雞丁烈焰 (Kung Pao Chicken Flame)", 4, "對一個敵方角色造成6點傷害，如果目標死亡，則對所有敵方角色造成1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(hotFlame.getName(), hotFlame);
        allSpells.add(hotFlame);
        
        SpellCard spicyRegeneration = new SpellCard(
            "辣椒湯再生術 (Hot Pepper Soup Regeneration)", 3, "使一個友方角色完全恢復生命值並獲得【嗆辣】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, Faction.SPICY_KINGDOM);
        allCards.put(spicyRegeneration.getName(), spicyRegeneration);
        allSpells.add(spicyRegeneration);
        
        SpellCard volcanicShield = new SpellCard(
            "麻婆豆腐護盾 (Mapo Tofu Shield)", 5, "使所有友方角色獲得+0/+2和【嗆辣】反擊效果。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(volcanicShield.getName(), volcanicShield);
        allSpells.add(volcanicShield);
        
        SpellCard spicyReinforcement = new SpellCard(
            "水煮魚增援 (Boiled Fish Reinforcement)", 6, "召喚兩個2/2的辣椒士兵，它們具有【嗆辣】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.SUMMON, Faction.SPICY_KINGDOM);
        allCards.put(spicyReinforcement.getName(), spicyReinforcement);
        allSpells.add(spicyReinforcement);
        
        SpellCard chiliBoost = new SpellCard(
            "油潑辣子強化 (Chili Oil Boost)", 4, "使一個友方角色獲得+3攻擊力和【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(chiliBoost.getName(), chiliBoost);
        allSpells.add(chiliBoost);
        
        SpellCard pepperStorm = new SpellCard(
            "花椒風暴襲擊 (Sichuan Pepper Storm)", 5, "對所有敵方角色造成3點傷害，並使其獲得【灼燒】效果：每回合受到2點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(pepperStorm.getName(), pepperStorm);
        allSpells.add(pepperStorm);
        
        SpellCard wasabiBlast = new SpellCard(
            "山葵醬爆發 (Wasabi Sauce Blast)", 6, "對所有敵方角色造成4點傷害，並使其獲得【灼燒】效果：每回合受到3點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(wasabiBlast.getName(), wasabiBlast);
        allSpells.add(wasabiBlast);
        
        SpellCard spicyStrike = new SpellCard(
            "紅油抄手打擊 (Spicy Wonton Strike)", 2, "對一個敵方角色造成2點傷害，並使其獲得【灼燒】效果：每回合受到1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyStrike.getName(), spicyStrike);
        allSpells.add(spicyStrike);
        
        SpellCard hotSauce = new SpellCard(
            "辣醬", 1, "使一個友方角色獲得+1攻擊力和【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotSauce.getName(), hotSauce);
        allSpells.add(hotSauce);
        
        SpellCard spicyTransform = new SpellCard(
            "辣味變形", 3, "將一個友方角色變形為具有【灼燒】效果的3/3角色。", 
            Rarity.GOURMET_DELIGHT, SpellType.TRANSFORM, Faction.SPICY_KINGDOM);
        allCards.put(spicyTransform.getName(), spicyTransform);
        allSpells.add(spicyTransform);
        
        SpellCard pepperDebuff = new SpellCard(
            "胡椒削弱", 2, "使一個敵方角色獲得-2攻擊力和【灼燒】效果：每回合受到1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.DEBUFF, Faction.SPICY_KINGDOM);
        allCards.put(pepperDebuff.getName(), pepperDebuff);
        allSpells.add(pepperDebuff);
        
        SpellCard chiliShot = new SpellCard(
            "辣椒射擊", 1, "對一個敵方角色造成1點傷害，並使其獲得【灼燒】效果：每回合受到1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(chiliShot.getName(), chiliShot);
        allSpells.add(chiliShot);
        
        SpellCard spicyBuff = new SpellCard(
            "辣味強化", 2, "使一個友方角色獲得+2攻擊力和【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyBuff.getName(), spicyBuff);
        allSpells.add(spicyBuff);
        
        SpellCard hotBuff = new SpellCard(
            "熱力強化", 2, "使一個友方角色獲得+2攻擊力和【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotBuff.getName(), hotBuff);
        allSpells.add(hotBuff);
        
        SpellCard spicySpecial = new SpellCard(
            "辣味特技", 4, "使一個友方角色獲得【灼燒】效果：攻擊時額外造成2點傷害，並獲得+2攻擊力。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicySpecial.getName(), spicySpecial);
        allSpells.add(spicySpecial);
        
        SpellCard pepperBuff = new SpellCard(
            "胡椒強化", 2, "使一個友方角色獲得+2攻擊力和【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(pepperBuff.getName(), pepperBuff);
        allSpells.add(pepperBuff);
        
        SpellCard wasabiStorm = new SpellCard(
            "芥末風暴", 5, "對所有敵方角色造成3點傷害，並使其獲得【灼燒】效果：每回合受到2點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(wasabiStorm.getName(), wasabiStorm);
        allSpells.add(wasabiStorm);
        
        SpellCard chiliDamage = new SpellCard(
            "辣椒傷害", 3, "對一個敵方角色造成3點傷害，並使其獲得【灼燒】效果：每回合受到1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(chiliDamage.getName(), chiliDamage);
        allSpells.add(chiliDamage);
        
        SpellCard spicySpecial2 = new SpellCard(
            "辣味特技2", 4, "使一個友方角色獲得【灼燒】效果：攻擊時額外造成2點傷害，並獲得+2攻擊力。", 
            Rarity.GOURMET_DELIGHT, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicySpecial2.getName(), spicySpecial2);
        allSpells.add(spicySpecial2);
        
        SpellCard pepperDamage = new SpellCard(
            "胡椒傷害", 3, "對一個敵方角色造成3點傷害，並使其獲得【灼燒】效果：每回合受到1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(pepperDamage.getName(), pepperDamage);
        allSpells.add(pepperDamage);
        
        SpellCard wasabiHeal = new SpellCard(
            "芥末治療", 3, "恢復一個友方角色3點生命值，並使其獲得【灼燒】效果：攻擊時額外造成1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.HEALING, Faction.SPICY_KINGDOM);
        allCards.put(wasabiHeal.getName(), wasabiHeal);
        allSpells.add(wasabiHeal);
        
        SpellCard spicyBuff2 = new SpellCard(
            "辣味強化2", 4, "使一個友方角色獲得+3攻擊力和【灼燒】效果：攻擊時額外造成2點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyBuff2.getName(), spicyBuff2);
        allSpells.add(spicyBuff2);
        
        SpellCard chiliSummon = new SpellCard(
            "辣椒召喚", 3, "召喚一個具有【灼燒】效果的2/2角色。", 
            Rarity.GOURMET_DELIGHT, SpellType.SUMMON, Faction.SPICY_KINGDOM);
        allCards.put(chiliSummon.getName(), chiliSummon);
        allSpells.add(chiliSummon);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard spicySauce = FieldCard.createEnvironmentField(
            "老乾媽辣醬工廠 (Laoganma Chili Sauce Factory)", 2, "使一個友方角色獲得+2攻擊力，但附加【嗆辣】效果。", 
            Rarity.CASUAL_BITES, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicySauce.getName(), spicySauce);
        allFieldCards.add(spicySauce);
        
        FieldCard chilliOil = FieldCard.createEnvironmentField(
            "紅油潑灑技術區 (Red Oil Splashing Zone)", 3, "給一個友方角色添加【爆炒】效果：可在戰鬥階段直接消滅一個生命值低於3的敵方單位。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.SPICY_KINGDOM);
        allCards.put(chilliOil.getName(), chilliOil);
        allFieldCards.add(chilliOil);
        
        FieldCard volcanicKitchen = FieldCard.createEnvironmentField(
            "川菜火山廚房 (Sichuan Volcanic Kitchen)", 5, "每回合開始時，對所有敵方角色造成1點傷害。友方火辣王國角色獲得【爆炒】效果，攻擊時有15%機率直接消滅目標。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.SPICY_KINGDOM);
        allCards.put(volcanicKitchen.getName(), volcanicKitchen);
        allFieldCards.add(volcanicKitchen);
        
        FieldCard pepperyKitchen = FieldCard.createEnvironmentField(
            "麻辣香鍋烹飪區 (Mala Fragrant Pot Cooking Area)", 3, "友方火辣王國角色攻擊力+1。每當打出一張火辣王國卡牌時，有25%機率使其獲得【嗆辣】效果。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.SPICY_KINGDOM);
        allCards.put(pepperyKitchen.getName(), pepperyKitchen);
        allFieldCards.add(pepperyKitchen);
        
        FieldCard spicyWok = FieldCard.createEnvironmentField(
            "麻辣鍋具烹飪臺 (Mala Wok Cooking Station)", 2, "每回合可以使一個友方角色獲得+1攻擊力和【爆炒】效果。", 
            Rarity.CASUAL_BITES, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicyWok.getName(), spicyWok);
        allFieldCards.add(spicyWok);
        
        FieldCard spicyLaboratory = FieldCard.createEnvironmentField(
            "辣味調味料實驗室 (Spicy Seasoning Laboratory)", 4, "每回合開始時，有30%機率發現一張火辣王國法術卡。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicyLaboratory.getName(), spicyLaboratory);
        allFieldCards.add(spicyLaboratory);
        
        FieldCard chilliGarden = FieldCard.createEnvironmentField(
            "辣椒醬釀造園 (Chili Sauce Brewing Garden)", 3, "每回合結束時，為一個隨機友方角色獲得+1攻擊力。場上每有一個火辣王國角色，增加5%機率。", 
            Rarity.CASUAL_BITES, 3, Faction.SPICY_KINGDOM);
        allCards.put(chilliGarden.getName(), chilliGarden);
        allFieldCards.add(chilliGarden);
        
        FieldCard spicyMortar = FieldCard.createEnvironmentField(
            "辣椒醬研磨站 (Chili Paste Grinding Station)", 2, "使一個友方角色獲得【嗆辣】效果和+2攻擊力。", 
            Rarity.CASUAL_BITES, 2, Faction.SPICY_KINGDOM);
        allCards.put(spicyMortar.getName(), spicyMortar);
        allFieldCards.add(spicyMortar);
        
        FieldCard hotSpiceMix = FieldCard.createEnvironmentField(
            "特級辣粉調製區 (Premium Spice Mix Area)", 3, "使一個友方角色獲得【爆炒】效果，攻擊時有20%機率造成雙倍傷害。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.SPICY_KINGDOM);
        allCards.put(hotSpiceMix.getName(), hotSpiceMix);
        allFieldCards.add(hotSpiceMix);
        
        FieldCard spicyAura = FieldCard.createEnvironmentField(
            "麻辣香氣氛圍 (Mala Fragrance Aura)", 4, "所有友方火辣王國角色獲得+1/+1。當敵方角色攻擊友方角色時，有20%機率使攻擊者獲得【嗆辣】效果。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.SPICY_KINGDOM);
        allCards.put(spicyAura.getName(), spicyAura);
        allFieldCards.add(spicyAura);

        FieldCard spiceGarden = FieldCard.createEnvironmentField(
            "香料栽培園地 (Spice Cultivation Garden)", 3, "每回合開始時，使一個敵方角色獲得-1/-1。", 
            Rarity.CASUAL_BITES, 2, Faction.SPICY_KINGDOM);
        allCards.put(spiceGarden.getName(), spiceGarden);
        allFieldCards.add(spiceGarden);

        FieldCard chiliField = FieldCard.createEnvironmentField(
            "辣椒醬製作坊 (Chili Sauce Workshop)", 2, "使一個友方角色獲得【連擊】效果：攻擊後，有30%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, Faction.SPICY_KINGDOM);
        allCards.put(chiliField.getName(), chiliField);
        allFieldCards.add(chiliField);

        FieldCard spiceMarket = FieldCard.createEnvironmentField(
            "麻辣調味市場 (Spicy Seasoning Market)", 4, "每回合結束時，對所有敵方角色造成1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.SPICY_KINGDOM);
        allCards.put(spiceMarket.getName(), spiceMarket);
        allFieldCards.add(spiceMarket);

        FieldCard pepperPalace = FieldCard.createEnvironmentField(
            "麻辣火鍋宮殿 (Mala Hot Pot Palace)", 5, "友方角色獲得+1/+1，且每回合開始時對一個敵方角色造成1點傷害。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.SPICY_KINGDOM);
        allCards.put(pepperPalace.getName(), pepperPalace);
        allFieldCards.add(pepperPalace);

        FieldCard spiceSanctuary = FieldCard.createEnvironmentField(
            "川菜聖殿餐廳 (Sichuan Cuisine Sanctuary)", 6, "所有友方角色獲得【連擊】效果，且每回合開始時對所有敵方角色造成1點傷害。", 
            Rarity.ULTIMATE_TASTE, 5, Faction.SPICY_KINGDOM);
        allCards.put(spiceSanctuary.getName(), spiceSanctuary);
        allFieldCards.add(spiceSanctuary);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard spicyCastle = CastleCard.builder()
            .name("麻辣火鍋城堡 (Mala Hot Pot Castle)")
            .cost(0)
            .description("【城堡效果】：所有友方角色攻擊力+2，對敵方角色造成的傷害+1。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        spicyCastle.setEffect(new CastleEffectImpl.SpicyKingdomEffect(2));
        addToCollection(spicyCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard volcanoCastle = CastleCard.builder()
            .name("辣子雞火山堡壘 (Chilli Chicken Volcano Fortress)")
            .cost(0)
            .description("【城堡效果】：回合結束時，對所有敵方角色造成1點傷害，所有友方角色攻擊力+1。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        volcanoCastle.setEffect(new CastleEffectImpl.SpicyKingdomEffect(3));
        addToCollection(volcanoCastle, allCards, allCastles);
        
        CastleCard spicyFortress = CastleCard.builder()
            .name("水煮魚要塞 (Boiled Fish Fortress)")
            .cost(0)
            .description("【城堡效果】：所有友方【嗆辣】效果觸發兩次，友方角色攻擊力+2。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        spicyFortress.setEffect(new CastleEffectImpl.SpicyKingdomEffect(1));
        addToCollection(spicyFortress, allCards, allCastles);
        
        CastleCard pepperCastle = CastleCard.builder()
            .name("麻婆豆腐碉堡 (Mapo Tofu Stronghold)")
            .cost(0)
            .description("【城堡效果】：每回合開始時，有40%機率使一個隨機敵方角色獲得【嗆辣】效果。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        pepperCastle.setEffect(new CastleEffectImpl.SpicyKingdomEffect(1));
        addToCollection(pepperCastle, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 