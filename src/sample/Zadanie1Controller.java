package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Zadanie1Controller implements Initializable {

    @FXML
    private ComboBox<String> functionComboBox;

    @FXML
    private TextField aTextField;

    @FXML
    private TextField bTextField;

    @FXML
    private TextField epsilonTextField;

    @FXML
    private Button metodaBisekcjiButton;

    @FXML
    private Button regulaFalskiButton;

    @FXML
    private Button metodaSieczychButton;

    @FXML
    private Label metodaBisekcjiLabel;

    @FXML
    private Label regulaFalsiLabel;

    @FXML
    private Label metodaSiecznychLabel;



    public Double getA() {
        String a= aTextField.getText();
        return Double.parseDouble(a);
    }
    public Double getB() {
        String b= bTextField.getText();
        return Double.parseDouble(b);
    }
    public Double getEpsilon(){
        String epsilon= epsilonTextField.getText();
        return Double.parseDouble(epsilon);
    }

    @FXML
    public Rownania getRownanie(){
        String rownanie= functionComboBox.getValue();
        if(Zadanie1.getRownanie(rownanie)==Rownania.rownanie1){
        aTextField.setText("1");
        bTextField.setText("2");
    }
        if(Zadanie1.getRownanie(rownanie)==Rownania.rownanie2){
            aTextField.setText("-1");
            bTextField.setText("2");
        }
        if(Zadanie1.getRownanie(rownanie)==Rownania.rownianie3){
            aTextField.setText("-1");
            bTextField.setText("0");

        System.out.println(">>> "+ Zadanie1.getRownanie(rownanie));


        }
        return Zadanie1.getRownanie(rownanie);

    }



    @FXML
    void setMetodaBisekcjiButton(ActionEvent event) throws IOException {
        double a = getA();
        double b = getB();
        double epsilon = getEpsilon();
        Rownania rownanie= getRownanie();
        String wynik= Zadanie1.metoda_bisekcji( rownanie, a, b, epsilon);
        metodaBisekcjiLabel.setText(wynik);

    }

    @FXML
    void setRegulaFalsiButton(ActionEvent event) throws IOException {
        double a = getA();
        double b = getB();
        double epsilon = getEpsilon();
        Rownania rownanie= getRownanie();
        String wynik= Zadanie1.metodaRegulaFalsi(rownanie,a,b,epsilon);
        regulaFalsiLabel.setText(wynik);

    }

    @FXML
    void setMetodaSieczychButtonn(ActionEvent event) throws IOException {
        double a = getA();
        double b = getB();
        double epsilon = getEpsilon();
        Rownania rownanie= getRownanie();
        System.out.println("ROWNAIE > + " + rownanie);
        String wynik= Zadanie1.metoda_siecznych(rownanie, a,b,epsilon);
        metodaSiecznychLabel.setText(wynik);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //lista funkcji
       // List<String> specializationsList= new ArrayList<>(specializationDictionary.keySet());
        ObservableList<String> list =  FXCollections.observableArrayList(Zadanie1.getDostepneRownania());
        functionComboBox.setItems(list);
        epsilonTextField.setText("0.0001");
    }

    public void Cofnij(ActionEvent actionEvent)throws IOException  {
        Parent functionalityChoiceParent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene funtionalityChoiceScene= new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();
    }
}
