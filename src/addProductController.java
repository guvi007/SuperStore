import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class addProductController {

    private String node;
    private Building s;

    @FXML
    private TextField name, id, price, quantity;

    @FXML
    private Text t;

    void setUp(Building s, String node) {
        this.node = node;
        this.s = s;
    }

    public void okay() throws IOException {
        String n = name.getText();
        String i = id.getText();
        int pr = Integer.valueOf(price.getText());
        int q = Integer.valueOf(quantity.getText());
        Product p = new Product(n,i,pr,q);
        if (s instanceof Store) {
            Warehouse w =(Warehouse) ((Store)s).getLinkedWarehouse();
            ArrayList<Object> array = w.getCatalogue().get(node);
            if (!(array.contains(p)))
                display();
            else
                s.addStuff(node, p);
        }
        else
            s.addStuff(node, p);

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/subcategoryScreenAdmin.fxml"));
        Parent root = loader.load();
        subcategoryScreenAdmin csc = loader.getController();
        csc.setValues(s, node);
        primaryStage.setTitle("SubCategory Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    void display() {
        t.setText("Invalid Addition");
    }
}
