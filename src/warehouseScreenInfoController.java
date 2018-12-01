import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class warehouseScreenInfoController {
    private Warehouse w;

    @FXML
    private Text name, adminid, d,h,k,id;

    @FXML
    private ListView linkedstores;

    public void setValues(Warehouse war) {
        w = war;
        id.setText(war.getId());
        name.setText(war.getName());
        adminid.setText(war.getMyAdmin().getID());
        d.setText(Integer.toString(war.getD()));
        h.setText(Integer.toString(war.getH()));
        k.setText(Integer.toString(war.getK()));

        ArrayList<Store> ww = war.returnLinkedStore();
        if(ww.size() > 0) {
            ObservableList<Store> x = FXCollections.observableList(ww);
            linkedstores.setItems(x);
        }
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
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/superUser.fxml"));
        primaryStage.setTitle("Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
