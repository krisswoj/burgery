import java.util.ArrayList;
import java.util.Scanner;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);

    static BurgerDAO burgerDAO = new BurgerDAO();

    public static void main(String[] args) {
        zlozZamowienie();
    }

    private static void zlozZamowienie() {

        String rodzajZamwowienia;
        System.out.println("Hamburger klasyczny (Bulka i mieso): 18 zl = Wybierz 1");
        System.out.println("Hamburger klasyczny (Bulka i mieso) + dodatki = Wybierz 2");

        rodzajZamwowienia = getUserInput();

        if (rodzajZamwowienia.equals("1")) {
            klasycznyHamburger();
        } else {
            zDodatkami();
        }
    }

    private static void klasycznyHamburger() {

        Hamburger hamburger = new Hamburger();

        hamburger.setTotalPrice(hamburger.bulka.getCena(), hamburger.mieso.getCena());
        burgerDAO.zlozZamowienie(hamburger);
        System.out.println("Dziekuje za zlozenie zamowienia, laczna cena do zaplaty to " + hamburger.getTotalPrice());

    }

    private static void zDodatkami() {

        Hamburger hamburger = new Hamburger();
        ArrayList<String> zDodatkamiLista = new ArrayList<String>();

        String dodatkowyOgorek;
        System.out.println("Dodatkowy ogorek: 2 zl = Wybierz 1");
        System.out.println("Bez dodatkowego ogorka = Wybierz 2");
        dodatkowyOgorek = getUserInput();

        if (dodatkowyOgorek.equals("1")) {

            zDodatkamiLista.add(hamburger.bulka.getNazwa());
            zDodatkamiLista.add(hamburger.mieso.getNazwa());
            zDodatkamiLista.add(hamburger.ogorek.getNazwa());

            hamburger.setTotalPrice(hamburger.bulka.getCena(), hamburger.mieso.getCena(), hamburger.ogorek.getCena());

        } else {
            zDodatkamiLista.add(hamburger.bulka.getNazwa());
            zDodatkamiLista.add(hamburger.mieso.getNazwa());

            hamburger.setTotalPrice(hamburger.bulka.getCena(), hamburger.mieso.getCena());

        }

        String dodatkowyPomidor;
        System.out.println("Dodatkowy podmidor: 2 zl = Wybierz 1");
        System.out.println("Bez dodatkowego pomidora = Wybierz 2");
        dodatkowyPomidor = getUserInput();

        if (dodatkowyPomidor.equals("1")) {

            zDodatkamiLista.add(hamburger.pomidor.getNazwa());
            hamburger.setTotalPrice(hamburger.getTotalPrice(), hamburger.pomidor.getCena());
        }

        String dodatkowyBoczek;
        System.out.println("Dodatkowy boczek: 2 zl = Wybierz 1");
        System.out.println("Bez dodatkowego boczku = Wybierz 2");
        dodatkowyBoczek = getUserInput();

        if (dodatkowyBoczek.equals("1")) {
            zDodatkamiLista.add(hamburger.boczek.getNazwa());
            hamburger.setTotalPrice(hamburger.getTotalPrice(), hamburger.boczek.getCena());
        }

        String dodatkowyMajonez;
        System.out.println("Dodatkowy majonez: 2 zl = Wybierz 1");
        System.out.println("Bez dodatkowego majonez = Wybierz 2");
        dodatkowyMajonez = getUserInput();

        if (dodatkowyMajonez.equals("1")) {
            zDodatkamiLista.add(hamburger.majonez.getNazwa());
            hamburger.setTotalPrice(hamburger.getTotalPrice(), hamburger.majonez.getCena());
        }

        System.out.println("Dziekuje za zlozenie zamowienia");
        System.out.println("Twoje kanpaka sklada sie z: ");

        for(String elem : zDodatkamiLista){
            System.out.print(elem+ ", ");
        }

        System.out.println("");
        System.out.println("Laczna cena za kanake to " + hamburger.getTotalPrice() + " zl");
    }

    public static String getUserInput() {
        return sc.nextLine().trim();
    }
}
