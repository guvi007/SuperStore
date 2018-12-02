/**
 * Controller for categoryScreen, for the Super User
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
import java.util.HashMap;

public class categorySuperUser {

    private HashMap<String, ArrayList<Object>> hmap;
    private Building war;
    @FXML
    ListView<String> list;

    /**
     * Sets the categoryScreen
     * @param hmap The inventory of items
     * @param w The warehouse w
     */
    public void setUp(HashMap<String, ArrayList<Object>> hmap, Building w) {
        this.war = w;
        ArrayList<String> y = new ArrayList<String>();
        this.hmap = hmap;
        for (Object a : hmap.get("root")) {
            y.add((String)a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        list.setItems(x);
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
     * Opens the next screen
     * @throws IOException Thrown by load function
     */
    public void forward() throws IOException {
        String selected = list.getSelectionModel().getSelectedItem();

        if(selected != null) {
            Stage primaryStage = Main.primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/subcategorySuperUser.fxml"));
            Parent root = loader.load();
            subcategorySuperUser csc = loader.getController();
            csc.setUp(hmap, selected);
            primaryStage.setTitle("Subcategory Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }

    /**
     * Returns the user to the previous screen
     * @throws IOException Thrown by load function
     */
    public void back() throws IOException{
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/warehouseScreenInfo.fxml"));
        Parent root = loader.load();
        if(war instanceof Warehouse) {
            warehouseScreenInfoController csc = loader.getController();
            csc.setValues((Warehouse)war);
            primaryStage.setTitle("Warehouse Info");
        }
        else {
            storeScreenInfoController csc = loader.getController();
            csc.setValues((Store)war);
            primaryStage.setTitle("Store Info");
        }

        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
