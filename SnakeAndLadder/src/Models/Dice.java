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
        return random.nextInt(size)+1;
    }
}
