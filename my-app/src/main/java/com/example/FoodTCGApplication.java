package com.example;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * F.O.O.D TCG 食物擬人對戰卡牌遊戲圖形界面主程序
 */
public class FoodTCGApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // 加載主選單FXML
            URL mainMenuUrl = getClass().getResource("/fxml/MainMenu.fxml");
            if (mainMenuUrl == null) {
                System.err.println("找不到MainMenu.fxml文件！");
                displayErrorAndExit(primaryStage);
                return;
            }
            
            Parent root = FXMLLoader.load(mainMenuUrl);
            Scene scene = new Scene(root, 1024, 768);
            
            // 設置窗口標題和場景
            primaryStage.setTitle("F.O.O.D TCG - 食物擬人對戰卡牌遊戲");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
            displayErrorAndExit(primaryStage);
        }
    }
    
    private void displayErrorAndExit(Stage stage) {
        System.err.println("應用程序初始化錯誤，即將退出...");
        stage.close();
    }

    /**
     * 應用程式主入口點
     */
    public static void main(String[] args) {
        launch(args);
    }
} 