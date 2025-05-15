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
 * 火辣王國陣營卡牌初始化實現類
 */
public class SpicyKingdomInitializer implements FactionCardInitializer {
    
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
        return "火辣王國";
    }
    
    private void initializeCharacterCards(Map<String, Card> allCards, List<CharacterCard> allCharacters) {
        // 基礎角色卡
        CharacterCard chiliPepper = new CharacterCard(
            "辣椒騎士", 3, "【開胃】：獲得+1攻擊力。【回味】：使一個友方角色獲得+1攻擊力。", 
            Rarity.COMMON, 3, 2, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(chiliPepper.getName(), chiliPepper);
        allCharacters.add(chiliPepper);
        
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
        
        CharacterCard sichuanChef = new CharacterCard(
            "川菜大廚", 4, "【開胃】：使一個敵方角色獲得【嗆辣】效果。【爆炒】：當攻擊時，有25%機率直接消滅目標。", 
            Rarity.EPIC, 3, 5, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(sichuanChef.getName(), sichuanChef);
        allCharacters.add(sichuanChef);

        CharacterCard curryWarrior = new CharacterCard(
            "咖哩武士", 3, "【彈牙】：每回合可攻擊 2 次。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 4, 1, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(curryWarrior.getName(), curryWarrior);
        allCharacters.add(curryWarrior);
        
        // 傳說角色卡
        CharacterCard spicyEmperor = new CharacterCard(
            "辣味皇帝", 8, "【開胃】：對所有敵方角色造成3點傷害並施加【嗆辣】效果。【爆炒】：攻擊時有50%機率摧毀目標，每回合只能發動一次。【回味】：對敵方英雄造成5點傷害。", 
            Rarity.LEGENDARY, 6, 5, 8, true, Faction.SPICY_KINGDOM);
        allCards.put(spicyEmperor.getName(), spicyEmperor);
        allCharacters.add(spicyEmperor);
        
        // 更多角色卡
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
        
        CharacterCard srirachaGuard = new CharacterCard(
            "是拉差守衛", 4, "【嗆辣】：每回合結束時，對對手造成1點傷害。【酥脆(1)】：減免1點傷害。", 
            Rarity.COMMON, 2, 2, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(srirachaGuard.getName(), srirachaGuard);
        allCharacters.add(srirachaGuard);
        
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
        
        // 補充更多角色卡以達到20張
        CharacterCard pepperGuard = new CharacterCard(
            "辣椒守衛", 3, "【嗆辣】：每回合結束時對敵方英雄造成1點傷害。【回味】：回復1點生命值。", 
            Rarity.COMMON, 2, 3, 4, false, Faction.SPICY_KINGDOM);
        allCards.put(pepperGuard.getName(), pepperGuard);
        allCharacters.add(pepperGuard);
        
        CharacterCard spiceMaster = new CharacterCard(
            "香料大師", 4, "【開胃】：使兩個友方角色獲得+1攻擊力。【爆炒】：攻擊時有20%機率造成雙倍傷害。", 
            Rarity.RARE, 3, 2, 4, true, Faction.SPICY_KINGDOM);
        allCards.put(spiceMaster.getName(), spiceMaster);
        allCharacters.add(spiceMaster);
        
        CharacterCard fireBreather = new CharacterCard(
            "吐火者", 5, "【開胃】：對所有敵方角色造成1點傷害。【嗆辣】：攻擊後，使被攻擊目標獲得【嗆辣】效果。", 
            Rarity.RARE, 4, 3, 5, true, Faction.SPICY_KINGDOM);
        allCards.put(fireBreather.getName(), fireBreather);
        allCharacters.add(fireBreather);
        
        CharacterCard chilliKing = new CharacterCard(
            "辣椒王", 7, "【開胃】：使所有友方角色獲得+1/+1。【爆炒】：攻擊時有30%機率使目標失去所有效果。", 
            Rarity.EPIC, 5, 3, 7, true, Faction.SPICY_KINGDOM);
        allCards.put(chilliKing.getName(), chilliKing);
        allCharacters.add(chilliKing);
        
        CharacterCard spicyNoodle = new CharacterCard(
            "辣麵達人", 3, "【連擊】：攻擊後，有50%機率可再次攻擊。【嗆辣】：受到傷害時，攻擊力+1。", 
            Rarity.COMMON, 2, 2, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(spicyNoodle.getName(), spicyNoodle);
        allCharacters.add(spicyNoodle);
        
        CharacterCard hotPotGuardian = new CharacterCard(
            "麻辣鍋守護者", 6, "【擺盤】：敵人必須優先攻擊這個單位。【嗆辣】：每回合結束時，對兩個隨機敵方角色造成1點傷害。", 
            Rarity.RARE, 4, 5, 6, false, Faction.SPICY_KINGDOM);
        allCards.put(hotPotGuardian.getName(), hotPotGuardian);
        allCharacters.add(hotPotGuardian);
        
        CharacterCard pepperSniper = new CharacterCard(
            "辣椒狙擊手", 4, "【遠程】：無視防禦進行攻擊。【潛行】：進場時不會觸發敵方的陷阱效果。", 
            Rarity.RARE, 5, 1, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(pepperSniper.getName(), pepperSniper);
        allCharacters.add(pepperSniper);
        
        CharacterCard spiceMerchant = new CharacterCard(
            "香料商人", 2, "【開胃】：抽一張牌。【爆炒】：如果抽到的是火辣王國卡牌，獲得+1/+1。", 
            Rarity.COMMON, 1, 1, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(spiceMerchant.getName(), spiceMerchant);
        allCharacters.add(spiceMerchant);
        
        CharacterCard hotSauceArtisan = new CharacterCard(
            "辣醬工匠", 3, "【開胃】：使一個友方角色獲得【爆炒】效果。【彈牙】：每回合可攻擊 2 次。", 
            Rarity.COMMON, 2, 1, 3, true, Faction.SPICY_KINGDOM);
        allCards.put(hotSauceArtisan.getName(), hotSauceArtisan);
        allCharacters.add(hotSauceArtisan);
    }
    
    private void initializeSpellCards(Map<String, Card> allCards, List<SpellCard> allSpells) {
        // 基礎法術卡
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
        
        // 更多法術卡以達到20張
        SpellCard redPepperRush = new SpellCard(
            "紅椒衝擊", 2, "使一個友方角色獲得+2攻擊力和【嗆辣】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(redPepperRush.getName(), redPepperRush);
        allSpells.add(redPepperRush);
        
        SpellCard spicyTransformation = new SpellCard(
            "辣味變身", 5, "使一個友方角色獲得+2/+2和【爆炒】效果，攻擊時有25%機率造成雙倍傷害。", 
            Rarity.RARE, SpellType.TRANSFORM, Faction.SPICY_KINGDOM);
        allCards.put(spicyTransformation.getName(), spicyTransformation);
        allSpells.add(spicyTransformation);
        
        SpellCard chilliStorm = new SpellCard(
            "辣椒風暴", 3, "對所有敵方角色造成1點傷害，並使其本回合內無法使用特殊效果。", 
            Rarity.RARE, SpellType.DEBUFF, Faction.SPICY_KINGDOM);
        allCards.put(chilliStorm.getName(), chilliStorm);
        allSpells.add(chilliStorm);
        
        SpellCard hotSauceSplash = new SpellCard(
            "辣醬濺射", 2, "對一個敵方角色造成3點傷害，並對其相鄰單位造成1點傷害。", 
            Rarity.COMMON, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(hotSauceSplash.getName(), hotSauceSplash);
        allSpells.add(hotSauceSplash);
        
        SpellCard spicyArmor = new SpellCard(
            "辣味護甲", 3, "使一個友方角色獲得+0/+3和【嗆辣】反擊效果：當被攻擊時，對攻擊者造成2點傷害。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(spicyArmor.getName(), spicyArmor);
        allSpells.add(spicyArmor);
        
        SpellCard flamingWeapon = new SpellCard(
            "烈焰武器", 4, "使一個友方角色攻擊力+3，並獲得【爆炒】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(flamingWeapon.getName(), flamingWeapon);
        allSpells.add(flamingWeapon);
        
        SpellCard spicyRecall = new SpellCard(
            "辣味召回", 1, "將一個友方【嗆辣】效果的角色返回手牌，並使其費用-2。", 
            Rarity.RARE, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicyRecall.getName(), spicyRecall);
        allSpells.add(spicyRecall);
        
        SpellCard hotPotion = new SpellCard(
            "辣味藥水", 2, "使一個友方角色獲得【爆炒】效果和【嗆辣】效果。", 
            Rarity.COMMON, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(hotPotion.getName(), hotPotion);
        allSpells.add(hotPotion);
        
        SpellCard blazingAssault = new SpellCard(
            "烈焰突襲", 5, "對所有敵方角色造成2點傷害，己方所有【嗆辣】效果角色攻擊力+2。", 
            Rarity.EPIC, SpellType.AOE, Faction.SPICY_KINGDOM);
        allCards.put(blazingAssault.getName(), blazingAssault);
        allSpells.add(blazingAssault);
        
        SpellCard chilliBarrage = new SpellCard(
            "辣椒彈幕", 3, "隨機對敵方角色造成共5點傷害，分配到1-5個目標。", 
            Rarity.RARE, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(chilliBarrage.getName(), chilliBarrage);
        allSpells.add(chilliBarrage);
        
        SpellCard spicyTrap = new SpellCard(
            "辣味陷阱", 2, "秘密：當敵方出牌時，使其獲得【嗆辣】效果並受到2點傷害。", 
            Rarity.RARE, SpellType.SPECIAL, Faction.SPICY_KINGDOM);
        allCards.put(spicyTrap.getName(), spicyTrap);
        allSpells.add(spicyTrap);
        
        SpellCard hotFlame = new SpellCard(
            "烈焰噴射", 4, "對一個敵方角色造成6點傷害，如果目標死亡，則對所有敵方角色造成1點傷害。", 
            Rarity.RARE, SpellType.DAMAGE, Faction.SPICY_KINGDOM);
        allCards.put(hotFlame.getName(), hotFlame);
        allSpells.add(hotFlame);
        
        SpellCard spicyRegeneration = new SpellCard(
            "辣味再生", 3, "使一個友方角色完全恢復生命值並獲得【嗆辣】效果。", 
            Rarity.RARE, SpellType.HEALING, Faction.SPICY_KINGDOM);
        allCards.put(spicyRegeneration.getName(), spicyRegeneration);
        allSpells.add(spicyRegeneration);
        
        SpellCard volcanicShield = new SpellCard(
            "火山盾牌", 5, "使所有友方角色獲得+0/+2和【嗆辣】反擊效果。", 
            Rarity.EPIC, SpellType.BUFF, Faction.SPICY_KINGDOM);
        allCards.put(volcanicShield.getName(), volcanicShield);
        allSpells.add(volcanicShield);
        
        SpellCard spicyReinforcement = new SpellCard(
            "辣味增援", 6, "召喚兩個2/2的辣椒士兵，它們具有【嗆辣】效果。", 
            Rarity.RARE, SpellType.SUMMON, Faction.SPICY_KINGDOM);
        allCards.put(spicyReinforcement.getName(), spicyReinforcement);
        allSpells.add(spicyReinforcement);
    }
    
    private void initializeFieldCards(Map<String, Card> allCards, List<FieldCard> allFieldCards) {
        // 基礎場地卡
        FieldCard spicySauce = FieldCard.createToolField(
            "魔鬼辣醬", 2, "使一個友方角色獲得+2攻擊力，但附加【嗆辣】效果。", 
            Rarity.COMMON, FieldEffectType.OFFENSIVE, 3, 2, Faction.SPICY_KINGDOM);
        allCards.put(spicySauce.getName(), spicySauce);
        allFieldCards.add(spicySauce);
        
        FieldCard chilliOil = FieldCard.createTechniqueField(
            "紅油潑灑", 3, "給一個友方角色添加【爆炒】效果：可在戰鬥階段直接消滅一個生命值低於3的敵方單位。", 
            Rarity.RARE, FieldEffectType.BOOST_ATTACK, 1, 3, Faction.SPICY_KINGDOM);
        allCards.put(chilliOil.getName(), chilliOil);
        allFieldCards.add(chilliOil);
        
        FieldCard volcanicKitchen = FieldCard.createEnvironmentField(
            "火山廚房", 5, "每回合開始時，對所有敵方角色造成1點傷害。友方火辣王國角色獲得【爆炒】效果，攻擊時有15%機率直接消滅目標。", 
            Rarity.EPIC, 4, Faction.SPICY_KINGDOM);
        allCards.put(volcanicKitchen.getName(), volcanicKitchen);
        allFieldCards.add(volcanicKitchen);
        
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
        
        // 補充更多場地卡以達到10張
        FieldCard spicyLaboratory = FieldCard.createEnvironmentField(
            "辣椒實驗室", 4, "每回合開始時，有30%機率發現一張火辣王國法術卡。", 
            Rarity.RARE, 3, Faction.SPICY_KINGDOM);
        allCards.put(spicyLaboratory.getName(), spicyLaboratory);
        allFieldCards.add(spicyLaboratory);
        
        FieldCard chilliGarden = FieldCard.createEnvironmentField(
            "辣椒花園", 3, "每回合結束時，為一個隨機友方角色獲得+1攻擊力。場上每有一個火辣王國角色，增加5%機率。", 
            Rarity.COMMON, 3, Faction.SPICY_KINGDOM);
        allCards.put(chilliGarden.getName(), chilliGarden);
        allFieldCards.add(chilliGarden);
        
        FieldCard spicyMortar = FieldCard.createToolField(
            "辣椒研缽", 2, "使一個友方角色獲得【嗆辣】效果和+2攻擊力。", 
            Rarity.COMMON, FieldEffectType.BOOST_ATTACK, 3, 2, Faction.SPICY_KINGDOM);
        allCards.put(spicyMortar.getName(), spicyMortar);
        allFieldCards.add(spicyMortar);
        
        FieldCard hotSpiceMix = FieldCard.createTechniqueField(
            "特級辣粉", 3, "使一個友方角色獲得【爆炒】效果，攻擊時有20%機率造成雙倍傷害。", 
            Rarity.RARE, FieldEffectType.SPECIAL, 2, 3, Faction.SPICY_KINGDOM);
        allCards.put(hotSpiceMix.getName(), hotSpiceMix);
        allFieldCards.add(hotSpiceMix);
        
        FieldCard spicyAura = FieldCard.createEnvironmentField(
            "辣味氛圍", 4, "所有友方火辣王國角色獲得+1/+1。當敵方角色攻擊友方角色時，有20%機率使攻擊者獲得【嗆辣】效果。", 
            Rarity.EPIC, 4, Faction.SPICY_KINGDOM);
        allCards.put(spicyAura.getName(), spicyAura);
        allFieldCards.add(spicyAura);
    }
    
    private void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard spicyCastle = new CastleCard(
            "辣椒城堡", 0, "【城堡效果】：所有友方角色攻擊力+2，對敵方角色造成的傷害+1。", 
            Rarity.EPIC, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(2));
        addToCollection(spicyCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard volcanoCastle = new CastleCard(
            "火山堡壘", 0, "【城堡效果】：回合結束時，對所有敵方角色造成1點傷害，所有友方角色攻擊力+1。", 
            Rarity.LEGENDARY, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(3));
        addToCollection(volcanoCastle, allCards, allCastles);
        
        CastleCard spicyFortress = new CastleCard(
            "辣味要塞", 0, "【城堡效果】：所有友方【嗆辣】效果觸發兩次，友方角色攻擊力+2。", 
            Rarity.RARE, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(1));
        addToCollection(spicyFortress, allCards, allCastles);
        
        CastleCard pepperCastle = new CastleCard(
            "辣椒碉堡", 0, "【城堡效果】：每回合開始時，有40%機率使一個隨機敵方角色獲得【嗆辣】效果。", 
            Rarity.RARE, Faction.SPICY_KINGDOM, new CastleEffectImpl.SpicyKingdomEffect(1));
        addToCollection(pepperCastle, allCards, allCastles);
    }
    
    private void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 