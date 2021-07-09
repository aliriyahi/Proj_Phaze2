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

public class Login {

    public Login(){

    }

    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Label wronglogin1;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(javafx.event.ActionEvent event) throws IOException{
        checkLogin();

    }
    public void userSignup(ActionEvent actionEvent) throws IOException{
        checkSignup();
    }






    Date date = new Date();
    File log = new File("log.txt");
    int level = 1, previousCoin = 0;

    //----------------------------------------------------------------------------------------------------------
    private void checkLogin() throws IOException {
        Main m = new Main();

        Scanner fileReader;
        int  prizeCheck = 0, startLevel;
        File users = new File("users.txt");
        try {
            PrintWriter printWriter1 = new PrintWriter(new FileWriter(users, true));
            PrintWriter logger = new PrintWriter(new FileWriter(log, true));
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            boolean temp = true;


                fileReader = new Scanner(users);
                while (fileReader.hasNextLine()) {
                    if (fileReader.nextLine().split("\\s")[0].equals(username.getText())) {
                        temp = false;
                        break;
                    }
                }
                if(temp) {
                    wronglogin1.setText("Wrong username or password!");
                    logger("ERROR", "WRONG USERNAME");
                }
                fileReader.close();


            temp = true;

                fileReader = new Scanner(users);

                while (fileReader.hasNextLine()) {
                    if (fileReader.nextLine().split("\\s")[1].equals(password.getText())) {
                        temp = false;
                        //----------------------------------------------------------------------------
                        PrintWriter logger = new PrintWriter(new FileWriter(log, true));
                        logger.append("Header");
                        logger.println();
                        logger.append("2. " + username.getText());
                        logger.println();
                        logger.println("3. last modified " + date.toLocaleString());
                        logger.close();

                        m.changeScene("menu.fxml");
                        break;
                    }
                }
                if(temp) {
                    wronglogin1.setText("Wrong username or password!");
                    logger("ERROR", "WRONG PASSWORD");
                }
                fileReader.close();


            temp = true;

                fileReader = new Scanner(users);

                while (fileReader.hasNextLine()) {           //     ----------      ----  hasnext az aval miad?
                    String temp1 = fileReader.nextLine();
                    if (temp1.contains(username.getText())) {
                        level = Integer.parseInt(temp1.split("\\s")[2]);
                        previousCoin = Integer.parseInt(temp1.split("\\s")[3]);
                        temp = false;
                        break;
                    }
                }
                fileReader.close();


            //-------------------------------------------------
        } catch (Exception e) {
            System.out.println(e);
        }


        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            wronglogin1.setText("Please enter your data.");
            logger("ERROR", "EMPTY FIELD!");
        }

    }

    //-----------------------------------------------------------------------------------------------------
    private void checkSignup() throws IOException {
        Main m = new Main();


        Scanner fileReader;
        int level = 1, prizeCheck = 0, startLevel, previousCoin = 0;
        File users = new File("users.txt");
        try {
            PrintWriter printWriter1 = new PrintWriter(new FileWriter(users, true));
            PrintWriter logger = new PrintWriter(new FileWriter(log, true));
        } catch (Exception e) {
            System.out.println(e);
        }


        try {
            boolean temp = true;


            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                wronglogin1.setText("Please enter your data.");
                logger("ERROR", "EMPTY FIELD!");
                temp = false;
            }

                fileReader = new Scanner(users);

                while (fileReader.hasNextLine()) {
                    if (fileReader.nextLine().split("\\s")[0].equals(username.getText())) {
                        wronglogin1.setText("This USERNAME is already taken");
                        logger("ERROR","This USERNAME is already taken");
                        temp = false;
                        break;
                    }
                }
                fileReader.close();



            if(temp) {
                PrintWriter printWriter = new PrintWriter(new FileWriter(users, true));
                printWriter.append(username.getText() + " " + password.getText() + " " + "1 0");
                printWriter.println();
                printWriter.close();
                try {
                    PrintWriter logger = new PrintWriter(new FileWriter(log, true));
                    logger.append("Header");
                    logger.println();
                    logger.append("1. " + date.toLocaleString());
                    logger.println();
                    logger.append("2. " + username.getText());
                    logger.println();
                    logger.println("3. " + date.toLocaleString());
                    logger.close();

                    m.changeScene("menu.fxml");

                } catch (Exception e) {
                    System.out.println(e);
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }





    public void logger(String type, String message ){
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
