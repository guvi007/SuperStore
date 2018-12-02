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
    private ArrayList<String> y;
    private Store selectedStore;
    private ArrayList<Product> productList;

    @FXML
    ListView<String> subCategoryList;

    @FXML
    TextField searchBar;

    public void setValues(Store s, String categoryName, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.cname = categoryName;
        this.e = e;
        this.hmap = hmap;
        this.selectedStore = s;

        for (Object a : hmap.get(cname)) {
            y.add((String) a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        subCategoryList.setItems(x);

    }

    public void sortList() {
        Collections.sort(y);
        ObservableList<String> x = FXCollections.observableList(y);
        subCategoryList.setItems(x);
    }

    public void openProducts() throws IOException {
        String subCategoryName = subCategoryList.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/searchResults.fxml"));
        Parent root = loader.load();
        searchResultsController src = loader.getController();
        for (Object a : hmap.get(subCategoryName)) {
            productList.add((Product)a);
        }
        src.setValues(productList, cname, subCategoryName, e, hmap);
        primaryStage.setTitle("Products Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }

    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

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
        src.setValues(productList, cname, "", e, hmap);
        primaryStage.setTitle("Products Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
