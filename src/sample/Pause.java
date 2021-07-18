package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Pause {
    public static void display() throws Exception {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("MENU");
        //window.setMinWidth(250);
        window.setResizable(false);

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();

        Image pause = new Image(new FileInputStream("src/image/pause.jpg"),200,300,false,true);
        ImageView pauseView = new ImageView(pause);
        pauseView.setPreserveRatio(false);
        pauseView.setX(0);
        pauseView.setY(0);


        Button Continue = new Button("Continue");
        Button mainMenu = new Button("Main menu");
        Continue.setLayoutX(50);
        Continue.setLayoutY(50);
        mainMenu.setLayoutX(50);
        mainMenu.setLayoutY(150);
        Continue.setMinHeight(50);
        Continue.setMinWidth(100);
        mainMenu.setMinHeight(50);
        mainMenu.setMinWidth(100);
        Continue.setStyle("-fx-background-color : #ff9900");
        mainMenu.setStyle("-fx-background-color : #ff9900");

        //Farm farm = new Farm();

        Continue.setOnAction(e -> {window.close(); Farm.gamePause = false;});
        Main m = new Main();
        mainMenu.setOnAction(e -> {
            try {
                m.changeScene("menu.fxml",600,400);
                window.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        anchorPane.getChildren().addAll(pauseView, Continue , mainMenu);
        borderPane.setCenter(anchorPane);



        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(borderPane, 200, 300);
        window.setScene(scene);
        window.showAndWait();
    }

}
