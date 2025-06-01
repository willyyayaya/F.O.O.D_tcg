package com.example.game.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.example.game.board.BattlefieldZone;
import com.example.game.player.Player;

/**
 * 目標選擇器 - 處理卡牌效果的目標選擇邏輯
 */
public class TargetSelector {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    
    /**
     * 獲取所有友方角色（合併三個區域）
     * @param battlefield 戰場
     * @return 所有友方角色列表
     */
    private static List<CharacterCard> getAllCharacters(BattlefieldZone battlefield) {
        List<CharacterCard> allCharacters = new ArrayList<>();
        allCharacters.addAll(battlefield.getAreaByType(BattlefieldZone.DRAW_AREA).getCharacters());
        allCharacters.addAll(battlefield.getAreaByType(BattlefieldZone.MANA_AREA).getCharacters());
        allCharacters.addAll(battlefield.getAreaByType(BattlefieldZone.PLAY_AREA).getCharacters());
        return allCharacters;
    }
    
    /**
     * 根據「擺盤」效果篩選可攻擊的目標
     * 如果對方戰場上有擺盤效果的角色，則只能攻擊擁有擺盤效果的角色
     * @param opponent 對手玩家
     * @param opponentCharacters 對手角色列表
     * @return 可攻擊的目標列表
     */
    public static List<CharacterCard> getValidAttackTargets(Player opponent, List<CharacterCard> opponentCharacters) {
        // 篩選出擁有擺盤效果的角色
        List<CharacterCard> garnishedCharacters = new ArrayList<>();
        CardEffect cardEffect = new CardEffectImpl();
        
        for (CharacterCard character : opponentCharacters) {
            if (cardEffect.processGarnishedEffect(character)) {
                garnishedCharacters.add(character);
            }
        }
        
        // 如果存在擺盤效果的角色，則只能攻擊這些角色
        if (!garnishedCharacters.isEmpty()) {
            System.out.println("對方存在具有【擺盤】效果的角色，必須優先攻擊這些角色!");
            return garnishedCharacters;
        }
        
        // 否則可以攻擊所有角色
        return new ArrayList<>(opponentCharacters);
    }
    
    /**
     * 選擇一個友方角色作為效果目標
     * @param player 當前玩家
     * @param sourceCard 效果來源卡牌
     * @param message 選擇提示信息
     * @return 選擇的友方角色，如果取消選擇則返回null
     */
    public static CharacterCard selectFriendlyCharacter(Player player, Card sourceCard, String message) {
        BattlefieldZone battlefield = player.getBattlefieldZone();
        List<CharacterCard> friendlyCharacters = getAllCharacters(battlefield);
        
        // 如果沒有友方角色可選，則返回null
        if (friendlyCharacters.isEmpty()) {
            System.out.println("沒有友方角色可選！");
            return null;
        }
        
        // 過濾掉效果來源卡牌自身（如果需要）
        List<CharacterCard> validTargets = new ArrayList<>();
        for (CharacterCard character : friendlyCharacters) {
            if (sourceCard instanceof CharacterCard && character == sourceCard) {
                continue; // 跳過自身
            }
            validTargets.add(character);
        }
        
        if (validTargets.isEmpty()) {
            System.out.println("沒有有效的友方目標！");
            return null;
        }
        
        // 顯示可選目標列表
        System.out.println("\n" + message);
        for (int i = 0; i < validTargets.size(); i++) {
            CharacterCard character = validTargets.get(i);
            System.out.printf("%d. %s [%d/%d] %s\n", 
                    i + 1, 
                    character.getName(), 
                    character.getCurrentHealth(), 
                    character.getMaxHealth(),
                    character.getFaction().getLocalizedName());
        }
        System.out.println("0. 取消選擇");
        
        // 玩家選擇目標
        System.out.print("請選擇目標 (0-" + validTargets.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        if (choice <= 0 || choice > validTargets.size()) {
            System.out.println("已取消選擇！");
            return null;
        }
        
        CharacterCard selectedTarget = validTargets.get(choice - 1);
        System.out.println("已選擇: " + selectedTarget.getName());
        return selectedTarget;
    }
    
    /**
     * 選擇一個敵方角色作為效果目標
     * @param player 當前玩家
     * @param opponent 對手玩家
     * @param message 選擇提示信息
     * @return 選擇的敵方角色，如果取消選擇則返回null
     */
    public static CharacterCard selectEnemyCharacter(Player player, Player opponent, String message) {
        BattlefieldZone opponentBattlefield = opponent.getBattlefieldZone();
        List<CharacterCard> enemyCharacters = getAllCharacters(opponentBattlefield);
        
        // 如果沒有敵方角色可選，則返回null
        if (enemyCharacters.isEmpty()) {
            System.out.println("沒有敵方角色可選！");
            return null;
        }
        
        // 顯示可選目標列表
        System.out.println("\n" + message);
        for (int i = 0; i < enemyCharacters.size(); i++) {
            CharacterCard character = enemyCharacters.get(i);
            System.out.printf("%d. %s [%d/%d] %s\n", 
                    i + 1, 
                    character.getName(), 
                    character.getCurrentHealth(), 
                    character.getMaxHealth(),
                    character.getFaction().getLocalizedName());
        }
        System.out.println("0. 取消選擇");
        
        // 玩家選擇目標
        System.out.print("請選擇目標 (0-" + enemyCharacters.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝
        
        if (choice <= 0 || choice > enemyCharacters.size()) {
            System.out.println("已取消選擇！");
            return null;
        }
        
        CharacterCard selectedTarget = enemyCharacters.get(choice - 1);
        System.out.println("已選擇: " + selectedTarget.getName());
        return selectedTarget;
    }
    
    /**
     * 隨機選擇一個友方角色作為效果目標
     * @param player 當前玩家
     * @param sourceCard 效果來源卡牌（可能需要排除自身）
     * @return 隨機選擇的友方角色，如果沒有有效目標則返回null
     */
    public static CharacterCard selectRandomFriendlyCharacter(Player player, Card sourceCard) {
        BattlefieldZone battlefield = player.getBattlefieldZone();
        List<CharacterCard> friendlyCharacters = getAllCharacters(battlefield);
        
        if (friendlyCharacters.isEmpty()) {
            return null;
        }
        
        // 過濾掉效果來源卡牌自身（如果需要）
        List<CharacterCard> validTargets = new ArrayList<>();
        for (CharacterCard character : friendlyCharacters) {
            if (sourceCard instanceof CharacterCard && character == sourceCard) {
                continue; // 跳過自身
            }
            validTargets.add(character);
        }
        
        if (validTargets.isEmpty()) {
            return null;
        }
        
        int randomIndex = random.nextInt(validTargets.size());
        CharacterCard selectedTarget = validTargets.get(randomIndex);
        System.out.println("隨機選擇了友方目標: " + selectedTarget.getName());
        return selectedTarget;
    }
    
    /**
     * 隨機選擇一個敵方角色作為效果目標
     * @param opponent 對手玩家
     * @return 隨機選擇的敵方角色，如果沒有敵方角色則返回null
     */
    public static CharacterCard selectRandomEnemyCharacter(Player opponent) {
        BattlefieldZone opponentBattlefield = opponent.getBattlefieldZone();
        List<CharacterCard> enemyCharacters = getAllCharacters(opponentBattlefield);
        
        if (enemyCharacters.isEmpty()) {
            return null;
        }
        
        int randomIndex = random.nextInt(enemyCharacters.size());
        CharacterCard selectedTarget = enemyCharacters.get(randomIndex);
        System.out.println("隨機選擇了敵方目標: " + selectedTarget.getName());
        return selectedTarget;
    }
    
    /**
     * 選擇所有友方角色作為效果目標
     * @param player 當前玩家
     * @return 所有友方角色列表
     */
    public static List<CharacterCard> selectAllFriendlyCharacters(Player player) {
        BattlefieldZone battlefield = player.getBattlefieldZone();
        List<CharacterCard> friendlyCharacters = getAllCharacters(battlefield);
        
        System.out.println("選擇了所有友方角色作為目標，共 " + friendlyCharacters.size() + " 個");
        return new ArrayList<>(friendlyCharacters);
    }
    
    /**
     * 選擇所有敵方角色作為效果目標
     * @param opponent 對手玩家
     * @return 所有敵方角色列表
     */
    public static List<CharacterCard> selectAllEnemyCharacters(Player opponent) {
        BattlefieldZone opponentBattlefield = opponent.getBattlefieldZone();
        List<CharacterCard> enemyCharacters = getAllCharacters(opponentBattlefield);
        
        System.out.println("選擇了所有敵方角色作為目標，共 " + enemyCharacters.size() + " 個");
        return new ArrayList<>(enemyCharacters);
    }
    
    /**
     * 選擇一個城牆作為效果目標
     * @param player 當前玩家
     * @param message 選擇提示信息
     * @return 選擇的城牆類型（1=抽牌區，2=法力區，3=出牌區），如果取消則返回0
     */
    public static int selectCastleWall(Player player, String message) {
        if (player == null) {
            System.out.println("無效的玩家！");
            return 0;
        }

        System.out.println("\n" + message);
        System.out.println("1. 抽牌區城牆");
        System.out.println("2. 法力區城牆");
        System.out.println("3. 出牌區城牆");
        System.out.println("0. 取消選擇");

        System.out.print("請選擇城牆 (0-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 清除輸入緩衝

        if (choice < 0 || choice > 3) {
            System.out.println("無效的選擇！");
            return 0;
        }

        if (choice == 0) {
            System.out.println("已取消選擇！");
            return 0;
        }

        String wallName = "";
        switch (choice) {
            case 1: wallName = "抽牌區城牆"; break;
            case 2: wallName = "法力區城牆"; break;
            case 3: wallName = "出牌區城牆"; break;
        }
        System.out.println("已選擇: " + wallName);
        return choice;
    }
} 