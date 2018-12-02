/**
 * Controller of productScreen for admin(warehouse/store)
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class productScreenController {

    private Product product;
    private EndUser endUser;
    private String scname, cname;
    private HashMap<String, ArrayList<Object>> hmap;
    private ArrayList<Product> products;

    @FXML
    Text name, id, price, errorText;

    @FXML
    TextField quantity;

    /**
     * Sets up the screen
     * @param products List of products
     * @param cname Category name
     * @param scname subcategory name
     * @param product The product
     * @param e End User
     * @param hmap The inventory
     */
    public void setValues(ArrayList<Product> products, String cname, String scname, Product product, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.product = product;
        this.endUser = e;
        this.scname = scname;
        this.hmap = hmap;
        this.cname = cname;
        this.products = products;

        name.setText(product.getName());
        id.setText(product.getID());
        price.setText(Integer.toString(product.getPrice()));
    }

    /**
     * Buys the product
     */
    public void buyProduct() {
        int q = Integer.valueOf(this.quantity.getText());
        if (q <= this.product.getQuantity() && this.endUser.getFunds() >= q*this.product.getQuantity()) {
            setText("");
            product.setQuantity(this.product.getQuantity()-q);
            endUser.setFunds(endUser.getFunds()-q*this.product.getQuantity());
        }
        else if (q > this.product.getQuantity())
            setText("Insufficient stock");
        else
            setText("Insufficient Funds");
    }

    /**
     * Incase of insufficient funds or insufficient stock
     * @param message
     */
    public void setText(String message) {
        this.errorText.setText(message);
    }

    /**
     * Function for signing out the user, returns the user to the main screen
     * @throws IOException Thrown by load function
     */
    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Goes back to the previous screen
     * @throws IOException Thrown by load function
     */
    public void back() throws IOException {

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/searchResults.fxml"));
        Parent root = loader.load();
        searchResultsController src = loader.getController();
        src.setValues(products, cname, scname, endUser, hmap);
        primaryStage.setTitle("Products Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


}
