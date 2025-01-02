package Services;

public class InputProcessor {
    Input inReceive = new Input();

    public void InputProcessing(){

        String inputString = inReceive.getInput();
        String[] inputArr = inputString.split(" ");

        // Listing Option of Show
        if(inputArr[0].equals("SHOW")){
            if(inputArr.length == 1){

            }else if(inputArr[1].equals("BOARD")){

            }
            else if(inputArr[1].equals("LIST")){

            }
            else if(inputArr[1].equals("CARD")){

            }
        }
        // Listing Options in BOARD
        else if(inputArr[0].equals("BOARD")){
            if(inputArr[1].equals("CREATE")){

            }
            else if(inputArr[1].equals("DELETE")){

            }
            else if(inputArr[2].equals("name")){

            }
            else if(inputArr[2].equals("privacy")) {

            }
            else if(inputArr[2].equals("ADD_MEMBER")){

            }
            else if(inputArr[2].equals("REMOVE_MEMBER")){

            }
        }
        // Listing Option in LIST
        else if(inputArr[0].equals("LIST")){
            if(inputArr[1].equals("CREATE")){

            }
            else if(inputArr[1].equals("DELETE")){

            }
        }
        // Listing Options in CARD
        else if(inputArr[0].equals("CARD")){
            if(inputArr[1].equals("CREATE")){

            }
            else if(inputArr[1].equals("DELETE")){

            }
            else if(inputArr[2].equals("name")){

            }
            else if(inputArr[2].equals("description")){

            }
            else if(inputArr[2].equals("ASSIGN")){

            }
            else if(inputArr[2].equals("UNASSIGN")){

            }
            else if(inputArr[2].equals("MOVE")){

            }

        }

    }

}
