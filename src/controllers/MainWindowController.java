package controllers;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class MainWindowController {
    @FXML
    private AnchorPane btnTransaction, btnCategory, btnAccount, btnData, tabTransaction, tabCategory, tabAccount, tabData;

    @FXML
    private Label screenText, btnTransactionText, btnCategoryText, btnAccountText;

    @FXML
    private ImageView transSelecIcon, catSelecIcon, accSelecIcon, dataSelecIcon;

    @FXML
    private JFXButton btnNewTrans, btnNewCat, btnNewAcc;

    @FXML
    private void handleSectionButtonAction(MouseEvent event){
        if (event.getTarget() == btnTransaction || event.getTarget() == btnTransactionText){

            //Controls the tab styles
            btnCategory.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnTransaction.getStyleClass().add("tabControl");

            //Controls the tabTitle of the page
            screenText.setText("Transações");

            //Controls the selected tab icons
            transSelecIcon.setVisible(true);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(true);
            tabCategory.setVisible(false);
            tabAccount.setVisible(false);
        }
        else if (event.getTarget() == btnCategory || event.getTarget() == btnCategoryText){

            //Controls the tab styles
            btnTransaction.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnCategory.getStyleClass().add("tabControl");

            //Controls the tabTitle of the page
            screenText.setText("Categorias");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(true);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(false);
            tabCategory.setVisible(true);
            tabAccount.setVisible(false);
        }
        else if (event.getTarget() == btnAccount || event.getTarget() == btnAccountText){

            //Controls the tab styles
            btnTransaction.getStyleClass().clear();
            btnCategory.getStyleClass().clear();
            btnData.getStyleClass().clear();
            btnAccount.getStyleClass().add("tabControl");

            //Controls the tabTitle of the page
            screenText.setText("Contas");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(true);
            dataSelecIcon.setVisible(false);

            //Controls the tab views
            tabTransaction.setVisible(false);
            tabCategory.setVisible(false);
            tabAccount.setVisible(true);
        }
        else if (event.getTarget() == btnData || event.getTarget() == btnData){

            //Controls the tab styles
            btnTransaction.getStyleClass().clear();
            btnCategory.getStyleClass().clear();
            btnAccount.getStyleClass().clear();
            btnData.getStyleClass().add("tabControl");

            //Controls the tabTitle of the page
            screenText.setText("Dados");

            //Controls the selected tab icons
            transSelecIcon.setVisible(false);
            catSelecIcon.setVisible(false);
            accSelecIcon.setVisible(false);
            dataSelecIcon.setVisible(true);

            //Controls the tab view
            tabTransaction.setVisible(false);
            tabCategory.setVisible(false);
            tabAccount.setVisible(false);
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



}
