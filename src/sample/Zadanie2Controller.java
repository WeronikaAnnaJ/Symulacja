package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Zadanie2Controller  implements Initializable {
    @FXML
    private AnchorPane metodaProctokatowLabel;

    @FXML
    private TextField xpTextField;

    @FXML
    private TextField xkTextField;

    @FXML
    private TextField nTextField;

    @FXML
    private ComboBox<String> funkcjaComboBox;

    @FXML
    private Button metodaProstokatowButton;

    @FXML
    private Button metodaTrapezowButton;

    @FXML
    private Button metodaParaoliButton;

    @FXML
    private Label metodaTrapezowLabel;

    @FXML
    private Label metodaParaboliLabel;

    @FXML
    private Label metodaProstokatowLabel;

    public Double getXp() {
        String xp= xpTextField.getText();
        return Double.parseDouble(xp);
    }
    public Double getXk() {
        String xk= xkTextField.getText();
        return Double.parseDouble(xk);
    }
    public Integer getN(){
        String n= nTextField.getText();
        return Integer.parseInt(n);
    }

    //get wybor combo box
    //slownik

    public Funkcje geFunkcja(){
        String rownanie= funkcjaComboBox.getValue();

        System.out.println(">>> "+ Zadanie1.getRownanie(rownanie));

        return Zadanie2.getFunkcje(rownanie);
    }

    @FXML
    void obliczMetodaProctokatow(ActionEvent event) throws IOException {
        double xp=getXp();
        double xk=getXk();
        int n= getN();
        Funkcje funkcja=geFunkcja();
        String wynik= Zadanie2.metodaProstokatow(xp,xk,n,funkcja);
        metodaProstokatowLabel.setText(wynik);
    }


    @FXML
    void obliczMetodaTrapezow(ActionEvent event) throws IOException {
        double xp=getXp();
        double xk=getXk();
        int n= getN();
        Funkcje funkcja=geFunkcja();
        String wynik= Zadanie2.metodaTrapezow(xp,xk,n,funkcja);
        metodaTrapezowLabel.setText(wynik);
    }

    @FXML
    void obliczMetodaParaboli(ActionEvent event) throws IOException {
        double xp=getXp();
        double xk=getXk();
        int n= getN();
        Funkcje funkcja=geFunkcja();
        String wynik= Zadanie2.metodaParaboli(xp,xk,n,funkcja);
        metodaParaboliLabel.setText(wynik);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            //lista funkcji
            // List<String> specializationsList= new ArrayList<>(specializationDictionary.keySet());
            ObservableList<String> list =  FXCollections.observableArrayList(Zadanie2.getDostepneFunkcje());
            funkcjaComboBox.setItems(list);

    }


    public void Cofnij(ActionEvent actionEvent)throws IOException  {
        Parent functionalityChoiceParent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene funtionalityChoiceScene= new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();
    }

    public void WyswietlSciage(ActionEvent actionEvent) {
    /*    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Potwierdzenie wizyty");
        alert.setHeaderText("Wybrana wizyta");
        alert.setContentText("Funkcja 1 : pow(x,2)*(-1)-x+10 " + "\nPrzedział :   <1, 2> " + "\nWartość : 37/6\n\n" +
                "Funkcja 2 : pow(x,2)+ 2*x " + "\nPrzedział :   <-1, 10> " + "\nWartość : 1298/3\n\n" +
                "Funkcja 3 : pow(x,4)+ pow(x,2)+ 2*x +2 " + "\nPrzedział :   <-3, 3> " + "\nWartość : 636/5");*/

        Label secondLabel = new Label("Funkcja 1 : pow(x,2)*(-1)-x+10 " + "\nPrzedział :   <1, 2> " + "\nWartość : 37/6\n\n" +
                "Funkcja 2 : pow(x,2)+ 2*x " + "\nPrzedział :   <-1, 10> " + "\nWartość : 1298/3\n\n" +
                "Funkcja 3 : pow(x,4)+ pow(x,2)+ 2*x +2 " + "\nPrzedział :   <-3, 3> " + "\nWartość : 636/5");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 300, 300);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Ściąga");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window.
        newWindow.setX(400);
        newWindow.setY(400);

        newWindow.show();

    }

}


