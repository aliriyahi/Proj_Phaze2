package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class Levelgoals {

    public Levelgoals(){

    }


    @FXML
    private Label level;
    @FXML
    private Label time ;
    @FXML
    private Label prize;
    @FXML
    private Label task1;
    @FXML
    private Label task2;
    @FXML
    private Label task3;
    @FXML
    private Label task4;
    @FXML
    private Label task5;
    @FXML
    private Label task6;
    @FXML
    private Button Ok;



    int currentLevel1, maxLevel, startCoin, timeprize, prize1;
    String tasks, wildanimals;
    String [] subtask;




    public void goals(int currentLevel) throws IOException {
        currentLevel1 = currentLevel;
        filereader();

        for (int i = 0; i < maxLevel; i++) {
            if (currentLevel == i){

                try {
                    this.level.setText("Level = " + i);
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

//        if(currentLevel == 1){
//            this.level.setText("Level = 1");
//            time.setText("Prize time : 50");
//            prize.setText("150 coins");
//            task1.setText("2   Egg");
//
//        }
//        else if(currentLevel == 2){
//            this.level.setText("Level = 2");
//            time.setText("Prize time : 100");
//            prize.setText("200 coins");
//
//        }
//        else if(currentLevel == 3){
//            this.level.setText("Level = 3");
//            time.setText("Prize time : 150");
//            prize.setText("250 coins");
//
//        }
//        else if(currentLevel == 4){
//            this.level.setText("Level = 4");
//            time.setText("Prize time : 200");
//            prize.setText("300 coins");
//
//        }
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
                    this.startCoin=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    Storage.coin = startCoin + previousCoin;
                    this.tasks=s.nextLine().substring(6);
                    this.subtask = tasks.split("\\s");
                    this.wildanimals=s.nextLine().substring(8);
                    //this.wildTn = wildanimals.split("\\s");
                    this.timeprize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.prize1=Integer.parseInt(s.nextLine().split("\\s")[1]);
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

    public void UserOk(ActionEvent actionEvent) throws Exception {

        Farm farm = new Farm();
        farm.run();




    }
}
