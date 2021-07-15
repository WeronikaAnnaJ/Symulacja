package sample;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.Random;

public class Zadanie4 {
    int rozmiar;
    int plansza[][];

    public Zadanie4(int rozmiar) {
        this.rozmiar = rozmiar;
        this.plansza = new int[rozmiar][rozmiar];
    }

    public int wygeneruj_losowa_wspolrzedna() {
        int max= rozmiar-3;// zle losuje rozmiar
        Random rand=new Random();
        int liczba= rand.nextInt(max - 1 + 1) + 1;
        System.out.println(liczba);
        return liczba;

    }

    public void setAliveRandomCells(int n) {
        System.out.println("W METODZIE ");
        for (int i = 0; i < n; i++) {
            int x=wygeneruj_losowa_wspolrzedna();
            int y=wygeneruj_losowa_wspolrzedna();
            setAlive(x,y);
            System.out.println(" >   x, y" + x + ", "+y);
        }
    }

    //metoda zapalajaca sensowne komorki


    //zastanowić się co z bokami
    int policz_zywych_sasiadow(int x, int y) {
        int suma = 0;
        //po zachod
        if (plansza[x][y - 1] == 1) {
            suma++;
        }

        //na wschod
        if (plansza[x][y + 1] == 1) {
            suma++;
        }
        //polnoc
        if (plansza[x + 1][y] == 1) {
            suma++;
        }

        //poludnie
        if (plansza[x - 1][y] == 1) {
            suma++;
        }


        //po polnocy-zachod
        if (plansza[x + 1][y - 1] == 1) {
            suma++;
        }

        //na polnocny-wschod
        if (plansza[x + 1][y + 1] == 1) {
            suma++;
        }
        //poludniowy-zachod
        if (plansza[x - 1][y - 1] == 1) {
            suma++;
        }

        //poludniowy-wschod
        if (plansza[x - 1][y + 1] == 1) {
            suma++;
        }

        return suma;
    }


    public void przejdz_pokolenie() {

        int nowaPlansza[][] = new int[rozmiar][rozmiar];

//mozna policzyc ile przezyło a ile nie itp

        for (int i = 1; i < rozmiar - 1; i++) {
            for (int j = 1; j < rozmiar - 1; j++) {
                int liczba_sasiadow = policz_zywych_sasiadow(i, j);
                if (liczba_sasiadow == 3) {
                    nowaPlansza[i][j] = 1;
                }
                if(liczba_sasiadow==2 && plansza[i][j]==1){
                    nowaPlansza[i][j]=1;
                }

                if (liczba_sasiadow < 2) {
                    nowaPlansza[i][j] = 0;
                }
                if (liczba_sasiadow > 3) {
                    nowaPlansza[i][j] = 0;
                }
            }
        }
        plansza = nowaPlansza;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setAlive(int x, int y) {
        plansza[x][y] = 1;
    }

    public void setDead(int x, int y) {
        plansza[x][y] = 0;
    }
}
