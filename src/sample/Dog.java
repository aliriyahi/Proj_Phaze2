package sample;

import java.util.Random;

public class Dog {
    Random rand = new Random();

    public String name = "dog";
    public int price=100;
    public int xposision = Math.abs(rand.nextInt()%500)+200;
    public int yposision= Math.abs(rand.nextInt()%300)+140;
    public int speed=10;
    public void animalmove(){
        int random= Math.abs(rand.nextInt()%2);
        if (random==0)
            random=1;
        else if (random==1)
            random=-1;
        int move=random*this.speed;
        int random1= Math.abs(rand.nextInt()%2);

        if (random1==0){
            if (this.xposision+move<=600 && this.xposision+move>=200){
                this.xposision+=move;
            }else {
                move *= -1;
                this.xposision += move;
            }

        }

        else if (random1==1){
            if (this.yposision+move<=340 && this.yposision+move>=140){
                this.yposision+=move;
            }else {
                move *= -1;
                this.yposision += move;
            }

        }
    }
}
