/**
 * Controller of productScreen for superuser
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class productSuperUser {

    @FXML
    Text name,id,price,quantity;

    /**
     * Sets up the screen
     * @param p The product
     */
    public void setUp(Product p) {
        name.setText(p.getName());
        id.setText(p.getID());
        price.setText(Integer.toString(p.getPrice()));
        quantity.setText(Integer.toString(p.getQuantity()));
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
}
