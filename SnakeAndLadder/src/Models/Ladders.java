package Models;

public class Ladders {
    int start;
    public int end;
    public Ladders(int start, int end){
        if(start>end){
            System.out.println("Can't create object, end should be greater than start");
        }
        this.start = start;
        this.end = end;
    }
}
