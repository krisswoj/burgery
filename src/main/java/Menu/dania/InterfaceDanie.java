package Menu.dania;

import Menu.skladniki.ASkladnik;

import java.util.List;

public interface InterfaceDanie<T> {

    Integer getCena();
    List<ASkladnik> getListaSkladnikow();
    List<ASkladnik> zlozZamowienie(String wersjaZamowienia);
    List<String> getIdscomponetsXml(String idsXml);


}
