/**
 * This class is the controller for categories super User.
 * @author Apoorv Singh, Gaurav Aggarwal
 */
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
import java.util.HashMap;

public class subcategorySuperUser {

    private HashMap<String, ArrayList<Object>> hmap;
    @FXML
    ListView<String> list;

    /**
     * Sets up inital values
     * @param hmap
     * @param cat
     */
    public void setUp(HashMap<String, ArrayList<Object>> hmap, String cat) {
            ArrayList<String> y = new ArrayList<String>();
            this.hmap = hmap;
            for (Object a : hmap.get(cat)) {
                y.add((String)a);
            }
            ObservableList<String> x = FXCollections.observableList(y);
            list.setItems(x);
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
     * Go to the next screen given a choice is selected from the list.
     * @throws IOException
     */
    public void forward() throws IOException {
        String selected = list.getSelectionModel().getSelectedItem();

        if( selected != null ) {
            Stage primaryStage = Main.primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/productsSuperUser.fxml"));
            Parent root = loader.load();
            productsSuperUser csc = loader.getController();
            csc.setUp(hmap, selected);
            primaryStage.setTitle("Products Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }
}
