package Model;

public class Banker {
    private Long id;
    private String name;
    private String phoneNo;
    private String pasword;

    static Banker banker = new Banker();

    private Banker(){};

    public static Banker getInstance(String name,String phoneNo,String password){
        banker.name = name;
        banker.phoneNo = phoneNo;
        banker.pasword = password;

        return banker;
    }

    public static Banker getInstance() {
        return banker;
    }

    public boolean canApprove(LoanApplication loanApplication){
        User user = loanApplication.getUser();

        float totalAmount = loanApplication.getPrincipleAmount();
        float tenthPercentage = (totalAmount)/100*10;

        if(tenthPercentage <= user.getIncome_per_year() ){
            return true;
        }
        return false;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}
