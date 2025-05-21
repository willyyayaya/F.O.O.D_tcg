package com.example.game.card.faction;

import java.util.List;
import java.util.Map;

import com.example.game.card.Card;
import com.example.game.card.CastleCard;
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
    
    @Override
    public void initializeCards(
        Map<String, Card> allCards,
        List<CharacterCard> allCharacters,
        List<SpellCard> allSpells,
        List<FieldCard> allFieldCards,
        List<CastleCard> allCastles
    ) {
        // 蛋糕類角色卡
        CharacterCard spongeCakeWarrior = new CharacterCard(
            "海綿蛋糕戰士", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(spongeCakeWarrior.getName(), spongeCakeWarrior);
        allCharacters.add(spongeCakeWarrior);
        
        CharacterCard chocolateCakeMage = new CharacterCard(
            "巧克力蛋糕法師", 4, "【糖霜】：抵擋一次傷害。【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(chocolateCakeMage.getName(), chocolateCakeMage);
        allCharacters.add(chocolateCakeMage);
        
        CharacterCard cheesecakeGuard = new CharacterCard(
            "起司蛋糕守衛", 3, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.COMMON, 1, 6, false, Faction.DESSERT_UNION);
        allCards.put(cheesecakeGuard.getName(), cheesecakeGuard);
        allCharacters.add(cheesecakeGuard);
        
        CharacterCard fruitCakeArcher = new CharacterCard(
            "水果蛋糕射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(fruitCakeArcher.getName(), fruitCakeArcher);
        allCharacters.add(fruitCakeArcher);
        
        CharacterCard creamCakePriest = new CharacterCard(
            "奶油蛋糕祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(creamCakePriest.getName(), creamCakePriest);
        allCharacters.add(creamCakePriest);
        
        CharacterCard layeredCakeWarrior = new CharacterCard(
            "千層蛋糕戰士", 4, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.RARE, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(layeredCakeWarrior.getName(), layeredCakeWarrior);
        allCharacters.add(layeredCakeWarrior);
        
        CharacterCard redVelvetMage = new CharacterCard(
            "紅絲絨蛋糕法師", 3, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(redVelvetMage.getName(), redVelvetMage);
        allCharacters.add(redVelvetMage);
        
        CharacterCard tiramisuGuard = new CharacterCard(
            "提拉米蘇守衛", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(tiramisuGuard.getName(), tiramisuGuard);
        allCharacters.add(tiramisuGuard);
        
        CharacterCard blackForestArcher = new CharacterCard(
            "黑森林蛋糕射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(blackForestArcher.getName(), blackForestArcher);
        allCharacters.add(blackForestArcher);
        
        CharacterCard angelCakePriest = new CharacterCard(
            "天使蛋糕祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(angelCakePriest.getName(), angelCakePriest);
        allCharacters.add(angelCakePriest);

        // 餅乾類角色卡
        CharacterCard chocolateChipWarrior = new CharacterCard(
            "巧克力豆餅乾戰士", 2, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(chocolateChipWarrior.getName(), chocolateChipWarrior);
        allCharacters.add(chocolateChipWarrior);
        
        CharacterCard oatmealGuard = new CharacterCard(
            "燕麥餅乾守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(oatmealGuard.getName(), oatmealGuard);
        allCharacters.add(oatmealGuard);
        
        CharacterCard gingerbreadArcher = new CharacterCard(
            "薑餅射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 2, true, Faction.DESSERT_UNION);
        allCards.put(gingerbreadArcher.getName(), gingerbreadArcher);
        allCharacters.add(gingerbreadArcher);
        
        CharacterCard fortuneCookieMage = new CharacterCard(
            "幸運餅乾法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：抽一張牌。", 
            Rarity.RARE, 3, 3, false, Faction.DESSERT_UNION);
        allCards.put(fortuneCookieMage.getName(), fortuneCookieMage);
        allCharacters.add(fortuneCookieMage);
        
        CharacterCard butterCookiePriest = new CharacterCard(
            "奶油餅乾祭司", 3, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(butterCookiePriest.getName(), butterCookiePriest);
        allCharacters.add(butterCookiePriest);
        
        CharacterCard almondCookieWarrior = new CharacterCard(
            "杏仁餅乾戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(almondCookieWarrior.getName(), almondCookieWarrior);
        allCharacters.add(almondCookieWarrior);
        
        CharacterCard coconutCookieMage = new CharacterCard(
            "椰子餅乾法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(coconutCookieMage.getName(), coconutCookieMage);
        allCharacters.add(coconutCookieMage);
        
        CharacterCard peanutCookieGuard = new CharacterCard(
            "花生餅乾守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(peanutCookieGuard.getName(), peanutCookieGuard);
        allCharacters.add(peanutCookieGuard);
        
        CharacterCard raisinCookieArcher = new CharacterCard(
            "葡萄乾餅乾射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 2, true, Faction.DESSERT_UNION);
        allCards.put(raisinCookieArcher.getName(), raisinCookieArcher);
        allCharacters.add(raisinCookieArcher);
        
        CharacterCard macaronPriest = new CharacterCard(
            "馬卡龍祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(macaronPriest.getName(), macaronPriest);
        allCharacters.add(macaronPriest);

        // 冰淇淋類角色卡
        CharacterCard vanillaWarrior = new CharacterCard(
            "香草冰淇淋戰士", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(vanillaWarrior.getName(), vanillaWarrior);
        allCharacters.add(vanillaWarrior);
        
        CharacterCard chocolateGuard = new CharacterCard(
            "巧克力冰淇淋守衛", 4, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(chocolateGuard.getName(), chocolateGuard);
        allCharacters.add(chocolateGuard);
        
        CharacterCard iceCreamStrawberryArcher = new CharacterCard(
            "草莓冰淇淋射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(iceCreamStrawberryArcher.getName(), iceCreamStrawberryArcher);
        allCharacters.add(iceCreamStrawberryArcher);
        
        CharacterCard mintMage = new CharacterCard(
            "薄荷冰淇淋法師", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個敵方角色無法攻擊。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(mintMage.getName(), mintMage);
        allCharacters.add(mintMage);
        
        CharacterCard caramelPriest = new CharacterCard(
            "焦糖冰淇淋祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(caramelPriest.getName(), caramelPriest);
        allCharacters.add(caramelPriest);
        
        CharacterCard blueberryWarrior = new CharacterCard(
            "藍莓冰淇淋戰士", 3, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(blueberryWarrior.getName(), blueberryWarrior);
        allCharacters.add(blueberryWarrior);
        
        CharacterCard coffeeMage = new CharacterCard(
            "咖啡冰淇淋法師", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(coffeeMage.getName(), coffeeMage);
        allCharacters.add(coffeeMage);
        
        CharacterCard pistachioGuard = new CharacterCard(
            "開心果冰淇淋守衛", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(pistachioGuard.getName(), pistachioGuard);
        allCharacters.add(pistachioGuard);
        
        CharacterCard mangoArcher = new CharacterCard(
            "芒果冰淇淋射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(mangoArcher.getName(), mangoArcher);
        allCharacters.add(mangoArcher);
        
        CharacterCard rainbowPriest = new CharacterCard(
            "彩虹冰淇淋祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(rainbowPriest.getName(), rainbowPriest);
        allCharacters.add(rainbowPriest);

        // 布丁類角色卡
        CharacterCard puddingCaramelWarrior = new CharacterCard(
            "焦糖布丁戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(puddingCaramelWarrior.getName(), puddingCaramelWarrior);
        allCharacters.add(puddingCaramelWarrior);
        
        CharacterCard puddingChocolateGuard = new CharacterCard(
            "巧克力布丁守衛", 4, "【糖爆】：攻擊時造成2點額外傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(puddingChocolateGuard.getName(), puddingChocolateGuard);
        allCharacters.add(puddingChocolateGuard);
        
        CharacterCard puddingStrawberryArcher = new CharacterCard(
            "草莓布丁射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(puddingStrawberryArcher.getName(), puddingStrawberryArcher);
        allCharacters.add(puddingStrawberryArcher);
        
        CharacterCard vanillaMage = new CharacterCard(
            "香草布丁法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(vanillaMage.getName(), vanillaMage);
        allCharacters.add(vanillaMage);
        
        CharacterCard matchaPriest = new CharacterCard(
            "抹茶布丁祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(matchaPriest.getName(), matchaPriest);
        allCharacters.add(matchaPriest);
        
        CharacterCard coffeeWarrior = new CharacterCard(
            "咖啡布丁戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(coffeeWarrior.getName(), coffeeWarrior);
        allCharacters.add(coffeeWarrior);
        
        CharacterCard mangoMage = new CharacterCard(
            "芒果布丁法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(mangoMage.getName(), mangoMage);
        allCharacters.add(mangoMage);
        
        CharacterCard coconutGuard = new CharacterCard(
            "椰子布丁守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(coconutGuard.getName(), coconutGuard);
        allCharacters.add(coconutGuard);
        
        CharacterCard strawberryArcher = new CharacterCard(
            "草莓布丁射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(strawberryArcher.getName(), strawberryArcher);
        allCharacters.add(strawberryArcher);
        
        CharacterCard taroPriest = new CharacterCard(
            "芋頭布丁祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(taroPriest.getName(), taroPriest);
        allCharacters.add(taroPriest);

        // 巧克力類角色卡
        CharacterCard darkWarrior = new CharacterCard(
            "黑巧克力戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 3, 4, true, Faction.DESSERT_UNION);
        allCards.put(darkWarrior.getName(), darkWarrior);
        allCharacters.add(darkWarrior);
        
        CharacterCard milkGuard = new CharacterCard(
            "牛奶巧克力守衛", 4, "【糖爆】：攻擊時造成2點額外傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(milkGuard.getName(), milkGuard);
        allCharacters.add(milkGuard);
        
        CharacterCard whiteArcher = new CharacterCard(
            "白巧克力射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(whiteArcher.getName(), whiteArcher);
        allCharacters.add(whiteArcher);
        
        CharacterCard hazelnutMage = new CharacterCard(
            "榛果巧克力法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+2/+0。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(hazelnutMage.getName(), hazelnutMage);
        allCharacters.add(hazelnutMage);
        
        CharacterCard chocolateCaramelPriest = new CharacterCard(
            "焦糖巧克力祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(chocolateCaramelPriest.getName(), chocolateCaramelPriest);
        allCharacters.add(chocolateCaramelPriest);
        
        CharacterCard mintWarrior = new CharacterCard(
            "薄荷巧克力戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(mintWarrior.getName(), mintWarrior);
        allCharacters.add(mintWarrior);
        
        CharacterCard orangeMage = new CharacterCard(
            "橙味巧克力法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(orangeMage.getName(), orangeMage);
        allCharacters.add(orangeMage);
        
        CharacterCard almondGuard = new CharacterCard(
            "杏仁巧克力守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(almondGuard.getName(), almondGuard);
        allCharacters.add(almondGuard);
        
        CharacterCard coffeeArcher = new CharacterCard(
            "咖啡巧克力射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(coffeeArcher.getName(), coffeeArcher);
        allCharacters.add(coffeeArcher);
        
        CharacterCard raspberryPriest = new CharacterCard(
            "覆盆子巧克力祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(raspberryPriest.getName(), raspberryPriest);
        allCharacters.add(raspberryPriest);

        // 和菓子類角色卡
        CharacterCard mochiWarrior = new CharacterCard(
            "麻糬戰士", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(mochiWarrior.getName(), mochiWarrior);
        allCharacters.add(mochiWarrior);
        
        CharacterCard dangoGuard = new CharacterCard(
            "團子守衛", 4, "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(dangoGuard.getName(), dangoGuard);
        allCharacters.add(dangoGuard);
        
        CharacterCard manjuArcher = new CharacterCard(
            "饅頭射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(manjuArcher.getName(), manjuArcher);
        allCharacters.add(manjuArcher);
        
        CharacterCard yokanMage = new CharacterCard(
            "羊羹法師", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(yokanMage.getName(), yokanMage);
        allCharacters.add(yokanMage);
        
        CharacterCard daifukuPriest = new CharacterCard(
            "大福祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(daifukuPriest.getName(), daifukuPriest);
        allCharacters.add(daifukuPriest);
        
        CharacterCard dorayakiWarrior = new CharacterCard(
            "銅鑼燒戰士", 3, "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(dorayakiWarrior.getName(), dorayakiWarrior);
        allCharacters.add(dorayakiWarrior);
        
        CharacterCard taiyakiMage = new CharacterCard(
            "鯛魚燒法師", 4, "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(taiyakiMage.getName(), taiyakiMage);
        allCharacters.add(taiyakiMage);
        
        CharacterCard wagashiGuard = new CharacterCard(
            "和菓子守衛", 3, "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(wagashiGuard.getName(), wagashiGuard);
        allCharacters.add(wagashiGuard);
        
        CharacterCard monakaArcher = new CharacterCard(
            "最中射手", 2, "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(monakaArcher.getName(), monakaArcher);
        allCharacters.add(monakaArcher);
        
        CharacterCard namagashiPriest = new CharacterCard(
            "生菓子祭司", 5, "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(namagashiPriest.getName(), namagashiPriest);
        allCharacters.add(namagashiPriest);

        // 派類角色卡
        CharacterCard pieAppleWarrior = new CharacterCard(
            "蘋果派戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(pieAppleWarrior.getName(), pieAppleWarrior);
        allCharacters.add(pieAppleWarrior);
        
        CharacterCard pumpkinGuard = new CharacterCard(
            "南瓜派守衛", 4, "【糖爆】：攻擊時造成2點額外傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(pumpkinGuard.getName(), pumpkinGuard);
        allCharacters.add(pumpkinGuard);
        
        CharacterCard pieCherryArcher = new CharacterCard(
            "櫻桃派射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieCherryArcher.getName(), pieCherryArcher);
        allCharacters.add(pieCherryArcher);
        
        CharacterCard chocolateMage = new CharacterCard(
            "巧克力派法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(chocolateMage.getName(), chocolateMage);
        allCharacters.add(chocolateMage);
        
        CharacterCard lemonPriest = new CharacterCard(
            "檸檬派祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(lemonPriest.getName(), lemonPriest);
        allCharacters.add(lemonPriest);
        
        CharacterCard pieBlueberryWarrior = new CharacterCard(
            "藍莓派戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieBlueberryWarrior.getName(), pieBlueberryWarrior);
        allCharacters.add(pieBlueberryWarrior);
        
        CharacterCard pecanMage = new CharacterCard(
            "胡桃派法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(pecanMage.getName(), pecanMage);
        allCharacters.add(pecanMage);
        
        CharacterCard keyLimeGuard = new CharacterCard(
            "萊姆派守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(keyLimeGuard.getName(), keyLimeGuard);
        allCharacters.add(keyLimeGuard);
        
        CharacterCard pieStrawberryArcher = new CharacterCard(
            "草莓派射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(pieStrawberryArcher.getName(), pieStrawberryArcher);
        allCharacters.add(pieStrawberryArcher);
        
        CharacterCard bananaPriest = new CharacterCard(
            "香蕉派祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(bananaPriest.getName(), bananaPriest);
        allCharacters.add(bananaPriest);

        // 糖果類角色卡
        CharacterCard lollipopWarrior = new CharacterCard(
            "棒棒糖戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 4, true, Faction.DESSERT_UNION);
        allCards.put(lollipopWarrior.getName(), lollipopWarrior);
        allCharacters.add(lollipopWarrior);
        
        CharacterCard gummyGuard = new CharacterCard(
            "軟糖守衛", 4, "【糖爆】：攻擊時造成2點額外傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 2, 6, false, Faction.DESSERT_UNION);
        allCards.put(gummyGuard.getName(), gummyGuard);
        allCharacters.add(gummyGuard);
        
        CharacterCard hardCandyArcher = new CharacterCard(
            "硬糖射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(hardCandyArcher.getName(), hardCandyArcher);
        allCharacters.add(hardCandyArcher);
        
        CharacterCard jellyBeanMage = new CharacterCard(
            "雷根糖法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(jellyBeanMage.getName(), jellyBeanMage);
        allCharacters.add(jellyBeanMage);
        
        CharacterCard candyCaramelPriest = new CharacterCard(
            "焦糖祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(candyCaramelPriest.getName(), candyCaramelPriest);
        allCharacters.add(candyCaramelPriest);
        
        CharacterCard chocolateWarrior = new CharacterCard(
            "巧克力戰士", 3, "【糖爆】：攻擊時造成2點額外傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 3, true, Faction.DESSERT_UNION);
        allCards.put(chocolateWarrior.getName(), chocolateWarrior);
        allCharacters.add(chocolateWarrior);
        
        CharacterCard marshmallowMage = new CharacterCard(
            "棉花糖法師", 4, "【糖爆】：攻擊時造成2點額外傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(marshmallowMage.getName(), marshmallowMage);
        allCharacters.add(marshmallowMage);
        
        CharacterCard toffeeGuard = new CharacterCard(
            "太妃糖守衛", 3, "【糖爆】：攻擊時造成2點額外傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 1, 5, false, Faction.DESSERT_UNION);
        allCards.put(toffeeGuard.getName(), toffeeGuard);
        allCharacters.add(toffeeGuard);
        
        CharacterCard licoriceArcher = new CharacterCard(
            "甘草糖射手", 2, "【糖爆】：攻擊時造成2點額外傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(licoriceArcher.getName(), licoriceArcher);
        allCharacters.add(licoriceArcher);
        
        CharacterCard rockCandyPriest = new CharacterCard(
            "冰糖祭司", 5, "【糖爆】：攻擊時造成2點額外傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 5, false, Faction.DESSERT_UNION);
        allCards.put(rockCandyPriest.getName(), rockCandyPriest);
        allCharacters.add(rockCandyPriest);

        // 法術卡
        // 糖霜相關法術
        SpellCard sugarFrosting = new SpellCard(
            "糖霜覆蓋", 2, "使一個友方角色獲得【糖霜】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarFrosting.getName(), sugarFrosting);
        allSpells.add(sugarFrosting);
        
        SpellCard frostShield = new SpellCard(
            "霜糖護盾", 3, "使一個友方角色獲得【糖霜】效果和+0/+2。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostShield.getName(), frostShield);
        allSpells.add(frostShield);
        
        SpellCard frostBarrier = new SpellCard(
            "霜糖屏障", 4, "使所有友方角色獲得【糖霜】效果。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostBarrier.getName(), frostBarrier);
        allSpells.add(frostBarrier);

        // 糖爆相關法術
        SpellCard sugarBurst = new SpellCard(
            "糖爆衝擊", 3, "對一個敵方角色造成3點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.DESSERT_UNION);
        allCards.put(sugarBurst.getName(), sugarBurst);
        allSpells.add(sugarBurst);
        
        SpellCard sugarExplosion = new SpellCard(
            "糖爆轟炸", 5, "對所有敵方角色造成2點傷害。", 
            Rarity.RARE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sugarExplosion.getName(), sugarExplosion);
        allSpells.add(sugarExplosion);
        
        SpellCard sugarStorm = new SpellCard(
            "糖爆風暴", 6, "對所有敵方角色造成3點傷害。", 
            Rarity.EPIC, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(sugarStorm.getName(), sugarStorm);
        allSpells.add(sugarStorm);

        // 甜點製作法術
        SpellCard cakeSummon = new SpellCard(
            "蛋糕召喚", 3, "召喚一個2/2的蛋糕小兵。", 
            Rarity.COMMON, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(cakeSummon.getName(), cakeSummon);
        allSpells.add(cakeSummon);
        
        SpellCard cookieArmy = new SpellCard(
            "餅乾大軍", 5, "召喚三個1/1的餅乾小兵。", 
            Rarity.RARE, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(cookieArmy.getName(), cookieArmy);
        allSpells.add(cookieArmy);
        
        SpellCard dessertBuffetSpell = new SpellCard(
            "甜點自助餐", 7, "召喚一個3/3的蛋糕、一個2/2的餅乾和一個1/1的糖果。", 
            Rarity.EPIC, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(dessertBuffetSpell.getName(), dessertBuffetSpell);
        allSpells.add(dessertBuffetSpell);

        // 甜點效果法術
        SpellCard sweetHealing = new SpellCard(
            "甜蜜治療", 2, "為一個友方角色恢復3點生命值。", 
            Rarity.COMMON, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(sweetHealing.getName(), sweetHealing);
        allSpells.add(sweetHealing);
        
        SpellCard sweetBlessing = new SpellCard(
            "甜蜜祝福", 4, "使所有友方角色獲得+1/+1。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sweetBlessing.getName(), sweetBlessing);
        allSpells.add(sweetBlessing);
        
        SpellCard sweetCurse = new SpellCard(
            "甜蜜詛咒", 3, "使一個敵方角色獲得-1/-1。", 
            Rarity.COMMON, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(sweetCurse.getName(), sweetCurse);
        allSpells.add(sweetCurse);

        // 特殊效果法術
        SpellCard dessertDraw = new SpellCard(
            "甜點抽牌", 2, "抽一張牌。", 
            Rarity.COMMON, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertDraw.getName(), dessertDraw);
        allSpells.add(dessertDraw);
        
        SpellCard dessertRitual = new SpellCard(
            "甜點儀式", 4, "抽兩張牌，並使一個友方角色獲得+1/+1。", 
            Rarity.RARE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertRitual.getName(), dessertRitual);
        allSpells.add(dessertRitual);
        
        SpellCard dessertMastery = new SpellCard(
            "甜點大師", 6, "抽三張牌，並使所有友方角色獲得+1/+1。", 
            Rarity.EPIC, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertMastery.getName(), dessertMastery);
        allSpells.add(dessertMastery);

        // 場地卡
        // 甜點店相關
        FieldCard cakeShop = FieldCard.createEnvironmentField(
            "蛋糕店", 3, "每回合開始時，使一個友方角色獲得【糖霜】效果。", 
            Rarity.COMMON, 2, Faction.DESSERT_UNION);
        allCards.put(cakeShop.getName(), cakeShop);
        allFieldCards.add(cakeShop);
        
        FieldCard cookieFactory = FieldCard.createEnvironmentField(
            "餅乾工廠", 4, "每回合結束時，召喚一個1/1的餅乾小兵。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(cookieFactory.getName(), cookieFactory);
        allFieldCards.add(cookieFactory);
        
        FieldCard iceCreamParlor = FieldCard.createEnvironmentField(
            "冰淇淋店", 3, "每當你使用一張法術卡時，使一個友方角色獲得+0/+1。", 
            Rarity.COMMON, 2, Faction.DESSERT_UNION);
        allCards.put(iceCreamParlor.getName(), iceCreamParlor);
        allFieldCards.add(iceCreamParlor);

        // 甜點工坊相關
        FieldCard dessertKitchen = FieldCard.createEnvironmentField(
            "甜點廚房", 5, "友方角色獲得+1/+1。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(dessertKitchen.getName(), dessertKitchen);
        allFieldCards.add(dessertKitchen);
        
        FieldCard sugarMill = FieldCard.createEnvironmentField(
            "糖廠", 3, "每回合開始時，隨機使一個友方角色獲得+2/+0直到回合結束。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(sugarMill.getName(), sugarMill);
        allFieldCards.add(sugarMill);
        
        FieldCard dessertMarket = FieldCard.createEnvironmentField(
            "甜點市集", 3, "每回合開始時，有25%機率抽一張牌。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(dessertMarket.getName(), dessertMarket);
        allFieldCards.add(dessertMarket);

        // 特殊場地
        FieldCard dessertBuffetField = FieldCard.createEnvironmentField(
            "甜點自助餐", 5, "每回合開始時，隨機使一個友方角色獲得【糖霜】效果。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(dessertBuffetField.getName(), dessertBuffetField);
        allFieldCards.add(dessertBuffetField);
        
        FieldCard dessertGarden = FieldCard.createEnvironmentField(
            "甜點花園", 4, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(dessertGarden.getName(), dessertGarden);
        allFieldCards.add(dessertGarden);
        
        FieldCard dessertWorkshop = FieldCard.createEnvironmentField(
            "甜點工作坊", 3, "每當你打出一個角色卡時，使其獲得+0/+2。", 
            Rarity.COMMON, 3, Faction.DESSERT_UNION);
        allCards.put(dessertWorkshop.getName(), dessertWorkshop);
        allFieldCards.add(dessertWorkshop);
        
        FieldCard dessertFountain = FieldCard.createEnvironmentField(
            "甜點噴泉", 4, "每回合開始時，使一個友方角色獲得【糖爆】效果直到回合結束。", 
            Rarity.EPIC, 3, Faction.DESSERT_UNION);
        allCards.put(dessertFountain.getName(), dessertFountain);
        allFieldCards.add(dessertFountain);
    }
    
    @Override
    public String getFactionName() {
        return "甜點聯盟";
    }
} 