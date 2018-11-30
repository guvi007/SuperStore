import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class loginPageController {

    public void back() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    @FXML
    private TextField username, password,invalidField;

    @FXML
    private void checkCredentials(ActionEvent Event) throws IOException {
        String enteredUsername = username.getText(), enteredPassword = password.getText();
        User temp = null;

        if(enteredPassword.equals("") || enteredUsername.equals("")) {
            invalidField.setText("Please enter both the fields");
        }
        else {
            if(Main.temp == 1) {
                temp = Main.log.checkWarehouseAdmin(enteredUsername, enteredPassword);
            }
            else if(Main.temp == 2){
                temp = Main.log.checkStoreAdmin(enteredUsername, enteredPassword);
            }
            else {
                temp = Main.log.checkSuperUser(enteredUsername, enteredPassword);
            }

            Stage primaryStage = Main.primaryStage;

            if(temp == null){
                invalidField.setText("Invalid Credentials, Please Try Again.");
            }
            else {
                Parent root = null;
                if(Main.temp == 2) {
                    root = FXMLLoader.load(getClass().getResource("./GUI/warehouseAdminScreen.fxml"));
                    primaryStage.setTitle("Warehouse Admin");
                }
                else if(Main.temp == 3) {
                    root = FXMLLoader.load(getClass().getResource("./GUI/superUser.fxml"));
                    primaryStage.setTitle("Super User");
                }
                else if(Main.temp == 1) {
                    root = FXMLLoader.load(getClass().getResource("./GUI/storeAdminScreen.fxml"));
                    primaryStage.setTitle("Super User");
                }
                primaryStage.resizableProperty().setValue(Boolean.FALSE);
                primaryStage.setScene(new Scene(root, 800, 600));
                primaryStage.show();
            }
        }
    }
}