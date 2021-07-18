package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Result {
    public static void display(int time, int prizeTime, int prize, int level) throws Exception {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Level Results");
        //window.setMinWidth(250);
        window.setResizable(false);

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();

        Image result = new Image(new FileInputStream("src/image/results.png"),700,500,false,true);
        ImageView resultView = new ImageView(result);
        resultView.setPreserveRatio(false);
        resultView.setX(0);
        resultView.setY(0);


        Button ok = new Button("OK");
        ok.setLayoutX(300);
        ok.setLayoutY(420);
        ok.setMinHeight(50);
        ok.setMinWidth(100);
        ok.setStyle("-fx-background-color : #ff00fb");

        Text level1 = new Text(String.valueOf(level));
        level1.setX(340);level1.setY(80);
        level1.setFont(new Font(25));
        Text prizeTime1 = new Text(String.valueOf(prizeTime));
        prizeTime1.setX(350);prizeTime1.setY(150);
        prizeTime1.setFont(new Font(25));
        Text time1 = new Text(String.valueOf(time));
        time1.setX(350);time1.setY(200);
        time1.setFont(new Font(25));
        Text prize1 = new Text(String.valueOf(prize));
        prize1.setX(350);prize1.setY(250);
        prize1.setFont(new Font(25));




        Main m = new Main();
        ok.setOnAction(e -> {window.close();
            try {
                m.changeScene("menu.fxml", 600,400);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        anchorPane.getChildren().addAll(resultView,ok, level1,prizeTime1, time1, prize1);
        borderPane.setCenter(anchorPane);



        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(borderPane, 700, 500);
        window.setScene(scene);
        window.show();
    }
}
