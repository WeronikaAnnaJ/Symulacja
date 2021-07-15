package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class Zadanie13Controller implements Initializable {


    private Map<Integer, List<List<Integer>>> wynikiGry1 = new TreeMap<>();
    private Map<Integer, List<List<Integer>>> wynikiGry2 = new TreeMap<>();
    private Map<Integer, List<List<Integer>>> wynikiGry3 = new TreeMap<>();
    private int liczbaKolejek;
    private int liczbaGraczy1;
    private int liczbaGraczy2;
    private int liczbaGraczy3;
    private int Orzel1;
    private int Orzel2;
    private int Orzel3;
    private int Reszka1;
    private int Reszka2;
    private int Reszka3;

    XYChart.Series dataSeries1 = new XYChart.Series();
    XYChart.Series dataSeries2 = new XYChart.Series();
    XYChart.Series dataSeries3 = new XYChart.Series();
    @FXML
    private BarChart<?, ?> gra1Chart;

    @FXML
    private BarChart<?, ?> gra2Chart;

    @FXML
    private BarChart<?, ?> gra3Chart;

    @FXML
    private TextField iloscKolejekTextField;

    @FXML
    private TextField gracze1TextField;

    @FXML
    private TextField gracze2TextField;

    @FXML
    private TextField gracze3TextField;

    @FXML
    private Button losujButton;

    @FXML
    private Label gra1OrzelLabel;


    @FXML
    private Label gra1ReszkaLabel;

    @FXML
    private Label gra2OrzelLabel;


    @FXML
    private Label gra2ReszkaLabel;

    @FXML
    private Label gra3OrzelLabel;


    @FXML
    private Label gra3ReszkaLabel;


    public void getLiczbeKolejek() {
        String liczbaKolejekText = iloscKolejekTextField.getText();
        liczbaKolejek = Integer.parseInt(liczbaKolejekText);
    }

    public void getGracze1() throws Exception {
        String gracze1Text = gracze1TextField.getText();
        liczbaGraczy1 = Integer.parseInt(gracze1Text);
    }

    public void getGracze2() throws Exception {
        String gracze2Text = gracze2TextField.getText();
        liczbaGraczy2 = Integer.parseInt(gracze2Text);
    }

    public void getGracze3() throws Exception {
        String gracze3Text = gracze3TextField.getText();
        liczbaGraczy3 = Integer.parseInt(gracze3Text);
    }



    @FXML
    private void rozpocznijLosowanie(ActionEvent event) {
        resetuj();
        getLiczbeKolejek();
        System.out.println("rozpocznij losowanie");
        int liczbaGier = 0;
        try {
            getGracze1();
            liczbaGier++;
            System.out.println("gracze 1 " + liczbaGraczy1);
        } catch (Exception e) {
            liczbaGraczy1 = 0;
        }
        try {
            getGracze2();
            System.out.println("gracze 2 " + liczbaGraczy2);
            liczbaGier++;
        } catch (Exception e) {
            liczbaGraczy2 = 0;
        }
        try {
            getGracze3();
            liczbaGier++;
            System.out.println("gracze 3 " + liczbaGraczy3);
        } catch (Exception e) {
            liczbaGraczy3 = 0;
        }
        System.out.println("liczba gier " + liczbaGier);


        for (int i = 0; i < liczbaKolejek; i++) {
            System.out.println("\nKOLEJKA >  " + i);


            //GRA1
            System.out.println("\n> GRA1");
            for (int j = 0; j < liczbaGraczy1; j++) {
                //wkladanie do mapy graczy
                if (!wynikiGry1.containsKey(j)) {
                    wynikiGry1.put(j, new ArrayList<>());
                }
                //losu
                //
                System.out.println("\n> gracz " + j);
                List<Integer> wylosowaneOczka = new ArrayList<>();
                System.out.print("Wylosowane oczka : ");

                int sumaOczek = 0;
                for (int k = 0; k < i; k++) {
                    Random rand = new Random();
                    int oczka = rand.nextInt(6) + 1;
                    wylosowaneOczka.add(oczka);
                    sumaOczek += oczka;
                    System.out.print(oczka + " , ");
                }
                if (sumaOczek % 2 == 0) {
                    Orzel1++;
                } else {
                    Reszka1++;
                }
                List<List<Integer>> wyniki1 = wynikiGry1.get(j);
                wyniki1.add(wylosowaneOczka);
                wynikiGry1.replace(j, wyniki1);
            }


            //gra2
            System.out.println("\n> GRA 2");
            for (int j = 0; j < liczbaGraczy2; j++) {
                //wkladanie do mapy graczy
                if (!wynikiGry2.containsKey(j)) {
                    wynikiGry2.put(j, new ArrayList<>());
                }
                //losu
                //
                System.out.println("\n> gracz " + j);
                List<Integer> wylosowaneOczka = new ArrayList<>();
                System.out.print("Wylosowane oczka : ");

                int sumaOczek = 0;
                for (int k = 0; k < i; k++) {
                    Random rand = new Random();
                    int oczka = rand.nextInt(6) + 1;
                    wylosowaneOczka.add(oczka);
                    sumaOczek += oczka;
                    System.out.print(oczka + " , ");
                }

                if (sumaOczek % 2 == 0) {
                    Orzel2++;
                } else {
                    Reszka2++;
                }

                List<List<Integer>> wyniki1 = wynikiGry2.get(j);
                wyniki1.add(wylosowaneOczka);
                wynikiGry2.replace(j, wyniki1);

            }


            //gra3

            System.out.println("\n> GRA 3");
            for (int j = 0; j < liczbaGraczy3; j++) {
                //wkladanie do mapy graczy
                if (!wynikiGry3.containsKey(j)) {
                    wynikiGry3.put(j, new ArrayList<>());
                }
                //losu
                //
                System.out.println("\n> gracz " + j);
                List<Integer> wylosowaneOczka = new ArrayList<>();
                System.out.print("Wylosowane oczka : ");

                int sumaOczek = 0;
                for (int k = 0; k < i; k++) {
                    Random rand = new Random();
                    int oczka = rand.nextInt(6) + 1;
                    wylosowaneOczka.add(oczka);
                    sumaOczek += oczka;
                    System.out.print(oczka + " , ");
                }

                if (sumaOczek % 2 == 0) {
                    Orzel3++;
                } else {
                    Reszka3++;
                }
                List<List<Integer>> wyniki1 = wynikiGry3.get(j);
                wyniki1.add(wylosowaneOczka);
                wynikiGry3.replace(j, wyniki1);

            }

        }
        System.out.println("gra 1 \n R"  + Reszka1  + " 0 " + Orzel1 );
        System.out.println("gra 1 \n R"  + Reszka2  + " 0 " + Orzel2);
        System.out.println("gra 1 \n R"  + Reszka3  + " 0 " + Orzel3);

        gra1OrzelLabel.setText( "Orzeł : " + Orzel1 );
        gra2OrzelLabel.setText( "Orzeł : " + Orzel2 );
        gra3OrzelLabel.setText( "Orzeł : " + Orzel3 );
        gra1ReszkaLabel.setText("Reszka : " + Reszka1);
        gra2ReszkaLabel.setText("Reszka : " + Reszka2);
        gra3ReszkaLabel.setText("Reszka : " + Reszka3);

        dataSeries1.getData().add(new XYChart.Data("Orzeł", Orzel1));
        dataSeries1.getData().add(new XYChart.Data("Reszka"  , Reszka1));
        gra1Chart.getData().add(dataSeries1);

        dataSeries2.getData().add(new XYChart.Data("Orzeł", Orzel2));
        dataSeries2.getData().add(new XYChart.Data("Reszka"  , Reszka2));
        gra2Chart.getData().add(dataSeries2);

        dataSeries3.getData().add(new XYChart.Data("Orzeł", Orzel3));
        dataSeries3.getData().add(new XYChart.Data("Reszka"  , Reszka3));
        gra3Chart.getData().add(dataSeries3);

    }


    public void resetuj() {
        wynikiGry3=new TreeMap<>();
        wynikiGry1=new TreeMap<>();
        wynikiGry2= new TreeMap<>();
        Orzel1=0;
        Orzel2=0;
        Orzel3=0;
        Reszka1=0;
        Reszka2=0;
        Reszka3=0;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Wynik gry 1");

      dataSeries1.getData().add(new XYChart.Data("Orzeł", 0));
        dataSeries1.getData().add(new XYChart.Data("Reszka"  , 0));


        gra1Chart.getData().add(dataSeries1);
        gra1Chart.isVisible();

        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries1.setName("Wynik gry 2");

        dataSeries2.getData().add(new XYChart.Data("Orzeł", 0));
        dataSeries2.getData().add(new XYChart.Data("Reszka"  , 0));


        gra2Chart.getData().add(dataSeries2);
        gra2Chart.isVisible();

        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries1.setName("Wynik gry 3");

      dataSeries3.getData().add(new XYChart.Data("Orzeł", 0));
       dataSeries3.getData().add(new XYChart.Data("Reszka"  , 0));


       gra3Chart.getData().add(dataSeries3);
        gra3Chart.isVisible();

    }


    public void Cofnij(ActionEvent actionEvent)throws IOException {
        Parent functionalityChoiceParent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene funtionalityChoiceScene= new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();
    }

    //metoda losowania
    //sprawdz czy orzeł czy reszka

    //policzyc orły i reszki wyrzucone podczas gry 1, 2 ,3
    // wyswietlić o:
    //wyswietlić r : dla każdej z gier
    //stworzyć wykres

}

