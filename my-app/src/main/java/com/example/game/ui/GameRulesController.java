package com.example.game.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 遊戲規則頁面控制器
 */
public class GameRulesController {

    @FXML
    private Button backButton;
    
    /**
     * 初始化控制器
     */
    @FXML
    public void initialize() {
        // 初始化時的設置（如需要）
    }
    
    /**
     * 處理返回按鈕點擊事件
     */
    @FXML
    public void handleBackButton(ActionEvent event) {
        // 獲取當前窗口並關閉
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
} 