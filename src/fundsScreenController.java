import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class fundsScreenController {

//    private EndUser eu;
    @FXML
    private TextField funds;

//    public void setEndUser(EndUser x) {
//        System.out.println("=====================================");
//        this.eu = x;
//    }

    public void confirm() {
        int x = Integer.valueOf(funds.getText());
        System.out.println("=====================================");
//        this.eu.setFunds(x);

    }
}
