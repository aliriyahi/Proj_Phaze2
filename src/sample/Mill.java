package sample;

public class Mill {   // asiab
    private final int COST = 150;
    private final int UPCOST = 100;
    public int unit = 0;
    int unitTime = 4;
    public  boolean exist = false;

    public boolean upgradeed = false;

    public Mill(){

    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){

        if(Storage.egg >= 1){
            Storage.egg -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("flour",n);
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