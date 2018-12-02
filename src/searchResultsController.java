/**
 * Controller of search results of products
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class searchResultsController {
    private HashMap<String, ArrayList<Object>> hmap;
    private EndUser e;
    private String scname, cname;
    private ArrayList<Product> y;
    private Store s;

    @FXML
    ListView<Product> productList;

    /**
     * Sets up the screen
     * @param y List of products
     * @param cname Category name
     * @param subCategoryName SubcategoryName
     * @param e EndUser
     * @param hmap The inventory
     */
    public void setValues(ArrayList<Product> y, String cname, String subCategoryName, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.scname = subCategoryName;
        this.cname = cname;
        this.e = e;
        this.hmap = hmap;
        this.s = s;
        this.y = y;

        for (Object a : hmap.get(scname)) {
            y.add((Product) a);
        }
        ObservableList<Product> x = FXCollections.observableList(y);
        productList.setItems(x);
    }

    /**
     * Displays in a sorted manner
     */
    public void sortList() {
        Collections.sort(y);
        ObservableList<Product> x = FXCollections.observableList(y);
        productList.setItems(x);
    }

    /**
     * Goes to next screen
     * @throws IOException Thrown by load function
     */
    public void openProduct() throws IOException {
        Product product = productList.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/productScreenEndUser.fxml"));
        Parent root = loader.load();
        productScreenController psc = loader.getController();
        for (Object a : hmap.get(scname)) {
            y.add((Product)a);
        }
        psc.setValues(y, cname, scname, product, e, hmap);
        primaryStage.setTitle("Product Screen");
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

    /**
     * Goes back to the previous screen
     * @throws IOException Thrown by load function
     */
    public void back() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/subCategoryScreen.fxml"));
        Parent root = loader.load();
        subCategoryScreenController scsc = loader.getController();
        scsc.setValues(s, cname, e, hmap);
        primaryStage.setTitle("Sub-Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
