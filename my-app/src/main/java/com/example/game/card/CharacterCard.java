package com.example.game.card;

import com.example.game.player.Player;

/**
 * 角色卡 - 代表F.O.O.D TCG中的食物擬人角色
 */
public class CharacterCard extends Card {
    private int attack;         // 攻擊力
    private int defense;        // 防禦力
    private int maxHealth;      // 最大生命值
    private int currentHealth;  // 當前生命值
    private boolean isOffensive; // 是否為進攻型角色
    private boolean canAttack;   // 是否可以攻擊（本回合）
    
    public CharacterCard(String name, int tokenCost, String description, Rarity rarity, 
                        int attack, int defense, int maxHealth, boolean isOffensive) {
        super(name, tokenCost, description, rarity, CardType.CHARACTER);
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.isOffensive = isOffensive;
        this.canAttack = false;  // 剛出場的角色通常不能立即攻擊
    }
    
    @Override
    public void play(Player player) {
        // 出牌時的效果，可能包括戰吼效果等
        System.out.println(player.getName() + " 派出了 " + name + " 角色!");
    }
    
    /**
     * 角色攻擊目標
     * @param target 攻擊目標
     * @return 實際造成的傷害
     */
    public int attack(CharacterCard target) {
        if (!canAttack) {
            System.out.println(name + " 本回合不能攻擊!");
            return 0;
        }
        
        // 計算實際傷害，考慮目標防禦力
        int damage = Math.max(0, this.attack - target.getDefense());
        target.takeDamage(damage);
        
        // 設置為已攻擊狀態
        this.canAttack = false;
        
        System.out.println(name + " 攻擊了 " + target.getName() + "，造成 " + damage + " 點傷害!");
        return damage;
    }
    
    /**
     * 角色受到傷害
     * @param amount 傷害量
     * @return 是否存活
     */
    public boolean takeDamage(int amount) {
        this.currentHealth -= amount;
        System.out.println(name + " 受到 " + amount + " 點傷害，剩餘生命值: " + currentHealth);
        
        return currentHealth > 0;
    }
    
    /**
     * 恢復生命值
     * @param amount 恢復量
     */
    public void heal(int amount) {
        this.currentHealth = Math.min(currentHealth + amount, maxHealth);
        System.out.println(name + " 恢復 " + amount + " 點生命值，當前生命值: " + currentHealth);
    }
    
    /**
     * 刷新角色狀態（新回合開始時）
     */
    public void refreshForNewTurn() {
        // 新回合開始時，可以再次攻擊
        this.canAttack = true;
    }
    
    /**
     * 增加攻擊力
     * @param amount 增加量
     */
    public void increaseAttack(int amount) {
        this.attack += amount;
        System.out.println(name + " 的攻擊力提升了 " + amount + "，現在為: " + attack);
    }
    
    /**
     * 增加防禦力
     * @param amount 增加量
     */
    public void increaseDefense(int amount) {
        this.defense += amount;
        System.out.println(name + " 的防禦力提升了 " + amount + "，現在為: " + defense);
    }
    
    // Getters
    public int getAttack() {
        return attack;
    }
    
    public int getDefense() {
        return defense;
    }
    
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public boolean isOffensive() {
        return isOffensive;
    }
    
    public boolean canAttack() {
        return canAttack;
    }
    
    @Override
    protected void displaySpecificDetails() {
        System.out.println("攻擊力: " + attack);
        System.out.println("防禦力: " + defense);
        System.out.println("生命值: " + currentHealth + "/" + maxHealth);
        System.out.println("類別: " + (isOffensive ? "進攻型" : "防禦型"));
    }
    
    // 兼容性方法，支援舊系統
    public int getManaCost() {
        return getTokenCost();
    }
    
    // 兼容性方法，與Minion類兼容
    public int getHealth() {
        return currentHealth;
    }
}