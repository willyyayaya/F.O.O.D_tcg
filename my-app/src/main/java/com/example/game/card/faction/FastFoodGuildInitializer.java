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
        CharacterCard cheeseburgerBrawler = CharacterCard.builder()
            .name("起司漢堡鬥士 (Cheeseburger Brawler)")
            .cost(3)
            .description("【開胃】：對一個敵方角色造成2點傷害。【連擊】：攻擊後，有40%機率再次攻擊。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(cheeseburgerBrawler.getName(), cheeseburgerBrawler);
        allCharacters.add(cheeseburgerBrawler);
        
        CharacterCard doublePattyGuardian = CharacterCard.builder()
            .name("雙層肉排守衛 (Double Patty Guardian)")
            .cost(4)
            .description("【油潤】：受到傷害-2。【速食】：每回合首次出牌時費用-1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(3)
            .health(5)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(doublePattyGuardian.getName(), doublePattyGuardian);
        allCharacters.add(doublePattyGuardian);
        
        CharacterCard baconBurgerAssassin = CharacterCard.builder()
            .name("培根漢堡刺客 (Bacon Burger Assassin)")
            .cost(5)
            .description("【開胃】：獲得+1/+1。【連擊】：攻擊後，有50%機率再次攻擊。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(4)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(baconBurgerAssassin.getName(), baconBurgerAssassin);
        allCharacters.add(baconBurgerAssassin);
        
        CharacterCard burgerEmperor = CharacterCard.builder()
            .name("漢堡帝王 (Burger Emperor)")
            .cost(8)
            .description("【開胃】：對所有敵方角色造成2點傷害。【油潤】：受到傷害-2。【速食】：每回合首次出牌時費用-3。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .attack(4)
            .health(8)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(5)
            .build();
        allCards.put(burgerEmperor.getName(), burgerEmperor);
        allCharacters.add(burgerEmperor);
        
        // 炸物類角色
        CharacterCard crispyFriesWizard = CharacterCard.builder()
            .name("酥脆薯條法師 (Crispy Fries Wizard)")
            .cost(3)
            .description("【連擊】：攻擊後，有30%機率對同一目標再次造成1點傷害。【油潤】：受到傷害-1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(3)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(crispyFriesWizard.getName(), crispyFriesWizard);
        allCharacters.add(crispyFriesWizard);
        
        CharacterCard onionRingsThrower = CharacterCard.builder()
            .name("洋蔥圈投擲者 (Onion Rings Thrower)")
            .cost(2)
            .description("【開胃】：對一個敵方角色造成2點傷害，對其相鄰的角色造成1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(1)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(onionRingsThrower.getName(), onionRingsThrower);
        allCharacters.add(onionRingsThrower);
        
        CharacterCard hashBrownScout = CharacterCard.builder()
            .name("馬鈴薯餅斥候 (Hash Brown Scout)")
            .cost(1)
            .description("【開胃】：從牌庫抽一張費用為1的卡牌。【速食】：使用費用為1的卡牌時，獲得+1攻擊力。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(1)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(hashBrownScout.getName(), hashBrownScout);
        allCharacters.add(hashBrownScout);
        
        CharacterCard friedChickenGeneral = CharacterCard.builder()
            .name("炸雞將軍 (Fried Chicken General)")
            .cost(6)
            .description("【開胃】：召喚兩個2/2的炸雞士兵。【油潤】：受到傷害-2，並且使相鄰友方角色受到傷害-1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(3)
            .health(6)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(friedChickenGeneral.getName(), friedChickenGeneral);
        allCharacters.add(friedChickenGeneral);
        
        // 飲料類角色
        CharacterCard colaBomber = CharacterCard.builder()
            .name("可樂轟炸手 (Cola Bomber)")
            .cost(4)
            .description("【開胃】：對所有敵方角色造成1點傷害。【滿足】：使用過【速食】效果後，執行一次額外攻擊。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(colaBomber.getName(), colaBomber);
        allCharacters.add(colaBomber);
        
        CharacterCard milkshakeMage = CharacterCard.builder()
            .name("奶昔魔導師 (Milkshake Mage)")
            .cost(3)
            .description("【開胃】：為一個友方角色恢復2點生命值。【滿足】：成功治療後，攻擊力+1，持續到下個回合。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(milkshakeMage.getName(), milkshakeMage);
        allCharacters.add(milkshakeMage);
        
        CharacterCard bubbleTeaArcher = CharacterCard.builder()
            .name("珍珠奶茶射手 (Bubble Tea Archer)")
            .cost(3)
            .description("【開胃】：使一個友方角色獲得【連擊】效果。【速食】：費用小於等於2的法術卡牌使用時，複製一份到手牌中。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(bubbleTeaArcher.getName(), bubbleTeaArcher);
        allCharacters.add(bubbleTeaArcher);
        
        CharacterCard energyDrinkBerserker = CharacterCard.builder()
            .name("能量飲料狂戰士 (Energy Drink Berserker)")
            .cost(2)
            .description("【連擊】：攻擊後，有70%機率再次攻擊。【虛弱】：每次攻擊後，自身受到1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(1)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(energyDrinkBerserker.getName(), energyDrinkBerserker);
        allCharacters.add(energyDrinkBerserker);
        
        // 甜點類角色
        CharacterCard donutMystic = CharacterCard.builder()
            .name("甜甜圈神秘師 (Donut Mystic)")
            .cost(3)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(donutMystic.getName(), donutMystic);
        allCharacters.add(donutMystic);
        
        CharacterCard softServePriestess = CharacterCard.builder()
            .name("霜淇淋女祭司 (Soft Serve Priestess)")
            .cost(5)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(3)
            .health(5)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(softServePriestess.getName(), softServePriestess);
        allCharacters.add(softServePriestess);
        
        CharacterCard applePieDefender = CharacterCard.builder()
            .name("蘋果派防衛者 (Apple Pie Defender)")
            .cost(4)
            .description("【開胃】：為一個友方角色恢復2點生命值。【速食】：每回合第一次使用治療效果時，治療量+2。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(2)
            .health(5)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(applePieDefender.getName(), applePieDefender);
        allCharacters.add(applePieDefender);
        
        CharacterCard cookieCrumbleRogue = CharacterCard.builder()
            .name("餅乾碎盜賊 (Cookie Crumble Rogue)")
            .cost(2)
            .description("【開胃】：抽一張牌。【連擊】：攻擊後，有35%機率再次攻擊。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(cookieCrumbleRogue.getName(), cookieCrumbleRogue);
        allCharacters.add(cookieCrumbleRogue);
        
        // 三明治類角色
        CharacterCard clubSandwichKnight = CharacterCard.builder()
            .name("總匯三明治騎士 (Club Sandwich Knight)")
            .cost(4)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(2)
            .health(5)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(clubSandwichKnight.getName(), clubSandwichKnight);
        allCharacters.add(clubSandwichKnight);
        
        CharacterCard chickenWrapAssassin = CharacterCard.builder()
            .name("雞肉捲刺客 (Chicken Wrap Assassin)")
            .cost(3)
            .description("【開胃】：對一個敵方角色造成3點傷害，但自身受到1點傷害。【油潤】：受到傷害-1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(chickenWrapAssassin.getName(), chickenWrapAssassin);
        allCharacters.add(chickenWrapAssassin);
        
        CharacterCard tunaMeltSorcerer = CharacterCard.builder()
            .name("鮪魚起司法師 (Tuna Melt Sorcerer)")
            .cost(4)
            .description("【開胃】：抽一張牌。如果抽到的是速食工會卡牌，則獲得+1/+1。【油潤】：受到傷害-1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(3)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(tunaMeltSorcerer.getName(), tunaMeltSorcerer);
        allCharacters.add(tunaMeltSorcerer);
        
        CharacterCard potatoChipMaster = CharacterCard.builder()
            .name("洋芋片大師 (Potato Chip Master)")
            .cost(3)
            .description("【開胃】：使一個友方角色獲得【油潤】效果。【速食】：每回合第一次出牌時費用-1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(3)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(potatoChipMaster.getName(), potatoChipMaster);
        allCharacters.add(potatoChipMaster);
        
        // 墨西哥風味角色
        CharacterCard tacoBellDancer = CharacterCard.builder()
            .name("墨西哥捲舞者 (Taco Bell Dancer)")
            .cost(2)
            .description("【開胃】：抽一張牌。【油潤】：每當你打出一張費用小於等於2的卡牌時，獲得+1攻擊力。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(1)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(tacoBellDancer.getName(), tacoBellDancer);
        allCharacters.add(tacoBellDancer);
        
        CharacterCard burritoBlaster = CharacterCard.builder()
            .name("墨西哥捲餅爆破手 (Burrito Blaster)")
            .cost(3)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(3)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(burritoBlaster.getName(), burritoBlaster);
        allCharacters.add(burritoBlaster);
        
        CharacterCard nachosNinja = CharacterCard.builder()
            .name("玉米脆片忍者 (Nachos Ninja)")
            .cost(3)
            .description("【開胃】：使一個友方角色獲得+2攻擊力。【油潤】：受到傷害-1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(3)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(nachosNinja.getName(), nachosNinja);
        allCharacters.add(nachosNinja);
        
        CharacterCard quesadillaShadow = CharacterCard.builder()
            .name("起司墨西哥薄餅影衛 (Quesadilla Shadow)")
            .cost(2)
            .description("【開胃】：對一個敵方角色造成2點傷害。【連擊】：攻擊後，有25%機率再次攻擊。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(quesadillaShadow.getName(), quesadillaShadow);
        allCharacters.add(quesadillaShadow);
        
        // 披薩類角色
        CharacterCard cheesePizzaArcher = CharacterCard.builder()
            .name("起司披薩射手 (Cheese Pizza Archer)")
            .cost(2)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(cheesePizzaArcher.getName(), cheesePizzaArcher);
        allCharacters.add(cheesePizzaArcher);
        
        CharacterCard pepperoniPizzaMage = CharacterCard.builder()
            .name("臘腸披薩法師 (Pepperoni Pizza Mage)")
            .cost(4)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免1點傷害。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(3)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(pepperoniPizzaMage.getName(), pepperoniPizzaMage);
        allCharacters.add(pepperoniPizzaMage);
        
        CharacterCard hawaiianPizzaTosser = CharacterCard.builder()
            .name("夏威夷披薩投擲師 (Hawaiian Pizza Tosser)")
            .cost(3)
            .description("【開胃】：對一個敵方角色造成2點傷害。【油潤】：每次攻擊後，有25%機率不受反擊傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(2)
            .build();
        allCards.put(hawaiianPizzaTosser.getName(), hawaiianPizzaTosser);
        allCharacters.add(hawaiianPizzaTosser);
        
        CharacterCard stuffedCrustGuardian = CharacterCard.builder()
            .name("起司邊披薩守衛 (Stuffed Crust Guardian)")
            .cost(5)
            .description("【開胃】：使所有友方角色獲得+1攻擊力。【速食】：每回合第一次使用速食工會卡牌時，抽一張牌。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(4)
            .health(5)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(stuffedCrustGuardian.getName(), stuffedCrustGuardian);
        allCharacters.add(stuffedCrustGuardian);
        
        // 速食早餐類角色
        CharacterCard mcmuffinPaladin = CharacterCard.builder()
            .name("早餐漢堡聖騎士 (McMuffin Paladin)")
            .cost(3)
            .description("【開胃】：獲得+1/+1。【集結】：場上每有一個費用小於3的友方角色，獲得+1攻擊力。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .attack(2)
            .health(4)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(3)
            .build();
        allCards.put(mcmuffinPaladin.getName(), mcmuffinPaladin);
        allCharacters.add(mcmuffinPaladin);
        
        CharacterCard waffleFryCleric = CharacterCard.builder()
            .name("格子薯餅牧師 (Waffle Fry Cleric)")
            .cost(2)
            .description("【開胃】：抽一張牌。【速食】：每回合第一次使用費用小於等於3的卡牌時，獲得+1/+1。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(2)
            .health(3)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(waffleFryCleric.getName(), waffleFryCleric);
        allCharacters.add(waffleFryCleric);
        
        CharacterCard breakfastBurritoStriker = CharacterCard.builder()
            .name("早餐捲餅突擊手 (Breakfast Burrito Striker)")
            .cost(1)
            .description("【連擊】：攻擊後，有30%機率再次攻擊。【速食】：費用為1的卡牌使用時，觸發【開胃】效果兩次。")
            .rarity(Rarity.CASUAL_BITES)
            .attack(1)
            .health(2)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(1)
            .build();
        allCards.put(breakfastBurritoStriker.getName(), breakfastBurritoStriker);
        allCharacters.add(breakfastBurritoStriker);
        
        CharacterCard hotcakesWizard = CharacterCard.builder()
            .name("鬆餅法師 (Hotcakes Wizard)")
            .cost(5)
            .description("【速食】：每回合第一次攻擊時，可以額外攻擊一次。【油潤】：受到傷害時，減免2點傷害。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .attack(4)
            .health(6)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(4)
            .build();
        allCards.put(hotcakesWizard.getName(), hotcakesWizard);
        allCharacters.add(hotcakesWizard);
        
        // 傳說角色 - 速食工會代表
        CharacterCard fastFoodKing = CharacterCard.builder()
            .name("速食之王 (Fast Food King)")
            .cost(7)
            .description("【開胃】：對所有敵方角色造成2點傷害。【速食】：每回合首次出牌時費用-2。【油潤】：受到傷害-2。【連擊】：攻擊後，有50%機率再次攻擊。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .attack(5)
            .health(7)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(5)
            .build();
        allCards.put(fastFoodKing.getName(), fastFoodKing);
        allCharacters.add(fastFoodKing);
        
        CharacterCard valueComboMaster = CharacterCard.builder()
            .name("超值套餐大師 (Value Combo Master)")
            .cost(6)
            .description("【開胃】：抽2張牌。【集結】：友方角色獲得+1/+1。【速食】：每回合第一次使用速食工會卡牌時，降低其費用2點。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .attack(4)
            .health(6)
            .faction(Faction.FAST_FOOD_GUILD)
            .points(4)
            .build();
        allCards.put(valueComboMaster.getName(), valueComboMaster);
        allCharacters.add(valueComboMaster);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard quickBite = SpellCard.builder()
            .name("快速一口 (Quick Bite)")
            .cost(1)
            .description("造成2點傷害，或使一個友方角色獲得+1攻擊力。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(quickBite.getName(), quickBite);
        allSpells.add(quickBite);
        
        SpellCard speedyDelivery = SpellCard.builder()
            .name("極速配送 (Speedy Delivery)")
            .cost(2)
            .description("抽2張牌。如果你在一回合內已經打出過3張或更多卡牌，則抽3張牌。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.DRAW)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(speedyDelivery.getName(), speedyDelivery);
        allSpells.add(speedyDelivery);
        
        SpellCard superSize = SpellCard.builder()
            .name("超大杯 (Super Size)")
            .cost(3)
            .description("使一個友方角色獲得+2/+2和【油潤】效果。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.BUFF)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(superSize.getName(), superSize);
        allSpells.add(superSize);
        
        SpellCard greaseSplash = SpellCard.builder()
            .name("油花四濺 (Grease Splash)")
            .cost(4)
            .description("對所有敵方角色造成2點傷害，並使其獲得【油潤】效果：受到傷害-1，但速度-1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.AOE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(greaseSplash.getName(), greaseSplash);
        allSpells.add(greaseSplash);
        
        SpellCard comboMeal = SpellCard.builder()
            .name("套餐組合 (Combo Meal)")
            .cost(5)
            .description("使用此卡牌時，從牌庫中隨機抽出一張費用分別為1、2、3的卡牌。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .spellType(SpellType.DRAW)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(comboMeal.getName(), comboMeal);
        allSpells.add(comboMeal);
        
        // 補充更多法術卡以達到20張
        SpellCard frenchFriesAssault = SpellCard.builder()
            .name("薯條突襲 (French Fries Assault)")
            .cost(2)
            .description("對一個敵方角色造成3點傷害，對其相鄰單位造成1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(frenchFriesAssault.getName(), frenchFriesAssault);
        allSpells.add(frenchFriesAssault);
        
        SpellCard burgerFlip = SpellCard.builder()
            .name("漢堡翻轉 (Burger Flip)")
            .cost(1)
            .description("將一個敵方或友方角色返回其擁有者的手牌中，其費用-1。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.SPECIAL)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(burgerFlip.getName(), burgerFlip);
        allSpells.add(burgerFlip);
        
        SpellCard fastFoodMarketing = SpellCard.builder()
            .name("速食營銷 (Fast Food Marketing)")
            .cost(2)
            .description("抽一張牌，如果是速食工會卡牌，則再抽一張牌並使其費用-1。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DRAW)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(fastFoodMarketing.getName(), fastFoodMarketing);
        allSpells.add(fastFoodMarketing);
        
        SpellCard driveThruRush = SpellCard.builder()
            .name("得來速衝刺 (Drive-Thru Rush)")
            .cost(3)
            .description("使一個友方角色獲得【連擊】效果，並在本回合可以額外攻擊一次。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.BUFF)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(driveThruRush.getName(), driveThruRush);
        allSpells.add(driveThruRush);
        
        SpellCard chickenNuggetBarrage = SpellCard.builder()
            .name("雞塊彈幕 (Chicken Nugget Barrage)")
            .cost(4)
            .description("隨機對敵方角色造成共6點傷害，分配到2-4個目標。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(chickenNuggetBarrage.getName(), chickenNuggetBarrage);
        allSpells.add(chickenNuggetBarrage);
        
        SpellCard valueMenuBlitz = SpellCard.builder()
            .name("超值菜單衝擊 (Value Menu Blitz)")
            .cost(3)
            .description("使你手牌中費用小於等於3的卡牌費用-1，持續到你的下個回合結束。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .spellType(SpellType.SPECIAL)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(valueMenuBlitz.getName(), valueMenuBlitz);
        allSpells.add(valueMenuBlitz);
        
        SpellCard deepFryBeam = SpellCard.builder()
            .name("油炸光束 (Deep Fry Beam)")
            .cost(2)
            .description("對一個敵方角色造成4點傷害，但其獲得【油潤】效果，減免1點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(deepFryBeam.getName(), deepFryBeam);
        allSpells.add(deepFryBeam);
        
        SpellCard friesReinforcement = SpellCard.builder()
            .name("薯條增援 (Fries Reinforcement)")
            .cost(3)
            .description("召喚三個1/1的薯條士兵，它們具有【連擊】效果。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.SUMMON)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(friesReinforcement.getName(), friesReinforcement);
        allSpells.add(friesReinforcement);
        
        SpellCard ketchupBlast = SpellCard.builder()
            .name("番茄醬爆發 (Ketchup Blast)")
            .cost(1)
            .description("對一個敵方角色造成2點傷害，如果你在本回合內已經使用過一張速食工會卡牌，則改為造成3點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(ketchupBlast.getName(), ketchupBlast);
        allSpells.add(ketchupBlast);
        
        SpellCard sodaExplosion = SpellCard.builder()
            .name("汽水炸裂 (Soda Explosion)")
            .cost(4)
            .description("對所有敵方角色造成2點傷害。對使用過【開胃】效果的敵方角色造成額外1點傷害。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.AOE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(sodaExplosion.getName(), sodaExplosion);
        allSpells.add(sodaExplosion);
        
        SpellCard fastFoodFrenzy = SpellCard.builder()
            .name("速食狂熱 (Fast Food Frenzy)")
            .cost(5)
            .description("使所有友方角色獲得+1/+1和【連擊】效果，持續2回合。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .spellType(SpellType.BUFF)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(fastFoodFrenzy.getName(), fastFoodFrenzy);
        allSpells.add(fastFoodFrenzy);
        
        SpellCard massProduction = SpellCard.builder()
            .name("批量生產 (Mass Production)")
            .cost(6)
            .description("在場上放置一個隨機的費用小於等於4的速食工會角色卡的複製。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .spellType(SpellType.SUMMON)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(massProduction.getName(), massProduction);
        allSpells.add(massProduction);
        
        SpellCard coffeeJolt = SpellCard.builder()
            .name("咖啡提神 (Coffee Jolt)")
            .cost(2)
            .description("使一個友方角色獲得+2攻擊力和【連擊】效果，持續1回合。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.BUFF)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(coffeeJolt.getName(), coffeeJolt);
        allSpells.add(coffeeJolt);
        
        SpellCard microwave = SpellCard.builder()
            .name("微波加熱 (Microwave Heating)")
            .cost(1)
            .description("對一個敵方角色造成1點傷害，如果你在本回合使用過另一張法術卡，則改為造成3點傷害。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.DAMAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(microwave.getName(), microwave);
        allSpells.add(microwave);
        
        SpellCard rushHour = SpellCard.builder()
            .name("營業高峰期 (Rush Hour)")
            .cost(3)
            .description("使所有友方角色獲得+1攻擊力，並使所有友方【速食】和【連擊】效果本回合觸發兩次。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .spellType(SpellType.BUFF)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(rushHour.getName(), rushHour);
        allSpells.add(rushHour);
        
        SpellCard extraDip = SpellCard.builder()
            .name("額外醬料 (Extra Dip)")
            .cost(2)
            .description("為一個友方角色恢復3點生命值，並使其獲得【油潤】效果，持續2回合。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.HEALING)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
        allCards.put(extraDip.getName(), extraDip);
        allSpells.add(extraDip);
        
        SpellCard kidsMealSurprise = SpellCard.builder()
            .name("兒童餐驚喜 (Kids Meal Surprise)")
            .cost(3)
            .description("隨機召喚一個費用為2的速食工會角色，並使其獲得+1/+1。")
            .rarity(Rarity.CASUAL_BITES)
            .spellType(SpellType.SUMMON)
            .faction(Faction.FAST_FOOD_GUILD)
            .build();
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