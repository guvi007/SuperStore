/**
 * This class is the controller for adding a category/subcategory.
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

public class addStuffController {

    private String node;
    private Building s;
    private Object position;
    private int check = 0;

    @FXML
    private TextField text;

    @FXML
    private Text t;

    /**
     *
     * @param s The Building object: whether the object is a store or a warehouse
     * @param node This is the subcategory where the required item
     *             needs to be added
     * @param d The category or subcategory that needs to be added
     */
    void setUp(Building s, String node, Object d) {
        this.node = node;
        this.s = s;
        this.position = d;
    }

    /**
     * Updates the catalogue with new category/subcategory. Also loads the previous screen
     * @throws IOException Given by the load function
     */

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

        if(check == 0) {
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
    }


    /**
     * This function displays the message when the insertion is invalid for store
     * (The category/subcategory is not in the linked warehouse)
     */
    void display() {
        check = 1;
        if(s instanceof Store) {
            t.setText("Invalid Addition, Maybe this category isn't present in your linked warehouse!");
        }
        else {
            t.setText("Invalid Addition");
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
}
