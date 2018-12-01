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

    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void AddWarehouse() throws IOException{
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/warehouseAddScreen.fxml"));
        primaryStage.setTitle("Add Warehouse");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void AddStore() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/storeAddScreen.fxml"));
        primaryStage.setTitle("Add Store");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
