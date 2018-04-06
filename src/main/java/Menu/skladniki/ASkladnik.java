package Menu.skladniki;

public class ASkladnik implements InterfaceSkladniki {

    private Integer id;
    private String nazwa;
    private Integer cena;


    public ASkladnik(Integer id, String nazwa, Integer cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
    }


    public Integer getId() {

        return id;
    }

    public String getNazwa() {

        return nazwa;
    }

    public Integer getCena() {

        return cena;
    }


}
