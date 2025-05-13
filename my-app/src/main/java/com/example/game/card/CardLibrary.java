package com.example.game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.example.game.player.Player;

/**
 * 卡牌圖鑑 - 管理所有可用的卡牌
 */
public class CardLibrary {
    private static Map<String, Card> allCards = new HashMap<>();
    private static List<Minion> allMinions = new ArrayList<>();
    private static List<SpellCard> allSpells = new ArrayList<>();
    private static List<CharacterCard> allCharacters = new ArrayList<>();
    private static List<FieldCard> allFieldCards = new ArrayList<>();
    private static List<CastleCard> allCastles = new ArrayList<>(); // 添加城堡卡列表
    
    /**
     * 初始化卡牌圖鑑
     */
    public static void initialize() {
        // 先清空現有卡牌，防止重複初始化
        allCards.clear();
        allMinions.clear();
        allSpells.clear();
        allCharacters.clear();
        allFieldCards.clear();
        allCastles.clear(); // 清空城堡卡列表
        
        // 注意：移除舊的初始化方法調用，因為這些卡牌沒有明確的陣營
        // initializeMinions();
        // initializeSpells();
        // initializeCharacters();
        // initializeFieldCards();
        
        // 初始化各陣營的城堡卡
        initializeCastleCards();
        
        // 只保留已明確設置陣營的卡牌
        
        // 火辣王國卡牌
        CharacterCard spicyChicken = new CharacterCard(
            "辣雞將軍", 5, "【開胃】：對敵方隨機角色造成2點傷害。【嗆辣】：每回合結束損失一點生命值。", 
            Rarity.RARE, 5, 3, 5, true, Faction.SPICY_KINGDOM);
        allCards.put(spicyChicken.getName(), spicyChicken);
        allCharacters.add(spicyChicken);

        CharacterCard chiliPepper = new CharacterCard(
            "辣椒騎士", 3, "【開胃】：獲得+1攻擊力。【回味】：使一個友方角色獲得+1攻擊力。", 
            Rarity.COMMON, 3, 2, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(chiliPepper.getName(), chiliPepper);
        allCharacters.add(chiliPepper);

        FieldCard spicySauce = FieldCard.createToolField(
            "魔鬼辣醬", 2, "使一個友方角色獲得+2攻擊力，但附加【嗆辣】效果。", 
            Rarity.COMMON, FieldEffectType.OFFENSIVE, 3, 2, Faction.SPICY_KINGDOM);
        allCards.put(spicySauce.getName(), spicySauce);
        allFieldCards.add(spicySauce);
        
        // 添加更多火辣王國卡牌
        CharacterCard hotPot = new CharacterCard(
            "麻辣火鍋", 6, "【開胃】：對所有敵方角色造成1點傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.EPIC, 4, 4, 6, true, Faction.SPICY_KINGDOM);
        allCards.put(hotPot.getName(), hotPot);
        allCharacters.add(hotPot);
        
        CharacterCard kimchi = new CharacterCard(
            "泡菜大師", 4, "【回味】：對敵方生命值最低的角色造成2點傷害。【彈牙】：每回合可攻擊 2 次。", 
            Rarity.RARE, 3, 3, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(kimchi.getName(), kimchi);
        allCharacters.add(kimchi);
        
        FieldCard chilliOil = FieldCard.createTechniqueField(
            "紅油潑灑", 3, "給一個友方角色添加【爆炒】效果：可在戰鬥階段直接消滅一個生命值低於3的敵方單位。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 1, 3, Faction.SPICY_KINGDOM);
        allCards.put(chilliOil.getName(), chilliOil);
        allFieldCards.add(chilliOil);
        
        // 新增火辣王國卡牌
        CharacterCard sichuanChef = new CharacterCard(
            "川菜大廚", 4, "【開胃】：使一個敵方角色獲得【嗆辣】效果。【爆炒】：當攻擊時，有25%機率直接消滅目標。", 
            Rarity.EPIC, 3, 5, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(sichuanChef.getName(), sichuanChef);
        allCharacters.add(sichuanChef);

        CharacterCard curryWarrior = new CharacterCard(
            "咖哩武士", 3, "【彈牙】：每回合可攻擊 2 次。【酥脆】：減免1點傷害。", 
            Rarity.COMMON, 2, 3, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(curryWarrior.getName(), curryWarrior);
        allCharacters.add(curryWarrior);

        // 新增火辣王國法術卡
        SpellCard spicyExplosion = new SpellCard(
            "麻辣爆破", 3, "對所有敵方角色造成2點傷害，並使其獲得【嗆辣】效果。", 
            Rarity.RARE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(spicyExplosion.getName(), spicyExplosion);
        allSpells.add(spicyExplosion);

        SpellCard hotPotFeast = new SpellCard(
            "火鍋盛宴", 5, "使所有友方角色獲得+1/+1和【爆炒】效果。", 
            Rarity.EPIC, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotPotFeast.getName(), hotPotFeast);
        allSpells.add(hotPotFeast);

        // 火辣王國傳說卡牌
        CharacterCard spicyEmperor = new CharacterCard(
            "辣味皇帝", 8, "【開胃】：對所有敵方角色造成3點傷害並施加【嗆辣】效果。【爆炒】：攻擊時有50%機率摧毀目標，每回合只能發動一次。【回味】：對敵方英雄造成5點傷害。", 
            Rarity.LEGENDARY, 6, 5, 8, true, Faction.SPICY_KINGDOM);
        allCards.put(spicyEmperor.getName(), spicyEmperor);
        allCharacters.add(spicyEmperor);
        
        // 火辣王國特殊場地卡
        FieldCard volcanicKitchen = FieldCard.createEnvironmentField(
            "火山廚房", 5, "每回合開始時，對所有敵方角色造成1點傷害。友方火辣王國角色獲得【爆炒】效果，攻擊時有15%機率直接消滅目標。", 
            Rarity.EPIC, 4, Faction.SPICY_KINGDOM);
        allCards.put(volcanicKitchen.getName(), volcanicKitchen);
        allFieldCards.add(volcanicKitchen);

        // 添加更多火辣王國卡牌
        CharacterCard hotSauceDragon = new CharacterCard(
            "辣醬飛龍", 6, "【開胃】：對敵方所有角色造成1點傷害。【爆炒】：攻擊時有30%機率造成雙倍傷害。", 
            Rarity.EPIC, 5, 3, 6, true, Faction.SPICY_KINGDOM);
        allCards.put(hotSauceDragon.getName(), hotSauceDragon);
        allCharacters.add(hotSauceDragon);
        
        CharacterCard wasabiNinja = new CharacterCard(
            "山葵忍者", 3, "【潛行】：進場時不會觸發敵方的陷阱效果。【嗆辣】：對被攻擊目標施加【嗆辣】效果。", 
            Rarity.RARE, 4, 2, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(wasabiNinja.getName(), wasabiNinja);
        allCharacters.add(wasabiNinja);
        
        CharacterCard sriracharGuard = new CharacterCard(
            "是拉差守衛", 4, "【嗆辣】：每回合結束時，對對手造成1點傷害。【酥脆】：減免1點傷害。", 
            Rarity.COMMON, 3, 4, 5, false, Faction.SPICY_KINGDOM);
        allCards.put(sriracharGuard.getName(), sriracharGuard);
        allCharacters.add(sriracharGuard);
        
        CharacterCard tabascoBerserk = new CharacterCard(
            "塔巴斯科狂戰士", 5, "【開胃】：自身攻擊力+2。【嗆辣】：每次攻擊後，自身生命值-1，攻擊力+1。", 
            Rarity.RARE, 4, 3, 5, true, Faction.SPICY_KINGDOM);
        allCards.put(tabascoBerserk.getName(), tabascoBerserk);
        allCharacters.add(tabascoBerserk);
        
        CharacterCard chiliArcher = new CharacterCard(
            "辣椒弓箭手", 2, "【彈牙】：每回合可攻擊 2 次。【嗆辣】：對被攻擊目標施加【嗆辣】效果。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(chiliArcher.getName(), chiliArcher);
        allCharacters.add(chiliArcher);
        
        SpellCard spicyRain = new SpellCard(
            "辣雨轟炸", 4, "對所有敵方角色造成2點傷害，並有50%機率使其獲得【嗆辣】效果。", 
            Rarity.RARE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(spicyRain.getName(), spicyRain);
        allSpells.add(spicyRain);
        
        SpellCard volcanicEruption = new SpellCard(
            "火山爆發", 6, "對所有敵方角色造成3點傷害，並摧毀敵方一面城牆。", 
            Rarity.EPIC, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(volcanicEruption.getName(), volcanicEruption);
        allSpells.add(volcanicEruption);
        
        SpellCard spicyBoost = new SpellCard(
            "辣度增強", 2, "使一個友方角色獲得+2攻擊力和【爆炒】效果，持續2回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyBoost.getName(), spicyBoost);
        allSpells.add(spicyBoost);
        
        FieldCard pepperyKitchen = FieldCard.createEnvironmentField(
            "辣味廚房", 3, "友方火辣王國角色攻擊力+1。每當打出一張火辣王國卡牌時，有25%機率使其獲得【嗆辣】效果。", 
            Rarity.RARE, 3, Faction.SPICY_KINGDOM);
        allCards.put(pepperyKitchen.getName(), pepperyKitchen);
        allFieldCards.add(pepperyKitchen);
        
        FieldCard spicyWok = FieldCard.createToolField(
            "麻辣鍋具", 2, "每回合可以使一個友方角色獲得+1攻擊力和【爆炒】效果。", 
            Rarity.COMMON, FieldEffectType.BOOST_ATTACK, 2, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicyWok.getName(), spicyWok);
        allFieldCards.add(spicyWok);

        // 健康綠洲卡牌
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

        FieldCard greenSmoothie = FieldCard.createTechniqueField(
            "綠色能量昔", 3, "為所有友方角色添加【滋補】效果，持續3回合。", 
            Rarity.RARE, FieldEffectType.HEAL, 2, 3, Faction.HEALTHY_OASIS);
        allCards.put(greenSmoothie.getName(), greenSmoothie);
        allFieldCards.add(greenSmoothie);
        
        // 添加更多健康綠洲卡牌
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
        
        FieldCard organicGarden = FieldCard.createEnvironmentField(
            "有機農場", 4, "每回合開始時，為所有友方角色恢復1點生命值，並給予一個隨機友方角色【滋補】效果。", 
            Rarity.RARE, 4, Faction.HEALTHY_OASIS);
        allCards.put(organicGarden.getName(), organicGarden);
        allFieldCards.add(organicGarden);
        
        // 新增健康綠洲卡牌
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

        // 新增健康綠洲法術卡
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

        // 健康綠洲傳說卡牌
        CharacterCard holisticHealer = new CharacterCard(
            "全息療愈師", 8, "【開胃】：為所有友方角色恢復全部生命值。【滋補】：每回合結束時，所有友方角色恢復2點生命值。【酥脆】：減免所有傷害的50%。", 
            Rarity.LEGENDARY, 3, 8, 10, false, Faction.HEALTHY_OASIS);
        allCards.put(holisticHealer.getName(), holisticHealer);
        allCharacters.add(holisticHealer);
        
        // 健康綠洲特殊場地卡
        FieldCard botanicalGarden = FieldCard.createEnvironmentField(
            "植物花園", 4, "每回合結束時，為生命值最低的友方角色恢復3點生命值。場上的健康綠洲角色獲得【清淡】效果，滿血時無法攻擊，但獲得+0/+3。", 
            Rarity.EPIC, 5, Faction.HEALTHY_OASIS);
        allCards.put(botanicalGarden.getName(), botanicalGarden);
        allFieldCards.add(botanicalGarden);

        // 添加更多健康綠洲卡牌
        CharacterCard spinachTitan = new CharacterCard(
            "菠菜巨人", 5, "【滋補】：回合結束時恢復2點生命值。【開胃】：生命值+3。", 
            Rarity.RARE, 3, 7, 7, false, Faction.HEALTHY_OASIS);
        allCards.put(spinachTitan.getName(), spinachTitan);
        allCharacters.add(spinachTitan);
        
        CharacterCard greenTeaMystic = new CharacterCard(
            "綠茶秘者", 3, "【開胃】：抽一張牌。【滋補】：每回合結束時恢復1點生命值。", 
            Rarity.COMMON, 2, 3, 4, false, Faction.HEALTHY_OASIS);
        allCards.put(greenTeaMystic.getName(), greenTeaMystic);
        allCharacters.add(greenTeaMystic);
        
        CharacterCard tofuProtector = new CharacterCard(
            "豆腐護衛", 2, "【酥脆】：減免2點傷害。【清淡】：滿血時無法攻擊，獲得+0/+2。", 
            Rarity.COMMON, 1, 5, 3, false, Faction.HEALTHY_OASIS);
        allCards.put(tofuProtector.getName(), tofuProtector);
        allCharacters.add(tofuProtector);
        
        CharacterCard saladPriest = new CharacterCard(
            "沙拉牧師", 4, "【開胃】：為一個友方角色恢復4點生命值。【滋補】：場上每有一名健康綠洲角色，回合結束時恢復1點生命值。", 
            Rarity.RARE, 2, 4, 5, false, Faction.HEALTHY_OASIS);
        allCards.put(saladPriest.getName(), saladPriest);
        allCharacters.add(saladPriest);
        
        CharacterCard beanSproutScout = new CharacterCard(
            "豆芽斥候", 1, "【開胃】：查看牌庫頂的兩張牌，選擇一張加入手牌。【清淡】：滿血時無法攻擊。", 
            Rarity.COMMON, 1, 1, 2, false, Faction.HEALTHY_OASIS);
        allCards.put(beanSproutScout.getName(), beanSproutScout);
        allCharacters.add(beanSproutScout);
        
        SpellCard natureBounty = new SpellCard(
            "自然恩賜", 3, "為所有友方角色恢復2點生命值，並抽一張牌。", 
            Rarity.COMMON, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(natureBounty.getName(), natureBounty);
        allSpells.add(natureBounty);
        
        SpellCard vegetableRegeneration = new SpellCard(
            "蔬菜再生", 5, "使所有友方角色獲得【滋補】效果，並為其恢復3點生命值。", 
            Rarity.RARE, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(vegetableRegeneration.getName(), vegetableRegeneration);
        allSpells.add(vegetableRegeneration);
        
        SpellCard greenShield = new SpellCard(
            "綠色盾牌", 2, "使一個友方角色獲得【酥脆】效果：減免3點傷害，持續2回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(greenShield.getName(), greenShield);
        allSpells.add(greenShield);
        
        FieldCard fruitGrove = FieldCard.createEnvironmentField(
            "果樹林", 3, "每回合開始時，為一個隨機友方角色恢復2點生命值。每當一個友方角色回復生命值，抽一張牌。", 
            Rarity.RARE, 3, Faction.HEALTHY_OASIS);
        allCards.put(fruitGrove.getName(), fruitGrove);
        allFieldCards.add(fruitGrove);
        
        FieldCard healingHerbs = FieldCard.createToolField(
            "療愈草藥", 2, "每回合可以為一個友方角色恢復全部生命值，此工具使用後耐久度-1。", 
            Rarity.COMMON, FieldEffectType.HEAL, 2, 2, Faction.HEALTHY_OASIS);
        allCards.put(healingHerbs.getName(), healingHerbs);
        allFieldCards.add(healingHerbs);

        // 速食工會卡牌
        CharacterCard burgerBoss = new CharacterCard(
            "漢堡老闆", 4, "【開胃】：若你控制另一個速食工會角色，抽一張牌。【油膩】：每回合攻擊力減少 1。", 
            Rarity.RARE, 4, 4, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerBoss.getName(), burgerBoss);
        allCharacters.add(burgerBoss);

        CharacterCard friesWarrior = new CharacterCard(
            "薯條戰士", 1, "【現炸】：進場當回合即可攻擊。【開胃】：下一張速食工會卡牌費用-1。", 
            Rarity.COMMON, 2, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(friesWarrior.getName(), friesWarrior);
        allCharacters.add(friesWarrior);

        FieldCard driveThru = FieldCard.createEnvironmentField(
            "得來速車道", 3, "每當你打出一張速食工會卡牌，有30%機率獲得【現炸】效果。", 
            Rarity.EPIC, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThru.getName(), driveThru);
        allFieldCards.add(driveThru);
        
        // 添加更多速食工會卡牌
        CharacterCard pizzaDeliverer = new CharacterCard(
            "披薩快遞員", 3, "【現炸】：進場當回合即可攻擊。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.COMMON, 3, 1, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(pizzaDeliverer.getName(), pizzaDeliverer);
        allCharacters.add(pizzaDeliverer);
        
        CharacterCard chickenNuggets = new CharacterCard(
            "雞塊部隊", 2, "【開胃】：生成2個1/1的雞塊小兵。【油膩】：每回合攻擊力減少 1，但獲得1點生命值。", 
            Rarity.RARE, 2, 2, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenNuggets.getName(), chickenNuggets);
        allCharacters.add(chickenNuggets);
        
        FieldCard fastFoodKitchen = FieldCard.createToolField(
            "速食廚房", 4, "每回合可以使一張手牌獲得【現炸】效果，並且費用-2。", 
            Rarity.RARE, FieldEffectType.ECONOMIC, 4, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodKitchen.getName(), fastFoodKitchen);
        allFieldCards.add(fastFoodKitchen);
        
        // 新增速食工會卡牌
        CharacterCard sodaDispenser = new CharacterCard(
            "汽水供應器", 2, "【開胃】：使一個友方角色獲得+1攻擊力。【彈牙】：每回合可攻擊 2 次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaDispenser.getName(), sodaDispenser);
        allCharacters.add(sodaDispenser);

        CharacterCard fastFoodManager = new CharacterCard(
            "速食店經理", 5, "【擺盤】：敵人必須優先攻擊這個單位。【現炸】：進場當回合即可攻擊。每次攻擊時，隨機生成一個1/1的小食品。", 
            Rarity.EPIC, 4, 3, 5, true, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodManager.getName(), fastFoodManager);
        allCharacters.add(fastFoodManager);

        // 新增速食工會法術卡
        SpellCard quickService = new SpellCard(
            "快速服務", 1, "使一個友方角色獲得【現炸】效果，並且可以攻擊兩次。", 
            Rarity.COMMON, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(quickService.getName(), quickService);
        allSpells.add(quickService);

        SpellCard massProduction = new SpellCard(
            "大量生產", 4, "召喚3個2/2的速食小兵，並使其獲得【油膩】效果。", 
            Rarity.RARE, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(massProduction.getName(), massProduction);
        allSpells.add(massProduction);

        // 速食工會傳說卡牌
        CharacterCard fastFoodTycoon = new CharacterCard(
            "速食大亨", 7, "【現炸】：進場後立即可以攻擊。【開胃】：召喚3個2/2的速食小兵。每當你打出一張速食工會卡牌時，所有友方角色獲得+1攻擊力。", 
            Rarity.LEGENDARY, 5, 4, 7, true, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodTycoon.getName(), fastFoodTycoon);
        allCharacters.add(fastFoodTycoon);
        
        // 速食工會特殊場地卡
        FieldCard fastFoodEmpire = FieldCard.createEnvironmentField(
            "速食帝國", 5, "友方速食工會角色費用-1。每當打出一張速食工會卡牌，有20%機率生成一個1/1的食品小兵，並具有【現炸】效果。", 
            Rarity.EPIC, 4, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodEmpire.getName(), fastFoodEmpire);
        allFieldCards.add(fastFoodEmpire);

        // 添加更多速食工會卡牌
        CharacterCard burgerTitan = new CharacterCard(
            "巨無霸漢堡", 6, "【開胃】：召喚兩個1/1的食品小兵。【擺盤】：敵人必須優先攻擊這個單位。【油膩】：每回合攻擊力減少1。", 
            Rarity.EPIC, 6, 4, 6, true, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerTitan.getName(), burgerTitan);
        allCharacters.add(burgerTitan);
        
        CharacterCard hotDogRacer = new CharacterCard(
            "熱狗競速者", 2, "【現炸】：進場當回合即可攻擊。【開胃】：下一張打出的速食工會卡牌費用-1。", 
            Rarity.COMMON, 3, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(hotDogRacer.getName(), hotDogRacer);
        allCharacters.add(hotDogRacer);
        
        CharacterCard milkshakeWizard = new CharacterCard(
            "奶昔法師", 3, "【開胃】：為一個友方角色恢復2點生命值。【現炸】：進場當回合即可使用能力。", 
            Rarity.RARE, 2, 2, 3, false, Faction.FAST_FOOD_GUILD);
        allCards.put(milkshakeWizard.getName(), milkshakeWizard);
        allCharacters.add(milkshakeWizard);
        
        CharacterCard friesCommander = new CharacterCard(
            "薯條指揮官", 4, "【開胃】：召喚兩個2/1的薯條戰士，具有【現炸】效果。【油膩】：每回合攻擊力減少1。", 
            Rarity.RARE, 4, 3, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(friesCommander.getName(), friesCommander);
        allCharacters.add(friesCommander);
        
        CharacterCard coffeeBarista = new CharacterCard(
            "咖啡師", 2, "【開胃】：抽一張牌。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(coffeeBarista.getName(), coffeeBarista);
        allCharacters.add(coffeeBarista);
        
        SpellCard doubleDrive = new SpellCard(
            "雙重得來速", 3, "抽兩張牌，這些牌在本回合費用-1並獲得【現炸】效果。", 
            Rarity.RARE, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(doubleDrive.getName(), doubleDrive);
        allSpells.add(doubleDrive);
        
        SpellCard fastDelivery = new SpellCard(
            "快速配送", 4, "從牌庫中選擇一張費用不超過3的速食工會卡牌，免費打出它。", 
            Rarity.EPIC, SpellType.SPECIAL, Faction.FAST_FOOD_GUILD);
        allCards.put(fastDelivery.getName(), fastDelivery);
        allSpells.add(fastDelivery);
        
        SpellCard cheapMenu = new SpellCard(
            "超值餐點", 1, "下兩張打出的速食工會卡牌費用-2。", 
            Rarity.COMMON, SpellType.ECONOMIC, Faction.FAST_FOOD_GUILD);
        allCards.put(cheapMenu.getName(), cheapMenu);
        allSpells.add(cheapMenu);
        
        FieldCard industrialFryer = FieldCard.createToolField(
            "工業油炸鍋", 3, "每回合可以使一張手牌獲得【現炸】效果，或使一個已在場上的角色再次獲得攻擊機會。", 
            Rarity.RARE, FieldEffectType.STRATEGIC, 3, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(industrialFryer.getName(), industrialFryer);
        allFieldCards.add(industrialFryer);
        
        FieldCard discountCoupon = FieldCard.createEnvironmentField(
            "折扣券", 2, "所有友方速食工會卡牌費用-1。【油膩】：每使用3張卡牌後，折扣效果-1。", 
            Rarity.COMMON, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(discountCoupon.getName(), discountCoupon);
        allFieldCards.add(discountCoupon);

        // 甜點聯盟卡牌
        CharacterCard cakeMaestro = new CharacterCard(
            "蛋糕大師", 5, "【糖霜】：抵擋一次攻擊。【開胃】：當對手打出一張卡牌，有20%機率將其退回手牌。", 
            Rarity.EPIC, 3, 6, 5, false, Faction.DESSERT_UNION);
        allCards.put(cakeMaestro.getName(), cakeMaestro);
        allCharacters.add(cakeMaestro);

        CharacterCard candyCrusher = new CharacterCard(
            "糖果粉碎者", 3, "【糖爆】：可選擇糖爆行動代替攻擊，使一個敵方角色攻擊力-2，持續2回合，但下回合無法攻擊。", 
            Rarity.COMMON, 3, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(candyCrusher.getName(), candyCrusher);
        allCharacters.add(candyCrusher);

        FieldCard sugarRush = FieldCard.createTechniqueField(
            "糖分衝擊", 4, "使所有友方角色獲得【糖爆】效果，持續2回合。", 
            Rarity.RARE, FieldEffectType.SPECIAL, 0, 2, Faction.DESSERT_UNION);
        allCards.put(sugarRush.getName(), sugarRush);
        allFieldCards.add(sugarRush);
        
        // 添加更多甜點聯盟卡牌
        CharacterCard chocolateArcher = new CharacterCard(
            "巧克力射手", 2, "【彈牙】：每回合可攻擊 2 次。【開胃】：可以攻擊對手的後排角色。", 
            Rarity.COMMON, 3, 1, 2, true, Faction.DESSERT_UNION);
        allCards.put(chocolateArcher.getName(), chocolateArcher);
        allCharacters.add(chocolateArcher);
        
        CharacterCard iceCreamWizard = new CharacterCard(
            "冰淇淋法師", 4, "【糖霜】：抵擋一次攻擊。【開胃】：凍結一個敵方角色一回合（無法攻擊）。", 
            Rarity.RARE, 2, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(iceCreamWizard.getName(), iceCreamWizard);
        allCharacters.add(iceCreamWizard);
        
        FieldCard bakery = FieldCard.createToolField(
            "甜點烘焙坊", 3, "每回合結束時，生成一個1/1的餅乾小兵，並給予【糖霜】效果。", 
            Rarity.RARE, FieldEffectType.STRATEGIC, 3, 4, Faction.DESSERT_UNION);
        allCards.put(bakery.getName(), bakery);
        allFieldCards.add(bakery);
        
        // 新增甜點聯盟卡牌
        CharacterCard macaronDancer = new CharacterCard(
            "馬卡龍舞者", 3, "【開胃】：其他友方角色獲得+1/+1。【糖霜】：抵擋一次攻擊，受到攻擊後生成一個1/1的甜點小兵。", 
            Rarity.RARE, 2, 4, 3, false, Faction.DESSERT_UNION);
        allCards.put(macaronDancer.getName(), macaronDancer);
        allCharacters.add(macaronDancer);

        CharacterCard cupcakeCommander = new CharacterCard(
            "杯子蛋糕指揮官", 4, "【開胃】：抽一張牌。【回味】：為玩家恢復3點生命值，生成一個2/2的甜點小兵。", 
            Rarity.COMMON, 3, 2, 4, true, Faction.DESSERT_UNION);
        allCards.put(cupcakeCommander.getName(), cupcakeCommander);
        allCharacters.add(cupcakeCommander);

        // 新增甜點聯盟法術卡
        SpellCard sugarCoating = new SpellCard(
            "糖衣保護", 2, "使一個友方角色獲得【糖霜】效果，抵擋下兩次攻擊。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarCoating.getName(), sugarCoating);
        allSpells.add(sugarCoating);

        SpellCard dessertParty = new SpellCard(
            "甜點派對", 5, "召喚三個不同的甜點小兵（1/3餅乾、3/1巧克力和2/2蛋糕），這些小兵具有【糖爆】效果。", 
            Rarity.EPIC, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(dessertParty.getName(), dessertParty);
        allSpells.add(dessertParty);

        // 甜點聯盟傳說卡牌
        CharacterCard sugarOverlord = new CharacterCard(
            "糖霜霸王", 8, "【糖霜】：抵擋首次受到的所有傷害。【糖爆】：每回合可使敵方隨機角色攻擊力-3，持續2回合。【開胃】：對敵方所有角色施加【糖爆】效果。", 
            Rarity.LEGENDARY, 5, 6, 8, false, Faction.DESSERT_UNION);
        allCards.put(sugarOverlord.getName(), sugarOverlord);
        allCharacters.add(sugarOverlord);
        
        // 甜點聯盟特殊場地卡
        FieldCard sugarPalace = FieldCard.createEnvironmentField(
            "甜點宮殿", 5, "友方甜點聯盟角色獲得【糖霜】效果。每回合結束時，隨機對一個敵方角色施加【糖爆】效果，使其攻擊力-2，持續1回合。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(sugarPalace.getName(), sugarPalace);
        allFieldCards.add(sugarPalace);

        // 添加更多甜點聯盟卡牌
        CharacterCard iceCreamGolem = new CharacterCard(
            "冰淇淋巨像", 6, "【糖霜】：抵擋兩次攻擊。【開胃】：凍結一個敵方角色一回合（不能攻擊）。", 
            Rarity.EPIC, 4, 6, 6, false, Faction.DESSERT_UNION);
        allCards.put(iceCreamGolem.getName(), iceCreamGolem);
        allCharacters.add(iceCreamGolem);
        
        CharacterCard cookieArcher = new CharacterCard(
            "餅乾弓手", 2, "【開胃】：對一個敵方角色造成1點傷害。【糖爆】：可選擇糖爆行動，使一個敵方角色攻擊力-1，持續2回合。", 
            Rarity.COMMON, 2, 1, 2, true, Faction.DESSERT_UNION);
        allCards.put(cookieArcher.getName(), cookieArcher);
        allCharacters.add(cookieArcher);
        
        CharacterCard puddingShield = new CharacterCard(
            "布丁護盾", 3, "【糖霜】：抵擋一次攻擊。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.COMMON, 1, 5, 4, false, Faction.DESSERT_UNION);
        allCards.put(puddingShield.getName(), puddingShield);
        allCharacters.add(puddingShield);
        
        CharacterCard fondantAssassin = new CharacterCard(
            "糖霜刺客", 4, "【潛行】：在場上兩回合內不會被敵方指定為攻擊目標。【糖爆】：攻擊時對目標施加【糖爆】效果。", 
            Rarity.RARE, 5, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(fondantAssassin.getName(), fondantAssassin);
        allCharacters.add(fondantAssassin);
        
        CharacterCard jellyGuardian = new CharacterCard(
            "果凍守護者", 3, "【糖霜】：抵擋一次攻擊。【彈牙】：每回合可攻擊2次，但每次造成的傷害-1。", 
            Rarity.RARE, 2, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(jellyGuardian.getName(), jellyGuardian);
        allCharacters.add(jellyGuardian);
        
        SpellCard sweetExplosion = new SpellCard(
            "甜蜜爆炸", 4, "對所有敵方角色造成2點傷害，並使其獲得【糖爆】效果。", 
            Rarity.RARE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sweetExplosion.getName(), sweetExplosion);
        allSpells.add(sweetExplosion);
        
        SpellCard icingArmor = new SpellCard(
            "糖霜裝甲", 3, "使所有友方角色獲得【糖霜】效果，抵擋一次攻擊。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(icingArmor.getName(), icingArmor);
        allSpells.add(icingArmor);
        
        SpellCard cakeSummon = new SpellCard(
            "蛋糕召喚", 5, "召喚一個3/5的甜點守護者，具有【糖霜】和【擺盤】效果。", 
            Rarity.EPIC, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(cakeSummon.getName(), cakeSummon);
        allSpells.add(cakeSummon);
        
        FieldCard candyFactory = FieldCard.createEnvironmentField(
            "糖果工廠", 3, "每回合結束時，生成一個1/1的糖果小兵，具有【糖爆】效果。", 
            Rarity.COMMON, 3, Faction.DESSERT_UNION);
        allCards.put(candyFactory.getName(), candyFactory);
        allFieldCards.add(candyFactory);
        
        FieldCard frostingGenerator = FieldCard.createToolField(
            "糖霜生成器", 2, "每回合可以使一個友方角色獲得【糖霜】效果，抵擋一次攻擊。", 
            Rarity.COMMON, FieldEffectType.DEFENSIVE, 3, 3, Faction.DESSERT_UNION);
        allCards.put(frostingGenerator.getName(), frostingGenerator);
        allFieldCards.add(frostingGenerator);

        // 中立卡牌
        CharacterCard waterServant = new CharacterCard(
            "水之侍者", 2, "【開胃】：若你的牌組中有至少兩個不同陣營的卡牌，獲得+1/+1。【酥脆】：減免1點傷害。", 
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
            "料理流浪者", 3, "【開胃】：選擇一個陣營，獲得該陣營的一個隨機關鍵字效果。【酥脆】：減免1點傷害。", 
            Rarity.COMMON, 3, 3, 3, true, Faction.NEUTRAL);
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
        
        // 原有火辣王國卡牌和新添加的卡牌
        
        // 新增火辣王國法術卡
        SpellCard heatWave = new SpellCard(
            "熱浪衝擊", 4, "對所有敵方角色造成2點傷害，並使其下回合攻擊力-1。", 
            Rarity.RARE, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(heatWave.getName(), heatWave);
        allSpells.add(heatWave);
        
        SpellCard flamingTouch = new SpellCard(
            "灼熱之觸", 2, "對一個敵方角色造成3點傷害，並施加【嗆辣】效果。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(flamingTouch.getName(), flamingTouch);
        allSpells.add(flamingTouch);
        
        SpellCard spicyEnhancement = new SpellCard(
            "辣味強化", 3, "使一個友方角色獲得+3攻擊力，但附帶【嗆辣】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyEnhancement.getName(), spicyEnhancement);
        allSpells.add(spicyEnhancement);
        
        SpellCard volcanicRage = new SpellCard(
            "火山怒火", 5, "對所有敵方角色造成2點傷害，若其生命值低於3，則直接消滅。", 
            Rarity.EPIC, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(volcanicRage.getName(), volcanicRage);
        allSpells.add(volcanicRage);
        
        SpellCard pepperTornado = new SpellCard(
            "辣椒風暴", 3, "隨機對敵方角色造成共5點傷害，分配方式隨機。", 
            Rarity.RARE, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(pepperTornado.getName(), pepperTornado);
        allSpells.add(pepperTornado);
        
        SpellCard infernalCooking = new SpellCard(
            "地獄烹飪", 7, "對所有敵方單位造成4點傷害，並使其獲得【嗆辣】效果，持續2回合。", 
            Rarity.LEGENDARY, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(infernalCooking.getName(), infernalCooking);
        allSpells.add(infernalCooking);

        // 健康綠洲卡牌
        // ... existing code ...
        
        // 新增健康綠洲法術卡
        SpellCard naturesBlessing = new SpellCard(
            "自然祝福", 4, "為所有友方角色恢復3點生命值，並使其獲得+0/+2。", 
            Rarity.RARE, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(naturesBlessing.getName(), naturesBlessing);
        allSpells.add(naturesBlessing);
        
        SpellCard fruitfulHarvest = new SpellCard(
            "豐收季節", 3, "抽兩張牌，若其中有健康綠洲卡牌，則恢復2點生命值。", 
            Rarity.COMMON, SpellType.DRAW, Faction.HEALTHY_OASIS);
        allCards.put(fruitfulHarvest.getName(), fruitfulHarvest);
        allSpells.add(fruitfulHarvest);
        
        SpellCard veggieProtection = new SpellCard(
            "蔬菜守護", 2, "使一個友方角色獲得【酥脆】效果，減免3點傷害，持續2回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.HEALTHY_OASIS);
        allCards.put(veggieProtection.getName(), veggieProtection);
        allSpells.add(veggieProtection);
        
        SpellCard nutrientRush = new SpellCard(
            "營養爆發", 5, "恢復5點生命值，並從牌庫中抽取兩張健康綠洲卡牌。", 
            Rarity.EPIC, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(nutrientRush.getName(), nutrientRush);
        allSpells.add(nutrientRush);
        
        SpellCard rejuvenatingTea = new SpellCard(
            "恢復茶飲", 1, "為一個友方角色恢復2點生命值，若其滿血，則抽一張牌。", 
            Rarity.COMMON, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(rejuvenatingTea.getName(), rejuvenatingTea);
        allSpells.add(rejuvenatingTea);
        
        SpellCard purifyingElixir = new SpellCard(
            "淨化靈藥", 7, "為所有友方角色恢復全部生命值，並移除所有負面效果。", 
            Rarity.LEGENDARY, SpellType.HEALING, Faction.HEALTHY_OASIS);
        allCards.put(purifyingElixir.getName(), purifyingElixir);
        allSpells.add(purifyingElixir);

        // 速食工會卡牌
        // ... existing code ...
        
        // 新增速食工會法術卡
        SpellCard expressDelivery = new SpellCard(
            "快速外送", 2, "從牌庫抽一張牌，其費用-2，並獲得【現炸】效果。", 
            Rarity.COMMON, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(expressDelivery.getName(), expressDelivery);
        allSpells.add(expressDelivery);
        
        SpellCard superSizeMenu = new SpellCard(
            "超大份餐點", 4, "使一個友方角色獲得+3/+3，但附加【油膩】效果。", 
            Rarity.RARE, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(superSizeMenu.getName(), superSizeMenu);
        allSpells.add(superSizeMenu);
        
        SpellCard assemblyLine = new SpellCard(
            "流水線作業", 5, "本回合內，你打出的前3張卡牌費用-2，並獲得【現炸】效果。", 
            Rarity.EPIC, SpellType.ECONOMIC, Faction.FAST_FOOD_GUILD);
        allCards.put(assemblyLine.getName(), assemblyLine);
        allSpells.add(assemblyLine);
        
        SpellCard franchiseExpansion = new SpellCard(
            "連鎖店擴張", 6, "召喚三個2/2的速食員工，具有【現炸】效果。", 
            Rarity.RARE, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(franchiseExpansion.getName(), franchiseExpansion);
        allSpells.add(franchiseExpansion);
        
        SpellCard comboMeal = new SpellCard(
            "套餐組合", 3, "抽三張牌，這些牌在本回合費用-1。若其中有速食工會卡牌，則其費用再-1。", 
            Rarity.RARE, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(comboMeal.getName(), comboMeal);
        allSpells.add(comboMeal);
        
        SpellCard massProductionPlus = new SpellCard(
            "大量生產", 8, "召喚五個2/2的速食小兵，具有【現炸】效果，並使所有友方角色獲得+1攻擊力。", 
            Rarity.LEGENDARY, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(massProductionPlus.getName(), massProductionPlus);
        allSpells.add(massProductionPlus);

        // 甜點聯盟卡牌
        // ... existing code ...
        
        // 新增甜點聯盟法術卡
        SpellCard sugarRushPlus = new SpellCard(
            "糖分衝擊", 2, "使一個友方角色獲得+2攻擊力，並具有【彈牙】效果，持續1回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarRushPlus.getName(), sugarRushPlus);
        allSpells.add(sugarRushPlus);
        
        SpellCard frostingBarrier = new SpellCard(
            "糖霜屏障", 3, "使兩個友方角色獲得【糖霜】效果，抵擋一次攻擊。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostingBarrier.getName(), frostingBarrier);
        allSpells.add(frostingBarrier);
        
        SpellCard candyStorm = new SpellCard(
            "糖果風暴", 4, "對所有敵方角色造成1點傷害，並使其獲得【糖爆】效果，攻擊力-2，持續1回合。", 
            Rarity.RARE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(candyStorm.getName(), candyStorm);
        allSpells.add(candyStorm);
        
        SpellCard dessertParade = new SpellCard(
            "甜點遊行", 5, "召喚三個不同的甜點角色：1/2糖果衛兵、2/1蛋糕騎士和1/3冰淇淋法師。", 
            Rarity.RARE, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(dessertParade.getName(), dessertParade);
        allSpells.add(dessertParade);
        
        SpellCard icingReinforcement = new SpellCard(
            "糖霜增援", 4, "使所有友方角色獲得+1/+1和【糖霜】效果。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(icingReinforcement.getName(), icingReinforcement);
        allSpells.add(icingReinforcement);
        
        SpellCard sweetSymphony = new SpellCard(
            "甜蜜交響曲", 7, "使所有友方角色獲得+2/+2、【糖霜】效果和【糖爆】效果。", 
            Rarity.LEGENDARY, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sweetSymphony.getName(), sweetSymphony);
        allSpells.add(sweetSymphony);

        // 中立卡牌
        // ... existing code ...
        
        // 新增中立法術卡
        SpellCard culinaryInspirationPlus = new SpellCard(
            "料理靈感", 2, "抽兩張牌，如果這些牌屬於不同陣營，則費用-1。", 
            Rarity.COMMON, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(culinaryInspirationPlus.getName(), culinaryInspirationPlus);
        allSpells.add(culinaryInspirationPlus);
        
        SpellCard recipeExchange = new SpellCard(
            "食譜交換", 3, "將你手牌中的一張卡牌返回牌庫，然後抽三張牌。", 
            Rarity.COMMON, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(recipeExchange.getName(), recipeExchange);
        allSpells.add(recipeExchange);
        
        SpellCard globalFlavor = new SpellCard(
            "環球風味", 4, "使所有友方角色獲得+1/+1，場上每有一種不同陣營的角色，額外獲得+1/+1。", 
            Rarity.RARE, SpellType.BUFF, Faction.NEUTRAL);
        allCards.put(globalFlavor.getName(), globalFlavor);
        allSpells.add(globalFlavor);
        
        SpellCard cuisineTransformation = new SpellCard(
            "料理變形", 5, "將一個友方角色轉變為一個隨機陣營的角色，並保留其原有屬性加成。", 
            Rarity.EPIC, SpellType.TRANSFORM, Faction.NEUTRAL);
        allCards.put(cuisineTransformation.getName(), cuisineTransformation);
        allSpells.add(cuisineTransformation);
        
        SpellCard ingredientGathering = new SpellCard(
            "食材收集", 2, "從牌庫中抽取三張不同陣營的卡牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.NEUTRAL);
        allCards.put(ingredientGathering.getName(), ingredientGathering);
        allSpells.add(ingredientGathering);
        
        SpellCard worldFeast = new SpellCard(
            "環球盛宴", 9, "召喚每個陣營的一個隨機角色到戰場，並使其獲得+1/+1。", 
            Rarity.LEGENDARY, SpellType.SUMMON, Faction.NEUTRAL);
        allCards.put(worldFeast.getName(), worldFeast);
        allSpells.add(worldFeast);

        // 添加更多火辣王國場地卡
        FieldCard spicyLaboratory = FieldCard.createEnvironmentField(
            "辣味實驗室", 4, "每回合開始時，有30%機率對所有敵方角色造成1點傷害。每當打出一張火辣王國卡牌，使其獲得+1攻擊力。", 
            Rarity.EPIC, 4, Faction.SPICY_KINGDOM);
        allCards.put(spicyLaboratory.getName(), spicyLaboratory);
        allFieldCards.add(spicyLaboratory);
        
        FieldCard hotpotStation = FieldCard.createToolField(
            "火鍋站", 3, "每回合可使一個友方角色獲得+2攻擊力，但使其獲得【嗆辣】效果。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 3, 3, Faction.SPICY_KINGDOM);
        allCards.put(hotpotStation.getName(), hotpotStation);
        allFieldCards.add(hotpotStation);
        
        FieldCard curryMachine = FieldCard.createToolField(
            "咖哩機", 2, "每回合可對一個敵方角色造成2點傷害，並使其獲得【嗆辣】效果。", 
            Rarity.COMMON, FieldEffectType.DAMAGE, 2, 3, Faction.SPICY_KINGDOM);
        allCards.put(curryMachine.getName(), curryMachine);
        allFieldCards.add(curryMachine);
        
        FieldCard explosiveKitchen = FieldCard.createEnvironmentField(
            "爆炸廚房", 5, "每當友方角色攻擊時，有20%機率造成雙倍傷害。每回合結束時，對所有單位造成1點傷害。", 
            Rarity.EPIC, 3, Faction.SPICY_KINGDOM);
        allCards.put(explosiveKitchen.getName(), explosiveKitchen);
        allFieldCards.add(explosiveKitchen);
        
        FieldCard pepperyEnchantment = FieldCard.createTechniqueField(
            "辣椒魔法", 3, "使所有友方角色攻擊力+1，並獲得【爆炒】效果：攻擊時有10%機率直接消滅目標。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 2, 4, Faction.SPICY_KINGDOM);
        allCards.put(pepperyEnchantment.getName(), pepperyEnchantment);
        allFieldCards.add(pepperyEnchantment);
        
        FieldCard spicyCauldron = FieldCard.createToolField(
            "辣味大釜", 4, "每回合可為一張手牌附加【嗆辣】效果，使其獲得+3攻擊力。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 3, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicyCauldron.getName(), spicyCauldron);
        allFieldCards.add(spicyCauldron);
        
        // 添加更多健康綠洲場地卡
        FieldCard hydroponicFarm = FieldCard.createEnvironmentField(
            "水培農場", 4, "每回合開始時，為所有友方角色恢復1點生命值。抽牌時，有30%機率額外抽一張牌。", 
            Rarity.EPIC, 3, Faction.HEALTHY_OASIS);
        allCards.put(hydroponicFarm.getName(), hydroponicFarm);
        allFieldCards.add(hydroponicFarm);
        
        FieldCard juicingMachine = FieldCard.createToolField(
            "榨汁機", 2, "每回合可使一個友方角色恢復3點生命值，並獲得+0/+1。", 
            Rarity.COMMON, FieldEffectType.HEAL, 3, 2, Faction.HEALTHY_OASIS);
        allCards.put(juicingMachine.getName(), juicingMachine);
        allFieldCards.add(juicingMachine);
        
        FieldCard meditationGarden = FieldCard.createEnvironmentField(
            "冥想花園", 3, "所有友方角色獲得【滋補】效果：回合結束時恢復1點生命值。滿血時，防禦力+2。", 
            Rarity.RARE, 3, Faction.HEALTHY_OASIS);
        allCards.put(meditationGarden.getName(), meditationGarden);
        allFieldCards.add(meditationGarden);
        
        FieldCard vitaminEnrichment = FieldCard.createTechniqueField(
            "維生素強化", 3, "使所有友方角色獲得+0/+2，並在受到傷害時恢復1點生命值。", 
            Rarity.RARE, FieldEffectType.BOOST_DEFENSE, 2, 3, Faction.HEALTHY_OASIS);
        allCards.put(vitaminEnrichment.getName(), vitaminEnrichment);
        allFieldCards.add(vitaminEnrichment);
        
        FieldCard organicLaboratory = FieldCard.createEnvironmentField(
            "有機實驗室", 5, "每當你使用治療效果時，治療量+1。每回合結束時，有25%機率為一個隨機友方角色恢復全部生命值。", 
            Rarity.EPIC, 4, Faction.HEALTHY_OASIS);
        allCards.put(organicLaboratory.getName(), organicLaboratory);
        allFieldCards.add(organicLaboratory);
        
        FieldCard renewalFountain = FieldCard.createToolField(
            "再生之泉", 3, "每回合可為兩個友方角色各恢復2點生命值。", 
            Rarity.COMMON, FieldEffectType.HEAL, 4, 3, Faction.HEALTHY_OASIS);
        allCards.put(renewalFountain.getName(), renewalFountain);
        allFieldCards.add(renewalFountain);
        
        // 添加更多速食工會場地卡
        FieldCard assemblyKitchen = FieldCard.createEnvironmentField(
            "組裝式廚房", 4, "每回合開始時，費用不超過2的卡牌費用-1。每當打出一張費用為0的卡牌，有30%機率使其獲得【現炸】效果。", 
            Rarity.EPIC, 4, Faction.FAST_FOOD_GUILD);
        allCards.put(assemblyKitchen.getName(), assemblyKitchen);
        allFieldCards.add(assemblyKitchen);
        
        FieldCard deliveryScooter = FieldCard.createToolField(
            "外送機車", 2, "每回合可使一個友方角色獲得【現炸】效果，進場當回合即可攻擊。", 
            Rarity.COMMON, FieldEffectType.STRATEGIC, 3, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(deliveryScooter.getName(), deliveryScooter);
        allFieldCards.add(deliveryScooter);
        
        FieldCard driveThruWindow = FieldCard.createEnvironmentField(
            "得來速窗口", 3, "每當你打出一張卡牌，有20%機率使其費用-1。每回合結束時，有25%機率抽一張牌。", 
            Rarity.RARE, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThruWindow.getName(), driveThruWindow);
        allFieldCards.add(driveThruWindow);
        
        FieldCard fastFoodMarketing = FieldCard.createTechniqueField(
            "速食行銷", 3, "使所有友方角色在打出時費用-1，但獲得【油膩】效果：每回合攻擊力-1。", 
            Rarity.RARE, FieldEffectType.SPECIAL, 2, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodMarketing.getName(), fastFoodMarketing);
        allFieldCards.add(fastFoodMarketing);
        
        FieldCard industrialGrill = FieldCard.createToolField(
            "工業烤爐", 4, "每回合可召喚一個2/1的速食小兵，具有【現炸】和【油膩】效果。", 
            Rarity.RARE, FieldEffectType.SUMMON, 2, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(industrialGrill.getName(), industrialGrill);
        allFieldCards.add(industrialGrill);
        
        FieldCard franchiseLeague = FieldCard.createEnvironmentField(
            "連鎖聯盟", 5, "當友方角色受到致命傷害時，有40%機率存活並保留1點生命值。每回合可使一張手牌費用-2。", 
            Rarity.EPIC, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(franchiseLeague.getName(), franchiseLeague);
        allFieldCards.add(franchiseLeague);
        
        // 添加更多甜點聯盟場地卡
        FieldCard sweetDreamery = FieldCard.createEnvironmentField(
            "甜夢工坊", 4, "所有友方角色獲得【糖霜】效果，抵擋一次攻擊。每回合結束時，有30%機率為一個隨機敵方角色施加【糖爆】效果。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(sweetDreamery.getName(), sweetDreamery);
        allFieldCards.add(sweetDreamery);
        
        FieldCard icingDispenser = FieldCard.createToolField(
            "糖霜噴槍", 2, "每回合可使一個友方角色獲得【糖霜】效果，抵擋下一次受到的傷害。", 
            Rarity.COMMON, FieldEffectType.DEFENSIVE, 3, 2, Faction.DESSERT_UNION);
        allCards.put(icingDispenser.getName(), icingDispenser);
        allFieldCards.add(icingDispenser);
        
        FieldCard candyWorkshop = FieldCard.createEnvironmentField(
            "糖果工作坊", 3, "每當友方角色使用【糖爆】效果時，效果持續時間+1回合。每回合結束時，有25%機率生成一個1/2的糖果小兵。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(candyWorkshop.getName(), candyWorkshop);
        allFieldCards.add(candyWorkshop);
        
        FieldCard frostingEnchantment = FieldCard.createTechniqueField(
            "糖霜魔法", 3, "使所有友方角色在被攻擊時，有30%機率使攻擊者攻擊力-2，持續1回合。", 
            Rarity.RARE, FieldEffectType.SPECIAL, 2, 3, Faction.DESSERT_UNION);
        allCards.put(frostingEnchantment.getName(), frostingEnchantment);
        allFieldCards.add(frostingEnchantment);
        
        FieldCard cakeCraftingTable = FieldCard.createToolField(
            "蛋糕工作台", 4, "每回合可召喚一個2/2的甜點衛兵，具有【糖霜】效果。", 
            Rarity.RARE, FieldEffectType.SUMMON, 2, 3, Faction.DESSERT_UNION);
        allCards.put(cakeCraftingTable.getName(), cakeCraftingTable);
        allFieldCards.add(cakeCraftingTable);
        
        FieldCard sugarRealm = FieldCard.createEnvironmentField(
            "糖霜領域", 5, "所有友方角色獲得【糖霜】和【糖爆】效果。每回合開始時，有25%機率使所有敵方角色攻擊力-1，持續1回合。", 
            Rarity.EPIC, 3, Faction.DESSERT_UNION);
        allCards.put(sugarRealm.getName(), sugarRealm);
        allFieldCards.add(sugarRealm);
        
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

        System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
        System.out.println("其中角色卡: " + allCharacters.size() + " 張，場地卡: " + allFieldCards.size() + " 張，法術卡: " + allSpells.size() + " 張，城堡卡: " + allCastles.size() + " 張");
    }
    
    /**
     * 初始化隨從卡
     * 已移除 - 這些卡牌沒有明確的陣營
     */
    private static void initializeMinions() {
        // 已移除 - 這些卡牌沒有明確的陣營
    }
    
    /**
     * 初始化法術卡
     * 已移除 - 這些卡牌沒有明確的陣營
     */
    private static void initializeSpells() {
        // 已移除 - 這些卡牌沒有明確的陣營
    }
    
    /**
     * 初始化角色卡
     * 已移除 - 這些卡牌沒有明確的陣營
     */
    private static void initializeCharacters() {
        // 已移除 - 這些卡牌沒有明確的陣營
    }
    
    /**
     * 初始化場地卡（整合原烹飪技術卡和料理工具卡）
     * 已移除 - 這些卡牌沒有明確的陣營
     */
    private static void initializeFieldCards() {
        // 已移除 - 這些卡牌沒有明確的陣營
    }
    
    /**
     * 添加隨從卡到圖鑑
     */
    private static void addMinion(Minion minion) {
        allCards.put(minion.getName(), minion);
        allMinions.add(minion);
    }
    
    /**
     * 添加法術卡到圖鑑
     */
    private static void addSpell(SpellCard spell) {
        allCards.put(spell.getName(), spell);
        allSpells.add(spell);
    }
    
    /**
     * 添加角色卡到圖鑑
     */
    private static void addCharacter(CharacterCard character) {
        allCards.put(character.getName(), character);
        allCharacters.add(character);
    }
    
    /**
     * 添加場地卡到圖鑑
     */
    private static void addFieldCard(FieldCard fieldCard) {
        allCards.put(fieldCard.getName(), fieldCard);
        allFieldCards.add(fieldCard);
    }
    
    /**
     * 顯示卡牌圖鑑介面
     */
    public static void showLibrary() {
        Scanner scanner = new Scanner(System.in);
        
        // 檢查圖鑑是否為空
        if (allCards.isEmpty()) {
            System.out.println("卡牌圖鑑為空，正在初始化...");
            initialize();
            
            // 檢查初始化後的狀態
            if (allCards.isEmpty()) {
                System.out.println("錯誤：無法初始化卡牌圖鑑！");
                System.out.println("按Enter返回...");
                scanner.nextLine();
                return;
            }
        }
        
        while (true) {
            System.out.println("\n======= 卡牌圖鑑 =======");
            System.out.println("卡牌總數: " + allCards.size() + " 張");
            System.out.println("1. 瀏覽所有法術卡 (" + allSpells.size() + " 張)");
            System.out.println("2. 瀏覽所有角色卡 (" + allCharacters.size() + " 張)");
            System.out.println("3. 瀏覽所有場地卡 (" + allFieldCards.size() + " 張)");
            System.out.println("4. 按陣營瀏覽卡牌");
            System.out.println("5. 按關鍵字瀏覽卡牌");
            System.out.println("6. 搜尋卡牌");
            System.out.println("7. 查看玩家手牌");
            System.out.println("8. 瀏覽所有城堡卡 (" + allCastles.size() + " 張)");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            switch (choice) {
                case 0:
                    return;
                case 1:
                    browseSpells();
                    break;
                case 2:
                    browseCharacters();
                    break;
                case 3:
                    browseFieldCards();
                    break;
                case 4:
                    browseFactions(scanner);
                    break;
                case 5:
                    browseByKeywords(scanner);
                    break;
                case 6:
                    searchCard(scanner);
                    break;
                case 7:
                    showPlayerHands();
                    break;
                case 8:
                    browseCastleCards();
                    break;
                default:
                    System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 按陣營瀏覽卡牌
     */
    private static void browseFactions(Scanner scanner) {
        while (true) {
            System.out.println("\n======= 選擇陣營 =======");
            System.out.println("1. 火辣王國 (Spicy Kingdom)");
            System.out.println("2. 健康綠洲 (Healthy Oasis)");
            System.out.println("3. 速食工會 (Fast Food Guild)");
            System.out.println("4. 甜點聯盟 (Dessert Union)");
            System.out.println("5. 中立 (Neutral)");
            System.out.println("6. 顯示所有陣營的城堡卡");
            System.out.println("0. 返回");
            System.out.print("請選擇陣營: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 6) {
                // 顯示所有陣營的城堡卡
                browseCastleCards();
                continue;
            }
            
            Faction selectedFaction = null;
            switch (choice) {
                case 1:
                    selectedFaction = Faction.SPICY_KINGDOM;
                    break;
                case 2:
                    selectedFaction = Faction.HEALTHY_OASIS;
                    break;
                case 3:
                    selectedFaction = Faction.FAST_FOOD_GUILD;
                    break;
                case 4:
                    selectedFaction = Faction.DESSERT_UNION;
                    break;
                case 5:
                    selectedFaction = Faction.NEUTRAL;
                    break;
                default:
                    System.out.println("無效的選擇!");
                    continue;
            }
            
            browseByFaction(selectedFaction, scanner);
        }
    }
    
    /**
     * 瀏覽特定陣營的卡牌
     */
    private static void browseByFaction(Faction faction, Scanner scanner) {
        // 獲取指定陣營的所有卡牌
        List<Card> factionCards = allCards.values().stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList());
        
        if (factionCards.isEmpty()) {
            System.out.println("\n該陣營沒有卡牌!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        // 分類該陣營的卡牌
        List<CharacterCard> characters = factionCards.stream()
                .filter(card -> card instanceof CharacterCard)
                .map(card -> (CharacterCard) card)
                .collect(Collectors.toList());
        
        List<FieldCard> fields = factionCards.stream()
                .filter(card -> card instanceof FieldCard)
                .map(card -> (FieldCard) card)
                .collect(Collectors.toList());
        
        List<SpellCard> spells = factionCards.stream()
                .filter(card -> card instanceof SpellCard)
                .map(card -> (SpellCard) card)
                .collect(Collectors.toList());
        
        while (true) {
            System.out.println("\n======= " + faction.getLocalizedName() + " (" + faction.getEnglishName() + ") =======");
            System.out.println("該陣營卡牌總數: " + factionCards.size() + " 張");
            System.out.println("1. 瀏覽角色卡 (" + characters.size() + " 張)");
            System.out.println("2. 瀏覽場地卡 (" + fields.size() + " 張)");
            System.out.println("3. 瀏覽法術卡 (" + spells.size() + " 張)");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            }
            
            switch (choice) {
                case 1:
                    browseCardList(characters, "角色卡", scanner);
                    break;
                case 2:
                    browseCardList(fields, "場地卡", scanner);
                    break;
                case 3:
                    browseCardList(spells, "法術卡", scanner);
                    break;
                default:
                    System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 按關鍵字瀏覽卡牌
     */
    private static void browseByKeywords(Scanner scanner) {
        while (true) {
            System.out.println("\n======= 選擇關鍵字 =======");
            System.out.println("通用關鍵字:");
            System.out.println("1. 開胃 (Appetizer) - 進場時發動效果");
            System.out.println("2. 回味 (Aftertaste) - 死亡後觸發效果");
            System.out.println("3. 拼盤 (Platter) - 符合條件時可免費打出融合卡");
            System.out.println("4. 彈牙 (Chewy Bite) - 每回合可攻擊 2 次");
            System.out.println("5. 酥脆 (Crispy) - 護甲，減免傷害");
            System.out.println("6. 擺盤 (Garnished) - 敵人必須優先攻擊此單位");
            
            System.out.println("\n陣營特定關鍵字:");
            System.out.println("7. 現炸 (Fresh-Fried) - 速食工會：進場當回合即可攻擊");
            System.out.println("8. 油膩 (Glossy) - 速食工會：每回合攻擊力減少 1");
            System.out.println("9. 糖霜 (Frosted) - 甜點聯盟：抵擋一次攻擊");
            System.out.println("10. 糖爆 (Sugar Crash) - 甜點聯盟：有特殊攻擊效果，下回合無法攻擊");
            System.out.println("11. 滋補 (Nourishing) - 健康綠洲：回合結束時恢復全滿血量");
            System.out.println("12. 清淡 (Bland) - 健康綠洲：滿血時無法攻擊");
            System.out.println("13. 爆炒 (Overheat) - 火辣王國：直接消滅一個單位");
            System.out.println("14. 嗆辣 (Spicy) - 火辣王國：每回合結束損失一點生命值");
            System.out.println("0. 返回");
            System.out.print("請選擇關鍵字: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            }
            
            String keyword = getKeywordByChoice(choice);
            if (keyword == null) {
                System.out.println("無效的選擇!");
                continue;
            }
            
            // 查找含有特定關鍵字的卡牌
            List<Card> keywordCards = allCards.values().stream()
                    .filter(card -> card.getDescription().contains(keyword))
                    .collect(Collectors.toList());
            
            browseCardList(keywordCards, "含有 [" + keyword + "] 關鍵字的卡牌", scanner);
        }
    }
    
    /**
     * 根據選擇獲取關鍵字
     */
    private static String getKeywordByChoice(int choice) {
        switch (choice) {
            case 1: return "【開胃】";
            case 2: return "【回味】";
            case 3: return "【拼盤】";
            case 4: return "【彈牙】";
            case 5: return "【酥脆】";
            case 6: return "【擺盤】";
            case 7: return "【現炸】";
            case 8: return "【油膩】";
            case 9: return "【糖霜】";
            case 10: return "【糖爆】";
            case 11: return "【滋補】";
            case 12: return "【清淡】";
            case 13: return "【爆炒】";
            case 14: return "【嗆辣】";
            default: return null;
        }
    }
    
    /**
     * 瀏覽卡牌列表
     */
    private static <T extends Card> void browseCardList(List<T> cards, String title, Scanner scanner) {
        if (cards.isEmpty()) {
            System.out.println("\n沒有" + title + "可以瀏覽!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n======= " + title + " (共 " + cards.size() + " 張) =======");
            
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                String cardInfo = String.format("%2d. %-20s [費用:%d", (i + 1), card.getName(), card.getTokenCost());
                
                if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    cardInfo += String.format(", 攻:%d, 防:%d, 生命:%d", 
                            character.getAttack(), character.getDefense(), character.getCurrentHealth());
                }
                
                cardInfo += String.format("] %s - %s", 
                        getRaritySymbol(card.getRarity()), card.getFaction().getLocalizedName());
                
                System.out.println(cardInfo);
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= cards.size()) {
                cards.get(choice - 1).displayCardDetails();
                
                // 提取並顯示關鍵字
                displayKeywords(cards.get(choice - 1).getDescription());
                
                // 查看完後暫停一下
                System.out.println("\n按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 提取並顯示關鍵字及其效果
     */
    private static void displayKeywords(String description) {
        System.out.println("\n------ 關鍵字效果 ------");
        
        // 檢查並顯示各種關鍵字
        if (description.contains("【開胃】")) {
            System.out.println("【開胃】(Appetizer): 進場時發動效果");
        }
        if (description.contains("【回味】")) {
            System.out.println("【回味】(Aftertaste): 死亡後觸發效果");
        }
        if (description.contains("【拼盤】")) {
            System.out.println("【拼盤】(Platter): 符合條件時可免費打出融合卡");
        }
        if (description.contains("【彈牙】")) {
            System.out.println("【彈牙】(Chewy Bite): 每回合可攻擊 2 次");
        }
        if (description.contains("【酥脆】")) {
            System.out.println("【酥脆】(Crispy): 護甲，減免傷害");
        }
        if (description.contains("【擺盤】")) {
            System.out.println("【擺盤】(Garnished): 敵人必須優先攻擊此單位");
        }
        if (description.contains("【現炸】")) {
            System.out.println("【現炸】(Fresh-Fried): 進場當回合即可攻擊");
        }
        if (description.contains("【油膩】")) {
            System.out.println("【油膩】(Glossy): 每回合攻擊力減少 1");
        }
        if (description.contains("【糖霜】")) {
            System.out.println("【糖霜】(Frosted): 抵擋一次攻擊");
        }
        if (description.contains("【糖爆】")) {
            System.out.println("【糖爆】(Sugar Crash): 有特殊攻擊效果，下回合無法攻擊");
        }
        if (description.contains("【滋補】")) {
            System.out.println("【滋補】(Nourishing): 回合結束時恢復全滿血量");
        }
        if (description.contains("【清淡】")) {
            System.out.println("【清淡】(Bland): 滿血時無法攻擊");
        }
        if (description.contains("【爆炒】")) {
            System.out.println("【爆炒】(Overheat): 直接消滅一個單位");
        }
        if (description.contains("【嗆辣】")) {
            System.out.println("【嗆辣】(Spicy): 每回合結束損失一點生命值");
        }
        
        System.out.println("-------------------------");
    }
    
    /**
     * 瀏覽所有法術卡
     */
    private static void browseSpells() {
        Scanner scanner = new Scanner(System.in);
        
        if (allSpells.isEmpty()) {
            System.out.println("\n目前沒有法術卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allSpells, "法術卡", scanner);
    }
    
    /**
     * 瀏覽所有角色卡
     */
    private static void browseCharacters() {
        Scanner scanner = new Scanner(System.in);
        
        if (allCharacters.isEmpty()) {
            System.out.println("\n目前沒有角色卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allCharacters, "角色卡", scanner);
    }
    
    /**
     * 瀏覽所有場地卡
     */
    private static void browseFieldCards() {
        Scanner scanner = new Scanner(System.in);
        
        if (allFieldCards.isEmpty()) {
            System.out.println("場地卡列表為空!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allFieldCards, "場地卡", scanner);
    }
    
    /**
     * 查看場上隨從詳情
     */
    private static void showBattlefieldMinions() {
        Scanner scanner = new Scanner(System.in);
        
        // 獲取當前遊戲雙方玩家
        com.example.game.player.Player player1 = com.example.game.FOODGameEngine.getPlayer1();
        com.example.game.player.Player player2 = com.example.game.FOODGameEngine.getPlayer2();
        
        if (player1 == null || player2 == null) {
            System.out.println("遊戲尚未開始或無法獲取玩家信息");
            return;
        }
        
        while (true) {
            System.out.println("\n======= 場上隨從詳情 =======");
            System.out.println("1. 查看 " + player1.getName() + " 的場上隨從");
            System.out.println("2. 查看 " + player2.getName() + " 的場上隨從");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 1) {
                showPlayerMinions(player1);
            } else if (choice == 2) {
                showPlayerMinions(player2);
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 顯示玩家場上隨從的詳細信息
     */
    private static void showPlayerMinions(com.example.game.player.Player player) {
        Scanner scanner = new Scanner(System.in);
        // 使用F.O.O.D系統的方法獲取場上角色
        List<CharacterCard> characters = player.getBattlefieldZone().getCharacters();
        
        if (characters.isEmpty()) {
            System.out.println(player.getName() + " 的場上沒有角色");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n" + player.getName() + " 的場上角色:");
            for (int i = 0; i < characters.size(); i++) {
                CharacterCard character = characters.get(i);
                System.out.printf("%2d. %-15s [攻擊力:%d, 生命值:%d/%d] %s\n", 
                        i+1, character.getName(), character.getAttack(), 
                        character.getCurrentHealth(), character.getMaxHealth(), 
                        getCharacterSpecialEffects(character));
            }
            
            System.out.println("\n輸入角色編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= characters.size()) {
                characters.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 獲取角色的特殊效果描述
     */
    private static String getCharacterSpecialEffects(CharacterCard character) {
        StringBuilder effects = new StringBuilder();
        
        if (character.canAttack()) {
            effects.append("可攻擊 ");
        } else {
            effects.append("已消耗 ");
        }
        
        // 可以添加更多特殊效果判斷
        
        return effects.toString().trim();
    }
    
    /**
     * 根據稀有度返回顯示符號
     */
    private static String getRaritySymbol(Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return "★";
            case RARE:
                return "★★";
            case EPIC:
                return "★★★";
            case LEGENDARY:
                return "★★★★";
            default:
                return "";
        }
    }
    
    /**
     * 根據名稱獲取卡牌
     */
    public static Card getCardByName(String name) {
        return allCards.get(name);
    }
    
    /**
     * 獲取所有隨從卡
     */
    public static List<Minion> getAllMinions() {
        return allMinions;
    }
    
    /**
     * 獲取所有法術卡
     */
    public static List<SpellCard> getAllSpells() {
        return allSpells;
    }
    
    /**
     * 獲取所有角色卡
     */
    public static List<CharacterCard> getAllCharacters() {
        return allCharacters;
    }
    
    /**
     * 獲取所有場地卡
     */
    public static List<FieldCard> getAllFieldCards() {
        return allFieldCards;
    }
    
    /**
     * 查看玩家手牌
     */
    private static void showPlayerHands() {
        Scanner scanner = new Scanner(System.in);
        
        // 獲取當前遊戲中的玩家
        com.example.game.player.Player player1 = com.example.game.FOODGameEngine.getPlayer1();
        com.example.game.player.Player player2 = com.example.game.FOODGameEngine.getPlayer2();
        
        if (player1 == null || player2 == null) {
            System.out.println("遊戲尚未開始或無法獲取玩家信息");
            return;
        }
        
        while (true) {
            System.out.println("\n======= 玩家手牌 =======");
            
            // 顯示雙方玩家選項
            System.out.println("1. 查看 " + player1.getName() + " 的手牌");
            System.out.println("2. 查看 " + player2.getName() + " 的手牌");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 1) {
                showPlayerCards(player1);
            } else if (choice == 2) {
                showPlayerCards(player2);
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 顯示玩家手牌的詳細信息
     */
    private static void showPlayerCards(com.example.game.player.Player player) {
        Scanner scanner = new Scanner(System.in);
        List<Card> cards = player.getHand();
        
        if (cards.isEmpty()) {
            System.out.println(player.getName() + " 的手牌為空");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n" + player.getName() + " 的手牌:");
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    System.out.printf("%2d. %-15s [費用:%d 攻擊力:%d 生命值:%d] %s\n", 
                            i+1, minion.getName(), minion.getTokenCost(), 
                            minion.getAttack(), minion.getHealth(), 
                            getRaritySymbol(minion.getRarity()));
                } else if (card instanceof SpellCard) {
                    SpellCard spell = (SpellCard) card;
                    System.out.printf("%2d. %-15s [費用:%d] (法術) %s\n", 
                            i+1, spell.getName(), spell.getTokenCost(), 
                            getRaritySymbol(spell.getRarity()));
                } else if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    System.out.printf("%2d. %-15s [費用:%d, 攻擊力:%d, 生命值:%d] %s\n", 
                            i+1, character.getName(), character.getTokenCost(), 
                            character.getAttack(), character.getCurrentHealth(), 
                            getRaritySymbol(character.getRarity()));
                } else if (card instanceof FieldCard) {
                    FieldCard fieldCard = (FieldCard) card;
                    String fieldTypeInfo = "";
                    switch (fieldCard.getFieldType()) {
                        case COOKING_TECHNIQUE:
                            fieldTypeInfo = "[烹飪技術]";
                            break;
                        case COOKING_TOOL:
                            fieldTypeInfo = "[料理工具]";
                            break;
                        case ENVIRONMENT:
                            fieldTypeInfo = "[環境]";
                            break;
                    }
                    System.out.printf("%2d. %-15s [費用:%d] %s %s\n", 
                            i+1, fieldCard.getName(), fieldCard.getTokenCost(), 
                            fieldTypeInfo, getRaritySymbol(fieldCard.getRarity()));
                }
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= cards.size()) {
                cards.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 搜尋卡牌
     */
    private static void searchCard(Scanner scanner) {
        System.out.println("\n======= 搜尋卡牌 =======");
        System.out.println("請輸入要搜尋的卡牌名稱或關鍵字（輸入空白返回）：");
        
        String query = scanner.nextLine().trim();
        if (query.isEmpty()) {
            return;
        }
        
        // 搜尋符合條件的卡牌
        List<Card> matchedCards = allCards.values().stream()
                .filter(card -> card.getName().contains(query) || card.getDescription().contains(query))
                .collect(Collectors.toList());
        
        if (matchedCards.isEmpty()) {
            System.out.println("沒有找到符合 '" + query + "' 的卡牌");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        // 顯示搜尋結果
        System.out.println("\n找到 " + matchedCards.size() + " 張符合 '" + query + "' 的卡牌：");
        browseCardList(matchedCards, "搜尋結果", scanner);
    }
    
    /**
     * 初始化城堡卡
     */
    private static void initializeCastleCards() {
        // 火辣王國城堡卡
        CastleCard spicyCastle = new CastleCard(
            "辣椒城堡", 0, "【城堡效果】：所有友方角色攻擊力+2，對敵方角色造成的傷害+1。", 
            Rarity.EPIC, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(2));
        addCastle(spicyCastle);
        
        // 健康綠洲城堡卡
        CastleCard healthyCastle = new CastleCard(
            "果蔬城堡", 0, "【城堡效果】：所有友方角色生命值+3，每回合結束時恢復1點生命值。", 
            Rarity.EPIC, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(3));
        addCastle(healthyCastle);
        
        // 速食工會城堡卡
        CastleCard fastFoodCastle = new CastleCard(
            "速食城堡", 0, "【城堡效果】：所有友方角色費用-1，30%機率獲得【現炸】效果。", 
            Rarity.EPIC, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(1));
        addCastle(fastFoodCastle);
        
        // 甜點聯盟城堡卡
        CastleCard dessertCastle = new CastleCard(
            "糖霜城堡", 0, "【城堡效果】：所有友方角色獲得+2防禦，25%機率獲得【糖霜】效果。", 
            Rarity.EPIC, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(2));
        addCastle(dessertCastle);
        
        // 中立城堡卡
        CastleCard neutralCastle = new CastleCard(
            "美食城堡", 0, "【城堡效果】：每回合開始時有30%機率額外抽一張牌，所有友方角色獲得+1/+1。", 
            Rarity.EPIC, Faction.NEUTRAL, new CastleEffectImpl.NeutralEffect(3));
        addCastle(neutralCastle);
        
        // 傳說級城堡卡
        CastleCard culinaryFortress = new CastleCard(
            "美食堡壘", 0, "【城堡效果】：所有友方角色獲得+2/+2，每回合開始時有20%機率獲得一個你所屬陣營的關鍵字效果。", 
            Rarity.LEGENDARY, Faction.NEUTRAL, new CastleEffectImpl.NeutralEffect(5) {
                @Override
                public String getEffectDescription() {
                    return "所有友方角色獲得+2/+2，每回合開始時有20%機率獲得一個你所屬陣營的關鍵字效果";
                }
                
                @Override
                public void applyEffect(Player player) {
                    System.out.println("美食堡壘效果：所有友方角色獲得+2/+2，每回合開始時有20%機率獲得一個你所屬陣營的關鍵字效果");
                }
            });
        addCastle(culinaryFortress);
        
        // 添加更多城堡卡 - 火辣王國
        CastleCard volcanoCastle = new CastleCard(
            "火山堡壘", 0, "【城堡效果】：回合結束時，對所有敵方角色造成1點傷害，所有友方角色攻擊力+1。", 
            Rarity.LEGENDARY, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(3));
        addCastle(volcanoCastle);
        
        CastleCard spicyFortress = new CastleCard(
            "辣味要塞", 0, "【城堡效果】：所有友方【嗆辣】效果觸發兩次，友方角色攻擊力+2。", 
            Rarity.RARE, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(1));
        addCastle(spicyFortress);
        
        CastleCard pepperCastle = new CastleCard(
            "辣椒碉堡", 0, "【城堡效果】：每回合開始時，有40%機率使一個隨機敵方角色獲得【嗆辣】效果。", 
            Rarity.RARE, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(1));
        addCastle(pepperCastle);
        
        // 添加更多城堡卡 - 健康綠洲
        CastleCard gardenCastle = new CastleCard(
            "花園堡壘", 0, "【城堡效果】：所有友方角色每回合恢復2點生命值，滿血時獲得+0/+2。", 
            Rarity.LEGENDARY, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(4));
        addCastle(gardenCastle);
        
        CastleCard vegetableTower = new CastleCard(
            "蔬菜高塔", 0, "【城堡效果】：友方【滋補】效果額外恢復1點生命值，友方角色獲得+0/+3。", 
            Rarity.RARE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(2));
        addCastle(vegetableTower);
        
        CastleCard fruitCastle = new CastleCard(
            "水果堡壘", 0, "【城堡效果】：每當你恢復生命值時，有30%機率抽一張牌。", 
            Rarity.RARE, Faction.HEALTHY_OASIS, new CastleEffectImpl.HealthyOasisEffect(1));
        addCastle(fruitCastle);
        
        // 添加更多城堡卡 - 速食工會
        CastleCard burgerCastle = new CastleCard(
            "漢堡堡壘", 0, "【城堡效果】：所有友方角色費用-2，但每回合結束時攻擊力-1。", 
            Rarity.LEGENDARY, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(3));
        addCastle(burgerCastle);
        
        CastleCard friesFortress = new CastleCard(
            "薯條要塞", 0, "【城堡效果】：所有友方【現炸】效果角色額外獲得+2攻擊力。", 
            Rarity.RARE, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(2));
        addCastle(friesFortress);
        
        CastleCard sodaCastle = new CastleCard(
            "汽水城堡", 0, "【城堡效果】：每當你打出一張速食工會卡牌，有20%機率獲得1點法力值。", 
            Rarity.RARE, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(1));
        addCastle(sodaCastle);
        
        // 添加更多城堡卡 - 甜點聯盟
        CastleCard cakeCastle = new CastleCard(
            "蛋糕堡壘", 0, "【城堡效果】：所有友方角色獲得【糖霜】效果，攻擊時有25%機率使敵方失去1點攻擊力。", 
            Rarity.LEGENDARY, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(3));
        addCastle(cakeCastle);
        
        CastleCard chocolateTower = new CastleCard(
            "巧克力高塔", 0, "【城堡效果】：所有友方【糖爆】效果持續回合+1，並增加10%觸發機率。", 
            Rarity.RARE, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(2));
        addCastle(chocolateTower);
        
        CastleCard iceCreamCastle = new CastleCard(
            "冰淇淋城堡", 0, "【城堡效果】：每回合結束時，有30%機率使一個隨機敵方角色凍結一回合（無法攻擊）。", 
            Rarity.RARE, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(1));
        addCastle(iceCreamCastle);
        
        // 添加更多中立城堡卡
        CastleCard worldCuisineCastle = new CastleCard(
            "世界美食城堡", 0, "【城堡效果】：場上每有一種不同陣營的角色，所有友方角色獲得+1/+1。", 
            Rarity.LEGENDARY, Faction.NEUTRAL, new CastleEffectImpl.NeutralEffect(4));
        addCastle(worldCuisineCastle);
        
        CastleCard fusionCastle = new CastleCard(
            "融合料理城堡", 0, "【城堡效果】：每當你打出一張與場上角色不同陣營的卡牌時，有25%機率抽一張牌。", 
            Rarity.RARE, Faction.NEUTRAL, new CastleEffectImpl.NeutralEffect(2));
        addCastle(fusionCastle);
    }
    
    /**
     * 添加城堡卡到圖鑑
     */
    private static void addCastle(CastleCard castle) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
    
    /**
     * 瀏覽所有城堡卡
     */
    private static void browseCastleCards() {
        Scanner scanner = new Scanner(System.in);
        
        if (allCastles.isEmpty()) {
            System.out.println("\n目前沒有城堡卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allCastles, "城堡卡", scanner);
    }
    
    /**
     * 獲取所有城堡卡
     */
    public static List<CastleCard> getAllCastles() {
        return allCastles;
    }
    
    /**
     * 獲取特定陣營的城堡卡
     */
    public static List<CastleCard> getCastleCards(Faction faction) {
        return allCastles.stream()
                .filter(castle -> castle.getFaction() == faction || castle.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
    }
    
    /**
     * 城堡卡選擇介面
     */
    public static CastleCard chooseCastleCard(Scanner scanner, Faction faction) {
        List<CastleCard> availableCastles = allCastles.stream()
                .filter(castle -> castle.getFaction() == faction || castle.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
        
        if (availableCastles.isEmpty()) {
            System.out.println("沒有適合你陣營的城堡卡可選！");
            return null;
        }
        
        System.out.println("\n======= 選擇你的城堡卡 =======");
        System.out.println("可選城堡卡：");
        
        for (int i = 0; i < availableCastles.size(); i++) {
            CastleCard castle = availableCastles.get(i);
            System.out.printf("%d. %s [%s] - %s\n", 
                    i + 1, castle.getName(), castle.getFaction().getLocalizedName(), castle.getDescription());
        }
        
        System.out.print("請選擇城堡卡(1-" + availableCastles.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        if (choice < 1 || choice > availableCastles.size()) {
            System.out.println("無效的選擇！默認選擇第一個城堡卡");
            return availableCastles.get(0);
        }
        
        return availableCastles.get(choice - 1);
    }
    
    /**
     * 城堡區域選擇介面
     */
    public static CastleCardZone chooseCastleZone(Scanner scanner, CastleCard castle) {
        System.out.println("\n======= 選擇城堡隱藏區域 =======");
        System.out.println("你選擇了: " + castle.getName());
        System.out.println("請選擇將城堡卡隱藏在哪個區域：");
        System.out.println("1. 出牌區 (Play Zone)");
        System.out.println("2. 法力區 (Mana Zone)");
        System.out.println("3. 抽牌區 (Deck Zone)");
        
        System.out.print("請選擇(1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        switch (choice) {
            case 1:
                return CastleCardZone.PLAY;
            case 2:
                return CastleCardZone.MANA;
            case 3:
                return CastleCardZone.DECK;
            default:
                System.out.println("無效的選擇！默認選擇出牌區");
                return CastleCardZone.PLAY;
        }
    }
    
    /**
     * 檢查區域是否被摧毀，並處理城堡卡效果
     */
    public static void checkZoneDestroyed(Player player, CastleCardZone zone) {
        CastleCard castle = player.getCastleCard();
        if (castle != null) {
            if (castle.checkZoneDestroyed(zone)) {
                System.out.println(player.getName() + " 的城堡被摧毀了！");
                System.out.println("城堡效果 [" + castle.getDescription() + "] 已消失！");
            }
        }
    }
} 