/*
    Artur Krycha
    Informatyka i Ekonometria, niestacjonarne 17/18
    Numer indeksu: 60011
 */

class TestPunkt {
    public static void main(String[] args) {
        Punkt punktyTestowe[] = new Punkt[5];
        punktyTestowe[0] = new Punkt(1, 2);
        punktyTestowe[1] = new Punkt(7, 5);
        punktyTestowe[2] = new Punkt(3, 7);
        punktyTestowe[3] = new Punkt(5, 9);
        punktyTestowe[4] = new Punkt(9, 6);

        //Zadanie A1 - test
        //Test odleglosci miedzy punktami w tablicy punktowTestowych
        for (int i = 0; i < punktyTestowe.length; i++)
            for (int j = 0; j < punktyTestowe.length; j++)
                System.out.println("Odleglosc punktu " + i + " od punktu " + j + " jest rowna: " + punktyTestowe[i].zmierzOdleglosc(punktyTestowe[j]));

        //Zadanie B1 - test
        //Test czy punkt znajduje sie w polu kola; promienR = 10
        int promienR = 10;
        for (int i = 0; i < punktyTestowe.length; i++)
            System.out.println("Czy punkt " + i + " znajduje sie w kole o promieniu r = " + promienR + ": " + punktyTestowe[i].czyKolo(promienR));

        //Zadanie C1 - test
        //Test dystansu miedzy punktami w tablicy punktowTestowych; zadanyDystans = 5
        int zadanyDystans = 5;
        for (int i = 0; i < punktyTestowe.length; i++)
            for (int j = 0; j < punktyTestowe.length; j++)
                System.out.println("Dystans punktu " + i + " i punktu " + j + " jest mniejszy niz " + zadanyDystans + ": " + punktyTestowe[i].czyDystans(punktyTestowe[j], zadanyDystans));
    }
}

class Punkt {
    private double x, y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Zadanie A1
    public double zmierzOdleglosc(Punkt punktPorownywany) {
        return Math.sqrt(Math.pow(punktPorownywany.x - this.x, 2) + Math.pow(punktPorownywany.y - this.y, 2));
    }

    //Zadanie B1
    public boolean czyKolo(int promienR) {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)) <= promienR;
    }

    //Zadanie C1
    public boolean czyDystans(Punkt punktPorownywany, int zadanyDystans) {
        return Math.sqrt(Math.pow(punktPorownywany.x - this.x, 2) + Math.pow(punktPorownywany.y - this.y, 2)) < zadanyDystans;
    }
}
