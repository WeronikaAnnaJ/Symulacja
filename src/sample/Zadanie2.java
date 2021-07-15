package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;



    enum Funkcje{
        f1, //<1,3>
        f2, //<1,3>
        f3
    }

public class Zadanie2 {



        public static Funkcje getEnum(int i  ){
            switch (i){
                case 1:
                    return Funkcje.f1;

                case 2:
                    return Funkcje.f2;

                case 3:
                    return Funkcje.f3;
                default:
                    return null;
            }
        }

        public static   double f1(double x) {
            return pow(x,2)*(-1)-x+10;             //funkcja rzeczywista, z której będzie liczona całka
        }



        public static    double f2(double x) {
            return pow(x,2)+ 2*x;   //funkcja rzeczywista, z której będzie liczona całka
        }


        public static  double f3(double x) {
            return pow(x,4)+ pow(x,2)+ 2*x +2;  //funkcja rzeczywista, z której będzie liczona całka
        }


        public static Double getfunkcja(Funkcje funkcja, double x)  {

            switch (funkcja) {

                case f1:

                    return f1(x);


                case f2:
                    return f2(x);

                case f3:
                    return f3(x);

                default:
                    return null;

            }

        }

    public static Funkcje getFunkcje(String rownanie) {
        if (rownanie==("pow(x,2)*(-1)-x+10")) {
            return Funkcje.f1;
        }
        if (rownanie==("pow(x,2)+ 2*x")) {
            return Funkcje.f2;
        }
        if (rownanie==("pow(x,4)+ pow(x,2)+ 2*x +2")); {
            return Funkcje.f3;
        }
    }



        public static List<String> getDostepneFunkcje() {
        List<String> list = new ArrayList<>();
        list.add("pow(x,2)*(-1)-x+10");
        list.add("pow(x,2)+ 2*x");
        list.add("pow(x,4)+ pow(x,2)+ 2*x +2");
        return list;
    }


    public static double[] getMinMaxFunkcji(Funkcje funkcja, double xp, double xk)  {

            switch (funkcja) {
                //pochodzna funkcji
                // miejsca gdzie pochodna funkcji = 0
                //oblicz wartość f od miejsc 0 i f od punktów xp i xk
                //wybierz najmniejszy i największy z punktów i zwróć

                case f1:

                    //f1'(x)=   -2x -1
                    //miejsce zerowe
                    double x01= 0.5;
                    double f1x0= getfunkcja(Funkcje.f1, x01);
                    double f1xp = getfunkcja(Funkcje.f1, xp);
                    double f1xk = getfunkcja(Funkcje.f1, xk);
                    List<Double> wartosci= new LinkedList<>();
                    wartosci.add(f1x0);
                    wartosci.add(f1xp);
                    wartosci.add(f1xk);
                    Collections.sort(wartosci);
                    double min = wartosci.get(0);
                    double max= wartosci.get(wartosci.size()-1);
                    double minMax[]= {min, max};
                    return minMax;

                case f2:

                    //f1'(x)=   2 (x+1)
                    //miejsce zerowe
                    double x02= -1;
                    double f2x0= getfunkcja(Funkcje.f2, x02);
                    double f2xp = getfunkcja(Funkcje.f2, xp);
                    double f2xk = getfunkcja(Funkcje.f2, xk);
                    List<Double> wartosci2= new LinkedList<>();
                    wartosci2.add(f2x0);
                    wartosci2.add(f2xp);
                    wartosci2.add(f2xk);
                    Collections.sort(wartosci2);
                    double min2 = wartosci2.get(0);
                    double max2= wartosci2.get(wartosci2.size()-1);
                    double minMax2[]= {min2, max2};
                    return minMax2;

                case f3:

                    //f1'(x)=   2 (2x^3 +x +1)
                    //miejsce zerowe
                    double x03=-0.5898;
                    double f3x0= getfunkcja(Funkcje.f3, x03);
                    double f3xp = getfunkcja(Funkcje.f3, xp);
                    double f3xk = getfunkcja(Funkcje.f3, xk);
                    List<Double> wartosci3= new LinkedList<>();
                    wartosci3.add(f3x0);
                    wartosci3.add(f3xp);
                    wartosci3.add(f3xk);
                    Collections.sort(wartosci3);
                    double min3 = wartosci3.get(0);
                    double max3= wartosci3.get(wartosci3.size()-1);
                    double minMax3[]= {min3, max3};
                    return minMax3;


                default:
                    return null;

            }

        }


        public  static  String metodaProstokatow(double xp,double xk,int n, Funkcje funkcja)  {

            double dx = (xk - xp) / (double)n;      //odległość miedzy dwoma sądziednimi punktami przedziałowymi,podstawa prostokata
            double wynik = 0;                        //przybliżona wartość całki oznaczonej funkcji w rpzedziale xp do xk

            for (int i=0; i<n; i++)
            {
                wynik += dx*(getfunkcja(funkcja, ( xp + i * dx)));
            }
            return wynik +"";

        }

        public  static  String metodaTrapezow(double xp,double xk,int n, Funkcje funkcja)  {

            double dx = (xk - xp) / (double)n;      //odległość miedzy dwoma sądziednimi punktami przedziałowymi,podstawa prostokata
            double wynik = 0;                        //przybliżona wartość całki oznaczonej funkcji w rpzedziale xp do xk

            for (int i=0; i<n; i++)
            {
                wynik += ( getfunkcja(funkcja, (xp + i * dx)));
            }

            wynik += (getfunkcja(funkcja,(xp))+getfunkcja(funkcja,(xk)))/2;
            wynik*=  dx;

            return wynik +"";
        }



        public  static String metodaParaboli(double xp,double xk,int n, Funkcje funkcja){

            double dx = (xk - xp) / (double)n;      //odległość miedzy dwoma sądziednimi punktami przedziałowymi,podstawa prostokata
            double wynik = 0;//przybliżona wartość całki oznaczonej funkcji w rpzedziale xp do xk
            double st=0;//suma wartości funkcji w punktach środkówych
            double x=0;// poztcja punktu podziałowego

            for (int i=0; i<n; i++)
            {
                x =xp + i * dx;
                st+=getfunkcja(funkcja,(x-(dx/2)));//czy tutaj -n

                if(i<(n-1)){
                    wynik+=getfunkcja(funkcja,(x));
                }
            }


            wynik =getfunkcja(funkcja,(xp))+getfunkcja(funkcja,(xk))+2*wynik+4*st;
            wynik*=dx/6;
            return wynik+"";
        }


    }
