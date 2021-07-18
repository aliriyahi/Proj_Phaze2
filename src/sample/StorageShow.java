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

import java.io.*;
import java.util.Date;

public class StorageShow {
    public static void display() throws Exception{
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("StorageShow");
        //window.setMinWidth(250);
        window.setResizable(false);

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();

        Image StorageShow = new Image(new FileInputStream("src/image/storageshow.png"),700,500,false,true);
        ImageView StorageShowview = new ImageView(StorageShow);
        StorageShowview.setPreserveRatio(false);
        StorageShowview.setX(0);
        StorageShowview.setY(0);
        anchorPane.getChildren().addAll(StorageShowview);

        //Car car = new Car();
        Text price = new Text(String.valueOf(Car.price));
        price.setX(580);price.setY(430);
        price.setFont(new Font(22));
        anchorPane.getChildren().add(price);

        Text egg = new Text("Egg : "+String.valueOf(Storage.egg)+"            15");
        egg.setX(30);egg.setY(105);
        Text feather = new Text("feather : "+String.valueOf(Storage.feather)+"          20");
        feather.setX(30);feather.setY(130);
        Text milk = new Text("milk : "+String.valueOf(Storage.milk)+"            25");
        milk.setX(30);milk.setY(155);
        Text flour = new Text("flour : "+String.valueOf(Storage.flour)+"            40");
        flour.setX(30);flour.setY(185);
        Text fabric = new Text("fabric : "+String.valueOf(Storage.fabric)+"            50");
        fabric.setX(30);fabric.setY(210);
        Text packmilk = new Text("packmilk : "+String.valueOf(Storage.packMilk)+"        60");
        packmilk.setX(30);packmilk.setY(235);
        Text bread = new Text("bread : "+String.valueOf(Storage.bread)+"            80");
        bread.setX(30);bread.setY(265);
        Text cloths = new Text("cloths : "+String.valueOf(Storage.cloths)+"            100");
        cloths.setX(30);cloths.setY(290);
        Text icecream = new Text("icecream : "+String.valueOf(Storage.icecream)+"        120");
        icecream.setX(30);icecream.setY(315);
        Text lion = new Text("lion : "+String.valueOf(Storage.lion)+"            300");
        lion.setX(30);lion.setY(345);
        Text bear = new Text("bear : "+String.valueOf(Storage.bear)+"            400");
        bear.setX(30);bear.setY(375);
        Text tiger = new Text("tiger : "+String.valueOf(Storage.tiger)+"            500");
        tiger.setX(30);tiger.setY(400);


        anchorPane.getChildren().addAll(egg,feather,milk,flour,fabric,packmilk,bread,cloths,icecream,lion,bear,tiger);

        Button eggload = new Button("load");eggload.setLayoutX(140);eggload.setLayoutY(87);
        Button eggunload = new Button("unload");eggunload.setLayoutX(190);eggunload.setLayoutY(87);
        Button featherload = new Button("load");featherload.setLayoutX(140);featherload.setLayoutY(112);
        Button featherunload = new Button("unload");featherunload.setLayoutX(190);featherunload.setLayoutY(112);
        Button milkload = new Button("load");milkload.setLayoutX(140);milkload.setLayoutY(139);
        Button milkunload = new Button("unload");milkunload.setLayoutX(190);milkunload.setLayoutY(139);
        Button flourload = new Button("load");flourload.setLayoutX(140);flourload.setLayoutY(165);
        Button flourunload = new Button("unload");flourunload.setLayoutX(190);flourunload.setLayoutY(165);
        Button fabricload = new Button("load");fabricload.setLayoutX(140);fabricload.setLayoutY(191);
        Button fabricunload = new Button("unload");fabricunload.setLayoutX(190);fabricunload.setLayoutY(191);
        Button packmilkload = new Button("load");packmilkload.setLayoutX(140);packmilkload.setLayoutY(217);
        Button packmilkunload = new Button("unload");packmilkunload.setLayoutX(190);packmilkunload.setLayoutY(217);
        Button breadload = new Button("load");breadload.setLayoutX(140);breadload.setLayoutY(244);
        Button breadunload = new Button("unload");breadunload.setLayoutX(190);breadunload.setLayoutY(244);
        Button clothsload = new Button("load");clothsload.setLayoutX(140);clothsload.setLayoutY(271);
        Button clothsunload = new Button("unload");clothsunload.setLayoutX(190);clothsunload.setLayoutY(271);
        Button icecreamload = new Button("load");icecreamload.setLayoutX(140);icecreamload.setLayoutY(298);
        Button icecreamunload = new Button("unload");icecreamunload.setLayoutX(190);icecreamunload.setLayoutY(298);
        Button lionload = new Button("load");lionload.setLayoutX(140);lionload.setLayoutY(325);
        Button lionunload = new Button("unload");lionunload.setLayoutX(190);lionunload.setLayoutY(325);
        Button bearload = new Button("load");bearload.setLayoutX(140);bearload.setLayoutY(354);
        Button bearunload = new Button("unload");bearunload.setLayoutX(190);bearunload.setLayoutY(354);
        Button tigerload = new Button("load");tigerload.setLayoutX(140);tigerload.setLayoutY(384);
        Button tigerunload = new Button("unload");tigerunload.setLayoutX(190);tigerunload.setLayoutY(384);


        anchorPane.getChildren().addAll(eggload,eggunload,featherload,featherunload,milkload,milkunload,flourload,flourunload,fabricload,fabricunload,packmilkload,packmilkunload,breadload,breadunload,clothsload,clothsunload,icecreamload,icecreamunload,lionload,lionunload,bearload,bearunload,tigerload,tigerunload);

        //Farm farm = new Farm();
        eggload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("egg", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
            egg.setText("Egg : "+String.valueOf(Storage.egg)+"            15");
            price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        eggunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("egg", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                egg.setText("Egg : "+String.valueOf(Storage.egg)+"            15");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        featherload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("feather", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                feather.setText("feather : "+String.valueOf(Storage.feather)+"          20");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        featherunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("feather", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                feather.setText("feather : "+String.valueOf(Storage.feather)+"            20");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        milkload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("milk", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                milk.setText("milk : "+String.valueOf(Storage.milk)+"            25");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        milkunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("milk", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                milk.setText("milk : "+String.valueOf(Storage.milk)+"            25");
                price.setText(String.valueOf(Car.price)); }
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        flourload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("flour", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                flour.setText("flour : "+String.valueOf(Storage.flour)+"            40");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        flourunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("flour", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                flour.setText("flour : "+String.valueOf(Storage.flour)+"            40");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        fabricload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("fabric", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                fabric.setText("fabric : "+String.valueOf(Storage.fabric)+"            50");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        fabricunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("fabric", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                fabric.setText("fabric : "+String.valueOf(Storage.fabric)+"            50");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        packmilkload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("packMilk", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                packmilk.setText("packmilk : "+String.valueOf(Storage.packMilk)+"        60");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        packmilkunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("packMilk", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                packmilk.setText("packmilk : "+String.valueOf(Storage.packMilk)+"        60");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        breadload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("bread", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                bread.setText("bread : "+String.valueOf(Storage.bread)+"            80");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        breadunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("bread", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                bread.setText("bread : "+String.valueOf(Storage.bread)+"            80");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        clothsload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("cloths", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                cloths.setText("cloths : "+String.valueOf(Storage.cloths)+"            100");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        clothsunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("cloths", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                cloths.setText("cloths : "+String.valueOf(Storage.cloths)+"            100");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        icecreamload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("icecream", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                icecream.setText("icecream : "+String.valueOf(Storage.icecream)+"        120");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        icecreamunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("icecream", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                icecream.setText("icecream : "+String.valueOf(Storage.icecream)+"        120");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        lionload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("lion", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                lion.setText("lion : "+String.valueOf(Storage.lion)+"            300");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        lionunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("lion", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                lion.setText("lion : "+String.valueOf(Storage.lion)+"            300");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        bearload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("bear", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                bear.setText("bear : "+String.valueOf(Storage.bear)+"            400");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        bearunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("bear", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                bear.setText("bear : "+String.valueOf(Storage.bear)+"            400");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});
        tigerload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.load("tiger", 1);
            if(temp == true){ logger("INFO", "TRUCK LOADED SUCCESSFULLY");
                tiger.setText("tiger : "+String.valueOf(Storage.tiger)+"            500");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK LOAD ERROR");
        }});
        tigerunload.setOnAction(e -> {if(Farm.truckTime == 0){
            boolean temp = Car.unload("tiger", 1);
            if(temp == true){ logger("INFO", "TRUCK UNLOADED SUCCESSFULLY");
                tiger.setText("tiger : "+String.valueOf(Storage.tiger)+"            500");
                price.setText(String.valueOf(Car.price));}
            else logger("ERROR", "TRUCK UNLOAD ERROR");
        }});




        borderPane.setCenter(anchorPane);


        window.setOnCloseRequest(e -> Farm.gamePause = false);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(borderPane, 700, 500);
        window.setScene(scene);
        window.showAndWait();
    }


    public static void logger(String type, String message){
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
}
