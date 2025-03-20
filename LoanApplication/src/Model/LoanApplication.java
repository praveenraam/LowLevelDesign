package Model;

import java.util.HashSet;

public class LoanApplication {
    static public HashSet<LoanApplication> loanApplicationHashSet = new HashSet<>();

    private User user;
    private Long id;
    private float interest_percentage;
    private int payTimeInMonths;
    private float principleAmount;
    private int curr_credit;
    private boolean isApproved;
    private float income_per_year;


    public LoanApplication(User user,float principleAmount,float interest_percentage,int payTimeInMonths){

        this.user = user;
        this.principleAmount = principleAmount;
        this.interest_percentage = interest_percentage;
        this.payTimeInMonths = payTimeInMonths;

        this.curr_credit = user.getCurrCreditScore();
        this.income_per_year = user.getIncome_per_year();
        this.isApproved = false;

        user.loanApplications.add(this);

        this.id = (long)loanApplicationHashSet.size();

    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "username=" + user.getName() +
                ", id=" + id +
                ", interest_percentage=" + interest_percentage +
                ", payTimeInMonths=" + payTimeInMonths +
                ", principleAmount=" + principleAmount +
                ", curr_credit=" + curr_credit +
                ", isApproved=" + isApproved +
                ", income_per_year=" + income_per_year +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getInterest_percentage() {
        return interest_percentage;
    }

    public void setInterest_percentage(float interest_percentage) {
        this.interest_percentage = interest_percentage;
    }

    public int getPayTimeInMonths() {
        return payTimeInMonths;
    }

    public void setPayTimeInMonths(int payTimeInMonths) {
        this.payTimeInMonths = payTimeInMonths;
    }

    public float getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(float principleAmount) {
        this.principleAmount = principleAmount;
    }

    public int getCurr_credit() {
        return curr_credit;
    }

    public void setCurr_credit(int curr_credit) {
        this.curr_credit = curr_credit;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean credited) {
        isApproved = credited;
    }

    public float getIncome_per_year() {
        return income_per_year;
    }

    public void setIncome_per_year(float income_per_year) {
        this.income_per_year = income_per_year;
    }


}
