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
public class DessertUnionInitializer extends AbstractCardInitializer {
    
    @Override
    public String getFactionName() {
        return "甜點聯盟";
    }
    
    @Override
    protected void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 蛋糕類角色卡
        CharacterCard spongeCakeWarrior = createCharacterCard(
            "海綿蛋糕吸收大師 (Sponge Cake Absorber)", 3, 
            "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 5, Faction.DESSERT_UNION, 8);
        addToCollection(spongeCakeWarrior, allCards, allCharacters);
        
        CharacterCard chocolateCakeMage = createCharacterCard(
            "巧克力蛋糕甜點魔導師 (Chocolate Cake Archmage)", 4, 
            "【糖霜】：抵擋一次傷害。【開胃】：為一個友方角色恢復2點生命值。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.DESSERT_UNION, 11);
        addToCollection(chocolateCakeMage, allCards, allCharacters);
        
        CharacterCard cheesecakeGuard = createCharacterCard(
            "起司蛋糕濃郁防衛官 (Cheesecake Defender)", 3, 
            "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 6, Faction.DESSERT_UNION, 10);
        addToCollection(cheesecakeGuard, allCards, allCharacters);
        
        CharacterCard fruitCakeArcher = createCharacterCard(
            "水果蛋糕彩虹狙擊手 (Fruit Cake Sniper)", 2, 
            "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.DESSERT_UNION, 7);
        addToCollection(fruitCakeArcher, allCards, allCharacters);
        
        CharacterCard creamCakePriest = createCharacterCard(
            "奶油蛋糕療癒牧師 (Cream Cake Healer)", 5, 
            "【糖霜】：抵擋一次傷害。【回味】：死亡時為所有友方角色恢復1點生命值。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.DESSERT_UNION, 12);
        addToCollection(creamCakePriest, allCards, allCharacters);
        
        CharacterCard layeredCakeWarrior = createCharacterCard(
            "千層蛋糕疊層劍士 (Layered Cake Bladesman)", 4, 
            "【糖霜】：抵擋一次傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.DESSERT_UNION, 11);
        addToCollection(layeredCakeWarrior, allCards, allCharacters);
        
        CharacterCard redVelvetMage = createCharacterCard(
            "紅絲絨蛋糕魔法調色師 (Red Velvet Colorist)", 3, 
            "【糖霜】：抵擋一次傷害。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.CASUAL_BITES, 2, 4, Faction.DESSERT_UNION, 9);
        addToCollection(redVelvetMage, allCards, allCharacters);
        
        CharacterCard tiramisuGuard = createCharacterCard(
            "提拉米蘇咖啡守護者 (Tiramisu Coffee Guardian)", 3, 
            "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, Faction.DESSERT_UNION, 9);
        addToCollection(tiramisuGuard, allCards, allCharacters);
        
        CharacterCard blackForestArcher = createCharacterCard(
            "黑森林蛋糕櫻桃獵人 (Black Forest Cherry Hunter)", 2, 
            "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.DESSERT_UNION, 7);
        addToCollection(blackForestArcher, allCards, allCharacters);
        
        CharacterCard angelCakePriest = createCharacterCard(
            "天使蛋糕祈福使者 (Angel Cake Blessed Envoy)", 5, 
            "【糖霜】：抵擋一次傷害。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.DESSERT_UNION, 12);
        addToCollection(angelCakePriest, allCards, allCharacters);

        // 餅乾類角色卡
        CharacterCard chocolateChipWarrior = createCharacterCard(
            "巧克力豆餅乾碎片突擊兵 (Chocolate Chip Assault Trooper)", 2, 
            "【糖爆】：對所有敵方角色造成1點傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.DESSERT_UNION, 7);
        addToCollection(chocolateChipWarrior, allCards, allCharacters);
        
        CharacterCard oatmealGuard = createCharacterCard(
            "燕麥餅乾健康守門員 (Oatmeal Nutrition Goalkeeper)", 3, 
            "【糖爆】：使自身獲得+0/+2直到回合結束。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.CASUAL_BITES, 1, 5, Faction.DESSERT_UNION, 9);
        addToCollection(oatmealGuard, allCards, allCharacters);
        
        CharacterCard gingerbreadArcher = createCharacterCard(
            "薑餅人奔跑弓箭手 (Gingerbread Sprinting Archer)", 2, 
            "【糖爆】：使敵方一個角色無法攻擊直到回合結束。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.DESSERT_UNION, 6);
        addToCollection(gingerbreadArcher, allCards, allCharacters);
        
        CharacterCard fortuneCookieMage = createCharacterCard(
            "幸運餅乾預言賢者 (Fortune Cookie Oracle)", 4, 
            "【糖爆】：抽一張牌。【開胃】：抽一張牌。", 
            Rarity.GOURMET_DELIGHT, 3, 3, Faction.DESSERT_UNION, 10);
        addToCollection(fortuneCookieMage, allCards, allCharacters);
        
        CharacterCard butterCookiePriest = createCharacterCard(
            "奶油餅乾甜香治癒師 (Butter Cookie Sweetscent Healer)", 3, 
            "【糖爆】：為一個友方角色恢復2點生命值。【回味】：死亡時使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 2, 4, Faction.DESSERT_UNION, 9);
        addToCollection(butterCookiePriest, allCards, allCharacters);
        
        CharacterCard almondCookieWarrior = createCharacterCard(
            "杏仁餅乾脆片刀客 (Almond Cookie Crisp Blader)", 3, 
            "【糖爆】：使自身獲得+2/+0直到回合結束。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.CASUAL_BITES, 3, 3, Faction.DESSERT_UNION, 9);
        addToCollection(almondCookieWarrior, allCards, allCharacters);
        
        CharacterCard coconutCookieMage = createCharacterCard(
            "椰子餅乾熱帶法術師 (Coconut Cookie Tropical Spellcaster)", 4, 
            "【糖爆】：使一個友方角色獲得【糖霜】效果。【開胃】：使一個友方角色獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.DESSERT_UNION, 11);
        addToCollection(coconutCookieMage, allCards, allCharacters);
        
        CharacterCard peanutCookieGuard = createCharacterCard(
            "花生餅乾堅硬盾衛 (Peanut Cookie Hard Shield)", 3, 
            "【糖爆】：對一個敵方角色造成1點傷害並使其攻擊力減少1。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 1, 5, Faction.DESSERT_UNION, 9);
        addToCollection(peanutCookieGuard, allCards, allCharacters);
        
        CharacterCard raisinCookieArcher = createCharacterCard(
            "葡萄乾餅乾精準射擊士 (Raisin Cookie Precision Shooter)", 2, 
            "【糖爆】：對敵方生命值最低的角色造成2點傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 2, Faction.DESSERT_UNION, 6);
        addToCollection(raisinCookieArcher, allCards, allCharacters);
        
        CharacterCard macaronPriest = createCharacterCard(
            "馬卡龍繽紛祭祀官 (Macaron Rainbow Celebrant)", 5, 
            "【糖爆】：為所有友方角色恢復1點生命值。【回味】：死亡時使一個友方角色獲得+2/+2。", 
            Rarity.GOURMET_DELIGHT, 2, 5, Faction.DESSERT_UNION, 12);
        addToCollection(macaronPriest, allCards, allCharacters);

        // 冰淇淋類角色卡
        CharacterCard vanillaWarrior = createCharacterCard(
            "香草冰淇淋清涼劍客 (Vanilla Ice Cream Frosty Swordsman)", 3, 
            "【糖霜】：抵擋一次傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.CASUAL_BITES, 2, 4, Faction.DESSERT_UNION, 9);
        addToCollection(vanillaWarrior, allCards, allCharacters);
        
        CharacterCard chocolateGuard = createCharacterCard(
            "巧克力冰淇淋融化護衛 (Chocolate Ice Cream Melting Guardian)", 4, 
            "【糖霜】：抵擋一次傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.GOURMET_DELIGHT, 2, 6, Faction.DESSERT_UNION, 12);
        addToCollection(chocolateGuard, allCards, allCharacters);
        
        CharacterCard strawberryArcher = createCharacterCard(
            "草莓冰淇淋凍感獵手 (Strawberry Ice Cream Frost Hunter)", 2, 
            "【糖霜】：抵擋一次傷害。【彈牙】：每回合可攻擊2次。", 
            Rarity.CASUAL_BITES, 2, 3, Faction.DESSERT_UNION, 7);
        addToCollection(strawberryArcher, allCards, allCharacters);
        
        CharacterCard mintMage = createCharacterCard(
            "薄荷冰淇淋涼爽巫師 (Mint Ice Cream Chilling Wizard)", 4, 
            "【糖霜】：抵擋一次傷害。【開胃】：使一個敵方角色無法攻擊。", 
            Rarity.GOURMET_DELIGHT, 3, 4, Faction.DESSERT_UNION, 11);
        addToCollection(mintMage, allCards, allCharacters);
    }
    
    @Override
    protected void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 甜點聯盟法術卡
        SpellCard sugarRush = createSpellCard(
            "糖分衝刺 (Sugar Rush)", 2, 
            "使一個友方角色獲得+2/+0並可額外攻擊一次。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.DESSERT_UNION);
        addToCollection(sugarRush, allCards, allSpells);
        
        SpellCard sweetHeal = createSpellCard(
            "甜蜜療癒 (Sweet Healing)", 1, 
            "為一個角色恢復4點生命值。", 
            Rarity.CASUAL_BITES, SpellType.HEALING, Faction.DESSERT_UNION);
        addToCollection(sweetHeal, allCards, allSpells);
        
        SpellCard frostingShield = createSpellCard(
            "糖霜護盾 (Frosting Shield)", 2, 
            "使一個友方角色獲得【糖霜】效果。", 
            Rarity.CASUAL_BITES, SpellType.BUFF, Faction.DESSERT_UNION);
        addToCollection(frostingShield, allCards, allSpells);
        
        SpellCard candyBomb = createSpellCard(
            "糖果炸彈 (Candy Bomb)", 3, 
            "對所有敵方角色造成2點傷害。", 
            Rarity.GOURMET_DELIGHT, SpellType.AOE, Faction.DESSERT_UNION);
        addToCollection(candyBomb, allCards, allSpells);
        
        SpellCard chocolateRain = createSpellCard(
            "巧克力雨 (Chocolate Rain)", 4, 
            "為所有友方角色恢復2點生命值並給予+1/+1。", 
            Rarity.GOURMET_DELIGHT, SpellType.BUFF, Faction.DESSERT_UNION);
        addToCollection(chocolateRain, allCards, allSpells);
    }
    
    @Override
    protected void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 甜點聯盟場地卡
        FieldCard candyLand = createFieldCard(
            "糖果樂園 (Candy Land)", 3, 
            "友方角色在出場時獲得+1/+1。", 
            Rarity.GOURMET_DELIGHT, Faction.DESSERT_UNION);
        addToCollection(candyLand, allCards, allFieldCards);
        
        FieldCard bakery = createFieldCard(
            "夢幻烘焙坊 (Dream Bakery)", 2, 
            "每回合開始時，為一個隨機友方角色恢復1點生命值。", 
            Rarity.CASUAL_BITES, Faction.DESSERT_UNION);
        addToCollection(bakery, allCards, allFieldCards);
    }
    
    @Override
    protected void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 甜點聯盟城堡卡
        CastleCard sugarPalace = createCastleCard(
            "糖霜宮殿 (Sugar Palace)", 0, 
            "【甜點聯盟效果】：己方角色在受到傷害時有50%機率獲得【糖霜】效果。", 
            Rarity.ULTIMATE_TASTE, Faction.DESSERT_UNION, 20);
        addToCollection(sugarPalace, allCards, allCastles);
    }
} 