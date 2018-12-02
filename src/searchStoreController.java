import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class searchStoreController {

    @FXML
    private ListView<String> storeList;

    public void setScreen() {
        ArrayList<String> y = Main.giveDatabase().storeList();
        ObservableList<String> x = FXCollections.observableList(y);
        storeList.setItems(x);
    }
}
