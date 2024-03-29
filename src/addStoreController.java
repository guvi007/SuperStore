/**
 * This class is the controller for adding a new Store.
 * @author Apoorv Singh, Gaurav Aggarwal
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addStoreController {

    @FXML
    private TextField nameStore, nameAdmin, loginAdmin, passAdmin, invalid;

    @FXML
    private Text ID;

    @FXML
    private ChoiceBox<Warehouse> cb;

    /**
     * Initialises the screen for adding the new store
     */
    public void initialize() {
        ID.setText("S-" + Main.giveDatabase().getStoreDatabase().getNumStores());
        ArrayList<Warehouse> w = Main.giveDatabase().getWarehouseDatabase().returnList();
        if(w.size() > 0) {
            ObservableList<Warehouse> x = FXCollections.observableList(w);
            cb.setItems(x);
        }
        else {
            invalid.setText("No Warehouses Exist to link!");
        }
    }

    /**
     * Function for signing out the user. Returns the user to main screen.
     * @throws IOException Given by the load function.
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
     * Takes the user back to the previous screen
     * @throws IOException Given by the load function.
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
     * Adds the new Store, and returns the user to the previous screen. Checks whether
     * all the fields have been filled and also checks for their validity.
     * @throws IOException Given by the load function.
     */
    public void onAdd() throws IOException {
        if(cb.getValue() == null || nameStore.getText().equals("") || nameAdmin.getText().equals("") || loginAdmin.getText().equals("") || passAdmin.getText().equals("")) {
            invalid.setText("Please fill all the fields!");
        }
        else {

            if(Main.giveDatabase().getStoreDatabase().isNamePresent(nameStore.getText()))
                invalid.setText("Store with same name already Exists!");
            else if(Main.giveDatabase().getStoreDatabase().isAdminLoginPresent(loginAdmin.getText()))
                invalid.setText("Admin Login already Exists!");
            else {
                Store s = Main.giveDatabase().getStoreDatabase().addStore(nameStore.getText(), cb.getValue(), nameAdmin.getText(), loginAdmin.getText(), passAdmin.getText());
                cb.getValue().addLinkedStore(s);
                back();
            }

        }
    }
}
