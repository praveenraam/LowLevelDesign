package Services;

import Model.MoneyMapped;
import Model.User;

import java.util.HashMap;
import java.util.HashSet;

import static Model.User.getUserTracker;

public class ProcessInput {

    Input inputGetter = new Input();

    String GivenInput;

    String[] InputArr;

    public void ProcessInputArr(){
        String GivenInput = inputGetter.getInput();

        InputArr = GivenInput.split(" ");
        HashMap<Integer,User> UserTracker = getUserTracker();


        if(InputArr[0].equals("SHOW")){
            if(InputArr.length == 1){
                User.ShowAllExpense();
                return;
            }
            else{
                int userId = Integer.parseInt(InputArr[1].substring(1));
                User userToPrint = UserTracker.get(userId);
                userToPrint.SpecificUserExpense();
                return;
            }
        }

        float amount = 0;
        int noOfUsers = 0;
        HashMap<Integer,Float> UserBorrowed = new HashMap<>();
        String typeOfSharing = "";

        int iter=4;
        if(InputArr[0].equals("EXPENSE") && InputArr[1].startsWith("u")){

            amount = Float.parseFloat(InputArr[2]);
            noOfUsers = Integer.parseInt(InputArr[3]);

            for(;iter<(4+noOfUsers);iter++){
                int ID = Integer.parseInt(InputArr[iter].substring(1));
                UserBorrowed.put(ID,0f);
            }
            typeOfSharing = InputArr[iter];
        }

        if(typeOfSharing.equals("EQUAL")){

            float perHead = amount/(noOfUsers);
            for(int userID : UserBorrowed.keySet()){
                UserBorrowed.put(userID,perHead);
            }

        }else if(typeOfSharing.equals("EXACT")){

            float[] arr = new float[noOfUsers];
            int currIter = iter;

            int idx = 0;
            for(iter=iter+1;iter<=(currIter+noOfUsers);iter++){
                arr[idx++] = Float.parseFloat(InputArr[iter]);
            }

            idx = 0;
            for(int userID : UserBorrowed.keySet()){
                UserBorrowed.put(userID,arr[idx++]);
            }


        }else if(typeOfSharing.equals("PERCENT")){

            float perPercentage = amount/100;

            float[] arr = new float[noOfUsers];

            int currIter = iter;
            int idx = 0;
            for(iter=iter+1;iter<=(currIter+noOfUsers);iter++){
                arr[idx++] = Float.parseFloat(InputArr[iter]);
            }

            idx = 0;
            for(int userID : UserBorrowed.keySet()){
                float amountToBeAdded = arr[idx]*(perPercentage);
                UserBorrowed.put(userID,amountToBeAdded);
            }

        }

        MoneyMapped[] arr = new MoneyMapped[UserBorrowed.size()]; int idx = 0;
        for(int userID : UserBorrowed.keySet()){
            User userBorrowedCurr = UserTracker.get(userID);
            MoneyMapped newObj = new MoneyMapped(userBorrowedCurr,UserBorrowed.get(userID));
            arr[idx++] = newObj;
        }

        int LentUserId = Integer.parseInt(InputArr[1].substring(1));
        UserTracker.get(LentUserId).addExpend(arr);

    }

}
