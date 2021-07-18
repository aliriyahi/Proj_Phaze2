package sample;

public class Tailoring {    // khayati
    private final int COST = 400;
    private final int UPCOST = 300;
    public int unit = 0;
    int unitTime = 25;
    public  boolean exist = false;
    boolean x2 = false; // for upgrade
    public boolean upgradeed = false;

    public Tailoring(){

    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){

        if(Storage.fabric >= 1){
            Storage.fabric -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("cloth",n);
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