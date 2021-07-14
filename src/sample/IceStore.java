package sample;

public class IceStore {
    private final int COST = 550;
    private final int UPCOST = 400;
    public int unit = 0;
    int unitTime = 7;
    public  boolean exist = false;
    boolean x2 = false; // for upgrade
    public boolean upgradeed =false;

    public IceStore(){
    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){

        if(Storage.packMilk >= 1){
            Storage.packMilk -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("icecream",n);
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