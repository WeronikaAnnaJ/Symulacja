package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Zadanie9Controller {

    //procesy Marcova
    // m <= N
    //N= krok na prawo + kroki na lewo
    // m = kroki na prawo - kroki na lewo = kroki na prawo - ( n - kroki na lewno)= 2 nr - N
    //prawdopodobienstwo, ze pijak pokonal pewna drogę  p^nr + p^nl
    //liczba realizaccji dróg N!/(nr!-nl!)
    //prawdopodobieństwo wwykonania nr kroków w prawo i nl kroków w lewo wynosi
    //PN= N!/(nr!*nl!) * p^nr * qnl
    @FXML
    private Label liczbaRealizacjiDrogLabel;

    @FXML
    private TextField NliczbaKrokowTextField;

    @FXML
    private TextField xmlMiejsceDoceloweTextField;

    @FXML
    private TextField lDlugoscKrokuTextField;

    @FXML
    private TextField pPrawdopodobienstwoPrawoTextField;

    @FXML
    private Label qPrawdopodobienstwoLewoLabel;

    @FXML
    private Label prawdopodobienstwoWyboruDrogiLabel;

    @FXML
    private Label prawdopodobienstwoDoceloweLabel;

    @FXML
    private Button obliczPrawdopodobienstoButton;

    @FXML
    private Label krokiWPrawo;

    @FXML
    private Label krokiWLewo;


    private double dlugoscKrokow; //w m
    private int liczaKrokow;
    private double miejsceDocelowe;
    private double prawdopodobienstwoPrawo;
    private double prawdopodobienstwoLewo;
    private double m;
    private int liczkaKrokowPrawo;
    private int liczbaKrokowLewo;
    private double prwdopodobienstwoWyboruDrogi;
    private double liczbaRealizacjiDrog;
    private double prawdopodobienstwoDocelowe;


    @FXML
    public void obliczPrawdopodobienstwo(ActionEvent actionEvent) {
        try {
            getDlugoscKrokow();
            getLiczbaKrokow();
            getMiejsceDocelowe();
            getPrawdopodobienstwoPrawo();

        } catch (Exception e) {
            e.printStackTrace();
        }


        obliczM();
        obliczLiczbaKrokowPrawo();
        obliczLiczbaKrokowLewo();
        obliczPrawopdobienstwoWyboruDrogi();
        DecimalFormat df = new DecimalFormat("###.############################");
       // prawdopodobienstwoWyboruDrogiLabel.setText(df.format(prwdopodobienstwoWyboruDrogi)+"");
        obliczLiczbeRealizacjiDrog();
      //  liczbaRealizacjiDrogLabel.setText(df.format(liczbaRealizacjiDrog)+"");
        obliczPrawdopodobienstwoDocelowe();
        prawdopodobienstwoDoceloweLabel.setText(df.format(prawdopodobienstwoDocelowe)+"");
    }

    public void getDlugoscKrokow() throws Exception {
        String dlugoscKrokowText = lDlugoscKrokuTextField.getText();
        dlugoscKrokow = Double.parseDouble(dlugoscKrokowText);
    }

    public void getLiczbaKrokow() throws Exception {
        String liczbaKrokowText = NliczbaKrokowTextField.getText();
        liczaKrokow = Integer.parseInt(liczbaKrokowText);
    }

    public void getMiejsceDocelowe() throws Exception {
        String miejsceDoceloweText = xmlMiejsceDoceloweTextField.getText();
        miejsceDocelowe = Double.parseDouble(miejsceDoceloweText);
    }


    public void getPrawdopodobienstwoPrawo() throws Exception {
        String prawdopodobienstwoPrawoText = pPrawdopodobienstwoPrawoTextField.getText();
        prawdopodobienstwoPrawo = Double.parseDouble(prawdopodobienstwoPrawoText);
        prawdopodobienstwoLewo = 1 - prawdopodobienstwoPrawo;
        qPrawdopodobienstwoLewoLabel.setText(prawdopodobienstwoLewo + "");
    }


    public void obliczM() {
        m = miejsceDocelowe / dlugoscKrokow;
    }

    public void obliczLiczbaKrokowPrawo() {
        liczkaKrokowPrawo = (int) ((liczaKrokow + m) / 2);
        System.out.println("Liczba krokow w prawo " + liczkaKrokowPrawo);
        krokiWPrawo.setText(liczkaKrokowPrawo+"");
    }

    public void obliczLiczbaKrokowLewo() {
        liczbaKrokowLewo = (int) (( liczaKrokow-liczkaKrokowPrawo ));
        System.out.println("Liczba krokow w lewo" + liczbaKrokowLewo);
        krokiWLewo.setText(liczbaKrokowLewo + "" );
    }

    public void obliczPrawopdobienstwoWyboruDrogi() {
        System.out.println("Prawdopodobieńtwo wyboru 2 drogi "+  Math.pow(prawdopodobienstwoPrawo, liczkaKrokowPrawo) * Math.pow(prawdopodobienstwoLewo, liczbaKrokowLewo));
        System.out.println("Prawdopodobieńtwo wyboru 2 drogi  b "+   Math.pow(prawdopodobienstwoPrawo, liczkaKrokowPrawo) * Math.pow(1- prawdopodobienstwoPrawo, (liczaKrokow-liczkaKrokowPrawo)));

            prwdopodobienstwoWyboruDrogi = Math.pow(prawdopodobienstwoPrawo, liczkaKrokowPrawo) * Math.pow(1- prawdopodobienstwoPrawo, (liczaKrokow-liczkaKrokowPrawo));

    }

    public void obliczLiczbeRealizacjiDrog() {
        System.out.println(" silnia(liczaKrokow) :  " +silnia(liczaKrokow));
        System.out.println(" silnia(liczkaKrokowPrawo) :  " +silnia(liczkaKrokowPrawo));
        System.out.println(" silnia(liczbaKrokowLewo :  " +silnia(liczbaKrokowLewo));
        System.out.println(" dzielnik :  " +silnia(liczkaKrokowPrawo) * silnia(liczbaKrokowLewo));
        liczbaRealizacjiDrog = silnia(liczaKrokow) / ((silnia(liczkaKrokowPrawo) * silnia(liczbaKrokowLewo)));
    }

    public void obliczPrawdopodobienstwoDocelowe() {
        prawdopodobienstwoDocelowe = prwdopodobienstwoWyboruDrogi * liczbaRealizacjiDrog;
    }


        public static int silnia(int i)
        {
            if (i < 1)
                return 1;
            else
                return i * silnia(i - 1);
        }



    public void Cofnij(ActionEvent actionEvent)throws IOException {
        Parent functionalityChoiceParent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene funtionalityChoiceScene= new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();
    }

}