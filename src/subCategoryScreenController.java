/**
 * This class is the controller for showing sub Categories.
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class subCategoryScreenController {

    private String cname;
    private EndUser e;
    private HashMap<String, ArrayList<Object>> hmap;
    private ArrayList<String> y = new ArrayList<>();
    private Store selectedStore;
    private ArrayList<Product> productList = new ArrayList<>();

    @FXML
    ListView<String> subCategoryList;

    @FXML
    TextField searchBar;

    /**
     * sets up the values from the parameters
     * @param s
     * @param categoryName
     * @param e Enduser instance
     * @param hmap
     */
    public void setValues(Store s, String categoryName, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.cname = categoryName;
        this.e = e;
        this.hmap = hmap;
        this.selectedStore = s;


        for (Object a : hmap.get(cname)) {
            if (a == null) {
                System.out.println("k");
                break;
            }
            System.out.println(a);
            y.add((String) a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        subCategoryList.setItems(x);

    }

    /**
     * sorts the list of categories/subcategories
     */
    public void sortList() {
        Collections.sort(y);
        ObservableList<String> x = FXCollections.observableList(y);
        subCategoryList.setItems(x);
    }

    /**
     * Shows the product list when a sub-category is selected.
     * @throws IOException
     */
    public void openProducts() throws IOException {
        String subCategoryName = subCategoryList.getSelectionModel().getSelectedItem();

        if(subCategoryName != null) {
            Stage primaryStage = Main.primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/searchResults.fxml"));
            Parent root = loader.load();
            searchResultsController src = loader.getController();
            for (Object a : hmap.get(subCategoryName)) {
                productList.add((Product) a);
            }
            src.setValues(productList, cname, subCategoryName, e, hmap);
            primaryStage.setTitle("Products Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }

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
     * return to the previous screen
     * @throws IOException Given by the load function
     */
    public void back() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreen.fxml"));
        Parent root = loader.load();
        categoryScreenController csc = loader.getController();
        csc.setValues(selectedStore, e);
        primaryStage.setTitle("Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public void searchResults() throws IOException {
        String x = searchBar.getText();
        ArrayList<Product> y = this.selectedStore.returnProductList(x);

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/searchResults.fxml"));
        Parent root = loader.load();
        searchResultsController src = loader.getController();
        productList = selectedStore.returnProductList(x);
        src.setValues(productList, cname, "", e, hmap);
        primaryStage.setTitle("Products Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
