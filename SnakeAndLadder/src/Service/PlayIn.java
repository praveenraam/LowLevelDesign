package Service;
import Models.Dice;
import Models.Players;

public class PlayIn {
    Inputs in = new Inputs();
    Dice dice;

    public void startPlay(){

        in.inputs(); // Calling the input function to gather the required inputs
        dice = new Dice(in.diceSize);

        while(true){
            // Getting the player from Queue
            Players CurrPlayer = in.GetPlayerFromQueue();
            int DiceValue = dice.RolledDiceValue();

            int NewPosition = NextPosition(CurrPlayer,DiceValue);

            if(hasWon(NewPosition))
                if(isGameOver(in.NoOfPlayersLeft()))
                    return;
                else continue;


            if (DiceValue == in.diceSize) { // Getting max on Size, getting chance again to roll dice.
                in.AddPlayerToFrontOfQueue(CurrPlayer);
            } else {
                in.AddPlayerToQueue(CurrPlayer); // adding the player back to the Queue.
            }
        }
    }

    int NextPosition(Players CurrPlayer,int DiceValue){
        int CurrPosition = CurrPlayer != null ? CurrPlayer.getPosition() : 0;
        int NextValue = CurrPosition+DiceValue;

        if(hasWon(NextValue)){ // Winner
            System.out.println(CurrPlayer.name + " wins the game by rolling "+DiceValue);
            if(in.playersQueue.size() == 1) return NextValue; // Completing the loop because only 1 player didn't reached.
        }
        else if(NextValue > 100){ // If Player exceeds winner Value, setting to same
            NextValue = CurrPosition;
        }
        else{
            if(in.SnakeContains(NextValue)){ // Checking for Snake
                NextValue = in.SnakeEnd(NextValue);
            }
            else if(in.LadderContains(NextValue)){ // Checking for Ladder
                NextValue = in.LadderEnd(NextValue);
            }
        }

        CurrPlayer.setPosition(NextValue); // Setting Position.
        System.out.println(CurrPlayer.name+" rolled a "+DiceValue+" and moved from "+CurrPosition+" to "+NextValue);
        return NextValue;
    }

    boolean hasWon(int nextValue){
        return nextValue == 100;
    }
    boolean isGameOver(int currNoOfPlayers){
        return currNoOfPlayers == 1;
    }
}
