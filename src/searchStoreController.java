/**
 * lists all the stores
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class searchStoreController {

    private EndUser eu;
    @FXML
    private ListView<Store> storeList;

    /**
     * Sets up the screen
     * @param a EndUser
     */
    public void setScreen(EndUser a) {
        ArrayList<Store> y = Main.giveDatabase().storeList();
        ObservableList<Store> x = FXCollections.observableList(y);
        storeList.setItems(x);
        this.eu = a;
    }

    /**
     * Goes to the next screen
     * @throws IOException
     */
    public void openStore() throws IOException {
        Store selectedStore = storeList.getSelectionModel().getSelectedItem();

        if(selectedStore != null) {
            Stage primaryStage = Main.primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/categoryScreen.fxml"));
            Parent root = loader.load();
            categoryScreenController csc = loader.getController();
            csc.setValues(selectedStore, eu);
            primaryStage.setTitle("Category Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }

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
        Main.temp = 0;
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/endUserScreen.fxml"));
        Parent root = loader.load();
        endUserScreenController eusc = loader.getController();
        eusc.setValues(eu);
        primaryStage.setTitle("EndUser");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
