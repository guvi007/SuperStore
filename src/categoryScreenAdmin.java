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

public class categoryScreenAdmin {

    private HashMap<String, ArrayList<Object>> hmap;
    private Building s;

    @FXML
    ListView<String> categoryList;

    void setValues(Building s) {
        if (s instanceof Warehouse)
            this.hmap = ((Warehouse) s).getCatalogue();
        else
            this.hmap = ((Store) s).getCatalogue();
        ArrayList<String> y = new ArrayList<String>();
        for (Object a : hmap.get("root")) {
            y.add((String)a);
        }
        this.s = s;
        ObservableList<String> x = FXCollections.observableList(y);
        categoryList.setItems(x);
    }

    public void addCategory() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/newCategoryScreen.fxml"));
        Parent root = loader.load();
        addStuffController csc = loader.getController();
        csc.setUp(s, "root", this);
        primaryStage.setTitle("Category Screen");
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

    public void forward() throws IOException {
        String selectedCategory = categoryList.getSelectionModel().getSelectedItem();

        if(selectedCategory != null) {
            Stage primaryStage = Main.primaryStage;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./GUI/subcategoryScreenAdmin.fxml"));
            Parent root = loader.load();
            subcategoryScreenAdmin csc = loader.getController();
            csc.setValues(s, selectedCategory);
            primaryStage.setTitle("SubCategory Screen");
            primaryStage.resizableProperty().setValue(Boolean.FALSE);
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }
    }

    public void delete() {
        String selectedCategory = categoryList.getSelectionModel().getSelectedItem();
        this.hmap.remove(selectedCategory);
        this.hmap.get("root").remove(selectedCategory);
        ArrayList<String> y = new ArrayList<String>();
        for (Object a : hmap.get("root")) {
            y.add((String)a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        categoryList.setItems(x);
    }
}
