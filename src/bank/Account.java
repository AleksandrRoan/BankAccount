package bank;

public class Account {

    private int id;
    private double accountBalance;
    private static final double DEFAULT_BALANCE = 0.0;

    public Account(int id, double accountBalance) {
        this.id = id;
        this.accountBalance = accountBalance;
    }

    public Account(int id) {
        this.id = id;
        accountBalance = DEFAULT_BALANCE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

}
