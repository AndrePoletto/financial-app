package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import logic.Category;

public class CategoryController {

    @FXML
    private JFXComboBox<String> fieldType;

    @FXML
    private JFXTextField fieldName, fieldNote;

    @FXML
    private JFXColorPicker fieldColor;

    @FXML
    private ObservableList <String> typeList = FXCollections.observableArrayList("Lazer", "Viagens", "Alimentação", "Outros", "Exporádico");

    @FXML
    private JFXButton btnAdd, btnCancel;

    @FXML
    private void initialize(){
        fieldType.setItems(typeList);
    }

    @FXML
    private void handleButtons(MouseEvent event){
        if(event.getSource() == btnAdd){
            Category cat = new Category(){{
                setName(fieldName.getText());
                setCategoryColor(fieldColor.getValue().toString());
                setNote(fieldNote.getText());
                setType(fieldType.getSelectionModel().getSelectedItem());
            }};
            cat.print();
        }
        else if(event.getSource() == btnCancel){
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }
}
