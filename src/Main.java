import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application implements Serializable {
    public static Stage primaryStage;
    public static login log;
    public static int temp;
    private static Database database;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        this.primaryStage = primaryStage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        database = new Database();
        log = login.getInstance(database);
        launch(args);
    }

    public static boolean isSuperUserPresent() {
        if(database.getSuperUser() == null)
            return false;
        return true;
    }

    public static User setSuperUser() {
        database.setSuperUser();
        return database.getSuperUser();
    }

    public static Database giveDatabase() {
        return database;
    }

    public static void serialize() throws IOException {
        Database d = database;
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("Database.txt"));
            out.writeObject(d);
        }
        finally {
            if(out!=null)
                out.close();
        }
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("Database.txt"));
            database = (Database) in.readObject();
        }
        finally {
            if(in!=null)
                in.close();
        }
    }

    @Override
    public void stop() throws IOException, ClassNotFoundException{
        System.out.println("hi");
//        ArrayList<Object> a = new ArrayList<>();
//        ArrayList<Object> wareData = database.getWarehouseDatabase().returnForConfig();
//        ArrayList<Object> storeData =database.getStoreDatabase().returnForConfig();
//        for(Object temp: wareData) {
//            a.add(temp);
//        }
//        for(Object temp2: storeData) {
//            a.add(temp2);
//        }
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("Database/config.txt"));
//            out.writeObject(a);
//        }
//        finally {
//            out.close();
//        }
    }
}
