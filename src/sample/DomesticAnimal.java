package sample;

import java.util.Random;

public class DomesticAnimal {
    Random rand = new Random();

    public String animalName;
    public int animalPrice;
    public int animalHealth=300;
    public int timeToProduce;
    public int turnTime;
    public String product;
    public int speed=5;
    public int xposision = Math.abs(rand.nextInt()%500)+200;
    public int yposision = Math.abs(rand.nextInt()%300)+140;

    int ID = 0;



    public void animalmove(){
        int random= Math.abs(rand.nextInt()%2);
        if (random==0)
            random=1;
        else if (random==1)
            random=-1;
        int move=random*this.speed;
        int random1 = Math.abs(rand.nextInt()%2);

        if (random1==0){
            if (this.xposision+move<=700 && this.xposision+move>=200){
                this.xposision+=move;
            }else {
                move *= -1;
                this.xposision += move;
            }

        }

        else if (random1==1){
            if (this.yposision+move<=440 && this.yposision+move>=140){
                this.yposision+=move;
            }else {
                move *= -1;
                this.yposision += move;
            }

        }
    }
    public void animalmove(int x , int y , int type){
        if(type == 1) {
            if (xposision < (x * 91 + 240) + 10 && xposision > (x * 91 + 240) - 10) {
                if (yposision > (y * 55 + 180))
                    yposision -= speed;
                else if (yposision < (y * 55 + 180))
                    yposision += speed;
            } else if (xposision > (x * 91 + 240))
                xposision -= speed;
            else if (xposision < (x * 91 + 240))
                xposision += speed;
        }else {
            animalmove();
        }

    }
    public int[][] foodneed(int[][] grassposision){
        double temp=52000;
        int[][] returnvalue=new int[3][1];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (grassposision[i][j]>0){
                    returnvalue[2][0] = 1;
                    if (Math.sqrt(((j*91+250)-this.xposision)*((j*91+250)-this.xposision)+((i*55+220)-this.yposision)*((i*55+220)-this.yposision))<temp){
                        temp=Math.sqrt(((j*91+250)-this.xposision)*((j*91+250)-this.xposision)+((i*55+220)-this.yposision)*((i*55+220)-this.yposision));
                        returnvalue[0][0]=j;
                        returnvalue[1][0]=i;
                    }
                }
            }
        }
        return returnvalue;
    }

}