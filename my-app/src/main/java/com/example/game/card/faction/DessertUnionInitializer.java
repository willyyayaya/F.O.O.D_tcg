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
        // 角色卡 - 基礎角色
        CharacterCard cupcakeSorcerer = new CharacterCard(
            "杯子蛋糕巫師", 3, "【開胃】：使一個友方角色獲得+1/+1。【糖霜】：每回合結束時，場上每有一個甜點聯盟單位，獲得+0/+1。", 
            Rarity.COMMON, 2, 3, 3, false, Faction.DESSERT_UNION);
        allCards.put(cupcakeSorcerer.getName(), cupcakeSorcerer);
        allCharacters.add(cupcakeSorcerer);
        
        CharacterCard cakeEmpress = new CharacterCard(
            "蛋糕女皇", 6, "【開胃】：使所有友方角色獲得+0/+2。【回味】：當你使用一張費用大於4的卡牌時，抽一張牌。", 
            Rarity.EPIC, 4, 3, 6, false, Faction.DESSERT_UNION);
        allCards.put(cakeEmpress.getName(), cakeEmpress);
        allCharacters.add(cakeEmpress);
        
        CharacterCard iceCreamDefender = new CharacterCard(
            "冰淇淋守衛", 4, "【酥脆(2)】：減免2點傷害。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.RARE, 3, 3, 5, false, Faction.DESSERT_UNION);
        allCards.put(iceCreamDefender.getName(), iceCreamDefender);
        allCharacters.add(iceCreamDefender);
        
        CharacterCard cookieArcher = new CharacterCard(
            "餅乾弓手", 2, "【酥脆(1)】：減免1點傷害。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.DESSERT_UNION);
        allCards.put(cookieArcher.getName(), cookieArcher);
        allCharacters.add(cookieArcher);
        
        CharacterCard mousseMage = new CharacterCard(
            "慕斯魔法師", 5, "【開胃】：為一個友方角色恢復3點生命值。【回味】：死亡時，使一個友方角色獲得+1/+1。", 
            Rarity.RARE, 3, 3, 5, false, Faction.DESSERT_UNION);
        allCards.put(mousseMage.getName(), mousseMage);
        allCharacters.add(mousseMage);
        
        // 較高費用角色卡
        CharacterCard sweetEmperor = new CharacterCard(
            "甜點皇帝", 8, "【開胃】：使所有友方角色獲得+1/+1。【彈牙】：每回合可攻擊2次。【酥脆(3)】：減免3點傷害。", 
            Rarity.LEGENDARY, 5, 5, 8, false, Faction.DESSERT_UNION);
        allCards.put(sweetEmperor.getName(), sweetEmperor);
        allCharacters.add(sweetEmperor);
        
        CharacterCard candyGuardian = new CharacterCard(
            "糖果守衛", 3, "【擺盤】：敵人必須優先攻擊這個單位。【糖霜】：每回合結束時，獲得+0/+1。", 
            Rarity.COMMON, 2, 4, 4, false, Faction.DESSERT_UNION);
        allCards.put(candyGuardian.getName(), candyGuardian);
        allCharacters.add(candyGuardian);
        
        CharacterCard puddingProtector = new CharacterCard(
            "布丁保衛者", 4, "【開胃】：獲得+0/+3。【回味】：死亡時，為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 3, 4, 6, false, Faction.DESSERT_UNION);
        allCards.put(puddingProtector.getName(), puddingProtector);
        allCharacters.add(puddingProtector);
        
        CharacterCard chocolateWarrior = new CharacterCard(
            "巧克力戰士", 3, "【開胃】：使一個友方角色獲得+1/+0。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.COMMON, 3, 2, 4, true, Faction.DESSERT_UNION);
        allCards.put(chocolateWarrior.getName(), chocolateWarrior);
        allCharacters.add(chocolateWarrior);
        
        CharacterCard tiramisuThief = new CharacterCard(
            "提拉米蘇盜賊", 3, "【開胃】：抽一張牌。【彈牙】：每回合可攻擊2次。", 
            Rarity.RARE, 2, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(tiramisuThief.getName(), tiramisuThief);
        allCharacters.add(tiramisuThief);
        
        // 低費用角色
        CharacterCard jellyDefender = new CharacterCard(
            "果凍防禦者", 2, "【酥脆(1)】：減免1點傷害。【糖霜】：每回合結束時，獲得+0/+1。", 
            Rarity.COMMON, 1, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(jellyDefender.getName(), jellyDefender);
        allCharacters.add(jellyDefender);
        
        CharacterCard macronMaiden = new CharacterCard(
            "馬卡龍少女", 2, "【開胃】：使一個友方角色獲得+1/+1。【回味】：死亡時，抽一張牌。", 
            Rarity.COMMON, 2, 2, 2, false, Faction.DESSERT_UNION);
        allCards.put(macronMaiden.getName(), macronMaiden);
        allCharacters.add(macronMaiden);
        
        CharacterCard donutDuelist = new CharacterCard(
            "甜甜圈決鬥者", 3, "【開胃】：抽一張牌。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(donutDuelist.getName(), donutDuelist);
        allCharacters.add(donutDuelist);
        
        CharacterCard waffleMage = new CharacterCard(
            "鬆餅魔法師", 4, "【開胃】：為所有友方角色恢復1點生命值。【回味】：死亡時，使一個友方角色獲得+2/+2。", 
            Rarity.RARE, 2, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(waffleMage.getName(), waffleMage);
        allCharacters.add(waffleMage);
        
        CharacterCard sugarRushBerserker = new CharacterCard(
            "糖分狂戰士", 4, "【開胃】：獲得+2/+0。【現炸】：可以在出場的回合立即攻擊。", 
            Rarity.RARE, 4, 1, 5, true, Faction.DESSERT_UNION);
        allCards.put(sugarRushBerserker.getName(), sugarRushBerserker);
        allCharacters.add(sugarRushBerserker);
        
        CharacterCard parfaitPrincess = new CharacterCard(
            "芭菲公主", 5, "【開胃】：使所有友方角色獲得+0/+1。【糖霜】：每回合結束時，獲得+1/+1。", 
            Rarity.EPIC, 3, 3, 5, false, Faction.DESSERT_UNION);
        allCards.put(parfaitPrincess.getName(), parfaitPrincess);
        allCharacters.add(parfaitPrincess);
        
        CharacterCard fudgeFighter = new CharacterCard(
            "軟糖鬥士", 2, "【酥脆(1)】：減免1點傷害。【回味】：死亡時，使一個友方角色獲得+1/+1。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(fudgeFighter.getName(), fudgeFighter);
        allCharacters.add(fudgeFighter);
        
        CharacterCard pastryPaladin = new CharacterCard(
            "糕點聖騎士", 6, "【開胃】：使相鄰的友方角色獲得+1/+2。【擺盤】：敵人必須優先攻擊這個單位。", 
            Rarity.EPIC, 4, 5, 7, false, Faction.DESSERT_UNION);
        allCards.put(pastryPaladin.getName(), pastryPaladin);
        allCharacters.add(pastryPaladin);
        
        CharacterCard cheesecakeSorcerer = new CharacterCard(
            "起司蛋糕術士", 3, "【開胃】：為一個友方角色恢復2點生命值。【糖霜】：每回合結束時，獲得+0/+1。", 
            Rarity.RARE, 2, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(cheesecakeSorcerer.getName(), cheesecakeSorcerer);
        allCharacters.add(cheesecakeSorcerer);
        
        CharacterCard lollipopLancer = new CharacterCard(
            "棒棒糖槍兵", 1, "【開胃】：使一個友方角色獲得+1/+0。【彈牙】：每回合可攻擊2次。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.DESSERT_UNION);
        allCards.put(lollipopLancer.getName(), lollipopLancer);
        allCharacters.add(lollipopLancer);
        
        CharacterCard icingEnchanter = new CharacterCard(
            "糖霜魔法師", 4, "【開胃】：使一個友方角色獲得+1/+1。【回味】：死亡時，抽一張牌。", 
            Rarity.EPIC, 3, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(icingEnchanter.getName(), icingEnchanter);
        allCharacters.add(icingEnchanter);
        
        // 最後一個角色
        CharacterCard honeyGuardian = new CharacterCard(
            "蜂蜜守護者", 3, "【糖霜】：每回合結束時，為所有友方角色恢復1點生命值。【酥脆(1)】：減免1點傷害。", 
            Rarity.RARE, 1, 4, 5, false, Faction.DESSERT_UNION);
        allCards.put(honeyGuardian.getName(), honeyGuardian);
        allCharacters.add(honeyGuardian);
        
        // 法術卡
        SpellCard sugarRush = new SpellCard(
            "糖分衝擊", 2, "使一個友方角色獲得+3/+0，持續1回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarRush.getName(), sugarRush);
        allSpells.add(sugarRush);
        
        SpellCard frostingArmor = new SpellCard(
            "糖霜護甲", 3, "使一個友方角色獲得+0/+4和【酥脆(2)】效果。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostingArmor.getName(), frostingArmor);
        allSpells.add(frostingArmor);
        
        SpellCard cakeExplosion = new SpellCard(
            "蛋糕爆炸", 4, "對所有敵方角色造成2點傷害，並使他們下回合無法攻擊。", 
            Rarity.RARE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(cakeExplosion.getName(), cakeExplosion);
        allSpells.add(cakeExplosion);
        
        SpellCard sweetInspiration = new SpellCard(
            "甜蜜靈感", 1, "抽一張牌。如果你控制至少一個甜點聯盟角色，則再抽一張牌。", 
            Rarity.COMMON, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(sweetInspiration.getName(), sweetInspiration);
        allSpells.add(sweetInspiration);
        
        SpellCard royalDessert = new SpellCard(
            "皇家甜點", 6, "使所有友方角色獲得+2/+2。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(royalDessert.getName(), royalDessert);
        allSpells.add(royalDessert);
        
        SpellCard iceCreamBlast = new SpellCard(
            "冰淇淋爆擊", 3, "對一個敵方角色造成3點傷害，並使其下回合無法攻擊。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.DESSERT_UNION);
        allCards.put(iceCreamBlast.getName(), iceCreamBlast);
        allSpells.add(iceCreamBlast);
        
        SpellCard cookieShield = new SpellCard(
            "餅乾護盾", 2, "使一個友方角色獲得+0/+3。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(cookieShield.getName(), cookieShield);
        allSpells.add(cookieShield);
        
        SpellCard sugarCoating = new SpellCard(
            "糖霜覆蓋", 1, "使一個友方角色獲得【糖霜】效果：每回合結束時恢復1點生命值。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarCoating.getName(), sugarCoating);
        allSpells.add(sugarCoating);
        
        SpellCard candyTempest = new SpellCard(
            "糖果風暴", 5, "造成3點傷害到所有敵方角色。", 
            Rarity.EPIC, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(candyTempest.getName(), candyTempest);
        allSpells.add(candyTempest);
        
        SpellCard jellyRebound = new SpellCard(
            "果凍反彈", 3, "使一個友方角色獲得【酥脆(2)】效果並且攻擊時有50%機率+2攻擊力。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(jellyRebound.getName(), jellyRebound);
        allSpells.add(jellyRebound);
        
        SpellCard caramelBond = new SpellCard(
            "焦糖連結", 4, "使兩個友方角色各獲得+1/+2。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(caramelBond.getName(), caramelBond);
        allSpells.add(caramelBond);
        
        SpellCard creamPuff = new SpellCard(
            "奶油泡芙", 2, "為一個友方角色恢復4點生命值。", 
            Rarity.COMMON, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(creamPuff.getName(), creamPuff);
        allSpells.add(creamPuff);
        
        SpellCard chocolateFusion = new SpellCard(
            "巧克力融合", 3, "使一個友方角色獲得+2/+2並且獲得【糖霜】效果。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(chocolateFusion.getName(), chocolateFusion);
        allSpells.add(chocolateFusion);
        
        SpellCard dessertBuffet = new SpellCard(
            "甜點自助餐", 5, "抽3張牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertBuffet.getName(), dessertBuffet);
        allSpells.add(dessertBuffet);
        
        SpellCard honeyTrap = new SpellCard(
            "蜂蜜陷阱", 2, "使一個敵方角色攻擊力-2，持續2回合。", 
            Rarity.COMMON, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(honeyTrap.getName(), honeyTrap);
        allSpells.add(honeyTrap);
        
        SpellCard sugarSurge = new SpellCard(
            "糖分湧動", 4, "使所有友方角色獲得+1/+1。糖霜連動：如果你控制至少一個具有【糖霜】效果的角色，則改為獲得+2/+2。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarSurge.getName(), sugarSurge);
        allSpells.add(sugarSurge);
        
        SpellCard candySummon = new SpellCard(
            "糖果召喚", 3, "召喚兩個1/2的糖果小兵。", 
            Rarity.COMMON, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(candySummon.getName(), candySummon);
        allSpells.add(candySummon);
        
        SpellCard tiramisu = new SpellCard(
            "提拉米蘇", 3, "為一個友方角色恢復全部生命值。", 
            Rarity.RARE, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(tiramisu.getName(), tiramisu);
        allSpells.add(tiramisu);
        
        SpellCard donutRing = new SpellCard(
            "甜甜圈環", 1, "抽一張牌。糖霜連動：如果你控制至少一個具有【糖霜】效果的角色，則再抽一張牌。", 
            Rarity.RARE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(donutRing.getName(), donutRing);
        allSpells.add(donutRing);
        
        SpellCard layeredCake = new SpellCard(
            "層疊蛋糕", 6, "使一個友方角色的攻擊力和生命值翻倍。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(layeredCake.getName(), layeredCake);
        allSpells.add(layeredCake);
        
        // 場地卡
        FieldCard bakery = FieldCard.createEnvironmentField(
            "甜點烘焙坊", 4, "每回合開始時，所有友方角色恢復1點生命值。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(bakery.getName(), bakery);
        allFieldCards.add(bakery);
        
        FieldCard iceCreamMaker = FieldCard.createEnvironmentField(
            "冰淇淋製造機", 3, "每回合開始時，隨機使一個友方角色獲得【酥脆(1)】效果。", 
            Rarity.COMMON, 2, Faction.DESSERT_UNION);
        allCards.put(iceCreamMaker.getName(), iceCreamMaker);
        allFieldCards.add(iceCreamMaker);
        
        FieldCard sugarCoatingField = FieldCard.createEnvironmentField(
            "糖霜塗層", 2, "每當你使用一張法術卡時，隨機使一個友方角色獲得+0/+1。", 
            Rarity.COMMON, 2, Faction.DESSERT_UNION);
        allCards.put(sugarCoatingField.getName(), sugarCoatingField);
        allFieldCards.add(sugarCoatingField);
        
        FieldCard sweetWorkshop = FieldCard.createEnvironmentField(
            "甜點工作坊", 5, "友方甜點聯盟角色獲得+1/+1。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(sweetWorkshop.getName(), sweetWorkshop);
        allFieldCards.add(sweetWorkshop);
        
        FieldCard chocolateFountain = FieldCard.createEnvironmentField(
            "巧克力噴泉", 3, "每回合開始時，隨機使一個友方角色獲得+2/+0直到回合結束。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(chocolateFountain.getName(), chocolateFountain);
        allFieldCards.add(chocolateFountain);
        
        FieldCard candyWorkshop = FieldCard.createEnvironmentField(
            "糖果工坊", 3, "每回合開始時，有25%機率抽一張牌。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(candyWorkshop.getName(), candyWorkshop);
        allFieldCards.add(candyWorkshop);
        
        FieldCard frostingMixer = FieldCard.createEnvironmentField(
            "糖霜攪拌機", 2, "當友方角色獲得【糖霜】效果時，也獲得+1/+1。", 
            Rarity.COMMON, 2, Faction.DESSERT_UNION);
        allCards.put(frostingMixer.getName(), frostingMixer);
        allFieldCards.add(frostingMixer);
        
        FieldCard sugarPlantation = FieldCard.createEnvironmentField(
            "糖分種植園", 4, "每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(sugarPlantation.getName(), sugarPlantation);
        allFieldCards.add(sugarPlantation);
        
        FieldCard honeyExtractor = FieldCard.createEnvironmentField(
            "蜂蜜提取器", 3, "每當你打出一個角色卡時，使其獲得+0/+2。", 
            Rarity.COMMON, 3, Faction.DESSERT_UNION);
        allCards.put(honeyExtractor.getName(), honeyExtractor);
        allFieldCards.add(honeyExtractor);
        
        FieldCard dessertBuffetField = FieldCard.createEnvironmentField(
            "甜點自助餐", 5, "每回合開始時，隨機使一個友方角色獲得【糖霜】效果。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(dessertBuffetField.getName(), dessertBuffetField);
        allFieldCards.add(dessertBuffetField);
        
        // 城堡卡
        CastleCard cakeCastle = new CastleCard(
            "蛋糕城堡", "所有友方角色獲得+1/+1和【糖霜】效果。", 
            Rarity.EPIC, Faction.DESSERT_UNION);
        allCards.put(cakeCastle.getName(), cakeCastle);
        allCastles.add(cakeCastle);
        
        CastleCard iceCreamFortress = new CastleCard(
            "冰淇淋堡壘", "所有友方角色獲得【酥脆(1)】效果。敵方角色攻擊時有20%機率失敗。", 
            Rarity.LEGENDARY, Faction.DESSERT_UNION);
        allCards.put(iceCreamFortress.getName(), iceCreamFortress);
        allCastles.add(iceCreamFortress);
        
        CastleCard chocolateTower = new CastleCard(
            "巧克力高塔", "所有友方角色獲得+1/+0。每回合開始時，隨機使一個友方角色獲得+1/+1。", 
            Rarity.EPIC, Faction.DESSERT_UNION);
        allCards.put(chocolateTower.getName(), chocolateTower);
        allCastles.add(chocolateTower);
        
        CastleCard candyCastle = new CastleCard(
            "糖果堡壘", "每回合開始時，召喚一個1/1的糖果小兵。友方角色獲得+0/+1。", 
            Rarity.RARE, Faction.DESSERT_UNION);
        allCards.put(candyCastle.getName(), candyCastle);
        allCastles.add(candyCastle);
        
        CastleCard puddingPalace = new CastleCard(
            "布丁宮殿", "所有友方角色獲得+0/+2。當友方角色受到傷害時，有30%機率減免1點傷害。", 
            Rarity.EPIC, Faction.DESSERT_UNION);
        allCards.put(puddingPalace.getName(), puddingPalace);
        allCastles.add(puddingPalace);
    }
    
    @Override
    public String getFactionName() {
        return "甜點聯盟";
    }
} 