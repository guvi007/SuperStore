/**
 * This class is the controller for warehouse screen for others
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

public class warehouseScreenInfoOthersController {
    private Warehouse warehouse;
    private WarehouseAdmin admin;

    @FXML
    private Text name, adminid, d,h,k,id;

    @FXML
    private ListView linkedstores;

    public void setValues(Warehouse w, WarehouseAdmin admin) {
        warehouse = w;
        this.admin = admin;

        id.setText(w.getId());
        name.setText(w.getName());
        adminid.setText(w.getMyAdmin().getID());
        d.setText(Integer.toString(w.getD()));
        h.setText(Integer.toString(w.getH()));
        k.setText(Integer.toString(w.getK()));

        ArrayList<Store> ww = w.returnLinkedStore();
        if(ww.size() > 0) {
            ObservableList<Store> x = FXCollections.observableList(ww);
            linkedstores.setItems(x);
        }
    }

    /**
     * return to the previous screen
     * @throws IOException Given by the load function
     */
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/searchWarehouse.fxml"));
        Parent root = loader.load();
        searchWarehouseController wsi = loader.getController();
        wsi.setValues(admin);
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("All Warehouses");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
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
