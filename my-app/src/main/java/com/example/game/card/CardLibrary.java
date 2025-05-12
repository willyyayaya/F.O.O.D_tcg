package com.example.game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 卡牌圖鑑 - 管理所有可用的卡牌
 */
public class CardLibrary {
    private static Map<String, Card> allCards = new HashMap<>();
    private static List<Minion> allMinions = new ArrayList<>();
    private static List<SpellCard> allSpells = new ArrayList<>();
    private static List<CharacterCard> allCharacters = new ArrayList<>();
    private static List<FieldCard> allFieldCards = new ArrayList<>();
    
    /**
     * 初始化卡牌圖鑑
     */
    public static void initialize() {
        // 先清空現有卡牌，防止重複初始化
        allCards.clear();
        allMinions.clear();
        allSpells.clear();
        allCharacters.clear();
        allFieldCards.clear();
        
        // 初始化一些預設卡牌
        initializeMinions();
        initializeSpells();
        initializeCharacters();
        initializeFieldCards();
        
        System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
        System.out.println("其中角色卡: " + allCharacters.size() + " 張，場地卡: " + allFieldCards.size() + " 張");
    }
    
    /**
     * 初始化隨從卡
     */
    private static void initializeMinions() {
        // 這裡可以添加一些基本的隨從卡（如果需要）
        addMinion(new Minion("小麵包", 1, "基礎隨從，適合新手使用", Rarity.COMMON, 1, 2));
        addMinion(new Minion("奶油餅乾", 2, "香甜可口的餅乾隨從", Rarity.COMMON, 2, 2));
        addMinion(new Minion("蔬菜沙拉", 3, "健康的蔬菜組合，恢復生命", Rarity.COMMON, 2, 3));
    }
    
    /**
     * 初始化法術卡
     */
    private static void initializeSpells() {
        // 添加幾張基本法術卡
        addSpell(new SpellCard("烹飪指南", 1, "抽一張卡牌", Rarity.COMMON, SpellType.DRAW));
        addSpell(new SpellCard("食材採購", 3, "抽兩張卡牌", Rarity.COMMON, SpellType.DRAW));
        addSpell(new SpellCard("美食評論", 2, "對目標造成2點傷害", Rarity.COMMON, SpellType.DAMAGE));
    }
    
    /**
     * 初始化角色卡
     */
    private static void initializeCharacters() {
        // 主食類角色
        addCharacter(new CharacterCard("白飯戰士", 2, "能量充沛的基本主食，可以搭配各種料理", Rarity.COMMON, 2, 2, 3, true));
        addCharacter(new CharacterCard("全麥麵包", 3, "富含纖維的健康選擇，防禦力特別高", Rarity.COMMON, 1, 4, 4, false));
        addCharacter(new CharacterCard("義大利麵", 4, "彈性十足的面條，攻防均衡", Rarity.COMMON, 3, 2, 4, true));
        
        // 肉類角色
        addCharacter(new CharacterCard("牛排勇士", 5, "高蛋白質的肌肉型角色，攻擊力驚人", Rarity.RARE, 5, 1, 4, true));
        addCharacter(new CharacterCard("雞腿騎士", 4, "靈活多變的家禽，速度快且攻擊優秀", Rarity.RARE, 4, 1, 3, true));
        addCharacter(new CharacterCard("豬肉劍士", 4, "全能型角色，攻防均衡", Rarity.RARE, 3, 3, 4, true));
        
        // 海鮮類角色
        addCharacter(new CharacterCard("鮭魚刺客", 6, "富含omega-3的高級食材，特殊攻擊能力強", Rarity.EPIC, 5, 1, 4, true));
        addCharacter(new CharacterCard("龍蝦將軍", 7, "堅硬外殼的高級食材，防禦力極高", Rarity.EPIC, 4, 6, 6, false));
        addCharacter(new CharacterCard("章魚智者", 6, "多觸手生物，能同時執行多種技能", Rarity.EPIC, 3, 3, 5, false));
        
        // 蔬菜類角色
        addCharacter(new CharacterCard("青椒射手", 2, "富含維他命C的綠色蔬菜，遠程攻擊專家", Rarity.COMMON, 3, 0, 2, true));
        addCharacter(new CharacterCard("洋蔥衛士", 3, "層層防護的蔬菜，防禦特化", Rarity.COMMON, 1, 5, 3, false));
        addCharacter(new CharacterCard("胡蘿蔔刺客", 3, "視力絕佳的橙色根莖，精準打擊", Rarity.COMMON, 4, 0, 2, true));
        
        // 水果類角色
        addCharacter(new CharacterCard("蘋果法師", 4, "每日一蘋果，醫生遠離我，具有治療能力", Rarity.RARE, 2, 2, 4, false));
        addCharacter(new CharacterCard("香蕉戰士", 3, "彎曲的黃色水果，靈活的戰鬥風格", Rarity.COMMON, 3, 1, 3, true));
        addCharacter(new CharacterCard("西瓜守衛", 5, "厚實外殼的大型水果，極高生命值", Rarity.RARE, 2, 3, 7, false));
        
        // 傳說級角色
        addCharacter(new CharacterCard("松露皇帝", 8, "珍稀名貴的食材之王，全能型最強角色", Rarity.LEGENDARY, 7, 5, 8, true));
        addCharacter(new CharacterCard("神級壽司", 8, "集合多種頂級食材的完美組合，均衡型傳說角色", Rarity.LEGENDARY, 6, 6, 7, true));
        addCharacter(new CharacterCard("和牛統帥", 9, "油花分佈完美的頂級牛肉，強力攻擊型", Rarity.LEGENDARY, 9, 2, 6, true));
    }
    
    /**
     * 初始化場地卡（整合原烹飪技術卡和料理工具卡）
     */
    private static void initializeFieldCards() {
        // 烹飪技術類場地卡
        addFieldCard(FieldCard.createTechniqueField("切丁技巧", 1, "將食材切成均勻小塊，提升角色攻擊力", Rarity.COMMON, 
                                   FieldEffectType.BOOST_ATTACK, 2, 2));
        addFieldCard(FieldCard.createTechniqueField("攪拌手法", 2, "均勻混合所有食材，提升團隊協作", Rarity.COMMON,
                                   FieldEffectType.BOOST_DEFENSE, 2, 2));
        
        // 熱處理技術類場地卡
        addFieldCard(FieldCard.createTechniqueField("火烤技術", 3, "用明火烤製食材，大幅提升攻擊力", Rarity.COMMON, 
                                   FieldEffectType.BOOST_ATTACK, 3, 3));
        addFieldCard(FieldCard.createTechniqueField("油炸方法", 4, "高溫油炸，形成酥脆外殼，增加防禦力", Rarity.COMMON,
                                   FieldEffectType.BOOST_DEFENSE, 4, 2));
        addFieldCard(FieldCard.createTechniqueField("燉煮技術", 4, "慢火燉煮，釋放食材精華，回復生命值", Rarity.COMMON,
                                  FieldEffectType.HEAL, 5, 0));
        
        // 冷處理技術類場地卡
        addFieldCard(FieldCard.createTechniqueField("醃漬技術", 3, "冷藏醃製食材，增加防禦力和保存時間", Rarity.COMMON,
                                   FieldEffectType.BOOST_DEFENSE, 3, 4));
        addFieldCard(FieldCard.createTechniqueField("冰鎮手法", 2, "急速冷卻，保持食材新鮮度，回復生命", Rarity.COMMON,
                                  FieldEffectType.HEAL, 3, 0));
        
        // 攻擊性技術類場地卡
        addFieldCard(FieldCard.createTechniqueField("刀工切片", 3, "精準切片技術，對敵方角色造成傷害", Rarity.RARE,
                                  FieldEffectType.DAMAGE, 4, 0));
        addFieldCard(FieldCard.createTechniqueField("壓榨技術", 4, "擠壓出食材精華，造成範圍傷害", Rarity.RARE,
                                  FieldEffectType.DAMAGE, 3, 0));
        
        // 料理工具類場地卡 - 使用新的FieldEffectType
        addFieldCard(FieldCard.createToolField("鋒利菜刀", 3, "專業主廚用刀，提高攻擊力", Rarity.COMMON, 
                                   FieldEffectType.OFFENSIVE, 3, 2));
        addFieldCard(FieldCard.createToolField("不鏽鋼鍋", 4, "耐用的烹飪鍋具，提高防禦力", Rarity.COMMON,
                                   FieldEffectType.DEFENSIVE, 4, 3));
        addFieldCard(FieldCard.createToolField("多功能攪拌機", 5, "現代廚房的必備工具，有多種用途", Rarity.RARE,
                                   FieldEffectType.UTILITY, 3, 4));
        
        // 新增幾張使用擴展效果類型的場地卡
        addFieldCard(FieldCard.createToolField("教學烹飪書", 2, "詳細的烹飪指南，輔助新手廚師", Rarity.COMMON,
                                   FieldEffectType.SUPPORTIVE, 4, 2));
        addFieldCard(FieldCard.createToolField("辣椒調味料", 3, "使敵方角色暫時失去味覺", Rarity.RARE,
                                   FieldEffectType.DISRUPTIVE, 2, 3));
        addFieldCard(FieldCard.createToolField("食材儲藏櫃", 4, "儲存額外的食材以備不時之需", Rarity.RARE,
                                   FieldEffectType.ECONOMIC, 5, 2));
        addFieldCard(FieldCard.createToolField("食譜筆記本", 3, "記錄各種秘方，提供多樣化策略", Rarity.EPIC,
                                   FieldEffectType.STRATEGIC, 3, 3));
        
        // 環境類場地卡
        addFieldCard(FieldCard.createEnvironmentField("專業廚房", 5, "設備齊全的現代廚房，提高所有角色能力", Rarity.RARE, 3));
        addFieldCard(FieldCard.createEnvironmentField("露營烹飪", 3, "戶外料理場地，增加角色韌性", Rarity.COMMON, 2));
        addFieldCard(FieldCard.createEnvironmentField("高級餐廳", 6, "正式的烹飪環境，提供細緻的料理體驗", Rarity.EPIC, 4));
    }
    
    /**
     * 添加隨從卡到圖鑑
     */
    private static void addMinion(Minion minion) {
        allCards.put(minion.getName(), minion);
        allMinions.add(minion);
    }
    
    /**
     * 添加法術卡到圖鑑
     */
    private static void addSpell(SpellCard spell) {
        allCards.put(spell.getName(), spell);
        allSpells.add(spell);
    }
    
    /**
     * 添加角色卡到圖鑑
     */
    private static void addCharacter(CharacterCard character) {
        allCards.put(character.getName(), character);
        allCharacters.add(character);
    }
    
    /**
     * 添加場地卡到圖鑑
     */
    private static void addFieldCard(FieldCard fieldCard) {
        allCards.put(fieldCard.getName(), fieldCard);
        allFieldCards.add(fieldCard);
    }
    
    /**
     * 顯示卡牌圖鑑介面
     */
    public static void showLibrary() {
        Scanner scanner = new Scanner(System.in);
        
        // 檢查圖鑑是否為空
        if (allCards.isEmpty()) {
            System.out.println("卡牌圖鑑為空，正在初始化...");
            initialize();
            
            // 檢查初始化後的狀態
            if (allCards.isEmpty()) {
                System.out.println("錯誤：無法初始化卡牌圖鑑！");
                System.out.println("按Enter返回...");
                scanner.nextLine();
                return;
            }
        }
        
        while (true) {
            System.out.println("\n======= 卡牌圖鑑 =======");
            System.out.println("卡牌總數: " + allCards.size() + " 張");
            System.out.println("1. 瀏覽所有隨從卡 (" + allMinions.size() + " 張)");
            System.out.println("2. 瀏覽所有法術卡 (" + allSpells.size() + " 張)");
            System.out.println("3. 瀏覽所有角色卡 (" + allCharacters.size() + " 張)");
            System.out.println("4. 瀏覽所有場地卡 (" + allFieldCards.size() + " 張)");
            System.out.println("5. 搜尋卡牌");
            System.out.println("6. 查看場上角色詳情");
            System.out.println("7. 查看玩家手牌");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            switch (choice) {
                case 0:
                    return;
                case 1:
                    browseMinions();
                    break;
                case 2:
                    browseSpells();
                    break;
                case 3:
                    browseCharacters();
                    break;
                case 4:
                    browseFieldCards();
                    break;
                case 5:
                    searchCard(scanner);
                    break;
                case 6:
                    showBattlefieldMinions();
                    break;
                case 7:
                    showPlayerHands();
                    break;
                default:
                    System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 瀏覽所有隨從卡
     */
    private static void browseMinions() {
        Scanner scanner = new Scanner(System.in);
        
        if (allMinions.isEmpty()) {
            System.out.println("\n目前沒有隨從卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n隨從卡列表 (共 " + allMinions.size() + " 張):");
            for (int i = 0; i < allMinions.size(); i++) {
                Minion minion = allMinions.get(i);
                System.out.printf("%2d. %-15s [費用:%d, 攻擊力:%d, 生命值:%d] %s\n", 
                        i+1, minion.getName(), minion.getTokenCost(), 
                        minion.getAttack(), minion.getHealth(), 
                        getRaritySymbol(minion.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= allMinions.size()) {
                allMinions.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine(); // 消耗前面的數字
                scanner.nextLine(); // 等待Enter
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 瀏覽所有法術卡
     */
    private static void browseSpells() {
        Scanner scanner = new Scanner(System.in);
        
        if (allSpells.isEmpty()) {
            System.out.println("\n目前沒有法術卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n法術卡列表 (共 " + allSpells.size() + " 張):");
            for (int i = 0; i < allSpells.size(); i++) {
                SpellCard spell = allSpells.get(i);
                System.out.printf("%2d. %-15s [費用:%d] %s\n", 
                        i+1, spell.getName(), spell.getTokenCost(), 
                        getRaritySymbol(spell.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= allSpells.size()) {
                allSpells.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine(); // 消耗前面的數字
                scanner.nextLine(); // 等待Enter
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 瀏覽所有角色卡
     */
    private static void browseCharacters() {
        Scanner scanner = new Scanner(System.in);
        
        if (allCharacters.isEmpty()) {
            System.out.println("\n目前沒有角色卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n角色卡列表 (共 " + allCharacters.size() + " 張):");
            for (int i = 0; i < allCharacters.size(); i++) {
                CharacterCard character = allCharacters.get(i);
                System.out.printf("%2d. %-15s [費用:%d, 攻擊力:%d, 生命值:%d] %s\n", 
                        i+1, character.getName(), character.getTokenCost(), 
                        character.getAttack(), character.getCurrentHealth(), 
                        getRaritySymbol(character.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= allCharacters.size()) {
                allCharacters.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine(); // 消耗前面的數字
                scanner.nextLine(); // 等待Enter
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 瀏覽所有場地卡
     */
    private static void browseFieldCards() {
        Scanner scanner = new Scanner(System.in);
        
        if (allFieldCards.isEmpty()) {
            System.out.println("場地卡列表為空!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        System.out.println("\n===== 場地卡列表 =====");
        for (int i = 0; i < allFieldCards.size(); i++) {
            FieldCard card = allFieldCards.get(i);
            
            String fieldTypeInfo = "";
            switch (card.getFieldType()) {
                case COOKING_TECHNIQUE:
                    fieldTypeInfo = "[烹飪技術]";
                    break;
                case COOKING_TOOL:
                    fieldTypeInfo = "[料理工具]";
                    break;
                case ENVIRONMENT:
                    fieldTypeInfo = "[環境]";
                    break;
            }
            
            System.out.printf("%2d. %-18s [費用:%d] %s %s\n", 
                    i+1, card.getName(), card.getTokenCost(), 
                    fieldTypeInfo, getRaritySymbol(card.getRarity()));
        }
        
        System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice > 0 && choice <= allFieldCards.size()) {
                allFieldCards.get(choice-1).displayCardDetails();
                System.out.println("\n按Enter繼續...");
                scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println("請輸入有效的數字!");
        }
    }
    
    /**
     * 搜尋卡牌
     */
    private static void searchCard(Scanner scanner) {
        System.out.print("請輸入卡牌名稱關鍵字: ");
        String keyword = scanner.nextLine().trim();
        
        if (keyword.isEmpty()) {
            System.out.println("搜尋關鍵字不能為空!");
            return;
        }
        
        List<Card> results = new ArrayList<>();
        
        // 搜尋含有關鍵字的卡牌
        for (Card card : allCards.values()) {
            if (card.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(card);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("沒有找到含有「" + keyword + "」的卡牌!");
            return;
        }
        
        while (true) {
            System.out.println("\n搜尋結果 (共 " + results.size() + " 張):");
            for (int i = 0; i < results.size(); i++) {
                Card card = results.get(i);
                System.out.printf("%2d. %-15s [費用:%d] %s\n", 
                        i+1, card.getName(), card.getTokenCost(), 
                        getRaritySymbol(card.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= results.size()) {
                results.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine(); // 消耗前面的數字
                scanner.nextLine(); // 等待Enter
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 查看場上隨從詳情
     */
    private static void showBattlefieldMinions() {
        Scanner scanner = new Scanner(System.in);
        
        // 獲取當前遊戲雙方玩家
        com.example.game.player.Player player1 = com.example.game.FOODGameEngine.getPlayer1();
        com.example.game.player.Player player2 = com.example.game.FOODGameEngine.getPlayer2();
        
        if (player1 == null || player2 == null) {
            System.out.println("遊戲尚未開始或無法獲取玩家信息");
            return;
        }
        
        while (true) {
            System.out.println("\n======= 場上隨從詳情 =======");
            System.out.println("1. 查看 " + player1.getName() + " 的場上隨從");
            System.out.println("2. 查看 " + player2.getName() + " 的場上隨從");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 1) {
                showPlayerMinions(player1);
            } else if (choice == 2) {
                showPlayerMinions(player2);
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 顯示玩家場上隨從的詳細信息
     */
    private static void showPlayerMinions(com.example.game.player.Player player) {
        Scanner scanner = new Scanner(System.in);
        // 使用F.O.O.D系統的方法獲取場上角色
        List<CharacterCard> characters = player.getBattlefieldZone().getCharacters();
        
        if (characters.isEmpty()) {
            System.out.println(player.getName() + " 的場上沒有角色");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n" + player.getName() + " 的場上角色:");
            for (int i = 0; i < characters.size(); i++) {
                CharacterCard character = characters.get(i);
                System.out.printf("%2d. %-15s [攻擊力:%d, 生命值:%d/%d] %s\n", 
                        i+1, character.getName(), character.getAttack(), 
                        character.getCurrentHealth(), character.getMaxHealth(), 
                        getCharacterSpecialEffects(character));
            }
            
            System.out.println("\n輸入角色編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= characters.size()) {
                characters.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 獲取角色的特殊效果描述
     */
    private static String getCharacterSpecialEffects(CharacterCard character) {
        StringBuilder effects = new StringBuilder();
        
        if (character.canAttack()) {
            effects.append("可攻擊 ");
        } else {
            effects.append("已消耗 ");
        }
        
        // 可以添加更多特殊效果判斷
        
        return effects.toString().trim();
    }
    
    /**
     * 根據稀有度返回顯示符號
     */
    private static String getRaritySymbol(Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return "★";
            case RARE:
                return "★★";
            case EPIC:
                return "★★★";
            case LEGENDARY:
                return "★★★★";
            default:
                return "";
        }
    }
    
    /**
     * 根據名稱獲取卡牌
     */
    public static Card getCardByName(String name) {
        return allCards.get(name);
    }
    
    /**
     * 獲取所有隨從卡
     */
    public static List<Minion> getAllMinions() {
        return allMinions;
    }
    
    /**
     * 獲取所有法術卡
     */
    public static List<SpellCard> getAllSpells() {
        return allSpells;
    }
    
    /**
     * 獲取所有角色卡
     */
    public static List<CharacterCard> getAllCharacters() {
        return allCharacters;
    }
    
    /**
     * 獲取所有場地卡
     */
    public static List<FieldCard> getAllFieldCards() {
        return allFieldCards;
    }
    
    /**
     * 查看玩家手牌
     */
    private static void showPlayerHands() {
        Scanner scanner = new Scanner(System.in);
        
        // 獲取當前遊戲中的玩家
        com.example.game.player.Player player1 = com.example.game.FOODGameEngine.getPlayer1();
        com.example.game.player.Player player2 = com.example.game.FOODGameEngine.getPlayer2();
        
        if (player1 == null || player2 == null) {
            System.out.println("遊戲尚未開始或無法獲取玩家信息");
            return;
        }
        
        while (true) {
            System.out.println("\n======= 玩家手牌 =======");
            
            // 顯示雙方玩家選項
            System.out.println("1. 查看 " + player1.getName() + " 的手牌");
            System.out.println("2. 查看 " + player2.getName() + " 的手牌");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 1) {
                showPlayerCards(player1);
            } else if (choice == 2) {
                showPlayerCards(player2);
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 顯示玩家手牌的詳細信息
     */
    private static void showPlayerCards(com.example.game.player.Player player) {
        Scanner scanner = new Scanner(System.in);
        List<Card> cards = player.getHand();
        
        if (cards.isEmpty()) {
            System.out.println(player.getName() + " 的手牌為空");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n" + player.getName() + " 的手牌:");
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                if (card instanceof Minion) {
                    Minion minion = (Minion) card;
                    System.out.printf("%2d. %-15s [費用:%d 攻擊力:%d 生命值:%d] %s\n", 
                            i+1, minion.getName(), minion.getTokenCost(), 
                            minion.getAttack(), minion.getHealth(), 
                            getRaritySymbol(minion.getRarity()));
                } else if (card instanceof SpellCard) {
                    SpellCard spell = (SpellCard) card;
                    System.out.printf("%2d. %-15s [費用:%d] (法術) %s\n", 
                            i+1, spell.getName(), spell.getTokenCost(), 
                            getRaritySymbol(spell.getRarity()));
                } else if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    System.out.printf("%2d. %-15s [費用:%d, 攻擊力:%d, 生命值:%d] %s\n", 
                            i+1, character.getName(), character.getTokenCost(), 
                            character.getAttack(), character.getCurrentHealth(), 
                            getRaritySymbol(character.getRarity()));
                } else if (card instanceof FieldCard) {
                    FieldCard fieldCard = (FieldCard) card;
                    String fieldTypeInfo = "";
                    switch (fieldCard.getFieldType()) {
                        case COOKING_TECHNIQUE:
                            fieldTypeInfo = "[烹飪技術]";
                            break;
                        case COOKING_TOOL:
                            fieldTypeInfo = "[料理工具]";
                            break;
                        case ENVIRONMENT:
                            fieldTypeInfo = "[環境]";
                            break;
                    }
                    System.out.printf("%2d. %-15s [費用:%d] %s %s\n", 
                            i+1, fieldCard.getName(), fieldCard.getTokenCost(), 
                            fieldTypeInfo, getRaritySymbol(fieldCard.getRarity()));
                }
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= cards.size()) {
                cards.get(choice-1).displayCardDetails();
                
                // 查看完後暫停一下
                System.out.println("按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
} 