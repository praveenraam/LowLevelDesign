package Service;
import Models.Dice;
import Models.Players;

public class PlayIn {
    Inputs in = new Inputs();
    Dice dice = new Dice(1);

    public void startPlay(){

        in.inputs(); // Calling the input function to gather the required inputs

        while(true){
            // Getting the player from Queue
            Players CurrPlayer = in.playersQueue.remove();

            int CurrPosition = CurrPlayer != null ? CurrPlayer.getPosition() : 0;

            int DiceValue = dice.RolledDiceValue();

            int NextValue = CurrPosition+DiceValue;

            if(hasWon(NextValue)){ // Winner
                System.out.println(CurrPlayer.name + " wins the game by rolling "+DiceValue);
                break;
            }
            else if(NextValue > 100){ // If Player exceeds winner Value, setting to same
                NextValue = CurrPosition;
            }
            else{

                if(in.snakesMap.containsKey(NextValue)){ // Checking for Snake
                    NextValue = in.snakesMap.get(NextValue).end;
                }
                else if(in.laddersMap.containsKey(NextValue)){ // Checking for Ladder
                    NextValue = in.laddersMap.get(NextValue).end;
                }
            }

            CurrPlayer.setPosition(NextValue); // Setting Position.
            System.out.println(CurrPlayer.name+" rolled a "+DiceValue+" and moved from "+CurrPosition+" to "+NextValue);

            in.playersQueue.add(CurrPlayer); // adding the player back to the Queue.
        }
    }

    boolean hasWon(int nextValue){
        return nextValue == 100;
    }

}
