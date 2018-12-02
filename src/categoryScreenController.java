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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class categoryScreenController {

    private EndUser e;
    private HashMap<String, ArrayList<Object>> hmap;
    private ArrayList<String> y;
    private Store s;

    @FXML
    ListView<String> categoryList;

    @FXML
    private TextField searchBar;

    public void setValues(Store s, EndUser e) {
        this.e = e;
        this.s = s;
        HashMap<String, ArrayList<Object>> catal = s.getCatalogue();
        for (Object a : catal.get("root")) {
            y.add((String)a);
        }
        ObservableList<String> x = FXCollections.observableList(y);
        categoryList.setItems(x);
    }

    public void sortList() {
        Collections.sort(y);
        ObservableList<String> x = FXCollections.observableList(y);
        categoryList.setItems(x);
    }

    public void openSubcategory() throws IOException {
        String categoryName = categoryList.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/subCategoryScreen.fxml"));
        Parent root = loader.load();
        subCategoryScreenController scsc = loader.getController();
        scsc.setValues(s, categoryName, e, hmap);
        primaryStage.setTitle("Sub-Category Screen");
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
        loader.setLocation(getClass().getResource("./GUI/searchStore.fxml"));
        Parent root = loader.load();
        searchStoreController ssc = loader.getController();
        ssc.setScreen(this.e);
        primaryStage.setTitle("Select Store");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

}
