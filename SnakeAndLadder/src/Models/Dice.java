package Models;

import java.util.Random;
public class Dice {
    int size;
    Random random;
    public Dice(int size){
        this.size = size;
        random = new Random();
    }
    public int RolledDiceValue(){
        int value = 0;
        for(int ite=0;ite<size;ite++){
            value += (random.nextInt(6)+1);
        }
        return value;
    }
}
