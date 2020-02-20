/*
    Artur Krycha
    Informatyka i Ekonometria, niestacjonarne 17/18
    Numer indeksu: 60011
*/

import java.util.ArrayList;

class LiczbaNawiasowa {
    /*
    To jest prosta klasa testujaca
    Ustalamy tablice dzialan do sprawdzenia, nastepnie wywolujemy wyniki
    */
    public static void main(String[] args) {
        Ulamek[] ulamkiTestowe = new Ulamek[4];

        ulamkiTestowe[0] = new Ulamek(23, 14);
        ulamkiTestowe[1] = new Ulamek(1, 40);
        ulamkiTestowe[2] = new Ulamek(4353, 334);
        ulamkiTestowe[3] = new Ulamek(19, 81);

        for (Ulamek podajUlamek : ulamkiTestowe) {
            podajUlamek.pokazWynik();
            System.out.println();
        }
    }
}

class Ulamek {
    private String licznik, mianownik;
    private String wynik;

    Ulamek(int licznik, int mianownik) {
        this.licznik = Integer.toString(licznik);
        this.mianownik = Integer.toString(mianownik);
        /*
        Jezeli reszta z dzielenia jest rowna zero to niczego nie szukamy, od razu tworzymy wynik
        */
        if (licznik % mianownik != 0) utworzWynikResztowy(licznik, mianownik);
        else wynik = ("" + licznik / mianownik);
    }

    private void utworzWynikResztowy(int licznik, int mianownik) {
        /*
        Uzycie .append() dla StringBuildera jest bardziej optymalne niz .concat() dla String, dlatego uzywany jest konstruktor, ktory potem zostanie przepisany do wyniku
        Ponadto tworzone sa pomocnicze zmienne i tablice
        */
        StringBuilder konstruktorWyniku;
        ArrayList<Integer> resztyDzielenia = new ArrayList<Integer>();
        ArrayList<Integer> wynikiDzielenia = new ArrayList<Integer>();
        int aktualnyWynik, aktualnaReszta;

        aktualnyWynik = licznik / mianownik;
        aktualnaReszta = licznik % mianownik;
        /*
        Poniewaz juz wiemy, ze mamy wynik nie bedacy liczba calkowita to od razu tworzymy poczatek wyniku w konstruktorze
        */
        konstruktorWyniku = new StringBuilder(aktualnyWynik + ".");
        /*
        W tym miejscu przeprowadzamy dzielenie pisemne w petli
        Za kazdym razem uwzgledniamy przesuniecie w prawo o jedno miejsce, mnozac reszte przez 10
        Aktualnie otrzymane wyniki i reszty zapisujemy do tablic pomocniczych
        */
        while (true) {
            resztyDzielenia.add(aktualnaReszta);
            aktualnaReszta *= 10;
            aktualnyWynik = aktualnaReszta / mianownik;
            wynikiDzielenia.add(aktualnyWynik);
            aktualnaReszta %= mianownik;
            /*
            Jezeli w ktoryms momencie reszta wyniesie zero to zakonczylismy nasze dzialanie, nie musimy sie dalej przesuwac w prawo
            Wystarczy wtedy otrzymane wyniki podac do konstruktora i potem utworzyc wynik
            */
            if (aktualnaReszta == 0) {
                for (int podajWynik : wynikiDzielenia)
                    konstruktorWyniku.append(podajWynik);
                wynik = konstruktorWyniku.toString();
                break;
                /*
                Za kazdym razem musimy sprawdzic, czy nasza reszta, jezeli nie jest zerem to czy juz nie wystapila wczesniej w tablicy reszt
                Jezeli reszta wystapila, czyli wartosc indeksu nie jest rowna -1 to wtedy znalezlismy okres i mozemy zakonczyc dzialanie
                Tworzymy wynik, dodajac wyniki dzielenia az do indeksu sprawdzonego wczesniej
                Nastepnie tworzymy ladnie liczbe okresowa w nawiasie az do konca wynikow
                */
            } else {
                int sprawdzReszte = resztyDzielenia.indexOf(aktualnaReszta);
                if (sprawdzReszte != -1) {
                    for (int i = 0; i < sprawdzReszte; i++)
                        konstruktorWyniku.append(wynikiDzielenia.get(i));
                    konstruktorWyniku.append("(");
                    for (int i = sprawdzReszte; i < wynikiDzielenia.size(); i++)
                        konstruktorWyniku.append(wynikiDzielenia.get(i));
                    konstruktorWyniku.append(")");
                    wynik = konstruktorWyniku.toString();
                    break;
                }
            }
        }
    }

    void pokazWynik() {
        System.out.println("Licznik: " + licznik + "\nMianownik: " + mianownik + "\nWynik: " + wynik);
    }
}
