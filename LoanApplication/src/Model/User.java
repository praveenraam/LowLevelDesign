package Model;

import java.util.HashSet;

public class User {

    static public HashSet<User> allUsers = new HashSet<>();

    private Long id;
    private String name;
    private String password;
    private int noOfLoans;
    private float totalPendingPrinciple;
    private String address;
    private String phoneNo;
    private int currCreditScore;
    private float totalPaid;
    private float income_per_year;

    HashSet<Loans> loansPaying = new HashSet<>();
    HashSet<LoanApplication> loanApplications = new HashSet<>();

    public User(String name, String password, String address, String phoneNo,float income_per_year) {
        this.name = name;
        this.password = password;
        this.income_per_year = income_per_year;
        this.noOfLoans = 0;
        this.totalPendingPrinciple = 0;
        this.address = address;
        this.phoneNo = phoneNo;
        this.currCreditScore = 1000;
        this.totalPaid = 0;

        this.id = (long)allUsers.size()+1;

        allUsers.add(this);
    }

    public static HashSet<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(HashSet<User> allUsers) {
        User.allUsers = allUsers;
    }

    public float getIncome_per_year() {
        return income_per_year;
    }

    public void setIncome_per_year(float income_per_year) {
        this.income_per_year = income_per_year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNoOfLoans() {
        return noOfLoans;
    }

    public void setNoOfLoans(int noOfLoans) {
        this.noOfLoans = noOfLoans;
    }

    public float getTotalPendingPrinciple() {
        return totalPendingPrinciple;
    }

    public void setTotalPendingPrinciple(float totalPendingPrinciple) {
        this.totalPendingPrinciple = totalPendingPrinciple;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getCurrCreditScore() {
        return currCreditScore;
    }

    public void setCurrCreditScore(int currCreditScore) {
        this.currCreditScore = currCreditScore;
    }

    public float getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(float totalPaid) {
        this.totalPaid = totalPaid;
    }

    public HashSet<Loans> getLoansPaying() {
        return loansPaying;
    }

    public void setLoansPaying(HashSet<Loans> loansPaying) {
        this.loansPaying = loansPaying;
    }
}
