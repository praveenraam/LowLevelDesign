package Models;

public class Players {
    public String name;
    private int position = 0;
    public Players(String name){
        this.name = name;
    }

    public int getPosition(){
        return position;
    }
    public void setPosition(int position){
        this.position = position;
    }

}
