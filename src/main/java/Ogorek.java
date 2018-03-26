public class Ogorek {

    private String nazwa;
    private int cena;

    protected Ogorek(){
        this.nazwa = "Ogorek";
        this.cena = 3;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }
}
