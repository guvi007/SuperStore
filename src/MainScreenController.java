/**
 * Controller for the main Screen
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class MainScreenController {

    /**
     * Opens the enduser screen if user is an end user
     * @throws IOException Thrown by load function
     */
    public void endUserScreen() throws IOException {
        Main.temp = 0;
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/endUserScreen.fxml"));
        Parent root = loader.load();
        endUserScreenController eusc = loader.getController();
        EndUser eu = new EndUser();
        eusc.setValues(eu);
        primaryStage.setTitle("EndUser");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    /**
     * Opens the warehouseAdmin screen if user is an warehouse Admin
     * @throws IOException Thrown by load function
     */
    public void warehouseAdminScreen() throws IOException {
        Main.temp = 1;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Admin Login Page");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Opens the store Admin screen if user is an store Admin
     * @throws IOException Thrown by load function
     */
    public void storeAdminScreen() throws IOException {
        Main.temp = 2;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Store Admin Login Page");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Opens the superUser screen if user is an superUser
     * @throws IOException Thrown by load function
     */
    public void superUser() throws IOException {
        Main.temp = 3;
        Parent root;
        if(Main.isSuperUserPresent()) {
            root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        }
        else {
            root = FXMLLoader.load(getClass().getResource("./GUI/firstTimeSuperUser.fxml"));
        }
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Welcome Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

}
