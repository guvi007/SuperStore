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

    public void setValues(ArrayList<Product> ProductList, String cname, String subCategoryName, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.scname = subCategoryName;
        this.cname = cname;
        this.e = e;
        this.hmap = hmap;
        this.s = s;

        this.y = ProductList;
        ObservableList<Product> x = FXCollections.observableList(y);
        productList.setItems(x);
    }

    public void sortList() {
        Collections.sort(y);
        ObservableList<Product> x = FXCollections.observableList(y);
        productList.setItems(x);
    }

    public void openProduct() throws IOException {
        Product product = productList.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/productScreenEndUser.fxml"));
        Parent root = loader.load();
        productScreenController psc = loader.getController();
        psc.setValues(y, cname, scname, product, e, hmap);
        primaryStage.setTitle("Product Screen");
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
