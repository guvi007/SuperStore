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

public class productsScreenAdmin {

    private HashMap<String, ArrayList<Object>> hmap;
    private Building s;
    private String subcategory;

    @FXML
    ListView<Product> list;

    void setValues(Building s, String subcategory) {
        if (s instanceof Warehouse)
            this.hmap = ((Warehouse) s).getCatalogue();
        else
            this.hmap = ((Store) s).getCatalogue();
        this.subcategory = subcategory;
        ArrayList<Product> y = new ArrayList<Product>();
        for (Object a : hmap.get(subcategory)) {
            y.add((Product)a);
        }
        this.s = s;
        ObservableList<Product> x = FXCollections.observableList(y);
        list.setItems(x);
    }

    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void openProduct() throws IOException {
        Product selected = list.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/productScreenAdmin.fxml"));
        Parent root = loader.load();
        productScreenAdmin csc = loader.getController();
        csc.setValues(selected);
        primaryStage.setTitle("Product Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void addProduct() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/newProductScreen.fxml"));
        Parent root = loader.load();
        addProductController csc = loader.getController();
        csc.setUp((Building)s, subcategory);
        primaryStage.setTitle("Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
