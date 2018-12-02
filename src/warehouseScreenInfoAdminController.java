/**
 * This class is the for warehouse screen admin
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class warehouseScreenInfoAdminController {
    private Warehouse warehouse;

    @FXML
    private Text name, id, admin;

    @FXML
    private TextField d,h,k;

    @FXML
    private ListView<Store> linkedStores;

    /**
     * sets initial values
     * @param w
     */
    public void setValues(Warehouse w) {
        warehouse = w;
        name.setText(w.getName());
        id.setText(w.getId());
        admin.setText(w.getMyAdmin().getID());

        d.setText(Integer.toString(w.getD()));
        h.setText(Integer.toString(w.getH()));
        k.setText(Integer.toString(w.getK()));

        ArrayList<Store> ww = w.returnLinkedStore();
        if(ww.size() > 0) {
            ObservableList<Store> x = FXCollections.observableList(ww);
            linkedStores.setItems(x);
        }
    }

    /**
     * Go to the catgory Screen to display all the categories present in the store.
     * @throws IOException Given by the load
     */
    public void signOut() throws IOException {
        changeValues();
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * return to the previous screen
     * @throws IOException Given by the load function
     */
    public void back() throws IOException {
        changeValues();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/warehouseAdminScreen.fxml"));
        Parent root = loader.load();
        warehouseAdminScreenController wsi = loader.getController();
        wsi.setValues((WarehouseAdmin)warehouse.getMyAdmin());
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Admin");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void changeValues() {
        warehouse.setD(Integer.parseInt(d.getText()));
        warehouse.setH(Integer.parseInt(h.getText()));
        warehouse.setK(Integer.parseInt(k.getText()));
    }

    /**
     * redirects to the screen to show products
     * @throws IOException
     */
    public void products() throws IOException{
        changeValues();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreenAdmin.fxml"));
        Parent root = loader.load();
        categoryScreenAdmin wsi = loader.getController();
        wsi.setValues(warehouse);
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Products");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
