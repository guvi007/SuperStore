/**
 * This class is the controller for adding a new product
 * @author Apoorv Singh, Gaurav Aggarwal
 */

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

    /**
     *
     * @param s The Building object: whether the object is a store or a warehouse
     * @param node This is the subcategory where the required item
     *             needs to be added
     */
    void setUp(Building s, String node) {
        this.node = node;
        this.s = s;
    }

    /**
     * Updates the catalogue with new product. Also loads the previous screen
     * @throws IOException Given by the load function
     */
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

    /**
     * This function displays the message when the insertion is invalid for store
     * (The product is not in the linked warehouse)
     */
    void display() {
        t.setText("Invalid Addition");
    }
}
