/**
 * The EndUser
 * @author Apoorv Singh, Gaurav Aggarwal
 */

public class EndUser {
    private int funds;

    /**
     * Constructor sets the funds to 0
     */
    EndUser() {
        this.funds = 0;
    }

    /**
     * Getter for end user funds
     * @return Returns end user funds
     */
    public int getFunds() {
        return funds;
    }

    /**
     * Setter for end user funds
     * @param funds end user funds
     */
    public void setFunds(int funds) {
        this.funds = funds;
    }

    /**
     * Buys the product
     * @param price The price of product
     * @param quantity The quantity purchased
     */
    void buyProduct(int price, int quantity) {
        this.funds -= price*quantity;
    }

}
