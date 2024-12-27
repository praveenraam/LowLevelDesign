package Service;

import Models.PairPosition;
import Models.Players;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inputs {

    Scanner in = new Scanner(System.in);
    public HashMap<Integer, PairPosition> snakesMap = new HashMap<>();
    public HashMap<Integer, PairPosition> laddersMap = new HashMap<>();
    public Queue<Players> playersQueue = new LinkedList<>();

    protected void inputs(){
//        System.out.println("Enter No of Snakes : ");
        SnakesInput();
//        System.out.println("Enter No of Ladders :");
        LaddersInput();
//        System.out.println("Enter the No of Players : ");
        PlayersInput();
    }
    public void SnakesInput(){
        int NoOfSnakes = in.nextInt();
        for(int ite=0;ite<NoOfSnakes;ite++){
//            System.out.println("Enter the start and end : ");
            int start = in.nextInt();
            int end = in.nextInt();
            if(start<=end) {
                System.out.println("Snake's start must be greater");
                ite--;
            }
            else {
                PairPosition snake = new PairPosition(start,end);
                snakesMap.put(start,snake);
            }
        }
    }
    public void LaddersInput(){
        int NoOfLadders = in.nextInt();
        for(int ite=0;ite<NoOfLadders;ite++){
//            System.out.println("Enter the start and end : ");

            int start = in.nextInt();
            int end = in.nextInt();
            if(start>=end) {
                System.out.println("Ladder's start must be greater");
                ite--;
            }
            else{
                PairPosition ladder = new PairPosition(start,end);
                laddersMap.put(start,ladder);
            }
        }
    }
    public void PlayersInput(){
        int NoOfPlayers = in.nextInt();
        in.nextLine();

        for(int ite=0;ite<NoOfPlayers;ite++){
//            System.out.println("Enter Name : ");

            String Name = in.nextLine();

            Players player = new Players(Name);
            playersQueue.add(player);
        }
    }
}
