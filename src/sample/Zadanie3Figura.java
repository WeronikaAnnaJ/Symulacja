package sample;

import java.util.Random;

public class Zadanie3Figura {

    double[] x;
    double[] y;
    Punkt p;
    double minx;
    double maxx;
    double miny;
    double maxy;
    int n;
    double PoleProstokata;

    Zadanie3Figura(double[] x, double[] y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;

    }

    public void wyznaczProstokat() {
        minx = znajdz_min(x);
        System.out.println("minx " + minx);
        maxx = znajdz_max(x);
        System.out.println("maxx " + maxx);
        miny = znajdz_min(y);
        System.out.println("miny " + miny);
        maxy = znajdz_max(y);
        System.out.println("maxy " + maxy);
        PoleProstokata = (maxx - minx) * (maxy - miny);
        System.out.println("pole prostokata " + PoleProstokata);
    }

    public void wylosujPunkty() {
        for (int i = 0; i < n; i++) {
            System.out.println("x" + wyglosujWspolrzedna(minx, maxx));
            System.out.println("y " + wyglosujWspolrzedna(miny, maxy));
        }
    }

    public int sprawdzPunkt(Punkt a, Punkt b, Punkt p) {
        //Ab nad pod lub po prawej od punktu
        if (a.y > p.y && b.y > p.y) {
            System.out.println("NAD");
            return 0;
        }
        if (a.y < p.y && b.y < p.y) {
            System.out.println("POD");
            return 0;
        }
        if (a.x > p.x && b.x > p.x) {
            System.out.println("NA PRAWO");
            return 0;
        }
        if ((sprawdzCzyPuktNalezyDoOdcinka(a, b, p) == 1) && (b.x != p.x && b.y != p.y)) {
            System.out.println("Punkt nalezy do odcinka");
            return 1;
        }

        if (wyznaczPunktPrzecieciaProstych(a, b, p) == 1) {
            System.out.println("Prosta przecina prosta p");
            return 1;
        }

        return 0;
    }


    //czy punkt znajduje się w figurze
    public int czy_punkt_znajduje_sie_figurze(Punkt p) {
        System.out.println("  WIERZCHOLKI ");

        for (int i = 0 ; i < x.length ; i ++){
            System.out.println( x[i] + ", " + y[i]);
        }
        int w_poprzedni = 0;
        int w = w_poprzedni + 1;



        int ilosc_przeciec = 0;
        int c = 1;
        for (int i = 0; i < x.length; i++) {
            System.out.println("  > ITERACJA  " + i );
            System.out.println("    > numer wierzcholka poprzedniego -  " + w_poprzedni );
            System.out.println("    > numer wierzcholka               -  " + w );

            Punkt a = new Punkt(x[w_poprzedni], y[w_poprzedni]);
            Punkt b = new Punkt(x[w], y[w]);

            System.out.println(" punkt A : "  +a.x + ", " + a.y);
            System.out.println(" punkt B : "  +b.x + ", " + b.y);
            int przeciecia = sprawdzPunkt(a, b, p);
            System.out.println("sprawdzenie punktu " + przeciecia);
            if (przeciecia == 1) {
                ilosc_przeciec++;
            }
            w_poprzedni++;
            w++;
            if(w==x.length){
                w=0;
                c--;
            }

        }

        System.out.println("ILOSC PRZECIEC " + ilosc_przeciec);
        if (ilosc_przeciec % 2 == 0) {//sprawdzenie czy parzysta ilosc przeciec
            return 0;
        } else {
            return 1;
        }
    }


    public double obliczPoleWielokatu(){
        wyznaczProstokat();

        int punkty_wewnatrz=0;

        for(int i=0;i<n;i++){
            double x= wyglosujWspolrzedna(minx, maxx);
            double y= wyglosujWspolrzedna(miny, maxy);
            Punkt p= new Punkt(x,y);
            System.out.println("x, y " + x + ", " + y);

            if(czy_punkt_znajduje_sie_figurze(p)==1){
                punkty_wewnatrz++;
            }
        }

        double przyblizenie_pola=(punkty_wewnatrz*PoleProstokata)/n;
        System.out.println("Pole -> " + przyblizenie_pola);
        return przyblizenie_pola;

    }



    public int sprawdzCzyPuktNalezyDoOdcinka(Punkt a, Punkt b, Punkt p) {
        double wyznacznik = (a.x * b.y) + (b.x * p.y) + (p.x * a.y) - (b.y * p.x) - (p.y * a.x) - a.y * b.x;
        if (wyznacznik == 0) {
            if (((Math.min(a.x, b.x) <= p.x) && (p.x <= Math.max(a.x, b.x)) &&
                    ((Math.min(a.y, b.y) <= p.y) && (p.y <= Math.max(a.y, b.y))))) {
                System.out.println("C leży na |AB|");
                return 1;
            } else {
                System.out.println("C nie leży na |AB| choć leżą na jednej prostej");
                return 0;
            }

        } else {
            System.out.println("Niestety, punkt C nie leży na tym odcinku. :(");
            return 0;
        }
    }


    public int wyznaczPunktPrzecieciaProstych(Punkt a, Punkt b, Punkt p) {

        if (a.x - b.x == 0) {
            a.x++;
        }
        // Wyznaczenie wspolczynnikow dla pierwszej prostej
        // 1 - 2 pierwsza prosta
        double a1 = (a.y - b.y) / (a.x - b.x);
        double b1 = (a.y - ((a.y - b.y) / (a.x - b.x)) * a.x);
        // Wyznaczenie wspolczynnikow dla drugiej prostej
        // 3 - 4 druga prosta
        double a2 = 0;
        double b2 = p.y;

        // Wyznaczenie wartosci x dla y w f1
        double x = (-b2 + b1) / (-a1);
        if (x > p.x) {
            System.out.println("Punkt przecięcia na prawo od punktu ");
            return 0;
        }
        if (x == p.x) {
            System.out.println("Punkt przecięcia to punkt");
            return 1;
        }
        if (x < p.x) {
            System.out.println("Punkt przecięcia na lewo od punktu");
            return 1;
        }
        return 0;
    }


    public static double wyglosujWspolrzedna(double min, double max) {
        Random rand = new Random();
        double wspolrzedna = rand.nextDouble() * (max - min) + min;
        return wspolrzedna;
    }

    public static double znajdz_min(double[] tabela) {
        double min = tabela[0];
        for (int i = 0; i < tabela.length; i++) {
            if (min > tabela[i]) {
                min = tabela[i];
            }
        }
        return min;
    }


    public static double znajdz_max(double tabela[]) {

        double max = tabela[0];
        for (int i = 0; i < tabela.length; i++) {
            if (max < tabela[i]) {
                max = tabela[i];
            }
        }
        return max;
    }


    public static class Punkt {
        double x;
        double y;

        Punkt(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
