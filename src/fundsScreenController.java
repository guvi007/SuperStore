import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class fundsScreenController {
    private EndUser eu;

    @FXML
    private TextField funds;

    public void setEndUser(EndUser x) {
        this.eu = x;
    }

    public void confirm() throws IOException {
        int x = Integer.valueOf(funds.getText());
        this.eu.setFunds(this.eu.getFunds() + x);

        Stage primaryStage = Main.primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./GUI/endUserScreen.fxml"));
        Parent root = loader.load();
        endUserScreenController fsc = loader.getController();
        fsc.setValues(eu);
        primaryStage.setTitle("EndUser");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
