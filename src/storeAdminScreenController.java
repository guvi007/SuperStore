/**
 * The storeAdmin homepage controller
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class storeAdminScreenController {
    private StoreAdmin admin;

    @FXML
    private Text welcome, name, id;

    /**
     * Sets up the Screen
     * @param w The store admin
     */
    public void setValues(StoreAdmin w) {
        admin = w;
        welcome.setText("WELCOME, " + w.getName());
        name.setText(w.getName());
        id.setText(w.getID());
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
     * Goes to the next screen
     * @throws IOException Thrown by load function
     */
    public void myStore() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/storeScreenInfoAdmin.fxml"));
        Parent root = loader.load();
        storeScreenInfoAdminController wsi = loader.getController();
        wsi.setValues(admin.myStore());
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Info Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

}
