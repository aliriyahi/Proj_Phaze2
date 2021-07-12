package sample;

public class ProdFabric {
    private final int COST = 250;
    private final int UPCOST = 200;
    public int unit = 0;
    int unitTime = 5;
    public  boolean exist = false;
    boolean x2 = false; // for upgrade

    public ProdFabric(){

    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.feather >= 2){
            Storage.feather -= 2;

            unit += 2;
        }
        else if(Storage.feather >= 1){
            Storage.feather -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("fabric",n);
            if(b)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public void upgrade(int mode){
        if(Storage.coin >= UPCOST){
            Storage.coin -= UPCOST;
            if(mode == 1)
                unitTime /= 2;
            if(mode == 2)
                x2 = true;
        }
    }
}