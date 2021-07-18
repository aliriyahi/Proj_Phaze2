package sample;

public class Car {
    static final int SPACE = 15;
    static int useSpace = 0;
    public final int time = 20;
    static int price = 0;

    public static boolean load(String name , int n){

        if(name.equals("egg")){
            if(n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                    useSpace += n;
                    price += 15*n;
                    return true; }
            }
        }else if(name.equals("feather")){
            if(n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += n;
                price += 20*n;
                return true;} }
        }else if(name.equals("milk")){
            if(n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += n;
                price += 25*n;
                return true; }}
        }else if(name.equals("flour")){
            if(2*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 2*n;
                price += 40*n;
                return true; }}
        }else if(name.equals("fabric")){
            if(2*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 2*n;
                price += 50*n;
                return true; }}
        }else if(name.equals("packMilk")){
            if(2*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 2*n;
                price += 60*n;
                return true;} }
        }else if(name.equals("bread")){
            if(4*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 4*n;
                price += 80*n;
                return true;} }
        }else if(name.equals("cloths")){
            if(4*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 4*n;
                price += 100*n;
                return true; }}
        }else if(name.equals("icecream")){
            if(4*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 4*n;
                price += 120*n;
                return true; }}
        }else if(name.equals("lion")){
            if(15*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 15*n;
                price += 300*n;
                return true;} }
        }else if(name.equals("bear")){
            if(15*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 15*n;
                price += 400*n;
                return true;} }
        }else if(name.equals("tiger")){
            if(15*n + useSpace <= SPACE){
                if(Storage.remove(name , n)){
                useSpace += 15*n;
                price += 500*n;
                return true; }}
        }

        return false;
    }

    public static boolean unload(String name , int n){
        if(name.equals("egg")){
            if(useSpace - n >= 0){
                if(Storage.add(name , n)){
                useSpace -= n;
                price -= 15*n;
                return true; }}
        }else if(name.equals("feather")){
            if(useSpace - n >= 0){
                if(Storage.add(name , n)){
                useSpace -= n;
                price -= 20*n;
                return true; }}
        }else if(name.equals("milk")){
            if(useSpace - n >= 0){
                if(Storage.add(name , n)){
                useSpace -= n;
                price -= 25*n;
                return true; }}
        }else if(name.equals("flour")){
            if(useSpace - 2*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 2*n;
                price -= 40*n;
                return true; }}
        }else if(name.equals("fabric")){
            if(useSpace - 2*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 2*n;
                price -= 50*n;
                return true;} }
        }else if(name.equals("packMilk")){
            if(useSpace - 2*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 2*n;
                price -= 60*n;
                return true; }}
        }else if(name.equals("bread")){
            if(useSpace - 4*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 4*n;
                price -= 80*n;
                return true; }}
        }else if(name.equals("cloths")){
            if(useSpace - 4*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 4*n;
                price -= 100*n;
                return true; }}
        }else if(name.equals("icecream")){
            if(useSpace - 4*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 4*n;
                price -= 120*n;
                return true;} }
        }else if(name.equals("lion")){
            if(useSpace - 15*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 15*n;
                price -= 300*n;
                return true; }}
        }else if(name.equals("bear")){
            if(useSpace - 15*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 15*n;
                price -= 400*n;
                return true; }}
        }else if(name.equals("tiger")){
            if(useSpace - 15*n >= 0){
                if(Storage.add(name , n)){
                useSpace -= 15*n;
                price -= 500*n;
                return true; }}
        }
        return false;
    }

    public static void sell(){
        Storage.coin += price;

        price = 0;
        useSpace = 0;

    }

}