package com.example.game.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.game.card.Card;
import com.example.game.card.CardLibrary;
import com.example.game.card.CardType;
import com.example.game.card.CharacterCard;
import com.example.game.card.Faction;
import com.example.game.card.FieldCard;
import com.example.game.card.SpellCard;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 卡牌圖鑑頁面控制器
 */
public class CardLibraryController {

    @FXML
    private ComboBox<String> factionComboBox;
    
    @FXML
    private ComboBox<String> cardTypeComboBox;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button resetButton;
    
    @FXML
    private GridPane cardGrid;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Label cardCountLabel;
    
    private List<Card> allCards = new ArrayList<>();
    
    /**
     * 初始化控制器
     */
    @FXML
    public void initialize() {
        System.out.println("正在初始化 F.O.O.D TCG 卡牌圖鑑...");
        
        try {
            // 初始化陣營下拉選單
            factionComboBox.setItems(FXCollections.observableArrayList(
                "全部", 
                "火辣王國", 
                "健康綠洲", 
                "速食工會", 
                "甜點聯盟", 
                "中立陣營"
            ));
            factionComboBox.getSelectionModel().selectFirst();
            
            // 初始化卡牌類型下拉選單
            cardTypeComboBox.setItems(FXCollections.observableArrayList(
                "全部", 
                "角色卡", 
                "場地卡", 
                "城堡卡",
                "法術卡"
            ));
            cardTypeComboBox.getSelectionModel().selectFirst();
            
            // 確保卡牌圖鑑已初始化
            if (CardLibrary.getAllCharacters().isEmpty()) {
                System.out.println("卡牌圖鑑尚未初始化，正在進行初始化...");
                CardLibrary.initialize();
            }
            
            // 載入所有卡牌
            loadAllCards();
            
            // 顯示卡牌
            displayCards(allCards);
            
            // 輸出卡牌載入信息
            System.out.println("卡牌圖鑑初始化完成，共 " + allCards.size() + " 張卡牌。");
            int characterCount = 0, fieldCount = 0, spellCount = 0, castleCount = 0, questCount = 0;
            for (Card card : allCards) {
                CardType type = card.getType();
                if (type == CardType.CHARACTER) characterCount++;
                else if (type == CardType.FIELD) fieldCount++;
                else if (type == CardType.CASTLE) castleCount++;
                else if (type == CardType.QUEST) questCount++;
                else spellCount++; // 其他類型卡牌暫時算作法術卡
            }
            System.out.println("其中角色卡: " + characterCount + " 張，場地卡: " + fieldCount + 
                             " 張，法術卡: " + spellCount + " 張，城堡卡: " + castleCount + " 張");
            
        } catch (Exception e) {
            System.err.println("卡牌圖鑑初始化失敗: " + e.getMessage());
            e.printStackTrace();
            cardCountLabel.setText("載入卡牌失敗");
        }
    }
    
    /**
     * 載入所有卡牌
     */
    private void loadAllCards() {
        try {
            allCards.clear();
            
            // 加載角色卡
            List<CharacterCard> characters = CardLibrary.getAllCharacters();
            if (characters != null) {
                allCards.addAll(characters);
                System.out.println("已載入 " + characters.size() + " 張角色卡");
            } else {
                System.out.println("找不到角色卡");
            }
            
            // 加載場地卡
            List<FieldCard> fieldCards = CardLibrary.getAllFieldCards();
            if (fieldCards != null) {
                allCards.addAll(fieldCards);
                System.out.println("已載入 " + fieldCards.size() + " 張場地卡");
            } else {
                System.out.println("找不到場地卡");
            }
            
            // 加載法術卡
            List<SpellCard> spellCards = CardLibrary.getAllSpells();
            if (spellCards != null) {
                allCards.addAll(spellCards);
                System.out.println("已載入 " + spellCards.size() + " 張法術卡");
            } else {
                System.out.println("找不到法術卡");
            }
            
            // 加載城堡卡
            try {
                allCards.addAll(CardLibrary.getCastleCards(Faction.NEUTRAL));
                allCards.addAll(CardLibrary.getCastleCards(Faction.SPICY_KINGDOM));
                allCards.addAll(CardLibrary.getCastleCards(Faction.HEALTHY_OASIS));
                allCards.addAll(CardLibrary.getCastleCards(Faction.FAST_FOOD_GUILD));
                allCards.addAll(CardLibrary.getCastleCards(Faction.DESSERT_UNION));
                System.out.println("已載入城堡卡");
            } catch (Exception e) {
                System.err.println("載入城堡卡時出錯: " + e.getMessage());
            }
            
            // 更新卡牌計數
            updateCardCount(allCards.size());
        } catch (Exception e) {
            System.err.println("載入卡牌時出錯: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 顯示卡牌
     */
    private void displayCards(List<Card> cards) {
        try {
            // 清空網格
            cardGrid.getChildren().clear();
            
            // 設置網格布局
            int col = 0;
            int row = 0;
            final int COLUMNS = 3;
            
            // 添加卡牌到網格
            for (Card card : cards) {
                VBox cardBox = createCardBox(card);
                
                cardGrid.add(cardBox, col, row);
                
                col++;
                if (col >= COLUMNS) {
                    col = 0;
                    row++;
                }
            }
            
            // 更新卡牌計數
            updateCardCount(cards.size());
        } catch (Exception e) {
            System.err.println("顯示卡牌時出錯: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 創建卡牌顯示框
     */
    private VBox createCardBox(Card card) {
        VBox cardBox = new VBox(5);
        cardBox.getStyleClass().add("card-item");
        
        try {
            // 創建卡牌名稱標籤
            Label nameLabel = new Label(card.getName());
            nameLabel.getStyleClass().add("card-name");
            
            // 創建卡牌類型標籤
            String cardTypeText = getCardTypeText(card.getType());
            String factionText = card.getFaction().getLocalizedName();
            Label typeLabel = new Label(cardTypeText + " - " + factionText);
            typeLabel.getStyleClass().add("card-type");
            
            // 創建卡牌描述標籤
            Label descLabel = new Label(card.getDescription());
            descLabel.setWrapText(true);
            
            // 添加到卡牌框
            cardBox.getChildren().addAll(nameLabel, typeLabel, descLabel);
            
            // 添加其他卡牌特定信息
            if (card.getType() == CardType.CHARACTER) {
                // 如果是角色卡，添加攻擊、防禦、生命等信息
                try {
                    CharacterCard characterCard = (CharacterCard) card;
                    Label statsLabel = new Label(
                        "攻擊: " + characterCard.getAttack() + 
                        " | 防禦: " + characterCard.getDefense() + 
                        " | 生命: " + characterCard.getMaxHealth()
                    );
                    cardBox.getChildren().add(statsLabel);
                } catch (Exception e) {
                    System.err.println("轉換角色卡時出錯：" + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("創建卡牌顯示框時出錯: " + e.getMessage());
            Label errorLabel = new Label("卡牌載入錯誤");
            cardBox.getChildren().add(errorLabel);
        }
        
        return cardBox;
    }
    
    /**
     * 獲取卡牌類型的中文名稱
     */
    private String getCardTypeText(CardType type) {
        if (type == CardType.CHARACTER) return "角色卡";
        else if (type == CardType.FIELD) return "場地卡";
        else if (type == CardType.QUEST) return "任務卡";
        else if (type == CardType.CASTLE) return "城堡卡";
        else return "法術卡"; // 其他未知類型暫時顯示為法術卡
    }
    
    /**
     * 更新卡牌計數
     */
    private void updateCardCount(int count) {
        cardCountLabel.setText("共 " + count + " 張卡牌");
    }
    
    /**
     * 處理搜尋按鈕
     */
    @FXML
    public void handleSearch(ActionEvent event) {
        try {
            String factionFilter = factionComboBox.getValue();
            String typeFilter = cardTypeComboBox.getValue();
            
            List<Card> filteredCards = new ArrayList<>();
            
            // 過濾卡牌
            for (Card card : allCards) {
                boolean matchFaction = "全部".equals(factionFilter) || 
                                        card.getFaction().getLocalizedName().equals(factionFilter);
                
                boolean matchType = "全部".equals(typeFilter) || 
                                    getCardTypeText(card.getType()).equals(typeFilter);
                
                if (matchFaction && matchType) {
                    filteredCards.add(card);
                }
            }
            
            // 顯示過濾後的卡牌
            displayCards(filteredCards);
        } catch (Exception e) {
            System.err.println("搜尋卡牌時出錯: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 處理重置按鈕
     */
    @FXML
    public void handleReset(ActionEvent event) {
        try {
            // 重置下拉選單
            factionComboBox.getSelectionModel().selectFirst();
            cardTypeComboBox.getSelectionModel().selectFirst();
            
            // 顯示所有卡牌
            displayCards(allCards);
        } catch (Exception e) {
            System.err.println("重置卡牌圖鑑時出錯: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * 處理返回按鈕
     */
    @FXML
    public void handleBackButton(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
} 