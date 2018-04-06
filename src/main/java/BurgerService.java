
import Menu.MenuService;

import java.util.Scanner;

public class BurgerService {

    Scanner sc = new Scanner(System.in);
    static String wybraneDanie;
    static String wersjaZamowienia;

    public boolean run() {

        przywitaj();

        pokazMenu();

        zamowienie();

        return (czyPowtorzycZamawianie());
    }

    private void pokazMenu() {

        MenuService menuService = new MenuService();

        for (int i = 0; menuService.wyswietlDania().size() > i; i++) {
            System.out.println(menuService.wyswietlDania().get(i).getNazwa() + " wybierz " + i);
        }
        wybraneDanie = getUserInput();
    }

    private void zamowienie() {

        MenuService menuService = new MenuService();
        System.out.println("");
        System.out.println("");
        System.out.println("Twoje zamowienie to: " + menuService.wyswietlDania().get(Integer.parseInt(wybraneDanie)).getNazwa());
        System.out.println("");
        System.out.println("");
        System.out.println("Wybierz czy chcesz wersje podstawowa, czy z dodatkami");
        System.out.println("-------------------------");
        menuService.wyswietlDania().get(Integer.parseInt(wybraneDanie)).wyborWersjiZamowienia();
        wersjaZamowienia = getUserInput();
        menuService.wyswietlDania().get(Integer.parseInt(wybraneDanie)).zlozZamowienie(wersjaZamowienia);
    }

    private Boolean czyPowtorzycZamawianie() {
        try {
            System.in.read();
        } catch (Exception e) {

        }
        return true;
    }

    public void przywitaj() {
        System.out.println("Prosimy o wybor obiadu");
        System.out.println("----------------------");
        System.out.println("");
        }

    public String getUserInput() {
        return sc.nextLine().trim();
    }
}
