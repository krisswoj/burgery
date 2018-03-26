public class Hamburger {

    Bulka bulka = new Bulka();
    Boczek boczek = new Boczek();
    Majonez majonez = new Majonez();
    Mieso mieso = new Mieso();
    Ogorek ogorek = new Ogorek();
    Pomidor pomidor = new Pomidor();


private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice, int totalPrice2) {
        this.totalPrice = totalPrice + totalPrice2;
    }

    public void setTotalPrice(int totalPrice, int totalPrice2, int totalPrice3) {
        this.totalPrice = totalPrice + totalPrice2 + totalPrice3;
    }
}
