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
 * 速食工會陣營卡牌初始化實現類
 */
public class FastFoodGuildInitializer implements FactionCardInitializer {
    
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
        return "速食工會";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 漢堡類角色
        CharacterCard cheeseburgerBrawler = createCharacterCard(
            "起司漢堡鬥士 (Cheeseburger Brawler)", 3, "【開胃】：對一個敵方角色造成2點傷害。【連擊】：攻擊後，有40%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(cheeseburgerBrawler.getName(), cheeseburgerBrawler);
        allCharacters.add(cheeseburgerBrawler);
        
        CharacterCard doublePattyGuardian = createCharacterCard(
            "雙層肉排守衛 (Double Patty Guardian)", 4, "【油潤】：受到傷害-2。【速食】：每回合首次出牌時費用-1。", 
            Rarity.GOURMET_DELIGHT, 3, 5, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(doublePattyGuardian.getName(), doublePattyGuardian);
        allCharacters.add(doublePattyGuardian);
        
        CharacterCard baconBurgerAssassin = createCharacterCard(
            "培根漢堡刺客 (Bacon Burger Assassin)", 5, "【開胃】：獲得+1/+1。【連擊】：攻擊後，有50%機率再次攻擊。", 
            Rarity.GOURMET_DELIGHT, 4, 3, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(baconBurgerAssassin.getName(), baconBurgerAssassin);
        allCharacters.add(baconBurgerAssassin);
        
        CharacterCard burgerEmperor = createCharacterCard(
            "漢堡帝王 (Burger Emperor)", 8, "【開胃】：對所有敵方角色造成2點傷害。【油潤】：受到傷害-2。【速食】：每回合首次出牌時費用-3。", 
            Rarity.ULTIMATE_TASTE, 4, 8, Faction.FAST_FOOD_GUILD, 5);
        allCards.put(burgerEmperor.getName(), burgerEmperor);
        allCharacters.add(burgerEmperor);
        
        // 炸物類角色
        CharacterCard crispyFriesWizard = createCharacterCard(
            "酥脆薯條法師 (Crispy Fries Wizard)", 3, "【連擊】：攻擊後，有30%機率對同一目標再次造成1點傷害。【油潤】：受到傷害-1。", 
            Rarity.CASUAL_BITES, 3, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(crispyFriesWizard.getName(), crispyFriesWizard);
        allCharacters.add(crispyFriesWizard);
        
        CharacterCard onionRingsThrower = createCharacterCard(
            "洋蔥圈投擲者 (Onion Rings Thrower)", 2, "【開胃】：對一個敵方角色造成2點傷害，對其相鄰的角色造成1點傷害。", 
            Rarity.CASUAL_BITES, 1, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(onionRingsThrower.getName(), onionRingsThrower);
        allCharacters.add(onionRingsThrower);
        
        CharacterCard hashBrownScout = createCharacterCard(
            "馬鈴薯餅斥候 (Hash Brown Scout)", 1, "【開胃】：從牌庫抽一張費用為1的卡牌。【速食】：使用費用為1的卡牌時，獲得+1攻擊力。", 
            Rarity.CASUAL_BITES, 1, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(hashBrownScout.getName(), hashBrownScout);
        allCharacters.add(hashBrownScout);
        
        CharacterCard friedChickenGeneral = createCharacterCard(
            "炸雞將軍 (Fried Chicken General)", 6, "【開胃】：召喚兩個2/2的炸雞士兵。【油潤】：受到傷害-2，並且使相鄰友方角色受到傷害-1。", 
            Rarity.GOURMET_DELIGHT, 3, 6, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(friedChickenGeneral.getName(), friedChickenGeneral);
        allCharacters.add(friedChickenGeneral);
        
        // 飲料類角色
        CharacterCard colaBomber = createCharacterCard(
            "可樂轟炸手 (Cola Bomber)", 4, "【開胃】：對所有敵方角色造成1點傷害。【滿足】：使用過【速食】效果後，執行一次額外攻擊。", 
            Rarity.CASUAL_BITES, 2, 4, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(colaBomber.getName(), colaBomber);
        allCharacters.add(colaBomber);
        
        CharacterCard milkshakeMage = createCharacterCard(
            "奶昔魔導師 (Milkshake Mage)", 3, "【開胃】：為一個友方角色恢復2點生命值。【滿足】：成功治療後，攻擊力+1，持續到下個回合。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(milkshakeMage.getName(), milkshakeMage);
        allCharacters.add(milkshakeMage);
        
        CharacterCard bubbleTeaArcher = createCharacterCard(
            "珍珠奶茶射手 (Bubble Tea Archer)", 3, "【開胃】：使一個友方角色獲得【連擊】效果。【速食】：費用小於等於2的法術卡牌使用時，複製一份到手牌中。", 
            Rarity.CASUAL_BITES, 2, 4, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(bubbleTeaArcher.getName(), bubbleTeaArcher);
        allCharacters.add(bubbleTeaArcher);
        
        CharacterCard energyDrinkBerserker = createCharacterCard(
            "能量飲料狂戰士 (Energy Drink Berserker)", 2, "【連擊】：攻擊後，有70%機率再次攻擊。【虛弱】：每次攻擊後，自身受到1點傷害。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(energyDrinkBerserker.getName(), energyDrinkBerserker);
        allCharacters.add(energyDrinkBerserker);
        
        // 甜點類角色
        CharacterCard donutMystic = createCharacterCard(
            "甜甜圈神秘師 (Donut Mystic)", 3, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(donutMystic.getName(), donutMystic);
        allCharacters.add(donutMystic);
        
        CharacterCard softServePriestess = createCharacterCard(
            "霜淇淋女祭司 (Soft Serve Priestess)", 5, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 5, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(softServePriestess.getName(), softServePriestess);
        allCharacters.add(softServePriestess);
        
        CharacterCard applePieDefender = createCharacterCard(
            "蘋果派防衛者 (Apple Pie Defender)", 4, "【開胃】：為一個友方角色恢復2點生命值。【速食】：每回合第一次使用治療效果時，治療量+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(applePieDefender.getName(), applePieDefender);
        allCharacters.add(applePieDefender);
        
        CharacterCard cookieCrumbleRogue = createCharacterCard(
            "餅乾碎盜賊 (Cookie Crumble Rogue)", 2, "【開胃】：抽一張牌。【連擊】：攻擊後，有35%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(cookieCrumbleRogue.getName(), cookieCrumbleRogue);
        allCharacters.add(cookieCrumbleRogue);
        
        // 三明治類角色
        CharacterCard clubSandwichKnight = createCharacterCard(
            "總匯三明治騎士 (Club Sandwich Knight)", 4, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(clubSandwichKnight.getName(), clubSandwichKnight);
        allCharacters.add(clubSandwichKnight);
        
        CharacterCard chickenWrapAssassin = createCharacterCard(
            "雞肉捲刺客 (Chicken Wrap Assassin)", 3, "【開胃】：對一個敵方角色造成3點傷害，但自身受到1點傷害。【油潤】：受到傷害-1。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(chickenWrapAssassin.getName(), chickenWrapAssassin);
        allCharacters.add(chickenWrapAssassin);
        
        CharacterCard tunaMeltSorcerer = createCharacterCard(
            "鮪魚起司法師 (Tuna Melt Sorcerer)", 4, "【開胃】：抽一張牌。如果抽到的是速食工會卡牌，則獲得+1/+1。【油潤】：受到傷害-1。", 
            Rarity.CASUAL_BITES, 3, 4, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(tunaMeltSorcerer.getName(), tunaMeltSorcerer);
        allCharacters.add(tunaMeltSorcerer);
        
        CharacterCard potatoChipMaster = createCharacterCard(
            "洋芋片大師 (Potato Chip Master)", 3, "【開胃】：使一個友方角色獲得【油潤】效果。【速食】：每回合第一次出牌時費用-1。", 
            Rarity.CASUAL_BITES, 3, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(potatoChipMaster.getName(), potatoChipMaster);
        allCharacters.add(potatoChipMaster);
        
        // 墨西哥風味角色
        CharacterCard tacoBellDancer = createCharacterCard(
            "墨西哥捲舞者 (Taco Bell Dancer)", 2, "【開胃】：抽一張牌。【油潤】：每當你打出一張費用小於等於2的卡牌時，獲得+1攻擊力。", 
            Rarity.CASUAL_BITES, 1, 3, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(tacoBellDancer.getName(), tacoBellDancer);
        allCharacters.add(tacoBellDancer);
        
        CharacterCard burritoBlaster = createCharacterCard(
            "墨西哥捲餅爆破手 (Burrito Blaster)", 3, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。", 
            Rarity.CASUAL_BITES, 3, 2, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(burritoBlaster.getName(), burritoBlaster);
        allCharacters.add(burritoBlaster);
        
        CharacterCard nachosNinja = createCharacterCard(
            "玉米脆片忍者 (Nachos Ninja)", 3, "【開胃】：使一個友方角色獲得+2攻擊力。【油潤】：受到傷害-1。", 
            Rarity.CASUAL_BITES, 3, 4, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(nachosNinja.getName(), nachosNinja);
        allCharacters.add(nachosNinja);
        
        CharacterCard quesadillaShadow = createCharacterCard(
            "起司墨西哥薄餅影衛 (Quesadilla Shadow)", 2, "【開胃】：對一個敵方角色造成2點傷害。【連擊】：攻擊後，有25%機率再次攻擊。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(quesadillaShadow.getName(), quesadillaShadow);
        allCharacters.add(quesadillaShadow);
        
        // 披薩類角色
        CharacterCard cheesePizzaArcher = createCharacterCard(
            "起司披薩射手 (Cheese Pizza Archer)", 2, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(cheesePizzaArcher.getName(), cheesePizzaArcher);
        allCharacters.add(cheesePizzaArcher);
        
        CharacterCard pepperoniPizzaMage = createCharacterCard(
            "臘腸披薩法師 (Pepperoni Pizza Mage)", 4, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(pepperoniPizzaMage.getName(), pepperoniPizzaMage);
        allCharacters.add(pepperoniPizzaMage);
        
        CharacterCard hawaiianPizzaTosser = createCharacterCard(
            "夏威夷披薩投擲師 (Hawaiian Pizza Tosser)", 3, "【開胃】：對一個敵方角色造成2點傷害。【油潤】：每次攻擊後，有25%機率不受反擊傷害。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 2);
        allCards.put(hawaiianPizzaTosser.getName(), hawaiianPizzaTosser);
        allCharacters.add(hawaiianPizzaTosser);
        
        CharacterCard stuffedCrustGuardian = createCharacterCard(
            "起司邊披薩守衛 (Stuffed Crust Guardian)", 5, "【開胃】：使所有友方角色獲得+1攻擊力。【速食】：每回合第一次使用速食工會卡牌時，抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 4, 5, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(stuffedCrustGuardian.getName(), stuffedCrustGuardian);
        allCharacters.add(stuffedCrustGuardian);
        
        // 速食早餐類角色
        CharacterCard mcmuffinPaladin = createCharacterCard(
            "早餐漢堡聖騎士 (McMuffin Paladin)", 3, "【開胃】：獲得+1/+1。【集結】：場上每有一個費用小於3的友方角色，獲得+1攻擊力。", 
            Rarity.GOURMET_DELIGHT, 2, 4, Faction.FAST_FOOD_GUILD, 3);
        allCards.put(mcmuffinPaladin.getName(), mcmuffinPaladin);
        allCharacters.add(mcmuffinPaladin);
        
        CharacterCard waffleFryCleric = createCharacterCard(
            "格子薯餅牧師 (Waffle Fry Cleric)", 2, "【開胃】：抽一張牌。【速食】：每回合第一次使用費用小於等於3的卡牌時，獲得+1/+1。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(waffleFryCleric.getName(), waffleFryCleric);
        allCharacters.add(waffleFryCleric);
        
        CharacterCard breakfastBurritoStriker = createCharacterCard(
            "早餐捲餅突擊手 (Breakfast Burrito Striker)", 1, "【連擊】：攻擊後，有30%機率再次攻擊。【速食】：費用為1的卡牌使用時，觸發【開胃】效果兩次。", 
            Rarity.CASUAL_BITES, 1, 2, Faction.FAST_FOOD_GUILD, 1);
        allCards.put(breakfastBurritoStriker.getName(), breakfastBurritoStriker);
        allCharacters.add(breakfastBurritoStriker);
        
        CharacterCard hotcakesWizard = createCharacterCard(
            "鬆餅法師 (Hotcakes Wizard)", 5, "【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。", 
            Rarity.CULINARY_HERITAGE, 4, 6, Faction.FAST_FOOD_GUILD, 4);
        allCards.put(hotcakesWizard.getName(), hotcakesWizard);
        allCharacters.add(hotcakesWizard);
        
        // 傳說角色 - 速食工會代表
        CharacterCard fastFoodKing = createCharacterCard(
            "速食之王 (Fast Food King)", 7, "【開胃】：對所有敵方角色造成2點傷害。【速食】：每回合首次出牌時費用-2。【油潤】：受到傷害-2。【連擊】：攻擊後，有50%機率再次攻擊。", 
            Rarity.ULTIMATE_TASTE, 5, 7, Faction.FAST_FOOD_GUILD, 5);
        allCards.put(fastFoodKing.getName(), fastFoodKing);
        allCharacters.add(fastFoodKing);
        
        CharacterCard valueComboMaster = createCharacterCard(
            "超值套餐大師 (Value Combo Master)", 6, "【開胃】：抽2張牌。【集結】：友方角色獲得+1/+1。【速食】：每回合第一次使用速食工會卡牌時，降低其費用2點。", 
            Rarity.ULTIMATE_TASTE, 4, 6, Faction.FAST_FOOD_GUILD, 4);
        allCards.put(valueComboMaster.getName(), valueComboMaster);
        allCharacters.add(valueComboMaster);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard quickBite = new SpellCard(
            "快速一口 (Quick Bite)", 1, "造成2點傷害，或使一個友方角色獲得+1攻擊力。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(quickBite.getName(), quickBite);
        allSpells.add(quickBite);
        
        SpellCard speedyDelivery = new SpellCard(
            "極速配送 (Speedy Delivery)", 2, "抽2張牌。如果你在一回合內已經打出過3張或更多卡牌，則抽3張牌。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(speedyDelivery.getName(), speedyDelivery);
        allSpells.add(speedyDelivery);
        
        SpellCard superSize = new SpellCard(
            "超大杯 (Super Size)", 3, "使一個友方角色獲得+2/+2和【油潤】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(superSize.getName(), superSize);
        allSpells.add(superSize);
        
        SpellCard greaseSplash = new SpellCard(
            "油花四濺 (Grease Splash)", 4, "對所有敵方角色造成2點傷害，並使其獲得【油潤】效果：受到傷害-1，但速度-1。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.FAST_FOOD_GUILD);
        allCards.put(greaseSplash.getName(), greaseSplash);
        allSpells.add(greaseSplash);
        
        SpellCard comboMeal = new SpellCard(
            "套餐組合 (Combo Meal)", 5, "使用此卡牌時，從牌庫中隨機抽出一張費用分別為1、2、3的卡牌。", 
            Rarity.CULINARY_HERITAGE, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(comboMeal.getName(), comboMeal);
        allSpells.add(comboMeal);
        
        // 補充更多法術卡以達到20張
        SpellCard frenchFriesAssault = new SpellCard(
            "薯條突襲 (French Fries Assault)", 2, "對一個敵方角色造成3點傷害，對其相鄰單位造成1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(frenchFriesAssault.getName(), frenchFriesAssault);
        allSpells.add(frenchFriesAssault);
        
        SpellCard burgerFlip = new SpellCard(
            "漢堡翻轉 (Burger Flip)", 1, "將一個敵方或友方角色返回其擁有者的手牌中，其費用-1。", 
            Rarity.CASUAL_BITES, SpellType.SPECIAL, Faction.FAST_FOOD_GUILD);
        allCards.put(burgerFlip.getName(), burgerFlip);
        allSpells.add(burgerFlip);
        
        SpellCard fastFoodMarketing = new SpellCard(
            "速食營銷 (Fast Food Marketing)", 2, "抽一張牌，如果是速食工會卡牌，則再抽一張牌並使其費用-1。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodMarketing.getName(), fastFoodMarketing);
        allSpells.add(fastFoodMarketing);
        
        SpellCard driveThruRush = new SpellCard(
            "得來速衝刺 (Drive-Thru Rush)", 3, "使一個友方角色獲得【連擊】效果，並在本回合可以額外攻擊一次。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThruRush.getName(), driveThruRush);
        allSpells.add(driveThruRush);
        
        SpellCard chickenNuggetBarrage = new SpellCard(
            "雞塊彈幕 (Chicken Nugget Barrage)", 4, "隨機對敵方角色造成共6點傷害，分配到2-4個目標。", 
            Rarity.GOURMET_DELIGHT, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenNuggetBarrage.getName(), chickenNuggetBarrage);
        allSpells.add(chickenNuggetBarrage);
        
        SpellCard valueMenuBlitz = new SpellCard(
            "超值菜單衝擊 (Value Menu Blitz)", 3, "使你手牌中費用小於等於3的卡牌費用-1，持續到你的下個回合結束。", 
            Rarity.CULINARY_HERITAGE, SpellType.SPECIAL, Faction.FAST_FOOD_GUILD);
        allCards.put(valueMenuBlitz.getName(), valueMenuBlitz);
        allSpells.add(valueMenuBlitz);
        
        SpellCard deepFryBeam = new SpellCard(
            "油炸光束 (Deep Fry Beam)", 2, "對一個敵方角色造成4點傷害，但其獲得【油潤】效果，減免1點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(deepFryBeam.getName(), deepFryBeam);
        allSpells.add(deepFryBeam);
        
        SpellCard friesReinforcement = new SpellCard(
            "薯條增援 (Fries Reinforcement)", 3, "召喚三個1/1的薯條士兵，它們具有【連擊】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(friesReinforcement.getName(), friesReinforcement);
        allSpells.add(friesReinforcement);
        
        SpellCard ketchupBlast = new SpellCard(
            "番茄醬爆發 (Ketchup Blast)", 1, "對一個敵方角色造成2點傷害，如果你在本回合內已經使用過一張速食工會卡牌，則改為造成3點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(ketchupBlast.getName(), ketchupBlast);
        allSpells.add(ketchupBlast);
        
        SpellCard sodaExplosion = new SpellCard(
            "汽水炸裂 (Soda Explosion)", 4, "對所有敵方角色造成2點傷害。對使用過【開胃】效果的敵方角色造成額外1點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaExplosion.getName(), sodaExplosion);
        allSpells.add(sodaExplosion);
        
        SpellCard fastFoodFrenzy = new SpellCard(
            "速食狂熱 (Fast Food Frenzy)", 5, "使所有友方角色獲得+1/+1和【連擊】效果，持續2回合。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodFrenzy.getName(), fastFoodFrenzy);
        allSpells.add(fastFoodFrenzy);
        
        SpellCard massProduction = new SpellCard(
            "批量生產 (Mass Production)", 6, "在場上放置一個隨機的費用小於等於4的速食工會角色卡的複製。", 
            Rarity.CULINARY_HERITAGE, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(massProduction.getName(), massProduction);
        allSpells.add(massProduction);
        
        SpellCard coffeeJolt = new SpellCard(
            "咖啡提神 (Coffee Jolt)", 2, "使一個友方角色獲得+2攻擊力和【連擊】效果，持續1回合。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(coffeeJolt.getName(), coffeeJolt);
        allSpells.add(coffeeJolt);
        
        SpellCard microwave = new SpellCard(
            "微波加熱 (Microwave Heating)", 1, "對一個敵方角色造成1點傷害，如果你在本回合使用過另一張法術卡，則改為造成3點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.FAST_FOOD_GUILD);
        allCards.put(microwave.getName(), microwave);
        allSpells.add(microwave);
        
        SpellCard rushHour = new SpellCard(
            "營業高峰期 (Rush Hour)", 3, "使所有友方角色獲得+1攻擊力，並使所有友方【速食】和【連擊】效果本回合觸發兩次。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.FAST_FOOD_GUILD);
        allCards.put(rushHour.getName(), rushHour);
        allSpells.add(rushHour);
        
        SpellCard extraDip = new SpellCard(
            "額外醬料 (Extra Dip)", 2, "為一個友方角色恢復3點生命值，並使其獲得【油潤】效果，持續2回合。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.FAST_FOOD_GUILD);
        allCards.put(extraDip.getName(), extraDip);
        allSpells.add(extraDip);
        
        SpellCard kidsMealSurprise = new SpellCard(
            "兒童餐驚喜 (Kids Meal Surprise)", 3, "隨機召喚一個費用為2的速食工會角色，並使其獲得+1/+1。", 
            Rarity.CASUAL_BITES, SpellType.SUMMON, Faction.FAST_FOOD_GUILD);
        allCards.put(kidsMealSurprise.getName(), kidsMealSurprise);
        allSpells.add(kidsMealSurprise);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard fastFoodRestaurant = FieldCard.createEnvironmentField(
            "速食連鎖餐廳 (Fast Food Chain Restaurant)", 4, "每回合第一次使用費用小於等於3的卡牌時，抽一張牌。友方角色的【速食】效果觸發機率+20%。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodRestaurant.getName(), fastFoodRestaurant);
        allFieldCards.add(fastFoodRestaurant);
        
        FieldCard fryer = FieldCard.createEnvironmentField(
            "油炸機 (Deep Fryer)", 2, "使一個友方角色獲得【油潤】效果：受到傷害時，減免2點傷害。", 
            Rarity.CASUAL_BITES, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fryer.getName(), fryer);
        allFieldCards.add(fryer);
        
        FieldCard quickServiceSystem = FieldCard.createEnvironmentField(
            "快速服務系統 (Quick Service System)", 3, "使一個友方角色獲得【速食】效果：每回合第一次攻擊時，可以額外攻擊一次。", 
            Rarity.GOURMET_DELIGHT, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(quickServiceSystem.getName(), quickServiceSystem);
        allFieldCards.add(quickServiceSystem);
        
        // 補充更多場地卡以達到10張
        FieldCard driveThru = FieldCard.createEnvironmentField(
            "得來速車道 (Drive-Thru Lane)", 3, "每回合第一次打出的費用小於等於2的卡牌，費用-1。友方角色獲得+1攻擊力。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(driveThru.getName(), driveThru);
        allFieldCards.add(driveThru);
        
        FieldCard sodaMachine = FieldCard.createEnvironmentField(
            "汽水機 (Soda Fountain Machine)", 2, "每回合可以使一個友方角色獲得【連擊】效果，持續1回合。", 
            Rarity.CASUAL_BITES, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(sodaMachine.getName(), sodaMachine);
        allFieldCards.add(sodaMachine);
        
        FieldCard valueMenuBoard = FieldCard.createEnvironmentField(
            "超值菜單欄 (Value Menu Board)", 5, "費用小於等於3的友方卡牌費用-1。每當打出一張費用小於等於3的速食工會卡牌時，有30%機率抽一張牌。", 
            Rarity.CULINARY_HERITAGE, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(valueMenuBoard.getName(), valueMenuBoard);
        allFieldCards.add(valueMenuBoard);
        
        FieldCard chickenBucket = FieldCard.createEnvironmentField(
            "炸雞全家桶 (Fried Chicken Bucket)", 3, "召喚一個2/2的炸雞士兵。每回合結束時，有30%機率再召喚一個。", 
            Rarity.CASUAL_BITES, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(chickenBucket.getName(), chickenBucket);
        allFieldCards.add(chickenBucket);
        
        FieldCard fastFoodKitchen = FieldCard.createEnvironmentField(
            "速食廚房 (Fast Food Kitchen)", 4, "每回合開始時，有25%機率發現一張速食工會法術卡。友方【連擊】效果觸發率+15%。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.FAST_FOOD_GUILD);
        allCards.put(fastFoodKitchen.getName(), fastFoodKitchen);
        allFieldCards.add(fastFoodKitchen);
        
        FieldCard grillStation = FieldCard.createEnvironmentField(
            "烤肉站 (Grill Station)", 3, "每回合可以使一個友方角色獲得+2攻擊力和【油潤】效果，持續1回合。", 
            Rarity.CASUAL_BITES, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(grillStation.getName(), grillStation);
        allFieldCards.add(grillStation);
        
        FieldCard selfServeArea = FieldCard.createEnvironmentField(
            "自助取餐區 (Self-Serve Area)", 3, "每回合開始時，有40%機率從牌庫中發現一張速食工會角色卡。", 
            Rarity.CASUAL_BITES, 2, Faction.FAST_FOOD_GUILD);
        allCards.put(selfServeArea.getName(), selfServeArea);
        allFieldCards.add(selfServeArea);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard burgerCastle = CastleCard.builder()
            .name("漢堡城堡 (Burger Castle)")
            .cost(0)
            .description("【城堡效果】：友方角色攻擊力+2，你的卡牌費用-1（最低為1）。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        burgerCastle.setEffect(new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(burgerCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard frenchFryCastle = CastleCard.builder()
            .name("薯條堡壘 (French Fries Fortress)")
            .cost(0)
            .description("【城堡效果】：每回合第一次打出的卡牌費用-2，友方角色獲得+1/+1。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        frenchFryCastle.setEffect(new CastleEffectImpl.FastFoodGuildEffect(3));
        addToCollection(frenchFryCastle, allCards, allCastles);
        
        CastleCard nuggetFortress = CastleCard.builder()
            .name("雞塊要塞 (Chicken Nugget Stronghold)")
            .cost(0)
            .description("【城堡效果】：每回合結束時，有50%機率召喚一個2/2的炸雞士兵。友方角色獲得【油潤】效果。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        nuggetFortress.setEffect(new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(nuggetFortress, allCards, allCastles);
        
        CastleCard driveThruTower = CastleCard.builder()
            .name("得來速塔樓 (Drive-Thru Tower)")
            .cost(0)
            .description("【城堡效果】：每回合第一次打出的費用小於等於3的卡牌抽一張牌。友方角色攻擊力+1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        driveThruTower.setEffect(new CastleEffectImpl.FastFoodGuildEffect(1));
        addToCollection(driveThruTower, allCards, allCastles);
        
        CastleCard pizzaKeep = CastleCard.builder()
            .name("披薩堡壘 (Pizza Fortress)")
            .cost(0)
            .description("【城堡效果】：友方角色的【連擊】和【速食】效果觸發機率+25%。友方角色獲得+1/+1。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        pizzaKeep.setEffect(new CastleEffectImpl.FastFoodGuildEffect(2));
        addToCollection(pizzaKeep, allCards, allCastles);
        
        CastleCard comboMealCitadel = CastleCard.builder()
            .name("套餐組合城塞 (Combo Meal Citadel)")
            .cost(0)
            .description("【城堡效果】：每回合第一次使用速食工會卡牌時，從牌庫抽一張卡。友方角色獲得+1/+2。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        comboMealCitadel.setEffect(new CastleEffectImpl.FastFoodGuildEffect(3));
        addToCollection(comboMealCitadel, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 