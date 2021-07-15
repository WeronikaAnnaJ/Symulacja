package sample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Zadanie3 {



    public static double wyglosujWspolrzedna(double min, double max){
        Random rand = new Random();
        return rand.nextDouble() * (max - min) + min;
    }





    public static double znajdz_min(double tabela[],int lenght){

        double min=tabela[0];
        for(int i=0; i<lenght;i++){

            if(min>tabela[i]){
                min=tabela[i];
            }
        }
        return min;
    }



    public static double znajdz_max(double tabela[],int length){
        double max=tabela[0];
        for(int i=0; i<length;i++){

            if(max<tabela[i]){
                max= tabela[i];
            }
        }
        return max;
    } public  static  double metodaMonteCarlo(double xp,double xk,int n, Funkcje funkcja) throws Exception {
        //yp, yk zakres wartosci funckji w tym przedzalne
        //sprawdź maksymalną oraz minimalną wartośc danej funkcji w przedziale
        double minMax [] =Zadanie2.getMinMaxFunkcji(funkcja,xp,xk);
        double yp=0;
        System.out.println(yp);
        double yk= minMax[1];
        System.out.println(yk);
        double poleProstokata= (abs(xk-xp)) * (abs(yk-yp));
        System.out.println("pole prostokata" + poleProstokata);
        double trafienia=0;

        //n liczba punktow do wylosowania
        // jeżeli wylosowany punkt (xi, yi) leży nad osią OY i jednocześnie pod wykresem funkcji całkowanej, czyli spełnia nierówność: 0 < yi ≤ f(xi), wówczas zwiększamy zmienną c o jeden,
        //jeżeli wylosowany punkt (xi, yi) leży pod osią OY i jednocześnie nad wykresem funkcji całkowanej, czyli spełnia nierówność: 0 > yi ≥ f(xi), wówczas zmniejszamy zmienną c o jeden,
        //jeżeli wylosowany punkt (xi, yi) nie spełnia żadnego z powyższych warunków, wówczas pozostawiamy zmienną c bez zmian.


        for (int i=0; i<n; i++)
        {
            double px=wyglosujWspolrzedna(xp, xk);
            System.out.println( "px " + px);
            double py=wyglosujWspolrzedna(yp, yk);
            System.out.println( "py "+ py);

            System.out.println( "getfunkcja(funkcja,px) )"+ Zadanie2.getfunkcja(funkcja,px));
            if( (py <= Zadanie2.getfunkcja(funkcja,px))  && (0 < py)  ){
                System.out.println( "> > if 1" );
                trafienia++;
            }
            if(  (py >= Zadanie2.getfunkcja(funkcja,px)) && (0 > py)   ){
                System.out.println( "> > if 2" );
                //   trafienia--;
            }
            System.out.println( "  > trafienia  "+ trafienia);
        }
        System.out.println( "  > > > trafienia  "+ trafienia);
        System.out.println( "  > > > poleProstokata  "+ poleProstokata);
        System.out.println( "  > > > n  "+ n);
        //wynik calka = pole prostokąta * (c/n);

        double wynik = poleProstokata * ( trafienia /n);

        return wynik;
    }





}
