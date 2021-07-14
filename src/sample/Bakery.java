package sample;

public class Bakery {
    private final int COST = 250;
    private final int UPCOST = 200;
    public int unit = 0;
    int unitTime = 5;
    public  boolean exist = false;

    public boolean upgradeed = false;

    public Bakery(){

    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){

         if(Storage.flour >= 1){
            Storage.flour -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("bread",n);
            if(b)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public void upgrade(){
        if(Storage.coin >= UPCOST){
            upgradeed=true;
            Storage.coin -= UPCOST;
            unitTime /= 2;

        }
    }
}