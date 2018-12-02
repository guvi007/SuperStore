/**
 * Controller for ScreenInfo
 * @author Apoorv Singh, Gaurav Aggarwal
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class storeScreenInfoController {
    private Store s;

    @FXML
    private Text name, adminid, d,h,k,id, wareid, warename;

    /**
     * Sets up the screen
     * @param store The store
     */
    public void setValues(Store store) {
        s = store;
        id.setText(store.getID());
        name.setText(store.getName());
        adminid.setText(store.getMyAdmin().getID());
        d.setText(Integer.toString(store.getD()));
        h.setText(Integer.toString(store.getH()));
        k.setText(Integer.toString(store.getK()));
        Warehouse linked = (Warehouse)store.getLinkedWarehouse();
        wareid.setText(linked.getId());
        warename.setText(linked.getName());
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
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/superUser.fxml"));
        primaryStage.setTitle("Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * For deleting the store
     * @throws IOException Thrown by load function
     */
    public void delete() throws IOException {
        Main.giveDatabase().getStoreDatabase().deleteStore(s.getID());
        Main.giveDatabase().getWarehouseDatabase().deleteLinkedStore(s);
        back();
    }

    public void products() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreenSuperUser.fxml"));
        Parent root = loader.load();
        categorySuperUser wsi = loader.getController();
        wsi.setUp(s.getCatalogue(), s);
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Store Products");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

}
