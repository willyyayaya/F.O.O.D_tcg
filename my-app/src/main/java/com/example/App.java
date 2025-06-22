package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.game.FOODGameEngine;

/**
 * F.O.O.D TCG 食物擬人對戰卡牌遊戲 Spring Boot 主程式
 */
@SpringBootApplication
public class App {
    
    public static void main(String[] args) {
        System.out.println("歡迎來到 F.O.O.D TCG 食物擬人對戰卡牌遊戲 - Spring Boot版本!");
        
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        
        // 可選：如果需要啟動控制台遊戲模式
        if (args.length > 0 && "--console".equals(args[0])) {
            FOODGameEngine gameEngine = context.getBean(FOODGameEngine.class);
            gameEngine.start();
        }
        
        System.out.println("F.O.O.D TCG Spring Boot 應用程式已啟動!");
        System.out.println("Web API 可在 http://localhost:8080 訪問");
        System.out.println("使用 --console 參數啟動控制台模式");
    }
    
    /**
     * 將遊戲引擎註冊為Spring Bean
     */
    @Bean
    public FOODGameEngine foodGameEngine() {
        return new FOODGameEngine();
    }
}
