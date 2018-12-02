/**
 * This class is the controller for display store info for admin
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class storeScreenInfoAdminController {
    private Store store;

    @FXML
    private Text name, id, admin, warename, wareid;

    @FXML
    private TextField d,h,k;

    /**
     *
     * sets up the values from store object
     * @param store The store Object
     */
    public void setValues(Store store) {
        this.store = store;
        name.setText(store.getName());
        id.setText(store.getID());
        admin.setText(store.getMyAdmin().getID());
        warename.setText(((Warehouse)store.getLinkedWarehouse()).getName());
        wareid.setText(((Warehouse)store.getLinkedWarehouse()).getId());

        d.setText(Integer.toString(store.getD()));
        h.setText(Integer.toString(store.getH()));
        k.setText(Integer.toString(store.getK()));
    }

    /**
     * Change values of d,k,h if changed
     */
    public void changeValues() {
        store.setD(Integer.parseInt(d.getText()));
        store.setH(Integer.parseInt(h.getText()));
        store.setK(Integer.parseInt(k.getText()));
    }

    /**
     * return to the previous screen
     * @throws IOException Given by the load function
     */
    public void back() throws IOException {
        changeValues();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/storeAdminScreen.fxml"));
        Parent root = loader.load();
        storeAdminScreenController wsi = loader.getController();
        wsi.setValues((StoreAdmin)store.getMyAdmin());
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Store Admin");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Function for signing out the user, returns the user to the main screen
     * @throws IOException Thrown by load function
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
     * Go to the catgory Screen to display all the categories present in the store.
     * @throws IOException Given by the load
     */
    public void openCategory() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreenAdmin.fxml"));
        Parent root = loader.load();
        categoryScreenAdmin csc = loader.getController();
        csc.setValues(store);
        primaryStage.setTitle("Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
