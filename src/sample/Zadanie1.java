package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.*;

//przygotować działajace przyklady
enum Rownania {
    rownanie1,
    rownanie2,
    rownianie3
}

class Zadanie1 {


    private static Map<String, Rownania> rownania = new TreeMap<>();


    public static Double getRownanie(Rownania rownanie, double x) {
        switch (rownanie) {
            case rownanie1:
                return pow(x, 3) + pow(x, 2) + (-3 * x) - 3; //przedział :<-3,-1,5 > <1, 2>
            case rownanie2:
                return 2 * pow(x, 2) + (5 * x) + 2; //przedział <-3, -1.5>, <-1,2>
            case rownianie3:
                return pow(x, 3) * (x + sin(x * x - 1) - 1) - 1;// przedział <-1,0> i przedział <1,2>
            default:
                return null;
        }
    }

    public static Rownania getRownanie(String rownanie) {
        if (rownanie==("pow(x, 3) + pow(x, 2) + (-3 * x) - 3")) {
            return Rownania.rownanie1;
        }
        if (rownanie==("2 * pow(x, 2) + (5 * x) + 2")) {
            return Rownania.rownanie2;
        }
        if (rownanie==("pow(x, 3) * (x + sin(x * x - 1) - 1) - 1")) {
            return Rownania.rownianie3;
        }
        return null;
    }

    public static List<String> getDostepneRownania() {
        List<String> list = new ArrayList<>();
        list.add("pow(x, 3) + pow(x, 2) + (-3 * x) - 3");
        list.add("2 * pow(x, 2) + (5 * x) + 2");
        list.add("pow(x, 3) * (x + sin(x * x - 1) - 1) - 1"); //
        return list;
    }


    public static String metoda_bisekcji(Rownania rownanie,double a, double b, double epsilon) {
        //wartosc zerowa funkcji w punkcie a i b
        double fa = getRownanie(rownanie, a);
        double fb = getRownanie(rownanie, b);
        if (fa * fb < 0) {
            while (true) {
                double s;
                s = (a + b) / 2;
                double fs;
                fs = getRownanie(rownanie, s);

                if (abs(fs) <= epsilon) {
                    return s + "";
                }

                if (fa * fs < 0) {
                    b = s;
                    fb = getRownanie(rownanie, b);
                } else {
                    a = s;
                    fa = getRownanie(rownanie, a);
                }
            }
        } else {
            return "Funkcja nie spelnia warunkow";
        }
    }

    public static String metodaRegulaFalsi(Rownania rownianie, double a, double b, double epsilon) {
        double fa, fb, fx;
        double x, x1;
        fa = getRownanie(rownianie, a);
        fb = getRownanie(rownianie, b);
        x1 = a;
        x = b;

        if (fa * fb < 0) {

            while (abs(x1 - x) > epsilon) {
                x1 = x; //terazniejszt staje sie poptzednim
                x = a - fa * ((b - a) / (fb - fa));
                fx = getRownanie(rownianie, x);

                if (abs(fx) < epsilon) {
                    return x + "";
                }

                if (fa * fx < 0) {
                    b = x;
                    fb = getRownanie(rownianie, b);
                }
                if (fb * fx < 0) {
                    a = x;
                    fa = getRownanie(rownianie, a);
                }

            }

        } else {
            return ("Funkcja nie spelnia warunkow");
        }
        return x + "";
    }

    public static String metoda_siecznych(Rownania rownanie, double a, double b, double epsilon) {
        double fa, fb, fx;
        double x = 0;
        int i;
        fa = getRownanie(rownanie,a);
        fb = getRownanie(rownanie,b);
        i = 64;//ile cykli wykonac

        if (fa * fb < 0) {
            while (i > 0 && abs(a - b) > epsilon) {

                if (abs(fa - fb) < epsilon) {
                    break;
                }
                x = a - fa * ((a - b) / (fa - fb));
                fx = getRownanie(rownanie, x);

                if (abs(fx) < epsilon) {
                    return x + ""; //rozwiazanie
                }
                b = a;
                a = x;
                fb = getRownanie(rownanie, b);
                fa = getRownanie(rownanie, a);
                i--;
            }

            if (i == 0) {
                return ("Przekroczono 64 dozwolone iteracje");
            }
        } else {
            return ("Funkcja nie spelnia warunkow");
        }
        return "";
    }

}

