package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.stage.Stage;

import java.io.IOException;

public class Zadanie4Controller extends Thread{

    private boolean status;
    Zadanie4 zadanie4;
    private Affine affine;
    private int iloscEpok;

    @FXML
    private TextField rozmiarTextField;

    @FXML
    private TextField epokiTextField;

    @FXML
    private Button rozpoczecieButton;

    @FXML
    private AnchorPane tabelaPane;

    @FXML
    private AnchorPane tablicaGryPane;

    @FXML
    private Button nastepnaEpokaButton;

    @FXML
    private Canvas canvas;


    public int getRozmiar() {
        String rozmiar = rozmiarTextField.getText();
      //  System.out.println(rozmiar);
        return Integer.parseInt(rozmiar);
    }


    public void startGame(ActionEvent actionEvent) {
        int rozmiar = getRozmiar();
        zadanie4 = new Zadanie4(rozmiar);
        zadanie4.setAlive(8,2);
        zadanie4.setAlive(20,10);
        zadanie4.setAlive(4,2);
        zadanie4.setAlive(3,8);
        zadanie4.setAlive(5,11);
        zadanie4.setAlive(9,2);
        zadanie4.setAlive(10,10);
        zadanie4.setAlive(6,3);
        zadanie4.setAlive(4,8);
        zadanie4.setAlive(5,8);

        System.out.println("SET ALIVER RANDOM CELLS" + rozmiar);

        zadanie4.setAliveRandomCells(zadanie4.getRozmiar() * 10);
        draw();


        //wylouj dużo i przerpowadź
        //zrób zeby automatycznie przechodziły prrzycistk start i stop

    }

    @FXML
    public void draw(){
        affine= new Affine();
        affine.appendScale(400/getRozmiar(), 400/getRozmiar());
        GraphicsContext graphicsContext= canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0,0,400,400);
     //   System.out.println("ZADANIE W PLANSZA>>" + zadanie4.plansza.length + " > " + zadanie4.plansza[2].length);
        //wylosuj zeby bylo w srodku na pewno


        graphicsContext.setTransform(affine);
        graphicsContext.setFill(Color.GREEN);
        for(int x =0 ; x < zadanie4.getRozmiar() ; x++){
            for(int y =0 ; y< zadanie4.getRozmiar();y++){
                if(zadanie4.plansza[x][y] ==1)
                graphicsContext.fillRect(x,y,1,1);
            }
        }

        graphicsContext.setStroke(Color.DARKGREY);
        graphicsContext.setLineWidth(0.05f);
        for(int x=0; x<zadanie4.getRozmiar();x++){
            graphicsContext.strokeLine(x,0, x, getRozmiar());
        }
        for(int y=0; y<zadanie4.getRozmiar();y++){
            graphicsContext.strokeLine(0, y, getRozmiar(), y);
        }
    }

    @FXML
    public void przeprowadzEpoke(ActionEvent actionEvent) {
        zadanie4.przejdz_pokolenie();
        draw();
    }



    public void getIloscEpok()throws Exception{
        String epokiText=epokiTextField.getText();
        System.out.println("string epoki " + epokiText);
        iloscEpok=Integer.parseInt(epokiText);
        System.out.println("ilosc epok int  " + iloscEpok);

    }

    @FXML
    public void rozpocznijEpoki(ActionEvent actionEvent) {
        System.out.println("Rozpocznij epoki");
        try {
            getIloscEpok();
            status=true;
        } catch (Exception e) {
             status=false;
        }
        System.out.println(iloscEpok);
        //pobbieramy jaki ile epok
        //dopókki status aktywny to rob nasteobe
        //i nastepne epoki

        for(int i =0 ; i< iloscEpok ;i ++){

            if(status==true){
                System.out.println("xad");
                przeprowadźEpoke();
            }
        }
    }
    public void przeprowadźEpoke(){
        zadanie4.przejdz_pokolenie();
        draw();
    }

    @FXML
    public void zatrzymajEpoki(ActionEvent actionEvent) {
        status=false;
        //zmiana statusu na niekatywny
    }

    public void run()
    {
        try {
            System.out.println("-");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            status=false;
        }
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



