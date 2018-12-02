/**
 * This class is the controller for working of superUser screen
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class superUserController {

    @FXML
    private Text welcome;

    @FXML
    private ListView<Warehouse> warehouseList;

    @FXML
    private ListView<Store> storeList;


    @FXML
    public void initialize() {
        welcome.setText("WELCOME, " + Main.giveDatabase().getSuperUser().getName());
        ArrayList<Warehouse> w = Main.giveDatabase().getWarehouseDatabase().returnList();
        ArrayList<Store> s = Main.giveDatabase().getStoreDatabase().returnList();
        if(w.size() > 0) {
            ObservableList<Warehouse> x = FXCollections.observableList(w);
            warehouseList.setItems(x);
        }
        if(s.size() > 0) {
            ObservableList<Store> x = FXCollections.observableList(s);
            storeList.setItems(x);
        }
    }

    /**
     * Go to the catgory Screen to display all the categories present in the store.
     * @throws IOException Given by the load
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
     * Adds Warehouse to the Database
     * @throws IOException
     */
    public void AddWarehouse() throws IOException{
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/warehouseAddScreen.fxml"));
        primaryStage.setTitle("Add Warehouse");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Adds Stores to the Database
     * @throws IOException
     */
    public void AddStore() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/storeAddScreen.fxml"));
        primaryStage.setTitle("Add Store");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * search for the warehouse info
     * @throws IOException
     */
    public void seeWarehouseInfo() throws IOException{
        Warehouse w = warehouseList.getSelectionModel().getSelectedItem();
        if(w != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/warehouseScreenInfo.fxml"));
            Parent root = loader.load();
            warehouseScreenInfoController wsi = loader.getController();
            wsi.setValues(w);
            Stage primaryStage = Main.primaryStage;
            primaryStage.setTitle("Warehouse Info Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }

    /**
     * search for the store info
     * @throws IOException
     */
    public void seeStoreInfo() throws IOException{
        Store w = storeList.getSelectionModel().getSelectedItem();
        if(w != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/storeScreenInfo.fxml"));
            Parent root = loader.load();
            storeScreenInfoController  wsi = loader.getController();
            wsi.setValues(w);
            Stage primaryStage = Main.primaryStage;
            primaryStage.setTitle("Store Info Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }
}
