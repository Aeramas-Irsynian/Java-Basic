import java.util.ArrayList;

class ulamek {
    private String licznik, mianownik;
    private StringBuilder wynik;

    ulamek(int licznik, int mianownik) {
        this.licznik = Integer.toString(licznik);
        this.mianownik = Integer.toString(mianownik);
        if (licznik % mianownik != 0) wynikResztowy(licznik, mianownik);
        else wynik = new StringBuilder("" + licznik/mianownik);
    }

    private void wynikResztowy(int licznik, int mianownik) {
        ArrayList<Integer> reszty = new ArrayList<Integer>();
        ArrayList<Integer> cyfry = new ArrayList<Integer>();
        int cyfra, reszta;

        cyfra = licznik / mianownik;
        reszta = licznik % mianownik;
        wynik = new StringBuilder(cyfra + ".");

        while (true) {
            reszty.add(reszta);
            reszta *= 10;
            cyfra = reszta / mianownik;
            cyfry.add(cyfra);
            reszta %= mianownik;

            if (reszta == 0) {
                for(var podajCyfre : cyfry)
                    wynik.append(podajCyfre);
                break;
            } else {
                int sprawdzReszte = reszty.indexOf(reszta);
                if(sprawdzReszte != -1) {
                    for(int i = 0; i < sprawdzReszte; i++)
                        wynik.append(cyfry.get(i));
                    wynik.append("(");
                    for(int i = sprawdzReszte; i < cyfry.size(); i++)
                        wynik.append(cyfry.get(i));
                    wynik.append(")");
                    break;
                }
            }
        }
    }

    void pokazWynik() {
        System.out.println("Licznik: " + licznik + "\nMianownik: " + mianownik + "\nWynik: " + wynik);
    }
}
