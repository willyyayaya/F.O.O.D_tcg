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
 * 速食工會陣營卡牌初始化實現類
 */
public class FastFoodGuildInitializer implements FactionCardInitializer {
    
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
        return "速食工會";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 基礎角色卡
        CharacterCard burgerFlinger = new CharacterCard(
            "漢堡投擲手", 2, "【開胃】：對一個敵方角色造成1點傷害。【連擊】：攻擊後，有50%機率再次攻擊。", 
            Rarity.COMMON, 3, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerFlinger.getName(), burgerFlinger);
        allCharacters.add(burgerFlinger);
        
        CharacterCard frenchFriesMaster = new CharacterCard(
            "薯條大師", 3, "【連擊】：攻擊後，有30%機率對同一目標再次造成1點傷害。【油潤】：受到傷害-1。", 
            Rarity.COMMON, 2, 3, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(frenchFriesMaster.getName(), frenchFriesMaster);
        allCharacters.add(frenchFriesMaster);
        
        CharacterCard tacoDancer = new CharacterCard(
            "墨西哥捲舞者", 2, "【開胃】：抽一張牌。【油潤】：每當你打出一張費用小於等於2的卡牌時，獲得+1攻擊力。", 
            Rarity.COMMON, 1, 1, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(tacoDancer.getName(), tacoDancer);
        allCharacters.add(tacoDancer);
        
        CharacterCard sodaStreamer = new CharacterCard(
            "汽水噴射者", 4, "【開胃】：對所有敵方角色造成1點傷害。【滿足】：使用過【速食】效果後，執行一次額外攻擊。", 
            Rarity.RARE, 3, 2, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaStreamer.getName(), sodaStreamer);
        allCharacters.add(sodaStreamer);
        
        CharacterCard nuggetCommander = new CharacterCard(
            "雞塊指揮官", 5, "【開胃】：召喚兩個1/1的雞塊士兵。【集結】：友方雞塊士兵攻擊力+1。", 
            Rarity.RARE, 3, 3, 5, true, Faction.FAST_FOOD_GUILD);
        allCards.put(nuggetCommander.getName(), nuggetCommander);
        allCharacters.add(nuggetCommander);
        
        // 傳說角色卡
        CharacterCard burgerEmperor = new CharacterCard(
            "漢堡皇帝", 8, "【開胃】：對所有敵方角色造成2點傷害。【油潤】：受到傷害-2。【速食】：每回合首次出牌時費用-3。", 
            Rarity.LEGENDARY, 5, 4, 8, true, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerEmperor.getName(), burgerEmperor);
        allCharacters.add(burgerEmperor);
        
        // 補充更多角色卡以達到20張
        CharacterCard pizzaTosser = new CharacterCard(
            "披薩投擲師", 3, "【開胃】：對一個敵方角色造成2點傷害。【油潤】：每次攻擊後，有25%機率不受反擊傷害。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(pizzaTosser.getName(), pizzaTosser);
        allCharacters.add(pizzaTosser);
        
        CharacterCard shawarmaChef = new CharacterCard(
            "沙威瑪廚師", 4, "【開胃】：使一個友方角色獲得+2攻擊力。【油潤】：受到傷害-1。", 
            Rarity.COMMON, 3, 3, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(shawarmaChef.getName(), shawarmaChef);
        allCharacters.add(shawarmaChef);
        
        CharacterCard hotdogVendor = new CharacterCard(
            "熱狗小販", 1, "【連擊】：攻擊後，有30%機率再次攻擊。【速食】：費用為1的卡牌使用時，觸發【開胃】效果兩次。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(hotdogVendor.getName(), hotdogVendor);
        allCharacters.add(hotdogVendor);
        
        CharacterCard milkshakeMixer = new CharacterCard(
            "奶昔調配師", 3, "【開胃】：為一個友方角色恢復2點生命值。【滿足】：成功治療後，攻擊力+1，持續到下個回合。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(milkshakeMixer.getName(), milkshakeMixer);
        allCharacters.add(milkshakeMixer);
        
        CharacterCard fastFoodCashier = new CharacterCard(
            "速食收銀員", 2, "【開胃】：抽一張牌。【速食】：每回合第一次使用費用小於等於3的卡牌時，獲得+1/+1。", 
            Rarity.COMMON, 1, 2, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodCashier.getName(), fastFoodCashier);
        allCharacters.add(fastFoodCashier);
        
        CharacterCard chickenFryer = new CharacterCard(
            "炸雞師傅", 3, "【開胃】：對一個敵方角色造成3點傷害，但自身受到1點傷害。【油潤】：受到傷害-1。", 
            Rarity.RARE, 3, 2, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenFryer.getName(), chickenFryer);
        allCharacters.add(chickenFryer);
        
        CharacterCard bubbleTeaBarista = new CharacterCard(
            "珍珠奶茶師", 3, "【開胃】：使一個友方角色獲得【連擊】效果。【速食】：費用小於等於2的法術卡牌使用時，複製一份到手牌中。", 
            Rarity.RARE, 2, 2, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(bubbleTeaBarista.getName(), bubbleTeaBarista);
        allCharacters.add(bubbleTeaBarista);
        
        CharacterCard onionRingThrower = new CharacterCard(
            "洋蔥圈投擲者", 2, "【開胃】：對一個敵方角色造成2點傷害，對其相鄰的角色造成1點傷害。", 
            Rarity.COMMON, 2, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(onionRingThrower.getName(), onionRingThrower);
        allCharacters.add(onionRingThrower);
        
        CharacterCard burgerAssembler = new CharacterCard(
            "漢堡組裝師", 5, "【集結】：每當你使用一張費用小於等於3的卡牌時，獲得+1/+0。", 
            Rarity.RARE, 2, 3, 5, true, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerAssembler.getName(), burgerAssembler);
        allCharacters.add(burgerAssembler);
        
        CharacterCard friesScavenger = new CharacterCard(
            "薯條搶奪者", 1, "【開胃】：從牌庫抽一張費用為1的卡牌。【速食】：使用費用為1的卡牌時，獲得+1攻擊力。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.FAST_FOOD_GUILD);
        allCards.put(friesScavenger.getName(), friesScavenger);
        allCharacters.add(friesScavenger);
        
        CharacterCard sushiRoller = new CharacterCard(
            "壽司卷師", 4, "【開胃】：抽一張牌。如果抽到的是速食工會卡牌，則獲得+1/+1。【油潤】：受到傷害-1。", 
            Rarity.RARE, 3, 3, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(sushiRoller.getName(), sushiRoller);
        allCharacters.add(sushiRoller);
        
        CharacterCard friedChickenGeneral = new CharacterCard(
            "炸雞將軍", 6, "【開胃】：召喚兩個2/2的炸雞士兵。【油潤】：受到傷害-2，並且使相鄰友方角色受到傷害-1。", 
            Rarity.EPIC, 4, 3, 6, true, Faction.FAST_FOOD_GUILD);
        allCards.put(friedChickenGeneral.getName(), friedChickenGeneral);
        allCharacters.add(friedChickenGeneral);
        
        CharacterCard potatoChipMaster = new CharacterCard(
            "洋芋片大師", 3, "【開胃】：使一個友方角色獲得【油潤】效果。【速食】：每回合第一次出牌時費用-1。", 
            Rarity.RARE, 2, 3, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(potatoChipMaster.getName(), potatoChipMaster);
        allCharacters.add(potatoChipMaster);
        
        CharacterCard energyDrinkEnthusiast = new CharacterCard(
            "能量飲料愛好者", 2, "【連擊】：攻擊後，有70%機率再次攻擊。【虛弱】：每次攻擊後，自身受到1點傷害。", 
            Rarity.RARE, 3, 1, 3, true, Faction.FAST_FOOD_GUILD);
        allCards.put(energyDrinkEnthusiast.getName(), energyDrinkEnthusiast);
        allCharacters.add(energyDrinkEnthusiast);
        
        CharacterCard fastFoodManager = new CharacterCard(
            "速食店經理", 5, "【開胃】：使所有友方角色獲得+1攻擊力。【速食】：每回合第一次使用速食工會卡牌時，抽一張牌。", 
            Rarity.EPIC, 3, 4, 5, true, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodManager.getName(), fastFoodManager);
        allCharacters.add(fastFoodManager);
        
        CharacterCard comboMealSpecialist = new CharacterCard(
            "套餐專家", 4, "【開胃】：獲得+1/+1。【集結】：場上每有一個費用小於3的友方角色，獲得+1攻擊力。", 
            Rarity.EPIC, 2, 2, 4, true, Faction.FAST_FOOD_GUILD);
        allCards.put(comboMealSpecialist.getName(), comboMealSpecialist);
        allCharacters.add(comboMealSpecialist);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard quickBite = new SpellCard(
            "快速一口", 1, "造成2點傷害，或使一個友方角色獲得+1攻擊力。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(quickBite.getName(), quickBite);
        allSpells.add(quickBite);
        
        SpellCard speedyDelivery = new SpellCard(
            "極速配送", 2, "抽2張牌。如果你在一回合內已經打出過3張或更多卡牌，則抽3張牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(speedyDelivery.getName(), speedyDelivery);
        allSpells.add(speedyDelivery);
        
        SpellCard superSize = new SpellCard(
            "超大杯", 3, "使一個友方角色獲得+2/+2和【油潤】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(superSize.getName(), superSize);
        allSpells.add(superSize);
        
        SpellCard greaseSplash = new SpellCard(
            "油花四濺", 4, "對所有敵方角色造成2點傷害，並使其獲得【油潤】效果：受到傷害-1，但速度-1。", 
            Rarity.RARE, SpellType.AOE, Faction.FAST_FOOD_GUILD);
        allCards.put(greaseSplash.getName(), greaseSplash);
        allSpells.add(greaseSplash);
        
        SpellCard comboMeal = new SpellCard(
            "套餐組合", 5, "使用此卡牌時，從牌庫中隨機抽出一張費用分別為1、2、3的卡牌。", 
            Rarity.EPIC, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(comboMeal.getName(), comboMeal);
        allSpells.add(comboMeal);
        
        // 補充更多法術卡以達到20張
        SpellCard frenchFriesAssault = new SpellCard(
            "薯條突襲", 2, "對一個敵方角色造成3點傷害，對其相鄰單位造成1點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(frenchFriesAssault.getName(), frenchFriesAssault);
        allSpells.add(frenchFriesAssault);
        
        SpellCard burgerFlip = new SpellCard(
            "漢堡翻轉", 1, "將一個敵方或友方角色返回其擁有者的手牌中，其費用-1。", 
            Rarity.COMMON, SpellType.SPECIAL, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerFlip.getName(), burgerFlip);
        allSpells.add(burgerFlip);
        
        SpellCard fastFoodMarketing = new SpellCard(
            "速食營銷", 2, "抽一張牌，如果是速食工會卡牌，則再抽一張牌並使其費用-1。", 
            Rarity.COMMON, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodMarketing.getName(), fastFoodMarketing);
        allSpells.add(fastFoodMarketing);
        
        SpellCard driveThruRush = new SpellCard(
            "得來速衝刺", 3, "使一個友方角色獲得【連擊】效果，並在本回合可以額外攻擊一次。", 
            Rarity.RARE, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThruRush.getName(), driveThruRush);
        allSpells.add(driveThruRush);
        
        SpellCard chickenNuggetBarrage = new SpellCard(
            "雞塊彈幕", 4, "隨機對敵方角色造成共6點傷害，分配到2-4個目標。", 
            Rarity.RARE, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenNuggetBarrage.getName(), chickenNuggetBarrage);
        allSpells.add(chickenNuggetBarrage);
        
        SpellCard valueMenuBlitz = new SpellCard(
            "超值菜單衝擊", 3, "使你手牌中費用小於等於3的卡牌費用-1，持續到你的下個回合結束。", 
            Rarity.EPIC, SpellType.SPECIAL, Faction.FAST_FOOD_GUILD);
        allCards.put(valueMenuBlitz.getName(), valueMenuBlitz);
        allSpells.add(valueMenuBlitz);
        
        SpellCard deepFryBeam = new SpellCard(
            "油炸光束", 2, "對一個敵方角色造成4點傷害，但其獲得【油潤】效果，減免1點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(deepFryBeam.getName(), deepFryBeam);
        allSpells.add(deepFryBeam);
        
        SpellCard friesReinforcement = new SpellCard(
            "薯條增援", 3, "召喚三個1/1的薯條士兵，它們具有【連擊】效果。", 
            Rarity.RARE, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(friesReinforcement.getName(), friesReinforcement);
        allSpells.add(friesReinforcement);
        
        SpellCard ketchupBlast = new SpellCard(
            "番茄醬爆發", 1, "對一個敵方角色造成2點傷害，如果你在本回合內已經使用過一張速食工會卡牌，則改為造成3點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(ketchupBlast.getName(), ketchupBlast);
        allSpells.add(ketchupBlast);
        
        SpellCard sodaExplosion = new SpellCard(
            "汽水炸裂", 4, "對所有敵方角色造成2點傷害。對使用過【開胃】效果的敵方角色造成額外1點傷害。", 
            Rarity.RARE, SpellType.AOE, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaExplosion.getName(), sodaExplosion);
        allSpells.add(sodaExplosion);
        
        SpellCard fastFoodFrenzy = new SpellCard(
            "速食狂熱", 5, "使所有友方角色獲得+1/+1和【連擊】效果，持續2回合。", 
            Rarity.EPIC, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodFrenzy.getName(), fastFoodFrenzy);
        allSpells.add(fastFoodFrenzy);
        
        SpellCard massProduction = new SpellCard(
            "批量生產", 6, "在場上放置一個隨機的費用小於等於4的速食工會角色卡的複製。", 
            Rarity.EPIC, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(massProduction.getName(), massProduction);
        allSpells.add(massProduction);
        
        SpellCard coffeeJolt = new SpellCard(
            "咖啡提神", 2, "使一個友方角色獲得+2攻擊力和【連擊】效果，持續1回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(coffeeJolt.getName(), coffeeJolt);
        allSpells.add(coffeeJolt);
        
        SpellCard microwave = new SpellCard(
            "微波加熱", 1, "對一個敵方角色造成1點傷害，如果你在本回合使用過另一張法術卡，則改為造成3點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(microwave.getName(), microwave);
        allSpells.add(microwave);
        
        SpellCard rushHour = new SpellCard(
            "營業高峰期", 3, "使所有友方角色獲得+1攻擊力，並使所有友方【速食】和【連擊】效果本回合觸發兩次。", 
            Rarity.RARE, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(rushHour.getName(), rushHour);
        allSpells.add(rushHour);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard fastFoodRestaurant = FieldCard.createEnvironmentField(
            "速食餐廳", 4, "每回合第一次使用費用小於等於3的卡牌時，抽一張牌。友方角色的【速食】效果觸發機率+20%。", 
            Rarity.RARE, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodRestaurant.getName(), fastFoodRestaurant);
        allFieldCards.add(fastFoodRestaurant);
        
        FieldCard fryer = FieldCard.createToolField(
            "油炸鍋", 2, "使一個友方角色獲得【油潤】效果：受到傷害時，減免2點傷害。", 
            Rarity.COMMON, FieldEffectType.DEFENSIVE, 3, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(fryer.getName(), fryer);
        allFieldCards.add(fryer);
        
        FieldCard quickServiceSystem = FieldCard.createTechniqueField(
            "快速服務系統", 3, "使一個友方角色獲得【速食】效果：每回合第一次攻擊時，可以額外攻擊一次。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 2, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(quickServiceSystem.getName(), quickServiceSystem);
        allFieldCards.add(quickServiceSystem);
        
        // 補充更多場地卡以達到10張
        FieldCard driveThru = FieldCard.createEnvironmentField(
            "得來速車道", 3, "每回合第一次打出的費用小於等於2的卡牌，費用-1。友方角色獲得+1攻擊力。", 
            Rarity.RARE, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThru.getName(), driveThru);
        allFieldCards.add(driveThru);
        
        FieldCard sodaMachine = FieldCard.createToolField(
            "汽水機", 2, "每回合可以使一個友方角色獲得【連擊】效果，持續1回合。", 
            Rarity.COMMON, FieldEffectType.UTILITY, 2, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaMachine.getName(), sodaMachine);
        allFieldCards.add(sodaMachine);
        
        FieldCard valueMenuBoard = FieldCard.createEnvironmentField(
            "超值菜單欄", 5, "費用小於等於3的友方卡牌費用-1。每當打出一張費用小於等於3的速食工會卡牌時，有30%機率抽一張牌。", 
            Rarity.EPIC, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(valueMenuBoard.getName(), valueMenuBoard);
        allFieldCards.add(valueMenuBoard);
        
        FieldCard chickenBucket = FieldCard.createTechniqueField(
            "炸雞桶", 3, "召喚一個2/2的炸雞士兵。每回合結束時，有30%機率再召喚一個。", 
            Rarity.COMMON, FieldEffectType.SUMMON, 2, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenBucket.getName(), chickenBucket);
        allFieldCards.add(chickenBucket);
        
        FieldCard fastFoodKitchen = FieldCard.createEnvironmentField(
            "速食廚房", 4, "每回合開始時，有25%機率發現一張速食工會法術卡。友方【連擊】效果觸發率+15%。", 
            Rarity.RARE, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodKitchen.getName(), fastFoodKitchen);
        allFieldCards.add(fastFoodKitchen);
        
        FieldCard grillStation = FieldCard.createToolField(
            "烤爐站", 3, "每回合可以使一個友方角色獲得+2攻擊力和【油潤】效果，持續1回合。", 
            Rarity.COMMON, FieldEffectType.BOOST_ATTACK, 2, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(grillStation.getName(), grillStation);
        allFieldCards.add(grillStation);
        
        FieldCard fastFoodFactory = FieldCard.createEnvironmentField(
            "速食工廠", 5, "每回合結束時，召喚一個1/1的速食工人，它具有【速食】效果。", 
            Rarity.EPIC, 4, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodFactory.getName(), fastFoodFactory);
        allFieldCards.add(fastFoodFactory);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard burgerCastle = new CastleCard(
            "漢堡城堡", 0, "【城堡效果】：友方角色攻擊力+2，你的卡牌費用-1（最低為1）。", 
            Rarity.EPIC, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(burgerCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard frenchFryCastle = new CastleCard(
            "薯條堡壘", 0, "【城堡效果】：每回合第一次打出的卡牌費用-2，友方角色獲得+1/+1。", 
            Rarity.LEGENDARY, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(3));
        addToCollection(frenchFryCastle, allCards, allCastles);
        
        CastleCard nuggetFortress = new CastleCard(
            "雞塊要塞", 0, "【城堡效果】：每回合結束時，有50%機率召喚一個2/2的雞塊士兵。友方角色獲得【油潤】效果。", 
            Rarity.RARE, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(nuggetFortress, allCards, allCastles);
        
        CastleCard driveThruTower = new CastleCard(
            "得來速塔樓", 0, "【城堡效果】：每回合第一次打出的費用小於等於3的卡牌抽一張牌。友方角色攻擊力+1。", 
            Rarity.RARE, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(1));
        addToCollection(driveThruTower, allCards, allCastles);
        
        CastleCard pizzaKeep = new CastleCard(
            "披薩堡壘", 0, "【城堡效果】：友方角色的【連擊】和【速食】效果觸發機率+25%。友方角色獲得+1/+1。", 
            Rarity.EPIC, Faction.FAST_FOOD_GUILD, new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(pizzaKeep, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 