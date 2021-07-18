package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
//import org.w3c.dom.Text;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Levelgoals {



    public Levelgoals(){

    }




    int currentLevel1, maxLevel, startCoin, timeprize, prize1;
    String tasks, wildanimals;
    String [] subtask;
    public String[] wildTn;



    public void goals(int currentLevel) throws IOException {
        currentLevel1 = currentLevel;
        filereader();

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();
        Image image = new Image(new FileInputStream("src/image/level goals.jpg") , 1080 , 700 ,false ,true );
        ImageView imageView = new ImageView(image);
        imageView.setX(0);imageView.setY(0);
        imageView.setPreserveRatio(false);
        anchorPane.getChildren().add(imageView);

        Button ok = new Button("OK");
        ok.setLayoutX(490);ok.setLayoutY(560);
        ok.setMinWidth(80);ok.setMinHeight(50);
        ok.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(ok);
        ok.setOnAction(e -> {
            Farm farm = null;
            try {
                farm = new Farm();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            farm.run();

            farm.play();
        });

        Text task1 = new Text();
        task1.setX(290);task1.setY(330);
        task1.setFont(new Font(22));
        Text task2 = new Text();
        task2.setX(290);task2.setY(390);
        task2.setFont(new Font(22));
        Text task3 = new Text();
        task3.setX(290);task3.setY(450);
        task3.setFont(new Font(22));
        Text task4 = new Text();
        task4.setX(290);task4.setY(420);
        task4.setFont(new Font(22));
        Text task5 = new Text();
        task5.setX(560);task5.setY(330);
        task5.setFont(new Font(22));
        Text task6 = new Text();
        task6.setX(560);task6.setY(400);
        task6.setFont(new Font(22));
        Text level = new Text();
        level.setX(480);level.setY(170);
        level.setFont(new Font(25));
        Text time = new Text();
        time.setX(380);time.setY(230);
        time.setFont(new Font(25));
        Text prize = new Text();
        prize.setX(570);prize.setY(230);
        prize.setFont(new Font(25));

        anchorPane.getChildren().addAll(task1, task2, task3, task4, task5, task6, level, time, prize);


        for (int i = 0; i < maxLevel; i++) {
            if (currentLevel == i){

                try {
                    level.setText("Level = " + i);
                    time.setText("Prize time : " + timeprize);
                    prize.setText(prize1 + " coins");
                    task1.setText(subtask[0] + "    " + subtask[1]);
                    task2.setText(subtask[2] + "    " + subtask[3]);
                    task3.setText(subtask[4] + "    " + subtask[5]);
                    task4.setText(subtask[6] + "    " + subtask[7]);
                    task5.setText(subtask[8] + "    " + subtask[9]);
                    task6.setText(subtask[10] + "    " + subtask[11]);
                }catch (Exception e){

                }
            }
        }

        borderPane.setCenter(anchorPane);

        Scene levelgoals = new Scene(borderPane, 1080, 700);
        Main main = new Main();
        try {
            main.changeScene(levelgoals);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void filereader(){
        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if(temp.contains("levelsnumber")){
                    maxLevel = Integer.parseInt(s.nextLine());
                }
                if (temp.contains("level "+this.currentLevel1)){

                    Farm.level = currentLevel1;
                    this.startCoin=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    Storage.coin = startCoin + Login.previousCoin;
                    Farm.tasks=s.nextLine().substring(6);
                    this.subtask = Farm.tasks.split("\\s");
                    this.wildanimals=s.nextLine().substring(8);
                    Farm.wildTn = wildanimals.split("\\s");
                    Farm.timeprize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.timeprize = Farm.timeprize;
                    Farm.prize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.prize1 = Farm.prize;
                    break;
                }

            }
            s.close();


        }catch (Exception e){
            System.out.println(e);
            logger("ERROR", "OPEN FILE(missions) ERROR");
        }

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


}
