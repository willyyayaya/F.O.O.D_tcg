package com.example.game.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.game.FOODGameEngine;
import com.example.game.board.BattlefieldZone;
import com.example.game.board.CastleZone;
import com.example.game.board.ResourceZone;
import com.example.game.card.Card;
import com.example.game.card.CardType;
import com.example.game.card.CharacterCard;
import com.example.game.card.FieldCard;
import com.example.game.player.Player;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 遊戲棋盤控制器類 - 處理遊戲界面的顯示與交互
 */
public class GameBoardController {
    
    // 玩家信息區域
    @FXML
    private Label playerNameLabel;
    
    @FXML
    private Label playerHealthLabel;
    
    @FXML
    private Label playerDeckCountLabel;
    
    // 對手信息區域
    @FXML
    private Label opponentNameLabel;
    
    @FXML
    private Label opponentHealthLabel;
    
    @FXML
    private Label opponentHandCountLabel;
    
    @FXML
    private Label opponentDeckCountLabel;
    
    // 資源區
    @FXML
    private Label drawAreaTokensLabel;
    
    @FXML
    private Label manaAreaTokensLabel;
    
    @FXML
    private Label playAreaTokensLabel;
    
    @FXML
    private Label availableManaLabel;
    
    // 遊戲日誌
    @FXML
    private TextArea gameLogArea;
    
    // 戰場區域
    @FXML
    private HBox playerBattlefieldBox;
    
    @FXML
    private HBox opponentBattlefieldBox;
    
    // 城堡區
    @FXML
    private GridPane playerCastleGrid;
    
    @FXML
    private GridPane opponentCastleGrid;
    
    // 手牌區域
    @FXML
    private HBox handCardsBox;
    
    // 場地卡區域
    @FXML
    private HBox fieldCardsBox;
    
    // 操作按鈕
    @FXML
    private Button placeTokenButton;
    
    @FXML
    private Button battleButton;
    
    @FXML
    private Button endTurnButton;
    
    @FXML
    private Button menuButton;
    
    // 遊戲引擎引用
    private FOODGameEngine gameEngine;
    
    // 當前玩家和對手引用
    private Player currentPlayer;
    private Player opponent;
    
    // 卡牌視圖列表
    private List<VBox> handCardViews = new ArrayList<>();
    private List<VBox> playerCharacterViews = new ArrayList<>();
    private List<VBox> opponentCharacterViews = new ArrayList<>();
    private List<VBox> fieldCardViews = new ArrayList<>();
    
    /**
     * 初始化控制器
     */
    @FXML
    public void initialize() {
        // 初始化遊戲日誌
        gameLogArea.setText("遊戲開始...\n");
        
        // 設置按鈕事件處理
        placeTokenButton.setOnAction(event -> handlePlaceToken());
        battleButton.setOnAction(event -> handleBattle());
        endTurnButton.setOnAction(event -> handleEndTurn());
        menuButton.setOnAction(event -> handleMenu());
        
        // 初始UI顯示
        updateUI();
    }
    
    /**
     * 設置遊戲引擎
     */
    public void setGameEngine(FOODGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        
        // 獲取玩家引用
        this.currentPlayer = FOODGameEngine.getCurrentPlayer();
        this.opponent = (currentPlayer == FOODGameEngine.getPlayer1()) ? 
                        FOODGameEngine.getPlayer2() : FOODGameEngine.getPlayer1();
        
        // 更新UI
        updateUI();
    }
    
    /**
     * 更新整個UI
     */
    public void updateUI() {
        // 需要在JavaFX應用線程中執行UI更新
        Platform.runLater(() -> {
            if (currentPlayer == null || opponent == null) return;
            
            // 更新玩家信息
            playerNameLabel.setText(currentPlayer.getName());
            playerHealthLabel.setText(String.valueOf(currentPlayer.getHealth()));
            playerDeckCountLabel.setText(String.valueOf(currentPlayer.getDeckSize()));
            
            // 更新對手信息
            opponentNameLabel.setText("對手: " + opponent.getName());
            opponentHealthLabel.setText(String.valueOf(opponent.getHealth()));
            opponentHandCountLabel.setText(String.valueOf(opponent.getHandSize()));
            opponentDeckCountLabel.setText(String.valueOf(opponent.getDeckSize()));
            
            // 更新資源區
            ResourceZone resourceZone = currentPlayer.getResourceZone();
            drawAreaTokensLabel.setText(String.valueOf(resourceZone.getTokens(ResourceZone.DRAW_AREA)));
            manaAreaTokensLabel.setText(String.valueOf(resourceZone.getTokens(ResourceZone.MANA_AREA)));
            playAreaTokensLabel.setText(String.valueOf(resourceZone.getTokens(ResourceZone.PLAY_AREA)));
            
            // 更新可用法力值
            int currentMana = currentPlayer.getCurrentMana();
            int maxMana = currentPlayer.getMaxMana();
            availableManaLabel.setText(currentMana + "/" + maxMana);
            
            // 更新城堡區
            updateCastleZone(playerCastleGrid, currentPlayer.getCastleZone());
            updateCastleZone(opponentCastleGrid, opponent.getCastleZone());
            
            // 更新戰場區
            updateBattlefield(playerBattlefieldBox, currentPlayer.getBattlefieldZone(), true);
            updateBattlefield(opponentBattlefieldBox, opponent.getBattlefieldZone(), false);
            
            // 更新手牌
            updateHand();
            
            // 更新場地卡
            updateFieldCards();
        });
    }
    
    /**
     * 更新城堡區
     */
    private void updateCastleZone(GridPane castleGrid, CastleZone castleZone) {
        castleGrid.getChildren().clear();
        
        // 抽牌城牆
        createWallElement(castleGrid, 0, 0, CastleZone.DRAW_WALL, "抽牌牆", castleZone);
        // 法力城牆
        createWallElement(castleGrid, 1, 0, CastleZone.MANA_WALL, "法力牆", castleZone);
        // 出牌城牆
        createWallElement(castleGrid, 0, 1, CastleZone.PLAY_WALL, "出牌牆", castleZone);
        // 城堡卡
        if (castleZone.getCastleCard() != null) {
            VBox castleCardView = createCardView(castleZone.getCastleCard(), false);
            // 調整大小
            castleCardView.setMaxWidth(80);
            castleCardView.setMaxHeight(110);
            castleGrid.add(castleCardView, 1, 1);
        }
    }
    
    /**
     * 創建城牆元素
     */
    private void createWallElement(GridPane castleGrid, int col, int row, int wallType, String wallName, CastleZone castleZone) {
        StackPane wallPane = new StackPane();
        wallPane.getStyleClass().add("wall-element");
        
        // 根據牆的狀態設置樣式
        if (castleZone.isWallDestroyed(wallType)) {
            wallPane.getStyleClass().add("destroyed");
        } else if (castleZone.getWallHealth(wallType) < castleZone.getWallMaxHealth(wallType)) {
            wallPane.getStyleClass().add("damaged");
        }
        
        // 添加牆的名稱和當前生命值
        VBox content = new VBox(5);
        content.setAlignment(Pos.CENTER);
        
        Label nameLabel = new Label(wallName);
        nameLabel.getStyleClass().add("wall-label");
        
        Label healthLabel = new Label(castleZone.getWallHealth(wallType) + "/" + castleZone.getWallMaxHealth(wallType));
        healthLabel.getStyleClass().add("wall-label");
        
        content.getChildren().addAll(nameLabel, healthLabel);
        wallPane.getChildren().add(content);
        
        castleGrid.add(wallPane, col, row);
    }
    
    /**
     * 更新戰場區
     */
    private void updateBattlefield(HBox battlefieldBox, BattlefieldZone battlefieldZone, boolean isPlayer) {
        battlefieldBox.getChildren().clear();
        List<VBox> characterViews = isPlayer ? playerCharacterViews : opponentCharacterViews;
        characterViews.clear();
        
        // 獲取該戰場區的所有角色卡
        List<CharacterCard> characters = battlefieldZone.getAllCharacters();
        
        // 如果沒有角色卡，顯示提示
        if (characters.isEmpty()) {
            Label emptyLabel = new Label("(無角色卡)");
            emptyLabel.setTextFill(Color.LIGHTGRAY);
            battlefieldBox.getChildren().add(emptyLabel);
            return;
        }
        
        // 添加所有角色卡到界面
        for (CharacterCard card : characters) {
            VBox cardView = createCardView(card, isPlayer);
            characterViews.add(cardView);
            battlefieldBox.getChildren().add(cardView);
        }
    }
    
    /**
     * 更新手牌區
     */
    private void updateHand() {
        handCardsBox.getChildren().clear();
        handCardViews.clear();
        
        // 獲取手牌
        List<Card> handCards = currentPlayer.getHand();
        
        // 如果沒有手牌，顯示提示
        if (handCards.isEmpty()) {
            Label emptyLabel = new Label("(無手牌)");
            emptyLabel.setTextFill(Color.LIGHTGRAY);
            handCardsBox.getChildren().add(emptyLabel);
            return;
        }
        
        // 添加所有手牌到界面
        for (Card card : handCards) {
            VBox cardView = createCardView(card, true);
            
            // 為手牌添加點擊事件
            cardView.setOnMouseClicked(event -> handleCardClick(card));
            
            handCardViews.add(cardView);
            handCardsBox.getChildren().add(cardView);
        }
    }
    
    /**
     * 更新場地卡區
     */
    private void updateFieldCards() {
        fieldCardsBox.getChildren().clear();
        fieldCardViews.clear();
        
        // 獲取當前玩家的場地卡
        List<FieldCard> fieldCards = currentPlayer.getFieldCards();
        
        // 如果沒有場地卡，顯示提示
        if (fieldCards.isEmpty()) {
            Label emptyLabel = new Label("(無場地卡)");
            emptyLabel.setTextFill(Color.LIGHTGRAY);
            fieldCardsBox.getChildren().add(emptyLabel);
            return;
        }
        
        // 添加所有場地卡到界面
        for (FieldCard card : fieldCards) {
            VBox cardView = createCardView(card, true);
            fieldCardViews.add(cardView);
            fieldCardsBox.getChildren().add(cardView);
        }
    }
    
    /**
     * 創建卡牌視圖
     */
    private VBox createCardView(Card card, boolean isPlayable) {
        VBox cardBox = new VBox(3);
        cardBox.getStyleClass().add("game-card");
        cardBox.setAlignment(Pos.CENTER);
        
        // 卡牌名稱
        Label nameLabel = new Label(card.getName());
        nameLabel.getStyleClass().add("card-name");
        nameLabel.setWrapText(true);
        nameLabel.setTextAlignment(TextAlignment.CENTER);
        
        // 添加卡牌背景色，根據陣營不同
        Rectangle background = new Rectangle(70, 70);
        background.setArcWidth(10);
        background.setArcHeight(10);
        
        // 根據卡牌陣營設置不同顏色
        switch (card.getFaction()) {
            case SPICY_KINGDOM: // 火辣王國
                background.setFill(Color.rgb(231, 76, 60, 0.3)); // 紅色
                break;
            case HEALTHY_OASIS: // 健康綠洲
                background.setFill(Color.rgb(46, 204, 113, 0.3)); // 綠色
                break;
            case FAST_FOOD_GUILD: // 速食工會
                background.setFill(Color.rgb(241, 196, 15, 0.3)); // 黃色
                break;
            case DESSERT_UNION: // 甜點聯盟
                background.setFill(Color.rgb(155, 89, 182, 0.3)); // 紫色
                break;
            default: // 中立陣營
                background.setFill(Color.rgb(189, 195, 199, 0.3)); // 灰色
                break;
        }
        
        // 特殊屬性標籤
        Label statsLabel = new Label();
        statsLabel.getStyleClass().add("card-stats");
        
        // 根據卡牌類型顯示不同屬性
        if (card.getType() == CardType.CHARACTER) {
            CharacterCard characterCard = (CharacterCard) card;
            statsLabel.setText("攻:" + characterCard.getAttack() + 
                              " | 防:" + characterCard.getDefense() + 
                              " | 生:" + characterCard.getCurrentHealth() + "/" + characterCard.getMaxHealth());
        } else if (card.getType() == CardType.FIELD) {
            FieldCard fieldCard = (FieldCard) card;
            statsLabel.setText("場地 | 費:" + fieldCard.getCost());
        } else {
            statsLabel.setText(card.getType().toString() + " | 費:" + card.getCost());
        }
        
        // 不可使用的卡牌顯示為半透明
        if (!isPlayable) {
            cardBox.setOpacity(0.7);
        }
        
        // 添加所有元素
        cardBox.getChildren().addAll(nameLabel, background, statsLabel);
        return cardBox;
    }
    
    /**
     * 處理卡牌點擊事件
     */
    private void handleCardClick(Card card) {
        // 顯示卡牌詳情或者使用卡牌的邏輯
        logGameMessage("點擊了卡牌: " + card.getName());
        // 這裡實現具體使用卡牌的邏輯
    }
    
    /**
     * 處理放置Token
     */
    private void handlePlaceToken() {
        logGameMessage("請選擇要放置Token的區域...");
        // 這裡實現放置Token的邏輯
    }
    
    /**
     * 處理戰鬥
     */
    private void handleBattle() {
        logGameMessage("請選擇攻擊者和目標...");
        // 這裡實現戰鬥的邏輯
    }
    
    /**
     * 處理結束回合
     */
    private void handleEndTurn() {
        logGameMessage("回合結束");
        // 這裡實現結束回合的邏輯
    }
    
    /**
     * 處理選單按鈕
     */
    private void handleMenu() {
        // 這裡實現選單的邏輯
    }
    
    /**
     * 記錄遊戲日誌
     */
    public void logGameMessage(String message) {
        Platform.runLater(() -> {
            gameLogArea.appendText(message + "\n");
            // 自動滾動到底部
            gameLogArea.positionCaret(gameLogArea.getText().length());
        });
    }
} 