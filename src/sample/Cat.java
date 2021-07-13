package sample;

import java.util.ArrayList;
import java.util.Random;

public class Cat {
    Random rand = new Random();

    public String name = "cat";
    public int price = 150;
    public int xposision = Math.abs(rand.nextInt()%500)+200;
    public int yposision = Math.abs(rand.nextInt()%300)+140;
    public int speed = 10;

    public void animalmove(ArrayList<Product> products) {
        double temp =10000;
        int x = 0;
        int y = 0;
        boolean movetype=false;
        for (int i = 0; i < products.size(); i++) {
            if (Math.sqrt((products.get(i).xposission-this.xposision)*(products.get(i).xposission-this.xposision)+(products.get(i).yposission-this.yposision)*(products.get(i).yposission-this.yposision))<temp){
                temp=Math.sqrt((products.get(i).xposission-this.xposision)*(products.get(i).xposission-this.xposision)+(products.get(i).yposission-this.yposision)*(products.get(i).yposission-this.yposision));
                x=products.get(i).xposission;
                y=products.get(i).yposission;
                movetype=true;
            }
        }
        if (movetype){
            if (xposision > x)
                xposision -= speed;
            else if (xposision < x)
                xposision += speed;
            else if (xposision == x) {
                if (yposision > y)
                    yposision -= speed;
                else if (yposision < y)
                    yposision += speed;
            }

        }else {
            int random = Math.abs(rand.nextInt() % 2);
            if (random == 0)
                random = 1;
            else if (random == 1)
                random = -1;
            int move = random * this.speed;
            int random1 = Math.abs(rand.nextInt() % 2);

            if (random1 == 0) {
                if (this.xposision + move <= 600 && this.xposision + move >= 200) {
                    this.xposision += move;
                } else {
                    move *= -1;
                    this.xposision += move;
                }
            } else if (random1 == 1) {
                if (this.yposision + move <= 340 && this.yposision + move >= 140) {
                    this.yposision += move;
                } else {
                    move *= -1;
                    this.yposision += move;
                }
            }
        }
    }
}
