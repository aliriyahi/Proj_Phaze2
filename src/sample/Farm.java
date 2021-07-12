package sample;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
//import java.beans.EventHandler;
import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Farm {


    public void run() throws Exception{
        Well well = new Well();
        int[][] grass=new int[6][6];

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();


        //----------------------------------------------------------------------------- main page
        Image background = new Image(new FileInputStream("src/image/main page.jpg") );
        ImageView backgroundview = new ImageView(background);
        backgroundview.setFitHeight(700);
        backgroundview.setFitWidth(1080);
        backgroundview.setX(0);
        backgroundview.setY(0);
        //backgroundview.setPreserveRatio(false);

       //----------------------------------------------------------------------------- Handling Button
        Button menu = new Button("Menu");
        menu.setLayoutX(20);
        menu.setLayoutY(650);
        menu.setMinHeight(40);
        menu.setMinWidth(90);
        menu.setStyle("-fx-background-color : #00b2ff");
        menu.setOnAction(e -> {
            try {
                Pause.display();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        Button chickenBuy = new Button(" 100$ ");
        chickenBuy.setLayoutX(37); chickenBuy.setLayoutY(80);
        chickenBuy.setStyle("-fx-background-color : #00b2ff");
        Button turkeyBuy = new Button(" 200$ ");
        turkeyBuy.setLayoutX(125); turkeyBuy.setLayoutY(80);
        turkeyBuy.setStyle("-fx-background-color : #00b2ff");
        Button buffaloBuy = new Button(" 400$ ");
        buffaloBuy.setLayoutX(215); buffaloBuy.setLayoutY(80);
        buffaloBuy.setStyle("-fx-background-color : #00b2ff");
        Button dogBuy = new Button(" 100$ ");
        dogBuy.setLayoutX(308); dogBuy.setLayoutY(80);
        dogBuy.setStyle("-fx-background-color : #00b2ff");
        Button catBuy = new Button(" 150$ ");
        catBuy.setLayoutX(395); catBuy.setLayoutY(80);
        catBuy.setStyle("-fx-background-color : #00b2ff");

        //chickenBuy.setOnAction(e -> );

        //-------------------------------------------------------------------- Image loading
        Image chickenIcon = new Image(new FileInputStream("src/image/chicken-.png"),110,90,false,true);
        ImageView chickenIconview = new ImageView(chickenIcon);
        chickenIconview.setX(5);
        chickenIconview.setY(0);
        Image turkeyIcon = new Image(new FileInputStream("src/image/turkey-.png"),110,90,false,true);
        ImageView turkeyIconview = new ImageView(turkeyIcon);
        turkeyIconview.setX(95);
        turkeyIconview.setY(0);
        Image buffaloIcon = new Image(new FileInputStream("src/image/buffalo-.png"),110,90,false,true);
        ImageView buffaloIconview = new ImageView(buffaloIcon);
        buffaloIconview.setX(185);
        buffaloIconview.setY(0);
        Image dogIcon = new Image(new FileInputStream("src/image/dog-.png"),110,90,false,true);
        ImageView dogIconview = new ImageView(dogIcon);
        dogIconview.setX(275);
        dogIconview.setY(0);
        Image catIcon = new Image(new FileInputStream("src/image/cat-.png"),110,90,false,true);
        ImageView catIconview = new ImageView(catIcon);
        catIconview.setX(365);
        catIconview.setY(0);






        //------------------------------------------------------------------------ Handling grass
        EventHandler<MouseEvent> grassHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(well.water > 0) {

                    //grass[y][x] += 1;
                    well.water -= 1;
                    logger("INFO","PLANTED SUCCESSFULLY");
                }
                else{
                    Text text = new Text("A");
                    text.setX(800);
                    text.setY(500);
                    anchorPane.getChildren().add(text);
                    logger("ERROR","you dont have any water!");
                }

            }
        };

        backgroundview.addEventFilter(MouseEvent.MOUSE_CLICKED, grassHandler);


        //---------------------------------------------------------------------------
        //        HBox.setMargin(bearView, new Insets(0, 0, 0, 0));
        anchorPane.getChildren().addAll(backgroundview, chickenIconview, turkeyIconview, buffaloIconview, dogIconview, catIconview , chickenBuy, turkeyBuy , buffaloBuy , dogBuy , catBuy , menu);
        borderPane.setCenter(anchorPane);


        Scene backgroundscene = new Scene(borderPane, 1080, 700);
        Main main = new Main();
        main.changeScene(backgroundscene);

    }



    public void logger(String type, String message ){
        Date date = new Date();
        File log = new File("log.txt");
        try {
            PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
            logger.append("["+type+"] ,"+date.toLocaleString()+" ,"+message);
            logger.println();
            logger.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void Wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}