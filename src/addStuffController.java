import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addStuffController {

    private String node;
    private Building s;

    @FXML
    private TextField text;

    @FXML
    private Text t;

    void setUp(Building s, String node) {
        this.node = node;
        this.s = s;
    }

    public void okay() throws IOException {
        String value = text.getText();
        if (s instanceof Store) {
            Warehouse w =(Warehouse) ((Store)s).getLinkedWarehouse();
            ArrayList<Object> array = w.getCatalogue().get(node);
            if (!(array.contains(value)))
                display();
            else
                s.addStuff(node, value);
        }
        else
            s.addStuff(node, value);

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/categoryScreenAdmin.fxml"));
        Parent root = loader.load();
        categoryScreenAdmin csc = loader.getController();
        csc.setValues(s);
        primaryStage.setTitle("Category Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    void display() {
        t.setText("Invalid Addition");
    }
}
