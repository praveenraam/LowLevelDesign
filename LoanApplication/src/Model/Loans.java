package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Loans {

    static HashSet<Loans> loansHashSet = new HashSet<>();

    private Long id;
    private User user;
    private Banker ApprovedBanker;
    private float AcceptedLoanAmount;
    private float totalPaid;
    private float pending_amount;
    private float interest;
    private int totalMonths;
    boolean isCompletelyPaid;
    private LoanApplication loanApplication;

    public ArrayList<EMI> emiArrayList = new ArrayList<>();

    public Loans( User user, Banker approvedBanker, float acceptedLoanAmount,float interest,LoanApplication application,int totalMonths) {
        this.user = user;
        ApprovedBanker = approvedBanker;
        AcceptedLoanAmount = acceptedLoanAmount;
        this.totalPaid = 0;
        this.pending_amount = acceptedLoanAmount;
        this.interest = interest;
        this.isCompletelyPaid = false;
        this.totalMonths = totalMonths;
        this.loanApplication = application;

        loansHashSet.add(this);
        this.id = (long) loansHashSet.size();
    }

    public int getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(int totalMonths) {
        this.totalMonths = totalMonths;
    }

    public boolean isCompletelyPaid() {
        return isCompletelyPaid;
    }

    public void setCompletelyPaid(boolean completelyPaid) {
        isCompletelyPaid = completelyPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Banker getApprovedBanker() {
        return ApprovedBanker;
    }

    public void setApprovedBanker(Banker approvedBanker) {
        ApprovedBanker = approvedBanker;
    }

    public float getAcceptedLoanAmount() {
        return AcceptedLoanAmount;
    }

    public void setAcceptedLoanAmount(float acceptedLoanAmount) {
        AcceptedLoanAmount = acceptedLoanAmount;
    }

    public float getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(float totalPaid) {
        this.totalPaid = totalPaid;
    }

    public float getPending_amount() {
        return pending_amount;
    }

    public void setPending_amount(float pending_amount) {
        this.pending_amount = pending_amount;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
}
