package bank;

public class DebitAccount extends Account {

    public DebitAccount(int id, double accountBalance, double serviceFee) {
        super(id, accountBalance, serviceFee);
    }

    public DebitAccount(int id, double accountBalance, double serviceFee, Currency currency) {
        super(id, accountBalance, serviceFee, currency);
    }

    public DebitAccount(int id, double accountBalance) {
        super(id, accountBalance);
    }

    public DebitAccount(int id) {
        super(id);
    }
}
