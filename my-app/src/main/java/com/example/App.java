package com.example;

import com.example.game.FOODGameEngine;

/**
 * F.O.O.D TCG 食物擬人對戰卡牌遊戲主程式
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "歡迎來到 F.O.O.D TCG 食物擬人對戰卡牌遊戲!" );
        System.out.println( "正在啟動遊戲引擎..." );
        
        // 實例化並啟動遊戲引擎
        FOODGameEngine gameEngine = new FOODGameEngine();
        gameEngine.start();
    }
}
