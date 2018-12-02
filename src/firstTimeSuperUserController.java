/**
 * Controller for superuser when the application is loaded for the
 * first time
 * @author Apoorv Singh, Gaurav Aggarwal
 */


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class firstTimeSuperUserController {

    @FXML
    private Text userId, password;

    /**
     * Initialises the screen
     */
    @FXML
    public void initialize() {
        User su = Main.setSuperUser();
        this.setid(su.getID());
        this.setpass(su.getPassword());
    }

    /**
     * Forwards to the next screen
     * @throws IOException Thrown by the load function
     */
    public void okay() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/superUser.fxml"));
        primaryStage.setTitle("Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Sets the id of superuser
     * @param id id of superuser
     */
    public void setid(String id) {
        this.userId.setText(id);
    }

    /**
     * Sets the password of superuser
     * @param pass password of superuser
     */
    public void setpass(String pass) {
        this.password.setText(pass);
    }

}
