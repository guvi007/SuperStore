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

public class subcategoryScreenAdmin {

    private HashMap<String, ArrayList<Object>> hmap;
    private Building s;
    private String category;

    @FXML
    ListView<String> list;

    void setValues(Building s, String category) {
        if (s instanceof Warehouse)
            this.hmap = ((Warehouse) s).getCatalogue();
        else
            this.hmap = ((Store) s).getCatalogue();
        this.category = category;
        ArrayList<String> y = new ArrayList<String>();
        for (Object a : hmap.get(category)) {
            y.add((String)a);
        }
        this.s = s;
        ObservableList<String> x = FXCollections.observableList(y);
        list.setItems(x);
    }

    public void addsubCategory() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/newCategoryScreen.fxml"));
        Parent root = loader.load();
        addStuffController csc = loader.getController();
        csc.setUp((Building)s, category, this);
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
        String selected = list.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/productsScreenAdmin.fxml"));
        Parent root = loader.load();
        productsScreenAdmin csc = loader.getController();
        csc.setValues(s, selected);
        primaryStage.setTitle("Products Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void back() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreenAdmin.fxml"));
        Parent root = loader.load();
        categoryScreenAdmin wsi = loader.getController();
        wsi.setValues(s);
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Products");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void delete() {
        String selected = list.getSelectionModel().getSelectedItem();
        this.hmap.get(category).remove(selected);
        this.hmap.remove(selected);
        ArrayList<String> y = new ArrayList<String>();
        for (Object a : hmap.get(category)) {
            y.add((String)a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        list.setItems(x);
    }
}
