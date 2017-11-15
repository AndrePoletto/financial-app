package controllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.dao.AccountDAO;
import model.dao.CategoryDAO;
import model.dao.TransactionDAO;
import model.logic.Account;
import model.logic.Category;
import model.logic.Transaction;

import java.io.IOException;


public class MainWindowController {
    @FXML
    private AnchorPane btnTransaction, btnCategory, btnAccount, btnData, btnHome, tabTransaction, tabCategory, tabAccount, tabData, tabHome;

    @FXML
    private Label screenText, btnTransactionText, btnCategoryText, btnAccountText, btnHomeText, btnDataText;

    @FXML
    private ImageView transSelecIcon, catSelecIcon, accSelecIcon, dataSelecIcon, homeSelecIcon;

    @FXML
    private JFXButton btnNewTrans, btnNewCat, btnNewAcc;

    @FXML
    private JFXTreeTableView transactionTable, categoryTable, accountTable;

    @FXML
    public void initialize() {
        handleData();
    }

    @FXML
    private void handleSectionButtonAction(MouseEvent event){
        if (event.getTarget() == btnTransaction || event.getTarget() == btnTransactionText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnHome.getStyleClass().clear();
            btnTransaction.getStyleClass().add("tabSelected");

            //Controls the tabTitle of the page
            screenText.setText("Transações");

            //Controls the selected tab icons
            transSelecIcon.setVisible(true);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(false);
            homeSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(true);
            tabCategory.setVisible(false);
            tabAccount.setVisible(false);
            tabData.setVisible(false);
            tabHome.setVisible(false);
        }
        else if (event.getTarget() == btnCategory || event.getTarget() == btnCategoryText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnHome.getStyleClass().clear();
            btnCategory.getStyleClass().add("tabSelected");

            //Controls the tabTitle of the page
            screenText.setText("Categorias");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(true);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(false);
            homeSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(false);
            tabCategory.setVisible(true);
            tabAccount.setVisible(false);
            tabData.setVisible(false);
            tabHome.setVisible(false);
        }
        else if (event.getTarget() == btnAccount || event.getTarget() == btnAccountText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnHome.getStyleClass().clear();
            btnAccount.getStyleClass().add("tabSelected");

            //Controls the tabTitle of the page
            screenText.setText("Contas");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(true);
            dataSelecIcon.setVisible(false);
            homeSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(false);
            tabCategory.setVisible(false);
            tabAccount.setVisible(true);
            tabData.setVisible(false);
            tabHome.setVisible(false);
        }
        else if (event.getTarget() == btnData || event.getTarget() == btnDataText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnHome.getStyleClass().clear();
            btnData.getStyleClass().add("tabSelected");

            //Controls the tabTitle of the page
            screenText.setText("Dados");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(true);
            homeSelecIcon.setVisible(false);

            //Controls the tab view
            tabTransaction.setVisible(false);
            tabCategory.setVisible(false);
            tabAccount.setVisible(false);
            tabData.setVisible(true);
            tabHome.setVisible(false);
        }
        else if (event.getTarget() == btnHome || event.getTarget() == btnHomeText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnHome.getStyleClass().clear();
            btnHome.getStyleClass().add("tabSelected");

            //Controls the tabTitle of the page
            screenText.setText("Início");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(false);
            homeSelecIcon.setVisible(true);

            //Controls the tab view
            tabTransaction.setVisible(false);
            tabCategory.setVisible(false);
            tabAccount.setVisible(false);
            tabData.setVisible(false);
            tabHome.setVisible(true);
        }
    }

    @FXML
    private void handleButtonAdd(MouseEvent event) throws IOException {
        if (event.getSource() == btnNewTrans){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/visual/addTransaction.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Add new Transaction");
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == btnNewCat){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/visual/addCategory.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Add new Category");
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == btnNewAcc){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../view/visual/addAccount.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Add new Account");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void handleClose(){
        System.exit(0);
    }

    @FXML
    private void handleEntered(MouseEvent event){
        AnchorPane source = (AnchorPane) event.getSource();
        if(source.getStyleClass().toString().equals("tabSelected")){
            source.getStyleClass().clear();
            source.getStyleClass().add("tabSelected");
        }
        else{
            source.getStyleClass().clear();
            source.getStyleClass().add("tabEntered");
        }
    }

    @FXML
    private void handleExited(MouseEvent event){
        AnchorPane source = (AnchorPane) event.getSource();
        if(source.getStyleClass().toString().equals("tabSelected")){
            source.getStyleClass().clear();
            source.getStyleClass().add("tabSelected");
        }
        else{
            source.getStyleClass().clear();
            source.getStyleClass().add("tabExited");
        }
    }

    @FXML
    private void handleData(){

        TransactionDAO traDao = new TransactionDAO();
        CategoryDAO catDao = new CategoryDAO();
        AccountDAO accDao = new AccountDAO();
        
        // Transaction tab
        JFXTreeTableColumn<Transaction, String> transactionValue = new JFXTreeTableColumn<>("Value");
        transactionValue.setPrefWidth(94.5);
        transactionValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));

        JFXTreeTableColumn<Transaction, String> transactionDescription = new JFXTreeTableColumn<>("Description");
        transactionDescription.setPrefWidth(94.5);
        transactionDescription.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));

        JFXTreeTableColumn<Transaction, String> transactionCategory = new JFXTreeTableColumn<>("Category");
        transactionCategory.setPrefWidth(94.5);
        transactionCategory.setCellValueFactory(new TreeItemPropertyValueFactory<>("category"));

        JFXTreeTableColumn<Transaction, String> transactionAccount = new JFXTreeTableColumn<>("Account");
        transactionAccount.setPrefWidth(94.5);
        transactionAccount.setCellValueFactory(new TreeItemPropertyValueFactory<>("account"));

        JFXTreeTableColumn<Transaction, String> transactionNote = new JFXTreeTableColumn<>("Note");
        transactionNote.setPrefWidth(94.5);
        transactionNote.setCellValueFactory(new TreeItemPropertyValueFactory<>("note"));

        JFXTreeTableColumn<Transaction, String> transactionType = new JFXTreeTableColumn<>("Type");
        transactionType.setPrefWidth(94.5);
        transactionType.setCellValueFactory(new TreeItemPropertyValueFactory<>("type"));

        JFXTreeTableColumn<Transaction, String> transactionDate = new JFXTreeTableColumn<>("Date");
        transactionDate.setPrefWidth(94.5);
        transactionDate.setCellValueFactory(new TreeItemPropertyValueFactory<>("date"));

        JFXTreeTableColumn<Transaction, String> transactionReminder = new JFXTreeTableColumn<>("Reminder");
        transactionReminder.setPrefWidth(94.5);
        transactionReminder.setCellValueFactory(new TreeItemPropertyValueFactory<>("reminder"));

        JFXTreeTableColumn<Transaction, String> transactionSituation = new JFXTreeTableColumn<>("Situation");
        transactionSituation.setPrefWidth(94.5);
        transactionSituation.setCellValueFactory(new TreeItemPropertyValueFactory<>("consolidate"));

        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        for(Object elements:traDao.readAll()){
            transactions.add((Transaction) elements);
        }

        final TreeItem<Transaction> traRoot = new RecursiveTreeItem<>(transactions, RecursiveTreeObject::getChildren);
        transactionTable.getColumns().setAll(transactionDescription, transactionValue, transactionCategory, transactionAccount,
                transactionNote, transactionType, transactionDate, transactionReminder, transactionSituation);
        transactionTable.setRoot(traRoot);
        transactionTable.setShowRoot(false);

        // Category tab
        JFXTreeTableColumn<Category, String> categoryName = new JFXTreeTableColumn<>("Category Name");
        categoryName.setPrefWidth(212.5);
        categoryName.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        JFXTreeTableColumn<Category, String> categoryType = new JFXTreeTableColumn<>("Category Type");
        categoryType.setPrefWidth(212.5);
        categoryType.setCellValueFactory(new TreeItemPropertyValueFactory<>("type"));

        JFXTreeTableColumn<Category, String> categoryColor = new JFXTreeTableColumn<>("Category Color");
        categoryColor.setPrefWidth(212.5);
        categoryColor.setCellValueFactory(new TreeItemPropertyValueFactory<>("categoryColor"));

        JFXTreeTableColumn<Category, String> categoryNote = new JFXTreeTableColumn<>("Category Note");
        categoryNote.setPrefWidth(212.5);
        categoryNote.setCellValueFactory(new TreeItemPropertyValueFactory<>("note"));

        ObservableList<Category> categories = FXCollections.observableArrayList();
        for(Object categoriesElements:catDao.readAll()){
            categories.add((Category) categoriesElements);
        }

        final TreeItem<Category> catRoot = new RecursiveTreeItem<>(categories, RecursiveTreeObject::getChildren);
        categoryTable.getColumns().setAll(categoryName, categoryType, categoryColor, categoryNote);
        categoryTable.setRoot(catRoot);
        categoryTable.setShowRoot(false);

        // Account tab
        JFXTreeTableColumn<Account, String> accountName = new JFXTreeTableColumn<>("Account Name");
        accountName.setPrefWidth(170.2);
        accountName.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        JFXTreeTableColumn<Account, String> iconLetters = new JFXTreeTableColumn<>("Icon Letters");
        iconLetters.setPrefWidth(170.2);
        iconLetters.setCellValueFactory(new TreeItemPropertyValueFactory<>("iconLetters"));

        JFXTreeTableColumn<Account, String> accountNote = new JFXTreeTableColumn<>("Account Note");
        accountNote.setPrefWidth(170.2);
        accountNote.setCellValueFactory(new TreeItemPropertyValueFactory<>("note"));

        JFXTreeTableColumn<Account, String> currentValue = new JFXTreeTableColumn<>("Current Value");
        currentValue.setPrefWidth(170.2);
        currentValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));

        JFXTreeTableColumn<Account, String> accountSituation = new JFXTreeTableColumn<>("Account Situation");
        accountSituation.setPrefWidth(170.2);
        accountSituation.setCellValueFactory(new TreeItemPropertyValueFactory<>("situation"));
        
        ObservableList<Account> accounts = FXCollections.observableArrayList();
        for(Object elements:accDao.read()){
            accounts.add((Account) elements);
        }

        final TreeItem<Account> accRoot = new RecursiveTreeItem<>(accounts, RecursiveTreeObject::getChildren);
        accountTable.getColumns().setAll(accountName, iconLetters, accountNote, currentValue, accountSituation);
        accountTable.setRoot(accRoot);
        accountTable.setShowRoot(false);
    }



}
