//niestety zmienne w polskim

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        zadanie41();
        zadanie42();
        zadanie43();
    }
    public static void zadanie41() throws FileNotFoundException{
        Scanner plik = new Scanner(new File("liczby.txt"));

        int licznik = 0;
        String pierwsza ="";

        while (plik.hasNext()){
            String liczba = plik.next();

            if(liczba.charAt(0)==liczba.charAt(liczba.length()-1)){
                licznik++;

                if(pierwsza.equals("")){
                    pierwsza = liczba;
                }
            }
        }
        plik.close();
        System.out.println("[----- ZADANIE 4.1 -----]");
        System.out.println("liczby spełniające warunki: "+licznik);
        System.out.println("pierwsza taka "+pierwsza);
    }
    public static void zadanie42() throws Exception{
        Scanner plik = new Scanner(new File("liczby.txt"));

        int maxCzynnikow = 0;
        int liczbaMaxCzynnikow = 0;
        int maxRoznych = 0;
        int liczbaMaxRoznych = 0;

        while(plik.hasNext()){
            int liczba = plik.nextInt();
            int temp = liczba;
            int czynniki = 0;
            int rozne = 0;
            int dzielnik = 2;

            while(dzielnik*dzielnik<=temp){
                if(temp % dzielnik==0){
                    rozne++;
                    while(temp % dzielnik==0){
                        czynniki++;
                        temp = temp/dzielnik;
                    }
                }
                dzielnik++;
            }
            if(temp > 1){
                czynniki++;
                rozne++;
            }
            if(czynniki>maxCzynnikow){
                maxCzynnikow=czynniki;
                liczbaMaxCzynnikow=liczba;
            }
            if(rozne>maxRoznych){
                maxRoznych=rozne;
                liczbaMaxRoznych=liczba;
            }
        }
        plik.close();
        System.out.println("[----- ZADANIE 4.2 -----]");
        System.out.println(liczbaMaxCzynnikow + " " + maxCzynnikow);
        System.out.println(liczbaMaxRoznych + " " + maxRoznych);
    }
    public static void zadanie43() throws Exception{
        Scanner plik = new Scanner(new File("liczby.txt"));

        java.util.ArrayList<Integer> liczby = new java.util.ArrayList<>();

        while(plik.hasNextInt()){
            int liczba = plik.nextInt();

            if(!liczby.contains(liczba)){
                liczby.add(liczba);
            }
        }
        plik.close();

        java.util.Collections.sort(liczby);
        java.io.PrintWriter zapis = new java.io.PrintWriter("trojki.txt");
        int liczbaDobrychTrojek = 0;
        int liczbaDobrychPiatek = 0;

        for(int i = 0; i<liczby.size(); i++){
            for(int j = i+1; j<liczby.size(); j++){
                for(int k = j+1; k<liczby.size(); k++){
                    int x = liczby.get(i);
                    int y = liczby.get(j);
                    int z = liczby.get(k);

                    if(y % x == 0 && z % y == 0){
                        zapis.println(x + " " + y + " " + z);
                        liczbaDobrychTrojek++;
                    }
                }
            }
        }
        zapis.close();
        for(int i = 0; i<liczby.size(); i++){
            for(int j = i+1; j<liczby.size(); j++){
                for(int k = j+1; k<liczby.size(); k++){
                    for(int l = k+1; l<liczby.size(); l++){
                        for(int m = l+1; m<liczby.size(); m++){
                            int u = liczby.get(i);
                            int w = liczby.get(j);
                            int x = liczby.get(k);
                            int y = liczby.get(l);
                            int z = liczby.get(m);

                            if(w % u == 0 &&
                                    x % w == 0 &&
                                    y % x == 0 &&
                                    z % y == 0){

                                liczbaDobrychPiatek++;
                            }
                        }
                    }
                }
            }
            System.out.println("[----- ZADANIE 4.3 -----]");
            System.out.println("liczba dobrych trojek: " + liczbaDobrychTrojek);
            System.out.println("liczba dobrych piatek: " + liczbaDobrychPiatek);
        }
    }
}

