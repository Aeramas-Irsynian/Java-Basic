import java.util.ArrayList;

public class JasMalgosia {
    private String jas;
    private String malgosia;
    private String razem;

    public JasMalgosia(String ileRazem, String ileRazyWiecejMalgosia) {
        razem = ileRazem;
        jas = ileMaJas(ileRazem, ileRazyWiecejMalgosia);
        malgosia = ileMaMalgosia(jas, ileRazyWiecejMalgosia);
    }

    private String ileMaJas(String ileRazem, String ileRazyWiecejMalgosia) {
        StringBuilder ileJas = new StringBuilder();
        ArrayList<Integer> tempLicznik = new ArrayList<Integer>();
        ArrayList<Integer> tempWynik = new ArrayList<Integer>();
        int tempMianownik = Integer.parseInt("" + ileRazyWiecejMalgosia) + 1;
        for (int i = 0; i < ileRazem.length(); i++)
            tempLicznik.add(Integer.parseInt("" + ileRazem.charAt(i)));

        int przeniesienie = 0;
        int dzialanie = 0;
        for (int i = 0; i < tempLicznik.size(); i++) {
            dzialanie = (tempLicznik.get(i) + przeniesienie) / tempMianownik;
            if (dzialanie == 0 && i == 0) {
                przeniesienie = 10 * tempLicznik.get(i);
                continue;
            } else {
                przeniesienie = 10 * ((tempLicznik.get(i) + przeniesienie) % tempMianownik);
            }
            tempWynik.add(dzialanie);
        }

        for (var podajLiczbe : tempWynik)
            ileJas.append(podajLiczbe);

        return ileJas.toString();
    }

    private String ileMaMalgosia(String jas, String ileRazyWiecejMalgosia) {
        StringBuilder ileMalgosia = new StringBuilder();
        ArrayList<Integer> tempWynik = new ArrayList<Integer>();
        int tempMnoznik = Integer.parseInt("" + ileRazyWiecejMalgosia);

        int przeniesienie = 0;
        int dzialanie = 0;
        for (int i = jas.length() - 1; i >= 0; i--) {
            dzialanie = (Integer.parseInt("" + jas.charAt(i)) * tempMnoznik) + przeniesienie;
            przeniesienie = dzialanie / 10;
            if (i > 0)
                dzialanie %= 10;
            tempWynik.add(0, dzialanie);
        }

        for (var podajLiczbe : tempWynik)
            ileMalgosia.append(podajLiczbe);

        return ileMalgosia.toString();
    }

    public String pokazWynik() {
        return "Razem: " + razem
                + "\nJas ma: " + jas
                + "\nMalgosia ma: " + malgosia;
    }
}
