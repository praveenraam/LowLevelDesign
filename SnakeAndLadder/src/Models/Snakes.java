package Models;

public class Snakes {
    int start = 0;
    public int end;
    public Snakes(int start,int end){
        if(start<end){
            System.out.println("Can't create object, start should be greater than end");
        }
        else{
            this.start = start;
            this.end = end;
        }
    }
}
