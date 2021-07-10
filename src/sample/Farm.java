package sample;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class Farm {
    public void run() throws Exception{
        Image background = new Image(new FileInputStream("src/image/main page.jpg") );
        ImageView backgroundview = new ImageView(background);
        backgroundview.setFitHeight(700);
        backgroundview.setFitWidth(1080);
        backgroundview.setX(0);
        backgroundview.setY(0);
        VBox vBox = new VBox();
        Image chicken = new Image(new FileInputStream("src/image/chicken.gif"));
        ImageView chickenview = new ImageView(chicken);
        chickenview.setFitWidth(100);
        chickenview.setFitHeight(100);
        chickenview.setX(100);
        chickenview.setY(200);
        chickenview.setPreserveRatio(false);
        vBox.getChildren().add(chickenview);



        backgroundview.setPreserveRatio(false);
        Group backgroundgroup = new Group( chickenview);
        Scene backgroundscene = new Scene(vBox, 1080 , 700);
        Main main = new Main();
        main.changeScene(backgroundscene);
    }




}
