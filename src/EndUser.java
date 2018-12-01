public class EndUser {
    private int funds;

    EndUser() {
        this.funds = 0;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    void buyProduct(int price, int quantity) {
        this.funds -= price*quantity;
    }

}
