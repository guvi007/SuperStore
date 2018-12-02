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

public class searchStoreController {

    private EndUser eu;
    @FXML
    private ListView<Store> storeList;

    public void setScreen(EndUser a) {
        ArrayList<Store> y = Main.giveDatabase().storeList();
        ObservableList<Store> x = FXCollections.observableList(y);
        storeList.setItems(x);
        this.eu = a;
    }

    public void openStore() throws IOException {
        Store selectedStore = storeList.getSelectionModel().getSelectedItem();

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreen.fxml"));
        Parent root = loader.load();
        categoryScreenController csc = loader.getController();
        csc.setValues(selectedStore, eu);
        primaryStage.setTitle("Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
