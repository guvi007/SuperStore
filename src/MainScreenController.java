import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainScreenController {

    public void endUserScreen() throws IOException {
        Main.temp = 0;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/endUserScreen.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Welcome User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void warehouseAdminScreen() throws IOException {
        Main.temp = 1;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Warehouse Admin Login Page");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void storeAdminScreen() throws IOException {
        Main.temp = 2;
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Store Admin Login Page");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public void superUser() throws IOException {
        Main.temp = 3;
        Parent root;
        if(Main.isSuperUserPresent()) {
            root = FXMLLoader.load(getClass().getResource("./GUI/loginPage.fxml"));
        }
        else {
            root = FXMLLoader.load(getClass().getResource("./GUI/firstTimeSuperUser.fxml"));
        }
        Stage primaryStage = Main.primaryStage;
        primaryStage.setTitle("Welcome Super User");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

}
