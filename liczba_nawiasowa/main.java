public class main {
    public static void main(String[] args) {
       ulamek ulamek[] = new ulamek[4];

       ulamek[0] = new ulamek(23, 14);
       ulamek[1] = new ulamek(1, 40);
       ulamek[2] = new ulamek(4353, 334);
       ulamek[3] = new ulamek(19, 81);

       for(var podajUlamek : ulamek) {
           podajUlamek.pokazWynik();
           System.out.println();
       }
    }
}
