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

public class productScreenAdmin {

    Product p;

    @FXML
    TextField quantity, price;

    @FXML
    Text name, id;

    /**
     * Sets up the screen
     * @param selected The selected product
     */
    public void setValues(Product selected) {
        name.setText(selected.getName());
        id.setText(selected.getID());
        quantity.setText(Integer.toString(selected.getQuantity()));
        price.setText(Integer.toString(selected.getPrice()));

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
     * Edits the price and quantity of the product
     */
    public void edit() {
        int q = Integer.valueOf(quantity.getText());
        int pr = Integer.valueOf(price.getText());
        p.setQuantity(q);
        p.setPrice(pr);

    }
}
