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
    private static List<TechniqueCard> allTechniques = new ArrayList<>();
    
    /**
     * 初始化卡牌圖鑑
     */
    public static void initialize() {
        // 初始化一些預設卡牌
        initializeMinions();
        initializeSpells();
        initializeCharacters();
        initializeTechniques();
        
        System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
    }
    
    /**
     * 初始化隨從卡
     */
    private static void initializeMinions() {
        // 保持空方法但不再添加隨從卡
    }
    
    /**
     * 初始化法術卡
     */
    private static void initializeSpells() {
        // 保持空方法但不再添加法術卡
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
     * 初始化烹飪技術卡
     */
    private static void initializeTechniques() {
        // 基本烹飪技術
        addTechnique(new TechniqueCard("切丁技巧", 1, "將食材切成均勻小塊，提升角色攻擊力", Rarity.COMMON, 
                                   TechniqueType.BOOST_ATTACK, 2, 2));
        addTechnique(new TechniqueCard("攪拌手法", 2, "均勻混合所有食材，提升團隊協作", Rarity.COMMON,
                                   TechniqueType.BOOST_DEFENSE, 2, 2));
        
        // 熱處理技術
        addTechnique(new TechniqueCard("火烤技術", 3, "用明火烤製食材，大幅提升攻擊力", Rarity.COMMON, 
                                   TechniqueType.BOOST_ATTACK, 3, 3));
        addTechnique(new TechniqueCard("油炸方法", 4, "高溫油炸，形成酥脆外殼，增加防禦力", Rarity.COMMON,
                                   TechniqueType.BOOST_DEFENSE, 4, 2));
        addTechnique(new TechniqueCard("燉煮技術", 4, "慢火燉煮，釋放食材精華，回復生命值", Rarity.COMMON,
                                  TechniqueType.HEAL, 5, 0));
        
        // 冷處理技術
        addTechnique(new TechniqueCard("醃漬技術", 3, "冷藏醃製食材，增加防禦力和保存時間", Rarity.COMMON,
                                   TechniqueType.BOOST_DEFENSE, 3, 4));
        addTechnique(new TechniqueCard("冰鎮手法", 2, "急速冷卻，保持食材新鮮度，回復生命", Rarity.COMMON,
                                  TechniqueType.HEAL, 3, 0));
        
        // 攻擊性技術
        addTechnique(new TechniqueCard("刀工切片", 3, "精準切片技術，對敵方角色造成傷害", Rarity.RARE,
                                  TechniqueType.DAMAGE, 4, 0));
        addTechnique(new TechniqueCard("壓榨技術", 4, "擠壓出食材精華，造成範圍傷害", Rarity.RARE,
                                  TechniqueType.DAMAGE, 3, 0));
        
        // 特殊技術
        addTechnique(new TechniqueCard("調味技巧", 1, "精確調味，強化食材風味，抽取卡牌", Rarity.RARE,
                                  TechniqueType.DRAW, 2, 0));
        addTechnique(new TechniqueCard("擺盤藝術", 2, "美觀的料理呈現，吸引目光，抽取卡牌", Rarity.RARE,
                                  TechniqueType.DRAW, 1, 0));
        
        // 高級技術
        addTechnique(new TechniqueCard("分子料理", 7, "運用科學原理改變食材形態，產生特殊效果", Rarity.EPIC,
                                  TechniqueType.SPECIAL, 0, 2));
        addTechnique(new TechniqueCard("真空低溫烹調", 6, "精確控溫烹飪，完美保留食材精華，全方位增強", Rarity.EPIC,
                                  TechniqueType.SPECIAL, 0, 3));
        
        // 傳說技術
        addTechnique(new TechniqueCard("米其林三星技法", 8, "只有頂級主廚才能掌握的烹飪秘技，強大全場效果", Rarity.LEGENDARY,
                                  TechniqueType.SPECIAL, 0, 3));
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
     * 添加烹飪技術卡到圖鑑
     */
    private static void addTechnique(TechniqueCard technique) {
        allCards.put(technique.getName(), technique);
        allTechniques.add(technique);
    }
    
    /**
     * 顯示卡牌圖鑑介面
     */
    public static void showLibrary() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n======= 卡牌圖鑑 =======");
            System.out.println("1. 瀏覽所有隨從卡");
            System.out.println("2. 瀏覽所有法術卡");
            System.out.println("3. 瀏覽所有角色卡");
            System.out.println("4. 瀏覽所有烹飪技術卡");
            System.out.println("5. 搜尋卡牌");
            System.out.println("6. 查看場上隨從詳情");
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
                    browseTechniques();
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
     * 瀏覽所有烹飪技術卡
     */
    private static void browseTechniques() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n烹飪技術卡列表 (共 " + allTechniques.size() + " 張):");
            for (int i = 0; i < allTechniques.size(); i++) {
                TechniqueCard technique = allTechniques.get(i);
                System.out.printf("%2d. %-15s [費用:%d] %s\n", 
                        i+1, technique.getName(), technique.getTokenCost(), 
                        getRaritySymbol(technique.getRarity()));
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= allTechniques.size()) {
                allTechniques.get(choice-1).displayCardDetails();
                
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
     * 獲取所有烹飪技術卡
     */
    public static List<TechniqueCard> getAllTechniques() {
        return allTechniques;
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
                } else if (card instanceof TechniqueCard) {
                    TechniqueCard technique = (TechniqueCard) card;
                    System.out.printf("%2d. %-15s [費用:%d] (技術) %s\n", 
                            i+1, technique.getName(), technique.getTokenCost(), 
                            getRaritySymbol(technique.getRarity()));
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