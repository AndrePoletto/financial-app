package controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.Account;

public class AccountController {

    @FXML
    private JFXTextField fieldName, fieldNote, fieldInitValue, fieldIcon;

    @FXML
    private JFXToggleButton fieldActivate;

    @FXML
    private JFXButton btnAdd, btnCancel;

    @FXML
    private void handleButtons(MouseEvent event){
        if(event.getTarget() == btnAdd){
            Account acc = new Account(){{
                setIconLetters(fieldIcon.getText());
                setValue(Float.parseFloat(fieldInitValue.getText()));
                setName(fieldName.getText());
                setNote(fieldNote.getText());
                setSituation(fieldActivate.isSelected());
            }};
            acc.print();
        }
        else if(event.getTarget() == btnCancel){
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
