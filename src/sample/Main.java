package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("FARM FRENZY");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public void changeScene(String fxml, int width, int height) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        //stg.getScene().setRoot(pane);

        stg.setScene(new Scene(pane, width, height));

    }
    public void changeScene(Scene scene) throws IOException{


        stg.setScene(scene);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
