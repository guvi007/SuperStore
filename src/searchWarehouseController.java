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

public class searchWarehouseController {
    private WarehouseAdmin admin;

    @FXML
    private ListView<Warehouse> warehouses;

    public void initialize() {
        ArrayList<Warehouse> w = Main.giveDatabase().getWarehouseDatabase().returnList();
        if(w.size() > 0) {
            ObservableList<Warehouse> x = FXCollections.observableList(w);
            warehouses.setItems(x);
        }
    }

    public void setValues(WarehouseAdmin w) {
        admin = w;
    }

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/warehouseAdminScreen.fxml"));
        Parent root = loader.load();
        warehouseAdminScreenController wsi = loader.getController();
        wsi.setValues(admin);
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Admin");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
