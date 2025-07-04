package com.example.game.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.example.game.card.faction.DessertUnionInitializer;
import com.example.game.card.faction.FactionCardInitializer;
import com.example.game.card.faction.FastFoodGuildInitializer;
import com.example.game.card.faction.HealthyOasisInitializer;
import com.example.game.card.faction.NeutralCardInitializer;
import com.example.game.card.faction.SpicyKingdomInitializer;
import com.example.game.player.Player;

/**
 * 卡牌圖鑑 - 管理所有可用的卡牌
 */
public class CardLibrary {
    private static Map<String, Card> allCards = new HashMap<>();
    private static List<SpellCard> allSpells = new ArrayList<>();
    private static List<CharacterCard> allCharacters = new ArrayList<>();
    private static List<FieldCard> allFieldCards = new ArrayList<>();
    private static List<CastleCard> allCastles = new ArrayList<>(); // 添加城堡卡列表
    
    /**
     * 初始化卡牌圖鑑
     */
    public static void initialize() {
        // 先清空現有卡牌，防止重複初始化
        allCards.clear();
        allSpells.clear();
        allCharacters.clear();
        allFieldCards.clear();
        allCastles.clear(); // 清空城堡卡列表
        
        // 使用各陣營的初始化器類來初始化卡牌
        FactionCardInitializer[] initializers = {
            new SpicyKingdomInitializer(),     // 火辣王國
            new HealthyOasisInitializer(),     // 健康綠洲
            new FastFoodGuildInitializer(),    // 速食工會
            new DessertUnionInitializer(),     // 甜點聯盟
            new NeutralCardInitializer()       // 中立
        };
        
        // 依次執行各陣營的初始化
        for (FactionCardInitializer initializer : initializers) {
            initializer.initializeCards(allCards, allCharacters, allSpells, allFieldCards, allCastles);
        }
        
        System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
        System.out.println("其中角色卡: " + allCharacters.size() + " 張，場地卡: " + allFieldCards.size() + " 張，法術卡: " + allSpells.size() + " 張，城堡卡: " + allCastles.size() + " 張");
    }
    
    /**
     * 遊戲開始時初始化玩家的城堡卡
     */
    public static void initializePlayerCastle(Player player) {
        CastleCard castle = player.getCastle();
        if (castle != null) {
            castle.initialize();
        }
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
            System.out.println("1. 瀏覽所有法術卡 (" + allSpells.size() + " 張)");
            System.out.println("2. 瀏覽所有角色卡 (" + allCharacters.size() + " 張)");
            System.out.println("3. 瀏覽所有場地卡 (" + allFieldCards.size() + " 張)");
            System.out.println("4. 按陣營瀏覽卡牌");
            System.out.println("5. 按關鍵字瀏覽卡牌");
            System.out.println("6. 搜尋卡牌");
            System.out.println("7. 查看玩家手牌");
            System.out.println("8. 瀏覽所有城堡卡 (" + allCastles.size() + " 張)");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            switch (choice) {
                case 0:
                    return;
                case 1:
                    browseSpells();
                    break;
                case 2:
                    browseCharacters();
                    break;
                case 3:
                    browseFieldCards();
                    break;
                case 4:
                    browseFactions(scanner);
                    break;
                case 5:
                    browseByKeywords(scanner);
                    break;
                case 6:
                    searchCard(scanner);
                    break;
                case 7:
                    showPlayerHands();
                    break;
                case 8:
                    browseCastleCards();
                    break;
                default:
                    System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 按陣營瀏覽卡牌
     */
    private static void browseFactions(Scanner scanner) {
        while (true) {
            System.out.println("\n======= 選擇陣營 =======");
            System.out.println("1. 火辣王國 (Spicy Kingdom)");
            System.out.println("2. 健康綠洲 (Healthy Oasis)");
            System.out.println("3. 速食工會 (Fast Food Guild)");
            System.out.println("4. 甜點聯盟 (Dessert Union)");
            System.out.println("5. 中立 (Neutral)");
            System.out.println("6. 顯示所有陣營的城堡卡");
            System.out.println("0. 返回");
            System.out.print("請選擇陣營: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice == 6) {
                // 顯示所有陣營的城堡卡
                browseCastleCards();
                continue;
            }
            
            Faction selectedFaction = null;
            switch (choice) {
                case 1:
                    selectedFaction = Faction.SPICY_KINGDOM;
                    break;
                case 2:
                    selectedFaction = Faction.HEALTHY_OASIS;
                    break;
                case 3:
                    selectedFaction = Faction.FAST_FOOD_GUILD;
                    break;
                case 4:
                    selectedFaction = Faction.DESSERT_UNION;
                    break;
                case 5:
                    selectedFaction = Faction.NEUTRAL;
                    break;
                default:
                System.out.println("無效的選擇!");
                    continue;
            }
            
            browseByFaction(selectedFaction, scanner);
        }
    }
    
    /**
     * 瀏覽特定陣營的卡牌
     */
    private static void browseByFaction(Faction faction, Scanner scanner) {
        // 獲取指定陣營的所有卡牌
        List<Card> factionCards = allCards.values().stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList());
        
        if (factionCards.isEmpty()) {
            System.out.println("\n該陣營沒有卡牌!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        // 分類該陣營的卡牌
        List<CharacterCard> characters = factionCards.stream()
                .filter(card -> card instanceof CharacterCard)
                .map(card -> (CharacterCard) card)
                .collect(Collectors.toList());
        
        List<FieldCard> fields = factionCards.stream()
                .filter(card -> card instanceof FieldCard)
                .map(card -> (FieldCard) card)
                .collect(Collectors.toList());
        
        List<SpellCard> spells = factionCards.stream()
                .filter(card -> card instanceof SpellCard)
                .map(card -> (SpellCard) card)
                .collect(Collectors.toList());
        
        while (true) {
            System.out.println("\n======= " + faction.getLocalizedName() + " (" + faction.getEnglishName() + ") =======");
            System.out.println("該陣營卡牌總數: " + factionCards.size() + " 張");
            System.out.println("1. 瀏覽角色卡 (" + characters.size() + " 張)");
            System.out.println("2. 瀏覽場地卡 (" + fields.size() + " 張)");
            System.out.println("3. 瀏覽法術卡 (" + spells.size() + " 張)");
            System.out.println("0. 返回");
            System.out.print("請選擇: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            }
            
            switch (choice) {
                case 1:
                    browseCardList(characters, "角色卡", scanner);
                    break;
                case 2:
                    browseCardList(fields, "場地卡", scanner);
                    break;
                case 3:
                    browseCardList(spells, "法術卡", scanner);
                    break;
                default:
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 按關鍵字瀏覽卡牌
     */
    private static void browseByKeywords(Scanner scanner) {
        while (true) {
            System.out.println("\n======= 選擇關鍵字 =======");
            System.out.println("通用關鍵字:");
            System.out.println("1. 開胃 (Appetizer) - 進場時發動效果");
            System.out.println("2. 回味 (Aftertaste) - 死亡後觸發效果");
            System.out.println("3. 拼盤 (Platter) - 符合條件的卡片都在場時，可免費打出融合卡");
            System.out.println("4. 彈牙 (Chewy Bite) - 每回合可攻擊 2 次");
            System.out.println("5. 酥脆 (Crispy) - 護甲值，減免相應點數的傷害");
            System.out.println("6. 擺盤 (Garnished) - 敵人必須優先攻擊此單位");
            
            System.out.println("\n陣營特定關鍵字:");
            System.out.println("7. 現炸 (Sizzle) - 速食工會：進場當回合即可攻擊");
            System.out.println("8. 油膩 (Greasy) - 速食工會：每回合攻擊力減少 1（最低降至 1）");
            System.out.println("9. 糖霜 (Frosted) - 甜點聯盟：抵擋一次攻擊");
            System.out.println("10. 糖爆 (Sugar Rush) - 甜點聯盟：可選糖爆的行動代替攻擊，但下回合無法攻擊或使用技能");
            System.out.println("11. 滋補 (Hearty) - 健康綠洲：回合結束時恢復全滿血量");
            System.out.println("12. 清淡 (Bland) - 健康綠洲：滿血時無法攻擊");
            System.out.println("13. 爆炒 (Sear) - 火辣王國：直接消滅一個單位");
            System.out.println("14. 嗆辣 (Fiery) - 火辣王國：每回合結束損失一點生命值");
            System.out.println("0. 返回");
            System.out.print("請選擇關鍵字: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
            return;
        }
        
            String keyword = getKeywordByChoice(choice);
            if (keyword == null) {
                System.out.println("無效的選擇!");
                continue;
            }
            
            // 查找含有特定關鍵字的卡牌
            List<Card> keywordCards = allCards.values().stream()
                    .filter(card -> card.getDescription().contains(keyword))
                    .collect(Collectors.toList());
            
            browseCardList(keywordCards, "含有 [" + keyword + "] 關鍵字的卡牌", scanner);
        }
    }
    
    /**
     * 根據選擇獲取關鍵字
     */
    private static String getKeywordByChoice(int choice) {
        switch (choice) {
            case 1: return "【開胃】";
            case 2: return "【回味】";
            case 3: return "【拼盤】";
            case 4: return "【彈牙】";
            case 5: return "【酥脆】";
            case 6: return "【擺盤】";
            case 7: return "【現炸】";
            case 8: return "【油膩】";
            case 9: return "【糖霜】";
            case 10: return "【糖爆】";
            case 11: return "【滋補】";
            case 12: return "【清淡】";
            case 13: return "【爆炒】";
            case 14: return "【嗆辣】";
            default: return null;
        }
    }
    
    /**
     * 瀏覽卡牌列表
     */
    private static <T extends Card> void browseCardList(List<T> cards, String title, Scanner scanner) {
        if (cards.isEmpty()) {
            System.out.println("\n沒有" + title + "可以瀏覽!");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        while (true) {
            System.out.println("\n======= " + title + " (共 " + cards.size() + " 張) =======");
            
            for (int i = 0; i < cards.size(); i++) {
                Card card = cards.get(i);
                String cardInfo = String.format("%2d. %-20s [費用:%d", (i + 1), card.getName(), card.getCost());
                
                if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    cardInfo += String.format(", 攻:%d, 防:%d, 生命:%d", 
                            character.getAttack(), character.getMaxHealth(), character.getCurrentHealth());
                }
                
                cardInfo += String.format("] %s - %s", 
                        getRaritySymbol(card.getRarity()), card.getFaction().getLocalizedName());
                
                System.out.println(cardInfo);
            }
            
            System.out.println("\n輸入卡牌編號查看詳情，或輸入0返回: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除輸入緩衝
            
            if (choice == 0) {
                return;
            } else if (choice > 0 && choice <= cards.size()) {
                cards.get(choice - 1).displayCardDetails();
                
                // 提取並顯示關鍵字
                displayKeywords(cards.get(choice - 1).getDescription());
                
                // 查看完後暫停一下
                System.out.println("\n按Enter繼續...");
                scanner.nextLine();
            } else {
                System.out.println("無效的選擇!");
            }
        }
    }
    
    /**
     * 提取並顯示關鍵字及其效果
     */
    private static void displayKeywords(String description) {
        System.out.println("\n------ 關鍵字效果 ------");
        
        // 檢查並顯示各種關鍵字
        if (description.contains("【開胃】")) {
            System.out.println("【開胃】(Appetizer): 進場時發動效果");
        }
        if (description.contains("【回味】")) {
            System.out.println("【回味】(Aftertaste): 死亡後觸發效果");
        }
        if (description.contains("【拼盤】")) {
            System.out.println("【拼盤】(Platter): 符合條件的卡片都在場時，可免費打出融合卡（但還是算出一張牌）");
        }
        if (description.contains("【彈牙】")) {
            System.out.println("【彈牙】(Chewy): 每回合可攻擊 2 次");
        }
        if (description.contains("【酥脆】")) {
            // 從卡片描述中提取護甲值
            String armorValueStr = "";
            int armorValue = 1; // 預設護甲值
            if (description.matches(".*【酥脆】\\s*\\((\\d+)\\).*")) {
                armorValueStr = description.replaceAll(".*【酥脆】\\s*\\((\\d+)\\).*", "$1");
                try {
                    armorValue = Integer.parseInt(armorValueStr);
                } catch (NumberFormatException e) {
                    // 解析失敗時使用預設值
                }
            }
            System.out.println("【酥脆】(Crispy): 護甲值" + armorValue + "，減免" + armorValue + "點傷害");
        }
        if (description.contains("【擺盤】")) {
            System.out.println("【擺盤】(Garnished): 敵人必須優先攻擊這個單位");
        }
        if (description.contains("【現炸】")) {
            System.out.println("【現炸】(Sizzle): 進場當回合即可攻擊");
        }
        if (description.contains("【油膩】")) {
            System.out.println("【油膩】(Greasy): 每回合開始時攻擊力減少 1（最低降至 1）");
        }
        if (description.contains("【糖霜】")) {
            System.out.println("【糖霜】(Frosted): 抵擋一次攻擊");
        }
        if (description.contains("【糖爆】")) {
            System.out.println("【糖爆】(Sugar Rush): 執行文字效果，下回合無法攻擊與無法使用糖爆");
            
            // 提取糖爆效果描述
            Pattern sugarRushPattern = Pattern.compile("【糖爆】：([^。]+)[。]?");
            Matcher sugarRushMatcher = sugarRushPattern.matcher(description);
            if (sugarRushMatcher.find()) {
                String effectText = sugarRushMatcher.group(1);
                System.out.println("  效果文字: " + effectText);
            }
        }
        if (description.contains("【滋補】")) {
            System.out.println("【滋補】(Hearty): 回合結束時恢復全滿血量");
        }
        if (description.contains("【清淡】")) {
            System.out.println("【清淡】(Bland): 滿血時無法攻擊");
        }
        if (description.contains("【爆炒】")) {
            System.out.println("【爆炒】(Sear): 消滅攻擊力低於特定值的單位");
        }
        if (description.contains("【嗆辣】")) {
            System.out.println("【嗆辣】(Fiery): 每回合結束損失一點生命值");
        }
        
        System.out.println("-------------------------");
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
        
        browseCardList(allSpells, "法術卡", scanner);
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
        
        browseCardList(allCharacters, "角色卡", scanner);
    }
    
    /**
     * 瀏覽所有場地卡
     */
    private static void browseFieldCards() {
        Scanner scanner = new Scanner(System.in);
        
        if (allFieldCards.isEmpty()) {
            System.out.println("\n目前沒有場地卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allFieldCards, "場地卡", scanner);
    }
    /**
     * 根據稀有度返回顯示符號
     */
    private static String getRaritySymbol(Rarity rarity) {
        switch (rarity) {
            case CASUAL_BITES:
                return "★";
            case GOURMET_DELIGHT:
                return "★★";
            case CULINARY_HERITAGE:
                return "★★★";
            case ULTIMATE_TASTE:
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
                if (card instanceof SpellCard) {
                    SpellCard spell = (SpellCard) card;
                    System.out.printf("%2d. %-15s [費用:%d] (法術) %s\n", 
                            i+1, spell.getName(), spell.getCost(), 
                            getRaritySymbol(spell.getRarity()));
                } else if (card instanceof CharacterCard) {
                    CharacterCard character = (CharacterCard) card;
                    System.out.printf("%2d. %-15s [費用:%d, 攻擊力:%d, 生命值:%d] %s\n", 
                            i+1, character.getName(), character.getCost(), 
                            character.getAttack(), character.getCurrentHealth(), 
                            getRaritySymbol(character.getRarity()));
                } else if (card instanceof FieldCard) {
                    FieldCard fieldCard = (FieldCard) card;
                    System.out.printf("%2d. %-15s [費用:%d] [環境] %s\n", 
                            i+1, fieldCard.getName(), fieldCard.getCost(), 
                            getRaritySymbol(fieldCard.getRarity()));
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
    
    /**
     * 搜尋卡牌
     */
    private static void searchCard(Scanner scanner) {
        System.out.println("\n======= 搜尋卡牌 =======");
        System.out.println("請輸入要搜尋的卡牌名稱或關鍵字（輸入空白返回）：");
        
        String query = scanner.nextLine().trim();
        if (query.isEmpty()) {
            return;
        }
        
        // 搜尋符合條件的卡牌
        List<Card> matchedCards = allCards.values().stream()
                .filter(card -> card.getName().contains(query) || card.getDescription().contains(query))
                .collect(Collectors.toList());
        
        if (matchedCards.isEmpty()) {
            System.out.println("沒有找到符合 '" + query + "' 的卡牌");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        // 顯示搜尋結果
        System.out.println("\n找到 " + matchedCards.size() + " 張符合 '" + query + "' 的卡牌：");
        browseCardList(matchedCards, "搜尋結果", scanner);
    }
    
    /**
     * 瀏覽所有城堡卡
     */
    private static void browseCastleCards() {
        Scanner scanner = new Scanner(System.in);
        
        if (allCastles.isEmpty()) {
            System.out.println("\n目前沒有城堡卡可供瀏覽");
            System.out.println("按Enter返回...");
            scanner.nextLine();
            return;
        }
        
        browseCardList(allCastles, "城堡卡", scanner);
    }
    
    /**
     * 獲取所有城堡卡
     */
    public static List<CastleCard> getAllCastles() {
        return new ArrayList<>(allCastles);
    }
    
    /**
     * 獲取指定陣營的角色卡
     */
    public static List<CharacterCard> getCharactersByFaction(Faction faction) {
        return allCharacters.stream()
                .filter(card -> card.getFaction() == faction)
                .collect(Collectors.toList());
    }
    
    /**
     * 獲取特定陣營的城堡卡
     */
    public static List<CastleCard> getCastleCards(Faction faction) {
        return allCastles.stream()
                .filter(castle -> castle.getFaction() == faction || castle.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
    }
    
    /**
     * 城堡卡選擇介面
     */
    public static CastleCard chooseCastleCard(Scanner scanner, Faction faction) {
        List<CastleCard> availableCastles = allCastles.stream()
                .filter(castle -> castle.getFaction() == faction || castle.getFaction() == Faction.NEUTRAL)
                .collect(Collectors.toList());
        
        if (availableCastles.isEmpty()) {
            System.out.println("沒有適合你陣營的城堡卡可選！");
            return null;
        }
        
        System.out.println("\n======= 選擇你的城堡卡 =======");
        System.out.println("可選城堡卡：");
        
        for (int i = 0; i < availableCastles.size(); i++) {
            CastleCard castle = availableCastles.get(i);
            System.out.printf("%d. %s [%s] - %s\n", 
                    i + 1, castle.getName(), castle.getFaction().getLocalizedName(), castle.getDescription());
        }
        
        System.out.print("請選擇城堡卡(1-" + availableCastles.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        if (choice < 1 || choice > availableCastles.size()) {
            System.out.println("無效的選擇！默認選擇第一個城堡卡");
            return availableCastles.get(0);
        }
        
        return availableCastles.get(choice - 1);
    }
    
    /**
     * 城堡區域選擇介面
     */
    public static CastleCardZone chooseCastleZone(Scanner scanner, CastleCard castle) {
        System.out.println("\n======= 選擇城堡隱藏區域 =======");
        System.out.println("你選擇了: " + castle.getName());
        System.out.println("請選擇將城堡卡隱藏在哪個區域：");
        System.out.println("1. 出牌區 (Play Zone)");
        System.out.println("2. 法力區 (Mana Zone)");
        System.out.println("3. 抽牌區 (Deck Zone)");
        
        System.out.print("請選擇(1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        switch (choice) {
            case 1:
                return CastleCardZone.PLAY;
            case 2:
                return CastleCardZone.MANA;
            case 3:
                return CastleCardZone.DECK;
            default:
                System.out.println("無效的選擇！默認選擇出牌區");
                return CastleCardZone.PLAY;
        }
    }
    
    /**
     * 檢查區域是否被摧毀，並處理城堡卡效果
     */
    public static void checkZoneDestroyed(Player player, CastleCardZone zone) {
        CastleCard castle = player.getCastle();
        if (castle != null) {
            if (castle.checkZoneDestroyed(zone)) {
                System.out.println(player.getName() + " 的城堡被摧毀了！");
                System.out.println("城堡效果 [" + castle.getDescription() + "] 已消失！");
            }
        }
    }
} 