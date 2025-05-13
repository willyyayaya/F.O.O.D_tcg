package com.example;

import com.example.game.FOODGameEngine;

/**
 * F.O.O.D TCG 食物擬人對戰卡牌遊戲主程式
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println("啟動 F.O.O.D TCG 食物擬人對戰卡牌遊戲...");
        
        // 建立必要的資源目錄，確保它們存在
        createResourceDirectories();
        
        // 啟動JavaFX圖形界面
        FoodTCGApplication.main(args);
    }
    
    /**
     * 創建必要的資源目錄
     */
    private static void createResourceDirectories() {
        try {
            // 確保資源目錄存在
            createDirectory("my-app/src/main/resources/images");
            createDirectory("my-app/src/main/resources/fxml");
            createDirectory("my-app/src/main/resources/styles");
            
        } catch (Exception e) {
            System.err.println("創建資源目錄時出錯: " + e.getMessage());
        }
    }
    
    /**
     * 創建目錄
     */
    private static void createDirectory(String path) {
        java.io.File directory = new java.io.File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("創建目錄: " + path);
            } else {
                System.err.println("無法創建目錄: " + path);
            }
        }
    }
    
    /**
     * 啟動遊戲控制台版本（無圖形界面）
     */
    public static void startConsoleVersion() {
        System.out.println("啟動控制台版本...");
        // 實例化並啟動遊戲引擎
        FOODGameEngine gameEngine = new FOODGameEngine();
        gameEngine.start();
    }
}
