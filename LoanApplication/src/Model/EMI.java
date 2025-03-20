package Model;

public class EMI {

    private Long id;
    private User user;
    private Loans loan;
    private float pendingAmount;
    private float total_amount;
    private int pending_months;
    private float interest;
    private float payPerMonth;

    public EMI(User user, Loans loan, float pendingAmount, float total_amount, int pending_months, float interest) {
        this.user = user;
        this.loan = loan;
        this.pendingAmount = pendingAmount;
        this.total_amount = total_amount;
        this.pending_months = pending_months;
        this.interest = interest;

        this.payPerMonth = calcCurrMonthValue();
    }
    public float calcCurrMonthValue(){

        float interest_Amount  = pendingAmount*(interest/100);
        float payment_amount = (total_amount/(float)pending_months);

        return interest_Amount+payment_amount;
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

    public Loans getLoan() {
        return loan;
    }

    public void setLoan(Loans loan) {
        this.loan = loan;
    }

    public float getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(float pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public int getPending_months() {
        return pending_months;
    }

    public void setPending_months(int pending_months) {
        this.pending_months = pending_months;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getPayPerMonth() {
        return payPerMonth;
    }

    public void setPayPerMonth(float payPerMonth) {
        this.payPerMonth = payPerMonth;
    }
}
