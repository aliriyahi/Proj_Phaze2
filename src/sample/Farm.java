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

import javax.swing.plaf.basic.BasicViewportUI;
import java.awt.event.KeyEvent;
//import java.beans.EventHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Farm {
    static int prize;
    Well well = new Well();
    int[][] grass=new int[6][6];
    //well.water+=50;
    Random rand = new Random();
    int turn = 0;
    int level = 0;
    int startCoin;
    String tasks;
    String wildanimals;
    int timeprize;

    int maxLevel;
    String[] wildTn ;
    String username , password;
    int previousCoin;
    File log = new File("log.txt");
    Date date = new Date();
    ArrayList<DomesticAnimal> domanimals = new ArrayList();
    ArrayList<WildAnimal> wildAnimals = new ArrayList();
    ArrayList<Dog> dogs = new ArrayList();
    ArrayList<Cat> cats = new ArrayList();
    ArrayList<Product> products = new ArrayList();
    Car car = new Car();
    Mill mill = new Mill();
    Bakery bakery = new Bakery();
    PackMilk packMilk = new PackMilk();
    IceStore iceStore = new IceStore();
    Tailoring tailoring = new Tailoring();
    ProdFabric prodFabric = new ProdFabric();
    int[][][] homeProduct=new int[6][6][12];
    int millTime=0,bakeryTime=0,iceStoreTime=0,tailoringTime=0,packmilkTime=0,prodfabricTime=0;
    int truckTime = 0;
    int[] lionRemoveTime=new int[3],bearRemoveTime=new  int[3],tigerRemoveTime=new int[3];
    boolean Return = false;
    public void run() throws Exception{

        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new AnchorPane();


        //----------------------------------------------------------------------------- main page
        Image background = new Image(new FileInputStream("src/image/main page.jpg") );
        ImageView backgroundview = new ImageView(background);
        backgroundview.setFitHeight(700);
        backgroundview.setFitWidth(1080);
        backgroundview.setX(0);
        backgroundview.setY(0);
        anchorPane.getChildren().add(backgroundview);
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
        chickenBuy.setStyle("-fx-background-color : #00ff22");
        Button turkeyBuy = new Button(" 200$ ");
        turkeyBuy.setLayoutX(125); turkeyBuy.setLayoutY(80);
        turkeyBuy.setStyle("-fx-background-color : #00ff22");
        Button buffaloBuy = new Button(" 400$ ");
        buffaloBuy.setLayoutX(215); buffaloBuy.setLayoutY(80);
        buffaloBuy.setStyle("-fx-background-color : #00ff22");
        Button dogBuy = new Button(" 100$ ");
        dogBuy.setLayoutX(308); dogBuy.setLayoutY(80);
        dogBuy.setStyle("-fx-background-color : #00ff22");
        Button catBuy = new Button(" 150$ ");
        catBuy.setLayoutX(395); catBuy.setLayoutY(80);
        catBuy.setStyle("-fx-background-color : #00ff22");
        Button well1 = new Button("Well 0/5");
        well1.setLayoutX(600);well1.setLayoutY(150);
        anchorPane.getChildren().add(well1);
        well1.setStyle("-fx-background-color : #00b2ff");
        well1.setOnAction( e -> {
                    if (well.water==0) {
                        well.water=5;
                        well1.setText("Well 5/5");

                    }
                });
        Button bakerybuy = new Button(" BUY 250$");
        bakerybuy.setLayoutX(175);bakerybuy.setLayoutY(165);
        bakerybuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(bakerybuy);
        Button bakeryupgrade = new Button("UPGRADE 200$");
        bakeryupgrade.setLayoutX(175);bakeryupgrade.setLayoutY(195);
        bakeryupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(bakeryupgrade);
        Button bakerywork = new Button("WORK");
        bakerywork.setLayoutX(175);bakerywork.setLayoutY(225);
        bakerywork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(bakerywork);
        Button millbuy = new Button(" BUY 150$");
        millbuy.setLayoutX(175);millbuy.setLayoutY(315);
        millbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(millbuy);
        Button millupgrade = new Button("UPGRADE 100$");
        millupgrade.setLayoutX(175);millupgrade.setLayoutY(345);
        millupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(millupgrade);
        Button millwork = new Button("WORK");
        millwork.setLayoutX(175);millwork.setLayoutY(375);
        millwork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(millwork);
        Button spinningbuy = new Button(" BUY 250$");
        spinningbuy.setLayoutX(175);spinningbuy.setLayoutY(465);
        spinningbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(spinningbuy);
        Button spinningupgrade = new Button("UPGRADE 200$");
        spinningupgrade.setLayoutX(175);spinningupgrade.setLayoutY(495);
        spinningupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(spinningupgrade);
        Button spinningwork = new Button("WORK");
        spinningwork.setLayoutX(175);spinningwork.setLayoutY(525);
        spinningwork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(spinningwork);
        Button tailoringbuy = new Button(" BUY 400$");
        tailoringbuy.setLayoutX(840);tailoringbuy.setLayoutY(130);
        tailoringbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(tailoringbuy);
        Button tailoringupgrade = new Button("UPGRADE 300$");
        tailoringupgrade.setLayoutX(840);tailoringupgrade.setLayoutY(160);
        tailoringupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(tailoringupgrade);
        Button tailoringwork = new Button("WORK");
        tailoringwork.setLayoutX(840);tailoringwork.setLayoutY(190);
        tailoringwork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(tailoringwork);
        Button icestorebuy = new Button(" BUY 550");
        icestorebuy.setLayoutX(840);icestorebuy.setLayoutY(280);
        icestorebuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(icestorebuy);
        Button icestoreupgrade = new Button("UPGRADE 400$");
        icestoreupgrade.setLayoutX(840);icestoreupgrade.setLayoutY(310);
        icestoreupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(icestoreupgrade);
        Button icestorework = new Button("WORK");
        icestorework.setLayoutX(840);icestorework.setLayoutY(340);
        icestorework.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(icestorework);
        Button packmilkbuy = new Button(" BUY 400$");
        packmilkbuy.setLayoutX(840);packmilkbuy.setLayoutY(430);
        packmilkbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(packmilkbuy);
        Button packmilkupgrade = new Button("UPGRADE 300$");
        packmilkupgrade.setLayoutX(840);packmilkupgrade.setLayoutY(460);
        packmilkupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(packmilkupgrade);
        Button packmilkwork = new Button("WORK");
        packmilkwork.setLayoutX(840);packmilkwork.setLayoutY(490);
        packmilkwork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(packmilkwork);
        //--------------------------------------------------------workshop button action
        bakerybuy.setOnAction( e -> {if(!bakery.exist){
        bakery.build();
        logger("INFO" , "BAKERY BUILT SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO BUY BAKERY");
        });
        bakeryupgrade.setOnAction( e ->{if (!bakery.upgradeed){
        bakery.upgrade();
        logger("INFO" , "BAKERY UPGRADED SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO UPGRADE BAKERY");
        });
        bakerywork.setOnAction( e -> {
            if (Storage.flour==0){
                logger("ERROR" , "CANT WORK BAKERY");
            }
            else {
                if(bakeryTime==0){
                    bakeryTime=turn+bakery.unitTime;
                }
            }
        });
        millbuy.setOnAction(e -> {if(!mill.exist){
            mill.build();
            logger("INFO" , "MILL BUILT SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO BUY MILL");
        });
        millupgrade.setOnAction( e ->{if (!mill.upgradeed){
            mill.upgrade();
            logger("INFO" , "MILL UPGRADED SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO UPGRADE MILL");
        });
        millwork.setOnAction( e -> {
            if (Storage.egg==0){
                logger("ERROR" , "CANT WORK MILL");
            }
            else {
                if(millTime==0){
                    millTime=turn+mill.unitTime;
                }
            }
        });
        spinningbuy.setOnAction(e -> {if(!prodFabric.exist){
            prodFabric.build();
            logger("INFO" , "PRODFABRIC BUILT SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO BUY PRODFABRIC");
        });
        spinningupgrade.setOnAction( e ->{if (!prodFabric.upgradeed){
            prodFabric.upgrade();
            logger("INFO" , "PRODFABRIC UPGRADED SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO UPGRADE PRODFABRIC");
        });
        spinningwork.setOnAction( e -> {
            if (Storage.fabric==0){
                logger("ERROR" , "CANT WORK PRODFABRIC");
            }
            else {
                if(prodfabricTime==0){
                    prodfabricTime=turn+prodFabric.unitTime;
                }
            }
        });
        tailoringbuy.setOnAction(e -> {if(!tailoring.exist){
            tailoring.build();
            logger("INFO" , "TAILORING BUILT SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO BUY TAILORING");
        });
        tailoringupgrade.setOnAction( e ->{if (!tailoring.upgradeed){
            prodFabric.upgrade();
            logger("INFO" , "PRODFABRIC UPGRADED SUCCESSFULLY");}
        else
            logger("ERROR" , "YOU DONT HAVE ENOUGH MONEY TO UPGRADE PRODFABRIC");
        });







        //-------------------------------------------------------------------- animal images
        Image chicken = new Image(new FileInputStream("src/image/chicken.gif") , 120 , 120 ,false ,true);
        Image turkey = new Image(new FileInputStream("src/image/turkey1.gif") , 120 , 120 ,false ,true);
        Image buffalo = new Image(new FileInputStream("src/image/buffalo1.gif") , 120 , 120,false ,true);
        Image cat = new Image(new FileInputStream("src/image/cat.gif") , 120 , 120 ,false ,true);
        Image dog = new Image(new FileInputStream("src/image/dog1.gif") , 120 , 120 ,false ,true);
        Image lion = new Image(new FileInputStream("src/image/lion.gif") , 120 , 120 ,false ,true);
        Image bear = new Image(new FileInputStream("src/image/bear.gif") , 120 , 120 ,false ,true);
        Image tiger = new Image(new FileInputStream("src/image/tiger.gif") , 120 , 120 ,false ,true);
        ArrayList<ImageView> cickens =new ArrayList<ImageView>();
        ArrayList<ImageView> turkeys =new ArrayList<ImageView>();
        ArrayList<ImageView> buffalos =new ArrayList<ImageView>();
        ArrayList<ImageView> catsi =new ArrayList<ImageView>();
        ArrayList<ImageView> dogsi =new ArrayList<ImageView>();
        ArrayList<ImageView> lions =new ArrayList<ImageView>();
        ArrayList<ImageView> bears =new ArrayList<ImageView>();
        ArrayList<ImageView> tigers =new ArrayList<ImageView>();
        //----------------------------------------------------------------------product images
        Image egg = new Image(new FileInputStream("src/image/egg.png") , 50 , 50 ,false ,true );
        Image feather = new Image(new FileInputStream("src/image/feather.png") , 50 , 50 ,false ,true );
        Image milk = new Image(new FileInputStream("src/image/milk.png") , 50 , 50 ,false ,true );
        Image bread = new Image(new FileInputStream("src/image/bread.png") , 50 , 50 ,false ,true );
        Image flour = new Image(new FileInputStream("src/image/flour.png") , 50 , 50 ,false ,true );
        Image fabric = new Image(new FileInputStream("src/image/fabric.png") , 50 , 50 ,false ,true );
        Image packmilk = new Image(new FileInputStream("src/image/packmilk.png") , 50 , 50 ,false ,true );
        Image cloth = new Image(new FileInputStream("src/image/cloth.png") , 50 , 50 ,false ,true );
        Image icecream = new Image(new FileInputStream("src/image/icecream.png") , 50 , 50 ,false ,true );
        ArrayList<ImageView> eggs = new ArrayList<ImageView>();
        ArrayList<ImageView> feathers = new ArrayList<ImageView>();
        ArrayList<ImageView> milks = new ArrayList<ImageView>();
        ArrayList<ImageView> breads = new ArrayList<ImageView>();
        ArrayList<ImageView> flours = new ArrayList<ImageView>();
        ArrayList<ImageView> fabrics = new ArrayList<ImageView>();
        ArrayList<ImageView> packmilks = new ArrayList<ImageView>();
        ArrayList<ImageView> cloths = new ArrayList<ImageView>();
        ArrayList<ImageView> icecreams = new ArrayList<ImageView>();
        //------------------------------------------------------------- workshop images
        Image bakeryImage = new Image(new FileInputStream("src/image/bakery.png") , 150 , 150 ,false ,true );
        Image millImage= new Image(new FileInputStream("src/image/mill.png") , 150 , 150 ,false ,true );
        Image spinningImage= new Image(new FileInputStream("src/image/spinning.png") , 150 , 150 ,false ,true );
        Image tailoringImage= new Image(new FileInputStream("src/image/tailoring.png") , 150 , 150 ,false ,true );
        Image icestoreImage= new Image(new FileInputStream("src/image/icecreamstore.png") , 150 , 150 ,false ,true );
        Image packmilkImage= new Image(new FileInputStream("src/image/packmilkstore.png") , 150 , 150 ,false ,true );
        ImageView bakeryview = new ImageView(bakeryImage);
        ImageView millview = new ImageView(millImage);
        ImageView spinningview = new ImageView(spinningImage);
        ImageView tailoringview =new ImageView(tailoringImage);
        ImageView icestoreview = new ImageView(icestoreImage);
        ImageView packmilkview = new ImageView(packmilkImage);
        bakeryview.setX(20);
        bakeryview.setY(160);
        millview.setX(20);
        millview.setY(310);
        spinningview.setX(20);
        spinningview.setY(460);
        tailoringview.setX(910);
        tailoringview.setY(110);
        icestoreview.setX(930);
        icestoreview.setY(260);
        packmilkview.setX(930);
        packmilkview.setY(410);
        anchorPane.getChildren().addAll(bakeryview , millview , spinningview , tailoringview , icestoreview , packmilkview);




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
        //--------------------------------------------------------------grass image
        Image grass1 = new Image(new FileInputStream("src/image/grass.png") , 91 , 55 , false , true);
        ImageView[][] grassview = new ImageView[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                grassview[i][j] = new ImageView(grass1);
            }
        }





        //------------------------------------------------------------------------ Handling grass
        EventHandler<MouseEvent> grassHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                if(well.water > 0) {
                    int x= (int)e.getX();
                    int y = (int)e.getY();
                    if (x<790 && x>250 && y<545 && y>220){
                        int x1=(int)((x-250)/91);
                        int y1=(int)((y-220)/55);
                        try {
                            grass[y1][x1]++;
                            //grassview[y1][x1].setImage(grass1);
                            grassview[y1][x1].setX(250+(x1)*91);
                            grassview[y1][x1].setY(220+(y1)*55);
                            anchorPane.getChildren().add(grassview[y1][x1]);
                            well.water--;
                            logger("INFO", "PLANTED SUCCESSFULLY");
                            well1.setText("Well "+well.water+"/5");
                        }catch (Exception exc){

                        }

                    }
                }
                else{
                    logger("ERROR","you dont have any water!");
                }
            }
        };

        backgroundview.addEventFilter(MouseEvent.MOUSE_CLICKED, grassHandler);
        //----------------------------------------------------- adding animals
        turkeyBuy.setOnAction( e ->{
            if(200 <= Storage.coin) {
                DomesticAnimal domesticAnimal = new DomesticAnimal();
                domesticAnimal.animalName = "turkey";
                domesticAnimal.animalPrice = 200;
                domesticAnimal.product = "feather";
                domesticAnimal.timeToProduce = 3;
                domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(turkey);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                turkeys.add(imageView);
                Storage.coin -= 200;
                logger("INFO" , "TURKEY BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY TURKEY");
            }  );
        chickenBuy.setOnAction( e ->{
            if(100 <= Storage.coin) {
                DomesticAnimal domesticAnimal = new DomesticAnimal();
                domesticAnimal.animalName = "chicken";
                domesticAnimal.animalPrice = 100;
                domesticAnimal.product = "egg";
                domesticAnimal.timeToProduce = 2;
                domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(chicken);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                cickens.add(imageView);
                Storage.coin -= 100;
                logger("INFO" , "CHICKEN BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY CHICKEN");
        }  );
        buffaloBuy.setOnAction( e ->{
            if(400 <= Storage.coin) {
                DomesticAnimal domesticAnimal = new DomesticAnimal();
                domesticAnimal.animalName = "buffalo";
                domesticAnimal.animalPrice = 400;
                domesticAnimal.product = "milk";
                domesticAnimal.timeToProduce = 5;
                domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(buffalo);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                buffalos.add(imageView);
                Storage.coin -= 400;
                logger("INFO" , "BUFFALO BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY BUFFALO");
        }  );
        dogBuy.setOnAction( e ->{
            Dog dog1 = new Dog();
            if(dog1.price <= Storage.coin){
                dogs.add(dog1);
                Storage.coin -= dog1.price;
                logger("INFO" , "DOG BOUGHT SUCCESSFULLY");
                ImageView imageView = new ImageView(dog);
                imageView.setX(dog1.xposision);
                imageView.setY(dog1.yposision);
                dogsi.add(imageView);
                anchorPane.getChildren().add(imageView);
            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY DOG");
        }  );
        catBuy.setOnAction( e ->{
            Cat cat1 = new Cat();
                if(cat1.price <= Storage.coin){
                    cats.add(cat1);
                    Storage.coin -= cat1.price;
                    logger("INFO" , "CAT BOUGHT SUCCESSFULLY");
                    ImageView imageView = new ImageView(cat);
                    imageView.setX(cat1.xposision);
                    imageView.setY(cat1.yposision);
                    catsi.add(imageView);
                    anchorPane.getChildren().add(imageView);
                }else
                    logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY CAT");
        }  );
        //---------------------------------------------------------------------animal move


        //---------------------------------------------------------------------------
        //        HBox.setMargin(bearView, new Insets(0, 0, 0, 0));


        anchorPane.getChildren().addAll( chickenIconview, turkeyIconview, buffaloIconview, dogIconview, catIconview , chickenBuy, turkeyBuy , buffaloBuy , dogBuy , catBuy , menu );

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