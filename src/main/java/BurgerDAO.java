import java.util.ArrayList;
import java.util.List;

public class BurgerDAO {

    List<Hamburger> hamburgers = new ArrayList<Hamburger>();

    public void zlozZamowienie(Hamburger hamburger){

        hamburgers.add(hamburger);
    }


}
