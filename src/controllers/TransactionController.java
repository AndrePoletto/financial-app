package controllers;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.AccountDAO;
import model.dao.CategoryDAO;
import model.dao.TransactionDAO;
import model.logic.Account;
import model.logic.Category;
import model.logic.Transaction;

import java.util.List;


public class TransactionController {

    @FXML
    private JFXComboBox<String> fieldAccount, fieldCategory;

    @FXML
    private JFXCheckBox fieldRecip, fieldDebit;

    @FXML
    private JFXButton btnAdd, btnCancel;

    @FXML
    private JFXTextField fieldValue, fieldDescription, fieldNote;

    @FXML
    private JFXDatePicker fieldDate, fieldReminder;

    @FXML
    private JFXToggleButton fieldConsolidate;

    @FXML
    private ObservableList<String> accountList = FXCollections.observableArrayList();
    private ObservableList<String> categoryList = FXCollections.observableArrayList();

    @FXML
    public void handleCheckBox(MouseEvent event) {
        if (event.getSource() == fieldRecip && fieldRecip.isSelected()) {
            fieldDebit.setSelected(false);
        }
        else if (event.getSource() == fieldDebit && fieldDebit.isSelected()) {
            fieldRecip.setSelected(false);
        }
    }

    // Initializes the account and categories comboBoxes
    @FXML
    private void initialize(){
        // Instantiations
        // Instantiates AccountDao and CategoryDao Objects
        AccountDAO accountDAO = new AccountDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        // Instantiates List of Account and Category Objects
        List <Account> accountObjectList = accountDAO.readAll();
        List <Category> categoryObjectList = categoryDAO.readAll();
        // Instantiates Account and Category Strings for ObservableList addition
        String accountListItemName;
        String categoryListItemName;
        // Instantiates Account and Category Objects
        Account accountListItem;
        Category categoryListItem;

        // Receive Items and adds them to the ObservableLists
        // Receive accountListItems
        for (Account anAccountObjectList : accountObjectList) {
            accountListItem = anAccountObjectList;
            accountListItemName = accountListItem.getName();
            accountList.add(accountListItemName);
        }
        // Receive categoryListItems
        for (Category aCategoryObjectList : categoryObjectList) {
            categoryListItem = aCategoryObjectList;
            categoryListItemName = categoryListItem.getName();
            categoryList.add(categoryListItemName);
        }

        // Set comboBoxes Items
        fieldAccount.setItems(accountList);
        fieldCategory.setItems(categoryList);
    }

    // Handle the action buttons performance
    @FXML
    private void handleButtons(MouseEvent event){
        // If "Adicionar" is pressed
        if(event.getSource() == btnAdd){

            // Instantiates a new Transaction Object with the typed values
            Transaction transaction = new Transaction(){{
                setValue(Float.parseFloat(fieldValue.getText()));
                setDescription(fieldDescription.getText());
                setNote(fieldNote.getText());
                setConsolidate(fieldConsolidate.isSelected());
                setDate(fieldDate.getValue());
                setReminder(fieldReminder.getValue());
                setAccount(fieldAccount.getSelectionModel().getSelectedItem());
                setCategory(fieldCategory.getSelectionModel().getSelectedItem());
                if(fieldRecip.isSelected()){
                    setType("Receita");
                }
                else{
                    setType("Débito");
                }
            }};

            // Instantiates a new TransactionDAO object
            TransactionDAO traDAO = new TransactionDAO();

            // Saves the new info on data
            traDAO.create(transaction);
            TransactionDAO.persist();

            // Closes the NewCategory Window
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();

            // Gives addition feedback to user
            // Instantiates a new Alert object
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            // Sets the info title, a null header and the contentText
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Nova transação registrada com sucesso!");
            // Shows the created message
            alert.showAndWait();
        }
        // If "Cancelar" is pressed
        else if(event.getSource() == btnCancel){
            // Closes the NewCategory Window
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
