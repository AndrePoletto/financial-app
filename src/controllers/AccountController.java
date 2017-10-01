package controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.AccountDAO;
import model.logic.Account;


public class AccountController {

    @FXML
    private JFXTextField fieldName, fieldNote, fieldInitValue, fieldIcon;

    @FXML
    private JFXToggleButton fieldActivate;

    @FXML
    private JFXButton btnAdd, btnCancel;

    // Handle the action buttons performance
    @FXML
    private void handleButtons(MouseEvent event){
        // If "Adicionar" is pressed
        if(event.getSource() == btnAdd){

            // Instantiates a new Account Object with the typed values
            Account acc = new Account(fieldName.getText(), fieldIcon.getText(), fieldNote.getText(), Float.parseFloat(fieldInitValue.getText()), fieldActivate.isSelected());

            // Instantiates a new AccountDAO object
            AccountDAO accDAO = new AccountDAO();

            // Saves the new info on data
            accDAO.create(acc);
            AccountDAO.persist();

            // Closes the NewAccount Window
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();

            // Gives addition feedback to user
            // Instantiates a new Alert object
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            // Sets the info title, a null header and the contentText
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Nova conta registrada com sucesso!");
            // Shows the created message
            alert.showAndWait();
        }
        // If "Cancelar" is pressed
        else if(event.getSource() == btnCancel){
            // Closes the NewAccount Window
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
