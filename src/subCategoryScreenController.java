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

public class subCategoryScreenController {

    private String cname;
    private EndUser e;
    private HashMap<String, ArrayList<Object>> hmap;
    private ArrayList<String> y;

    @FXML
    ListView<String> subCategoryList;

    public void setValues(String categoryName, EndUser e, HashMap<String, ArrayList<Object>> hmap) {
        this.cname = categoryName;
        this.e = e;
        this.hmap = hmap;

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
        subCategoryScreenController scsc = loader.getController();
        scsc.setValues(subCategoryName, e, hmap);
        primaryStage.setTitle("Sub-Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }
}
