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
 * 甜點聯盟陣營卡牌初始化實現類
 */
public class DessertUnionInitializer implements FactionCardInitializer {
    
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
        return "甜點聯盟";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 蛋糕類角色卡
        CharacterCard spongeCakeWarrior = new CharacterCard(
            "海綿蛋糕吸收大師 (Sponge Cake Absorber)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(spongeCakeWarrior.getName(), spongeCakeWarrior);
        allCharacters.add(spongeCakeWarrior);
        
        CharacterCard chocolateCakeMage = new CharacterCard(
            "巧克力蛋糕甜點魔導師 (Chocolate Cake Archmage)", 4, "【糖霜】：抵擋一次傷害。【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(chocolateCakeMage.getName(), chocolateCakeMage);
        allCharacters.add(chocolateCakeMage);
        
        CharacterCard cheesecakeGuard = new CharacterCard(
            "起司蛋糕濃郁防衛官 (Cheesecake Defender)", 3, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 6, false, Faction.DESSERT_UNION);
        allCards.put(cheesecakeGuard.getName(), cheesecakeGuard);
        allCharacters.add(cheesecakeGuard);
        
        CharacterCard fruitCakeArcher = new CharacterCard(
            "水果蛋糕彩虹狙擊手 (Fruit Cake Sniper)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(fruitCakeArcher.getName(), fruitCakeArcher);
        allCharacters.add(fruitCakeArcher);
        
        CharacterCard creamCakePriest = new CharacterCard(
            "奶油蛋糕療癒牧師 (Cream Cake Healer)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(creamCakePriest.getName(), creamCakePriest);
        allCharacters.add(creamCakePriest);
        
        CharacterCard layeredCakeWarrior = new CharacterCard(
            "千層蛋糕疊層劍士 (Layered Cake Bladesman)", 4, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(layeredCakeWarrior.getName(), layeredCakeWarrior);
        allCharacters.add(layeredCakeWarrior);
        
        CharacterCard redVelvetMage = new CharacterCard(
            "紅絲絨蛋糕魔法調色師 (Red Velvet Colorist)", 3, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(redVelvetMage.getName(), redVelvetMage);
        allCharacters.add(redVelvetMage);
        
        CharacterCard tiramisuGuard = new CharacterCard(
            "提拉米蘇咖啡守護者 (Tiramisu Coffee Guardian)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(tiramisuGuard.getName(), tiramisuGuard);
        allCharacters.add(tiramisuGuard);
        
        CharacterCard blackForestArcher = new CharacterCard(
            "黑森林蛋糕櫻桃獵人 (Black Forest Cherry Hunter)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(blackForestArcher.getName(), blackForestArcher);
        allCharacters.add(blackForestArcher);
        
        CharacterCard angelCakePriest = new CharacterCard(
            "天使蛋糕祈福使者 (Angel Cake Blessed Envoy)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(angelCakePriest.getName(), angelCakePriest);
        allCharacters.add(angelCakePriest);

        // 餅乾類角色卡
        CharacterCard chocolateChipWarrior = new CharacterCard(
            "巧克力豆餅乾碎片突擊兵 (Chocolate Chip Assault Trooper)", 2, "【糖爆】：對所有敵方角色造成1點傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(chocolateChipWarrior.getName(), chocolateChipWarrior);
        allCharacters.add(chocolateChipWarrior);
        
        CharacterCard oatmealGuard = new CharacterCard(
            "燕麥餅乾健康守門員 (Oatmeal Nutrition Goalkeeper)", 3, "【糖爆】：使自身獲得+0/+2直到回合結束。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(oatmealGuard.getName(), oatmealGuard);
        allCharacters.add(oatmealGuard);
        
        CharacterCard gingerbreadArcher = new CharacterCard(
            "薑餅人奔跑弓箭手 (Gingerbread Sprinting Archer)", 2, "【糖爆】：使敵方一個角色無法攻擊直到回合結束。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.DESSERT_UNION);
        allCards.put(gingerbreadArcher.getName(), gingerbreadArcher);
        allCharacters.add(gingerbreadArcher);
        
        CharacterCard fortuneCookieMage = new CharacterCard(
            "幸運餅乾預言賢者 (Fortune Cookie Oracle)", 4, "【糖爆】：抽一張牌。【開胃】：抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 3, 3, false, Faction.DESSERT_UNION);
        allCards.put(fortuneCookieMage.getName(), fortuneCookieMage);
        allCharacters.add(fortuneCookieMage);
        
        CharacterCard butterCookiePriest = new CharacterCard(
            "奶油餅乾甜香治癒師 (Butter Cookie Sweetscent Healer)", 3, "【糖爆】：為一個友方角色恢復2點生命值。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(butterCookiePriest.getName(), butterCookiePriest);
        allCharacters.add(butterCookiePriest);
        
        CharacterCard almondCookieWarrior = new CharacterCard(
            "杏仁餅乾脆片刀客 (Almond Cookie Crisp Blader)", 3, "【糖爆】：使自身獲得+2/+0直到回合結束。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(almondCookieWarrior.getName(), almondCookieWarrior);
        allCharacters.add(almondCookieWarrior);
        
        CharacterCard coconutCookieMage = new CharacterCard(
            "椰子餅乾熱帶法術師 (Coconut Cookie Tropical Spellcaster)", 4, "【糖爆】：使一個友方角色獲得【糖霜】效果。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(coconutCookieMage.getName(), coconutCookieMage);
        allCharacters.add(coconutCookieMage);
        
        CharacterCard peanutCookieGuard = new CharacterCard(
            "花生餅乾堅硬盾衛 (Peanut Cookie Hard Shield)", 3, "【糖爆】：對一個敵方角色造成1點傷害並使其攻擊力減少1。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(peanutCookieGuard.getName(), peanutCookieGuard);
        allCharacters.add(peanutCookieGuard);
        
        CharacterCard raisinCookieArcher = new CharacterCard(
            "葡萄乾餅乾精準射擊士 (Raisin Cookie Precision Shooter)", 2, "【糖爆】：對敵方生命值最低的角色造成2點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, true, Faction.DESSERT_UNION);
        allCards.put(raisinCookieArcher.getName(), raisinCookieArcher);
        allCharacters.add(raisinCookieArcher);
        
        CharacterCard macaronPriest = new CharacterCard(
            "馬卡龍繽紛祭祀官 (Macaron Rainbow Celebrant)", 5, "【糖爆】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(macaronPriest.getName(), macaronPriest);
        allCharacters.add(macaronPriest);

        // 冰淇淋類角色卡
        CharacterCard vanillaWarrior = new CharacterCard(
            "香草冰淇淋清涼劍客 (Vanilla Ice Cream Frosty Swordsman)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(vanillaWarrior.getName(), vanillaWarrior);
        allCharacters.add(vanillaWarrior);
        
        CharacterCard chocolateGuard = new CharacterCard(
            "巧克力冰淇淋融化護衛 (Chocolate Ice Cream Melting Guardian)", 4, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(chocolateGuard.getName(), chocolateGuard);
        allCharacters.add(chocolateGuard);
        
        CharacterCard iceCreamStrawberryArcher = new CharacterCard(
            "草莓冰淇淋凍感獵手 (Strawberry Ice Cream Frost Hunter)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(iceCreamStrawberryArcher.getName(), iceCreamStrawberryArcher);
        allCharacters.add(iceCreamStrawberryArcher);
        
        CharacterCard mintMage = new CharacterCard(
            "薄荷冰淇淋涼爽巫師 (Mint Ice Cream Chilling Wizard)", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個敵方角色無法攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(mintMage.getName(), mintMage);
        allCharacters.add(mintMage);
        
        CharacterCard caramelPriest = new CharacterCard(
            "焦糖冰淇淋黏糊祭司 (Caramel Ice Cream Sticky Priest)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(caramelPriest.getName(), caramelPriest);
        allCharacters.add(caramelPriest);
        
        CharacterCard blueberryWarrior = new CharacterCard(
            "藍莓冰淇淋急凍勇士 (Blueberry Ice Cream Flash Freezer)", 3, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(blueberryWarrior.getName(), blueberryWarrior);
        allCharacters.add(blueberryWarrior);
        
        CharacterCard coffeeMage = new CharacterCard(
            "咖啡冰淇淋提神魔法師 (Coffee Ice Cream Awakener Magus)", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(coffeeMage.getName(), coffeeMage);
        allCharacters.add(coffeeMage);
        
        CharacterCard pistachioGuard = new CharacterCard(
            "開心果冰淇淋翠綠防禦官 (Pistachio Ice Cream Emerald Defender)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(pistachioGuard.getName(), pistachioGuard);
        allCharacters.add(pistachioGuard);
        
        CharacterCard mangoArcher = new CharacterCard(
            "芒果冰淇淋熱帶神射手 (Mango Ice Cream Tropical Marksman)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(mangoArcher.getName(), mangoArcher);
        allCharacters.add(mangoArcher);
        
        CharacterCard rainbowPriest = new CharacterCard(
            "彩虹冰淇淋七色高祭 (Rainbow Ice Cream Spectrum Pontiff)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(rainbowPriest.getName(), rainbowPriest);
        allCharacters.add(rainbowPriest);

        // 布丁類角色卡
        CharacterCard puddingCaramelWarrior = new CharacterCard(
            "焦糖布丁搖晃劍士 (Caramel Pudding Wobbling Swordsman)", 3, "【糖爆】：使自身和相鄰友方角色獲得+1/+0直到回合結束。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(puddingCaramelWarrior.getName(), puddingCaramelWarrior);
        allCharacters.add(puddingCaramelWarrior);
        
        CharacterCard puddingChocolateGuard = new CharacterCard(
            "巧克力布丁彈跳守護者 (Chocolate Pudding Bouncing Guardian)", 4, "【糖爆】：使所有友方角色獲得+0/+1。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(puddingChocolateGuard.getName(), puddingChocolateGuard);
        allCharacters.add(puddingChocolateGuard);
        
        CharacterCard puddingStrawberryArcher = new CharacterCard(
            "草莓布丁果香狙擊手 (Strawberry Pudding Fruity Sniper)", 2, "【糖爆】：如果目標敵方角色生命值低於3，則造成3點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(puddingStrawberryArcher.getName(), puddingStrawberryArcher);
        allCharacters.add(puddingStrawberryArcher);
        
        CharacterCard vanillaMage = new CharacterCard(
            "香草布丁療癒奇術師 (Vanilla Pudding Healing Mystic)", 4, "【糖爆】：為所有友方角色恢復1點生命值。【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(vanillaMage.getName(), vanillaMage);
        allCharacters.add(vanillaMage);
        
        CharacterCard matchaPriest = new CharacterCard(
            "抹茶布丁茶道司祭 (Matcha Pudding Tea Ceremony Priest)", 5, "【糖爆】：使一個友方角色獲得+1/+1並恢復1點生命值。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(matchaPriest.getName(), matchaPriest);
        allCharacters.add(matchaPriest);
        
        CharacterCard coffeeWarrior = new CharacterCard(
            "咖啡布丁醒神戰將 (Coffee Pudding Awakening General)", 3, "【糖爆】：本回合可以再攻擊一次。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(coffeeWarrior.getName(), coffeeWarrior);
        allCharacters.add(coffeeWarrior);
        
        CharacterCard mangoMage = new CharacterCard(
            "芒果布丁熱帶施法者 (Mango Pudding Tropical Conjurer)", 4, "【糖爆】：召喚一個1/1的布丁小兵。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(mangoMage.getName(), mangoMage);
        allCharacters.add(mangoMage);
        
        CharacterCard coconutGuard = new CharacterCard(
            "椰子布丁椰香衛隊長 (Coconut Pudding Tropical Guard Captain)", 3, "【糖爆】：為自身恢復2點生命值。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(coconutGuard.getName(), coconutGuard);
        allCharacters.add(coconutGuard);
        
        CharacterCard strawberryArcher = new CharacterCard(
            "草莓布丁漿果獵人 (Strawberry Pudding Berry Hunter)", 2, "【糖爆】：使一個敵方角色本回合無法使用技能。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(strawberryArcher.getName(), strawberryArcher);
        allCharacters.add(strawberryArcher);
        
        CharacterCard taroPriest = new CharacterCard(
            "芋頭布丁紫晶聖職者 (Taro Pudding Amethyst Cleric)", 5, "【糖爆】：抽一張牌並使一個友方角色獲得+1/+1。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(taroPriest.getName(), taroPriest);
        allCharacters.add(taroPriest);

        // 巧克力類角色卡
        CharacterCard darkWarrior = new CharacterCard(
            "黑巧克力黑暗騎士團長 (Dark Chocolate Shadow Knight Commander)", 3, "【糖爆】：對目標敵方角色造成3點傷害，自身受到1點傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(darkWarrior.getName(), darkWarrior);
        allCharacters.add(darkWarrior);
        
        CharacterCard milkGuard = new CharacterCard(
            "牛奶巧克力絲滑守護騎士 (Milk Chocolate Silky Protection Knight)", 4, "【糖爆】：為所有友方角色恢復1點生命值並使其獲得+0/+1。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(milkGuard.getName(), milkGuard);
        allCharacters.add(milkGuard);
        
        CharacterCard whiteArcher = new CharacterCard(
            "白巧克力月光精靈射手 (White Chocolate Moonlight Elf Archer)", 2, "【糖爆】：使所有敵方角色在下個回合攻擊力降低1。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(whiteArcher.getName(), whiteArcher);
        allCharacters.add(whiteArcher);
        
        CharacterCard hazelnutMage = new CharacterCard(
            "榛果巧克力爆裂咒術師 (Hazelnut Chocolate Explosive Hexmaster)", 4, "【糖爆】：對一個敵方角色造成2點傷害並使其無法行動一回合。【開胃】：使一個友方角色獲得+2/+0。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(hazelnutMage.getName(), hazelnutMage);
        allCharacters.add(hazelnutMage);
        
        CharacterCard chocolateCaramelPriest = new CharacterCard(
            "焦糖巧克力甜蜜大司祭 (Caramel Chocolate Sweet Supreme Pontiff)", 5, "【糖爆】：使一個友方角色獲得+1/+1並抽一張牌。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(chocolateCaramelPriest.getName(), chocolateCaramelPriest);
        allCharacters.add(chocolateCaramelPriest);
        
        CharacterCard mintWarrior = new CharacterCard(
            "薄荷巧克力冰凍刺客 (Mint Chocolate Frost Assassin)", 3, "【糖爆】：使一個敵方角色凍結一回合（無法攻擊也無法使用技能）。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(mintWarrior.getName(), mintWarrior);
        allCharacters.add(mintWarrior);
        
        CharacterCard orangeMage = new CharacterCard(
            "橙味巧克力陽光術法家 (Orange Chocolate Sunshine Spellweaver)", 4, "【糖爆】：使所有友方角色獲得+1/+0直到回合結束。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(orangeMage.getName(), orangeMage);
        allCharacters.add(orangeMage);
        
        CharacterCard almondGuard = new CharacterCard(
            "杏仁巧克力硬殼防衛者 (Almond Chocolate Hard Shell Defender)", 3, "【糖爆】：將一個敵方角色的攻擊目標轉向自己。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(almondGuard.getName(), almondGuard);
        allCharacters.add(almondGuard);
        
        CharacterCard coffeeArcher = new CharacterCard(
            "咖啡巧克力警醒神槍手 (Coffee Chocolate Vigilant Sharpshooter)", 2, "【糖爆】：使自身攻擊力提高2點直到回合結束。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(coffeeArcher.getName(), coffeeArcher);
        allCharacters.add(coffeeArcher);
        
        CharacterCard raspberryPriest = new CharacterCard(
            "覆盆子巧克力漿果巫師 (Raspberry Chocolate Berry Sorcerer Supreme)", 5, "【糖爆】：隨機對三個敵方角色各造成1點傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(raspberryPriest.getName(), raspberryPriest);
        allCharacters.add(raspberryPriest);

        // 和菓子類角色卡
        CharacterCard mochiWarrior = new CharacterCard(
            "麻糬彈性劍豪 (Mochi Elastic Blade Master)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(mochiWarrior.getName(), mochiWarrior);
        allCharacters.add(mochiWarrior);
        
        CharacterCard dangoGuard = new CharacterCard(
            "團子堅實防壁隊長 (Dango Solid Bulwark Captain)", 4, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(dangoGuard.getName(), dangoGuard);
        allCharacters.add(dangoGuard);
        
        CharacterCard manjuArcher = new CharacterCard(
            "饅頭蒸氣遠征射手 (Manju Steam Expedition Archer)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(manjuArcher.getName(), manjuArcher);
        allCharacters.add(manjuArcher);
        
        CharacterCard yokanMage = new CharacterCard(
            "羊羹凝結魔法師 (Yokan Gelatinous Archmage)", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(yokanMage.getName(), yokanMage);
        allCharacters.add(yokanMage);
        
        CharacterCard daifukuPriest = new CharacterCard(
            "大福豆沙祈禱官 (Daifuku Bean Paste Prayer Master)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(daifukuPriest.getName(), daifukuPriest);
        allCharacters.add(daifukuPriest);
        
        CharacterCard dorayakiWarrior = new CharacterCard(
            "銅鑼燒旋風斬擊者 (Dorayaki Whirlwind Slash Artist)", 3, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(dorayakiWarrior.getName(), dorayakiWarrior);
        allCharacters.add(dorayakiWarrior);
        
        CharacterCard taiyakiMage = new CharacterCard(
            "鯛魚燒河流元素使 (Taiyaki River Elemental Conjurer)", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(taiyakiMage.getName(), taiyakiMage);
        allCharacters.add(taiyakiMage);
        
        CharacterCard wagashiGuard = new CharacterCard(
            "和菓子四季守護者 (Wagashi Four Seasons Guardian)", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(wagashiGuard.getName(), wagashiGuard);
        allCharacters.add(wagashiGuard);
        
        CharacterCard monakaArcher = new CharacterCard(
            "最中脆片精準射擊手 (Monaka Crispy Precision Sniper)", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(monakaArcher.getName(), monakaArcher);
        allCharacters.add(monakaArcher);
        
        CharacterCard namagashiPriest = new CharacterCard(
            "生菓子鮮花祝福者 (Namagashi Fresh Flower Blesser)", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(namagashiPriest.getName(), namagashiPriest);
        allCharacters.add(namagashiPriest);

        // 派類角色卡
        CharacterCard pieAppleWarrior = new CharacterCard(
            "蘋果派果香劍術大師 (Apple Pie Fruity Sword Grandmaster)", 3, "【糖爆】：使自身獲得+1/+1並治癒所有負面效果。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(pieAppleWarrior.getName(), pieAppleWarrior);
        allCharacters.add(pieAppleWarrior);
        
        CharacterCard pumpkinGuard = new CharacterCard(
            "南瓜派豐收護壁騎士 (Pumpkin Pie Harvest Bulwark Knight)", 4, "【糖爆】：使敵方角色本回合不能攻擊該角色。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(pumpkinGuard.getName(), pumpkinGuard);
        allCharacters.add(pumpkinGuard);
        
        CharacterCard pieCherryArcher = new CharacterCard(
            "櫻桃派紅寶石遠射士 (Cherry Pie Ruby Longshot Trooper)", 2, "【糖爆】：對敵方所有角色造成1點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieCherryArcher.getName(), pieCherryArcher);
        allCharacters.add(pieCherryArcher);
        
        CharacterCard chocolateMage = new CharacterCard(
            "巧克力派魔法製餡師 (Chocolate Pie Magical Filling Artificer)", 4, "【糖爆】：抽兩張牌並棄一張牌。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(chocolateMage.getName(), chocolateMage);
        allCharacters.add(chocolateMage);
        
        CharacterCard lemonPriest = new CharacterCard(
            "檸檬派淨化光環祭司 (Lemon Pie Purification Aura Priest)", 5, "【糖爆】：治療一個友方角色所有傷害並消除其負面效果。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(lemonPriest.getName(), lemonPriest);
        allCharacters.add(lemonPriest);
        
        CharacterCard pieBlueberryWarrior = new CharacterCard(
            "藍莓派星空突襲兵 (Blueberry Pie Starry Night Raider)", 3, "【糖爆】：使一個友方角色獲得+1/+1並治癒其所有負面效果。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieBlueberryWarrior.getName(), pieBlueberryWarrior);
        allCharacters.add(pieBlueberryWarrior);
        
        CharacterCard pecanMage = new CharacterCard(
            "胡桃派古木魔能師 (Pecan Pie Ancient Wood Mage)", 4, "【糖爆】：使一個敵方角色攻擊和生命值減少1。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(pecanMage.getName(), pecanMage);
        allCharacters.add(pecanMage);
        
        CharacterCard keyLimeGuard = new CharacterCard(
            "萊姆派酸甜鎧甲守護者 (Key Lime Pie Tangy Armored Protector)", 3, "【糖爆】：使周圍友方角色獲得【酥脆(1)】效果一回合。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(keyLimeGuard.getName(), keyLimeGuard);
        allCharacters.add(keyLimeGuard);
        
        CharacterCard pieStrawberryArcher = new CharacterCard(
            "草莓派鮮紅狙殺者 (Strawberry Pie Crimson Eliminator)", 2, "【糖爆】：攻擊敵方最弱的角色並造成2點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieStrawberryArcher.getName(), pieStrawberryArcher);
        allCharacters.add(pieStrawberryArcher);
        
        CharacterCard bananaPriest = new CharacterCard(
            "香蕉派黃金聖光牧師 (Banana Pie Golden Radiance Chaplain)", 5, "【糖爆】：為所有友方角色恢復2點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(bananaPriest.getName(), bananaPriest);
        allCharacters.add(bananaPriest);

        // 糖果類角色卡
        CharacterCard lollipopWarrior = new CharacterCard(
            "棒棒糖旋轉刀鋒騎士 (Lollipop Spinning Blade Knight)", 3, "【糖爆】：隨機使一個敵方角色暈眩一回合（無法行動）。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, true, Faction.DESSERT_UNION);
        allCards.put(lollipopWarrior.getName(), lollipopWarrior);
        allCharacters.add(lollipopWarrior);
        
        CharacterCard gummyGuard = new CharacterCard(
            "軟糖彈力防禦者 (Gummy Elastic Defense Specialist)", 4, "【糖爆】：使自身獲得+1/+3直到回合結束。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(gummyGuard.getName(), gummyGuard);
        allCharacters.add(gummyGuard);
        
        CharacterCard hardCandyArcher = new CharacterCard(
            "硬糖水晶穿透射手 (Hard Candy Crystal Penetration Archer)", 2, "【糖爆】：對敵方生命值最高的角色造成3點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(hardCandyArcher.getName(), hardCandyArcher);
        allCharacters.add(hardCandyArcher);
        
        CharacterCard jellyBeanMage = new CharacterCard(
            "雷根糖彩色元素師 (Jelly Bean Chromatic Elementalist)", 4, "【糖爆】：隨機使三個友方角色各獲得+1/+0。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(jellyBeanMage.getName(), jellyBeanMage);
        allCharacters.add(jellyBeanMage);
        
        CharacterCard candyCaramelPriest = new CharacterCard(
            "焦糖金色祈禱主教 (Caramel Golden Prayer Bishop)", 5, "【糖爆】：使所有友方角色本回合獲得+1/+0。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(candyCaramelPriest.getName(), candyCaramelPriest);
        allCharacters.add(candyCaramelPriest);
        
        CharacterCard chocolateWarrior = new CharacterCard(
            "巧克力百分比傷害勇者 (Chocolate Percentage Damage Hero)", 3, "【糖爆】：對目標敵方角色造成其當前生命值20%的傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(chocolateWarrior.getName(), chocolateWarrior);
        allCharacters.add(chocolateWarrior);
        
        CharacterCard marshmallowMage = new CharacterCard(
            "棉花糖雲朵治癒大師 (Marshmallow Cloud Healing Master)", 4, "【糖爆】：為生命值最低的友方角色恢復3點生命值。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(marshmallowMage.getName(), marshmallowMage);
        allCharacters.add(marshmallowMage);
        
        CharacterCard toffeeGuard = new CharacterCard(
            "太妃糖黏附重盾衛士 (Toffee Sticky Heavy Shield Sentry)", 3, "【糖爆】：使敵方角色攻擊力降低2直到回合結束。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(toffeeGuard.getName(), toffeeGuard);
        allCharacters.add(toffeeGuard);
        
        CharacterCard licoriceArcher = new CharacterCard(
            "甘草糖毒性弓術專家 (Licorice Toxic Archery Specialist)", 2, "【糖爆】：使目標敵方角色中毒（每回合受到1點傷害，持續2回合）。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(licoriceArcher.getName(), licoriceArcher);
        allCharacters.add(licoriceArcher);
        
        CharacterCard rockCandyPriest = new CharacterCard(
            "冰糖水晶聖光祭祀長 (Rock Candy Crystal Holy Ceremonialist)", 5, "【糖爆】：使所有友方角色獲得【糖霜】效果直到回合結束。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(rockCandyPriest.getName(), rockCandyPriest);
        allCharacters.add(rockCandyPriest);

        // 法術卡
        // 糖霜相關法術
        SpellCard sugarFrosting = new SpellCard(
            "頂級糖霜魔法披風 (Premium Sugar Frost Magical Cloak)", 2, "使一個友方角色獲得【糖霜】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarFrosting.getName(), sugarFrosting);
        allSpells.add(sugarFrosting);
        
        SpellCard frostShield = new SpellCard(
            "冰晶糖霜折光護盾 (Crystal Sugar Refraction Shield)", 3, "使一個友方角色獲得【糖霜】效果和+0/+2。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostShield.getName(), frostShield);
        allSpells.add(frostShield);
        
        SpellCard frostBarrier = new SpellCard(
            "霜糖多層次防護結界 (Frosting Multi-Layered Barrier Field)", 4, "使所有友方角色獲得【糖霜】效果。", 
            Rarity.CULINARY_HERITAGE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostBarrier.getName(), frostBarrier);
        allSpells.add(frostBarrier);

        // 糖爆相關法術
        SpellCard sugarBurst = new SpellCard(
            "爆裂糖華能量脈衝 (Bursting Sugar Energy Pulse)", 3, "對一個敵方角色造成3點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DAMAGE, Faction.DESSERT_UNION);
        allCards.put(sugarBurst.getName(), sugarBurst);
        allSpells.add(sugarBurst);
        
        SpellCard sugarExplosion = new SpellCard(
            "甜蜜超新星連鎖爆炸 (Sweet Supernova Chain Explosion)", 5, "對所有敵方角色造成2點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sugarExplosion.getName(), sugarExplosion);
        allSpells.add(sugarExplosion);
        
        SpellCard sugarStorm = new SpellCard(
            "狂暴蔗糖極限漩渦 (Raging Sucrose Ultimate Vortex)", 6, "對所有敵方角色造成3點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sugarStorm.getName(), sugarStorm);
        allSpells.add(sugarStorm);

        // 甜點製作法術
        SpellCard cakeSummon = new SpellCard(
            "皇家蛋糕華麗現身術 (Royal Cake Magnificent Manifestation)", 3, "召喚一個2/2的蛋糕小兵。", 
            Rarity.CASUAL_BITES, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(cakeSummon.getName(), cakeSummon);
        allSpells.add(cakeSummon);
        
        SpellCard cookieArmy = new SpellCard(
            "餅乾軍團緊急動員令 (Cookie Legion Emergency Mobilization)", 5, "召喚三個1/1的餅乾小兵。", 
            Rarity.GOURMET_DELIGHT, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(cookieArmy.getName(), cookieArmy);
        allSpells.add(cookieArmy);
        
        SpellCard dessertBuffetSpell = new SpellCard(
            "甜點饗宴盛會嘉年華 (Dessert Extravaganza Carnival Feast)", 7, "召喚一個3/3的蛋糕、一個2/2的餅乾和一個1/1的糖果。", 
            Rarity.CULINARY_HERITAGE, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(dessertBuffetSpell.getName(), dessertBuffetSpell);
        allSpells.add(dessertBuffetSpell);

        // 甜點效果法術
        SpellCard sweetHealing = new SpellCard(
            "蜜糖療癒溫柔之觸 (Honey Healing Gentle Caress)", 2, "為一個友方角色恢復3點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(sweetHealing.getName(), sweetHealing);
        allSpells.add(sweetHealing);
        
        SpellCard sweetBlessing = new SpellCard(
            "甜蜜祝福七彩光環 (Sweet Blessing Rainbow Aura)", 4, "使所有友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sweetBlessing.getName(), sweetBlessing);
        allSpells.add(sweetBlessing);
        
        SpellCard sweetCurse = new SpellCard(
            "糖衣毒咒隱形魔法 (Sugar-Coated Invisible Hex)", 3, "使一個敵方角色獲得-1/-1。", 
            Rarity.CASUAL_BITES, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(sweetCurse.getName(), sweetCurse);
        allSpells.add(sweetCurse);

        // 特殊效果法術
        SpellCard dessertDraw = new SpellCard(
            "甜品靈感突發創意 (Dessert Inspiration Sudden Creativity)", 2, "抽一張牌。", 
            Rarity.CASUAL_BITES, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertDraw.getName(), dessertDraw);
        allSpells.add(dessertDraw);
        
        SpellCard dessertRitual = new SpellCard(
            "甜點祭典古老儀式 (Dessert Festival Ancient Ceremony)", 4, "抽兩張牌，並使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertRitual.getName(), dessertRitual);
        allSpells.add(dessertRitual);
        
        SpellCard dessertMastery = new SpellCard(
            "甜點大師無上心法 (Dessert Maestro Supreme Technique)", 6, "抽三張牌，並使所有友方角色獲得+1/+1。", 
            Rarity.CULINARY_HERITAGE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertMastery.getName(), dessertMastery);
        allSpells.add(dessertMastery);

        // 場地卡
        // 甜點店相關
        FieldCard cakeShop = FieldCard.createEnvironmentField(
            "皇家蛋糕魔幻夢工坊 (Royal Cake Magical Dream Atelier)", 3, "每回合開始時，使一個友方角色獲得【糖霜】效果。", 
            Rarity.CASUAL_BITES, 2, Faction.DESSERT_UNION);
        allCards.put(cakeShop.getName(), cakeShop);
        allFieldCards.add(cakeShop);
        
        FieldCard cookieFactory = FieldCard.createEnvironmentField(
            "餅乾超智能生產工廠 (Cookie Hyper-Intelligent Manufacturing Plant)", 4, "每回合結束時，召喚一個1/1的餅乾小兵。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.DESSERT_UNION);
        allCards.put(cookieFactory.getName(), cookieFactory);
        allFieldCards.add(cookieFactory);
        
        FieldCard iceCreamParlor = FieldCard.createEnvironmentField(
            "極凍冰淇淋水晶宮殿 (Frostbite Ice Cream Crystal Palace)", 3, "每當你使用一張法術卡時，使一個友方角色獲得+0/+1。", 
            Rarity.CASUAL_BITES, 2, Faction.DESSERT_UNION);
        allCards.put(iceCreamParlor.getName(), iceCreamParlor);
        allFieldCards.add(iceCreamParlor);

        // 甜點工坊相關
        FieldCard dessertKitchen = FieldCard.createEnvironmentField(
            "米其林星級甜點主廚廚房 (Michelin Star Dessert Chef Kitchen)", 5, "友方角色獲得+1/+1。", 
            Rarity.CULINARY_HERITAGE, 4, Faction.DESSERT_UNION);
        allCards.put(dessertKitchen.getName(), dessertKitchen);
        allFieldCards.add(dessertKitchen);
        
        FieldCard sugarMill = FieldCard.createEnvironmentField(
            "魔法糖霜高階提煉研究所 (Magical Frosting Advanced Refining Institute)", 3, "每回合開始時，隨機使一個友方角色獲得+2/+0直到回合結束。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.DESSERT_UNION);
        allCards.put(sugarMill.getName(), sugarMill);
        allFieldCards.add(sugarMill);
        
        FieldCard dessertMarket = FieldCard.createEnvironmentField(
            "甜點嘉年華奇妙市集 (Dessert Carnival Wondrous Bazaar)", 3, "每回合開始時，有25%機率抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.DESSERT_UNION);
        allCards.put(dessertMarket.getName(), dessertMarket);
        allFieldCards.add(dessertMarket);

        // 特殊場地
        FieldCard dessertBuffetField = FieldCard.createEnvironmentField(
            "奢華甜點永恆饗宴盛宴 (Luxurious Dessert Eternal Banquet Feast)", 5, "每回合開始時，隨機使一個友方角色獲得【糖霜】效果。", 
            Rarity.ULTIMATE_TASTE, 4, Faction.DESSERT_UNION);
        allCards.put(dessertBuffetField.getName(), dessertBuffetField);
        allFieldCards.add(dessertBuffetField);
        
        FieldCard dessertGarden = FieldCard.createEnvironmentField(
            "魔幻甜品童話夢境花園 (Enchanted Confection Fairytale Dream Garden)", 4, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, Faction.DESSERT_UNION);
        allCards.put(dessertGarden.getName(), dessertGarden);
        allFieldCards.add(dessertGarden);
        
        FieldCard dessertWorkshop = FieldCard.createEnvironmentField(
            "精靈甜點創意研發工坊 (Elf Confectionery Creative Development Workshop)", 3, "每當你打出一個角色卡時，使其獲得+0/+2。", 
            Rarity.CASUAL_BITES, 3, Faction.DESSERT_UNION);
        allCards.put(dessertWorkshop.getName(), dessertWorkshop);
        allFieldCards.add(dessertWorkshop);
        
        FieldCard dessertFountain = FieldCard.createEnvironmentField(
            "彩虹糖漿瀑布魔法噴泉 (Rainbow Syrup Waterfall Magical Fountain)", 4, "每回合開始時，使一個友方角色獲得【糖爆】效果直到回合結束。", 
            Rarity.CULINARY_HERITAGE, 3, Faction.DESSERT_UNION);
        allCards.put(dessertFountain.getName(), dessertFountain);
        allFieldCards.add(dessertFountain);

        // 新增的法術卡
        SpellCard sugarNova = new SpellCard(
            "糖霜新星能量爆發 (Sugar Nova Energy Burst)", 6, "對所有敵方角色造成3點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sugarNova.getName(), sugarNova);
        allSpells.add(sugarNova);

        // 糖霜相關法術
        SpellCard frostBite = new SpellCard(
            "霜糖凍結射線 (Frosting Freeze Ray)", 2, "使一個敵方角色獲得【糖霜】效果。", 
            Rarity.CASUAL_BITES, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(frostBite.getName(), frostBite);
        allSpells.add(frostBite);
        
        SpellCard frostWave = new SpellCard(
            "霜糖波浪衝擊波 (Frosting Wave Shockwave)", 4, "使所有敵方角色獲得【糖霜】效果。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(frostWave.getName(), frostWave);
        allSpells.add(frostWave);
        
        SpellCard frostStorm = new SpellCard(
            "霜糖風暴能量漩渦 (Frosting Storm Energy Vortex)", 5, "使所有敵方角色獲得【糖霜】效果並造成1點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(frostStorm.getName(), frostStorm);
        allSpells.add(frostStorm);

        // 糖霜和糖爆混合法術
        SpellCard frostBurst = new SpellCard(
            "霜糖爆裂能量脈衝 (Frosting Burst Energy Pulse)", 3, "使一個敵方角色獲得【糖霜】效果並造成2點傷害。", 
            Rarity.CASUAL_BITES, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(frostBurst.getName(), frostBurst);
        allSpells.add(frostBurst);
        
        SpellCard frostExplosion = new SpellCard(
            "霜糖爆炸能量風暴 (Frosting Explosion Energy Storm)", 5, "使所有敵方角色獲得【糖霜】效果並造成2點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(frostExplosion.getName(), frostExplosion);
        allSpells.add(frostExplosion);
        
        SpellCard frostNova = new SpellCard(
            "霜糖新星能量爆發 (Frosting Nova Energy Burst)", 6, "使所有敵方角色獲得【糖霜】效果並造成3點傷害。", 
            Rarity.CULINARY_HERITAGE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(frostNova.getName(), frostNova);
        allSpells.add(frostNova);

        // 新增的城堡卡
        CharacterCard cakeCastle = new CharacterCard(
            "蛋糕城堡甜點王座 (Cake Castle Dessert Throne)", 6, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CULINARY_HERITAGE, 4, 8, false, Faction.DESSERT_UNION);
        allCards.put(cakeCastle.getName(), cakeCastle);
        allCharacters.add(cakeCastle);
        
        CharacterCard cookieCastle = new CharacterCard(
            "餅乾城堡酥脆要塞 (Cookie Castle Crispy Fortress)", 5, "【糖爆】：使所有友方角色獲得+1/+1。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 3, 7, false, Faction.DESSERT_UNION);
        allCards.put(cookieCastle.getName(), cookieCastle);
        allCharacters.add(cookieCastle);
        
        CharacterCard iceCreamCastle = new CharacterCard(
            "冰淇淋城堡清涼堡壘 (Ice Cream Castle Cool Fortress)", 6, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 4, 8, false, Faction.DESSERT_UNION);
        allCards.put(iceCreamCastle.getName(), iceCreamCastle);
        allCharacters.add(iceCreamCastle);
        
        CharacterCard puddingCastle = new CharacterCard(
            "布丁城堡彈跳要塞 (Pudding Castle Bouncing Fortress)", 7, "【糖爆】：使所有友方角色獲得+2/+2。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CULINARY_HERITAGE, 5, 9, false, Faction.DESSERT_UNION);
        allCards.put(puddingCastle.getName(), puddingCastle);
        allCharacters.add(puddingCastle);
        
        CharacterCard chocolateCastle = new CharacterCard(
            "巧克力城堡甜蜜堡壘 (Chocolate Castle Sweet Fortress)", 5, "【糖爆】：使所有友方角色獲得+1/+1。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 3, 7, false, Faction.DESSERT_UNION);
        allCards.put(chocolateCastle.getName(), chocolateCastle);
        allCharacters.add(chocolateCastle);
        
        CharacterCard japaneseCastle = new CharacterCard(
            "和菓子城堡四季要塞 (Japanese Dessert Castle Four Seasons Fortress)", 6, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 4, 8, false, Faction.DESSERT_UNION);
        allCards.put(japaneseCastle.getName(), japaneseCastle);
        allCharacters.add(japaneseCastle);
        
        CharacterCard pieCastle = new CharacterCard(
            "派城堡豐收堡壘 (Pie Castle Harvest Fortress)", 7, "【糖爆】：使所有友方角色獲得+2/+2。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CULINARY_HERITAGE, 5, 9, false, Faction.DESSERT_UNION);
        allCards.put(pieCastle.getName(), pieCastle);
        allCharacters.add(pieCastle);
        
        CharacterCard candyCastle = new CharacterCard(
            "糖果城堡甜蜜要塞 (Candy Castle Sweet Fortress)", 5, "【糖爆】：使所有友方角色獲得+1/+1。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 3, 7, false, Faction.DESSERT_UNION);
        allCards.put(candyCastle.getName(), candyCastle);
        allCharacters.add(candyCastle);
        
        CharacterCard dessertCastle = new CharacterCard(
            "甜點城堡終極堡壘 (Dessert Castle Ultimate Fortress)", 8, "【糖霜】：抵擋一次傷害。【糖爆】：使所有友方角色獲得+3/+3。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.ULTIMATE_TASTE, 6, 10, false, Faction.DESSERT_UNION);
        allCards.put(dessertCastle.getName(), dessertCastle);
        allCharacters.add(dessertCastle);
    }
    
} 