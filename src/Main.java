/**
 * The main file
 * @author Apoorv Singh, Gaurav Aggarwal
 */

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

    /**
     * Starts the application
     * @param primaryStage The main Stage
     * @throws Exception Thrown by the load function
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./GUI/MainScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root, 800, 600));
        this.primaryStage = primaryStage;
        primaryStage.show();
    }

    /**
     * The main function
     * @param args
     */
    public static void main(String[] args) {
        database = new Database();
        log = login.getInstance(database);
        launch(args);
    }

    /**
     * Returns whether superuser has been initialised
     * @return Returns true if superuser has been initialised, false otherwise
     */
    public static boolean isSuperUserPresent() {
        if(database.getSuperUser() == null)
            return false;
        return true;
    }

    /**
     * Setter for superuser
     * @return Returns the superuser
     */
    public static User setSuperUser() {
        database.setSuperUser();
        return database.getSuperUser();
    }

    /**
     * Getter for database
     * @return Returns the database
     */
    public static Database giveDatabase() {
        return database;
    }

    /**
     * Function for serializing
     * @throws IOException Thrown by FileOutputStream
     */
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

    /**
     * Function for deserealizing
     * @throws IOException Thrown by FileInputStream
     * @throws ClassNotFoundException Thrown by readObject
     */
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
