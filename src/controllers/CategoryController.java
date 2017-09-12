package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dao.CategoryDAO;
import model.logic.Category;

public class CategoryController {

    @FXML
    private JFXComboBox<String> fieldType;

    @FXML
    private JFXTextField fieldName, fieldNote;

    @FXML
    private JFXColorPicker fieldColor;

    @FXML
    private ObservableList <String> typeList = FXCollections.observableArrayList("Lazer", "Alimentação", "Outros", "Exporádico");

    @FXML
    private JFXButton btnAdd, btnCancel;

    @FXML
    private void initialize(){
        // Initiates the comboBox List
        fieldType.setItems(typeList);
    }

    // Handle the action buttons performance
    @FXML
    private void handleButtons(MouseEvent event){
        // If "Adicionar" is pressed
        if(event.getSource() == btnAdd){

            // Instantiates a new Category Object with the typed values
            Category cat = new Category(){{
                setName(fieldName.getText());
                setCategoryColor(fieldColor.getValue().toString());
                setNote(fieldNote.getText());
                setType(fieldType.getSelectionModel().getSelectedItem());
            }};
            // Instantiates a new CategoryDAO object
            CategoryDAO catDAO = new CategoryDAO();

            // Saves the new info on data
            catDAO.create(cat);
            CategoryDAO.persist();

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
            alert.setContentText("Nova categoria registrada com sucesso!");
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
