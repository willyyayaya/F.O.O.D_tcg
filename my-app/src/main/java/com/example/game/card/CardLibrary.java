package com.example.game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 卡牌圖鑑 - 管理所有可用的卡牌
 */
public class CardLibrary {
    private static Map<String, Card> allCards = new HashMap<>();
    private static List<Minion> allMinions = new ArrayList<>();
    private static List<SpellCard> allSpells = new ArrayList<>();
    private static List<CharacterCard> allCharacters = new ArrayList<>();
    private static List<FieldCard> allFieldCards = new ArrayList<>();
    
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
        
        // 注意：移除舊的初始化方法調用，因為這些卡牌沒有明確的陣營
        // initializeMinions();
        // initializeSpells();
        // initializeCharacters();
        // initializeFieldCards();
        
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

        System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
        System.out.println("其中角色卡: " + allCharacters.size() + " 張，場地卡: " + allFieldCards.size() + " 張，法術卡: " + allSpells.size() + " 張");
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
            System.out.println("0. 返回");
            System.out.print("請選擇陣營: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
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
} 