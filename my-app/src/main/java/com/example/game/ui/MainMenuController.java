package com.example.game.ui;

import java.io.IOException;

import com.example.game.FOODGameEngine;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 主選單控制器類
 */
public class MainMenuController {
    
    @FXML
    private VBox menuContainer;
    
    @FXML
    private Button startGameButton;
    
    @FXML
    private Button gameRulesButton;
    
    @FXML
    private Button cardLibraryButton;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Label versionLabel;

    /**
     * 初始化控制器
     */
    @FXML
    public void initialize() {
        // 設置版本信息
        versionLabel.setText("版本 1.0.0");
        
        // 設置按鈕事件
        startGameButton.setOnAction(event -> startGame());
        gameRulesButton.setOnAction(event -> showGameRules());
        cardLibraryButton.setOnAction(event -> showCardLibrary());
        exitButton.setOnAction(event -> exitGame());
    }
    
    /**
     * 開始遊戲 - 使用圖形界面
     */
    private void startGame() {
        try {
            // 載入遊戲棋盤FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameBoard.fxml"));
            Parent root = loader.load();
            
            // 獲取控制器，用於後續操作
            GameBoardController gameBoardController = loader.getController();
            
            // 創建遊戲引擎
            FOODGameEngine gameEngine = new FOODGameEngine();
            
            // 在新線程中初始化遊戲引擎
            new Thread(() -> {
                // 初始化遊戲引擎（但不啟動控制台模式的gameLoop）
                gameEngine.prepareGame();
                
                // 在JavaFX線程中更新UI
                Platform.runLater(() -> {
                    // 設置遊戲引擎到控制器
                    gameBoardController.setGameEngine(gameEngine);
                    
                    // 記錄遊戲開始信息
                    gameBoardController.logGameMessage("遊戲準備就緒！");
                });
            }).start();
            
            // 創建遊戲窗口
            Stage gameStage = new Stage();
            gameStage.setTitle("F.O.O.D TCG - 食物擬人對戰卡牌遊戲");
            gameStage.setScene(new Scene(root, 1024, 768));
            gameStage.setResizable(false);
            
            // 隱藏主選單窗口
            Stage currentStage = (Stage) startGameButton.getScene().getWindow();
            currentStage.hide();
            
            // 顯示遊戲窗口
            gameStage.show();
            
            // 當遊戲窗口關閉時，顯示主選單
            gameStage.setOnCloseRequest(e -> currentStage.show());
            
        } catch (Exception e) {
            e.printStackTrace();
            showError("遊戲啟動失敗：" + e.getMessage());
        }
    }
    
    /**
     * 顯示遊戲規則
     */
    private void showGameRules() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GameRules.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("F.O.O.D TCG - 遊戲規則");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            showError("無法載入遊戲規則：" + e.getMessage());
        }
    }
    
    /**
     * 顯示卡牌圖鑑
     */
    private void showCardLibrary() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CardLibrary.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("F.O.O.D TCG - 卡牌圖鑑");
            stage.setScene(new Scene(root, 900, 700));
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            showError("無法載入卡牌圖鑑：" + e.getMessage());
        }
    }
    
    /**
     * 退出遊戲
     */
    private void exitGame() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
    /**
     * 顯示錯誤信息
     */
    private void showError(String message) {
        System.err.println("錯誤：" + message);
        // 這裡可以實現彈出錯誤窗口的邏輯
    }
} 