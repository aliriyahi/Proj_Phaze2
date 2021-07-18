package sample;

public class PackMilk {
    private final int COST = 400;
    private final int UPCOST = 300;
    public int unit = 0;
    int unitTime = 18;
    public  boolean exist = false;
    boolean x2 = false; // for upgrade
    public boolean upgradeed = false;

    public PackMilk(){

    }

    public void build(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){

        if(Storage.milk >= 1){
            Storage.milk -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            boolean b = Storage.add("packmilk",n);
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