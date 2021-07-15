package sample;


import com.sun.javafx.collections.ImmutableObservableList;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Zadanie3Controller implements Initializable {

    private GraphicsContext graphicsContext;

    @FXML
    private Button obliczPoleWieokatuButton;

    @FXML
    private TextField xpPoczatekTextField;

    @FXML
    private TextField xkKoniecTextField;

    @FXML
    private TextField dokadnoscTextField;

    @FXML
    private Button obliczPolePodWykresemButton;

    @FXML
    private ComboBox<String> functionChoiceBox;

    @FXML
    private Label wynikFunkcjiLabel;

    @FXML
    private Label o;

    @FXML
    private Canvas canvas;

    @FXML
    private TableColumn<Wierzcholek,Double> yKolumna;

    @FXML
    private TableColumn<Wierzcholek, Double> xKolumna;

    @FXML
    private Button dodajWierzcholekButton;

    @FXML
    private TextField xTextField;

    @FXML
    private TextField yTextField;

    @FXML
    private Label poleWielokatuLabel;


    private int liczbaWierzcholkow;

    private List<Wierzcholek> list= new ArrayList<>();
    private  ObservableList<Wierzcholek> wierzcholki=  FXCollections.observableList(list);
    private ArrayList<Double> xWszystkie= new ArrayList<>();
    private ArrayList<Double> yWszystkie= new ArrayList<>();

    @FXML
    private TableView<Wierzcholek> tabela;

    //lista wierzcholkow
    @FXML
    void dodajWierzcholek(ActionEvent event) {

        try {
            double x= getX();
            System.out.println(" x = " + x);
            double y= getY();
            System.out.println(" y = " + y);
            Wierzcholek wierzcholek= new Wierzcholek(x, y);
            xWszystkie.add(x);
            yWszystkie.add(y);

            //list.add(0,wierzcholek);
            wierzcholki.add(wierzcholek);



        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public double getX()throws Exception{
        return  Double.parseDouble(xTextField.getText());
    }

    public double getY()throws Exception{
        return  Double.parseDouble(yTextField.getText());
    }


    public Double getXp() {
        String xp= xpPoczatekTextField.getText();
        return Double.parseDouble(xp);
    }
    public Double getXk() {
        String xk= xkKoniecTextField.getText();
        return Double.parseDouble(xk);
    }
    public Integer getN(){
        String n= dokadnoscTextField.getText();
        return Integer.parseInt(n);
    }

    //get wybor combo box
    //slownik

    public Funkcje getFunkcja(){
        String rownanie= functionChoiceBox.getValue();
        System.out.println(">>> "+ Zadanie1.getRownanie(rownanie));
        return Zadanie2.getFunkcje(rownanie);
    }

    @FXML
    void obliczPolePodWykresem(ActionEvent event) throws Exception {


        double xp=getXp();
        double xk=getXk();
        int n= getN();
        Funkcje funkcja =getFunkcja();
        System.out.println( "Calkowanie metoda monte Carlo");
        double wynikMonteCarlo= Zadanie3.metodaMonteCarlo(xp,xk , n, funkcja);
        System.out.println(wynikMonteCarlo);
        wynikFunkcjiLabel.setText(wynikMonteCarlo +" ");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.add(new Wierzcholek(0, -15));
        list.add(new Wierzcholek(-2, -4));
        list.add(new Wierzcholek(-7, -7));
        list.add(new Wierzcholek(-4, -2));
        list.add(new Wierzcholek(-10,0));
        list.add(new Wierzcholek(-4, 2));
        list.add(new Wierzcholek(-7, 7));
        list.add(new Wierzcholek(-2, 4));
        list.add(new Wierzcholek(0, 10));
        list.add(new Wierzcholek(2, 4));
        list.add(new Wierzcholek(7, 7));
        list.add(new Wierzcholek(4, 2));
        list.add(new Wierzcholek(10, 0));
        list.add(new Wierzcholek(4, -2));
        list.add(new Wierzcholek(7, -7));
        list.add(new Wierzcholek(2, -4));

        for(int i =0 ; i < list.size() ; i++){
            xWszystkie.add(list.get(i).getX());
            yWszystkie.add(list.get(i).getY());
        }

        tabela.setItems( wierzcholki);
        yKolumna.setCellValueFactory(new PropertyValueFactory<>("Y"));
        xKolumna.setCellValueFactory(new PropertyValueFactory<>("X"));
        draw();
        ObservableList<String> list =  FXCollections.observableArrayList(Zadanie2.getDostepneFunkcje());
        functionChoiceBox.setItems(list);

    }

    @FXML
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
    @FXML
    public void draw(){
        Affine affine = new Affine();
        affine.appendScale(400/50, 400/50);
        graphicsContext= canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITESMOKE);
        graphicsContext.fillRect(0,0,400,400);
        //   System.out.println("ZADANIE W PLANSZA>>" + zadanie4.plansza.length + " > " + zadanie4.plansza[2].length);
        //wylosuj zeby bylo w srodku na pewno


        graphicsContext.setTransform(affine);

        graphicsContext.setStroke(Color.DARKGREY);
        graphicsContext.setLineWidth(0.05f);
        for(int x=0; x<50;x++){
            graphicsContext.strokeLine(x,0, x, 50);
        }
        for(int y=0; y<50;y++){
            graphicsContext.strokeLine(0, y,50, y);
        }



        graphicsContext.setStroke(Color.DARKGREY);
        graphicsContext.setLineWidth(0.1f);
        graphicsContext.strokeLine(0, 25,50,25);
        graphicsContext.strokeLine(25, 0,25,50);


        //srdek 25 , 25


    }


    public void obliczPoleWielokatu(ActionEvent actionEvent) {
        int m = xWszystkie.size();
        int startX = 10;
        int startY = 20;
        int koniecX = 100;
        int koniecY = 200;
        // Współrzędne początku i końca linii ustawiane za pomocą konstruktora


        int w_poprzedni=0;
        int w=w_poprzedni+1;
        graphicsContext.setStroke(Color.GREEN);
        graphicsContext.setLineWidth(0.2f);

        for (int i =0 ; i< xWszystkie.size() ; i ++){
            double Ax=25+ xWszystkie.get(w_poprzedni);
            double Ay=25- yWszystkie.get(w_poprzedni);
            double Bx=25+ xWszystkie.get(w);
            double By=25- yWszystkie.get(w);
            graphicsContext.strokeLine(Ax,Ay,Bx, By);
            w_poprzedni++;
            w++;
            if(w==xWszystkie.size()){
                w=0;
            }
        }


        double[] arrayX = new double[m];
        double[] arrayY = new double[m];

        for(int i =0; i < xWszystkie.size() ; i ++){
            arrayX[i]=xWszystkie.get(i);
        }
        for(int i =0; i < yWszystkie.size() ; i ++){
            arrayY[i]=yWszystkie.get(i);
        }

        //przykładowe wierzcholki
        //(3,4),(3,11),(10,11),(11,4) //jak zegar po kolei

        //Obliczenie pola wielokątu metodą Monte Carlo
        // wejście : 2 tabele , tabela1- współrzędne x wszytskich wierzchołków po kolei, tabela2- współrzędne y wszytskich wierzchołków po kolei)
        //m to liczba wierzchołków
        //ilośc losowań liczb



        // szerokość

        Zadanie3Figura figura= new Zadanie3Figura(arrayX,arrayY,1000);
        double pole= figura.obliczPoleWielokatu();
        poleWielokatuLabel.setText(pole + "");
    }

    public void cofnij(ActionEvent actionEvent) {
    }


    public void Cofnij(ActionEvent actionEvent)throws IOException {
        Parent functionalityChoiceParent= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene funtionalityChoiceScene= new Scene(functionalityChoiceParent);
        Stage stage = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        stage.hide();
        stage.setScene(funtionalityChoiceScene);
        stage.show();
    }

    public void Resetuj(ActionEvent actionEvent) {
        list= new ArrayList<>();
        wierzcholki=  FXCollections.observableList(list);
        tabela.setItems( wierzcholki);
        xWszystkie= new ArrayList<>();
        yWszystkie= new ArrayList<>();
        draw();
    }

    public static class Wierzcholek {
    private  final SimpleDoubleProperty  x;
    private  final SimpleDoubleProperty y;
    Wierzcholek(double x, double y){
        this.x=new SimpleDoubleProperty(x);
        this.y=new SimpleDoubleProperty(y);
    }
    public double getX(){
        return x.get();
}
        public double getY(){
            return y.get();
        }




}}