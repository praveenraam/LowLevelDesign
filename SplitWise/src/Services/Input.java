package Services;

import java.util.Scanner;

public class Input {

    Scanner in = new Scanner(System.in);
    String inputValue;

    public String getInput(){
        inputValue = in.nextLine();
        return inputValue;
    }
}
