package Services;

import Model.EMI;
import Model.Loans;
import Model.User;

public class PayEmiOrPartPayment {

    public static boolean payAmountService(Loans loan,int currMonth){
        if(loan == null) return false;
//        if(currMonth > loan.getTotalMonths()) return false;

        EMI emi = new EMI(loan.getUser(),loan, loan.getPending_amount(), loan.getAcceptedLoanAmount(),loan.getTotalMonths()-currMonth,loan.getInterest());

        User user = loan.getUser();
        loan.setTotalPaid(loan.getTotalPaid()-emi.getPayPerMonth());
        user.setTotalPaid(user.getTotalPaid()+emi.getPayPerMonth());
        loan.emiArrayList.add(emi);

        return true;
    }

    public static boolean payPartPaymentService(Loans loan,float amountGoingToPay){
        if(loan == null) return false;

        loan.setPending_amount(loan.getPending_amount()-amountGoingToPay);
        loan.setTotalPaid(loan.getTotalPaid()+amountGoingToPay);

        User user = loan.getUser();
        user.setTotalPaid(user.getTotalPaid()+amountGoingToPay);

        return true;
    }


}
