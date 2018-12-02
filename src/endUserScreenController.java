/**
 * Controller for end user home screen
 * @author Apoorv Singh, Gaurav Aggarwal
 */


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class endUserScreenController {
    private EndUser endUser;

    @FXML
    private Text funds;

    /**
     * Sets up the screen
     * @param eu The end User
     */
    void setValues(EndUser eu) {
        this.endUser = eu;
        funds.setText(Integer.toString(this.endUser.getFunds()));
    }

    /**
     * Function for signing out the user, returns the user to the main screen
     * @throws IOException Thrown by load function
     */
    public void signOut() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Adds funds for the end user
     * @throws IOException Thrown by load function
     */
    public void addFunds() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/funds.fxml"));
        Parent root = loader.load();
        fundsScreenController fsc = loader.getController();
        System.out.println(endUser.getFunds());
        fsc.setEndUser(endUser);
        primaryStage.setTitle("Funds");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    /**
     * Opens the next screen
     * @throws IOException Thrown by load function
     */
    public void searchStore() throws IOException {
        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/searchStore.fxml"));
        Parent root = loader.load();
        searchStoreController ssc = loader.getController();
        ssc.setScreen(this.endUser);
        primaryStage.setTitle("Select Store");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
