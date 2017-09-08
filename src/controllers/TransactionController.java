package controllers;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.Transaction;

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
    private ObservableList<String> accountList = FXCollections.observableArrayList("Carteira", "Conta Corrente", "Cartão de Crédito");
    private ObservableList<String> categoryList = FXCollections.observableArrayList("Lazer", "Alimentação", "Outros");

    @FXML
    public void handleCheckBox(MouseEvent event) {
        if (event.getSource() == fieldRecip && fieldRecip.isSelected()) {
            fieldDebit.setSelected(false);
        }
        else if (event.getSource() == fieldDebit && fieldDebit.isSelected()) {
            fieldRecip.setSelected(false);
        }
    }

    @FXML
    private void initialize(){
        fieldAccount.setItems(accountList);
        fieldCategory.setItems(categoryList);
    }

    @FXML
    private void handleButtons(MouseEvent event){
        if(event.getSource() == btnAdd){
            Transaction trans = new Transaction(){{
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
            trans.print();
        }
        else if(event.getSource() == btnCancel){
            Node  source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
