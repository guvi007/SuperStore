import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class addWarehouseController {

    @FXML
    private TextField nameWarehouse, nameAdmin, loginAdmin, passAdmin, invalid;

    @FXML
    private Text ID;

    public void initialize() {
        ID.setText("W-" + Main.giveDatabase().getWarehouseDatabase().getNumWarehouse());
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

    public void onAdd() throws IOException {
        if(nameWarehouse.getText().equals("") || nameAdmin.getText().equals("") || loginAdmin.getText().equals("") || passAdmin.getText().equals("")) {
            invalid.setText("Please fill all the fields!");
        }
        else {

            if(Main.giveDatabase().getWarehouseDatabase().isNamePresent(nameWarehouse.getText()))
                invalid.setText("Warehouse with same name already Exists!");
            else if(Main.giveDatabase().getWarehouseDatabase().isAdminLoginPresent(loginAdmin.getText()))
                invalid.setText("Admin Login already Exists!");
            else {
                Main.giveDatabase().getWarehouseDatabase().addWarehouse(nameWarehouse.getText(), nameAdmin.getText(), loginAdmin.getText(), passAdmin.getText());
                back();
            }

        }
    }
}
