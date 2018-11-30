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

    @FXML
    public void initialize() {
        User su = Main.setSuperUser();
        this.setid(su.getID());
        this.setpass(su.getPassword());
    }

    public void okay() throws IOException {
        Stage primaryStage = Main.primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/superUser.fxml"));
        primaryStage.setTitle("Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void setid(String id) {
        this.userId.setText(id);
    }

    public void setpass(String pass) {
        this.password.setText(pass);
    }

}
