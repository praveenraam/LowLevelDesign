package Models;

import java.util.Random;
public class Dice {
    public static int RolledDiceValue(){
        Random random = new Random();
        return random.nextInt(7);
    }
}
