package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import logic.Account;
import logic.Category;
import logic.Transaction;

import java.text.ParseException;


public class Controller {

    @FXML
    private AnchorPane btnTran, btnCat, btnAco, screenTran, screenCat, screenAco;

    @FXML
    private Label screenText;

    @FXML
    private JFXTextField fieldValue, fieldDescription, fieldInitValue, fieldAccountName, fieldInitials, fieldCategoryName;

    @FXML
    private JFXCheckBox fieldRecip, fieldDebit;

    @FXML
    private JFXTextArea fieldNote, fieldCategoryNote, fieldAccountNote;

    @FXML
    private JFXToggleButton fieldConsolidate, fieldActivate;

    @FXML
    private JFXDatePicker fieldDate, fieldReminder;

    @FXML
    private JFXColorPicker fieldCategoryColor;

    @FXML
    private JFXComboBox <String> fieldAccount, fieldCategory, fieldCategoryType;

    @FXML
    private javafx.scene.image.ImageView transSelecIcon, catSelecIcon, acoSelecIcon;

    @FXML
    private JFXButton btnSubTrans, btnSubCat, btnSubAco;

    @FXML
    private ObservableList<String> accountList = FXCollections.observableArrayList("Carteira", "Conta Corrente", "Cartão de Crédito");
    private ObservableList<String> categoryList = FXCollections.observableArrayList("Lazer", "Alimentação", "Outros");
    private ObservableList<String> categoryTypeList = FXCollections.observableArrayList("Lazer", "Viagens", "Alimentação", "Outros", "Exporádico");

    @FXML
    private void initialize(){
        fieldAccount.setItems(accountList);
        fieldCategory.setItems(categoryList);
        fieldCategoryType.setItems(categoryTypeList);
    }

    @FXML
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() == fieldRecip && fieldRecip.isSelected()) {
            fieldDebit.setSelected(false);
        }
        else if (mouseEvent.getSource() == fieldDebit && fieldDebit.isSelected()) {
            fieldRecip.setSelected(false);
        }
    }

    @FXML
    private void handleButtonAction(MouseEvent event){
        if (event.getTarget() == btnTran){
            screenText.setText("Transações");
            transSelecIcon.setVisible(true);
            catSelecIcon.setVisible(false);
            acoSelecIcon.setVisible(false);
            screenTran.setVisible(true);
            screenCat.setVisible(false);
            screenAco.setVisible(false);
        }
        else if (event.getTarget() == btnCat){
            screenText.setText("Categorias");
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(true);
            acoSelecIcon.setVisible(false);
            screenTran.setVisible(false);
            screenCat.setVisible(true);
            screenAco.setVisible(false);
        }
        else if (event.getTarget() == btnAco){
            screenText.setText("Contas");
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            acoSelecIcon.setVisible(true);
            screenTran.setVisible(false);
            screenCat.setVisible(false);
            screenAco.setVisible(true);
        }
    }

    @FXML
    private void handleButtonSubmit(MouseEvent event) throws ParseException {
        if (event.getSource() == btnSubTrans){
            Transaction trans = new Transaction();

            trans.setValue(Float.parseFloat(fieldValue.getText()));
            trans.setDescription(fieldDescription.getText());
            trans.setNote(fieldNote.getText());
            trans.setConsolidate(fieldConsolidate.isSelected());
            trans.setDate(fieldDate.getValue());
            trans.setReminder(fieldReminder.getValue());
            trans.setAccount(fieldAccount.getSelectionModel().getSelectedItem());
            trans.setCategory(fieldCategory.getSelectionModel().getSelectedItem());
            if(fieldRecip.isSelected()){
                trans.setType("Receita");
            }
            else{
                trans.setType("Débito");
            }
            trans.printAt();
        }
        else if (event.getSource() == btnSubCat){
            Category cat = new Category();
            cat.setName(fieldCategoryName.getText());
            cat.setCategoryColor(fieldCategoryColor.getValue().toString());
            cat.setNote(fieldCategoryNote.getText());
            cat.setType(fieldCategoryType.getSelectionModel().getSelectedItem());
            cat.printCa();
        }
        else if (event.getSource() == btnSubAco){
            Account acc = new Account();
            acc.setIconLetters(fieldInitials.getText());
            acc.setInitialValue(Float.parseFloat(fieldInitValue.getText()));
            acc.setName(fieldAccountName.getText());
            acc.setNote(fieldAccountNote.getText());
            acc.setSituation(fieldActivate.isSelected());
            acc.printAc();
        }
    }

    @FXML
    private void handleClose(){
        System.exit(0);
    }



}
