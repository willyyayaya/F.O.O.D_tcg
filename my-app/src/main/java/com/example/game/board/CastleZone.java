package com.example.game.board;

/**
 * 城堡區 (Castle Zone) - 代表玩家的防禦核心
 * 包含三面城牆：抽牌區、法力區、出牌區
 */
public class CastleZone {
    private Wall drawWall;      // 抽牌區
    private Wall manaWall;      // 法力區
    private Wall playWall;      // 出牌區
    
    private static final int MAX_TOTAL_TOKENS = 10; // 所有牆的最大Token總數
    
    /**
     * 城牆 - 每個城牆是一個獨立的戰場
     */
    public static class Wall {
        private String name;
        private int tokenCount;
        private int health;     // 城牆生命值
        private static final int MAX_HEALTH = 10; // 最大生命值
        
        public Wall(String name) {
            this.name = name;
            this.tokenCount = 1; // 初始時有1個Token
            this.health = MAX_HEALTH; // 初始生命值為10
        }
        
        public boolean addToken() {
            tokenCount++;
            return true;
        }
        
        public int getTokenCount() {
            return tokenCount;
        }
        
        public String getName() {
            return name;
        }
        
        public boolean removeToken() {
            if (tokenCount > 0) {
                tokenCount--;
                return true;
            }
            return false; // 沒有Token可移除
        }
        
        /**
         * 獲取城牆當前生命值
         */
        public int getHealth() {
            return health;
        }
        
        /**
         * 獲取城牆最大生命值
         */
        public int getMaxHealth() {
            return MAX_HEALTH;
        }
        
        /**
         * 城牆受到傷害
         * @param damage 傷害量
         * @return 城牆是否倒塌(生命值為0)
         */
        public boolean takeDamage(int damage) {
            health = Math.max(0, health - damage);
            System.out.println(name + " 受到 " + damage + " 點傷害，剩餘生命值: " + health);
            return health <= 0; // 返回城牆是否倒塌
        }
        
        /**
         * 城牆恢復生命值
         * @param amount 恢復量
         */
        public void heal(int amount) {
            health = Math.min(MAX_HEALTH, health + amount);
            System.out.println(name + " 恢復 " + amount + " 點生命值，當前生命值: " + health);
        }
        
        /**
         * 檢查城牆是否倒塌
         */
        public boolean isDestroyed() {
            return health <= 0;
        }
    }
    
    public CastleZone() {
        this.drawWall = new Wall("抽牌區");
        this.manaWall = new Wall("法力區");
        this.playWall = new Wall("出牌區");
    }
    
    /**
     * 獲取抽牌區
     */
    public Wall getDrawWall() {
        return drawWall;
    }
    
    /**
     * 獲取法力區
     */
    public Wall getManaWall() {
        return manaWall;
    }
    
    /**
     * 獲取出牌區
     */
    public Wall getPlayWall() {
        return playWall;
    }
    
    /**
     * 獲取當前所有城牆的Token總數
     */
    public int getTotalTokenCount() {
        return drawWall.getTokenCount() + manaWall.getTokenCount() + playWall.getTokenCount();
    }
    
    /**
     * 向指定區域添加一個Token
     * @param wallType 城牆類型：1=抽牌區, 2=法力區, 3=出牌區
     * @return 是否成功添加
     */
    public boolean addTokenToWall(int wallType) {
        // 檢查是否已達到Token總數上限
        if (getTotalTokenCount() >= MAX_TOTAL_TOKENS) {
            System.out.println("所有城牆Token總數已達上限 (" + MAX_TOTAL_TOKENS + ")!");
            return false;
        }
        
        switch (wallType) {
            case 1: return drawWall.addToken();
            case 2: return manaWall.addToken();
            case 3: return playWall.addToken();
            default: return false;
        }
    }
    
    /**
     * 檢查所有城牆是否都倒塌
     * @return 如果所有城牆的生命值都為0，返回true
     */
    public boolean areAllWallsDestroyed() {
        return drawWall.isDestroyed() && manaWall.isDestroyed() && playWall.isDestroyed();
    }
    
    /**
     * 對指定城牆造成傷害
     * @param wallType 城牆類型：1=抽牌區, 2=法力區, 3=出牌區
     * @param damage 傷害量
     * @return 城牆是否倒塌
     */
    public boolean damageWall(int wallType, int damage) {
        switch (wallType) {
            case 1: return drawWall.takeDamage(damage);
            case 2: return manaWall.takeDamage(damage);
            case 3: return playWall.takeDamage(damage);
            default: return false;
        }
    }
    
    /**
     * 顯示城堡區狀態
     */
    public void displayStatus() {
        System.out.println("城堡區狀態: (Token總數: " + getTotalTokenCount() + "/" + MAX_TOTAL_TOKENS + ")");
        System.out.println("- " + drawWall.getName() + ": " + drawWall.getTokenCount() + " 個Token" + 
                          ", 生命值: " + drawWall.getHealth() + "/" + drawWall.getMaxHealth());
        System.out.println("- " + manaWall.getName() + ": " + manaWall.getTokenCount() + " 個Token" + 
                          ", 生命值: " + manaWall.getHealth() + "/" + manaWall.getMaxHealth());
        System.out.println("- " + playWall.getName() + ": " + playWall.getTokenCount() + " 個Token" + 
                          ", 生命值: " + playWall.getHealth() + "/" + playWall.getMaxHealth());
    }
} 