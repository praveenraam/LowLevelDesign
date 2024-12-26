package Models;

public class Ladders extends PairPosition{
    public Ladders(int start, int end){
        super(start,end);
        if(start>=end) System.out.println("Ladder's start must be greater");
    }
}
