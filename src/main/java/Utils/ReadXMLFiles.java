package Utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import Menu.dania.ADanie;
import Menu.skladniki.ASkladnik;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFiles {

    public List<ArrayList<String>> readXMLFilesF(String xmlPath, String xmlID) {

        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        try {

            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(xmlID);

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                ArrayList<String> pozycja = new ArrayList<String>();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    if (eElement.getElementsByTagName("id").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("id").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("name").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("price").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("price").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("default_components").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("default_components").item(0).getTextContent());
                    }

                    if (eElement.getElementsByTagName("optional_components").getLength() != 0) {
                        pozycja.add(eElement.getElementsByTagName("optional_components").item(0).getTextContent());
                    }

                    list.add(pozycja);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (list);

    }

    public static List<ADanie> getDania(List<ASkladnik> skliki, List<ArrayList<String>> tablicaZDaniami) {

        List<ADanie> listaDan = new ArrayList();
        for (List<String> lista : tablicaZDaniami) {
            ADanie aDanie = new ADanie(Integer.parseInt(lista.get(0)), lista.get(1), 0, skliki, lista.get(2), lista.get(3));
            listaDan.add(aDanie);
        }
        return listaDan;
    }


    public static List<ASkladnik> getSkladniki(List<ArrayList<String>> tablicaZSkladnikami) {

        List<ASkladnik> listaSkaldnikow = new ArrayList();
        for (List<String> lista : tablicaZSkladnikami) {

            listaSkaldnikow.add(new ASkladnik(Integer.parseInt(lista.get(0)), lista.get(1), Integer.parseInt(lista.get(2))));
        }
        return listaSkaldnikow;
    }
}
