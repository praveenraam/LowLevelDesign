package Models;

public class Snakes extends PairPosition{
    public Snakes(int start, int end) {
        super(start, end);
        if(start<=end) System.out.println("Snake's start must be greater");
    }
}
