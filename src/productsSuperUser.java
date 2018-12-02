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

public class productsSuperUser {

    @FXML
    ListView<Product> list;

    public void setUp(HashMap<String, ArrayList<Object>> hmap, String sub) {
        ArrayList<Product> y = new ArrayList<Product>();
        for (Object a : hmap.get(sub)) {
            y.add((Product)a);
        }
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

    public void forward() throws IOException {
        Product selected = list.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/productScreenSuper.fxml"));
        Parent root = loader.load();
        productSuperUser csc = loader.getController();
        csc.setUp(selected);
        primaryStage.setTitle("Product Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
