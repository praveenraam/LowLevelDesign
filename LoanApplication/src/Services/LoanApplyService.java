package Services;

import Model.Banker;
import Model.LoanApplication;
import Model.Loans;
import Model.User;

public class LoanApplyService {

    public static LoanApplication applyLoanService(User user, float principleAmount, float interest_percentage, int payTimeInMonths){
        LoanApplication loanApplication = new LoanApplication(user,principleAmount,interest_percentage,payTimeInMonths);
        return loanApplication;
    }

    public static boolean doRejectOrApprove(LoanApplication loanApplication){

        Banker banker = Banker.getInstance();
        boolean status = banker.canApprove(loanApplication);

        if(status) loanAccepted(loanApplication,banker);
        else loanReject(loanApplication);
        return status;
    }

    public static boolean loanAccepted(LoanApplication loanApplication, Banker banker){
        if(loanApplication == null) return false;

        loanApplication.setApproved(true);
        User user = loanApplication.getUser();

        Loans loan = new Loans(user,banker,loanApplication.getPrincipleAmount(),loanApplication.getInterest_percentage(),loanApplication,loanApplication.getPayTimeInMonths());
        user.getLoansPaying().add(loan);

        user.setTotalPendingPrinciple(user.getTotalPendingPrinciple()+loan.getAcceptedLoanAmount());
        return true;
    }

    public static boolean loanReject(LoanApplication loanApplication){
        if(loanApplication == null) return false;
        loanApplication.setApproved(false);
        return true;
    }

    public static void showDetailsAboutLoanApplication(LoanApplication loanApplication){
        System.out.println(loanApplication.toString());
    }

}
