package Menu.dania;

import Menu.skladniki.ASkladnik;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class ADanie implements InterfaceDanie<ASkladnik> {

    Integer id;
    String nazwa;
    Integer cena;
    List<ASkladnik> listaSkladnikow = new ArrayList<ASkladnik>();
    String defaultComponents;
    String optionalComponents;

    Scanner sc = new Scanner(System.in);


    public ADanie(Integer id, String nazwa, Integer cena, List<ASkladnik> list, String defaultComponents, String optionalComponents) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.listaSkladnikow = list;
        this.defaultComponents = defaultComponents;
        this.optionalComponents = optionalComponents;

    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getCena() {
        return cena;
    }

    public Integer getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<ASkladnik> getListaSkladnikow() {
        return listaSkladnikow;
    }

    public String getDefaultComponents() {
        return defaultComponents;
    }

    public String getOptionalComponents() {
        return optionalComponents;
    }

    public String getUserInput() {
        return sc.nextLine().trim();
    }

    public List<ASkladnik> zlozZamowienie(String wersjaZamowienia) {

        List<ASkladnik> listaZSkladnikamiWZamowieniu = new ArrayList<ASkladnik>();

        List<String> idsPieces = getIdscomponetsXml(getDefaultComponents());

        for (String piece : idsPieces) {
            listaZSkladnikamiWZamowieniu.add(new ASkladnik(getListaSkladnikow().get(Integer.parseInt(piece)).getId(), getListaSkladnikow().get(Integer.parseInt(piece)).getNazwa(), getListaSkladnikow().get(Integer.parseInt(piece)).getCena()));
            setCena(getCena() + getListaSkladnikow().get(Integer.parseInt(piece)).getCena());
        }

        //wariant dla wersji z dodatkami
        if (wersjaZamowienia.equals("2")) {

            List<String> idsPieces2 = getIdscomponetsXml(getOptionalComponents());
            for (String piece2 : idsPieces2) {

                System.out.println("Wybierz czy ponizszy dodatek dodac do Twojego zamowienia");
                System.out.println("");
                System.out.println(getListaSkladnikow().get(Integer.parseInt(piece2)).getNazwa() + " (cena " + getListaSkladnikow().get(Integer.parseInt(piece2)).getCena() + " zl)");
                System.out.println("");
                System.out.println("Jezeli tak, wybierz 1 | Jezeli nie, wybierz 2");

                String wyborKlienta = getUserInput();

                if (wyborKlienta.equals("1")) {
                    listaZSkladnikamiWZamowieniu.add(new ASkladnik(getListaSkladnikow().get(Integer.parseInt(piece2)).getId(), getListaSkladnikow().get(Integer.parseInt(piece2)).getNazwa(), getListaSkladnikow().get(Integer.parseInt(piece2)).getCena()));
                    setCena(getCena() + getListaSkladnikow().get(Integer.parseInt(piece2)).getCena());
                }
            }
        }

        return wyswietlParagon(listaZSkladnikamiWZamowieniu);
    }

    public List<ASkladnik> wyswietlParagon(List<ASkladnik> zamowioneSkladniki){
        
        System.out.println("Dziekujemy za zlozenie zamowienia, ponizej prezentujemy paragon z podzialem na skladniki");
        System.out.println("");
        for(int i =0; zamowioneSkladniki.size() > i;i++ ){
            System.out.println(zamowioneSkladniki.get(i).getNazwa() +", Cena: " + zamowioneSkladniki.get(i).getCena());
        }
        System.out.println("");
        System.out.println("Laczna suma to: " + getCena());

        return null;
    }

    public void wyborWersjiZamowienia() {

        List<String> idsPieces = getIdscomponetsXml(getDefaultComponents());
        System.out.print("Wersja podstawowa: ");
        for (String piece : idsPieces) {
            System.out.print(getListaSkladnikow().get(Integer.parseInt(piece)).getNazwa() + " (Cena " + getListaSkladnikow().get(Integer.parseInt(piece)).getCena() + "zl) | ");
            setCena(getCena() + getListaSkladnikow().get(Integer.parseInt(piece)).getCena());
        }
        System.out.print("Laczna cena: " + getCena() + " | Wybierz === 1");
        System.out.println("");
        System.out.println("");
        System.out.print("Wersja z dodatkami: Wszystko co w wersji podstawowej + możliwosc doboru " + getIdscomponetsXml(getOptionalComponents()).size() + " dodatkow | Wybierz === 2");
        System.out.println("");
        System.out.println("");
    }

    public List<String> getIdscomponetsXml(String idsXml) {

        String[] skladnikIdsString = new String[]{idsXml};
        List<String> separateSkladnikIds = new ArrayList<String>();

        for (String line : skladnikIdsString) {
            String[] linePieces = line.split(",");
            for (String piece : linePieces) {
                separateSkladnikIds.add(piece);
            }
        }
        return separateSkladnikIds;
    }
}
