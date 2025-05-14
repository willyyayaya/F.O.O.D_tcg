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
        // 基礎角色卡
        CharacterCard cupcakeSorcerer = new CharacterCard(
            "杯子蛋糕巫師", 3, "【開胃】：使一個友方角色獲得+1/+1。【甜膩】：每回合結束時，場上每有一個甜點聯盟單位，獲得+1生命值。", 
            Rarity.COMMON, 2, 3, 3, false, Faction.DESSERT_UNION);
        allCards.put(cupcakeSorcerer.getName(), cupcakeSorcerer);
        allCharacters.add(cupcakeSorcerer);
        
        CharacterCard cakeEmpress = new CharacterCard(
            "蛋糕女皇", 6, "【開胃】：使所有友方角色獲得+0/+2。【華麗】：當你使用一張費用大於4的卡牌時，抽一張牌。", 
            Rarity.EPIC, 4, 3, 6, false, Faction.DESSERT_UNION);
        allCards.put(cakeEmpress.getName(), cakeEmpress);
        allCharacters.add(cakeEmpress);
        
        CharacterCard iceCreamDefender = new CharacterCard(
            "冰淇淋守衛", 4, "【冷凍】：攻擊時有50%機率使目標無法攻擊，持續1回合。【漸融】：每回合結束時，生命值-1，攻擊力+1。", 
            Rarity.RARE, 3, 3, 5, true, Faction.DESSERT_UNION);
        allCards.put(iceCreamDefender.getName(), iceCreamDefender);
        allCharacters.add(iceCreamDefender);
        
        CharacterCard cookieArcher = new CharacterCard(
            "餅乾弓手", 2, "【脆裂】：當生命值降至2以下時，攻擊力+2。【甜膩】：每回合結束時，回復1點生命值。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.DESSERT_UNION);
        allCards.put(cookieArcher.getName(), cookieArcher);
        allCharacters.add(cookieArcher);
        
        CharacterCard mousseMage = new CharacterCard(
            "慕斯魔法師", 5, "【開胃】：為一個友方角色恢復3點生命值。【甜膩】：治療友方角色時，同時使其獲得+0/+1。", 
            Rarity.RARE, 3, 3, 5, false, Faction.DESSERT_UNION);
        allCards.put(mousseMage.getName(), mousseMage);
        allCharacters.add(mousseMage);
        
        // 傳說角色卡
        CharacterCard sweetEmperor = new CharacterCard(
            "甜點皇帝", 8, "【開胃】：使所有友方角色獲得+1/+1和【甜膩】效果。【華麗】：每回合結束時，抽一張牌，並使一個友方角色獲得+1/+1。【冷凍】：敵方角色攻擊時有25%機率失敗。", 
            Rarity.LEGENDARY, 5, 5, 8, false, Faction.DESSERT_UNION);
        allCards.put(sweetEmperor.getName(), sweetEmperor);
        allCharacters.add(sweetEmperor);
        
        // 補充更多角色卡以達到20張
        CharacterCard candyGuardian = new CharacterCard(
            "糖果守衛", 3, "【保護】：相鄰的友方角色受到的傷害-1。【甜膩】：每回合結束時，為相鄰的友方角色恢復1點生命值。", 
            Rarity.COMMON, 2, 4, 4, false, Faction.DESSERT_UNION);
        allCards.put(candyGuardian.getName(), candyGuardian);
        allCharacters.add(candyGuardian);
        
        CharacterCard puddingProtector = new CharacterCard(
            "布丁保衛者", 4, "【開胃】：獲得+0/+3。【甜膩】：其他友方角色受到傷害時，此角色可以承擔1點傷害。", 
            Rarity.RARE, 3, 4, 6, false, Faction.DESSERT_UNION);
        allCards.put(puddingProtector.getName(), puddingProtector);
        allCharacters.add(puddingProtector);
        
        CharacterCard chocolateWarrior = new CharacterCard(
            "巧克力戰士", 3, "【開胃】：使一個友方角色獲得+1攻擊力。【漸融】：每次攻擊後，攻擊力+1，但防禦力-1。", 
            Rarity.COMMON, 3, 2, 4, true, Faction.DESSERT_UNION);
        allCards.put(chocolateWarrior.getName(), chocolateWarrior);
        allCharacters.add(chocolateWarrior);
        
        CharacterCard tiramisuThief = new CharacterCard(
            "提拉米蘇盜賊", 3, "【開胃】：從對手的牌庫中偷取一張卡牌。【甜膩】：使用偷取的卡牌時，費用-1。", 
            Rarity.RARE, 2, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(tiramisuThief.getName(), tiramisuThief);
        allCharacters.add(tiramisuThief);
        
        CharacterCard jellyDefender = new CharacterCard(
            "果凍防禦者", 2, "【彈性】：受到大於2點的傷害時，減為2點。【甜膩】：每回合結束時，如果本回合內受到過傷害，獲得+0/+1。", 
            Rarity.COMMON, 1, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(jellyDefender.getName(), jellyDefender);
        allCharacters.add(jellyDefender);
        
        CharacterCard macronMaiden = new CharacterCard(
            "馬卡龍少女", 2, "【開胃】：使一個友方角色獲得+1/+1。【華麗】：使用法術卡後，有30%機率使其費用返還1點。", 
            Rarity.COMMON, 2, 2, 2, false, Faction.DESSERT_UNION);
        allCards.put(macronMaiden.getName(), macronMaiden);
        allCharacters.add(macronMaiden);
        
        CharacterCard donutDuelist = new CharacterCard(
            "甜甜圈決鬥者", 3, "【開胃】：抽一張牌。【環型】：當受到傷害時，有50%機率只受到1點傷害。", 
            Rarity.COMMON, 3, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(donutDuelist.getName(), donutDuelist);
        allCharacters.add(donutDuelist);
        
        CharacterCard waffleMage = new CharacterCard(
            "鬆餅魔法師", 4, "【開胃】：隨機發現一張甜點聯盟法術卡。【華麗】：每當使用一張法術牌，獲得+0/+1。", 
            Rarity.RARE, 2, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(waffleMage.getName(), waffleMage);
        allCharacters.add(waffleMage);
        
        CharacterCard sugarRushBerserker = new CharacterCard(
            "糖分狂戰士", 4, "【開胃】：獲得+2攻擊力。【虛弱】：每回合結束時，攻擊力-1。【甜膩】：使用甜點聯盟卡時，攻擊力+1。", 
            Rarity.RARE, 4, 1, 5, true, Faction.DESSERT_UNION);
        allCards.put(sugarRushBerserker.getName(), sugarRushBerserker);
        allCharacters.add(sugarRushBerserker);
        
        CharacterCard parfaitPrincess = new CharacterCard(
            "芭菲公主", 5, "【開胃】：使所有友方角色獲得+0/+1。【甜膩】：每回合結束時，如果你的生命值高於20，所有友方角色獲得+1/+1。", 
            Rarity.EPIC, 3, 3, 5, false, Faction.DESSERT_UNION);
        allCards.put(parfaitPrincess.getName(), parfaitPrincess);
        allCharacters.add(parfaitPrincess);
        
        CharacterCard fudgeFighter = new CharacterCard(
            "軟糖鬥士", 2, "【彈性】：第一次受到傷害時，傷害減半（向下取整）。【甜膩】：攻擊後，恢復1點生命值。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.DESSERT_UNION);
        allCards.put(fudgeFighter.getName(), fudgeFighter);
        allCharacters.add(fudgeFighter);
        
        CharacterCard pastryPaladin = new CharacterCard(
            "糕點聖騎士", 6, "【開胃】：使相鄰的友方角色獲得+1/+2。【保護】：相鄰的友方角色受到的傷害轉移到此角色上。", 
            Rarity.EPIC, 4, 5, 7, false, Faction.DESSERT_UNION);
        allCards.put(pastryPaladin.getName(), pastryPaladin);
        allCharacters.add(pastryPaladin);
        
        CharacterCard cheesecakeSorcerer = new CharacterCard(
            "起司蛋糕術士", 3, "【開胃】：為一個友方角色恢復2點生命值。【華麗】：每回合第一次使用法術牌時，其費用-1。", 
            Rarity.RARE, 2, 3, 4, false, Faction.DESSERT_UNION);
        allCards.put(cheesecakeSorcerer.getName(), cheesecakeSorcerer);
        allCharacters.add(cheesecakeSorcerer);
        
        CharacterCard lollipopLancer = new CharacterCard(
            "棒棒糖槍兵", 1, "【開胃】：使一個友方角色獲得+1攻擊力。【甜膩】：如果你控制3個或更多甜點聯盟角色，獲得+1/+1。", 
            Rarity.COMMON, 1, 1, 2, true, Faction.DESSERT_UNION);
        allCards.put(lollipopLancer.getName(), lollipopLancer);
        allCharacters.add(lollipopLancer);
        
        CharacterCard icingEnchanter = new CharacterCard(
            "糖霜魔法師", 4, "【開胃】：使一個友方角色獲得【冷凍】效果。【華麗】：使用法術牌時，有25%機率複製該法術。", 
            Rarity.EPIC, 3, 2, 4, false, Faction.DESSERT_UNION);
        allCards.put(icingEnchanter.getName(), icingEnchanter);
        allCharacters.add(icingEnchanter);
        
        CharacterCard honeyGuardian = new CharacterCard(
            "蜂蜜守護者", 3, "【甜膩】：每回合結束時，為所有友方角色恢復1點生命值。【黏稠】：敵方角色攻擊此角色時，攻擊力-1。", 
            Rarity.RARE, 1, 4, 5, false, Faction.DESSERT_UNION);
        allCards.put(honeyGuardian.getName(), honeyGuardian);
        allCharacters.add(honeyGuardian);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
        SpellCard sugarRush = new SpellCard(
            "糖分衝擊", 2, "使一個友方角色獲得+3攻擊力，持續1回合。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarRush.getName(), sugarRush);
        allSpells.add(sugarRush);
        
        SpellCard frostingArmor = new SpellCard(
            "糖霜護甲", 3, "使一個友方角色獲得+0/+4和【冷凍】效果：攻擊時有50%機率使目標無法攻擊，持續1回合。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(frostingArmor.getName(), frostingArmor);
        allSpells.add(frostingArmor);
        
        SpellCard cakeExplosion = new SpellCard(
            "蛋糕爆炸", 4, "對所有敵方角色造成2點傷害，並使其獲得【甜膩】效果，下回合無法攻擊。", 
            Rarity.RARE, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(cakeExplosion.getName(), cakeExplosion);
        allSpells.add(cakeExplosion);
        
        SpellCard sweetInspiration = new SpellCard(
            "甜蜜靈感", 1, "抽一張牌。如果抽到的是甜點聯盟卡牌，則再抽一張牌。", 
            Rarity.COMMON, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(sweetInspiration.getName(), sweetInspiration);
        allSpells.add(sweetInspiration);
        
        SpellCard royalDessert = new SpellCard(
            "皇家甜點", 6, "使所有友方角色獲得+2/+2和【華麗】效果：使用卡牌時，有30%機率抽一張牌。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(royalDessert.getName(), royalDessert);
        allSpells.add(royalDessert);
        
        // 補充更多法術卡以達到20張
        SpellCard iceCreamBlast = new SpellCard(
            "冰淇淋爆擊", 3, "對一個敵方角色造成3點傷害，並使其獲得【冷凍】效果，下回合無法攻擊。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.DESSERT_UNION);
        allCards.put(iceCreamBlast.getName(), iceCreamBlast);
        allSpells.add(iceCreamBlast);
        
        SpellCard cookieShield = new SpellCard(
            "餅乾護盾", 2, "使一個友方角色獲得+0/+3和【脆裂】效果：當生命值降至2以下時，攻擊力+2。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(cookieShield.getName(), cookieShield);
        allSpells.add(cookieShield);
        
        SpellCard sugarCoating = new SpellCard(
            "糖霜覆蓋", 1, "使一個友方角色獲得【甜膩】效果：每回合結束時恢復1點生命值。", 
            Rarity.COMMON, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarCoating.getName(), sugarCoating);
        allSpells.add(sugarCoating);
        
        SpellCard candyTempest = new SpellCard(
            "糖果風暴", 5, "造成1-3點傷害到所有敵方角色，並使其獲得【甜膩】效果，攻擊力-1。", 
            Rarity.EPIC, SpellType.AOE, Faction.DESSERT_UNION);
        allCards.put(candyTempest.getName(), candyTempest);
        allSpells.add(candyTempest);
        
        SpellCard jellyRebound = new SpellCard(
            "果凍反彈", 3, "使一個友方角色獲得【彈性】效果：受到的下一次傷害減半並反彈到攻擊者身上。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(jellyRebound.getName(), jellyRebound);
        allSpells.add(jellyRebound);
        
        SpellCard caramelBond = new SpellCard(
            "焦糖連結", 4, "使兩個友方角色獲得+1/+2和效果：其中一個受到傷害時，另一個分擔一半傷害。", 
            Rarity.RARE, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(caramelBond.getName(), caramelBond);
        allSpells.add(caramelBond);
        
        SpellCard creamPuff = new SpellCard(
            "奶油泡芙", 2, "為一個友方角色恢復4點生命值，並使其獲得+1/+1。", 
            Rarity.COMMON, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(creamPuff.getName(), creamPuff);
        allSpells.add(creamPuff);
        
        SpellCard chocolateFusion = new SpellCard(
            "巧克力融合", 3, "移除一個友方角色，則另一個友方角色獲得等同於被移除角色屬性總和的加成。", 
            Rarity.EPIC, SpellType.TRANSFORM, Faction.DESSERT_UNION);
        allCards.put(chocolateFusion.getName(), chocolateFusion);
        allSpells.add(chocolateFusion);
        
        SpellCard dessertBuffet = new SpellCard(
            "甜點自助餐", 5, "抽3張牌，從中選擇2張加入手牌，其費用-1。", 
            Rarity.RARE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(dessertBuffet.getName(), dessertBuffet);
        allSpells.add(dessertBuffet);
        
        SpellCard honeyTrap = new SpellCard(
            "蜂蜜陷阱", 2, "使一個敵方角色獲得【黏稠】效果：攻擊力-2，移動速度-1，持續2回合。", 
            Rarity.COMMON, SpellType.DEBUFF, Faction.DESSERT_UNION);
        allCards.put(honeyTrap.getName(), honeyTrap);
        allSpells.add(honeyTrap);
        
        SpellCard sugarSurge = new SpellCard(
            "糖分湧動", 4, "使所有友方角色獲得+1/+1和效果：每回合第一次攻擊後，可以再次攻擊。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(sugarSurge.getName(), sugarSurge);
        allSpells.add(sugarSurge);
        
        SpellCard candySummon = new SpellCard(
            "糖果召喚", 3, "召喚兩個1/2的糖果小兵，它們具有【甜膩】效果。", 
            Rarity.COMMON, SpellType.SUMMON, Faction.DESSERT_UNION);
        allCards.put(candySummon.getName(), candySummon);
        allSpells.add(candySummon);
        
        SpellCard tiramisu = new SpellCard(
            "提拉米蘇", 3, "為一個友方角色恢復全部生命值，並使其獲得【甜膩】和【華麗】效果。", 
            Rarity.RARE, SpellType.HEALING, Faction.DESSERT_UNION);
        allCards.put(tiramisu.getName(), tiramisu);
        allSpells.add(tiramisu);
        
        SpellCard donutRing = new SpellCard(
            "甜甜圈環", 1, "從牌庫中抽出一張最高費用的甜點聯盟卡牌，並使其費用-2。", 
            Rarity.RARE, SpellType.DRAW, Faction.DESSERT_UNION);
        allCards.put(donutRing.getName(), donutRing);
        allSpells.add(donutRing);
        
        SpellCard layeredCake = new SpellCard(
            "層疊蛋糕", 6, "使一個友方角色的攻擊力和生命值翻倍，但下回合結束時獲得【漸融】效果：每回合生命值-1。", 
            Rarity.EPIC, SpellType.BUFF, Faction.DESSERT_UNION);
        allCards.put(layeredCake.getName(), layeredCake);
        allSpells.add(layeredCake);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard bakery = FieldCard.createEnvironmentField(
            "甜點烘焙坊", 4, "每回合開始時，所有友方角色恢復1點生命值。場上每有一個甜點聯盟角色，有15%機率抽一張牌。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(bakery.getName(), bakery);
        allFieldCards.add(bakery);
        
        FieldCard iceCreamMaker = FieldCard.createToolField(
            "冰淇淋製造機", 3, "每回合可以使一個友方角色獲得【冷凍】效果：攻擊時有50%機率使目標無法攻擊，持續1回合。", 
            Rarity.COMMON, FieldEffectType.SPECIAL, 2, 3, Faction.DESSERT_UNION);
        allCards.put(iceCreamMaker.getName(), iceCreamMaker);
        allFieldCards.add(iceCreamMaker);
        
        FieldCard sugarCoating = FieldCard.createTechniqueField(
            "糖霜塗層", 2, "使一個友方角色獲得【甜膩】效果：每回合結束時恢復2點生命值。", 
            Rarity.COMMON, FieldEffectType.HEAL, 2, 3, Faction.DESSERT_UNION);
        allCards.put(sugarCoating.getName(), sugarCoating);
        allFieldCards.add(sugarCoating);
        
        // 補充更多場地卡以達到10張
        FieldCard sweetWorkshop = FieldCard.createEnvironmentField(
            "甜點工作坊", 5, "友方甜點聯盟角色獲得+1/+1。每當使用一張費用大於4的卡牌時，有30%機率使其費用-2。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(sweetWorkshop.getName(), sweetWorkshop);
        allFieldCards.add(sweetWorkshop);
        
        FieldCard chocolateFountain = FieldCard.createToolField(
            "巧克力噴泉", 3, "每回合可以使一個友方角色攻擊力+2，但下回合結束時獲得【漸融】效果：攻擊力-1。", 
            Rarity.RARE, FieldEffectType.OFFENSIVE, 3, 3, Faction.DESSERT_UNION);
        allCards.put(chocolateFountain.getName(), chocolateFountain);
        allFieldCards.add(chocolateFountain);
        
        FieldCard candyWorkshop = FieldCard.createEnvironmentField(
            "糖果工坊", 3, "每回合開始時，有25%機率發現一張甜點聯盟法術卡。友方【甜膩】效果恢復量+1。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(candyWorkshop.getName(), candyWorkshop);
        allFieldCards.add(candyWorkshop);
        
        FieldCard frostingMixer = FieldCard.createToolField(
            "糖霜攪拌機", 2, "每回合可以使一個友方角色獲得+0/+2和【彈性】效果，持續1回合。", 
            Rarity.COMMON, FieldEffectType.DEFENSIVE, 2, 2, Faction.DESSERT_UNION);
        allCards.put(frostingMixer.getName(), frostingMixer);
        allFieldCards.add(frostingMixer);
        
        FieldCard sugarPlantation = FieldCard.createEnvironmentField(
            "糖分種植園", 4, "友方角色的【華麗】效果觸發機率+20%。每回合結束時，為所有友方角色恢復1點生命值。", 
            Rarity.RARE, 3, Faction.DESSERT_UNION);
        allCards.put(sugarPlantation.getName(), sugarPlantation);
        allFieldCards.add(sugarPlantation);
        
        FieldCard honeyExtractor = FieldCard.createTechniqueField(
            "蜂蜜提取器", 3, "使一個友方角色獲得【黏稠】反擊效果：當被攻擊時，攻擊者攻擊力-1，持續1回合。", 
            Rarity.COMMON, FieldEffectType.SPECIAL, 3, 3, Faction.DESSERT_UNION);
        allCards.put(honeyExtractor.getName(), honeyExtractor);
        allFieldCards.add(honeyExtractor);
        
        FieldCard dessertBuffet = FieldCard.createEnvironmentField(
            "甜點自助餐", 5, "每回合開始時，從牌庫隨機抽出一張甜點聯盟卡牌，如果該卡費用大於4，則費用-2。", 
            Rarity.EPIC, 4, Faction.DESSERT_UNION);
        allCards.put(dessertBuffet.getName(), dessertBuffet);
        allFieldCards.add(dessertBuffet);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard cakeCastle = new CastleCard(
            "蛋糕城堡", 0, "【城堡效果】：所有友方角色獲得+1/+2和【甜膩】效果。每回合結束時，使一個隨機友方角色恢復2點生命值。", 
            Rarity.EPIC, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(2));
        addToCollection(cakeCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard iceCreamFortress = new CastleCard(
            "冰淇淋堡壘", 0, "【城堡效果】：所有友方角色獲得【冷凍】效果。敵方角色攻擊時有20%機率失敗。", 
            Rarity.LEGENDARY, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(3));
        addToCollection(iceCreamFortress, allCards, allCastles);
        
        CastleCard chocolateTower = new CastleCard(
            "巧克力塔樓", 0, "【城堡效果】：所有友方角色獲得+2/+0和【漸融】效果。每回合結束時抽一張牌。", 
            Rarity.RARE, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(2));
        addToCollection(chocolateTower, allCards, allCastles);
        
        CastleCard candyCastle = new CastleCard(
            "糖果堡壘", 0, "【城堡效果】：每回合開始時，召喚一個1/1的糖果小兵。友方角色獲得+0/+2。", 
            Rarity.RARE, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(1));
        addToCollection(candyCastle, allCards, allCastles);
        
        CastleCard puddingPalace = new CastleCard(
            "布丁宮殿", 0, "【城堡效果】：所有友方角色獲得【彈性】效果，受到的傷害最多為2點。當友方角色觸發【甜膩】效果時，有30%機率抽一張牌。", 
            Rarity.EPIC, Faction.DESSERT_UNION, new CastleEffectImpl.DessertUnionEffect(2));
        addToCollection(puddingPalace, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 