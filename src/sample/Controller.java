package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button Zadanie1;

    @FXML
    private Button Zadanie2;

    @FXML
    private Button Zadanie3;

    @FXML
    private Button Zadanie4;

    @FXML
    private Button Zadanie9;

    @FXML
    private Button Zadanie13;

    @FXML
    private BorderPane backgroundMain;

    @FXML
    private AnchorPane background;

  @FXML
    void setZadanie1ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie1.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }
    @FXML
    void setZadanie2ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie2.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }

    @FXML
    void setZadanie3ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie3.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }

    @FXML
    void setZadanie4ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie4.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }
    @FXML
    void setZadanie13ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie13.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }

    @FXML
    void setZadanie9ButtonAction(ActionEvent event) throws IOException {
        Parent functionalityChoiceParent = FXMLLoader.load(getClass().getResource("zadanie9.fxml"));
        Scene funtionalityChoiceScene = new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imageFile= new File("src/sample/green/tlo1.png");
        Image imageImage= new Image(imageFile.toURI().toString());

        BackgroundImage backgroundimage = new BackgroundImage(imageImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Background background = new Background(backgroundimage);
        backgroundMain.setBackground(background);
    }
}