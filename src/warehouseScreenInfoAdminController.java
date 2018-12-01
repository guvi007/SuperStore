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

    public void signOut() throws IOException {
        changeValues();
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

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

    public void products() {
        changeValues();
    }
}
