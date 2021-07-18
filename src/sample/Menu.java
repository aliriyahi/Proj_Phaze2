package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
public class Menu {

    public Menu(){

    }

    @FXML
    private Image image;
    @FXML
    private Button logout;
    @FXML
    private Button start;
    @FXML
    private TextField level;
    @FXML
    private Label wrongInput;

    public int getLevel(){
       return Integer.parseInt(this.level.getText());
    }


    public void userStart(ActionEvent actionEvent) throws IOException{
        //Main m = new Main();
        Login login = new Login();

        try {
            if (level.getText().isEmpty()) {
                wrongInput.setText("Pleas enter your data.");
                logger("ERROR", "EMPTY FIELD");
            }
            else if (Integer.parseInt(level.getText()) <= login.level) {


                Levelgoals l = new Levelgoals();
                l.goals(Integer.parseInt(level.getText()));


                logger("INFO", "USER ENTER THE GAME ...");

            }
            else {
                wrongInput.setText("You have not reached this level!");
            }
        }catch (Exception e){
            System.out.println(e);
            wrongInput.setText("Invalid input!");
            logger("ERROR", "Invalid input!");
        }
    }

    public void userLogout(ActionEvent actionEvent) throws IOException{
        Main m = new Main();
        logger("INFO", "USER LOG OUT");
        m.changeScene("sample.fxml", 600, 400);
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
