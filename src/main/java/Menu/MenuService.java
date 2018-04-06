package Menu;

import Menu.dania.ADanie;
import Menu.skladniki.ASkladnik;
import Utils.ReadXMLFiles;

import java.util.List;

public class MenuService {

    static String menuskladnikiFile = "src/main/java/Utils/skladniki.xml";
    static String daniaFile = "src/main/java/Utils/dania.xml";


    public List<ADanie> wyswietlDania() {

        //pobranie listy skladniwkow z xml
        List<ASkladnik> listaSkladnikow = ReadXMLFiles.getSkladniki(new ReadXMLFiles().readXMLFilesF(menuskladnikiFile, "Skladnik"));


        //pobranie listy dan na podstawie wczesniej pobranych skladnikow
        List<ADanie> listaDania = ReadXMLFiles.getDania(listaSkladnikow, new ReadXMLFiles().readXMLFilesF(daniaFile, "Danie"));

        return listaDania;
    }






}

