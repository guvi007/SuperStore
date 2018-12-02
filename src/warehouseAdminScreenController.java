/**
 * This class is the controller for warehouse Admin Screen
 * @author Apoorv Singh, Gaurav Aggarwal
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class warehouseAdminScreenController {
    private WarehouseAdmin admin;

    @FXML
    private Text welcome, name, id;

    /**
     * Sets inital values
     * @param w
     */
    public void setValues(WarehouseAdmin w) {
        admin = w;
        welcome.setText("WELCOME, " + w.getName());
        name.setText(w.getName());
        id.setText(w.getID());
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
     * displays info for admin's warehouse
     * @throws IOException
     */
    public void myWarehouse() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/warehouseScreenInfoAdmin.fxml"));
        Parent root = loader.load();
        warehouseScreenInfoAdminController wsi = loader.getController();
        wsi.setValues(admin.returnMyWarehouse());
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Info Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * displaying information for all the warehouses
     * @throws IOException
     */
    public void allWarehouse() throws IOException{
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
}
