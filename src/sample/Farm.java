package sample;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import javafx.animation.Transition;
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
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.plaf.basic.BasicViewportUI;
import java.awt.event.KeyEvent;
//import java.beans.EventHandler;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Farm extends Transition {





    static int prize;
    Well well = new Well();
    int[][] grass=new int[6][6];
    //well.water+=50;
    Random rand = new Random();
    //----------------------
    double turn = 0;
    static int level = 0;
    int startCoin;
    static String tasks;
    String wildanimals;
    static int timeprize;

    int maxLevel;
    static String[] wildTn ;
    static String username , password;
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
    //int[][][] homeProduct=new int[6][6][12];
    int millTime=0,bakeryTime=0,iceStoreTime=0,tailoringTime=0,packmilkTime=0,prodfabricTime=0;
    static int truckTime = 0;
    int[] lionRemoveTime=new int[3],bearRemoveTime=new  int[3],tigerRemoveTime=new int[3];
    boolean Return = false;

    //-----------------------------handling ID
    int domAnimalID = 0;
    int dogID = 0;
    int catID = 0;
    int wildAnimalID = 0;
    int productID = 0;

    int prodChickenTime = 0;


    int timeHandler=0;

    static boolean gamePause = false;


    int temp = 0;

    Text time = new Text();
    Text[] tasksShow = new Text[13];
    BorderPane borderPane = new BorderPane();
    AnchorPane anchorPane = new AnchorPane();

    Text currentCoin = new Text(String.valueOf(Storage.coin));
    //----------------------------------------------------------------------------- main page
    Image background = new Image(new FileInputStream("src/image/main page.jpg") );
    ImageView backgroundview = new ImageView(background);
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
    //-------------------------------------------------------------------- animal images
    Image chicken = new Image(new FileInputStream("src/image/chicken.gif") , 120 , 120 ,false ,true);
    Image turkey = new Image(new FileInputStream("src/image/turkey1.gif") , 100 , 100 ,false ,true);
    Image buffalo = new Image(new FileInputStream("src/image/buffalo1.gif") , 120 , 120,false ,true);
    Image cat = new Image(new FileInputStream("src/image/cat.gif") , 100 , 100 ,false ,true);
    Image dog = new Image(new FileInputStream("src/image/dog1.gif") , 120 , 120 ,false ,true);
    Image lion = new Image(new FileInputStream("src/image/lion.gif") , 120 , 120 ,false ,true);
    Image bear = new Image(new FileInputStream("src/image/bear.gif") , 120 , 120 ,false ,true);
    Image tiger = new Image(new FileInputStream("src/image/tiger.gif") , 120 , 120 ,false ,true);
    ArrayList<ImageView> chickens =new ArrayList<ImageView>();
    ArrayList<ImageView> turkeys =new ArrayList<ImageView>();
    ArrayList<ImageView> buffalos =new ArrayList<ImageView>();
    ArrayList<ImageView> catsi =new ArrayList<ImageView>();
    ArrayList<ImageView> dogsi =new ArrayList<ImageView>();
    ArrayList<ImageView> lions =new ArrayList<ImageView>();
    ArrayList<ImageView> bears =new ArrayList<ImageView>();
    ArrayList<ImageView> tigers =new ArrayList<ImageView>();
    //----------------------------------------------------------------------product images
    Image egg = new Image(new FileInputStream("src/image/egg.png") , 15 , 20 ,false ,true );
    Image feather = new Image(new FileInputStream("src/image/feather.png") , 40 , 40 ,false ,true );
    Image milk = new Image(new FileInputStream("src/image/milk.png") , 25 , 40 ,false ,true );
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
    //-------------------------------------------------------------------- Icon Image loading
    Image chickenIcon = new Image(new FileInputStream("src/image/chicken-.png"),110,90,false,true);
    ImageView chickenIconview = new ImageView(chickenIcon);
    Image turkeyIcon = new Image(new FileInputStream("src/image/turkey-.png"),110,90,false,true);
    ImageView turkeyIconview = new ImageView(turkeyIcon);
    Image buffaloIcon = new Image(new FileInputStream("src/image/buffalo-.png"),110,90,false,true);
    ImageView buffaloIconview = new ImageView(buffaloIcon);
    Image dogIcon = new Image(new FileInputStream("src/image/dog-.png"),110,90,false,true);
    ImageView dogIconview = new ImageView(dogIcon);
    Image catIcon = new Image(new FileInputStream("src/image/cat-.png"),110,90,false,true);
    ImageView catIconview = new ImageView(catIcon);
    //--------------------------------------------------------------grass image
    Image grass1 = new Image(new FileInputStream("src/image/grass.png") , 91 , 55 , false , true);
    ImageView[][] grassview = new ImageView[6][6];
    //--------------------------------------------------------------truck image
    Image truck = new Image(new FileInputStream("src/image/truck.gif") , 170 , 130 , false , true);
    ImageView truckview = new ImageView(truck);
    //-------------------------------------------------------------- cage image
    Image cage = new Image(new FileInputStream("src/image/cage.png") , 120 , 130 , false , true);
    ArrayList<ImageView> cages = new ArrayList<ImageView>();
    //------------------------------------------------------------- egg incubator
    Image eggIncubator = new Image(new FileInputStream("src/image/eggincubator.png") , 120 , 130 , false , true);
    ImageView eggIncubatorview = new ImageView(eggIncubator);



    public Farm() throws Exception {
        this.setCycleDuration(Duration.minutes(1000));
        this.setCycleCount(-1);
    }



    @Override
    protected void interpolate(double v) {

        if(gamePause == false) {
            turn += 0.01;


            //System.out.println(turn);
            timeHandler++;

            if (timeHandler % 10 == 1) {

                time.setText((int) turn + " sec");

                //--------------------------------------------------------- handling movement
                for (int j = 0; j < wildAnimals.size(); j++) {
                    if (wildAnimals.get(j).cages < wildAnimals.get(j).maxCage) {
                        wildAnimals.get(j).animalmove();
                        for (int i = 0; i < lions.size(); i++) {
                            if (wildAnimals.get(j).ID == Integer.parseInt(lions.get(i).getId())) {
                                lions.get(i).setX(wildAnimals.get(j).xposision);
                                lions.get(i).setY(wildAnimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < bears.size(); i++) {
                            if (wildAnimals.get(j).ID == Integer.parseInt(bears.get(i).getId())) {
                                bears.get(i).setX(wildAnimals.get(j).xposision);
                                bears.get(i).setY(wildAnimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < tigers.size(); i++) {
                            if (wildAnimals.get(j).ID == Integer.parseInt(tigers.get(i).getId())) {
                                tigers.get(i).setX(wildAnimals.get(j).xposision);
                                tigers.get(i).setY(wildAnimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < cages.size(); i++) {
                            if (wildAnimals.get(j).ID == Integer.parseInt(cages.get(i).getId())) {
                                cages.get(i).setX(wildAnimals.get(j).xposision);
                                cages.get(i).setY(wildAnimals.get(j).yposision-10);
                            }
                        }
                    }
                }
                for (int j = 0; j < cats.size(); j++) {
                    cats.get(j).animalmove(products);
                    for (int i = 0; i < catsi.size(); i++) {
                        if (cats.get(j).ID == Integer.parseInt(catsi.get(i).getId())) {
                            catsi.get(i).setX(cats.get(j).xposision);
                            catsi.get(i).setY(cats.get(j).yposision);
                        }
                    }
                }
                for (int j = 0; j < dogs.size(); j++) {
                    dogs.get(j).animalmove();
                    for (int i = 0; i < dogsi.size(); i++) {
                        if (dogs.get(j).ID == Integer.parseInt(dogsi.get(i).getId())) {
                            dogsi.get(i).setX(dogs.get(j).xposision);
                            dogsi.get(i).setY(dogs.get(j).yposision);
                        }
                    }
                }

                //-------------------------------------------------------- handling products

                for (int j = 0; j < domanimals.size(); j++) {
                    if (turn >= domanimals.get(j).turnTime) {
                        if (domanimals.get(j).animalName.equals("chicken")) {
                            domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                            Product product = new Product();
                            product.name = 0;
                            product.xposission = domanimals.get(j).xposision + 30;
                            product.yposission = domanimals.get(j).yposision + 70;
                            product.existtime = 8;
                            product.removetime = (int) turn + 8;
                            product.ID = productID;
                            products.add(product);
                            ImageView imageView = new ImageView(egg);
                            imageView.setX(domanimals.get(j).xposision + 30);
                            imageView.setY(domanimals.get(j).yposision + 70);
                            imageView.setId(String.valueOf(productID));
                            eggs.add(imageView);
                            anchorPane.getChildren().add(imageView);
                            productID++;


                            EventHandler<MouseEvent> eggHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    if (Storage.add("egg", 1)) {
                                        products.remove(product);
                                        anchorPane.getChildren().removeAll(imageView);
                                        eggs.remove(imageView);
                                        anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, eggHandler);


                        } else if (domanimals.get(j).animalName.equals("turkey")) {
                            domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                            Product product = new Product();
                            product.name = 1;
                            product.xposission = domanimals.get(j).xposision + 30;
                            product.yposission = domanimals.get(j).yposision + 70;
                            product.existtime = 8;
                            product.removetime = (int) turn + 8;
                            product.ID = productID;
                            products.add(product);
                            ImageView imageView = new ImageView(feather);
                            imageView.setX(domanimals.get(j).xposision + 30);
                            imageView.setY(domanimals.get(j).yposision + 70);
                            imageView.setId(String.valueOf(productID));
                            feathers.add(imageView);
                            anchorPane.getChildren().add(imageView);
                            productID++;


                            EventHandler<MouseEvent> featherHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    if (Storage.add("feather", 1)) {
                                        products.remove(product);
                                        anchorPane.getChildren().removeAll(imageView);
                                        feathers.remove(imageView);
                                        anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, featherHandler);


                        } else if (domanimals.get(j).animalName.equals("buffalo")) {
                            domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                            Product product = new Product();
                            product.name = 2;
                            product.xposission = domanimals.get(j).xposision + 30;
                            product.yposission = domanimals.get(j).yposision + 70;
                            product.existtime = 8;
                            product.removetime = (int) turn + 8;
                            product.ID = productID;
                            products.add(product);
                            ImageView imageView = new ImageView(milk);
                            imageView.setX(domanimals.get(j).xposision + 30);
                            imageView.setY(domanimals.get(j).yposision + 70);
                            imageView.setId(String.valueOf(productID));
                            milks.add(imageView);
                            anchorPane.getChildren().add(imageView);
                            productID++;

                            EventHandler<MouseEvent> milkHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    if (Storage.add("milk", 1)) {
                                        products.remove(product);
                                        anchorPane.getChildren().removeAll(imageView);
                                        milks.remove(imageView);
                                        anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, milkHandler);

                        }
                    }
                }

                //------------------------------------------------------- prod remove time
                for (int j = 0; j < products.size(); j++) {
                    if (products.get(j).removetime < turn) {
                        for (int i = 0; i < eggs.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(eggs.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(eggs.get(i));
                                eggs.remove(i);
                            }
                        }
                        for (int i = 0; i < feathers.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(feathers.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(feathers.get(i));
                                feathers.remove(i);
                            }
                        }
                        for (int i = 0; i < milks.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(milks.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(milks.get(i));
                                milks.remove(i);
                            }
                        }
                        for (int i = 0; i < flours.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(flours.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(flours.get(i));
                                flours.remove(i);
                            }
                        }
                        for (int i = 0; i < fabrics.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(fabrics.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(fabrics.get(i));
                                fabrics.remove(i);
                            }
                        }
                        for (int i = 0; i < packmilks.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(packmilks.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(packmilks.get(i));
                                packmilks.remove(i);
                            }
                        }
                        for (int i = 0; i < breads.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(breads.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(breads.get(i));
                                breads.remove(i);
                            }
                        }
                        for (int i = 0; i < cloths.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(cloths.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(cloths.get(i));
                                cloths.remove(i);
                            }
                        }
                        for (int i = 0; i < icecreams.size(); i++) {
                            if (products.get(j).ID == Integer.parseInt(icecreams.get(i).getId())) {
                                products.remove(j);
                                anchorPane.getChildren().removeAll(icecreams.get(i));
                                icecreams.remove(i);
                            }
                        }
                    }
                }


                //----------------------------------------------------------------------------  handling product pickup


                //----------------------------------------------------------- handling wildAnimals
                for (int j = 0; j < wildTn.length - 1; j++) {
                    if (wildTn[j].toLowerCase().equals("lion")) {
                        if (turn >= Integer.parseInt(wildTn[j + 1])) {
                            WildAnimal wildAnimal = new WildAnimal();
                            wildAnimal.animalname = "lion";
                            wildAnimal.maxCage = 2;
                            wildAnimal.ID = wildAnimalID;
                            wildAnimals.add(wildAnimal);
                            wildTn[j] = "a";

                            ImageView imageView = new ImageView(lion);
                            imageView.setX(wildAnimal.xposision);
                            imageView.setY(wildAnimal.yposision);
                            imageView.setId(String.valueOf(wildAnimalID));
                            lions.add(imageView);
                            anchorPane.getChildren().add(imageView);

                            ImageView imageView1 = new ImageView(cage);
                            imageView1.setX(wildAnimal.xposision);
                            imageView1.setY(wildAnimal.yposision-10);
                            imageView1.setId(String.valueOf(wildAnimalID));
                            wildAnimalID++;

                            final boolean[] b = {true};

                            EventHandler<MouseEvent> lionHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    wildAnimal.cages++;

                                    cages.add(imageView1);
                                    if(b[0]) {
                                        anchorPane.getChildren().add(imageView1);
                                        b[0] = false;
                                    }

                                    if (wildAnimal.cages >= wildAnimal.maxCage) {
                                        wildAnimal.removeTime = (int) turn + 10;
                                        if (Storage.add("lion", 1)) {
                                            anchorPane.getChildren().removeAll(imageView);
                                            lions.remove(imageView);
                                            wildAnimals.remove(wildAnimal);
                                            anchorPane.getChildren().removeAll(imageView1);
                                            cages.remove(imageView1);
                                        }
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, lionHandler);
                            imageView1.addEventFilter(MouseEvent.MOUSE_CLICKED, lionHandler);


                        }
                    } else if (wildTn[j].toLowerCase().equals("bear")) {
                        if (turn >= Integer.parseInt(wildTn[j + 1])) {
                            WildAnimal wildAnimal = new WildAnimal();
                            wildAnimal.animalname = "bear";
                            wildAnimal.maxCage = 3;
                            wildAnimal.ID = wildAnimalID;
                            wildAnimals.add(wildAnimal);
                            wildTn[j] = "a";

                            ImageView imageView = new ImageView(bear);
                            imageView.setX(wildAnimal.xposision);
                            imageView.setY(wildAnimal.yposision);
                            imageView.setId(String.valueOf(wildAnimalID));
                            bears.add(imageView);
                            anchorPane.getChildren().add(imageView);

                            ImageView imageView2 = new ImageView(cage);
                            imageView2.setX(wildAnimal.xposision);
                            imageView2.setY(wildAnimal.yposision-10);
                            imageView2.setId(String.valueOf(wildAnimalID));
                            wildAnimalID++;

                            final boolean[] b = {true};



                            EventHandler<MouseEvent> bearHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    wildAnimal.cages++;

                                    cages.add(imageView2);
                                    if(b[0]) {
                                        anchorPane.getChildren().add(imageView2);
                                        b[0] = false;
                                    }

                                    if (wildAnimal.cages >= wildAnimal.maxCage) {
                                        wildAnimal.removeTime = (int) turn + 10;
                                        if (Storage.add("bear", 1)) {
                                            anchorPane.getChildren().removeAll(imageView);
                                            bears.remove(imageView);
                                            wildAnimals.remove(wildAnimal);
                                            anchorPane.getChildren().removeAll(imageView2);
                                            cages.remove(imageView2);
                                        }
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, bearHandler);
                            imageView2.addEventFilter(MouseEvent.MOUSE_CLICKED, bearHandler);


                        }
                    } else if (wildTn[j].toLowerCase().equals("tiger")) {
                        if (turn >= Integer.parseInt(wildTn[j + 1])) {
                            WildAnimal wildAnimal = new WildAnimal();
                            wildAnimal.animalname = "tiger";
                            wildAnimal.maxCage = 3;
                            wildAnimal.ID = wildAnimalID;
                            wildAnimals.add(wildAnimal);
                            wildTn[j] = "a";

                            ImageView imageView = new ImageView(tiger);
                            imageView.setX(wildAnimal.xposision);
                            imageView.setY(wildAnimal.yposision);
                            imageView.setId(String.valueOf(wildAnimalID));
                            tigers.add(imageView);
                            anchorPane.getChildren().add(imageView);

                            ImageView imageView3 = new ImageView(cage);
                            imageView3.setX(wildAnimal.xposision);
                            imageView3.setY(wildAnimal.yposision-10);
                            imageView3.setId(String.valueOf(wildAnimalID));
                            wildAnimalID++;

                            final boolean[] b = {true};


                            EventHandler<MouseEvent> tigerHandler = new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent e) {
                                    wildAnimal.cages++;

                                    cages.add(imageView3);
                                    if(b[0]) {
                                        anchorPane.getChildren().add(imageView3);
                                        b[0] = false;
                                    }

                                    if (wildAnimal.cages >= wildAnimal.maxCage) {
                                        wildAnimal.removeTime = (int) turn + 10;
                                        if (Storage.add("tiger", 1)) {
                                            anchorPane.getChildren().removeAll(imageView);
                                            tigers.remove(imageView);
                                            wildAnimals.remove(wildAnimal);
                                            anchorPane.getChildren().removeAll(imageView3);
                                            cages.remove(imageView3);
                                        }
                                    }
                                }
                            };
                            imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, tigerHandler);
                            imageView3.addEventFilter(MouseEvent.MOUSE_CLICKED, tigerHandler);


                        }
                    }
                }

                //--------------------------------------------------------------------------handling second products
                if (turn >= millTime && millTime != 0) {
                    mill.run();
                    Product product = new Product();
                    product.name = 6;
                    product.xposission = 175;
                    product.yposission = 400;
                    product.existtime = 15;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(flour);
                    imageView.setX(175);
                    imageView.setY(400);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    flours.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    millTime = 0;

                    EventHandler<MouseEvent> flourHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("flour", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                flours.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, flourHandler);


                }
                if (turn >= prodfabricTime && prodfabricTime != 0) {
                    prodFabric.run();
                    Product product = new Product();
                    product.name = 7;
                    product.xposission = 175;
                    product.yposission = 550;
                    product.existtime = 15;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(fabric);
                    imageView.setX(175);
                    imageView.setY(550);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    fabrics.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    prodfabricTime = 0;

                    EventHandler<MouseEvent> fabricHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("fabric", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                fabrics.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, fabricHandler);


                }
                if (turn >= packmilkTime && packmilkTime != 0) {
                    packMilk.run();
                    Product product = new Product();
                    product.name = 8;
                    product.xposission = 840;
                    product.yposission = 520;
                    product.existtime = 15;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(packmilk);
                    imageView.setX(840);
                    imageView.setY(520);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    packmilks.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    packmilkTime = 0;

                    EventHandler<MouseEvent> packmilkHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("packMilk", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                packmilks.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, packmilkHandler);


                }
                if (turn >= bakeryTime && bakeryTime != 0) {
                    bakery.run();
                    Product product = new Product();
                    product.name = 9;
                    product.xposission = 175;
                    product.yposission = 250;
                    product.existtime = 16;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(bread);
                    imageView.setX(175);
                    imageView.setY(250);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    breads.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    bakeryTime = 0;

                    EventHandler<MouseEvent> breadHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("bread", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                breads.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, breadHandler);


                }
                if (turn >= tailoringTime && tailoringTime != 0) {
                    tailoring.run();
                    Product product = new Product();
                    product.name = 10;
                    product.xposission = 840;
                    product.yposission = 220;
                    product.existtime = 16;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(cloth);
                    imageView.setX(840);
                    imageView.setY(220);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    cloths.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    tailoringTime = 0;

                    EventHandler<MouseEvent> clithHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("cloths", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                cloths.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, clithHandler);

                }
                if (turn >= iceStoreTime && iceStoreTime != 0) {
                    iceStore.run();
                    Product product = new Product();
                    product.name = 11;
                    product.xposission = 840;
                    product.yposission = 370;
                    product.existtime = 16;
                    product.removetime = (int) turn + product.existtime;
                    product.ID = productID;
                    products.add(product);
                    ImageView imageView = new ImageView(icecream);
                    imageView.setX(840);
                    imageView.setY(370);
                    imageView.setId(String.valueOf(productID));
                    productID++;
                    icecreams.add(imageView);
                    anchorPane.getChildren().add(imageView);

                    iceStoreTime = 0;

                    EventHandler<MouseEvent> icecreamHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            if (Storage.add("icecream", 1)) {
                                products.remove(product);
                                anchorPane.getChildren().removeAll(imageView);
                                icecreams.remove(imageView);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    };
                    imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, icecreamHandler);

                }


                //------------------------------------------------------------- grass check
                int grasscheck = 0;
                for (int j = 0; j < 6; j++) {
                    for (int k = 0; k < 6; k++) {
                        if (grass[j][k] != 0)
                            grasscheck = 1;
                    }
                }
                if (grasscheck == 0) {
                    logger("ALARM", "THERE IS NO GRASS");
                }


                //---------------------------------------------------------------wildAnimal remove time
                for (int i = 0; i < wildAnimals.size(); i++) {
                    if (wildAnimals.get(i).removeTime <= turn && wildAnimals.get(i).removeTime != 0) {
                        for (int j = 0; j < lions.size(); j++) {
                            if (wildAnimals.get(i).ID == Integer.parseInt(lions.get(j).getId())) {
                                anchorPane.getChildren().removeAll(lions.get(j));
                                lions.remove(j);
                                wildAnimals.remove(i);
                            }
                        }
                        for (int j = 0; j < bears.size(); j++) {
                            if (wildAnimals.get(i).ID == Integer.parseInt(bears.get(j).getId())) {
                                anchorPane.getChildren().removeAll(bears.get(j));
                                bears.remove(j);
                                wildAnimals.remove(i);
                            }
                        }
                        for (int j = 0; j < tigers.size(); j++) {
                            if (wildAnimals.get(i).ID == Integer.parseInt(tigers.get(j).getId())) {
                                anchorPane.getChildren().removeAll(tigers.get(j));
                                tigers.remove(j);
                                wildAnimals.remove(i);
                            }
                        }
                    }
                }


                //-----------------------------------------------handling truck
                if (turn >= truckTime && truckTime != 0) {
                    car.sell();
                    truckTime = 0;


                    currentCoin.setText(String.valueOf(Storage.coin));
                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                }

                //---------------------------------------------------- health reduce
                for (int j = 0; j < domanimals.size(); j++) {
                    domanimals.get(j).animalHealth -= 1;
                    if (domanimals.get(j).animalHealth <= 0) {
                        for (int i = 0; i < chickens.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(chickens.get(i).getId())) {
                                anchorPane.getChildren().removeAll(chickens.get(i));
                                chickens.remove(i);
                                domanimals.remove(j);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                        for (int i = 0; i < turkeys.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(turkeys.get(i).getId())) {
                                anchorPane.getChildren().removeAll(turkeys.get(i));
                                turkeys.remove(i);
                                domanimals.remove(j);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                        for (int i = 0; i < buffalos.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(buffalos.get(i).getId())) {
                                anchorPane.getChildren().removeAll(buffalos.get(i));
                                buffalos.remove(i);
                                domanimals.remove(j);
                                anchorPane.getChildren().add(task(domanimals, tasksShow));
                            }
                        }
                    }
                }

                //---------------------------------------------------------------- animal move(food need)
                for (int j = 0; j < domanimals.size(); j++) {
                    if (domanimals.get(j).animalHealth <= 150) {


                        for (int i = 0; i < chickens.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(chickens.get(i).getId())) {
                                domanimals.get(j).animalmove(domanimals.get(j).foodneed(grass)[0][0], domanimals.get(j).foodneed(grass)[1][0] , domanimals.get(j).foodneed(grass)[2][0]);
                                chickens.get(i).setX(domanimals.get(j).xposision);
                                chickens.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < turkeys.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(turkeys.get(i).getId())) {
                                domanimals.get(j).animalmove(domanimals.get(j).foodneed(grass)[0][0], domanimals.get(j).foodneed(grass)[1][0] , domanimals.get(j).foodneed(grass)[2][0]);
                                turkeys.get(i).setX(domanimals.get(j).xposision);
                                turkeys.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < buffalos.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(buffalos.get(i).getId())) {
                                domanimals.get(j).animalmove(domanimals.get(j).foodneed(grass)[0][0], domanimals.get(j).foodneed(grass)[1][0] , domanimals.get(j).foodneed(grass)[2][0]);
                                buffalos.get(i).setX(domanimals.get(j).xposision);
                                buffalos.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                    } else if (domanimals.get(j).animalHealth > 150) {
                        for (int i = 0; i < chickens.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(chickens.get(i).getId())) {
                                domanimals.get(j).animalmove();
                                chickens.get(i).setX(domanimals.get(j).xposision);
                                chickens.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < turkeys.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(turkeys.get(i).getId())) {
                                domanimals.get(j).animalmove();
                                turkeys.get(i).setX(domanimals.get(j).xposision);
                                turkeys.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                        for (int i = 0; i < buffalos.size(); i++) {
                            if (domanimals.get(j).ID == Integer.parseInt(buffalos.get(i).getId())) {
                                domanimals.get(j).animalmove();
                                buffalos.get(i).setX(domanimals.get(j).xposision);
                                buffalos.get(i).setY(domanimals.get(j).yposision);
                            }
                        }
                    }
                }


                //------------------------------------------------------ eating grass
                for (int j = 0; j < domanimals.size(); j++) {

                    if (domanimals.get(j).animalHealth < 20) {
                        int[] xy = grassCheck(domanimals.get(j));
                        if (grass[xy[0]][xy[1]] != 0) {
                            domanimals.get(j).animalHealth = 300;
                            grass[xy[0]][xy[1]] -= 1;
                            anchorPane.getChildren().removeAll(grassview[xy[0]][xy[1]]);
                        }
                    } else if (domanimals.get(j).animalHealth < 40) {
                        int[] xy = grassCheck(domanimals.get(j));
                        if (grass[xy[0]][xy[1]] != 0) {
                            domanimals.get(j).animalHealth = 300;
                            grass[xy[0]][xy[1]] -= 1;
                            anchorPane.getChildren().removeAll(grassview[xy[0]][xy[1]]);
                        }
                    } else if (domanimals.get(j).animalHealth < 80) {
                        int[] xy = grassCheck(domanimals.get(j));
                        if (grass[xy[0]][xy[1]] != 0) {
                            domanimals.get(j).animalHealth = 300;
                            grass[xy[0]][xy[1]] -= 1;
                            anchorPane.getChildren().removeAll(grassview[xy[0]][xy[1]]);
                        }
                    } else if (domanimals.get(j).animalHealth < 110) {
                        int[] xy = grassCheck(domanimals.get(j));
                        if (grass[xy[0]][xy[1]] != 0) {
                            domanimals.get(j).animalHealth = 300;
                            grass[xy[0]][xy[1]] -= 1;
                            anchorPane.getChildren().removeAll(grassview[xy[0]][xy[1]]);
                        }
                    } else if (domanimals.get(j).animalHealth < 150) {
                        int[] xy = grassCheck(domanimals.get(j));
                        if (grass[xy[0]][xy[1]] != 0) {
                            domanimals.get(j).animalHealth = 300;
                            grass[xy[0]][xy[1]] -= 1;
                            anchorPane.getChildren().removeAll(grassview[xy[0]][xy[1]]);
                        }
                    }

                }

                //---------------------------------------------------------------- dog wild killer
                for (int j = 0; j < dogs.size(); j++) {
                    for (int k = 0; k < wildAnimals.size(); k++) {
                        if (dogs.get(j).xposision <= wildAnimals.get(k).xposision + 40 && dogs.get(j).xposision >= wildAnimals.get(k).xposision - 40 && dogs.get(j).yposision <= wildAnimals.get(k).yposision + 40 && dogs.get(j).yposision >= wildAnimals.get(k).yposision - 40) {
                            for (int i = 0; i < dogsi.size(); i++) {
                                if (dogs.get(j).ID == Integer.parseInt(dogsi.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(dogsi.get(i));
                                    dogsi.remove(i);
                                    dogs.remove(j);
                                }
                            }
                            for (int i = 0; i < lions.size(); i++) {
                                if (wildAnimals.get(k).ID == Integer.parseInt(lions.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(lions.get(i));
                                    lions.remove(i);
                                    wildAnimals.remove(k);
                                }
                            }
                            for (int i = 0; i < bears.size(); i++) {
                                if (wildAnimals.get(k).ID == Integer.parseInt(bears.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(bears.get(i));
                                    bears.remove(i);
                                    wildAnimals.remove(k);
                                }
                            }
                            for (int i = 0; i < tigers.size(); i++) {
                                if (wildAnimals.get(k).ID == Integer.parseInt(tigers.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(tigers.get(i));
                                    tigers.remove(i);
                                    wildAnimals.remove(k);
                                }
                            }
                        }
                    }
                }


                //---------------------------------------------------------------- wild dom killer
                for (int j = 0; j < domanimals.size(); j++) {
                    for (int k = 0; k < wildAnimals.size(); k++) {
                        if (domanimals.get(j).xposision <= wildAnimals.get(k).xposision + 40 && domanimals.get(j).xposision >= wildAnimals.get(k).xposision - 40 && domanimals.get(j).yposision <= wildAnimals.get(k).yposision + 40 && domanimals.get(j).yposision >= wildAnimals.get(k).yposision - 40) {
                            for (int i = 0; i < chickens.size(); i++) {
                                if (domanimals.get(j).ID == Integer.parseInt(chickens.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(chickens.get(i));
                                    chickens.remove(i);
                                    domanimals.remove(j);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                            for (int i = 0; i < turkeys.size(); i++) {
                                if (domanimals.get(j).ID == Integer.parseInt(turkeys.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(turkeys.get(i));
                                    turkeys.remove(i);
                                    domanimals.remove(j);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                            for (int i = 0; i < buffalos.size(); i++) {
                                if (domanimals.get(j).ID == Integer.parseInt(buffalos.get(i).getId())) {
                                    anchorPane.getChildren().removeAll(buffalos.get(i));
                                    buffalos.remove(i);
                                    domanimals.remove(j);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                        }
                    }
                }


                //----------------------------------------------------------------- kind cat
                for (int j = 0; j < cats.size(); j++) {
                    for (int i = 0; i < products.size(); i++) {
                        if (cats.get(j).xposision <= products.get(i).xposission + 15 && cats.get(j).xposision >= products.get(i).xposission - 15 && cats.get(j).yposision <= products.get(i).yposission + 15 && cats.get(j).yposision >= products.get(i).yposission - 15) {
                            for (int k = 0; k < eggs.size(); k++) {
                                if (products.get(i).ID == Integer.parseInt(eggs.get(k).getId())) {
                                    anchorPane.getChildren().removeAll(eggs.get(k));
                                    eggs.remove(k);
                                    products.remove(i);
                                    Storage.add("egg", 1);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                            for (int k = 0; k < feathers.size(); k++) {
                                if (products.get(i).ID == Integer.parseInt(feathers.get(k).getId())) {
                                    anchorPane.getChildren().removeAll(feathers.get(k));
                                    feathers.remove(k);
                                    products.remove(i);
                                    Storage.add("feather", 1);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                            for (int k = 0; k < milks.size(); k++) {
                                if (products.get(i).ID == Integer.parseInt(milks.get(k).getId())) {
                                    anchorPane.getChildren().removeAll(milks.get(k));
                                    milks.remove(k);
                                    products.remove(i);
                                    Storage.add("milk", 1);
                                    anchorPane.getChildren().add(task(domanimals, tasksShow));
                                    break;
                                }
                            }
                        }
                    }
                }


                //-------------------------------------------------------------------- egg incubator check
                if(prodChickenTime <= (int)turn && prodChickenTime != 0){
                    prodChickenTime = 0;

                    DomesticAnimal domesticAnimal = new DomesticAnimal();
                    domesticAnimal.animalName = "chicken";
                    domesticAnimal.animalPrice = 100;
                    domesticAnimal.product = "egg";
                    domesticAnimal.timeToProduce = 18;
                    domesticAnimal.turnTime = (int)turn + domesticAnimal.timeToProduce;
                    domesticAnimal.ID = domAnimalID;
                    domanimals.add(domesticAnimal);
                    ImageView imageView = new ImageView(chicken);
                    imageView.setX(domesticAnimal.xposision);
                    imageView.setY(domesticAnimal.yposision);
                    imageView.setId(String.valueOf(domAnimalID));
                    domAnimalID++;
                    chickens.add(imageView);
                    Storage.coin -= 100;
                    logger("INFO" , "CHICKEN BOUGHT SUCCESSFULLY");
                    anchorPane.getChildren().add(imageView);

                    currentCoin.setText(String.valueOf(Storage.coin));

                    anchorPane.getChildren().add(task(domanimals,tasksShow));

                }

                //-------------------------------------------------------------------- final check
                int chicken = 0, turkey = 0, buffalo = 0;
                for (int j = 0; j < domanimals.size(); j++) {
                    if (domanimals.get(j).animalName.equals("chicken")) {
                        chicken++;
                    } else if (domanimals.get(j).animalName.equals("turkey")) {
                        turkey++;
                    } else if (domanimals.get(j).animalName.equals("buffalo")) {
                        buffalo++;
                    }
                }
                boolean[] b = new boolean[13];
                for (int j = 0; j < b.length; j++) {
                    b[j] = false;
                }
                String[] task1 = tasks.split("\\s");
                for (int j = 0; j < task1.length; j++) {
                    if (task1[j].equals("egg")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalegg)
                            b[0] = true;
                    } else if (task1[j].equals("feather")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalfeather)
                            b[1] = true;
                    } else if (task1[j].equals("milk")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalmilk)
                            b[2] = true;
                    } else if (task1[j].equals("flour")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalflour)
                            b[3] = true;
                    } else if (task1[j].equals("fabric")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalfabric)
                            b[4] = true;
                    } else if (task1[j].equals("packmilk")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalpackmilk)
                            b[5] = true;
                    } else if (task1[j].equals("bread")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalbread)
                            b[6] = true;
                    } else if (task1[j].equals("cloths")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalcloths)
                            b[7] = true;
                    } else if (task1[j].equals("icecream")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.totalicecream)
                            b[8] = true;
                    } else if (task1[j].equals("coin")) {
                        if (Integer.parseInt(task1[j - 1]) <= Storage.coin)
                            b[9] = true;
                    } else if (task1[j].equals("chicken")) {
                        if (Integer.parseInt(task1[j - 1]) <= chicken)
                            b[10] = true;
                    } else if (task1[j].equals("turkey")) {
                        if (Integer.parseInt(task1[j - 1]) <= turkey)
                            b[11] = true;
                    } else if (task1[j].equals("buffalo")) {
                        if (Integer.parseInt(task1[j - 1]) <= buffalo)
                            b[12] = true;
                    }
                }

                int temp = 0;
                for (int j = 0; j < b.length; j++) {
                    if (b[j] == true)
                        temp++;
                }
                if (temp == task1.length / 2) {
                    level++;
                    logger("INFO", "FINISHED THE LEVEL");

                    try {
                        File users = new File("users.txt");
                        File users1 = new File("users1.txt");
                        Scanner user = new Scanner(users);
                        PrintWriter printWriter = new PrintWriter(users1);
                        Scanner user1 = new Scanner((users1));
                        while (user.hasNextLine()) {
                            String line = user.nextLine();
                            if (turn <= timeprize) {
                                if (line.startsWith(username)) {
                                    printWriter.append(username + " " + password + " " + level + " " + prize);
                                    printWriter.println();
                                } else {
                                    printWriter.append(line);
                                    printWriter.println();
                                }

                            } else {
                                prize = 0;
                                if (line.startsWith(username)) {
                                    printWriter.append(username + " " + password + " " + level + " 0");
                                    printWriter.println();
                                } else {
                                    printWriter.append(line);
                                    printWriter.println();
                                }

                            }
                        }
                        printWriter.close();
                        user.close();
                        PrintWriter printWriter1 = new PrintWriter(users);
                        while (user1.hasNextLine()) {
                            printWriter1.append(user1.nextLine());
                            printWriter1.println();
                        }
                        printWriter1.close();
                        user1.close();

                        pause();
                        Result.display((int) turn, timeprize, prize, level);

                    } catch (Exception e) {
                        System.out.println(e);
                        logger("ERROR", "OPEN FILE(users , users1)");
                    }

                }


                if (temp >= 0) {
                    try {
                        anchorPane.getChildren().add(time);
                    } catch (Exception e) {

                    }
                    temp++;
                }

            }

        }
    }



















    //backgroundview.setPreserveRatio(false);

    public void run() {



        time.setX(915);time.setY(680);
        time.setFont(new Font(22));

        backgroundview.setFitHeight(700);
        backgroundview.setFitWidth(1080);
        backgroundview.setX(0);
        backgroundview.setY(0);
        anchorPane.getChildren().add(backgroundview);

        for (int i = 0; i < 13; i++) {
            tasksShow[i] = new Text();
        }


        //-------------------------------------------------------- egg incubator handling
        eggIncubatorview.setX(600);
        eggIncubatorview.setY(550);
        anchorPane.getChildren().add(eggIncubatorview);

        Button prodChicken = new Button("work");
        prodChicken.setLayoutX(640);prodChicken.setLayoutY(570);
        prodChicken.setStyle("-fx-background-color : #00ffc4");
        anchorPane.getChildren().add(prodChicken);

        prodChicken.setOnAction(e -> {
            if(prodChickenTime == 0) {
                if (Storage.egg > 0) {
                    Storage.remove("egg", 1);
                    prodChickenTime = (int) turn + 10;
                }
            }
        });


        //------------------------------------------------------------truck handling
        truckview.setX(200);
        truckview.setY(550);
        anchorPane.getChildren().add(truckview);

        Button truck = new Button("Truck Go");
        truck.setLayoutX(230);truck.setLayoutY(570);
        truck.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(truck);

        truck.setOnAction(e -> {if (car.useSpace == 0) {
            logger("ERROR", "TRUCK GO ERROR");
        } //else {
            if (truckTime == 0) {
                truckTime = (int)(turn) + car.time;
                logger("INFO", "TRUCK WENT SUCCESSFULLY");
            }
            else {
                logger("ERROR", "TRUCK GO ERROR");
            }
        });
        //-----------------------------------------------------------------coins show

        currentCoin.setX(740);currentCoin.setY(65);
        currentCoin.setFont(new Font(25));
        anchorPane.getChildren().add(currentCoin);

        //-----------------------------------------------------------------tasks show
        //anchorPane.getChildren().add(task(domanimals,tasksShow));


        //------------------------------------------------------------- workshop images
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



       //----------------------------------------------------------------------------- Handling Button
        Button menu = new Button("Menu");
        menu.setLayoutX(20);
        menu.setLayoutY(650);
        menu.setMinHeight(40);
        menu.setMinWidth(90);
        menu.setStyle("-fx-background-color : #00b2ff");
        menu.setOnAction(e -> {
            try {
                gamePause = true;
                Pause.display();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Button storageShow = new Button("STORAGE");
        storageShow.setLayoutX(450);
        storageShow.setLayoutY(600);
        storageShow.setStyle("-fx-background-color : #00b2ff");
        anchorPane.getChildren().add(storageShow);
        storageShow.setOnAction(e -> {
            try {
                gamePause = true;
                StorageShow.display();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
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
        bakerybuy.setLayoutX(155);bakerybuy.setLayoutY(165);
        bakerybuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(bakerybuy);
        Button bakeryupgrade = new Button("UPGRADE 200$");
        bakeryupgrade.setLayoutX(130);bakeryupgrade.setLayoutY(195);
        bakeryupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(bakeryupgrade);
        Button bakerywork = new Button("WORK");
        bakerywork.setLayoutX(175);bakerywork.setLayoutY(225);
        bakerywork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(bakerywork);
        Button millbuy = new Button(" BUY 150$");
        millbuy.setLayoutX(155);millbuy.setLayoutY(315);
        millbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(millbuy);
        Button millupgrade = new Button("UPGRADE 100$");
        millupgrade.setLayoutX(130);millupgrade.setLayoutY(345);
        millupgrade.setStyle("-fx-background-color : #ffffff");
        anchorPane.getChildren().add(millupgrade);
        Button millwork = new Button("WORK");
        millwork.setLayoutX(175);millwork.setLayoutY(375);
        millwork.setStyle("-fx-background-color : #ff00cd");
        anchorPane.getChildren().add(millwork);
        Button spinningbuy = new Button(" BUY 250$");
        spinningbuy.setLayoutX(155);spinningbuy.setLayoutY(465);
        spinningbuy.setStyle("-fx-background-color : #ff5e00");
        anchorPane.getChildren().add(spinningbuy);
        Button spinningupgrade = new Button("UPGRADE 200$");
        spinningupgrade.setLayoutX(130);spinningupgrade.setLayoutY(495);
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
        currentCoin.setText(String.valueOf(Storage.coin));
        if(bakery.exist) logger("INFO" , "BAKERY BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "BAKERY ALREADY EXIST");
        });
        bakeryupgrade.setOnAction( e ->{if (!bakery.upgradeed){
        bakery.upgrade();
        currentCoin.setText(String.valueOf(Storage.coin));
        if(bakery.upgradeed) logger("INFO" , "BAKERY UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "BAKERY ALREADY UPGRADED");
        });
        bakerywork.setOnAction( e -> {
            if(bakery.exist) {
                if (Storage.flour == 0) {
                    logger("ERROR", "CANT WORK BAKERY");
                } else {
                    if (bakeryTime == 0) {
                        bakeryTime = (int) turn + bakery.unitTime;
                    }
                }
            }
        });
        millbuy.setOnAction(e -> {if(!mill.exist){
            mill.build();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(mill.exist) logger("INFO" , "MILL BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "MILL ALREADY EXIST");
        });
        millupgrade.setOnAction( e ->{if (!mill.upgradeed){
            mill.upgrade();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(mill.upgradeed) logger("INFO" , "MILL UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "MILL ALREADY UPGRADED");
        });
        millwork.setOnAction( e -> {
            if(mill.exist) {
                if (Storage.egg == 0) {
                    logger("ERROR", "CANT WORK MILL");
                } else {
                    if (millTime == 0) {
                        millTime = (int) turn + mill.unitTime;
                    }
                }
            }
        });
        spinningbuy.setOnAction(e -> {if(!prodFabric.exist){
            prodFabric.build();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(prodFabric.exist)logger("INFO" , "PRODFABRIC BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "PRODFABRIC ALREADY EXIST");
        });
        spinningupgrade.setOnAction( e ->{if (!prodFabric.upgradeed){
            prodFabric.upgrade();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(prodFabric.upgradeed)logger("INFO" , "PRODFABRIC UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "PRODFABRIC ALREADY UPGRADED");
        });
        spinningwork.setOnAction( e -> {
            if(prodFabric.exist) {
                if (Storage.feather == 0) {
                    logger("ERROR", "CANT WORK PRODFABRIC");
                } else {
                    if (prodfabricTime == 0) {
                        prodfabricTime = (int) turn + prodFabric.unitTime;
                    }
                }
            }
        });
        tailoringbuy.setOnAction(e -> {if(!tailoring.exist){
            tailoring.build();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(tailoring.exist)logger("INFO" , "TAILORING BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "TAILORING ALREADY EXIST");
        });
        tailoringupgrade.setOnAction( e ->{if (!tailoring.upgradeed){
            tailoring.upgrade();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(tailoring.upgradeed)logger("INFO" , "TAILORING UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "TAILORING ALREADY UPGRADED");
        });
        tailoringwork.setOnAction( e -> {
            if(tailoring.exist) {
                if (Storage.fabric == 0) {
                    logger("ERROR", "CANT WORK TAILORING");
                } else {
                    if (tailoringTime == 0) {
                        tailoringTime = (int) turn + tailoring.unitTime;
                    }
                }
            }
        });
        icestorebuy.setOnAction(e -> {if(!iceStore.exist){
            iceStore.build();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(iceStore.exist)logger("INFO" , "ICESTORE BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "ICESTORE ALREADY EXIST");
        });
        icestoreupgrade.setOnAction( e ->{if (!iceStore.upgradeed){
            iceStore.upgrade();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(iceStore.upgradeed)logger("INFO" , "ICESTORE UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "ICESTORE ALREADY UPGRADED");
        });
        icestorework.setOnAction( e -> {
            if(iceStore.exist) {
                if (Storage.packMilk == 0) {
                    logger("ERROR", "CANT WORK ICESTORE");
                } else {
                    if (iceStoreTime == 0) {
                        iceStoreTime = (int) turn + iceStore.unitTime;
                    }
                }
            }
        });
        packmilkbuy.setOnAction(e -> {if(!packMilk.exist){
            packMilk.build();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(packMilk.exist) logger("INFO" , "PACKMILK BUILT SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "PACKMILK ALREADY EXIST");
        });
        packmilkupgrade.setOnAction( e ->{if (!packMilk.upgradeed){
            packMilk.upgrade();
            currentCoin.setText(String.valueOf(Storage.coin));
            if(packMilk.upgradeed)logger("INFO" , "PACKMILK UPGRADED SUCCESSFULLY");
            anchorPane.getChildren().add(task(domanimals,tasksShow));}
        else
            logger("ERROR" , "PACKMILK ALREADY UPGRADED");
        });
        packmilkwork.setOnAction( e -> {
            if(packMilk.exist) {
                if (Storage.milk == 0) {
                    logger("ERROR", "CANT WORK PACKMILK");
                } else {
                    if (packmilkTime == 0) {
                        packmilkTime = (int) turn + packMilk.unitTime;
                    }
                }
            }
        });










        //--------------------------------------------------------------------------------------WildAnimal picking up
        for (int i = 0; i < lions.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> lionHandler = new EventHandler<MouseEvent>() {
                @Override public void handle (MouseEvent e){
                    for (int j = 0; j < wildAnimals.size(); j++) {
                        if(wildAnimals.get(j).ID == Integer.parseInt(lions.get(finalI).getId())){
                            wildAnimals.get(j).cages++;
                            if(wildAnimals.get(j).cages >= wildAnimals.get(j).maxCage){
                                if(Storage.add("lion",1)){
                                    anchorPane.getChildren().removeAll(lions.get(finalI));
                                    lions.remove(finalI);
                                    wildAnimals.remove(j);
                                }
                            }
                        }
                    }
                }
            };
            lions.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, lionHandler);
        }
        for (int i = 0; i < bears.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> bearHandler = new EventHandler<MouseEvent>() {
                @Override public void handle (MouseEvent e){
                    for (int j = 0; j < wildAnimals.size(); j++) {
                        if(wildAnimals.get(j).ID == Integer.parseInt(bears.get(finalI).getId())){
                            wildAnimals.get(j).cages++;
                            if(wildAnimals.get(j).cages >= wildAnimals.get(j).maxCage){
                                if(Storage.add("bear",1)){
                                    anchorPane.getChildren().removeAll(bears.get(finalI));
                                    bears.remove(finalI);
                                    wildAnimals.remove(j);
                                }
                            }
                        }
                    }
                }
            };
            bears.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, bearHandler);
        }
        for (int i = 0; i < tigers.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> tigerHandler = new EventHandler<MouseEvent>() {
                @Override public void handle (MouseEvent e){
                    for (int j = 0; j < wildAnimals.size(); j++) {
                        if(wildAnimals.get(j).ID == Integer.parseInt(tigers.get(finalI).getId())){
                            wildAnimals.get(j).cages++;
                            if(wildAnimals.get(j).cages >= wildAnimals.get(j).maxCage){
                                if(Storage.add("tiger",1)){
                                    anchorPane.getChildren().removeAll(tigers.get(finalI));
                                    tigers.remove(finalI);
                                    wildAnimals.remove(j);
                                }
                            }
                        }
                    }
                }
            };
            tigers.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, tigerHandler);
        }





        //---------------------------------------------------------------------------- Product picking up
        for (int i = 0; i < eggs.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> eggHandler = new EventHandler<MouseEvent>() {
                    @Override public void handle (MouseEvent e){
                        if (Storage.add("egg", 1)) {
                            for (int j = 0; j < products.size(); j++) {
                                if(products.get(j).ID == Integer.parseInt(eggs.get(finalI).getId())){
                                    products.remove(j);
                                }
                            }
                            anchorPane.getChildren().removeAll(eggs.get(finalI));
                            eggs.remove(finalI);
                            anchorPane.getChildren().add(task(domanimals,tasksShow));
                        }
                    }
            };
            eggs.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, eggHandler);
        }
        for (int i = 0; i <feathers.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> featherHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("feather", 1)){
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(feathers.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(feathers.get(finalI));
                        feathers.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            feathers.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, featherHandler);
        }
        for (int i = 0; i <milks.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> milkHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("milk", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(milks.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(milks.get(finalI));
                        milks.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            milks.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, milkHandler);
        }
        for (int i = 0; i < flours.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> flourHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("flour", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(flours.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(flours.get(finalI));
                        flours.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            flours.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, flourHandler);
        }
        for (int i = 0; i < fabrics.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> fabricHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("fabric", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(fabrics.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(fabrics.get(finalI));
                        fabrics.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            fabrics.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, fabricHandler);
        }
        for (int i = 0; i < packmilks.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> packmilkHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("packMilk", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(packmilks.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(packmilks.get(finalI));
                        packmilks.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            packmilks.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, packmilkHandler);
        }
        for (int i = 0; i < breads.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> breadHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("bread", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(breads.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(breads.get(finalI));
                        breads.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            breads.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, breadHandler);
        }
        for (int i = 0; i < cloths.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> clothHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("cloths", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(cloths.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(cloths.get(finalI));
                        cloths.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            cloths.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, clothHandler);
        }
        for (int i = 0; i < icecreams.size(); i++) {
            int finalI = i;
            EventHandler<MouseEvent> icecreamHandler = new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    if (Storage.add("icecream", 1)) {
                        for (int j = 0; j < products.size(); j++) {
                            if(products.get(j).ID == Integer.parseInt(icecreams.get(finalI).getId())){
                                products.remove(j);
                            }
                        }
                        anchorPane.getChildren().removeAll(icecreams.get(finalI));
                        icecreams.remove(finalI);
                        anchorPane.getChildren().add(task(domanimals,tasksShow));
                    }
                }
            };
            icecreams.get(i).addEventFilter(MouseEvent.MOUSE_CLICKED, icecreamHandler);
        }




        //-------------------------------------------------------------------- Icon Image loading
        chickenIconview.setX(5);
        chickenIconview.setY(0);

        turkeyIconview.setX(95);
        turkeyIconview.setY(0);

        buffaloIconview.setX(185);
        buffaloIconview.setY(0);

        dogIconview.setX(275);
        dogIconview.setY(0);

        catIconview.setX(365);
        catIconview.setY(0);
        //--------------------------------------------------------------grass image
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
                domesticAnimal.timeToProduce = 22;
                domesticAnimal.turnTime = (int)turn + domesticAnimal.timeToProduce;
                domesticAnimal.ID = domAnimalID;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(turkey);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                imageView.setId(String.valueOf(domAnimalID));
                domAnimalID++;
                turkeys.add(imageView);
                Storage.coin -= 200;
                logger("INFO" , "TURKEY BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

                currentCoin.setText(String.valueOf(Storage.coin));

                anchorPane.getChildren().add(task(domanimals,tasksShow));
            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY TURKEY");
            }  );
        chickenBuy.setOnAction( e ->{
            if(100 <= Storage.coin) {
                DomesticAnimal domesticAnimal = new DomesticAnimal();
                domesticAnimal.animalName = "chicken";
                domesticAnimal.animalPrice = 100;
                domesticAnimal.product = "egg";
                domesticAnimal.timeToProduce = 18;
                domesticAnimal.turnTime = (int)turn + domesticAnimal.timeToProduce;
                domesticAnimal.ID = domAnimalID;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(chicken);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                imageView.setId(String.valueOf(domAnimalID));
                domAnimalID++;
                chickens.add(imageView);
                Storage.coin -= 100;
                logger("INFO" , "CHICKEN BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

                currentCoin.setText(String.valueOf(Storage.coin));

                anchorPane.getChildren().add(task(domanimals,tasksShow));
            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY CHICKEN");
        }  );
        buffaloBuy.setOnAction( e ->{
            if(400 <= Storage.coin) {
                DomesticAnimal domesticAnimal = new DomesticAnimal();
                domesticAnimal.animalName = "buffalo";
                domesticAnimal.animalPrice = 400;
                domesticAnimal.product = "milk";
                domesticAnimal.timeToProduce = 30;
                domesticAnimal.turnTime = (int)turn + domesticAnimal.timeToProduce;
                domesticAnimal.ID = domAnimalID;
                domanimals.add(domesticAnimal);
                ImageView imageView = new ImageView(buffalo);
                imageView.setX(domesticAnimal.xposision);
                imageView.setY(domesticAnimal.yposision);
                imageView.setId(String.valueOf(domAnimalID));
                domAnimalID++;
                buffalos.add(imageView);
                Storage.coin -= 400;
                logger("INFO" , "BUFFALO BOUGHT SUCCESSFULLY");
                anchorPane.getChildren().add(imageView);

                currentCoin.setText(String.valueOf(Storage.coin));

                anchorPane.getChildren().add(task(domanimals,tasksShow));
            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY BUFFALO");
        }  );
        dogBuy.setOnAction( e ->{
            Dog dog1 = new Dog();
            if(dog1.price <= Storage.coin){
                dog1.ID = dogID;
                dogs.add(dog1);
                Storage.coin -= dog1.price;
                logger("INFO" , "DOG BOUGHT SUCCESSFULLY");
                ImageView imageView = new ImageView(dog);
                imageView.setX(dog1.xposision);
                imageView.setY(dog1.yposision);
                imageView.setId(String.valueOf(dogID));
                dogsi.add(imageView);
                dogID++;
                anchorPane.getChildren().add(imageView);

                currentCoin.setText(String.valueOf(Storage.coin));

                anchorPane.getChildren().add(task(domanimals,tasksShow));
            }else
                logger("ERROR" , "DONT HAVE ENOUGH MONEY TO BUY DOG");
        }  );
        catBuy.setOnAction( e ->{
            Cat cat1 = new Cat();
                if(cat1.price <= Storage.coin){
                    cat1.ID = catID;
                    cats.add(cat1);
                    Storage.coin -= cat1.price;
                    logger("INFO" , "CAT BOUGHT SUCCESSFULLY");
                    ImageView imageView = new ImageView(cat);
                    imageView.setX(cat1.xposision);
                    imageView.setY(cat1.yposision);
                    imageView.setId(String.valueOf(catID));
                    catsi.add(imageView);
                    catID++;
                    anchorPane.getChildren().add(imageView);

                    currentCoin.setText(String.valueOf(Storage.coin));

                    anchorPane.getChildren().add(task(domanimals,tasksShow));
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
        try {
            main.changeScene(backgroundscene);
        } catch (IOException e) {
            e.printStackTrace();
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







    public Group task( ArrayList<DomesticAnimal> domesticAnimals , Text[] tasksShow){
        Group task = new Group();

        String tasks = null;
        int chicken =0,turkey=0,buffalo=0;
        for (int i = 0; i < domesticAnimals.size(); i++) {
            if(domesticAnimals.get(i).animalName.equals("chicken")){
                chicken ++;
            }else if(domesticAnimals.get(i).animalName.equals("turkey")){
                turkey ++;
            } else if(domesticAnimals.get(i).animalName.equals("buffalo")){
                buffalo ++;
            }
        }




        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if (temp.contains("level "+ this.level)){
                    tasks=s.nextLine().substring(6);
                    tasks=s.nextLine().substring(6);
                }

            }
            s.close();
        }catch (Exception e){
            System.out.println(e);
        }


        String[] task1 = tasks.split("\\s");
        for (int i = 0; i < task1.length; i++) {

            if(task1[i].equals("egg")){
                tasksShow[0].setText("Egg:"+Storage.totalegg+"/"+task1[i-1]);
                tasksShow[0].setX(860);tasksShow[0].setY(615);
                task.getChildren().add(tasksShow[0]);
            }
            else if(task1[i].equals("feather")){
                tasksShow[1].setText("Feather:"+Storage.totalfeather+"/"+task1[i-1]);
                tasksShow[1].setX(940);tasksShow[1].setY(615);
                task.getChildren().add(tasksShow[1]);
            }
            else if(task1[i].equals("milk")){
                tasksShow[2].setText("Milk:"+Storage.totalmilk+"/"+task1[i-1]);
                tasksShow[2].setX(1020);tasksShow[2].setY(615);
                task.getChildren().add(tasksShow[2]);
            }
            else if(task1[i].equals("flour")){
                tasksShow[3].setText("Flour:"+Storage.totalflour+"/"+task1[i-1]);
                tasksShow[3].setX(1100);tasksShow[3].setY(615);
                task.getChildren().add(tasksShow[3]);
            }
            else if(task1[i].equals("fabric")){
                tasksShow[4].setText("Fabric:"+Storage.totalfabric+"/"+task1[i-1]);
                tasksShow[4].setX(860);tasksShow[4].setY(635);
                task.getChildren().add(tasksShow[4]);
            }
            else if(task1[i].equals("packmilk")){
                tasksShow[5].setText("PackMilk:"+Storage.totalpackmilk+"/"+task1[i-1]);
                tasksShow[5].setX(940);tasksShow[5].setY(635);
                task.getChildren().add(tasksShow[5]);
            }
            else if(task1[i].equals("bread")){
                tasksShow[6].setText("Bread:"+Storage.totalbread+"/"+task1[i-1]);
                tasksShow[6].setX(1020);tasksShow[6].setY(635);
                task.getChildren().add(tasksShow[6]);
            }
            else if(task1[i].equals("cloths")){
                tasksShow[7].setText("Cloths:"+Storage.totalcloths+"/"+task1[i-1]);
                tasksShow[7].setX(1100);tasksShow[7].setY(635);
                task.getChildren().add(tasksShow[7]);
            }
            else if(task1[i].equals("icecream")){
                tasksShow[8].setText("Icecream:"+Storage.totalicecream+"/"+task1[i-1]);
                tasksShow[8].setX(860);tasksShow[8].setY(655);
                task.getChildren().add(tasksShow[8]);
            }
            else if(task1[i].equals("coin")){
                tasksShow[9].setText("Coin:"+Storage.coin+"/"+task1[i-1]);
                tasksShow[9].setX(940);tasksShow[9].setY(655);
                task.getChildren().add(tasksShow[9]);
            }
            else if(task1[i].equals("chicken")){
                tasksShow[10].setText("Chicken:"+chicken+"/"+task1[i-1]);
                tasksShow[10].setX(1020);tasksShow[10].setY(655);
                task.getChildren().add(tasksShow[10]);
            }
            else if(task1[i].contains("turkey")){
                tasksShow[11].setText("Turkey:"+turkey+"/"+task1[i-1]);
                tasksShow[11].setX(1100);tasksShow[11].setY(655);
                task.getChildren().add(tasksShow[11]);
            }
            else if(task1[i].equals("buffalo")){
                tasksShow[12].setText("Buffalo:"+buffalo+"/"+task1[i-1]);
                tasksShow[12].setX(860);tasksShow[12].setY(615);
                task.getChildren().add(tasksShow[12]);
            }
        }

        return task;
    }


    public int[] grassCheck(DomesticAnimal domesticAnimal){
        int[] xy = new int[2];

            int x = domesticAnimal.xposision+60;
            int y = domesticAnimal.yposision+60;

            xy[0] = (y-220)/55;
            xy[1] = (x-250)/91;

            /*
            if(x > 250 && x < 341 && y > 220 && y <275)
                xy[0]=0;xy[1]=0;
            if(x > 250 && x < 341 && y > 275 && y < 330)
                xy[0]=1;xy[1]=0;
            if(x > 250 && x < 341 && y > 330 && y <385)
                xy[0]=2;xy[1]=0;
            if(x > 250 && x < 341 && y > 385 && y <440)
                xy[0]=3;xy[1]=0;
            if(x > 250 && x < 341 && y > 440 && y <495)
                xy[0]=4;xy[1]=0;
            if(x > 250 && x < 341 && y > 495 && y <550)
                xy[0]=5;xy[1]=0;
            if(x > 341 && x < 432 && y > 220 && y <275)
                xy[0]=0;xy[1]=1;
            if(x > 341 && x < 432 && y > 275 && y < 330)
                xy[0]=1;xy[1]=1;
            if(x > 341 && x < 432 && y > 330 && y <385)
                xy[0]=2;xy[1]=1;
            if(x > 341 && x < 432 && y > 385 && y <440)
                xy[0]=3;xy[1]=1;
            if(x > 341 && x < 432 && y > 440 && y <495)
                xy[0]=4;xy[1]=1;
            if(x > 341 && x < 432 && y > 495 && y <550)
                xy[0]=5;xy[1]=1;
            if(x > 432 && x < 523 && y > 220 && y <275)
                xy[0]=0;xy[1]=2;
            if(x > 432 && x < 523 && y > 275 && y <330)
                xy[0]=1;xy[1]=2;
            if(x > 432 && x < 523 && y > 330 && y <385)
                xy[0]=2;xy[1]=2;
            if(x > 432 && x < 523 && y > 385 && y <440)
                xy[0]=3;xy[1]=2;
            if(x > 432 && x < 523 && y > 440 && y <495)
                xy[0]=4;xy[1]=2;
            if(x > 432 && x < 523 && y > 495 && y <550)
                xy[0]=5;xy[1]=2;
            if(x > 523 && x < 614 && y > 220 && y <275)
                xy[0]=0;xy[1]=3;
            if(x > 523 && x < 614 && y > 275 && y <330)
                xy[0]=1;xy[1]=3;
            if(x > 523 && x < 614 && y > 330 && y <385)
                xy[0]=2;xy[1]=3;
            if(x > 523 && x < 614 && y > 385 && y <440)
                xy[0]=3;xy[1]=3;
            if(x > 523 && x < 614 && y > 440 && y <495)
                xy[0]=4;xy[1]=3;
            if(x > 523 && x < 614 && y > 495 && y <550)
                xy[0]=5;xy[1]=3;
            if(x > 614 && x < 705 && y > 220 && y <275)
                xy[0]=0;xy[1]=4;
            if(x > 614 && x < 705 && y > 275 && y <330)
                xy[0]=1;xy[1]=4;
            if(x > 614 && x < 705 && y > 330 && y <385)
                xy[0]=2;xy[1]=4;
            if(x > 614 && x < 705 && y > 385 && y <440)
                xy[0]=3;xy[1]=4;
            if(x > 614 && x < 705 && y > 440 && y <495)
                xy[0]=4;xy[1]=4;
            if(x > 614 && x < 705 && y > 495 && y <550)
                xy[0]=5;xy[1]=4;
            if(x > 705 && x < 796 && y > 220 && y <275)
                xy[0]=0;xy[1]=5;
            if(x > 705 && x < 796 && y > 275 && y <330)
                xy[0]=1;xy[1]=5;
            if(x > 705 && x < 796 && y > 330 && y <385)
                xy[0]=2;xy[1]=5;
            if(x > 705 && x < 796 && y > 385 && y <440)
                xy[0]=3;xy[1]=5;
            if(x > 705 && x < 796 && y > 440 && y <495)
                xy[0]=4;xy[1]=5;
            if(x > 705 && x < 796 && y > 495 && y <550)
                xy[0]=5;xy[1]=5;

             */


        return xy;
    }



}