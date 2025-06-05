package com.example.game.card;

import java.util.List;
import java.util.Map;

import com.example.game.player.Player;

/**
 * 城堡效果實現類 - 為各陣營提供不同的城堡效果
 */
public class CastleEffectImpl {
    
    /**
     * 火辣王國城堡效果 - 增加攻擊力和傷害
     */
    public static class SpicyKingdomEffect implements CastleEffect {
        private final int attackBonus;
        
        public SpicyKingdomEffect(int attackBonus) {
            this.attackBonus = attackBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("火辣王國城堡效果: 所有友方角色攻擊力+" + attackBonus + "，對敵方角色造成的傷害+1");
            // TODO: 在遊戲引擎中實現實際效果
            // 1. 增加所有友方角色的攻擊力
            // 2. 增加對敵方角色造成的傷害
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色攻擊力+" + attackBonus + "，對敵方角色造成的傷害+1";
        }
    }
    
    /**
     * 健康綠洲城堡效果 - 增加生命值和治療效果
     */
    public static class HealthyOasisEffect implements CastleEffect {
        private final int healthBonus;
        
        public HealthyOasisEffect(int healthBonus) {
            this.healthBonus = healthBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("健康綠洲城堡效果: 所有友方角色生命值+" + healthBonus + "，每回合結束時恢復1點生命值");
            // TODO: 在遊戲引擎中實現實際效果
            // 1. 增加所有友方角色的生命值
            // 2. 每回合結束時恢復生命值
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色生命值+" + healthBonus + "，每回合結束時恢復1點生命值";
        }
    }
    
    /**
     * 速食工會城堡效果 - 減少費用和加速
     */
    public static class FastFoodGuildEffect implements CastleEffect {
        private final int costReduction;
        
        public FastFoodGuildEffect(int costReduction) {
            this.costReduction = costReduction;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("速食工會城堡效果: 所有友方角色費用-" + costReduction + "，30%機率獲得【現炸】效果");
            // TODO: 在遊戲引擎中實現實際效果
            // 1. 減少所有友方角色的費用
            // 2. 30%機率獲得【現炸】效果
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色費用-" + costReduction + "，30%機率獲得【現炸】效果";
        }
    }
    
    /**
     * 甜點聯盟城堡效果 - 提供防禦和特殊能力
     */
    public static class DessertUnionEffect implements CastleEffect {
        private final int defenseBonus;
        
        public DessertUnionEffect(int defenseBonus) {
            this.defenseBonus = defenseBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("甜點聯盟城堡效果: 所有友方角色獲得+" + defenseBonus + "防禦，25%機率獲得【糖霜】效果");
            // TODO: 在遊戲引擎中實現實際效果
            // 1. 增加所有友方角色的防禦
            // 2. 25%機率獲得【糖霜】效果
        }
        
        @Override
        public String getEffectDescription() {
            return "所有友方角色獲得+" + defenseBonus + "防禦，25%機率獲得【糖霜】效果";
        }
    }
    
    /**
     * 中立城堡效果 - 多功能輔助效果
     */
    public static class NeutralEffect implements CastleEffect {
        private final int drawBonus;
        
        public NeutralEffect(int drawBonus) {
            this.drawBonus = drawBonus;
        }
        
        @Override
        public void applyEffect(Player player) {
            // 實際效果需要在遊戲引擎中實現，這裡只是模擬
            System.out.println("中立城堡效果: 每回合開始時有" + (drawBonus * 10) + "%機率額外抽一張牌，所有友方角色獲得+1/+1");
            // TODO: 在遊戲引擎中實現實際效果
            // 1. 每回合開始時有機率額外抽牌
            // 2. 所有友方角色獲得+1/+1
        }
        
        @Override
        public String getEffectDescription() {
            return "每回合開始時有" + (drawBonus * 10) + "%機率額外抽一張牌，所有友方角色獲得+1/+1";
        }
    }

    /**
     * 初始化所有城堡卡
     */
    public static void initializeCastleCards(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 火辣王國城堡卡
        initializeSpicyKingdomCastles(allCards, allCastles);
        
        // 健康綠洲城堡卡
        initializeHealthyOasisCastles(allCards, allCastles);
        
        // 速食工會城堡卡
        initializeFastFoodGuildCastles(allCards, allCastles);
        
        // 甜點聯盟城堡卡
        initializeDessertUnionCastles(allCards, allCastles);
        
        // 中立城堡卡
        initializeNeutralCastles(allCards, allCastles);
    }

    /**
     * 初始化火辣王國城堡卡
     */
    private static void initializeSpicyKingdomCastles(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard spicyCastle = CastleCard.builder()
            .name("辣椒王座")
            .cost(5)
            .description("【城堡效果】：每回合開始時，使所有友方角色獲得+2攻擊力，並獲得【嗆辣】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        spicyCastle.setEffect(new SpicyKingdomEffect(2));
        addToCollection(spicyCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard volcanoCastle = CastleCard.builder()
            .name("火山廚房")
            .cost(0)
            .description("【城堡效果】：每回合開始時，對所有敵方角色造成2點傷害，並使其獲得【灼燒】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        volcanoCastle.setEffect(new SpicyKingdomEffect(3));
        addToCollection(volcanoCastle, allCards, allCastles);
        
        CastleCard spicyTemple = CastleCard.builder()
            .name("辣味神殿")
            .cost(0)
            .description("【城堡效果】：所有友方角色攻擊力+3，對敵方角色造成的傷害+2，並有25%機率觸發【爆炒】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        spicyTemple.setEffect(new SpicyKingdomEffect(3));
        addToCollection(spicyTemple, allCards, allCastles);
        
        CastleCard chiliFortress = CastleCard.builder()
            .name("辣椒要塞")
            .cost(0)
            .description("【城堡效果】：所有友方角色攻擊力+2，獲得【嗆辣】效果，攻擊時有30%機率使敵方失去1點攻擊力。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        chiliFortress.setEffect(new SpicyKingdomEffect(2));
        addToCollection(chiliFortress, allCards, allCastles);
        
        CastleCard pepperTower = CastleCard.builder()
            .name("胡椒塔")
            .cost(0)
            .description("【城堡效果】：所有友方角色攻擊力+1，獲得【連擊】效果，每回合可額外攻擊一次。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.SPICY_KINGDOM)
            .health(30)
            .build();
        pepperTower.setEffect(new SpicyKingdomEffect(1));
        addToCollection(pepperTower, allCards, allCastles);
    }

    /**
     * 初始化健康綠洲城堡卡
     */
    private static void initializeHealthyOasisCastles(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard healthyCastle = CastleCard.builder()
            .name("生命之泉")
            .cost(5)
            .description("【城堡效果】：每回合開始時，使所有友方角色獲得+2生命值，並恢復1點生命值。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.HEALTHY_OASIS)
            .health(30)
            .build();
        healthyCastle.setEffect(new HealthyOasisEffect(3));
        addToCollection(healthyCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard gardenCastle = CastleCard.builder()
            .name("療癒花園")
            .cost(0)
            .description("【城堡效果】：每回合開始時，為所有友方角色恢復2點生命值，並獲得【滋補】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.HEALTHY_OASIS)
            .health(30)
            .build();
        gardenCastle.setEffect(new HealthyOasisEffect(3));
        addToCollection(gardenCastle, allCards, allCastles);
        
        CastleCard healthyTemple = CastleCard.builder()
            .name("生命神殿")
            .cost(0)
            .description("【城堡效果】：所有友方角色生命值+4，每回合結束時恢復2點生命值，並獲得【再生】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.HEALTHY_OASIS)
            .health(30)
            .build();
        healthyTemple.setEffect(new HealthyOasisEffect(4));
        addToCollection(healthyTemple, allCards, allCastles);
        
        CastleCard vegetableFortress = CastleCard.builder()
            .name("蔬菜要塞")
            .cost(0)
            .description("【城堡效果】：所有友方角色生命值+3，獲得【滋補】效果，每回合結束時恢復1點生命值。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.HEALTHY_OASIS)
            .health(30)
            .build();
        vegetableFortress.setEffect(new HealthyOasisEffect(3));
        addToCollection(vegetableFortress, allCards, allCastles);
        
        CastleCard fruitTower = CastleCard.builder()
            .name("水果塔")
            .cost(0)
            .description("【城堡效果】：所有友方角色生命值+2，獲得【再生】效果，每回合開始時恢復1點生命值。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.HEALTHY_OASIS)
            .health(30)
            .build();
        fruitTower.setEffect(new HealthyOasisEffect(2));
        addToCollection(fruitTower, allCards, allCastles);
    }

    /**
     * 初始化速食工會城堡卡
     */
    private static void initializeFastFoodGuildCastles(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard burgerCastle = CastleCard.builder()
            .name("漢堡王座")
            .cost(5)
            .description("【城堡效果】：友方角色攻擊力+2，你的卡牌費用-1（最低為1），並獲得【現炸】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        burgerCastle.setEffect(new FastFoodGuildEffect(2));
        addToCollection(burgerCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard frenchFryCastle = CastleCard.builder()
            .name("薯條堡壘")
            .cost(0)
            .description("【城堡效果】：每回合第一次打出的卡牌費用-2，友方角色獲得+1/+1，並獲得【現炸】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        frenchFryCastle.setEffect(new FastFoodGuildEffect(3));
        addToCollection(frenchFryCastle, allCards, allCastles);
        
        CastleCard nuggetFortress = CastleCard.builder()
            .name("雞塊要塞")
            .cost(0)
            .description("【城堡效果】：每回合結束時，有50%機率召喚一個2/2的雞塊士兵。友方角色獲得【油潤】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        nuggetFortress.setEffect(new FastFoodGuildEffect(2));
        addToCollection(nuggetFortress, allCards, allCastles);
        
        CastleCard driveThruTower = CastleCard.builder()
            .name("得來速塔")
            .cost(0)
            .description("【城堡效果】：每回合開始時，抽一張牌，並使你的下一張卡牌費用-1。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        driveThruTower.setEffect(new FastFoodGuildEffect(3));
        addToCollection(driveThruTower, allCards, allCastles);
        
        CastleCard fastFoodTemple = CastleCard.builder()
            .name("速食神殿")
            .cost(0)
            .description("【城堡效果】：友方角色攻擊力+3，你的卡牌費用-2（最低為1），並獲得【現炸】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        fastFoodTemple.setEffect(new FastFoodGuildEffect(3));
        addToCollection(fastFoodTemple, allCards, allCastles);
        
        CastleCard burgerFortress = CastleCard.builder()
            .name("漢堡要塞")
            .cost(0)
            .description("【城堡效果】：友方角色攻擊力+2，你的卡牌費用-1（最低為1），並獲得【油潤】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        burgerFortress.setEffect(new FastFoodGuildEffect(2));
        addToCollection(burgerFortress, allCards, allCastles);
        
        CastleCard pizzaTower = CastleCard.builder()
            .name("披薩塔")
            .cost(0)
            .description("【城堡效果】：友方角色的【連擊】和【速食】效果觸發機率+25%。友方角色獲得+1/+1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.FAST_FOOD_GUILD)
            .health(30)
            .build();
        pizzaTower.setEffect(new FastFoodGuildEffect(1));
        addToCollection(pizzaTower, allCards, allCastles);
    }

    /**
     * 初始化甜點聯盟城堡卡
     */
    private static void initializeDessertUnionCastles(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 基礎城堡卡
        CastleCard dessertCastle = CastleCard.builder()
            .name("甜點王座")
            .cost(5)
            .description("【城堡效果】：每回合開始時，使所有友方角色獲得【糖霜】效果，並獲得+1防禦。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        dessertCastle.setEffect(new DessertUnionEffect(2));
        addToCollection(dessertCastle, allCards, allCastles);
        
        // 更多城堡卡
        CastleCard cakeCastle = CastleCard.builder()
            .name("蛋糕堡壘")
            .cost(0)
            .description("【城堡效果】：所有友方角色獲得【糖霜】效果，攻擊時有25%機率使敵方失去1點攻擊力。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        cakeCastle.setEffect(new DessertUnionEffect(3));
        addToCollection(cakeCastle, allCards, allCastles);
        
        CastleCard chocolateTower = CastleCard.builder()
            .name("巧克力高塔")
            .cost(0)
            .description("【城堡效果】：所有友方【糖爆】效果持續回合+1，並增加10%觸發機率。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        chocolateTower.setEffect(new DessertUnionEffect(2));
        addToCollection(chocolateTower, allCards, allCastles);
        
        CastleCard iceCreamCastle = CastleCard.builder()
            .name("冰淇淋城堡")
            .cost(0)
            .description("【城堡效果】：每回合開始時，使一個友方角色獲得【糖霜】效果，並恢復1點生命值。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        iceCreamCastle.setEffect(new DessertUnionEffect(1));
        addToCollection(iceCreamCastle, allCards, allCastles);
        
        CastleCard dessertTemple = CastleCard.builder()
            .name("甜點神殿")
            .cost(0)
            .description("【城堡效果】：所有友方角色獲得+3防禦，50%機率獲得【糖霜】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        dessertTemple.setEffect(new DessertUnionEffect(3));
        addToCollection(dessertTemple, allCards, allCastles);
        
        CastleCard cakeFortress = CastleCard.builder()
            .name("蛋糕要塞")
            .cost(0)
            .description("【城堡效果】：所有友方角色獲得+2防禦，25%機率獲得【糖霜】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        cakeFortress.setEffect(new DessertUnionEffect(2));
        addToCollection(cakeFortress, allCards, allCastles);
        
        CastleCard cookieTower = CastleCard.builder()
            .name("餅乾塔")
            .cost(0)
            .description("【城堡效果】：所有友方角色獲得+1防禦，15%機率獲得【糖霜】效果。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.DESSERT_UNION)
            .health(30)
            .build();
        cookieTower.setEffect(new DessertUnionEffect(1));
        addToCollection(cookieTower, allCards, allCastles);
    }

    /**
     * 初始化中立城堡卡
     */
    private static void initializeNeutralCastles(Map<String, Card> allCards, List<CastleCard> allCastles) {
        // 根莖類主題城堡
        CastleCard rootCastle = CastleCard.builder()
            .name("大地根莖聖殿（The Rootspire Sanctuary）")
            .cost(5)
            .description("【城堡效果】：每回合開始時，使所有友方根莖類角色獲得【酥脆(1)】效果，並恢復1點生命值。每當你打出一個根莖類角色時，抽一張牌。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        rootCastle.setEffect(new NeutralEffect(2));
        addToCollection(rootCastle, allCards, allCastles);
        
        // 豆類主題城堡
        CastleCard beanCastle = CastleCard.builder()
            .name("豆響之塔（Resonant Beanspire）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，使所有友方豆類角色獲得【彈牙】效果，並有25%機率抽一張牌。每當你打出一個豆類角色時，使其獲得+1/+1。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        beanCastle.setEffect(new NeutralEffect(3));
        addToCollection(beanCastle, allCards, allCastles);
        
        // 葉菜類主題城堡
        CastleCard leafyCastle = CastleCard.builder()
            .name("翠綠天穹庭（Verdant Canopy Keep）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，為所有友方葉菜類角色恢復1點生命值，並使其獲得+0/+1。每當你打出一個葉菜類角色時，使其獲得【開胃】效果。")
            .rarity(Rarity.GOURMET_DELIGHT)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        leafyCastle.setEffect(new NeutralEffect(2));
        addToCollection(leafyCastle, allCards, allCastles);
        
        // 瓜果類主題城堡
        CastleCard gourdCastle = CastleCard.builder()
            .name("芳甜籬堡（Aroma Melofort）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，使所有友方瓜果類角色獲得+1/+0，並有30%機率獲得【彈牙】效果。每當你打出一個瓜果類角色時，使其獲得【酥脆(1)】效果。")
            .rarity(Rarity.CULINARY_HERITAGE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        gourdCastle.setEffect(new NeutralEffect(3));
        addToCollection(gourdCastle, allCards, allCastles);
        
        // 菇類主題城堡
        CastleCard mushroomCastle = CastleCard.builder()
            .name("蕈靈回憶殿（Temple of Sporemind）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，有40%機率使一個友方菇類角色獲得【回味】效果，並抽一張牌。每當你打出一個菇類角色時，使其獲得【酥脆(1)】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        mushroomCastle.setEffect(new NeutralEffect(4));
        addToCollection(mushroomCastle, allCards, allCastles);
        
        // 香料類主題城堡
        CastleCard spiceCastle = CastleCard.builder()
            .name("萬香錘製所（Citadel of Seasonforge）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，使所有友方香料類角色獲得+1/+1，並有20%機率獲得【現炸】效果。每當你打出一個香料類角色時，使其獲得【彈牙】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        spiceCastle.setEffect(new NeutralEffect(4));
        addToCollection(spiceCastle, allCards, allCastles);
        
        // 綜合主題城堡
        CastleCard fusionCastle = CastleCard.builder()
            .name("千味交融壇（Pantaste Throne）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，根據場上不同食材類別數量獲得效果：1類-抽一張牌；2類-所有友方角色+1/+1；3類-恢復1點生命值；4類-獲得【酥脆(1)】；5類-獲得【彈牙】；6類-獲得【現炸】。每當你打出一個角色時，使其獲得對應食材類別的關鍵字效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        fusionCastle.setEffect(new NeutralEffect(5));
        addToCollection(fusionCastle, allCards, allCastles);
        
        // 特殊主題城堡
        CastleCard ancientCastle = CastleCard.builder()
            .name("古饕遺殿（Ancient Gourmet Reliquary）")
            .cost(0)
            .description("【城堡效果】：每回合開始時，使一個友方角色獲得+2/+2，並隨機獲得一個食材類別的關鍵字效果。每當你打出一個角色時，使其獲得【回味】效果。")
            .rarity(Rarity.ULTIMATE_TASTE)
            .faction(Faction.NEUTRAL)
            .health(30)
            .build();
        ancientCastle.setEffect(new NeutralEffect(5));
        addToCollection(ancientCastle, allCards, allCastles);
    }

    /**
     * 添加城堡卡到集合中
     */
    private static void addToCollection(CastleCard castle, Map<String, Card> allCards, List<CastleCard> allCastles) {
        allCards.put(castle.getName(), castle);
        allCastles.add(castle);
    }
} 