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
    private Object position;

    @FXML
    private TextField text;

    @FXML
    private Text t;

    void setUp(Building s, String node, Object d) {
        this.node = node;
        this.s = s;
        this.position = d;
    }

    public void okay() throws IOException {
        String value = text.getText();
        if (s instanceof Store) {
            Warehouse w =(Warehouse) ((Store)s).getLinkedWarehouse();
            ArrayList<Object> array = w.getCatalogue().get(node);
            if (!(array.contains(value)))
                display();
            else {
                s.addStuff(node, value);
            }
        }
        else {
            System.out.println("lol");
            s.addStuff(node, value);
        }

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        Parent root;
        if(position instanceof categoryScreenAdmin) {
            loader.setLocation(getClass().getResource("./GUI/categoryScreenAdmin.fxml"));
            root = loader.load();
            categoryScreenAdmin csc = loader.getController();
            csc.setValues(s);
            primaryStage.setTitle("Category Screen");
        }
        else {
            loader.setLocation(getClass().getResource("./GUI/subcategoryScreenAdmin.fxml"));
            root = loader.load();
            subcategoryScreenAdmin csc = loader.getController();
            csc.setValues(s, node);
            primaryStage.setTitle("Sub Category Screen");
        }
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



    void display() {
        t.setText("Invalid Addition");
    }
}
